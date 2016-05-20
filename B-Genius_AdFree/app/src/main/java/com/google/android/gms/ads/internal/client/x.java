package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.a.j;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.bC;

public final class x
{
  private static final Object a = new Object();
  private static x b;
  private final a c = new a();
  private final p d = new p();
  private final v e = new v();

  static
  {
    x localx = new x();
    synchronized (a)
    {
      b = localx;
      return;
    }
  }

  protected x()
  {
    new f();
    new bC();
    new j();
  }

  public static a a()
  {
    return d().c;
  }

  public static p b()
  {
    return d().d;
  }

  public static v c()
  {
    return d().e;
  }

  private static x d()
  {
    synchronized (a)
    {
      x localx = b;
      return localx;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.x
 * JD-Core Version:    0.6.0
 */