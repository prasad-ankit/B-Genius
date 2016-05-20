package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class GradientColorValue extends ParticleValue
{
  private static float[] temp = new float[3];
  private float[] colors = { 1.0F, 1.0F, 1.0F };
  public float[] timeline = { 0.0F };

  public void getColor(float paramFloat, float[] paramArrayOfFloat, int paramInt)
  {
    int i = 0;
    float[] arrayOfFloat = this.timeline;
    int j = arrayOfFloat.length;
    int k = 1;
    if (k < j)
      if (arrayOfFloat[k] <= paramFloat);
    while (true)
    {
      float f1 = arrayOfFloat[i];
      int m = i * 3;
      float f2 = this.colors[m];
      float f3 = this.colors[(m + 1)];
      float f4 = this.colors[(m + 2)];
      if (k == -1)
      {
        paramArrayOfFloat[paramInt] = f2;
        paramArrayOfFloat[(paramInt + 1)] = f3;
        paramArrayOfFloat[(paramInt + 2)] = f4;
        return;
        int i1 = k + 1;
        i = k;
        k = i1;
        break;
      }
      float f5 = (paramFloat - f1) / (arrayOfFloat[k] - f1);
      int n = k * 3;
      paramArrayOfFloat[paramInt] = (f2 + f5 * (this.colors[n] - f2));
      paramArrayOfFloat[(paramInt + 1)] = (f3 + f5 * (this.colors[(n + 1)] - f3));
      paramArrayOfFloat[(paramInt + 2)] = (f4 + f5 * (this.colors[(n + 2)] - f4));
      return;
      k = -1;
    }
  }

  public float[] getColor(float paramFloat)
  {
    getColor(paramFloat, temp, 0);
    return temp;
  }

  public float[] getColors()
  {
    return this.colors;
  }

  public float[] getTimeline()
  {
    return this.timeline;
  }

  public void load(GradientColorValue paramGradientColorValue)
  {
    super.load(paramGradientColorValue);
    this.colors = new float[paramGradientColorValue.colors.length];
    System.arraycopy(paramGradientColorValue.colors, 0, this.colors, 0, this.colors.length);
    this.timeline = new float[paramGradientColorValue.timeline.length];
    System.arraycopy(paramGradientColorValue.timeline, 0, this.timeline, 0, this.timeline.length);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    super.read(paramJson, paramJsonValue);
    this.colors = ((float[])paramJson.readValue("colors", [F.class, paramJsonValue));
    this.timeline = ((float[])paramJson.readValue("timeline", [F.class, paramJsonValue));
  }

  public void setColors(float[] paramArrayOfFloat)
  {
    this.colors = paramArrayOfFloat;
  }

  public void setTimeline(float[] paramArrayOfFloat)
  {
    this.timeline = paramArrayOfFloat;
  }

  public void write(Json paramJson)
  {
    super.write(paramJson);
    paramJson.writeValue("colors", this.colors);
    paramJson.writeValue("timeline", this.timeline);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue
 * JD-Core Version:    0.6.0
 */