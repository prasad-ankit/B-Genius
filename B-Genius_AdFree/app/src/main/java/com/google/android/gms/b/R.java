package com.google.android.gms.b;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

public class R
{
  private final Object a = new Object();
  private final WeakHashMap b = new WeakHashMap();
  private final ArrayList c = new ArrayList();
  private final Context d;
  private final VersionInfoParcel e;
  private final du f;

  public R(Context paramContext, VersionInfoParcel paramVersionInfoParcel, du paramdu)
  {
    this.d = paramContext.getApplicationContext();
    this.e = paramVersionInfoParcel;
    this.f = paramdu;
  }

  public G a(AdSizeParcel paramAdSizeParcel, gS paramgS)
  {
    return a(paramAdSizeParcel, paramgS, paramgS.b.b());
  }

  public G a(AdSizeParcel paramAdSizeParcel, gS paramgS, View paramView)
  {
    return a(paramAdSizeParcel, paramgS, new O(paramView, paramgS), null);
  }

  public G a(AdSizeParcel paramAdSizeParcel, gS paramgS, View paramView, dR paramdR)
  {
    return a(paramAdSizeParcel, paramgS, new O(paramView, paramgS), paramdR);
  }

  public G a(AdSizeParcel paramAdSizeParcel, gS paramgS, g paramg)
  {
    return a(paramAdSizeParcel, paramgS, new L(paramg), null);
  }

  public G a(AdSizeParcel paramAdSizeParcel, gS paramgS, ac paramac, dR paramdR)
  {
    while (true)
    {
      synchronized (this.a)
      {
        if (!a(paramgS))
          continue;
        G localG = (G)this.b.get(paramgS);
        return localG;
        if (paramdR != null)
        {
          localObject3 = new S(this.d, paramAdSizeParcel, paramgS, this.e, paramac, paramdR);
          ((G)localObject3).a(this);
          this.b.put(paramgS, localObject3);
          this.c.add(localObject3);
          return localObject3;
        }
      }
      Object localObject3 = new V(this.d, paramAdSizeParcel, paramgS, this.e, paramac, this.f);
    }
  }

  public void a(G paramG)
  {
    synchronized (this.a)
    {
      if (!paramG.e())
      {
        this.c.remove(paramG);
        Iterator localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          if (((Map.Entry)localIterator.next()).getValue() != paramG)
            continue;
          localIterator.remove();
        }
      }
    }
    monitorexit;
  }

  public boolean a(gS paramgS)
  {
    while (true)
    {
      synchronized (this.a)
      {
        G localG = (G)this.b.get(paramgS);
        if ((localG != null) && (localG.e()))
        {
          i = 1;
          return i;
        }
      }
      int i = 0;
    }
  }

  public void b(gS paramgS)
  {
    synchronized (this.a)
    {
      G localG = (G)this.b.get(paramgS);
      if (localG != null)
        localG.c();
      return;
    }
  }

  public void c(gS paramgS)
  {
    synchronized (this.a)
    {
      G localG = (G)this.b.get(paramgS);
      if (localG != null)
        localG.g();
      return;
    }
  }

  public void d(gS paramgS)
  {
    synchronized (this.a)
    {
      G localG = (G)this.b.get(paramgS);
      if (localG != null)
        localG.h();
      return;
    }
  }

  public void e(gS paramgS)
  {
    synchronized (this.a)
    {
      G localG = (G)this.b.get(paramgS);
      if (localG != null)
        localG.i();
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.R
 * JD-Core Version:    0.6.0
 */