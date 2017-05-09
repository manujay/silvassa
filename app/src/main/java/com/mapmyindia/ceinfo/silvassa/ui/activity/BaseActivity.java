package com.mapmyindia.ceinfo.silvassa.ui.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by ceinfo on 27-02-2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    public static void showToast(Context context, String mesg) {
        Toast.makeText(context, mesg, Toast.LENGTH_SHORT).show();
    }

    private static void showSnackBar(View view, String mesg) {
        Snackbar.make(view, mesg, Snackbar.LENGTH_SHORT).show();
    }

    private static void showSnackBarLong(View view, String mesg) {
        Snackbar.make(view, mesg, Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo Automatically dismisses snackbar
            }
        }).setActionTextColor(view.getContext().getResources().getColor(android.R.color.holo_red_light)).show();
    }

    public static void showSnackBarLong(View view, String mesg, boolean hasAction) {
        if (hasAction) {
            showSnackBarLong(view, mesg);
        } else showSnackBar(view, mesg);
    }

    public static boolean isServiceRunning(Context context, Class _class) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (_class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    public void setToolbar(Toolbar mToolbar) {
        this.mToolbar = mToolbar;
    }

    public abstract void setmTitle(String mTitle);

    public void startActivityForIntent(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
