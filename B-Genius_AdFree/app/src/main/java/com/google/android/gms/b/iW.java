package com.google.android.gms.b;

import android.support.v4.app.z;
import android.util.Log;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.clearcut.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.m;
import java.util.concurrent.TimeUnit;

public final class iW
  implements f
{
  private static final jd a;
  private static final long b;
  private final ju c;
  private final Object d = new Object();
  private long e = 0L;
  private g f = null;

  static
  {
    new Object();
    a = new jd(0);
    b = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
  }

  public iW()
  {
    this(new jv(), b, new iZ());
  }

  private iW(ju paramju, long paramLong, iZ paramiZ)
  {
    new iX(this);
    this.c = paramju;
  }

  private static void b(LogEventParcelable paramLogEventParcelable)
  {
    if ((paramLogEventParcelable.f != null) && (paramLogEventParcelable.e.e.length == 0))
      paramLogEventParcelable.e.e = paramLogEventParcelable.f.a();
    if ((paramLogEventParcelable.g != null) && (paramLogEventParcelable.e.h.length == 0))
      paramLogEventParcelable.e.h = paramLogEventParcelable.g.a();
    paramLogEventParcelable.c = ku.a(paramLogEventParcelable.e);
  }

  public final m a(g paramg, LogEventParcelable paramLogEventParcelable)
  {
    b(paramLogEventParcelable);
    a.a();
    jb localjb = new jb(this, paramLogEventParcelable, paramg);
    localjb.a(new iY(this));
    return paramg.a(localjb);
  }

  public final boolean a(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = a.a(paramLong, paramTimeUnit);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.e("ClearcutLoggerApiImpl", "flush interrupted");
      Thread.currentThread().interrupt();
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.iW
 * JD-Core Version:    0.6.0
 */