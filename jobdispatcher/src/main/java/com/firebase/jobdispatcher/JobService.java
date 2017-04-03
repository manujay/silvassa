// Copyright 2016 Google, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * JobService is the fundamental unit of work used in the JobDispatcher.
 * <p>
 * Users will need to override {@link #onStartJob(JobParameters)}, which is where any asynchronous
 * execution should start. This method, like most lifecycle methods, runs on the main thread; you
 * <b>must</b> offload execution to another thread (or {@link android.os.AsyncTask}, or
 * {@link android.os.Handler}, or your favorite flavor of concurrency).
 * <p>
 * Once any asynchronous work is complete {@link #jobFinished(JobParameters, boolean)} should be
 * called to inform the backing driver of the result.
 * <p>
 * Implementations should also override {@link #onStopJob(JobParameters)}, which will be called if
 * the scheduling engine wishes to interrupt your work (most likely because the runtime constraints
 * that are associated with the job in question are no longer met).
 */
public abstract class JobService extends Service {
    /**
     * Returned to indicate the job was executed successfully. If the job is not recurring (i.e. a
     * one-off) it will be dequeued and forgotten. If it is recurring the trigger will be reset and
     * the job will be requeued.
     */
    public static final int RESULT_SUCCESS = 0;

    /**
     * Returned to indicate the job encountered an error during execution and should be retried after
     * a backoff period.
     */
    public static final int RESULT_FAIL_RETRY = 1;

    /**
     * Returned to indicate the job encountered an error during execution but should not be retried.
     * If the job is not recurring (i.e. a one-off) it will be dequeued and forgotten. If it is
     * recurring the trigger will be reset and the job will be requeued.
     */
    public static final int RESULT_FAIL_NORETRY = 2;

    static final String TAG = "FJD.JobService";

    @VisibleForTesting
    static final String ACTION_EXECUTE = "com.firebase.jobdispatcher.ACTION_EXECUTE";

    /**
     * Correlates job tags (unique strings) with Messages, which are used to signal the completion
     * of a job.
     */
    private final SimpleArrayMap<String, JobCallback> runningJobs = new SimpleArrayMap<>(1);
    private LocalBinder binder = new LocalBinder();

    /**
     * The entry point to your Job. Implementations should offload work to another thread of
     * execution as soon as possible.
     *
     * @return whether there is more work remaining.
     */
    public abstract boolean onStartJob(JobParameters job);

    /**
     * Called when the scheduling engine has decided to interrupt the execution of a running job,
     * most likely because the runtime constraints associated with the job are no longer satisfied.
     *
     * @return whether the job should be retried
     * @see Builder#setRetryStrategy(RetryStrategy)
     * @see RetryStrategy
     */
    public abstract boolean onStopJob(JobParameters job);

    final void start(JobParameters job, Message msg) {
        synchronized (runningJobs) {
            runningJobs.put(job.getTag(), new JobCallback(job, msg));
        }

        boolean moreWork = onStartJob(job);
        if (!moreWork) {
            synchronized (runningJobs) {
                runningJobs.remove(job.getTag()).sendResult(RESULT_SUCCESS);
            }
        }
    }

    /**
     * Called to indicate that execution of the provided {@code job} has completed.
     *
     * @param job
     * @param needsReschedule whether the job should be rescheduled
     * @see Builder#setRetryStrategy(RetryStrategy)
     */
    public final void jobFinished(@NonNull JobParameters job, boolean needsReschedule) {
        if (job == null) {
            Log.e(TAG, "jobFinished called with a null JobParameters");
            return;
        }

        JobCallback jobCallback;
        synchronized (runningJobs) {
            jobCallback = runningJobs.remove(job.getTag());
        }

        if (jobCallback != null) {
            jobCallback.sendResult(needsReschedule ? RESULT_FAIL_RETRY : RESULT_SUCCESS);
        }
    }

    @Override
    public final int onStartCommand(Intent intent, int flags, int startId) {
        stopSelf(startId);

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public final IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public final boolean onUnbind(Intent intent) {
        synchronized (runningJobs) {
            for (int i = runningJobs.size() - 1; i >= 0; i--) {
                JobCallback message = runningJobs.get(runningJobs.keyAt(i));
                if (message != null) {
                    message.sendResult(onStopJob(message.jobParameters)
                            // returned true, would like to be rescheduled
                            ? RESULT_FAIL_RETRY
                            // returned false, but was interrupted so consider it a fail
                            : RESULT_FAIL_NORETRY);
                }
            }
        }

        return super.onUnbind(intent);
    }

    @Override
    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public final void onStart(Intent intent, int startId) {
    }

    @Override
    protected final void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(fd, writer, args);
    }

    @Override
    public final void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public final void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }

    /**
     * The result returned from a job execution.
     */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({RESULT_SUCCESS, RESULT_FAIL_RETRY, RESULT_FAIL_NORETRY})
    public @interface JobResult {
    }

    private final static class JobCallback {
        public final JobParameters jobParameters;
        public final Message message;

        private JobCallback(JobParameters jobParameters, Message message) {
            this.jobParameters = jobParameters;
            this.message = message;
        }

        void sendResult(@JobResult int result) {
            message.arg1 = result;
            message.sendToTarget();
        }
    }

    class LocalBinder extends Binder {
        JobService getService() {
            return JobService.this;
        }
    }
}
