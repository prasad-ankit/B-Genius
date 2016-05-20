package com.google.android.gms.b;

public final class kx extends kp
{
  private String[] a = kw.c;
  private String[] b = kw.c;
  private int[] c = kw.a;
  private long[] d = kw.b;

  public kx()
  {
    this.f = null;
    this.E = -1;
  }

  protected final int a()
  {
    int i = 0;
    int j = super.a();
    int i6;
    int i7;
    if ((this.a != null) && (this.a.length > 0))
    {
      int i5 = 0;
      i6 = 0;
      i7 = 0;
      while (i5 < this.a.length)
      {
        String str2 = this.a[i5];
        if (str2 != null)
        {
          i7++;
          i6 += kn.a(str2);
        }
        i5++;
      }
    }
    for (int k = j + i6 + i7 * 1; ; k = j)
    {
      if ((this.b != null) && (this.b.length > 0))
      {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < this.b.length)
        {
          String str1 = this.b[i2];
          if (str1 != null)
          {
            i4++;
            i3 += kn.a(str1);
          }
          i2++;
        }
        k = k + i3 + i4 * 1;
      }
      if ((this.c != null) && (this.c.length > 0))
      {
        int n = 0;
        int i1 = 0;
        while (n < this.c.length)
        {
          i1 += kn.a(this.c[n]);
          n++;
        }
        k = k + i1 + 1 * this.c.length;
      }
      if ((this.d != null) && (this.d.length > 0))
      {
        int m = 0;
        while (i < this.d.length)
        {
          m += kn.a(this.d[i]);
          i++;
        }
        k = k + m + 1 * this.d.length;
      }
      return k;
    }
  }

  public final void a(kn paramkn)
  {
    if ((this.a != null) && (this.a.length > 0))
      for (int n = 0; n < this.a.length; n++)
      {
        String str2 = this.a[n];
        if (str2 == null)
          continue;
        paramkn.a(1, str2);
      }
    if ((this.b != null) && (this.b.length > 0))
      for (int m = 0; m < this.b.length; m++)
      {
        String str1 = this.b[m];
        if (str1 == null)
          continue;
        paramkn.a(2, str1);
      }
    if ((this.c != null) && (this.c.length > 0))
      for (int k = 0; k < this.c.length; k++)
        paramkn.a(3, this.c[k]);
    if (this.d != null)
    {
      int i = this.d.length;
      int j = 0;
      if (i > 0)
        while (j < this.d.length)
        {
          paramkn.a(4, this.d[j]);
          j++;
        }
    }
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    kx localkx;
    while (true)
    {
      return true;
      if (!(paramObject instanceof kx))
        return false;
      localkx = (kx)paramObject;
      if (!kt.a(this.a, localkx.a))
        return false;
      if (!kt.a(this.b, localkx.b))
        return false;
      if (!kt.a(this.c, localkx.c))
        return false;
      if (!kt.a(this.d, localkx.d))
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localkx.f != null) && (!localkx.f.b()))
        return false;
    }
    return this.f.equals(localkx.f);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 * (31 * (31 * (527 + getClass().getName().hashCode()) + kt.a(this.a)) + kt.a(this.b)) + kt.a(this.c)) + kt.a(this.d));
    if ((this.f == null) || (this.f.b()));
    for (int j = 0; ; j = this.f.hashCode())
      return j + i;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kx
 * JD-Core Version:    0.6.0
 */