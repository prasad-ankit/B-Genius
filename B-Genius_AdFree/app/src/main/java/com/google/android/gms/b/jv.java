package com.google.android.gms.b;

import android.os.SystemClock;

public final class jv
  implements ju
{
  private static jv a;

  public static ju d()
  {
    monitorenter;
    try
    {
      if (a == null)
        a = new jv();
      jv localjv = a;
      return localjv;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public final long a()
  {
    return System.currentTimeMillis();
  }

  public final long b()
  {
    return SystemClock.elapsedRealtime();
  }

  public final long c()
  {
    return System.nanoTime();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jv
 * JD-Core Version:    0.6.0
 */