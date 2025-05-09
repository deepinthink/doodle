/*
 * Copyright (c) 2020-present DeepInThink. All rights reserved.
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
db.getSiblingDB("admin").auth(
  process.env.MONGO_INITDB_ROOT_USERNAME,
  process.env.MONGO_INITDB_ROOT_PASSWORD
);

db.getSiblingDB("admin").createUser({
  user: process.env.MONGO_INITDB_ADMIN_USERNAME,
  pwd: process.env.MONGO_INITDB_ADMIN_PASSWORD,
  roles: [{
    role: "readWriteAnyDatabase",
    db: "admin"
  },{
    role: "userAdminAnyDatabase",
    db: "admin"
  }]}
);
