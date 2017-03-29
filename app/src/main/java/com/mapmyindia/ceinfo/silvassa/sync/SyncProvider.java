package com.mapmyindia.ceinfo.silvassa.sync;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertyCursor;
import com.mapmyindia.ceinfo.silvassa.provider.property.PropertySelection;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailCursor;
import com.mapmyindia.ceinfo.silvassa.provider.taxdetail.TaxdetailSelection;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.PostExecutionThread;
import com.mapmyindia.ceinfo.silvassa.utils.UIThread;
import com.mapmyindia.ceinfo.silvassa.wsmodel.PropertyWSModel;
import com.mapmyindia.ceinfo.silvassa.wsmodel.TAXDetailBean;
import com.orhanobut.logger.Logger;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by ceinfo on 22-03-2017.
 */

public class SyncProvider {

    private static final String TAG = SyncProvider.class.getSimpleName();
    private static SyncProvider mInstance;
    private Context mContext;
    private PostExecutionThread mPostExecutionThread;

    private SyncProvider(Context context) {
        this.mContext = context;
        this.mPostExecutionThread = UIThread.getInstance();
    }

    public static SyncProvider getInstance(Context context) {
        if (null == mInstance)
            mInstance = new SyncProvider(context);
        return mInstance;
    }

    public void performSync(SyncProviderListener listener, String pojo) {
        if (!Connectivity.isConnected(mContext)) {
            sendErrorResponse(listener, mContext.getString(R.string.error_network));
        } else {
            doSync(listener, pojo);
        }
    }

    private void doSync(final SyncProviderListener listener, String pojo) {

        RestApiClient apiclient = RestAppController.getRetrofitinstance().create(RestApiClient.class);

        Call<ResponseBody> call = apiclient.searchProperty(pojo);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    try {

                        JSONObject jsonObject = new JSONObject(response.body().string());

                        if (!jsonObject.getString("message").equalsIgnoreCase("Success")) {
                            sendErrorResponse(listener, mContext.getString(R.string.error_server));
                            return;
                        }

                        if (Integer.parseInt(jsonObject.getString("status")) != 200) {
                            sendErrorResponse(listener, mContext.getString(R.string.error_server));
                            return;
                        }

                        if (null == jsonObject.get("data")) {
                            sendErrorResponse(listener, mContext.getString(R.string.error_server));
                            return;
                        }

                        Gson gson = new GsonBuilder().serializeNulls().create();

                        final ArrayList<PropertyWSModel> data = gson.fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<PropertyWSModel>>() {
                        }.getType());

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                saveInDatabase(data);
                            }
                        }).start();

                        sendSuccessResponse(listener, jsonObject.getString("message"));

                        Logger.d(TAG, " @SyncProvider:doSync : " + data);

                    } catch (Exception e) {

                        sendErrorResponse(listener, e.getMessage());
                        e.printStackTrace();
                    }

                    Logger.d(TAG, " @SyncProvider:doSync : SUCCESS : " + response.body());

                } else {
                    sendErrorResponse(listener, response.message());
                    Logger.e(TAG, " @SyncProvider:doSync : FAILURE : " + call.request());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.e(TAG, " @getSearchCriteria : FAILURE : " + call.request());

                try {
                    if (t instanceof IOException) {
                        throw new IOException(t);
                    } else if (t instanceof HttpException) {
                        throw new Exception(t.getMessage());
                    }
                } catch (Exception e) {
                    sendErrorResponse(listener, t.getMessage());
                    e.printStackTrace();
                }
            }
        });

    }


    private void saveInDatabase(List<PropertyWSModel> modelList) {

        for (PropertyWSModel wsModel : modelList) {

            try {
                PropertyContentValues values = new PropertyContentValues();
                values.putPropertyuniqueid(wsModel.getPropertyUniqueId());
                values.putPropertyowner(wsModel.getPropertyOwner());
                values.putPropertyoccupiername(wsModel.getPropertyOccupierName());
                values.putPropertyrelationowner(wsModel.getPropertyRelationOwner());
                values.putZoneid(wsModel.getZoneId());
                values.putPropertysublocality(wsModel.getPropertySublocality());
                values.putEmail(wsModel.getEmail());
                values.putPhone(wsModel.getPhone());
                values.putPropertylandmark(wsModel.getPropertyLandmark());
                values.putPropertyplotno(wsModel.getPropertyPlotNo());
                values.putPropertyhouseno(wsModel.getPropertyHouseNo());
                values.putPropertyroad(wsModel.getPropertyRoad());
                values.putPropertypincode(wsModel.getPropertyPincode());
                values.putPropertybuildingname(wsModel.getPropertyBuildingName());

                if (null != wsModel.getTAXDetailBean()) {
                    TAXDetailBean taxDetailBean = wsModel.getTAXDetailBean();
                    TaxdetailContentValues tdContentValues = new TaxdetailContentValues();
                    tdContentValues.putTaxno(taxDetailBean.getTaxNo());
                    tdContentValues.putPropertyid(taxDetailBean.getPropertyId());
                    tdContentValues.putFinancialyear(taxDetailBean.getFinancialYear());
                    tdContentValues.putPropertytax(taxDetailBean.getPropertyTax());
                    tdContentValues.putWatertax(taxDetailBean.getWaterTax());
                    tdContentValues.putConservancytax(taxDetailBean.getConservancyTax());
                    tdContentValues.putWaterseweragecharge(taxDetailBean.getWaterSewerageCharge());
                    tdContentValues.putWatermeterbillamount(taxDetailBean.getWaterMeterBillAmount());
                    tdContentValues.putArrearamount(taxDetailBean.getArrearAmount());
                    tdContentValues.putAdvancepaidamount(taxDetailBean.getAdvancePaidAmount());
                    tdContentValues.putRebateamount(taxDetailBean.getRebateAmount());
                    tdContentValues.putAdjustmentamount(taxDetailBean.getAdjustmentAmount());
                    tdContentValues.putTotalpropertytax(taxDetailBean.getTotalPropertyTax());
                    tdContentValues.putServicetax(taxDetailBean.getServiceTax());
                    tdContentValues.putOthertax(taxDetailBean.getOtherTax());
                    tdContentValues.putGrandtotal(taxDetailBean.getGrandTotal());
                    tdContentValues.putDelaypaymentcharges(taxDetailBean.getDelayPaymentCharges());
                    tdContentValues.putPayableamount(taxDetailBean.getPayableAmount());
                    tdContentValues.putDuedate(Long.toString(taxDetailBean.getDueDate()));
                    tdContentValues.putNoticegenerated(taxDetailBean.getNoticeGenerated());
                    tdContentValues.putObjectionstatus(taxDetailBean.getObjectionStatus());

                    TaxdetailSelection taxdetailSelection = new TaxdetailSelection();
                    taxdetailSelection.propertyid(taxDetailBean.getPropertyId());

                    TaxdetailCursor cursor = taxdetailSelection.query(mContext.getContentResolver());

                    if (cursor.moveToFirst()) {
                        tdContentValues.update(mContext.getContentResolver(), taxdetailSelection);
                    } else {
                        tdContentValues.insert(mContext.getContentResolver());
                    }

                    cursor.close();
                }

                PropertySelection propertySelection = new PropertySelection();
                propertySelection.propertyuniqueid(wsModel.getPropertyUniqueId());

                PropertyCursor cursor = propertySelection.query(mContext.getContentResolver());

                if (cursor.moveToFirst()) {
                    values.update(mContext.getContentResolver(), propertySelection);
                } else {
                    values.insert(mContext.getContentResolver());
                }

                cursor.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sendErrorResponse(final SyncProviderListener listener, final String msg) {
        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (null != listener) {
                    Logger.wtf(TAG, " @SyncProvider:sendErrorResponse : " + msg);
                    listener.onSyncError(msg);
                }
            }
        });
    }

    private void sendSuccessResponse(final SyncProviderListener listener, final String msg) {
        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (null != listener) {
                    Logger.wtf(TAG, " @SyncProvider:sendSuccessResponse : " + msg);
                    listener.onSyncResponse(msg);
                }
            }
        });
    }


    public interface SyncProviderListener {
        void onSyncResponse(String msg);

        void onSyncError(String msg);
    }
}
