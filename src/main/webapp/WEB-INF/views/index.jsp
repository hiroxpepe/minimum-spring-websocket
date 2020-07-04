<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>websocket</title>
        <script type="text/javascript">
            // open the web socket connection to the server
            var ws = new WebSocket('ws://localhost:8080/endpoint');
            // send the message.
            function send() {
                var message = document.getElementById('client-message');
                if (message.value) {
                    ws.send(message.value);
                    message.value = '';
                }
            }
            // recive the message.
            ws.onmessage = function(event) {
                var message = document.getElementById('server-message');
                message.value = event.data;
            }
        </script>
    </head>
    <body>
       <h3>Spring MVC + WebSocket</h3>
       <hr />
       <label>Message</label>
       <br>
       <textarea rows="8" cols="50" id="client-message"></textarea>
       <br>
       <button onclick="send()">Send</button>
       <br>
       <label>Response from Server</label>
       <br>
       <textarea rows="8" cols="50" id="server-message" readonly="readonly"></textarea>
    </body>
</html>
