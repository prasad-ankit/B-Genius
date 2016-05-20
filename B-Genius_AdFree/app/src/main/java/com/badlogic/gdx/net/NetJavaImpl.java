package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.async.AsyncExecutor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NetJavaImpl
{
  private final AsyncExecutor asyncExecutor = new AsyncExecutor(1);
  final ObjectMap connections = new ObjectMap();
  final ObjectMap listeners = new ObjectMap();

  public void cancelHttpRequest(Net.HttpRequest paramHttpRequest)
  {
    Net.HttpResponseListener localHttpResponseListener = getFromListeners(paramHttpRequest);
    if (localHttpResponseListener != null)
    {
      localHttpResponseListener.cancelled();
      removeFromConnectionsAndListeners(paramHttpRequest);
    }
  }

  Net.HttpResponseListener getFromListeners(Net.HttpRequest paramHttpRequest)
  {
    monitorenter;
    try
    {
      Net.HttpResponseListener localHttpResponseListener = (Net.HttpResponseListener)this.listeners.get(paramHttpRequest);
      monitorexit;
      return localHttpResponseListener;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void putIntoConnectionsAndListeners(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener, HttpURLConnection paramHttpURLConnection)
  {
    monitorenter;
    try
    {
      this.connections.put(paramHttpRequest, paramHttpURLConnection);
      this.listeners.put(paramHttpRequest, paramHttpResponseListener);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  void removeFromConnectionsAndListeners(Net.HttpRequest paramHttpRequest)
  {
    monitorenter;
    try
    {
      this.connections.remove(paramHttpRequest);
      this.listeners.remove(paramHttpRequest);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public void sendHttpRequest(Net.HttpRequest paramHttpRequest, Net.HttpResponseListener paramHttpResponseListener)
  {
    boolean bool = true;
    if (paramHttpRequest.getUrl() == null)
    {
      paramHttpResponseListener.failed(new GdxRuntimeException("can't process a HTTP request without URL set"));
      return;
    }
    try
    {
      String str1 = paramHttpRequest.getMethod();
      if (str1.equalsIgnoreCase("GET"))
      {
        String str2 = paramHttpRequest.getContent();
        if ((str2 == null) || ("".equals(str2)))
          break label324;
        str3 = "?" + str2;
        localURL = new URL(paramHttpRequest.getUrl() + str3);
        localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
        if ((!str1.equalsIgnoreCase("POST")) && (!str1.equalsIgnoreCase("PUT")))
          break label331;
        localHttpURLConnection.setDoOutput(bool);
        localHttpURLConnection.setDoInput(true);
        localHttpURLConnection.setRequestMethod(str1);
        HttpURLConnection.setFollowRedirects(paramHttpRequest.getFollowRedirects());
        putIntoConnectionsAndListeners(paramHttpRequest, paramHttpResponseListener, localHttpURLConnection);
        Iterator localIterator = paramHttpRequest.getHeaders().entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localHttpURLConnection.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        try
        {
          HttpURLConnection localHttpURLConnection;
          paramHttpResponseListener.failed(localException);
          return;
          URL localURL = new URL(paramHttpRequest.getUrl());
          continue;
          localHttpURLConnection.setConnectTimeout(paramHttpRequest.getTimeOut());
          localHttpURLConnection.setReadTimeout(paramHttpRequest.getTimeOut());
          this.asyncExecutor.submit(new NetJavaImpl.1(this, bool, paramHttpRequest, localHttpURLConnection, paramHttpResponseListener));
          return;
        }
        finally
        {
          removeFromConnectionsAndListeners(paramHttpRequest);
        }
        label324: String str3 = "";
        continue;
        label331: bool = false;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.NetJavaImpl
 * JD-Core Version:    0.6.0
 */