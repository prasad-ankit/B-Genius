package com.google.android.gms.b;

import android.support.v4.app.w;
import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class gc
  implements bU
{
  gc(gb paramgb, dh paramdh, gi paramgi, ic paramic)
  {
  }

  public final void a(is paramis, Map paramMap)
  {
    this.a.b("/nativeAdPreProcess", this.b.a);
    try
    {
      String str = (String)paramMap.get("success");
      if (!TextUtils.isEmpty(str))
      {
        this.c.b(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      hc.b("Malformed native JSON response.", localJSONException);
      this.d.a(0);
      w.a(this.d.a(), "Unable to set the ad state error!");
      this.c.b(null);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gc
 * JD-Core Version:    0.6.0
 */