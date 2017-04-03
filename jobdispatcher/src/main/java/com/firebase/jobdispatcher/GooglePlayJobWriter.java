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

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.annotation.VisibleForTesting;

import com.firebase.jobdispatcher.RetryStrategy.RetryPolicy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* package */ final class GooglePlayJobWriter {

    static final String REQUEST_PARAM_UPDATE_CURRENT = "update_current";
    static final String REQUEST_PARAM_EXTRAS = "extras";
    static final String REQUEST_PARAM_PERSISTED = "persisted";
    static final String REQUEST_PARAM_REQUIRED_NETWORK = "requiredNetwork";
    static final String REQUEST_PARAM_REQUIRES_CHARGING = "requiresCharging";
    static final String REQUEST_PARAM_RETRY_STRATEGY = "retryStrategy";
    static final String REQUEST_PARAM_SERVICE = "service";
    static final String REQUEST_PARAM_TAG = "tag";

    static final String REQUEST_PARAM_RETRY_STRATEGY_INITIAL_BACKOFF_SECONDS =
            "initial_backoff_seconds";
    static final String REQUEST_PARAM_RETRY_STRATEGY_MAXIMUM_BACKOFF_SECONDS =
            "maximum_backoff_seconds";
    static final String REQUEST_PARAM_RETRY_STRATEGY_POLICY = "retry_policy";

    static final String REQUEST_PARAM_TRIGGER_TYPE = "trigger_type";
    static final String REQUEST_PARAM_TRIGGER_WINDOW_END = "window_end";
    static final String REQUEST_PARAM_TRIGGER_WINDOW_FLEX = "period_flex";
    static final String REQUEST_PARAM_TRIGGER_WINDOW_PERIOD = "period";
    static final String REQUEST_PARAM_TRIGGER_WINDOW_START = "window_start";

    @VisibleForTesting
    /* package */ static final int LEGACY_RETRY_POLICY_EXPONENTIAL = 0;
    @VisibleForTesting
    /* package */ static final int LEGACY_RETRY_POLICY_LINEAR = 1;
    @VisibleForTesting
    /* package */ final static int LEGACY_NETWORK_UNMETERED = 1;
    @VisibleForTesting
    /* package */ final static int LEGACY_NETWORK_CONNECTED = 0;
    @VisibleForTesting
    /* package */ final static int LEGACY_NETWORK_ANY = 2;

    private JobCoder jobCoder = new JobCoder(BundleProtocol.PACKED_PARAM_BUNDLE_PREFIX, false);

    private static boolean isSupported(JobTrigger trigger) {
        return trigger instanceof JobTrigger.ExecutionWindowTrigger || trigger == Trigger.NOW;
    }

    private static void writeExecutionWindowTriggerToBundle(JobParameters job, Bundle b,
                                                            JobTrigger.ExecutionWindowTrigger trigger) {

        b.putInt(REQUEST_PARAM_TRIGGER_TYPE, BundleProtocol.TRIGGER_TYPE_EXECUTION_WINDOW);

        if (job.isRecurring()) {
            b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_PERIOD,
                    trigger.getWindowEnd());
            b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_FLEX,
                    trigger.getWindowEnd() - trigger.getWindowStart());
        } else {
            b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_START,
                    trigger.getWindowStart());
            b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_END,
                    trigger.getWindowEnd());
        }
    }

    private static void writeImmediateTriggerToBundle(Bundle b) {
        b.putInt(REQUEST_PARAM_TRIGGER_TYPE, BundleProtocol.TRIGGER_TYPE_IMMEDIATE);
        b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_START, 0);
        b.putLong(REQUEST_PARAM_TRIGGER_WINDOW_END, 30);
    }

    public Bundle writeToBundle(JobParameters job, Bundle b) {
        b.putString(REQUEST_PARAM_TAG, job.getTag());
        b.putBoolean(REQUEST_PARAM_UPDATE_CURRENT, job.shouldReplaceCurrent());

        boolean persisted = job.getLifetime() == Lifetime.FOREVER;
        b.putBoolean(REQUEST_PARAM_PERSISTED, persisted);
        b.putString(REQUEST_PARAM_SERVICE, GooglePlayReceiver.class.getName());

        writeTriggerToBundle(job, b);
        writeConstraintsToBundle(job, b);
        writeRetryStrategyToBundle(job, b);

        // Embed the job spec (minus extras) into the extras (under a prefix)
        Bundle extras = job.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        b.putBundle(REQUEST_PARAM_EXTRAS, jobCoder.encode(job, extras));

        return b;
    }

    private void writeRetryStrategyToBundle(JobParameters job, Bundle b) {
        RetryStrategy strategy = job.getRetryStrategy();

        Bundle rb = new Bundle();
        rb.putInt(REQUEST_PARAM_RETRY_STRATEGY_POLICY,
                convertRetryPolicyToLegacyVersion(strategy.getPolicy()));
        rb.putInt(REQUEST_PARAM_RETRY_STRATEGY_INITIAL_BACKOFF_SECONDS,
                strategy.getInitialBackoff());
        rb.putInt(REQUEST_PARAM_RETRY_STRATEGY_MAXIMUM_BACKOFF_SECONDS,
                strategy.getMaximumBackoff());

        b.putBundle(REQUEST_PARAM_RETRY_STRATEGY, rb);
    }

    private int convertRetryPolicyToLegacyVersion(@RetryPolicy int policy) {
        switch (policy) {
            case RetryStrategy.RETRY_POLICY_LINEAR:
                return LEGACY_RETRY_POLICY_LINEAR;

            case RetryStrategy.RETRY_POLICY_EXPONENTIAL:
                // fallthrough
            default:
                return LEGACY_RETRY_POLICY_EXPONENTIAL;
        }
    }

    private void writeTriggerToBundle(JobParameters job, Bundle b) {
        final JobTrigger trigger = job.getTrigger();
        if (!isSupported(trigger)) {
            throw new IllegalArgumentException("Unknown trigger: " + trigger.getClass());
        }

        if (trigger == Trigger.NOW) {
            writeImmediateTriggerToBundle(b);
        } else {
            writeExecutionWindowTriggerToBundle(job, b, (JobTrigger.ExecutionWindowTrigger) trigger);
        }
    }

    private void writeConstraintsToBundle(JobParameters job, Bundle b) {
        int c = Constraint.compact(job.getConstraints());

        b.putBoolean(REQUEST_PARAM_REQUIRES_CHARGING,
                (c & Constraint.DEVICE_CHARGING) == Constraint.DEVICE_CHARGING);

        b.putInt(REQUEST_PARAM_REQUIRED_NETWORK, convertConstraintsToLegacyNetConstant(c));
    }

    /**
     * Converts a bitmap of Constraint values into a LegacyNetworkConstraint constant (int).
     */
    @LegacyNetworkConstant
    private int convertConstraintsToLegacyNetConstant(int constraintMap) {
        int reqNet = LEGACY_NETWORK_ANY;

        reqNet = (constraintMap & Constraint.ON_ANY_NETWORK) == Constraint.ON_ANY_NETWORK
                ? LEGACY_NETWORK_CONNECTED
                : reqNet;

        reqNet = (constraintMap & Constraint.ON_UNMETERED_NETWORK) == Constraint.ON_UNMETERED_NETWORK
                ? LEGACY_NETWORK_UNMETERED
                : reqNet;

        return reqNet;
    }

    @IntDef({LEGACY_NETWORK_ANY, LEGACY_NETWORK_CONNECTED, LEGACY_NETWORK_UNMETERED})
    @Retention(RetentionPolicy.SOURCE)
    private @interface LegacyNetworkConstant {
    }
}
