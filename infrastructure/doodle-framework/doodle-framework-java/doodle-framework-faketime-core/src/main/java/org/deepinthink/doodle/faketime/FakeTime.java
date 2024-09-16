/*
 * Copyright (c) 2020-2024 DeepInThink. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.deepinthink.doodle.faketime;

import java.util.Date;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FakeTime {
  public static final String ENV_KEY_PREFIX = "doodle.faketime";
  public static final String ENV_KEY_ABS = ENV_KEY_PREFIX + ".abs.ms";
  public static final String ENV_KEY_OFFSET = ENV_KEY_PREFIX + ".offset.ms";

  static final FakeTimeAbs ABS = new FakeTimeAbs();
  static final FakeTimeOffset OFFSET = new FakeTimeOffset();

  public static long abs(Date date) {
    return ABS.getAndSet(date.getTime());
  }

  public static long offset(Date date) {
    long currentOffsetMs = OFFSET.get();
    return OFFSET.getAndSet(date.getTime() - System.currentTimeMillis() - currentOffsetMs);
  }

  public static void reset() {
    ABS.reset();
    OFFSET.reset();
  }
}
