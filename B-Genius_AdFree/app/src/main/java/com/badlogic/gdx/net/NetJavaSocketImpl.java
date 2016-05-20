package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class NetJavaSocketImpl
  implements Socket
{
  private java.net.Socket socket;

  public NetJavaSocketImpl(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints)
  {
    try
    {
      this.socket = new java.net.Socket();
      applyHints(paramSocketHints);
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(paramString, paramInt);
      if (paramSocketHints != null)
      {
        this.socket.connect(localInetSocketAddress, paramSocketHints.connectTimeout);
        return;
      }
      this.socket.connect(localInetSocketAddress);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error making a socket connection to " + paramString + ":" + paramInt, localException);
  }

  public NetJavaSocketImpl(java.net.Socket paramSocket, SocketHints paramSocketHints)
  {
    this.socket = paramSocket;
    applyHints(paramSocketHints);
  }

  private void applyHints(SocketHints paramSocketHints)
  {
    if (paramSocketHints != null);
    try
    {
      this.socket.setPerformancePreferences(paramSocketHints.performancePrefConnectionTime, paramSocketHints.performancePrefLatency, paramSocketHints.performancePrefBandwidth);
      this.socket.setTrafficClass(paramSocketHints.trafficClass);
      this.socket.setTcpNoDelay(paramSocketHints.tcpNoDelay);
      this.socket.setKeepAlive(paramSocketHints.keepAlive);
      this.socket.setSendBufferSize(paramSocketHints.sendBufferSize);
      this.socket.setReceiveBufferSize(paramSocketHints.receiveBufferSize);
      this.socket.setSoLinger(paramSocketHints.linger, paramSocketHints.lingerDuration);
      this.socket.setSoTimeout(paramSocketHints.socketTimeout);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error setting socket hints.", localException);
  }

  public void dispose()
  {
    if (this.socket != null);
    try
    {
      this.socket.close();
      this.socket = null;
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error closing socket.", localException);
  }

  public InputStream getInputStream()
  {
    try
    {
      InputStream localInputStream = this.socket.getInputStream();
      return localInputStream;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error getting input stream from socket.", localException);
  }

  public OutputStream getOutputStream()
  {
    try
    {
      OutputStream localOutputStream = this.socket.getOutputStream();
      return localOutputStream;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error getting output stream from socket.", localException);
  }

  public String getRemoteAddress()
  {
    return this.socket.getRemoteSocketAddress().toString();
  }

  public boolean isConnected()
  {
    if (this.socket != null)
      return this.socket.isConnected();
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.NetJavaSocketImpl
 * JD-Core Version:    0.6.0
 */