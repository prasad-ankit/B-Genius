package com.google.android.gms.b;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

public final class cf
  implements bU
{
  private HashMap a = new HashMap();

  public final Future a(String paramString)
  {
    ic localic = new ic();
    this.a.put(paramString, localic);
    return localic;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("request_id");
    String str2 = (String)paramMap.get("fetched_ad");
    hc.a("Received ad from the cache.");
    ic localic = (ic)this.a.get(str1);
    if (localic == null)
    {
      hc.b("Could not find the ad request for the corresponding ad response.");
      return;
    }
    try
    {
      localic.b(new JSONObject(str2));
      return;
    }
    catch (JSONException localJSONException)
    {
      hc.b("Failed constructing JSON object from value passed from javascript", localJSONException);
      localic.b(null);
      return;
    }
    finally
    {
      this.a.remove(str1);
    }
    throw localObject;
  }

  public final void b(String paramString)
  {
    ic localic = (ic)this.a.get(paramString);
    if (localic == null)
    {
      hc.b("Could not find the ad request for the corresponding ad response.");
      return;
    }
    if (!localic.isDone())
      localic.cancel(true);
    this.a.remove(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cf
 * JD-Core Version:    0.6.0
 */