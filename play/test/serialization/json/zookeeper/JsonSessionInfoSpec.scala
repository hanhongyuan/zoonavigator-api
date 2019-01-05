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

import org.scalatest.FlatSpec
import play.api.libs.json._
import session.SessionToken
import zookeeper.ConnectionString
import zookeeper.session.SessionInfo

class JsonSessionInfoSpec extends FlatSpec with JsonSessionInfo {

  "Serialized JsonSessionInfo" should "be a JSON object with 'token' field" in {
    val s = SessionInfo(SessionToken("token"), ConnectionString("localhost:2181"))
    val j = implicitly[Writes[s.type]].writes(s)

    assert(j \ "token" isDefined)
  }

  it should "be a JSON object with 'connectionString' field" in {
    val s = SessionInfo(SessionToken("token"), ConnectionString("localhost:2181"))
    val j = implicitly[Writes[SessionInfo]].writes(s)

    assert(j \ "connectionString" isDefined)
  }
}