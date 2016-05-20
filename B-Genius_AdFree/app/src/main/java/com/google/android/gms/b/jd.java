package com.google.android.gms.b;

import java.util.concurrent.TimeUnit;

final class jd
{
  private int a = 0;

  public final void a()
  {
    monitorenter;
    try
    {
      this.a = (1 + this.a);
      monitorexit;
      return;
    }
    finally
    {
      localObject = finally;
      monitorexit;
    }
    throw localObject;
  }

  public final boolean a(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = System.currentTimeMillis();
    long l2 = TimeUnit.MILLISECONDS.convert(paramLong, paramTimeUnit);
    monitorenter;
    while (true)
    {
      try
      {
        if (this.a == 0)
          return true;
        if (l2 <= 0L)
          return false;
      }
      finally
      {
        monitorexit;
      }
      wait(l2);
      long l3 = System.currentTimeMillis();
      l2 -= l3 - l1;
    }
  }

  public final void b()
  {
    monitorenter;
    try
    {
      if (this.a == 0)
        throw new RuntimeException("too many decrements");
    }
    finally
    {
      monitorexit;
    }
    this.a = (-1 + this.a);
    if (this.a == 0)
      notifyAll();
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jd
 * JD-Core Version:    0.6.0
 */