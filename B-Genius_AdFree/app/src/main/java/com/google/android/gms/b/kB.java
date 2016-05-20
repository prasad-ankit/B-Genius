package com.google.android.gms.b;

public final class kB extends kp
{
  private static volatile kB[] a;
  private String b = "";
  private String c = "";

  public kB()
  {
    this.f = null;
    this.E = -1;
  }

  public static kB[] e()
  {
    if (a == null);
    synchronized (kt.a)
    {
      if (a == null)
        a = new kB[0];
      return a;
    }
  }

  protected final int a()
  {
    int i = super.a();
    if (!this.b.equals(""))
      i += kn.b(1, this.b);
    if (!this.c.equals(""))
      i += kn.b(2, this.c);
    return i;
  }

  public final void a(kn paramkn)
  {
    if (!this.b.equals(""))
      paramkn.a(1, this.b);
    if (!this.c.equals(""))
      paramkn.a(2, this.c);
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    kB localkB;
    while (true)
    {
      return true;
      if (!(paramObject instanceof kB))
        return false;
      localkB = (kB)paramObject;
      if (this.b == null)
      {
        if (localkB.b != null)
          return false;
      }
      else if (!this.b.equals(localkB.b))
        return false;
      if (this.c == null)
      {
        if (localkB.c != null)
          return false;
      }
      else if (!this.c.equals(localkB.c))
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localkB.f != null) && (!localkB.f.b()))
        return false;
    }
    return this.f.equals(localkB.f);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int n;
    int i1;
    if (this.b == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.c != null)
        break label101;
      m = 0;
      n = 31 * (m + k);
      kr localkr = this.f;
      i1 = 0;
      if (localkr != null)
      {
        boolean bool = this.f.b();
        i1 = 0;
        if (!bool)
          break label113;
      }
    }
    while (true)
    {
      return n + i1;
      j = this.b.hashCode();
      break;
      label101: m = this.c.hashCode();
      break label44;
      label113: i1 = this.f.hashCode();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kB
 * JD-Core Version:    0.6.0
 */