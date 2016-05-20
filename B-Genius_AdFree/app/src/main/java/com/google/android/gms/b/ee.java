package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.internal.P;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ee
{
  public static List a(JSONObject paramJSONObject, String paramString)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray(paramString);
    if (localJSONArray != null)
    {
      ArrayList localArrayList = new ArrayList(localJSONArray.length());
      for (int i = 0; i < localJSONArray.length(); i++)
        localArrayList.add(localJSONArray.getString(i));
      return Collections.unmodifiableList(localArrayList);
    }
    return null;
  }

  public static void a(Context paramContext, String paramString1, gS paramgS, String paramString2, boolean paramBoolean, List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return;
    if (paramBoolean);
    for (String str1 = "1"; ; str1 = "0")
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str2 = ((String)localIterator.next()).replaceAll("@gw_adlocid@", paramString2).replaceAll("@gw_adnetrefresh@", str1).replaceAll("@gw_qdata@", paramgS.q.f).replaceAll("@gw_sdkver@", paramString1).replaceAll("@gw_sessid@", P.h().a()).replaceAll("@gw_seqnum@", paramgS.i);
        if (paramgS.n != null)
          str2 = str2.replaceAll("@gw_adnetid@", paramgS.n.b).replaceAll("@gw_allocid@", paramgS.n.d);
        new hX(paramContext, paramString1, str2).g();
      }
      break;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ee
 * JD-Core Version:    0.6.0
 */