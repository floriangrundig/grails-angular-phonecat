package org.eclipse.jetty.websocket

import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.SelectChannelConnector;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import static org.eclipse.jetty.websocket.WebSocket.FrameConnection
import static org.eclipse.jetty.websocket.WebSocket.Connection

public class MyTestServer extends Server {
  boolean _verbose;

  WebSocket _websocket;
  SelectChannelConnector _connector;
  WebSocketHandler _wsHandler;

  public MyTestServer(int port) {
    _connector = new SelectChannelConnector();
    _connector.setPort(port);

    addConnector(_connector);
    _wsHandler = new WebSocketHandler() {
      public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
        if ("karma-test-results".equals(protocol)) {
          _websocket = new MyTestEchoWebSocket();
        }
        return _websocket;
      }
    };

    setHandler(_wsHandler);
  }

  /* ------------------------------------------------------------ */

  public boolean isVerbose() {
    return _verbose;
  }

  /* ------------------------------------------------------------ */

  public void setVerbose(boolean verbose) {
    _verbose = verbose;
  }

  /* ------------------------------------------------------------ */


  /* ------------------------------------------------------------ */
  /* ------------------------------------------------------------ */
  class MyTestWebSocket implements WebSocket, WebSocket.OnFrame, WebSocket.OnTextMessage, WebSocket.OnControl {
    protected FrameConnection _connection;

    public FrameConnection getConnection() {
      return _connection;
    }

    public void onOpen(Connection connection) {
      if (_verbose)
        System.err.printf("%s#onOpen %s\n", this.getClass().getSimpleName(), connection);
    }

    public void onHandshake(FrameConnection connection) {
      if (_verbose)
        System.err.printf("%s#onHandshake %s %s\n", this.getClass().getSimpleName(), connection, connection.getClass().getSimpleName());
      _connection = connection;
    }

    public void onClose(int code, String message) {
      if (_verbose)
        System.err.printf("%s#onDisonnect %d %s\n", this.getClass().getSimpleName(), code, message);
    }

    public boolean onFrame(byte flags, byte opcode, byte[] data, int offset, int length) {
      if (_verbose)
        System.err.printf("%s#onFrame %s|%s %s\n", this.getClass().getSimpleName(), TypeUtil.toHexString(flags), TypeUtil.toHexString(opcode), TypeUtil.toHexString(data, offset, length));
      return false;
    }

    public boolean onControl(byte controlCode, byte[] data, int offset, int length) {
      if (_verbose)
        System.err.printf("%s#onControl  %s %s\n", this.getClass().getSimpleName(), TypeUtil.toHexString(controlCode), TypeUtil.toHexString(data, offset, length));
      return false;
    }

    public void onMessage(String data) {
        System.err.printf("%s#onMessage     %s\n", this.getClass().getSimpleName(), data);
    }

    public void onMessage(byte[] data, int offset, int length) {
        System.err.printf("%s#onMessage     %s\n", this.getClass().getSimpleName(), TypeUtil.toHexString(data, offset, length));
    }
  }

  /* ------------------------------------------------------------ */
  /* ------------------------------------------------------------ */
  class MyTestEchoWebSocket extends MyTestWebSocket {
    @Override
    public void onOpen(Connection connection) {
      super.onOpen(connection);
      connection.setMaxTextMessageSize(-1);
      connection.setMaxBinaryMessageSize(-1);
    }

    @Override
    public boolean onFrame(byte flags, byte opcode, byte[] data, int offset, int length) {
      super.onFrame(flags, opcode, data, offset, length);
      try {
        if (!getConnection().isControl(opcode))
          getConnection().sendFrame(flags, opcode, data, offset, length);
      }
      catch (IOException e) {
        e.printStackTrace();
      }

      return false;
    }
  }


  public static void main(String... args) {
    try {
      int port = 9000;


      MyTestServer server = new MyTestServer(port);
      server.setVerbose(true);
      server.start();
      server.join();
    }
    catch (Exception e) {
      Log.warn(e);
    }
  }


}