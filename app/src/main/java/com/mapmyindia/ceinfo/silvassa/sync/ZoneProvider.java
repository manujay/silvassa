package com.mapmyindia.ceinfo.silvassa.sync;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.ApiCodes;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneContentValues;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneCursor;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneSelection;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.PostExecutionThread;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;
import com.mapmyindia.ceinfo.silvassa.utils.UIThread;
import com.mapmyindia.ceinfo.silvassa.wsmodel.ZoneWSModel;
import com.orhanobut.logger.Logger;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by ceinfo on 14-04-2017.
 */

public class ZoneProvider {

    private static final String TAG = ZoneProvider.class.getSimpleName();
    private static ZoneProvider mInstance;
    private Context mContext;
    private PostExecutionThread mPostExecutionThread;

    private ZoneProvider(Context context) {
        this.mContext = context;
        this.mPostExecutionThread = UIThread.getInstance();
    }

    public static ZoneProvider getInstance(Context context) {
        if (null == mInstance)
            mInstance = new ZoneProvider(context);
        return mInstance;
    }

    public void GetZone(GetZoneListener listener) {

        if (!Connectivity.isConnected(mContext)) {

            sendErrorResponse(listener, mContext.getResources().getString(R.string.error_network));

        } else {

            getZone(listener);
        }

    }

    private void getZone(final GetZoneListener listener) {
        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);

        Call<ResponseBody> call = apiClient.getZone();

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()) {

                    Logger.d(TAG, " @GetZoneListener:getZone : SUCCESS : " + response.body());

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        int status = Integer.parseInt(jsonObject.getString("status"));
                        String message = jsonObject.getString("message");

                        if (status != ApiCodes.STATUS_200) {
                            if (!StringUtils.isNullOrEmpty(message))
                                sendErrorResponse(listener, message);
                            else
                                sendErrorResponse(listener, mContext.getString(R.string.error_server));
                            return;
                        }

                        final ArrayList<ZoneWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<ZoneWSModel>>() {
                        }.getType());

                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    saveInDataBase(data);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                sendSuccessResponse(listener, "Zone Data Sync Sucessfull");
                            }
                        }).start();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Logger.d(TAG, " @getZone : SUCCESS : " + response.body());

                } else {
                    Logger.e(TAG, " @getZone : FAILURE : " + call.request());
                    sendErrorResponse(listener, response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Logger.e(TAG, " @getZone : FAILURE : " + call.request());

                try {
                    if (t instanceof IOException) {
                        throw new IOException(t);
                    } else if (t instanceof HttpException) {
                        throw new Exception(t.getMessage());
                    }
                } catch (Exception e) {
                    sendErrorResponse(listener, mContext.getResources().getString(R.string.error_network_connectivity));
                    e.printStackTrace();
                }
            }
        });
    }

    private void saveInDataBase(List<ZoneWSModel> data) throws SQLException {

        try {
            for (ZoneWSModel zoneWSModel : data) {
                insertZone(zoneWSModel.getZoneName(), zoneWSModel.getZoneId());
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    private void insertZone(String zoneName, String zoneId) throws SQLException {
        ZoneContentValues contentValues = new ZoneContentValues();
        contentValues.putZoneid(zoneId);
        contentValues.putZonename(zoneName);

        ZoneSelection selection = new ZoneSelection();
        selection.zoneid(zoneId);

        ZoneCursor cursor = selection.query(mContext.getContentResolver());

        if (cursor.moveToFirst()) {
            contentValues.update(mContext.getContentResolver(), selection);
        } else {
            contentValues.insert(mContext.getContentResolver());
        }
    }

    private void sendErrorResponse(final GetZoneListener listener, final String msg) {

        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (null != listener) {
                    Logger.wtf(TAG, " @ZoneProvider:sendErrorResponse : " + msg);
                    listener.onError(msg);
                }
            }
        });
    }

    private void sendSuccessResponse(final GetZoneListener listener, final String msg) {
        mPostExecutionThread.post(new Runnable() {
            @Override
            public void run() {
                if (null != listener) {
                    Logger.wtf(TAG, " @ZoneProvider:sendSuccessResponse : " + msg);
                    listener.onSuccess(msg);
                }
            }
        });
    }

    public interface GetZoneListener {

        void onSuccess(String msg);

        void onError(String msg);
    }
}
