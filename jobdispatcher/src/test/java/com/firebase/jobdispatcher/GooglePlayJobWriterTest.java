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

import com.firebase.jobdispatcher.Job.Builder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, sdk = 23)
public class GooglePlayJobWriterTest {

    private static final boolean[] ALL_BOOLEANS = {true, false};

    private GooglePlayJobWriter mWriter;

    private static Builder initializeDefaultBuilder() {
        return TestUtil.getBuilderWithNoopValidator()
                .setConstraints(Constraint.DEVICE_CHARGING)
                .setExtras(null)
                .setLifetime(Lifetime.FOREVER)
                .setRecurring(false)
                .setReplaceCurrent(false)
                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                .setService(TestJobService.class)
                .setTag("tag")
                .setTrigger(Trigger.NOW);
    }

    @Before
    public void setUp() throws Exception {
        mWriter = new GooglePlayJobWriter();
    }

    @Test
    public void testWriteToBundle_tags() {
        for (String tag : Arrays.asList("foo", "bar", "foobar", "this is a tag")) {
            Bundle b = mWriter.writeToBundle(
                    initializeDefaultBuilder().setTag(tag).build(),
                    new Bundle());

            assertEquals("tag", tag, b.getString("tag"));
        }
    }

    @Test
    public void testWriteToBundle_updateCurrent() {
        for (boolean replaceCurrent : ALL_BOOLEANS) {
            Bundle b = mWriter.writeToBundle(
                    initializeDefaultBuilder().setReplaceCurrent(replaceCurrent).build(),
                    new Bundle());

            assertEquals("update_current", replaceCurrent, b.getBoolean("update_current"));
        }
    }

    @Test
    public void testWriteToBundle_persisted() {
        Bundle b = mWriter.writeToBundle(
                initializeDefaultBuilder().setLifetime(Lifetime.FOREVER).build(),
                new Bundle());

        assertTrue("persisted", b.getBoolean("persisted"));

        for (int lifetime : new int[]{Lifetime.UNTIL_NEXT_BOOT}) {
            b = mWriter.writeToBundle(
                    initializeDefaultBuilder().setLifetime(lifetime).build(),
                    new Bundle());

            assertFalse("persisted", b.getBoolean("persisted"));
        }
    }

    @Test
    public void testWriteToBundle_service() {
        Bundle b = mWriter.writeToBundle(
                initializeDefaultBuilder().setService(TestJobService.class).build(),
                new Bundle());

        assertEquals("service", GooglePlayReceiver.class.getName(), b.getString("service"));
    }

    @Test
    public void testWriteToBundle_requiredNetwork() {
        Map<Integer, Integer> mapping = new HashMap<>();
        mapping.put(Constraint.ON_ANY_NETWORK, GooglePlayJobWriter.LEGACY_NETWORK_CONNECTED);
        mapping.put(Constraint.ON_UNMETERED_NETWORK, GooglePlayJobWriter.LEGACY_NETWORK_UNMETERED);
        mapping.put(0, GooglePlayJobWriter.LEGACY_NETWORK_ANY);

        for (Entry<Integer, Integer> testCase : mapping.entrySet()) {
            @SuppressWarnings("WrongConstant")
            Bundle b = mWriter.writeToBundle(
                    initializeDefaultBuilder().setConstraints(testCase.getKey()).build(),
                    new Bundle());

            assertEquals("requiredNetwork", (int) testCase.getValue(), b.getInt("requiredNetwork"));
        }
    }

    @Test
    public void testWriteToBundle_requiresCharging() {
        assertTrue("requiresCharging", mWriter.writeToBundle(
                initializeDefaultBuilder().setConstraints(Constraint.DEVICE_CHARGING).build(),
                new Bundle()).getBoolean("requiresCharging"));

        for (Integer constraint : Arrays.asList(
                Constraint.ON_ANY_NETWORK,
                Constraint.ON_UNMETERED_NETWORK)) {

            assertFalse("requiresCharging", mWriter.writeToBundle(
                    initializeDefaultBuilder().setConstraints(constraint).build(),
                    new Bundle()).getBoolean("requiresCharging"));
        }
    }

    @Test
    public void testWriteToBundle_retryPolicy() {
        assertEquals("retry_policy",
                GooglePlayJobWriter.LEGACY_RETRY_POLICY_EXPONENTIAL,
                mWriter.writeToBundle(
                        initializeDefaultBuilder()
                                .setRetryStrategy(RetryStrategy.DEFAULT_EXPONENTIAL)
                                .build(),
                        new Bundle()).getBundle("retryStrategy").getInt("retry_policy"));

        assertEquals("retry_policy",
                GooglePlayJobWriter.LEGACY_RETRY_POLICY_LINEAR,
                mWriter.writeToBundle(
                        initializeDefaultBuilder()
                                .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR)
                                .build(),
                        new Bundle()).getBundle("retryStrategy").getInt("retry_policy"));
    }

    @Test
    public void testWriteToBundle_backoffSeconds() {
        for (RetryStrategy retryStrategy : Arrays
                .asList(RetryStrategy.DEFAULT_EXPONENTIAL, RetryStrategy.DEFAULT_LINEAR)) {

            Bundle b = mWriter.writeToBundle(
                    initializeDefaultBuilder().setRetryStrategy(retryStrategy).build(),
                    new Bundle()).getBundle("retryStrategy");

            assertEquals("initial_backoff_seconds",
                    retryStrategy.getInitialBackoff(),
                    b.getInt("initial_backoff_seconds"));

            assertEquals("maximum_backoff_seconds",
                    retryStrategy.getMaximumBackoff(),
                    b.getInt("maximum_backoff_seconds"));

        }
    }

    @Test
    public void testWriteToBundle_triggers() {
        // immediate
        Bundle b = mWriter.writeToBundle(
                initializeDefaultBuilder().setTrigger(Trigger.NOW).build(),
                new Bundle());

        assertEquals("window_start", 0, b.getLong("window_start"));
        assertEquals("window_end", 30, b.getLong("window_end"));

        // execution window (oneoff)
        JobTrigger.ExecutionWindowTrigger t = Trigger.executionWindow(631, 978);
        b = mWriter.writeToBundle(
                initializeDefaultBuilder().setTrigger(t).build(),
                new Bundle());

        assertEquals("window_start", t.getWindowStart(), b.getLong("window_start"));
        assertEquals("window_end", t.getWindowEnd(), b.getLong("window_end"));

        // execution window (periodic)
        b = mWriter.writeToBundle(
                initializeDefaultBuilder().setRecurring(true).setTrigger(t).build(),
                new Bundle());

        assertEquals("period", t.getWindowEnd(), b.getLong("period"));
        assertEquals("period_flex", t.getWindowEnd() - t.getWindowStart(), b.getLong("period_flex"));
    }

    @Test
    public void testWriteToBundle_extras() {
        Bundle extras = new Bundle();

        Bundle result = mWriter.writeToBundle(
                initializeDefaultBuilder().setExtras(extras).build(),
                new Bundle());

        assertEquals("extras", extras, result.getBundle("extras"));
    }
}
