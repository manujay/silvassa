package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ceinfo on 13-04-2017.
 */

public class DemoActivity extends Activity {

    private static final String TAG = DemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, " @mky:onCreate ");


    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, " @mky:onStart ");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, " @mky:onResume ");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, " @mky:onPause ");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, " @mky:onCreate ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " @mky:onDestroy ");
    }
}
