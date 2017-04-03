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

import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, manifest = Config.NONE, sdk = 23)
public class ConstraintTest {

    private static final List<List<Integer>> POSSIBLE_COMBINATIONS = TestUtil
            .getAllConstraintCombinations();

    /**
     * Just to get 100% coverage.
     */
    @Test
    public void testPrivateConstructor() throws Exception {
        TestUtil.assertHasSinglePrivateConstructor(Constraint.class);
    }

    @Test
    public void testCompactAndUnCompact() {
        for (List<Integer> combo : POSSIBLE_COMBINATIONS) {
            int[] input = TestUtil.toIntArray(combo);
            Arrays.sort(input);

            int[] output = Constraint.uncompact(Constraint.compact(input));
            Arrays.sort(output);

            for (int i = 0; i < combo.size(); i++) {
                assertEquals("Combination = " + TextUtils.join(", ", combo),
                        input[i],
                        output[i]);
            }

            assertEquals("Expected length of two arrays to be the same",
                    input.length,
                    output.length);
        }
    }
}
