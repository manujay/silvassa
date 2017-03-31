package com.mapmyindia.ceinfo.silvassa.scheduler;

import com.firebase.jobdispatcher.JobParameters;
import com.mapmyindia.ceinfo.silvassa.service.SyncService;

/**
 * Created by ceinfo on 28-03-2017.
 */
public class SyncJobProvider extends com.firebase.jobdispatcher.JobService {
    @Override
    public boolean onStartJob(JobParameters job) {

        SyncService.start(getApplicationContext());

        return true;
    }

    @Override
    public boolean onStopJob(JobParameters job) {
        return false;
    }
}
