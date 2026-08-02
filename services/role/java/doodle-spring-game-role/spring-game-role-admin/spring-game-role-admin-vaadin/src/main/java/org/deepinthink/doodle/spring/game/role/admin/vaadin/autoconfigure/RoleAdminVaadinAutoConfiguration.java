package org.deepinthink.doodle.spring.game.role.admin.vaadin.autoconfigure;

import com.vaadin.flow.component.sidenav.SideNavItem;
import org.deepinthink.amoeba.spring.boot.vaadin.EnableVaadin;
import org.deepinthink.amoeba.spring.boot.vaadin.admin.views.VaadinAdminSideNavItemSupplier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@EnableVaadin(RoleAdminVaadinProperties.PREFIX_VIEWS)
@EnableConfigurationProperties(RoleAdminVaadinProperties.class)
public class RoleAdminVaadinAutoConfiguration {

  @Bean
  public VaadinAdminSideNavItemSupplier roleAdminVaadinSideNavView(
      RoleAdminVaadinProperties properties) {
    return (context) -> new SideNavItem(properties.getLabel());
  }
}
