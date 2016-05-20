package com.badlogic.gdx.math;

public class FloatCounter
{
  public float average;
  public int count;
  public float latest;
  public float max;
  public final WindowedMean mean;
  public float min;
  public float total;
  public float value;

  public FloatCounter(int paramInt)
  {
    if (paramInt > 1);
    for (WindowedMean localWindowedMean = new WindowedMean(paramInt); ; localWindowedMean = null)
    {
      this.mean = localWindowedMean;
      reset();
      return;
    }
  }

  public void put(float paramFloat)
  {
    this.latest = paramFloat;
    this.total = (paramFloat + this.total);
    this.count = (1 + this.count);
    this.average = (this.total / this.count);
    if (this.mean != null)
      this.mean.addValue(paramFloat);
    for (this.value = this.mean.getMean(); ; this.value = this.latest)
    {
      if ((this.mean == null) || (this.mean.hasEnoughData()))
      {
        if (this.value < this.min)
          this.min = this.value;
        if (this.value > this.max)
          this.max = this.value;
      }
      return;
    }
  }

  public void reset()
  {
    this.count = 0;
    this.total = 0.0F;
    this.min = 3.4028235E+38F;
    this.max = 1.4E-45F;
    this.average = 0.0F;
    this.latest = 0.0F;
    this.value = 0.0F;
    if (this.mean != null)
      this.mean.clear();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.FloatCounter
 * JD-Core Version:    0.6.0
 */