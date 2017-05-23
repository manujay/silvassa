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
import com.orhanobut.logger.Logger;

public class SplashActivity extends BaseActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private ProgressBar progressBar;

    @Override
    public void setmTitle(String mTitle) {

    }

    @Override
    public void onActionCliked() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (StringUtils.isNullOrEmpty(SharedPrefeHelper.getZoneId(this))) {
            if (!Connectivity.isConnected(this)) {
                showToast(SplashActivity.this, getString(R.string.error_network));
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
                        Logger.e(TAG, " @ZoneProvider.onError ", msg);
                        showToast(SplashActivity.this, msg);
                    }
                });

                redirectLogin();
            }
        } else {
            redirectLogin();
        }
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

    private void redirectLogin() {
        startActivityForIntent(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
