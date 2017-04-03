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

public class JobTrigger {

    public static final class ImmediateTrigger extends JobTrigger {
        /* package */ ImmediateTrigger() {
        }
    }

    /**
     * ExecutionWindow represents a Job trigger that becomes eligible once
     * the current elapsed time exceeds the scheduled time + the {@code windowStart}
     * value. The scheduler backend is encouraged to use the windowEnd value as a
     * signal that the job should be run, but this is not an enforced behavior.
     */
    public static final class ExecutionWindowTrigger extends JobTrigger {
        private final int mWindowStart;
        private final int mWindowEnd;

        /* package */ ExecutionWindowTrigger(int windowStart, int windowEnd) {
            this.mWindowStart = windowStart;
            this.mWindowEnd = windowEnd;
        }

        public int getWindowStart() {
            return mWindowStart;
        }

        public int getWindowEnd() {
            return mWindowEnd;
        }
    }
}
