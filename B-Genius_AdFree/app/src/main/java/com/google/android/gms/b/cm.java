package com.google.android.gms.b;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.a;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public final class cm
  implements bU
{
  private final Map a = new WeakHashMap();

  private static int a(Context paramContext, Map paramMap, String paramString, int paramInt)
  {
    String str = (String)paramMap.get(paramString);
    if (str != null);
    try
    {
      int i = com.google.android.gms.ads.internal.client.x.a().a(paramContext, Integer.parseInt(str));
      paramInt = i;
      return paramInt;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      hc.d("Could not parse " + paramString + " in a video GMSG: " + str);
    }
    return paramInt;
  }

  public final void a(is paramis, Map paramMap)
  {
    String str1 = (String)paramMap.get("action");
    if (str1 == null)
      hc.d("Action missing from video GMSG.");
    ir localir1;
    while (true)
    {
      return;
      if (hc.a(3))
      {
        JSONObject localJSONObject = new JSONObject(paramMap);
        localJSONObject.remove("google.afma.Notify_dt");
        hc.a("Video GMSG: " + str1 + " " + localJSONObject.toString());
      }
      if ("background".equals(str1))
      {
        String str4 = (String)paramMap.get("color");
        if (TextUtils.isEmpty(str4))
        {
          hc.d("Color parameter missing from color video GMSG.");
          return;
        }
        int i5;
        try
        {
          i5 = Color.parseColor(str4);
          ir localir2 = paramis.v();
          if (localir2 != null)
          {
            com.google.android.gms.ads.internal.overlay.x localx3 = localir2.a();
            if (localx3 != null)
            {
              localx3.setBackgroundColor(i5);
              return;
            }
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          hc.d("Invalid color parameter in video GMSG.");
          return;
        }
        this.a.put(paramis, Integer.valueOf(i5));
        return;
      }
      localir1 = paramis.v();
      if (localir1 == null)
      {
        hc.d("Could not get underlay container for a video GMSG.");
        return;
      }
      boolean bool1 = "new".equals(str1);
      boolean bool2 = "position".equals(str1);
      if ((!bool1) && (!bool2))
        break;
      Context localContext1 = paramis.getContext();
      int i = a(localContext1, paramMap, "x", 0);
      int j = a(localContext1, paramMap, "y", 0);
      int k = a(localContext1, paramMap, "w", -1);
      int m = a(localContext1, paramMap, "h", -1);
      try
      {
        int i2 = Integer.parseInt((String)paramMap.get("player"));
        n = i2;
        if ((bool1) && (localir1.a() == null))
        {
          localir1.a(i, j, k, m, n);
          if (!this.a.containsKey(paramis))
            continue;
          int i1 = ((Integer)this.a.get(paramis)).intValue();
          com.google.android.gms.ads.internal.overlay.x localx1 = localir1.a();
          localx1.setBackgroundColor(i1);
          localx1.k();
          return;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        while (true)
          int n = 0;
        localir1.a(i, j, k, m);
        return;
      }
    }
    com.google.android.gms.ads.internal.overlay.x localx2 = localir1.a();
    if (localx2 == null)
    {
      com.google.android.gms.ads.internal.overlay.x.a(paramis);
      return;
    }
    if ("click".equals(str1))
    {
      Context localContext2 = paramis.getContext();
      int i3 = a(localContext2, paramMap, "x", 0);
      int i4 = a(localContext2, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 0, i3, i4, 0);
      localx2.a(localMotionEvent);
      localMotionEvent.recycle();
      return;
    }
    if ("currentTime".equals(str1))
    {
      String str3 = (String)paramMap.get("time");
      if (str3 == null)
      {
        hc.d("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        localx2.a((int)(1000.0F * Float.parseFloat(str3)));
        return;
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        hc.d("Could not parse time parameter from currentTime video GMSG: " + str3);
        return;
      }
    }
    if ("hide".equals(str1))
    {
      localx2.setVisibility(4);
      return;
    }
    if ("load".equals(str1))
    {
      localx2.f();
      return;
    }
    if ("mimetype".equals(str1))
    {
      localx2.a((String)paramMap.get("mimetype"));
      return;
    }
    if ("muted".equals(str1))
    {
      if (Boolean.parseBoolean((String)paramMap.get("muted")))
      {
        localx2.i();
        return;
      }
      localx2.j();
      return;
    }
    if ("pause".equals(str1))
    {
      localx2.g();
      return;
    }
    if ("play".equals(str1))
    {
      localx2.h();
      return;
    }
    if ("show".equals(str1))
    {
      localx2.setVisibility(0);
      return;
    }
    if ("src".equals(str1))
    {
      localx2.b((String)paramMap.get("src"));
      return;
    }
    if ("volume".equals(str1))
    {
      String str2 = (String)paramMap.get("volume");
      if (str2 == null)
      {
        hc.d("Level parameter missing from volume video GMSG.");
        return;
      }
      try
      {
        localx2.a(Float.parseFloat(str2));
        return;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        hc.d("Could not parse volume parameter from volume video GMSG: " + str2);
        return;
      }
    }
    if ("watermark".equals(str1))
    {
      localx2.k();
      return;
    }
    hc.d("Unknown video action: " + str1);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cm
 * JD-Core Version:    0.6.0
 */