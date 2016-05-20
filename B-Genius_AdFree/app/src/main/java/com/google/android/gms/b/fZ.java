package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.H;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class fZ extends ha
{
  private final fU a;
  private final AdResponseParcel b;
  private final gT c;
  private final gb d;
  private final Object e = new Object();
  private Future f;

  public fZ(Context paramContext, H paramH, dj paramdj, gT paramgT, y paramy, fU paramfU)
  {
    this(paramgT, paramfU, new gb(paramContext, paramH, paramdj, new hN(paramContext), paramy, paramgT));
  }

  private fZ(gT paramgT, fU paramfU, gb paramgb)
  {
    this.c = paramgT;
    this.b = paramgT.b;
    this.a = paramfU;
    this.d = paramgb;
  }

  public final void a()
  {
    int i = -2;
    try
    {
      synchronized (this.e)
      {
        this.f = ho.a(this.d);
        localgS = (gS)this.f.get(60000L, TimeUnit.MILLISECONDS);
        if (localgS != null)
        {
          hu.a.post(new ga(this, localgS));
          return;
        }
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
      {
        hc.d("Timed out waiting for native ad.");
        i = 2;
        this.f.cancel(true);
        localgS = null;
      }
    }
    catch (ExecutionException localExecutionException)
    {
      while (true)
      {
        localgS = null;
        i = 0;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        i = -1;
        localgS = null;
      }
    }
    catch (CancellationException localCancellationException)
    {
      while (true)
      {
        i = -1;
        gS localgS = null;
        continue;
        localgS = new gS(this.c.a.c, null, null, i, null, null, this.b.l, this.b.k, this.c.a.i, false, null, null, null, null, null, this.b.i, this.c.d, this.b.g, this.c.f, this.b.n, this.b.o, this.c.h, null, null, null, null, this.c.b.G);
      }
    }
  }

  public final void b()
  {
    synchronized (this.e)
    {
      if (this.f != null)
        this.f.cancel(true);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fZ
 * JD-Core Version:    0.6.0
 */