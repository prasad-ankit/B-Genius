package com.badlogic.gdx.utils;

public class Bits
{
  long[] bits = { 0L };

  public Bits()
  {
  }

  public Bits(int paramInt)
  {
    checkCapacity(paramInt >>> 6);
  }

  private void checkCapacity(int paramInt)
  {
    if (paramInt >= this.bits.length)
    {
      long[] arrayOfLong = new long[paramInt + 1];
      System.arraycopy(this.bits, 0, arrayOfLong, 0, this.bits.length);
      this.bits = arrayOfLong;
    }
  }

  public void and(Bits paramBits)
  {
    int i = Math.min(this.bits.length, paramBits.bits.length);
    for (int j = 0; i > j; j++)
    {
      long[] arrayOfLong = this.bits;
      arrayOfLong[j] &= paramBits.bits[j];
    }
    if (this.bits.length > i)
    {
      int k = this.bits.length;
      while (k > i)
      {
        this.bits[i] = 0L;
        i++;
      }
    }
  }

  public void andNot(Bits paramBits)
  {
    int i = 0;
    int j = this.bits.length;
    int k = paramBits.bits.length;
    while ((i < j) && (i < k))
    {
      long[] arrayOfLong = this.bits;
      arrayOfLong[i] &= (0xFFFFFFFF ^ paramBits.bits[i]);
      i++;
    }
  }

  public void clear()
  {
    long[] arrayOfLong = this.bits;
    int i = arrayOfLong.length;
    for (int j = 0; j < i; j++)
      arrayOfLong[j] = 0L;
  }

  public void clear(int paramInt)
  {
    int i = paramInt >>> 6;
    if (i >= this.bits.length)
      return;
    long[] arrayOfLong = this.bits;
    arrayOfLong[i] &= (0xFFFFFFFF ^ 1L << (paramInt & 0x3F));
  }

  public boolean containsAll(Bits paramBits)
  {
    long[] arrayOfLong1 = this.bits;
    long[] arrayOfLong2 = paramBits.bits;
    int i = arrayOfLong2.length;
    int j = arrayOfLong1.length;
    for (int k = j; k < i; k++)
      if (arrayOfLong2[k] != 0L)
        return false;
    for (int m = -1 + Math.min(j, i); ; m--)
    {
      if (m < 0)
        break label85;
      if ((arrayOfLong1[m] & arrayOfLong2[m]) != arrayOfLong2[m])
        break;
    }
    label85: return true;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Bits localBits;
    long[] arrayOfLong;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localBits = (Bits)paramObject;
      arrayOfLong = localBits.bits;
      int i = Math.min(this.bits.length, arrayOfLong.length);
      for (int j = 0; i > j; j++)
        if (this.bits[j] != arrayOfLong[j])
          return false;
    }
    while ((this.bits.length == arrayOfLong.length) || (length() == localBits.length()));
    return false;
  }

  public void flip(int paramInt)
  {
    int i = paramInt >>> 6;
    checkCapacity(i);
    long[] arrayOfLong = this.bits;
    arrayOfLong[i] ^= 1L << (paramInt & 0x3F);
  }

  public boolean get(int paramInt)
  {
    int i = paramInt >>> 6;
    if (i >= this.bits.length);
    do
      return false;
    while ((this.bits[i] & 1L << (paramInt & 0x3F)) == 0L);
    return true;
  }

  public boolean getAndClear(int paramInt)
  {
    int i = paramInt >>> 6;
    if (i >= this.bits.length);
    long l;
    do
    {
      return false;
      l = this.bits[i];
      long[] arrayOfLong = this.bits;
      arrayOfLong[i] &= (0xFFFFFFFF ^ 1L << (paramInt & 0x3F));
    }
    while (this.bits[i] == l);
    return true;
  }

  public boolean getAndSet(int paramInt)
  {
    int i = paramInt >>> 6;
    checkCapacity(i);
    long l = this.bits[i];
    long[] arrayOfLong = this.bits;
    arrayOfLong[i] |= 1L << (paramInt & 0x3F);
    return this.bits[i] == l;
  }

  public int hashCode()
  {
    int i = 0;
    int j = length() >>> 6;
    int k = 0;
    while (j >= i)
    {
      k = k * 127 + (int)(this.bits[i] ^ this.bits[i] >>> 32);
      i++;
    }
    return k;
  }

  public boolean intersects(Bits paramBits)
  {
    long[] arrayOfLong1 = this.bits;
    long[] arrayOfLong2 = paramBits.bits;
    for (int i = -1 + Math.min(arrayOfLong1.length, arrayOfLong2.length); i >= 0; i--)
      if ((arrayOfLong1[i] & arrayOfLong2[i]) != 0L)
        return true;
    return false;
  }

  public boolean isEmpty()
  {
    long[] arrayOfLong = this.bits;
    int i = arrayOfLong.length;
    for (int j = 0; j < i; j++)
      if (arrayOfLong[j] != 0L)
        return false;
    return true;
  }

  public int length()
  {
    long[] arrayOfLong = this.bits;
    for (int i = -1 + arrayOfLong.length; i >= 0; i--)
    {
      long l = arrayOfLong[i];
      if (l == 0L)
        continue;
      for (int j = 63; j >= 0; j--)
        if ((l & 1L << (j & 0x3F)) != 0L)
          return 1 + (j + (i << 6));
    }
    return 0;
  }

  public int nextClearBit(int paramInt)
  {
    long[] arrayOfLong = this.bits;
    int i = paramInt >>> 6;
    int j = arrayOfLong.length;
    if (i >= j)
      return arrayOfLong.length << 6;
    long l1 = arrayOfLong[i];
    for (int k = paramInt & 0x3F; k < 64; k++)
      if ((l1 & 1L << (k & 0x3F)) == 0L)
        return k + (i << 6);
    for (int m = i + 1; m < j; m++)
    {
      if (m == 0)
        return m << 6;
      long l2 = arrayOfLong[m];
      for (int n = 0; n < 64; n++)
        if ((l2 & 1L << (n & 0x3F)) == 0L)
          return n + (m << 6);
    }
    return arrayOfLong.length << 6;
  }

  public int nextSetBit(int paramInt)
  {
    long[] arrayOfLong = this.bits;
    int i = paramInt >>> 6;
    int j = arrayOfLong.length;
    if (i >= j)
      return -1;
    long l1 = arrayOfLong[i];
    if (l1 != 0L)
      for (int n = paramInt & 0x3F; n < 64; n++)
        if ((l1 & 1L << (n & 0x3F)) != 0L)
          return n + (i << 6);
    for (int k = i + 1; k < j; k++)
    {
      if (k == 0)
        continue;
      long l2 = arrayOfLong[k];
      if (l2 == 0L)
        continue;
      for (int m = 0; m < 64; m++)
        if ((l2 & 1L << (m & 0x3F)) != 0L)
          return m + (k << 6);
    }
    return -1;
  }

  public int numBits()
  {
    return this.bits.length << 6;
  }

  public void or(Bits paramBits)
  {
    int i = Math.min(this.bits.length, paramBits.bits.length);
    for (int j = 0; i > j; j++)
    {
      long[] arrayOfLong = this.bits;
      arrayOfLong[j] |= paramBits.bits[j];
    }
    if (i < paramBits.bits.length)
    {
      checkCapacity(paramBits.bits.length);
      int k = paramBits.bits.length;
      while (k > i)
      {
        this.bits[i] = paramBits.bits[i];
        i++;
      }
    }
  }

  public void set(int paramInt)
  {
    int i = paramInt >>> 6;
    checkCapacity(i);
    long[] arrayOfLong = this.bits;
    arrayOfLong[i] |= 1L << (paramInt & 0x3F);
  }

  public void xor(Bits paramBits)
  {
    int i = Math.min(this.bits.length, paramBits.bits.length);
    for (int j = 0; i > j; j++)
    {
      long[] arrayOfLong = this.bits;
      arrayOfLong[j] ^= paramBits.bits[j];
    }
    if (i < paramBits.bits.length)
    {
      checkCapacity(paramBits.bits.length);
      int k = paramBits.bits.length;
      while (k > i)
      {
        this.bits[i] = paramBits.bits[i];
        i++;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Bits
 * JD-Core Version:    0.6.0
 */