package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.fF;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class c extends ha
  implements ServiceConnection
{
  private final Object a = new Object();
  private boolean b = false;
  private Context c;
  private fF d;
  private b e;
  private i f;
  private List g = null;
  private n h;

  public c(Context paramContext, fF paramfF, n paramn)
  {
    this(paramContext, paramfF, paramn, new b(paramContext), i.a(paramContext.getApplicationContext()));
  }

  private c(Context paramContext, fF paramfF, n paramn, b paramb, i parami)
  {
    this.c = paramContext;
    this.d = paramfF;
    this.h = paramn;
    this.e = paramb;
    this.f = parami;
    this.g = this.f.a(10L);
  }

  private void a(long paramLong)
  {
    do
    {
      if (b(paramLong))
        continue;
      hc.e("Timeout waiting for pending transaction to be processed.");
    }
    while (!this.b);
  }

  private boolean b(long paramLong)
  {
    long l = 60000L - (SystemClock.elapsedRealtime() - paramLong);
    if (l <= 0L)
      return false;
    try
    {
      this.a.wait(l);
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        hc.d("waitWithTimeout_lock interrupted");
    }
  }

  public final void a()
  {
    synchronized (this.a)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      com.google.android.gms.common.stats.b.a().a(this.c, localIntent, this, 1);
      a(SystemClock.elapsedRealtime());
      com.google.android.gms.common.stats.b.a().a(this.c, this);
      this.e.a = null;
      return;
    }
  }

  public final void b()
  {
    synchronized (this.a)
    {
      com.google.android.gms.common.stats.b.a().a(this.c, this);
      this.e.a = null;
      return;
    }
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    HashMap localHashMap;
    synchronized (this.a)
    {
      this.e.a(paramIBinder);
      if (this.g.isEmpty())
        break label413;
      localHashMap = new HashMap();
      Iterator localIterator1 = this.g.iterator();
      if (localIterator1.hasNext())
      {
        g localg2 = (g)localIterator1.next();
        localHashMap.put(localg2.c, localg2);
      }
    }
    Object localObject3 = null;
    Bundle localBundle = this.e.b(this.c.getPackageName(), (String)localObject3);
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    String str2;
    if (localBundle != null)
    {
      P.o();
      if (k.a(localBundle) == 0)
      {
        localArrayList1 = localBundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
        localArrayList2 = localBundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        localArrayList3 = localBundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        str2 = localBundle.getString("INAPP_CONTINUATION_TOKEN");
      }
    }
    for (int i = 0; ; i++)
      if (i < localArrayList1.size())
      {
        if (!localHashMap.containsKey(localArrayList1.get(i)))
          continue;
        String str3 = (String)localArrayList1.get(i);
        String str4 = (String)localArrayList2.get(i);
        String str5 = (String)localArrayList3.get(i);
        g localg1 = (g)localHashMap.get(str3);
        P.o();
        String str6 = k.a(str4);
        if (!localg1.b.equals(str6))
          continue;
        Intent localIntent = new Intent();
        P.o();
        localIntent.putExtra("RESPONSE_CODE", 0);
        P.o();
        localIntent.putExtra("INAPP_PURCHASE_DATA", str4);
        P.o();
        localIntent.putExtra("INAPP_DATA_SIGNATURE", str5);
        hu.a.post(new d(this, localg1, localIntent));
        localHashMap.remove(str3);
      }
      else
      {
        if ((str2 == null) || (localHashMap.isEmpty()))
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str1 = (String)localIterator2.next();
            this.f.a((g)localHashMap.get(str1));
          }
          label413: this.b = true;
          this.a.notify();
          monitorexit;
          return;
        }
        localObject3 = str2;
        break;
      }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    hc.c("In-app billing service disconnected.");
    this.e.a = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.c
 * JD-Core Version:    0.6.0
 */