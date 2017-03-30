package com.mapmyindia.ceinfo.silvassa.publish;

import android.content.Context;

import com.google.gson.Gson;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentColumns;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentCursor;
import com.mapmyindia.ceinfo.silvassa.provider.payment.PaymentSelection;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.orhanobut.logger.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ceinfo on 30-03-2017.
 */

public class PublishProvider {

    private static PublishProvider instance = null;
    private static RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);
    private Context mContext;
    private OnPublishCallBack onPublishCallBack;

    private PublishProvider(Context context, OnPublishCallBack callBack) {
        this.mContext = context;
        this.onPublishCallBack = callBack;
    }

    public static PublishProvider getPublishProvider(Context context, OnPublishCallBack callBack) {
        if (null == instance) {
            instance = new PublishProvider(context, callBack);
        }
        return instance;
    }

    public void publishOnServer() {

        try {
            String[] projection = {
                    PaymentColumns.PROPERTYUNIQUEID,
                    PaymentColumns.TAXNO,
                    PaymentColumns.AMOUNT,
                    PaymentColumns.MODE,
                    PaymentColumns.EMAIL,
                    PaymentColumns.PHONE,
                    PaymentColumns.PDATE
            };

            PaymentSelection selection = new PaymentSelection();

            PaymentCursor cursor = selection.query(mContext.getContentResolver(), projection);

            if (cursor.moveToFirst()) {

                while (!cursor.isAfterLast()) {

                    PaymentBean paymentBean = new PaymentBean();
                    paymentBean.setDeviceId(SharedPrefeHelper.getDeviceId(mContext));
                    paymentBean.setUserId(SharedPrefeHelper.getUserId(mContext));
                    paymentBean.setPropertyId(cursor.getPropertyuniqueid());
                    paymentBean.setPaymentAmount(cursor.getAmount());
                    paymentBean.setPayDate(cursor.getPdate());
                    paymentBean.setPaymentMode(cursor.getMode());
                    paymentBean.setTaxNo(cursor.getTaxno());

                    String payment = new Gson().toJson(paymentBean, PaymentBean.class);

                    doPost(payment);

                    cursor.moveToNext();
                }
            }

            cursor.close();

        } catch (Exception e) {

            onPublishCallBack.onPublishCompleted(false);
            e.printStackTrace();
        }

        onPublishCallBack.onPublishCompleted(true);
    }

    private void doPost(String payment) {

        Call<ResponseBody> call = apiClient.mobPayment(payment);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    Logger.json(response.body().toString());

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Logger.e(t.getLocalizedMessage(), t);

            }
        });
    }

    public interface OnPublishCallBack {
        void onPublishCompleted(boolean flag);
    }

    private class PaymentBean {
        //{deviceId:"1234567899874561",userId:"sandeep",propertyId:"S05000180000",taxNo:"12345",paymentMode:"cash",paymentAmount:"121",payDate:"1402500000"}

        String deviceId, userId, propertyId, taxNo, paymentMode, paymentAmount, payDate;

        public String getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(String deviceId) {
            this.deviceId = deviceId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPropertyId() {
            return propertyId;
        }

        public void setPropertyId(String propertyId) {
            this.propertyId = propertyId;
        }

        public String getTaxNo() {
            return taxNo;
        }

        public void setTaxNo(String taxNo) {
            this.taxNo = taxNo;
        }

        public String getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(String paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public String getPaymentMode() {
            return paymentMode;
        }

        public void setPaymentMode(String paymentMode) {
            this.paymentMode = paymentMode;
        }

        public String getPayDate() {
            return payDate;
        }

        public void setPayDate(String payDate) {
            this.payDate = payDate;
        }
    }
}
