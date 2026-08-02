package org.deepinthink.doodle.spring.game.role.admin.vaadin.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = RoleAdminVaadinProperties.PREFIX)
public class RoleAdminVaadinProperties {
  public static final String PREFIX = "doodle.role.admin.vaadin";

  public static final String PREFIX_VIEWS =
      "org.deepinthink.doodle.spring.game.role.admin.vaadin.views";

  private String label = "Role";

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }
}
