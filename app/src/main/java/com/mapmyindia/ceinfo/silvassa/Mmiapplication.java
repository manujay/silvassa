package com.mapmyindia.ceinfo.silvassa;

import android.app.Application;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by ceinfo on 28-03-2017.
 */

public class Mmiapplication extends Application {

    public static final String LOG_TAG = Mmiapplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Logger
                .init(LOG_TAG)                 // default PRETTYLOGGER or use just init()
                .methodCount(3)                 // default 2
//                .hideThreadInfo()               // default shown
                .logLevel(LogLevel.FULL)        // default LogLevel.FULL
                .methodOffset(2);                // default 0
//                .logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
    }
}
