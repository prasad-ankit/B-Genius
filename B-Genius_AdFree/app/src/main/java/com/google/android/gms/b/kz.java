package com.google.android.gms.b;

import java.util.Arrays;

public final class kz extends kp
{
  private byte[] a = kw.e;
  private byte[][] b = kw.d;
  private boolean c = false;

  public kz()
  {
    this.f = null;
    this.E = -1;
  }

  protected final int a()
  {
    int i = 0;
    int j = super.a();
    if (!Arrays.equals(this.a, kw.e))
      j += kn.b(1, this.a);
    if ((this.b != null) && (this.b.length > 0))
    {
      int k = 0;
      int m = 0;
      while (i < this.b.length)
      {
        byte[] arrayOfByte = this.b[i];
        if (arrayOfByte != null)
        {
          m++;
          k += kn.b(arrayOfByte);
        }
        i++;
      }
      j = j + k + m * 1;
    }
    return j;
  }

  public final void a(kn paramkn)
  {
    if (!Arrays.equals(this.a, kw.e))
      paramkn.a(1, this.a);
    if ((this.b != null) && (this.b.length > 0))
      for (int i = 0; i < this.b.length; i++)
      {
        byte[] arrayOfByte = this.b[i];
        if (arrayOfByte == null)
          continue;
        paramkn.a(2, arrayOfByte);
      }
    super.a(paramkn);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    kz localkz;
    while (true)
    {
      return true;
      if (!(paramObject instanceof kz))
        return false;
      localkz = (kz)paramObject;
      if (!Arrays.equals(this.a, localkz.a))
        return false;
      if (!kt.a(this.b, localkz.b))
        return false;
      if ((this.f != null) && (!this.f.b()))
        break;
      if ((localkz.f != null) && (!localkz.f.b()))
        return false;
    }
    return this.f.equals(localkz.f);
  }

  public final int hashCode()
  {
    int i = 31 * (1237 + 31 * (31 * (31 * (527 + getClass().getName().hashCode()) + Arrays.hashCode(this.a)) + kt.a(this.b)));
    if ((this.f == null) || (this.f.b()));
    for (int j = 0; ; j = this.f.hashCode())
      return j + i;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kz
 * JD-Core Version:    0.6.0
 */