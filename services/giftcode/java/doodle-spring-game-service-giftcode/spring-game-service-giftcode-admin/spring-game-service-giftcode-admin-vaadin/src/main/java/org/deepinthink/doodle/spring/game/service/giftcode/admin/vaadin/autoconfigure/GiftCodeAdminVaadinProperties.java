/*
 * Copyright 2026-present DeepInThink. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.deepinthink.doodle.spring.game.service.giftcode.admin.vaadin.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(GiftCodeAdminVaadinProperties.PREFIX)
public class GiftCodeAdminVaadinProperties {
  public static final String PREFIX = "doodle.service.giftcode.admin.vaadin";

  public static final String PREFIX_VIEWS =
      "org.deepinthink.doodle.spring.game.service.giftcode.admin.vaadin.views";

  private String label = "Service::GiftCode";

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
