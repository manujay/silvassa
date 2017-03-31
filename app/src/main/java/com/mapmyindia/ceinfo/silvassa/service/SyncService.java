package com.mapmyindia.ceinfo.silvassa.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.mapmyindia.ceinfo.silvassa.R;
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
        context.startService(starter);
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

    private class SyncThread extends Thread {

        boolean stop = false;
        private Context context;
        private int _id = 1;
        private NotificationManager mNotifyManager;

        private void setContext(Context context) {
            this.context = context;
            mNotifyManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        @Override
        public void run() {
            super.run();

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                    .setContentTitle("Publish on Cloud")
                    .setContentText("Sync in progress")
                    .setSmallIcon(R.drawable.ic_cloud_upload);

            while (!stop) {
                PublishProvider.getPublishProvider(context, new PublishProvider.OnPublishCallBack() {
                    @Override
                    public void onPublishCompleted(boolean flag) {
                        stop = flag && !stop;
                    }
                }).publishOnServer();

                // Sets an activity indicator for an operation of indeterminate length
                mBuilder.setProgress(0, 0, true);// Issues the notification
                mNotifyManager.notify(_id, mBuilder.build());
            }

            // When the loop is finished, updates the notification
            mBuilder.setContentText("Sync complete")
                    // Removes the progress bar
                    .setProgress(0, 0, false);
            mNotifyManager.notify(_id, mBuilder.build());
        }
    }
}
