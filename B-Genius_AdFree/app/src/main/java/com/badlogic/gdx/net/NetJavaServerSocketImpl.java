package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.net.InetSocketAddress;

public class NetJavaServerSocketImpl
  implements ServerSocket
{
  private Net.Protocol protocol;
  private java.net.ServerSocket server;

  public NetJavaServerSocketImpl(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints)
  {
    this(paramProtocol, null, paramInt, paramServerSocketHints);
  }

  public NetJavaServerSocketImpl(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints)
  {
    this.protocol = paramProtocol;
    InetSocketAddress localInetSocketAddress;
    try
    {
      this.server = new java.net.ServerSocket();
      if (paramServerSocketHints != null)
      {
        this.server.setPerformancePreferences(paramServerSocketHints.performancePrefConnectionTime, paramServerSocketHints.performancePrefLatency, paramServerSocketHints.performancePrefBandwidth);
        this.server.setReuseAddress(paramServerSocketHints.reuseAddress);
        this.server.setSoTimeout(paramServerSocketHints.acceptTimeout);
        this.server.setReceiveBufferSize(paramServerSocketHints.receiveBufferSize);
      }
      if (paramString != null);
      for (localInetSocketAddress = new InetSocketAddress(paramString, paramInt); paramServerSocketHints != null; localInetSocketAddress = new InetSocketAddress(paramInt))
      {
        this.server.bind(localInetSocketAddress, paramServerSocketHints.backlog);
        return;
      }
    }
    catch (Exception localException)
    {
      throw new GdxRuntimeException("Cannot create a server socket at port " + paramInt + ".", localException);
    }
    this.server.bind(localInetSocketAddress);
  }

  public Socket accept(SocketHints paramSocketHints)
  {
    try
    {
      NetJavaSocketImpl localNetJavaSocketImpl = new NetJavaSocketImpl(this.server.accept(), paramSocketHints);
      return localNetJavaSocketImpl;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error accepting socket.", localException);
  }

  public void dispose()
  {
    if (this.server != null);
    try
    {
      this.server.close();
      this.server = null;
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error closing server.", localException);
  }

  public Net.Protocol getProtocol()
  {
    return this.protocol;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.NetJavaServerSocketImpl
 * JD-Core Version:    0.6.0
 */