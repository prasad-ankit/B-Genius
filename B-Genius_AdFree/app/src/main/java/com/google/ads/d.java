package com.google.ads;

import com.google.android.gms.ads.f;

public final class d
{
  public static final d a = new d(-1, -2);
  public static final d b = new d(320, 50);
  public static final d c = new d(300, 250);
  public static final d d = new d(468, 60);
  public static final d e = new d(728, 90);
  public static final d f = new d(160, 600);
  private final f g;

  private d(int paramInt1, int paramInt2)
  {
    this(new f(paramInt1, paramInt2));
  }

  public d(f paramf)
  {
    this.g = paramf;
  }

  public final int a()
  {
    return this.g.b();
  }

  public final int b()
  {
    return this.g.a();
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof d))
      return false;
    d locald = (d)paramObject;
    return this.g.equals(locald.g);
  }

  public final int hashCode()
  {
    return this.g.hashCode();
  }

  public final String toString()
  {
    return this.g.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.d
 * JD-Core Version:    0.6.0
 */