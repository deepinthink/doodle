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
package org.deepinthink.doodle.vaadin.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.deepinthink.doodle.vaadin.VaadinProperties;

@Route("login")
@PageTitle("Login | Vaadin")
@AnonymousAllowed
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LoginView extends VerticalLayout implements BeforeEnterObserver {
  LoginForm login = new LoginForm();

  public LoginView(VaadinProperties properties) {
    addClassName("login-view");
    setSizeFull();
    setAlignItems(Alignment.CENTER);
    setJustifyContentMode(JustifyContentMode.CENTER);

    login.setAction("login");
    add(new H1("Vaadin"));
    add(login);
  }

  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    if (event.getLocation().getQueryParameters().getParameters().containsKey("error")) {
      login.setError(true);
    }
  }
}
