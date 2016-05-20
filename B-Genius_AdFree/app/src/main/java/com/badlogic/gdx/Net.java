package com.badlogic.gdx;

import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

public abstract interface Net
{
  public abstract void cancelHttpRequest(Net.HttpRequest paramHttpRequest);

  public abstract Socket newClientSocket(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints);

  public abstract ServerSocket newServerSocket(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints);

  public abstract ServerSocket newServerSocket(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints);

  public abstract boolean openURI(String paramString);

  public abstract void sendHttpRequest(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Net
 * JD-Core Version:    0.6.0
 */