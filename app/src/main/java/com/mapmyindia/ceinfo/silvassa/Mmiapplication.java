package com.mapmyindia.ceinfo.silvassa;

import android.app.Application;

import com.orhanobut.logger.LogAdapter;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

import java.util.Locale;

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
                .methodOffset(2)            // default 0
                .logAdapter(new AndroidLogAdapter()); //default AndroidLogAdapter
    }


    public class AndroidLogAdapter implements LogAdapter {

        @Override
        public void d(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));
        }

        @Override
        public void e(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));
        }

        @Override
        public void w(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));
        }

        @Override
        public void i(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));
        }

        @Override
        public void v(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));
        }

        @Override
        public void wtf(String tag, String message) {
            System.out.println(String.format(Locale.getDefault(), "@" + tag + ": %s ", message));

        }
    }
}
