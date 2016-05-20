package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.ho;
import com.google.android.gms.b.v;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

final class r
  implements com.google.android.gms.b.r, Runnable
{
  private final List a = new Vector();
  private final AtomicReference b = new AtomicReference();
  private Q c;
  private CountDownLatch d = new CountDownLatch(1);

  public r(Q paramQ)
  {
    this.c = paramQ;
    x.a();
    if (a.b())
    {
      ho.a(this);
      return;
    }
    run();
  }

  private boolean a()
  {
    try
    {
      this.d.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      hc.c("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }

  private static Context b(Context paramContext)
  {
    au localau = aD.f;
    if (!((Boolean)P.n().a(localau)).booleanValue());
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    }
    while (localContext == null);
    return localContext;
  }

  private void b()
  {
    if (this.a.isEmpty())
      return;
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1)
      {
        ((Runnable)this.b.get()).a((MotionEvent)arrayOfObject[0]);
        continue;
      }
      if (arrayOfObject.length != 3)
        continue;
      ((Runnable)this.b.get()).a(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
    }
    this.a.clear();
  }

  public final String a(Context paramContext)
  {
    if (a())
    {
      com.google.android.gms.b.r localr = (Runnable)this.b.get();
      if (localr != null)
      {
        b();
        return localr.a(b(paramContext));
      }
    }
    return "";
  }

  public final String a(Context paramContext, String paramString)
  {
    if (a())
    {
      com.google.android.gms.b.r localr = (Runnable)this.b.get();
      if (localr != null)
      {
        b();
        return localr.a(b(paramContext), paramString);
      }
    }
    return "";
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    com.google.android.gms.b.r localr = (Runnable)this.b.get();
    if (localr != null)
    {
      b();
      localr.a(paramInt1, paramInt2, paramInt3);
      return;
    }
    List localList = this.a;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    localList.add(arrayOfObject);
  }

  public final void a(MotionEvent paramMotionEvent)
  {
    com.google.android.gms.b.r localr = (Runnable)this.b.get();
    if (localr != null)
    {
      b();
      localr.a(paramMotionEvent);
      return;
    }
    this.a.add(new Object[] { paramMotionEvent });
  }

  public final void run()
  {
    while (true)
    {
      try
      {
        au localau = aD.o;
        if (((Boolean)P.n().a(localau)).booleanValue())
        {
          if (!this.c.e.e)
            continue;
          break label104;
          v localv = v.a(this.c.e.b, b(this.c.c), bool);
          this.b.set(localv);
          return;
          bool = false;
          continue;
        }
      }
      finally
      {
        this.d.countDown();
        this.c = null;
      }
      label104: boolean bool = true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.r
 * JD-Core Version:    0.6.0
 */