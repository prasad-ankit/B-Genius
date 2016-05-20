package com.google.ads.a.a;

import com.google.android.gms.b.kn;
import com.google.android.gms.b.kt;
import com.google.android.gms.b.ku;

public final class c extends ku
{
  private static volatile c[] c;
  public Long a = null;
  public Long b = null;

  public c()
  {
    this.E = -1;
  }

  public static c[] a_()
  {
    if (c == null);
    synchronized (kt.a)
    {
      if (c == null)
        c = new c[0];
      return c;
    }
  }

  protected final int a()
  {
    int i = super.a();
    if (this.a != null)
      i += kn.c(1, this.a.longValue());
    if (this.b != null)
      i += kn.c(2, this.b.longValue());
    return i;
  }

  public final void a(kn paramkn)
  {
    if (this.a != null)
      paramkn.a(1, this.a.longValue());
    if (this.b != null)
      paramkn.a(2, this.b.longValue());
    super.a(paramkn);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.a.a.c
 * JD-Core Version:    0.6.0
 */