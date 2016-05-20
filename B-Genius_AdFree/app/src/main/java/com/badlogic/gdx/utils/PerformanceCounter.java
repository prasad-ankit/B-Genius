package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.FloatCounter;

public class PerformanceCounter
{
  private static final float nano2seconds = 1.0E-009F;
  public float current = 0.0F;
  private long lastTick = 0L;
  public final FloatCounter load;
  public final String name;
  private long startTime = 0L;
  public final FloatCounter time;
  public boolean valid = false;

  public PerformanceCounter(String paramString)
  {
    this(paramString, 5);
  }

  public PerformanceCounter(String paramString, int paramInt)
  {
    this.name = paramString;
    this.time = new FloatCounter(paramInt);
    this.load = new FloatCounter(1);
  }

  public void reset()
  {
    this.time.reset();
    this.load.reset();
    this.startTime = 0L;
    this.lastTick = 0L;
    this.current = 0.0F;
    this.valid = false;
  }

  public void start()
  {
    this.startTime = TimeUtils.nanoTime();
    this.valid = false;
  }

  public void stop()
  {
    if (this.startTime > 0L)
    {
      this.current += 1.0E-009F * (float)(TimeUtils.nanoTime() - this.startTime);
      this.startTime = 0L;
      this.valid = true;
    }
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
    if (!this.valid)
    {
      Gdx.app.error("PerformanceCounter", "Invalid data, check if you called PerformanceCounter#stop()");
      return;
    }
    this.time.put(this.current);
    float f;
    FloatCounter localFloatCounter;
    if (paramFloat == 0.0F)
    {
      f = 0.0F;
      localFloatCounter = this.load;
      if (paramFloat <= 1.0F)
        break label76;
    }
    while (true)
    {
      localFloatCounter.put(f);
      this.current = 0.0F;
      this.valid = false;
      return;
      f = this.current / paramFloat;
      break;
      label76: f = f * paramFloat + (1.0F - paramFloat) * this.load.latest;
    }
  }

  public StringBuilder toString(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(this.name).append(": [time: ").append(this.time.value).append(", load: ").append(this.load.value).append("]");
    return paramStringBuilder;
  }

  public String toString()
  {
    return toString(new StringBuilder()).toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.PerformanceCounter
 * JD-Core Version:    0.6.0
 */