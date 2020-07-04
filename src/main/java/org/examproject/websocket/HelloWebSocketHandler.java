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

    ///////////////////////////////////////////////////////////////////////////
    // public methods

   @Override
   public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      // get a message from the client.
       String text = message.getPayload();

      // send a message to the client.
      if (text.startsWith("Hello") || text.startsWith("Hi")) {
         session.sendMessage(new TextMessage("Hello! What can i do for you?"));
      } else {
         session.sendMessage(new TextMessage("It's a simple example of Spring WebSocket."));
      }
   }
   
}
