package com.badlogic.gdx.math;

import java.util.Random;

public final class MathUtils
{
  private static final double BIG_ENOUGH_CEIL = 16384.999999999996D;
  private static final double BIG_ENOUGH_FLOOR = 16384.0D;
  private static final int BIG_ENOUGH_INT = 16384;
  private static final double BIG_ENOUGH_ROUND = 16384.5D;
  private static final double CEIL = 0.9999999000000001D;
  public static final float E = 2.718282F;
  public static final float FLOAT_ROUNDING_ERROR = 1.0E-006F;
  public static final float PI = 3.141593F;
  public static final float PI2 = 6.283186F;
  private static final int SIN_BITS = 14;
  private static final int SIN_COUNT = 16384;
  private static final int SIN_MASK = 16383;
  private static final float degFull = 360.0F;
  public static final float degRad = 0.01745329F;
  private static final float degToIndex = 45.511112F;
  public static final float degreesToRadians = 0.01745329F;
  public static final float nanoToSec = 1.0E-009F;
  public static final float radDeg = 57.295776F;
  private static final float radFull = 6.283186F;
  private static final float radToIndex = 2607.5945F;
  public static final float radiansToDegrees = 57.295776F;
  public static Random random = new RandomXS128();

  public static float atan2(float paramFloat1, float paramFloat2)
  {
    float f1 = 1.570796F;
    if (paramFloat2 == 0.0F)
      if (paramFloat1 <= 0.0F);
    do
    {
      float f2;
      while (true)
      {
        return f1;
        if (paramFloat1 == 0.0F)
          return 0.0F;
        return -1.570796F;
        f2 = paramFloat1 / paramFloat2;
        if (Math.abs(f2) >= 1.0F)
          break;
        f1 = f2 / (1.0F + f2 * (0.28F * f2));
        if (paramFloat2 >= 0.0F)
          continue;
        if (paramFloat1 < 0.0F)
          return f1 - 3.141593F;
        return f1 + 3.141593F;
      }
      f1 -= f2 / (0.28F + f2 * f2);
    }
    while (paramFloat1 >= 0.0F);
    return f1 - 3.141593F;
  }

  public static int ceil(float paramFloat)
  {
    return -16384 + (int)(16384.999999999996D + paramFloat);
  }

  public static int ceilPositive(float paramFloat)
  {
    return (int)(0.9999999000000001D + paramFloat);
  }

  public static double clamp(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramDouble1 < paramDouble2)
      return paramDouble2;
    if (paramDouble1 > paramDouble3)
      return paramDouble3;
    return paramDouble1;
  }

  public static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2)
      return paramFloat2;
    if (paramFloat1 > paramFloat3)
      return paramFloat3;
    return paramFloat1;
  }

  public static int clamp(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
      return paramInt2;
    if (paramInt1 > paramInt3)
      return paramInt3;
    return paramInt1;
  }

  public static long clamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 < paramLong2)
      return paramLong2;
    if (paramLong1 > paramLong3)
      return paramLong3;
    return paramLong1;
  }

  public static short clamp(short paramShort1, short paramShort2, short paramShort3)
  {
    if (paramShort1 < paramShort2)
      return paramShort2;
    if (paramShort1 > paramShort3)
      return paramShort3;
    return paramShort1;
  }

  public static float cos(float paramFloat)
  {
    return MathUtils.Sin.table[(0x3FFF & (int)(2607.5945F * (1.570796F + paramFloat)))];
  }

  public static float cosDeg(float paramFloat)
  {
    return MathUtils.Sin.table[(0x3FFF & (int)(45.511112F * (90.0F + paramFloat)))];
  }

  public static int floor(float paramFloat)
  {
    return -16384 + (int)(16384.0D + paramFloat);
  }

  public static int floorPositive(float paramFloat)
  {
    return (int)paramFloat;
  }

  public static boolean isEqual(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) <= 1.0E-006F;
  }

  public static boolean isEqual(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.abs(paramFloat1 - paramFloat2) <= paramFloat3;
  }

  public static boolean isPowerOfTwo(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & paramInt - 1) == 0);
  }

  public static boolean isZero(float paramFloat)
  {
    return Math.abs(paramFloat) <= 1.0E-006F;
  }

  public static boolean isZero(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1) <= paramFloat2;
  }

  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }

  public static float lerpAngle(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (6.283186F + (paramFloat1 + paramFloat3 * ((3.141593F + (6.283186F + (paramFloat2 - paramFloat1))) % 6.283186F - 3.141593F))) % 6.283186F;
  }

  public static float lerpAngleDeg(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (360.0F + (paramFloat1 + paramFloat3 * ((180.0F + (360.0F + (paramFloat2 - paramFloat1))) % 360.0F - 180.0F))) % 360.0F;
  }

  public static float log(float paramFloat1, float paramFloat2)
  {
    return (float)(Math.log(paramFloat2) / Math.log(paramFloat1));
  }

  public static float log2(float paramFloat)
  {
    return log(2.0F, paramFloat);
  }

  public static int nextPowerOfTwo(int paramInt)
  {
    if (paramInt == 0)
      return 1;
    int i = paramInt - 1;
    int j = i | i >> 1;
    int k = j | j >> 2;
    int m = k | k >> 4;
    int n = m | m >> 8;
    return 1 + (n | n >> 16);
  }

  public static float random()
  {
    return random.nextFloat();
  }

  public static float random(float paramFloat)
  {
    return paramFloat * random.nextFloat();
  }

  public static float random(float paramFloat1, float paramFloat2)
  {
    return paramFloat1 + random.nextFloat() * (paramFloat2 - paramFloat1);
  }

  public static int random(int paramInt)
  {
    return random.nextInt(paramInt + 1);
  }

  public static int random(int paramInt1, int paramInt2)
  {
    return paramInt1 + random.nextInt(1 + (paramInt2 - paramInt1));
  }

  public static long random(long paramLong)
  {
    return ()(random.nextDouble() * paramLong);
  }

  public static long random(long paramLong1, long paramLong2)
  {
    return paramLong1 + ()(random.nextDouble() * (paramLong2 - paramLong1));
  }

  public static boolean randomBoolean()
  {
    return random.nextBoolean();
  }

  public static boolean randomBoolean(float paramFloat)
  {
    return random() < paramFloat;
  }

  public static int randomSign()
  {
    return 0x1 | random.nextInt() >> 31;
  }

  public static float randomTriangular()
  {
    return random.nextFloat() - random.nextFloat();
  }

  public static float randomTriangular(float paramFloat)
  {
    return paramFloat * (random.nextFloat() - random.nextFloat());
  }

  public static float randomTriangular(float paramFloat1, float paramFloat2)
  {
    return randomTriangular(paramFloat1, paramFloat2, 0.5F * (paramFloat1 + paramFloat2));
  }

  public static float randomTriangular(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = random.nextFloat();
    float f2 = paramFloat2 - paramFloat1;
    if (f1 <= (paramFloat3 - paramFloat1) / f2)
      return paramFloat1 + (float)Math.sqrt(f1 * f2 * (paramFloat3 - paramFloat1));
    return paramFloat2 - (float)Math.sqrt(f2 * (1.0F - f1) * (paramFloat2 - paramFloat3));
  }

  public static int round(float paramFloat)
  {
    return -16384 + (int)(16384.5D + paramFloat);
  }

  public static int roundPositive(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  public static float sin(float paramFloat)
  {
    return MathUtils.Sin.table[(0x3FFF & (int)(2607.5945F * paramFloat))];
  }

  public static float sinDeg(float paramFloat)
  {
    return MathUtils.Sin.table[(0x3FFF & (int)(45.511112F * paramFloat))];
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.MathUtils
 * JD-Core Version:    0.6.0
 */