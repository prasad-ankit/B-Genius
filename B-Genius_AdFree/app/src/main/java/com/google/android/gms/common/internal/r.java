package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.w;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class r
  implements Handler.Callback
{
  private final s a;
  private final ArrayList b = new ArrayList();
  private ArrayList c = new ArrayList();
  private final ArrayList d = new ArrayList();
  private volatile boolean e = false;
  private final AtomicInteger f = new AtomicInteger(0);
  private boolean g = false;
  private final Handler h;
  private final Object i = new Object();

  public r(Looper paramLooper, s params)
  {
    this.a = params;
    this.h = new Handler(paramLooper, this);
  }

  public final void a()
  {
    this.e = false;
    this.f.incrementAndGet();
  }

  public final void a(int paramInt)
  {
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = this.h.getLooper();
    boolean bool = false;
    if (localLooper1 == localLooper2)
      bool = true;
    w.a(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.h.removeMessages(1);
    synchronized (this.i)
    {
      this.g = true;
      ArrayList localArrayList = new ArrayList(this.b);
      int j = this.f.get();
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if ((!this.e) || (this.f.get() != j))
          break;
        if (!this.b.contains(localj))
          continue;
        localj.a(paramInt);
      }
    }
    this.c.clear();
    this.g = false;
    monitorexit;
  }

  public final void a(Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2;
    if (Looper.myLooper() == this.h.getLooper())
    {
      bool2 = bool1;
      w.a(bool2, "onConnectionSuccess must only be called on the Handler thread");
    }
    while (true)
    {
      synchronized (this.i)
      {
        if (this.g)
          break label192;
        bool3 = bool1;
        w.b(bool3);
        this.h.removeMessages(1);
        this.g = true;
        if (this.c.size() != 0)
          break label198;
        w.b(bool1);
        ArrayList localArrayList = new ArrayList(this.b);
        int j = this.f.get();
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext())
          break label203;
        j localj = (j)localIterator.next();
        if ((!this.e) || (!this.a.e()) || (this.f.get() != j))
          break label203;
        if (this.c.contains(localj))
          continue;
        localj.a(paramBundle);
      }
      bool2 = false;
      break;
      label192: boolean bool3 = false;
      continue;
      label198: bool1 = false;
    }
    label203: this.c.clear();
    this.g = false;
    monitorexit;
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.h.getLooper());
    for (boolean bool = true; ; bool = false)
    {
      w.a(bool, "onConnectionFailure must only be called on the Handler thread");
      this.h.removeMessages(1);
      synchronized (this.i)
      {
        ArrayList localArrayList = new ArrayList(this.d);
        int j = this.f.get();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          k localk = (k)localIterator.next();
          if ((!this.e) || (this.f.get() != j))
            return;
          if (!this.d.contains(localk))
            continue;
          localk.a(paramConnectionResult);
        }
      }
      monitorexit;
      return;
    }
  }

  public final void a(j paramj)
  {
    w.a(paramj);
    synchronized (this.i)
    {
      if (this.b.contains(paramj))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramj + " is already registered");
        if (this.a.e())
          this.h.sendMessage(this.h.obtainMessage(1, paramj));
        return;
      }
      this.b.add(paramj);
    }
  }

  public final void a(k paramk)
  {
    w.a(paramk);
    synchronized (this.i)
    {
      if (this.d.contains(paramk))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramk + " is already registered");
        return;
      }
      this.d.add(paramk);
    }
  }

  public final void b()
  {
    this.e = true;
  }

  public final void b(k paramk)
  {
    w.a(paramk);
    synchronized (this.i)
    {
      if (!this.d.remove(paramk))
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramk + " not found");
      return;
    }
  }

  public final boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      j localj = (j)paramMessage.obj;
      synchronized (this.i)
      {
        if ((this.e) && (this.a.e()) && (this.b.contains(localj)))
          localj.a(this.a.b_());
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle message: " + paramMessage.what, new Exception());
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.r
 * JD-Core Version:    0.6.0
 */