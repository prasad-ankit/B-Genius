package com.google.android.gms.b;

import com.google.android.gms.ads.internal.P;
import java.util.Map;

public final class eS
{
  private final is a;
  private final boolean b;
  private final String c;

  public eS(is paramis, Map paramMap)
  {
    this.a = paramis;
    this.c = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      this.b = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    this.b = true;
  }

  public final void a()
  {
    if (this.a == null)
    {
      hc.d("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(this.c))
      i = P.g().b();
    while (true)
    {
      this.a.b(i);
      return;
      if ("landscape".equalsIgnoreCase(this.c))
      {
        i = P.g().a();
        continue;
      }
      if (this.b)
      {
        i = -1;
        continue;
      }
      i = P.g().c();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eS
 * JD-Core Version:    0.6.0
 */