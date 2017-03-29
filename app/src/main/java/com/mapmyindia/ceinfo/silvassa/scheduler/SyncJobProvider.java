package com.mapmyindia.ceinfo.silvassa.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by ceinfo on 28-03-2017.
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public class SyncJobProvider extends JobService {

    @Override
    public boolean onStartJob(JobParameters params) {
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
