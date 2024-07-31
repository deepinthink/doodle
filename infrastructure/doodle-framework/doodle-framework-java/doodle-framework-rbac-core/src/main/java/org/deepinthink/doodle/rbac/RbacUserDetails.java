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
package org.deepinthink.doodle.rbac;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@ToString
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = RbacUserDetails.COLLECTION)
public class RbacUserDetails implements UserDetails {
  public static final String COLLECTION = "rbac-users";
  @Id String username;
  String password;
  boolean accountNonExpired;
  boolean accountNonLocked;
  boolean credentialsNonExpired;
  boolean enabled;
  List<? extends GrantedAuthority> authorities;
}
