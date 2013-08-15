var WebSocketServer = require('ws').Server
var wss = new WebSocketServer({host: '127.0.0.1',port: 9000});

wss.on('connection', function (ws) {
  console.log('client verbunden...');

  ws.on('message', function (message) {
    console.log('von Client empfangen: ' + message);
    ws.send('von Server empfangen: ' + message);
  });

});
