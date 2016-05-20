package com.google.android.gms.b;

public final class kr
  implements Cloneable
{
  private static final ks a = new ks();
  private boolean b = false;
  private int[] c;
  private ks[] d;
  private int e;

  kr()
  {
    this(10);
  }

  private kr(int paramInt)
  {
    int i = b(paramInt << 2) / 4;
    this.c = new int[i];
    this.d = new ks[i];
    this.e = 0;
  }

  private static int b(int paramInt)
  {
    for (int i = 4; ; i++)
    {
      if (i < 32)
      {
        if (paramInt > -12 + (1 << i))
          continue;
        paramInt = -12 + (1 << i);
      }
      return paramInt;
    }
  }

  final int a()
  {
    return this.e;
  }

  final ks a(int paramInt)
  {
    return this.d[paramInt];
  }

  public final boolean b()
  {
    return this.e == 0;
  }

  public final kr c()
  {
    int i = 0;
    int j = this.e;
    kr localkr = new kr(j);
    System.arraycopy(this.c, 0, localkr.c, 0, j);
    while (i < j)
    {
      if (this.d[i] != null)
        localkr.d[i] = this.d[i].b();
      i++;
    }
    localkr.e = j;
    return localkr;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    label147: label153: label157: 
    while (true)
    {
      return true;
      if (!(paramObject instanceof kr))
        return false;
      kr localkr = (kr)paramObject;
      if (this.e != localkr.e)
        return false;
      int[] arrayOfInt1 = this.c;
      int[] arrayOfInt2 = localkr.c;
      int i = this.e;
      int j = 0;
      int k;
      label76: int n;
      if (j < i)
        if (arrayOfInt1[j] != arrayOfInt2[j])
        {
          k = 0;
          if (k != 0)
          {
            ks[] arrayOfks1 = this.d;
            ks[] arrayOfks2 = localkr.d;
            int m = this.e;
            n = 0;
            label102: if (n >= m)
              break label153;
            if (arrayOfks1[n].equals(arrayOfks2[n]))
              break label147;
          }
        }
      for (int i1 = 0; ; i1 = 1)
      {
        if (i1 != 0)
          break label157;
        return false;
        j++;
        break;
        k = 1;
        break label76;
        n++;
        break label102;
      }
    }
  }

  public final int hashCode()
  {
    int i = 17;
    for (int j = 0; j < this.e; j++)
      i = 31 * (i * 31 + this.c[j]) + this.d[j].hashCode();
    return i;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.kr
 * JD-Core Version:    0.6.0
 */