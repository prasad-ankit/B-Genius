package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.net.NetJavaImpl;
import com.badlogic.gdx.net.NetJavaServerSocketImpl;
import com.badlogic.gdx.net.NetJavaSocketImpl;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;

public class AndroidNet
  implements Net
{
  final AndroidApplicationBase app;
  NetJavaImpl netJavaImpl;

  public AndroidNet(AndroidApplicationBase paramAndroidApplicationBase)
  {
    this.app = paramAndroidApplicationBase;
    this.netJavaImpl = new NetJavaImpl();
  }

  public void cancelHttpRequest(Net.HttpRequest paramHttpRequest)
  {
    this.netJavaImpl.cancelHttpRequest(paramHttpRequest);
  }

  public Socket newClientSocket(Net.Protocol paramProtocol, String paramString, int paramInt, SocketHints paramSocketHints)
  {
    return new NetJavaSocketImpl(paramProtocol, paramString, paramInt, paramSocketHints);
  }

  public ServerSocket newServerSocket(Net.Protocol paramProtocol, int paramInt, ServerSocketHints paramServerSocketHints)
  {
    return new NetJavaServerSocketImpl(paramProtocol, paramInt, paramServerSocketHints);
  }

  public ServerSocket newServerSocket(Net.Protocol paramProtocol, String paramString, int paramInt, ServerSocketHints paramServerSocketHints)
  {
    return new NetJavaServerSocketImpl(paramProtocol, paramString, paramInt, paramServerSocketHints);
  }

  public boolean openURI(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    ResolveInfo localResolveInfo = this.app.getContext().getPackageManager().resolveActivity(localIntent, 65536);
    int i = 0;
    if (localResolveInfo != null)
    {
      this.app.runOnUiThread(new AndroidNet.1(this, localUri));
      i = 1;
    }
    return i;
  }

  public void sendHttpRequest(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener)
  {
    this.netJavaImpl.sendHttpRequest(paramHttpRequest, paramHttpResponseListener);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidNet
 * JD-Core Version:    0.6.0
 */