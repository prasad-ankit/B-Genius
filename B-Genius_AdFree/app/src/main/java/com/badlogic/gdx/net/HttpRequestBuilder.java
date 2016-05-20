package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.utils.Base64Coder;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pools;
import java.io.InputStream;
import java.util.Map;

public class HttpRequestBuilder
{
  public static String baseUrl = "";
  public static int defaultTimeout = 1000;
  public static Json json = new Json();
  private Net.HttpRequest httpRequest;

  private void validate()
  {
    if (this.httpRequest == null)
      throw new IllegalStateException("A new request has not been started yet. Call HttpRequestBuilder.newRequest() first.");
  }

  public HttpRequestBuilder basicAuthentication(String paramString1, String paramString2)
  {
    validate();
    this.httpRequest.setHeader("Authorization", "Basic " + Base64Coder.encodeString(new StringBuilder().append(paramString1).append(":").append(paramString2).toString()));
    return this;
  }

  public Net.HttpRequest build()
  {
    validate();
    Net.HttpRequest localHttpRequest = this.httpRequest;
    this.httpRequest = null;
    return localHttpRequest;
  }

  public HttpRequestBuilder content(InputStream paramInputStream, long paramLong)
  {
    validate();
    this.httpRequest.setContent(paramInputStream, paramLong);
    return this;
  }

  public HttpRequestBuilder content(String paramString)
  {
    validate();
    this.httpRequest.setContent(paramString);
    return this;
  }

  public HttpRequestBuilder followRedirects(boolean paramBoolean)
  {
    validate();
    this.httpRequest.setFollowRedirects(paramBoolean);
    return this;
  }

  public HttpRequestBuilder formEncodedContent(Map paramMap)
  {
    validate();
    this.httpRequest.setHeader("Content-Type", "application/x-www-form-urlencoded");
    String str = HttpParametersUtils.convertHttpParameters(paramMap);
    this.httpRequest.setContent(str);
    return this;
  }

  public HttpRequestBuilder header(String paramString1, String paramString2)
  {
    validate();
    this.httpRequest.setHeader(paramString1, paramString2);
    return this;
  }

  public HttpRequestBuilder jsonContent(Object paramObject)
  {
    validate();
    this.httpRequest.setHeader("Content-Type", "application/json");
    String str = json.toJson(paramObject);
    this.httpRequest.setContent(str);
    return this;
  }

  public HttpRequestBuilder method(String paramString)
  {
    validate();
    this.httpRequest.setMethod(paramString);
    return this;
  }

  public HttpRequestBuilder newRequest()
  {
    if (this.httpRequest != null)
      throw new IllegalStateException("A new request has already been started. Call HttpRequestBuilder.build() first.");
    this.httpRequest = ((Net.HttpRequest)Pools.obtain(Net.HttpRequest.class));
    this.httpRequest.setTimeOut(defaultTimeout);
    return this;
  }

  public HttpRequestBuilder timeout(int paramInt)
  {
    validate();
    this.httpRequest.setTimeOut(paramInt);
    return this;
  }

  public HttpRequestBuilder url(String paramString)
  {
    validate();
    this.httpRequest.setUrl(baseUrl + paramString);
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.HttpRequestBuilder
 * JD-Core Version:    0.6.0
 */