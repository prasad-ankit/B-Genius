package com.google.android.gms.b;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;

final class bK
  implements bU
{
  public final void a(is paramis, Map paramMap)
  {
    String str = (String)paramMap.get("u");
    if (str == null)
    {
      hc.d("URL missing from httpTrack GMSG.");
      return;
    }
    new hX(paramis.getContext(), paramis.o().b, str).g();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bK
 * JD-Core Version:    0.6.0
 */