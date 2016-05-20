package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.b.k;
import android.util.Log;

public final class f
{
  private final long a;
  private final int b;
  private final k c;

  public f()
  {
    this.a = 60000L;
    this.b = 10;
    this.c = new k(10);
  }

  public f(int paramInt, long paramLong)
  {
    this.a = paramLong;
    this.b = 1024;
    this.c = new k();
  }

  public final Long a(String paramString)
  {
    long l1 = SystemClock.elapsedRealtime();
    long l2 = this.a;
    monitorenter;
    long l3 = l2;
    while (true)
    {
      int i;
      try
      {
        if (this.c.size() < this.b)
          continue;
        i = -1 + this.c.size();
        if (i < 0)
          continue;
        if (l1 - ((Long)this.c.c(i)).longValue() > l3)
        {
          this.c.d(i);
          break label161;
          long l4 = l3 / 2L;
          Log.w("ConnectionTracker", "The max capacity " + this.b + " is not enough. Current durationThreshold is: " + l4);
          l3 = l4;
          continue;
          Long localLong = (Long)this.c.put(paramString, Long.valueOf(l1));
          return localLong;
        }
      }
      finally
      {
        monitorexit;
      }
      label161: i--;
    }
  }

  public final boolean b(String paramString)
  {
    monitorenter;
    while (true)
    {
      try
      {
        if (this.c.remove(paramString) != null)
        {
          i = 1;
          return i;
        }
      }
      finally
      {
        monitorexit;
      }
      int i = 0;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.f
 * JD-Core Version:    0.6.0
 */