package com.google.android.gms.ads.internal;

import android.content.Intent;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.is;

final class d
  implements Runnable
{
  d(c paramc, Intent paramIntent)
  {
  }

  public final void run()
  {
    P.o();
    int i = com.google.android.gms.ads.internal.purchase.k.a(this.a);
    P.o();
    if ((i == 0) && (this.b.d.j != null) && (this.b.d.j.b != null) && (this.b.d.j.b.i() != null))
      this.b.d.j.b.i().a();
    this.b.d.E = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.d
 * JD-Core Version:    0.6.0
 */