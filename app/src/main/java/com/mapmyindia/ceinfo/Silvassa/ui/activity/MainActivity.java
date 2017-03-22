package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.provider.zone.ZoneContentValues;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestApiClient;
import com.mapmyindia.ceinfo.silvassa.restcontroller.RestAppController;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.wsmodel.ZoneWSModel;

import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProgressBar progressBar;

    @Override
    public void setTitle(String mTitle) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!Connectivity.isConnected(MainActivity.this)) {
            Snackbar.make(getWindow().getDecorView(), R.string.error_network, Snackbar.LENGTH_SHORT).show();
        } else {
            getZone();
        }

        startActivity(new Intent(MainActivity.this, ActivityLogin.class));
        finish();
    }

    private void getZone() {
        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);

        Call<ResponseBody> call = apiClient.getZone();

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {

                    showProgress(false);

                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());

                        if (!jsonObject.getString("message").equalsIgnoreCase("Success")) {
                            Snackbar.make(getWindow().getDecorView(), R.string.error_server, Snackbar.LENGTH_SHORT);
                            return;
                        }

                        if (Integer.parseInt(jsonObject.getString("status")) != 200) {
                            Snackbar.make(getWindow().getDecorView(), R.string.error_server, Snackbar.LENGTH_SHORT);
                            return;
                        }

                        ArrayList<ZoneWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<ZoneWSModel>>() {
                        }.getType());

                        for (ZoneWSModel zoneWSModel : data) {
                            insertZone(zoneWSModel.getZoneName(), zoneWSModel.getZoneId());
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Log.d(TAG, " @getZone : SUCCESS : " + response.body());

                } else {
                    Log.e(TAG, " @getZone : FAILURE : " + call.request());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, " @getZone : FAILURE : " + call.request());
            }
        });

        showProgress(true);
    }

    private long insertZone(String zoneName, String zoneId) {
        ZoneContentValues contentValues = new ZoneContentValues();
        contentValues.putZoneid(zoneId);
        contentValues.putZonename(zoneName);
        Uri uri = contentValues.insert(getContentResolver());
        return ContentUris.parseId(uri);
    }

    private void showProgress(boolean show) {
        if (null == progressBar) {
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
        }
        if (show && progressBar.getVisibility() != View.VISIBLE) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}
