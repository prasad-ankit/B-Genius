package com.google.android.gms.b;

import com.google.android.gms.ads.internal.overlay.k;
import java.util.Map;

final class bR
  implements bU
{
  public final void a(is paramis, Map paramMap)
  {
    k localk1 = paramis.i();
    if (localk1 != null)
    {
      localk1.a();
      return;
    }
    k localk2 = paramis.j();
    if (localk2 != null)
    {
      localk2.a();
      return;
    }
    hc.d("A GMSG tried to close something that wasn't an overlay.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.bR
 * JD-Core Version:    0.6.0
 */