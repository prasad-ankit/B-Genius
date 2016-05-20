package com.badlogic.gdx.utils;

public final class TimeUtils
{
  private static final long nanosPerMilli = 1000000L;

  public static long millis()
  {
    return System.currentTimeMillis();
  }

  public static long millisToNanos(long paramLong)
  {
    return 1000000L * paramLong;
  }

  public static long nanoTime()
  {
    return System.nanoTime();
  }

  public static long nanosToMillis(long paramLong)
  {
    return paramLong / 1000000L;
  }

  public static long timeSinceMillis(long paramLong)
  {
    return millis() - paramLong;
  }

  public static long timeSinceNanos(long paramLong)
  {
    return nanoTime() - paramLong;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.TimeUtils
 * JD-Core Version:    0.6.0
 */