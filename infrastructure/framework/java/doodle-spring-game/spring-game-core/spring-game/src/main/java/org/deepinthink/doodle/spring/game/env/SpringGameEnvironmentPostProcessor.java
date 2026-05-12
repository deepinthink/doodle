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
package org.deepinthink.doodle.spring.game.env;

import java.util.Properties;
import org.deepinthink.doodle.spring.game.SpringGameVersion;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.util.StringUtils;

public class SpringGameEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

  public static final String SPRING_GAME_DEFAULT_PROPERTY_SOURCE = "springGameDefaultProperties";
  public static final String SPRING_GAME_VERSION = "spring-game.version";
  public static final String SPRING_GAME_FORMATTED_VERSION = "spring-game.formatted-version";
  public static final int ORDER = Ordered.LOWEST_PRECEDENCE - 100;

  @Override
  public void postProcessEnvironment(
      @NonNull ConfigurableEnvironment environment, @NonNull SpringApplication application) {
    addSpringGameDefaultPropertySource(environment);
  }

  private void addSpringGameDefaultPropertySource(ConfigurableEnvironment environment) {
    Properties defaultProperties = getSpringGameVersionProperties();
    PropertiesPropertySource propertySource =
        new PropertiesPropertySource(SPRING_GAME_DEFAULT_PROPERTY_SOURCE, defaultProperties);
    environment.getPropertySources().addLast(propertySource);
  }

  private Properties getSpringGameVersionProperties() {
    Properties properties = new Properties();
    String version = getSpringGameVersion();
    String formattedVersion = getFormattedSpringGameVersion();
    properties.setProperty(SPRING_GAME_VERSION, version);
    properties.setProperty(SPRING_GAME_FORMATTED_VERSION, formattedVersion);
    return properties;
  }

  protected String getSpringGameVersion() {
    return SpringGameVersion.getVersion();
  }

  protected String getFormattedSpringGameVersion() {
    String version = getSpringGameVersion();
    return !StringUtils.hasText(version) ? "" : String.format(" (v%s)", version);
  }

  @Override
  public int getOrder() {
    return ORDER;
  }
}
