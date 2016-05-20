package com.google.android.gms.b;

import org.json.JSONException;
import org.json.JSONObject;

public class eZ
{
  private final is a;
  private final String b;

  public eZ(is paramis)
  {
    this(paramis, "");
  }

  public eZ(is paramis, String paramString)
  {
    this.a = paramis;
    this.b = paramString;
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.a.b("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occured while dispatching size change.", localJSONException);
    }
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      this.a.b("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occured while obtaining screen information.", localJSONException);
    }
  }

  public final void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("message", paramString).put("action", this.b);
      this.a.b("onError", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occurred while dispatching error event.", localJSONException);
    }
  }

  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.a.b("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occured while dispatching default position.", localJSONException);
    }
  }

  public final void b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("js", paramString);
      this.a.b("onReadyEventReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occured while dispatching ready Event.", localJSONException);
    }
  }

  public final void c(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("state", paramString);
      this.a.b("onStateChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Error occured while dispatching state change.", localJSONException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eZ
 * JD-Core Version:    0.6.0
 */