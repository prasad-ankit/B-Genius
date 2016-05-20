package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class ScaledNumericValue extends RangedNumericValue
{
  private float highMax;
  private float highMin;
  private boolean relative = false;
  private float[] scaling = { 1.0F };
  public float[] timeline = { 0.0F };

  public float getHighMax()
  {
    return this.highMax;
  }

  public float getHighMin()
  {
    return this.highMin;
  }

  public float getScale(float paramFloat)
  {
    int i = this.timeline.length;
    int j = 1;
    if (j < i)
      if (this.timeline[j] <= paramFloat);
    while (true)
    {
      if (j == -1)
      {
        return this.scaling[(i - 1)];
        j++;
        break;
      }
      int k = j - 1;
      float f1 = this.scaling[k];
      float f2 = this.timeline[k];
      return f1 + (this.scaling[j] - f1) * ((paramFloat - f2) / (this.timeline[j] - f2));
      j = -1;
    }
  }

  public float[] getScaling()
  {
    return this.scaling;
  }

  public float[] getTimeline()
  {
    return this.timeline;
  }

  public boolean isRelative()
  {
    return this.relative;
  }

  public void load(ScaledNumericValue paramScaledNumericValue)
  {
    super.load(paramScaledNumericValue);
    this.highMax = paramScaledNumericValue.highMax;
    this.highMin = paramScaledNumericValue.highMin;
    this.scaling = new float[paramScaledNumericValue.scaling.length];
    System.arraycopy(paramScaledNumericValue.scaling, 0, this.scaling, 0, this.scaling.length);
    this.timeline = new float[paramScaledNumericValue.timeline.length];
    System.arraycopy(paramScaledNumericValue.timeline, 0, this.timeline, 0, this.timeline.length);
    this.relative = paramScaledNumericValue.relative;
  }

  public float newHighValue()
  {
    return this.highMin + (this.highMax - this.highMin) * MathUtils.random();
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.highMin = ((Float)paramJson.readValue("highMin", Float.TYPE, paramJsonValue)).floatValue();
    this.highMax = ((Float)paramJson.readValue("highMax", Float.TYPE, paramJsonValue)).floatValue();
    this.relative = ((Boolean)paramJson.readValue("relative", Boolean.TYPE, paramJsonValue)).booleanValue();
    this.scaling = ((float[])paramJson.readValue("scaling", [F.class, paramJsonValue));
    this.timeline = ((float[])paramJson.readValue("timeline", [F.class, paramJsonValue));
  }

  public void setHigh(float paramFloat)
  {
    this.highMin = paramFloat;
    this.highMax = paramFloat;
  }

  public void setHigh(float paramFloat1, float paramFloat2)
  {
    this.highMin = paramFloat1;
    this.highMax = paramFloat2;
  }

  public void setHighMax(float paramFloat)
  {
    this.highMax = paramFloat;
  }

  public void setHighMin(float paramFloat)
  {
    this.highMin = paramFloat;
  }

  public void setRelative(boolean paramBoolean)
  {
    this.relative = paramBoolean;
  }

  public void setScaling(float[] paramArrayOfFloat)
  {
    this.scaling = paramArrayOfFloat;
  }

  public void setTimeline(float[] paramArrayOfFloat)
  {
    this.timeline = paramArrayOfFloat;
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("highMin", Float.valueOf(this.highMin));
    paramJson.writeValue("highMax", Float.valueOf(this.highMax));
    paramJson.writeValue("relative", Boolean.valueOf(this.relative));
    paramJson.writeValue("scaling", this.scaling);
    paramJson.writeValue("timeline", this.timeline);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.ScaledNumericValue
 * JD-Core Version:    0.6.0
 */