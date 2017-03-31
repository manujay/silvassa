package com.mapmyindia.ceinfo.silvassa.reciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.RetryStrategy;
import com.firebase.jobdispatcher.Trigger;
import com.mapmyindia.ceinfo.silvassa.scheduler.SyncJobProvider;
import com.mapmyindia.ceinfo.silvassa.utils.SharedPrefeHelper;

/**
 * Created by ceinfo on 31-03-2017.
 */

public class BootReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        switch (intent.getAction()) {

            case Intent.ACTION_BOOT_COMPLETED:

            case Intent.ACTION_POWER_CONNECTED:

                String jobTag = SharedPrefeHelper.getDeviceId(context);
                // Create a new dispatcher using the Google Play driver.
                FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(context));
                Job myJob = dispatcher.newJobBuilder()
                        .setService(SyncJobProvider.class) // the JobService that will be called
                        .setTag(jobTag)        // uniquely identifies the job
                        // one-off job
                        .setRecurring(true)
                        // don't persist past a device reboot
                        .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                        // start between 0 and 60 seconds from now
                        .setTrigger(Trigger.executionWindow(0, 60))
                        // don't overwrite an existing job with the same tag
                        .setReplaceCurrent(false)
                        // retry with exponential backoff
                        .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                        .setConstraints(
                                // only run on an unmetered network
                                Constraint.ON_UNMETERED_NETWORK,
                                // only run when the device is charging
                                Constraint.DEVICE_CHARGING
                        )
                        .build();
                dispatcher.mustSchedule(myJob);
            default:
                break;
        }
    }
}
