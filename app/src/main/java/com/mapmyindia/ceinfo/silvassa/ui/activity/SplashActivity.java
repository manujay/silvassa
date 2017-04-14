package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.mapmyindia.ceinfo.silvassa.R;
import com.mapmyindia.ceinfo.silvassa.sync.ZoneProvider;
import com.mapmyindia.ceinfo.silvassa.utils.Connectivity;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;
import com.mapmyindia.ceinfo.silvassa.utils.StringUtils;

public class SplashActivity extends BaseActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private ProgressBar progressBar;

    @Override
    public void setTitle(String mTitle) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (StringUtils.isNullOrEmpty(SharedPrefeHelper.getZoneId(this))) {
            if (!Connectivity.isConnected(this)) {
                showSnackBar(getWindow().getDecorView(), getString(R.string.error_network));
            } else {

                showProgress(true);

                ZoneProvider.getInstance(this).GetZone(new ZoneProvider.GetZoneListener() {
                    @Override
                    public void onSuccess(String msg) {
                        showProgress(false);
                        showToast(SplashActivity.this, msg);
                    }

                    @Override
                    public void onError(String msg) {
                        showProgress(false);
                        showToast(SplashActivity.this, msg);
                    }
                });

                startActivityForIntent(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        } else {
            startActivityForIntent(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }
    }

//    private void getZone() {
//        RestApiClient apiClient = RestAppController.getRetrofitinstance().create(RestApiClient.class);
//
//        Call<ResponseBody> call = apiClient.getZone();
//
//        call.enqueue(new Callback<ResponseBody>() {
//
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//                showProgress(false);
//
//                if (response.isSuccessful()) {
//
//                    try {
//
//                        JSONObject jsonObject = new JSONObject(response.body().string());
//
//                        if (!jsonObject.getString("message").equalsIgnoreCase("Success")) {
//                            new DialogHandler(SplashActivity.this).showAlertDialog(getString(R.string.error_server));
//                            return;
//                        }
//
//                        if (Integer.parseInt(jsonObject.getString("status")) != 200) {
//                            new DialogHandler(SplashActivity.this).showAlertDialog(getString(R.string.error_server));
//                            return;
//                        }
//
//                        if (null == jsonObject.get("data")) {
//                            new DialogHandler(SplashActivity.this).showAlertDialog(getString(R.string.error_server));
//                            return;
//                        }
//
//                        ArrayList<ZoneWSModel> data = new Gson().fromJson(jsonObject.getString("data"), new TypeToken<ArrayList<ZoneWSModel>>() {
//                        }.getType());
//
//                        for (ZoneWSModel zoneWSModel : data) {
//                            insertZone(zoneWSModel.getZoneName(), zoneWSModel.getZoneId());
//                        }
//
//                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                        finish();
//
//                    } catch (Exception e) {
////                        new DialogHandler(SplashActivity.this).showAlertDialog(e.getMessage());
//                        e.printStackTrace();
//                    }
//
//                    Logger.d(TAG, " @getZone : SUCCESS : " + response.body());
//
//                } else {
//                    Logger.e(TAG, " @getZone : FAILURE : " + call.request());
////                    new DialogHandler(SplashActivity.this).showAlertDialog(call.request().toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                showProgress(false);
//                Logger.e(TAG, " @getZone : FAILURE : " + call.request());
//
//                try {
//                    if (t instanceof IOException) {
//                        throw new IOException(t);
//                    } else if (t instanceof HttpException) {
//                        throw new Exception(t.getMessage());
//                    }
//                } catch (Exception e) {
////                    new DialogHandler(SplashActivity.this).showAlertDialog(e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        showProgress(true);
//    }

//    private void insertZone(String zoneName, String zoneId) {
//        ZoneContentValues contentValues = new ZoneContentValues();
//        contentValues.putZoneid(zoneId);
//        contentValues.putZonename(zoneName);
//
//        ZoneSelection selection = new ZoneSelection();
//        selection.zoneid(zoneId);
//
//        ZoneCursor cursor = selection.query(getContentResolver());
//
//        if (cursor.moveToFirst()) {
//            contentValues.update(getContentResolver(), selection);
//        } else {
//            contentValues.insert(getContentResolver());
//        }
//    }

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
