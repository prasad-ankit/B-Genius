package com.badlogic.gdx;

import com.badlogic.gdx.utils.Pool.Poolable;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Net$HttpRequest
  implements Pool.Poolable
{
  private String content;
  private long contentLength;
  private InputStream contentStream;
  private boolean followRedirects = true;
  private Map headers = new HashMap();
  private String httpMethod;
  private int timeOut = 0;
  private String url;

  public Net$HttpRequest()
  {
  }

  public Net$HttpRequest(String paramString)
  {
    this();
    this.httpMethod = paramString;
  }

  public String getContent()
  {
    return this.content;
  }

  public long getContentLength()
  {
    return this.contentLength;
  }

  public InputStream getContentStream()
  {
    return this.contentStream;
  }

  public boolean getFollowRedirects()
  {
    return this.followRedirects;
  }

  public Map getHeaders()
  {
    return this.headers;
  }

  public String getMethod()
  {
    return this.httpMethod;
  }

  public int getTimeOut()
  {
    return this.timeOut;
  }

  public String getUrl()
  {
    return this.url;
  }

  public void reset()
  {
    this.httpMethod = null;
    this.url = null;
    this.headers.clear();
    this.timeOut = 0;
    this.content = null;
    this.contentStream = null;
    this.contentLength = 0L;
    this.followRedirects = true;
  }

  public void setContent(InputStream paramInputStream, long paramLong)
  {
    this.contentStream = paramInputStream;
    this.contentLength = paramLong;
  }

  public void setContent(String paramString)
  {
    this.content = paramString;
  }

  public void setFollowRedirects(boolean paramBoolean)
  {
    if ((paramBoolean == true) || (Gdx.app.getType() != Application.ApplicationType.WebGL))
    {
      this.followRedirects = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("Following redirects can't be disabled using the GWT/WebGL backend!");
  }

  public void setHeader(String paramString1, String paramString2)
  {
    this.headers.put(paramString1, paramString2);
  }

  public void setMethod(String paramString)
  {
    this.httpMethod = paramString;
  }

  public void setTimeOut(int paramInt)
  {
    this.timeOut = paramInt;
  }

  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Net.HttpRequest
 * JD-Core Version:    0.6.0
 */