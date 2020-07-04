/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.examproject.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author h.adachi
 */
@Component
public class HelloWebSocketHandler extends TextWebSocketHandler {

   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

      String clientMessage = message.getPayload();

      if (clientMessage.startsWith("Hello") || clientMessage.startsWith("Hi")) {
         session.sendMessage(new TextMessage("Hello! What can i do for you?"));
      } else {
         session.sendMessage(
               new TextMessage("This is a simple hello world example of using Spring WebSocket."));
      }
   }
}
