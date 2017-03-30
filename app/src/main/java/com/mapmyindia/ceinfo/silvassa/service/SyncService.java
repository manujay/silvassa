package com.mapmyindia.ceinfo.silvassa.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.mapmyindia.ceinfo.silvassa.publish.PublishProvider;

/**
 * Created by ceinfo on 30-03-2017.
 * <p>
 * Service to publish payment db on server uses firebase job scheduler to schedule as a job</p>
 */

public class SyncService extends Service {

    private SyncThread thread = null;

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startActivity(starter);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if (thread == null) {
            thread = new SyncThread();
            thread.setContext(getApplicationContext());
            thread.start();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        try {
            thread.join();
        } catch (Exception e) {
        }
        thread = null;
        super.onDestroy();
    }

    private static class SyncThread extends Thread {

        boolean stop = false;
        private Context context;

        private void setContext(Context context) {
            this.context = context;
        }

        @Override
        public void run() {
            super.run();

            while (!stop) {
                PublishProvider.getPublishProvider(context, new PublishProvider.OnPublishCallBack() {
                    @Override
                    public void onPublishCompleted(boolean flag) {
                        stop = flag;
                    }
                }).publishOnServer();
            }
        }
    }
}
