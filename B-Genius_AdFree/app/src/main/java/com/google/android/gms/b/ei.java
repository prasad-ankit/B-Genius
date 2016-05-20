package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ei
  implements dU
{
  private final AdRequestInfoParcel a;
  private final el b;
  private final Context c;
  private final Object d = new Object();
  private final dW e;
  private final boolean f;
  private final long g;
  private final long h;
  private final aR i;
  private final boolean j;
  private boolean k = false;
  private dZ l;

  public ei(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, el paramel, dW paramdW, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, aR paramaR)
  {
    this.c = paramContext;
    this.a = paramAdRequestInfoParcel;
    this.b = paramel;
    this.e = paramdW;
    this.f = paramBoolean1;
    this.j = paramBoolean2;
    this.g = paramLong1;
    this.h = paramLong2;
    this.i = paramaR;
  }

  public final ec a(List paramList)
  {
    hc.a("Starting mediation.");
    ArrayList localArrayList = new ArrayList();
    aN localaN1 = this.i.a();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      dV localdV = (dV)localIterator1.next();
      hc.c("Trying mediation network: " + localdV.b);
      Iterator localIterator2 = localdV.c.iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        aN localaN2 = this.i.a();
        ec localec2;
        synchronized (this.d)
        {
          if (this.k)
          {
            ec localec1 = new ec(-1);
            return localec1;
          }
          this.l = new dZ(this.c, str, this.b, this.e, localdV, this.a.c, this.a.d, this.a.k, this.f, this.j, this.a.z, this.a.n);
          localec2 = this.l.a(this.g, this.h);
          if (localec2.a == 0)
          {
            hc.a("Adapter succeeded.");
            this.i.a("mediation_network_succeed", str);
            if (!localArrayList.isEmpty())
              this.i.a("mediation_networks_fail", TextUtils.join(",", localArrayList));
            this.i.a(localaN2, new String[] { "mls" });
            this.i.a(localaN1, new String[] { "ttm" });
            return localec2;
          }
        }
        localArrayList.add(str);
        this.i.a(localaN2, new String[] { "mlf" });
        if (localec2.c == null)
          continue;
        hu.a.post(new ej(this, localec2));
      }
    }
    if (!localArrayList.isEmpty())
      this.i.a("mediation_networks_fail", TextUtils.join(",", localArrayList));
    return new ec(1);
  }

  public final void a()
  {
    synchronized (this.d)
    {
      this.k = true;
      if (this.l != null)
        this.l.a();
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ei
 * JD-Core Version:    0.6.0
 */