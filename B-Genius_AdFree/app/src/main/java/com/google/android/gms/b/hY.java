package com.google.android.gms.b;

import com.google.android.gms.ads.internal.P;

public final class hY
{
  private long a;
  private long b = -9223372036854775808L;
  private Object c = new Object();

  public hY(long paramLong)
  {
    this.a = paramLong;
  }

  public final boolean a()
  {
    synchronized (this.c)
    {
      long l = P.i().b();
      if (this.b + this.a > l)
        return false;
      this.b = l;
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hY
 * JD-Core Version:    0.6.0
 */