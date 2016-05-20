package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class NumericValue extends ParticleValue
{
  private float value;

  public float getValue()
  {
    return this.value;
  }

  public void load(NumericValue paramNumericValue)
  {
    super.load(paramNumericValue);
    this.value = paramNumericValue.value;
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.value = ((Float)paramJson.readValue("value", Float.TYPE, paramJsonValue)).floatValue();
  }

  public void setValue(float paramFloat)
  {
    this.value = paramFloat;
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("value", Float.valueOf(this.value));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.NumericValue
 * JD-Core Version:    0.6.0
 */