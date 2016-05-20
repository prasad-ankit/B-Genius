package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.support.v4.app.w;
import android.view.View;
import com.google.android.gms.ads.internal.H;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.dh;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.y;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private final H a;
  private final JSONObject b;
  private final dh c;
  private final h d;
  private WeakReference e;

  public g(Context paramContext, H paramH, dh paramdh, y paramy, JSONObject paramJSONObject, h paramh, VersionInfoParcel paramVersionInfoParcel)
  {
    new Object();
    this.e = null;
    this.a = paramH;
    this.c = paramdh;
    this.b = paramJSONObject;
    this.d = paramh;
  }

  public void a()
  {
    w.b("recordImpression must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ad", this.b);
      this.c.a("google.afma.nativeAds.handleImpressionPing", localJSONObject);
      this.a.a(this);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        hc.b("Unable to create impression JSON.", localJSONException);
    }
  }

  public void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    w.b("performClick must be called on the main UI thread.");
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("asset", paramString);
      localJSONObject1.put("template", this.d.j());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("ad", this.b);
      localJSONObject2.put("click", localJSONObject1);
      if (this.a.b(this.d.k()) != null);
      for (boolean bool = true; ; bool = false)
      {
        localJSONObject2.put("has_custom_click_handler", bool);
        this.c.a("google.afma.nativeAds.handleClickGmsg", localJSONObject2);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      hc.b("Unable to create click JSON.", localJSONException);
    }
  }

  public View b()
  {
    return null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.g
 * JD-Core Version:    0.6.0
 */