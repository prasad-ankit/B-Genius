package com.badlogic.gdx.math;

import java.util.Random;

public class RandomXS128 extends Random
{
  private static final double NORM_DOUBLE = 1.110223024625157E-016D;
  private static final double NORM_FLOAT = 5.960464477539063E-008D;
  private long seed0;
  private long seed1;

  public RandomXS128()
  {
    setSeed(new Random().nextLong());
  }

  public RandomXS128(long paramLong)
  {
    setSeed(paramLong);
  }

  public RandomXS128(long paramLong1, long paramLong2)
  {
    setState(paramLong1, paramLong2);
  }

  private static final long murmurHash3(long paramLong)
  {
    long l1 = -49064778989728563L * (paramLong ^ paramLong >>> 33);
    long l2 = -4265267296055464877L * (l1 ^ l1 >>> 33);
    return l2 ^ l2 >>> 33;
  }

  public long getState(int paramInt)
  {
    if (paramInt == 0)
      return this.seed0;
    return this.seed1;
  }

  protected final int next(int paramInt)
  {
    return (int)(nextLong() & (1L << paramInt) - 1L);
  }

  public boolean nextBoolean()
  {
    return (1L & nextLong()) != 0L;
  }

  public void nextBytes(byte[] paramArrayOfByte)
  {
    int k;
    for (int i = paramArrayOfByte.length; i != 0; i = k)
    {
      if (i < 8);
      for (int j = i; ; j = 8)
      {
        long l1 = nextLong();
        k = i;
        int m = j;
        long l2 = l1;
        while (true)
        {
          int n = m - 1;
          if (m == 0)
            break;
          k--;
          paramArrayOfByte[k] = (byte)(int)l2;
          l2 >>= 8;
          m = n;
        }
      }
    }
  }

  public double nextDouble()
  {
    return 1.110223024625157E-016D * (nextLong() >>> 11);
  }

  public float nextFloat()
  {
    return (float)(5.960464477539063E-008D * (nextLong() >>> 40));
  }

  public int nextInt()
  {
    return (int)nextLong();
  }

  public int nextInt(int paramInt)
  {
    return (int)nextLong(paramInt);
  }

  public long nextLong()
  {
    long l1 = this.seed0;
    long l2 = this.seed1;
    this.seed0 = l2;
    long l3 = l1 ^ l1 << 23;
    long l4 = l3 ^ l2 ^ l3 >>> 17 ^ l2 >>> 26;
    this.seed1 = l4;
    return l4 + l2;
  }

  public long nextLong(long paramLong)
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("n must be positive");
    long l1;
    long l2;
    do
    {
      l1 = nextLong() >>> 1;
      l2 = l1 % paramLong;
    }
    while (l1 - l2 + (paramLong - 1L) < 0L);
    return l2;
  }

  public void setSeed(long paramLong)
  {
    if (paramLong == 0L)
      paramLong = -9223372036854775808L;
    long l = murmurHash3(paramLong);
    setState(l, murmurHash3(l));
  }

  public void setState(long paramLong1, long paramLong2)
  {
    this.seed0 = paramLong1;
    this.seed1 = paramLong2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.RandomXS128
 * JD-Core Version:    0.6.0
 */