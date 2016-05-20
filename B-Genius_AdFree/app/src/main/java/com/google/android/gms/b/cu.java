package com.google.android.gms.b;

import android.support.v4.app.j;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.k;
import java.util.Map;

public final class cu
  implements bU
{
  public final void a(is paramis, Map paramMap)
  {
    cp localcp = P.t();
    if (paramMap.containsKey("abort"))
    {
      if (!localcp.a(paramis))
        hc.d("Precache abort but no preload task running.");
      return;
    }
    String str = (String)paramMap.get("src");
    if (str == null)
    {
      hc.d("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      Integer.parseInt((String)paramMap.get("player"));
      label68: if (paramMap.containsKey("mimetype"))
        paramMap.get("mimetype");
      if (localcp.b(paramis))
      {
        hc.d("Precache task already running.");
        return;
      }
      j.a(paramis.h());
      new cn(paramis, paramis.h().a.a(paramis), str).g();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label68;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cu
 * JD-Core Version:    0.6.0
 */