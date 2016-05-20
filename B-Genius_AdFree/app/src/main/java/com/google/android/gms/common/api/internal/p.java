package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.support.v4.app.w;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.l;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

final class p
  implements l
{
  private final WeakReference a;
  private final a b;
  private final int c;

  public p(n paramn, a parama, int paramInt)
  {
    this.a = new WeakReference(paramn);
    this.b = parama;
    this.c = paramInt;
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    n localn = (n)this.a.get();
    if (localn == null)
      return;
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = n.d(localn).d.a();
    boolean bool1 = false;
    if (localLooper1 == localLooper2)
      bool1 = true;
    w.a(bool1, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
    n.c(localn).lock();
    try
    {
      boolean bool2 = n.a(localn, 0);
      if (!bool2)
        return;
      if (!paramConnectionResult.b())
        n.a(localn, paramConnectionResult, this.b, this.c);
      if (n.k(localn))
        n.j(localn);
      return;
    }
    finally
    {
      n.c(localn).unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.p
 * JD-Core Version:    0.6.0
 */