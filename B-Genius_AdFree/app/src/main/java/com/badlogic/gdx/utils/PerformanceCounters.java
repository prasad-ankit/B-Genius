package com.badlogic.gdx.utils;

public class PerformanceCounters
{
  private static final float nano2seconds = 1.0E-009F;
  public final Array counters = new Array();
  private long lastTick = 0L;

  public PerformanceCounter add(String paramString)
  {
    PerformanceCounter localPerformanceCounter = new PerformanceCounter(paramString);
    this.counters.add(localPerformanceCounter);
    return localPerformanceCounter;
  }

  public PerformanceCounter add(String paramString, int paramInt)
  {
    PerformanceCounter localPerformanceCounter = new PerformanceCounter(paramString, paramInt);
    this.counters.add(localPerformanceCounter);
    return localPerformanceCounter;
  }

  public void tick()
  {
    long l = TimeUtils.nanoTime();
    if (this.lastTick > 0L)
      tick(1.0E-009F * (float)(l - this.lastTick));
    this.lastTick = l;
  }

  public void tick(float paramFloat)
  {
    for (int i = 0; i < this.counters.size; i++)
      ((PerformanceCounter)this.counters.get(i)).tick(paramFloat);
  }

  public StringBuilder toString(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.setLength(0);
    for (int i = 0; i < this.counters.size; i++)
    {
      if (i != 0)
        paramStringBuilder.append("; ");
      ((PerformanceCounter)this.counters.get(i)).toString(paramStringBuilder);
    }
    return paramStringBuilder;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.PerformanceCounters
 * JD-Core Version:    0.6.0
 */