package com.google.android.gms.b;

import java.util.Map;

final class dz
  implements bU
{
  dz(dv paramdv, dh paramdh)
  {
  }

  public final void a(is paramis, Map paramMap)
  {
    synchronized (du.c(this.b.b))
    {
      if ((this.b.a.e() == -1) || (this.b.a.e() == 1))
        return;
      du.a(this.b.b, 0);
      du.d(this.b.b).a(this.a);
      this.b.a.a(this.a);
      du.a(this.b.b, this.b.a);
      hc.e("Successfully loaded JS Engine.");
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dz
 * JD-Core Version:    0.6.0
 */