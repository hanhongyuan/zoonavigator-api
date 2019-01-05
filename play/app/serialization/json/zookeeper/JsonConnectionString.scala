/*
 * Copyright (C) 2018  Ľuboš Kozmon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package serialization.json.zookeeper

import play.api.libs.json._
import zookeeper.ConnectionString

trait JsonConnectionString {

  implicit object ConnectionStringFormat extends Format[ConnectionString] {
    override def reads(json: JsValue): JsResult[ConnectionString] =
      json match {
        case JsString(connectionString) =>
          JsSuccess(ConnectionString(connectionString))
        case _ =>
          JsError("Invalid connection string format")
      }

    override def writes(o: ConnectionString): JsValue =
      JsString(o.string)
  }

}