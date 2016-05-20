package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class fX extends fP
{
  protected ec f;
  private el g;
  private dU h;
  private dW i;
  private final aR j;
  private final is k;
  private boolean l;

  fX(Context paramContext, gT paramgT, el paramel, fU paramfU, aR paramaR, is paramis)
  {
    super(paramContext, paramgT, paramfU);
    this.g = paramel;
    this.i = paramgT.c;
    this.j = paramaR;
    this.k = paramis;
  }

  protected final gS a(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = this.d.a;
    AdRequestParcel localAdRequestParcel = localAdRequestInfoParcel.c;
    is localis = this.k;
    List localList1 = this.e.d;
    List localList2 = this.e.f;
    List localList3 = this.e.j;
    int m = this.e.l;
    long l1 = this.e.k;
    String str1 = localAdRequestInfoParcel.i;
    boolean bool = this.e.h;
    dV localdV;
    eo localeo;
    label111: String str2;
    label127: dW localdW;
    if (this.f != null)
    {
      localdV = this.f.b;
      if (this.f == null)
        break label269;
      localeo = this.f.c;
      if (this.f == null)
        break label275;
      str2 = this.f.d;
      localdW = this.i;
      if (this.f == null)
        break label285;
    }
    label269: label275: label285: for (dY localdY = this.f.e; ; localdY = null)
    {
      return new gS(localAdRequestParcel, localis, localList1, paramInt, localList2, localList3, m, l1, str1, bool, localdV, localeo, str2, localdW, localdY, this.e.i, this.d.d, this.e.g, this.d.f, this.e.n, this.e.o, this.d.h, null, this.e.D, this.e.E, this.e.F, this.e.G);
      localdV = null;
      break;
      localeo = null;
      break label111;
      str2 = AdMobAdapter.class.getName();
      break label127;
    }
  }

  protected final void a(long paramLong)
  {
    synchronized (this.c)
    {
      Object localObject3;
      if (this.i.h != -1)
      {
        Context localContext2 = this.a;
        AdRequestInfoParcel localAdRequestInfoParcel2 = this.d.a;
        el localel2 = this.g;
        dW localdW2 = this.i;
        boolean bool3 = this.e.t;
        boolean bool4 = this.e.C;
        au localau2 = aD.aa;
        localObject3 = new ef(localContext2, localAdRequestInfoParcel2, localel2, localdW2, bool3, bool4, paramLong, ((Long)P.n().a(localau2)).longValue(), 2);
        this.h = ((dU)localObject3);
        this.f = this.h.a(this.i.a);
      }
      switch (this.f.a)
      {
      default:
        throw new fS("Unexpected mediation result: " + this.f.a, 0);
        Context localContext1 = this.a;
        AdRequestInfoParcel localAdRequestInfoParcel1 = this.d.a;
        el localel1 = this.g;
        dW localdW1 = this.i;
        boolean bool1 = this.e.t;
        boolean bool2 = this.e.C;
        au localau1 = aD.aa;
        localObject3 = new ei(localContext1, localAdRequestInfoParcel1, localel1, localdW1, bool1, bool2, paramLong, ((Long)P.n().a(localau1)).longValue(), this.j);
      case 1:
      case 0:
      }
    }
    throw new fS("No fill from any mediation ad networks.", 3);
    if ((this.f.b != null) && (this.f.b.i != null))
    {
      CountDownLatch localCountDownLatch = new CountDownLatch(1);
      hu.a.post(new fY(this, localCountDownLatch));
      try
      {
        localCountDownLatch.await(10L, TimeUnit.SECONDS);
        synchronized (this.c)
        {
          if (!this.l)
            throw new fS("View could not be prepared", 0);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new fS("Interrupted while waiting for latch : " + localInterruptedException, 0);
      }
      if (this.k.r())
        throw new fS("Assets not loaded, web view is destroyed", 0);
      monitorexit;
    }
  }

  public final void b()
  {
    synchronized (this.c)
    {
      super.b();
      if (this.h != null)
        this.h.a();
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fX
 * JD-Core Version:    0.6.0
 */