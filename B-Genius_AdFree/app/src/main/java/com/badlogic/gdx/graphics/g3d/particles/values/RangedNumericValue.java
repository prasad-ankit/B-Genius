package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class RangedNumericValue extends ParticleValue
{
  private float lowMax;
  private float lowMin;

  public float getLowMax()
  {
    return this.lowMax;
  }

  public float getLowMin()
  {
    return this.lowMin;
  }

  public void load(RangedNumericValue paramRangedNumericValue)
  {
    super.load(paramRangedNumericValue);
    this.lowMax = paramRangedNumericValue.lowMax;
    this.lowMin = paramRangedNumericValue.lowMin;
  }

  public float newLowValue()
  {
    return this.lowMin + (this.lowMax - this.lowMin) * MathUtils.random();
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.lowMin = ((Float)paramJson.readValue("lowMin", Float.TYPE, paramJsonValue)).floatValue();
    this.lowMax = ((Float)paramJson.readValue("lowMax", Float.TYPE, paramJsonValue)).floatValue();
  }

  public void setLow(float paramFloat)
  {
    this.lowMin = paramFloat;
    this.lowMax = paramFloat;
  }

  public void setLow(float paramFloat1, float paramFloat2)
  {
    this.lowMin = paramFloat1;
    this.lowMax = paramFloat2;
  }

  public void setLowMax(float paramFloat)
  {
    this.lowMax = paramFloat;
  }

  public void setLowMin(float paramFloat)
  {
    this.lowMin = paramFloat;
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("lowMin", Float.valueOf(this.lowMin));
    paramJson.writeValue("lowMax", Float.valueOf(this.lowMax));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.RangedNumericValue
 * JD-Core Version:    0.6.0
 */