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

final class FakeTimeOffset extends FakeTimeOps {

  FakeTimeOffset() {
    super(FakeTime.ENV_KEY_OFFSET);
  }

  @Override
  protected long getAndSet(long value) {
    return UPDATER.getAndUpdate(
        this,
        offset -> {
          long newOffset = offset + value;
          System.setProperty(property, Long.toString(newOffset));
          return newOffset;
        });
  }
}
