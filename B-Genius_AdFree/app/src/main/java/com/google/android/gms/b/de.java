package com.google.android.gms.b;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.v;
import java.util.Iterator;
import java.util.LinkedList;

final class de
{
  v a;
  MutableContextWrapper b;
  cy c;
  long d;
  boolean e;
  boolean f;

  de(dd paramdd, cx paramcx)
  {
    cx localcx = paramcx.a();
    this.b = paramcx.b();
    this.a = localcx.a(dd.a(paramdd));
    this.c = new cy();
    cy localcy = this.c;
    v localv = this.a;
    localv.a(new cz(localcy));
    localv.a(new cF(localcy));
    localv.a(new cH(localcy));
    localv.a(new cJ(localcy));
    localv.a(new cL(localcy));
    localv.a(new cN(localcy));
  }

  private void a()
  {
    if ((!this.e) && (dd.c(this.g) != null))
    {
      this.f = this.a.a(dd.c(this.g));
      this.e = true;
      this.d = P.i().a();
    }
  }

  final void a(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel != null)
      dd.a(this.g, paramAdRequestParcel);
    a();
    Iterator localIterator = dd.b(this.g).iterator();
    while (localIterator.hasNext())
      ((de)localIterator.next()).a();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.de
 * JD-Core Version:    0.6.0
 */