package com.badlogic.gdx.graphics.g3d.environment;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class AmbientCubemap
{
  public final float[] data;

  public AmbientCubemap()
  {
    this.data = new float[18];
  }

  public AmbientCubemap(AmbientCubemap paramAmbientCubemap)
  {
    this(paramAmbientCubemap.data);
  }

  public AmbientCubemap(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 18)
      throw new GdxRuntimeException("Incorrect array size");
    this.data = new float[paramArrayOfFloat.length];
    System.arraycopy(paramArrayOfFloat, 0, this.data, 0, this.data.length);
  }

  private static final float clamp(float paramFloat)
  {
    if (paramFloat < 0.0F)
      paramFloat = 0.0F;
    do
      return paramFloat;
    while (paramFloat <= 1.0F);
    return 1.0F;
  }

  public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 0;
    while (i < this.data.length)
    {
      float[] arrayOfFloat1 = this.data;
      int j = i + 1;
      arrayOfFloat1[i] = (paramFloat1 + arrayOfFloat1[i]);
      float[] arrayOfFloat2 = this.data;
      int k = j + 1;
      arrayOfFloat2[j] = (paramFloat2 + arrayOfFloat2[j]);
      float[] arrayOfFloat3 = this.data;
      i = k + 1;
      arrayOfFloat3[k] = (paramFloat3 + arrayOfFloat3[k]);
    }
    return this;
  }

  public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat4 * paramFloat4;
    float f2 = paramFloat5 * paramFloat5;
    float f3 = paramFloat6 * paramFloat6;
    float f4 = f3 + (f1 + f2);
    if (f4 == 0.0F)
      return this;
    float f5 = 1.0F / f4 * (f4 + 1.0F);
    float f6 = paramFloat1 * f5;
    float f7 = paramFloat2 * f5;
    float f8 = paramFloat3 * f5;
    int i;
    int m;
    if (paramFloat4 > 0.0F)
    {
      i = 0;
      float[] arrayOfFloat1 = this.data;
      arrayOfFloat1[i] += f1 * f6;
      float[] arrayOfFloat2 = this.data;
      int j = i + 1;
      arrayOfFloat2[j] += f1 * f7;
      float[] arrayOfFloat3 = this.data;
      int k = i + 2;
      arrayOfFloat3[k] += f1 * f8;
      if (paramFloat5 <= 0.0F)
        break label343;
      m = 6;
      label168: float[] arrayOfFloat4 = this.data;
      arrayOfFloat4[m] += f2 * f6;
      float[] arrayOfFloat5 = this.data;
      int n = m + 1;
      arrayOfFloat5[n] += f2 * f7;
      float[] arrayOfFloat6 = this.data;
      int i1 = m + 2;
      arrayOfFloat6[i1] += f2 * f8;
      if (paramFloat6 <= 0.0F)
        break label350;
    }
    label343: label350: for (int i2 = 12; ; i2 = 15)
    {
      float[] arrayOfFloat7 = this.data;
      arrayOfFloat7[i2] += f6 * f3;
      float[] arrayOfFloat8 = this.data;
      int i3 = i2 + 1;
      arrayOfFloat8[i3] += f7 * f3;
      float[] arrayOfFloat9 = this.data;
      int i4 = i2 + 2;
      arrayOfFloat9[i4] += f3 * f8;
      return this;
      i = 3;
      break;
      m = 9;
      break label168;
    }
  }

  public AmbientCubemap add(float paramFloat1, float paramFloat2, float paramFloat3, Vector3 paramVector3)
  {
    return add(paramFloat1, paramFloat2, paramFloat3, paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public AmbientCubemap add(Color paramColor)
  {
    return add(paramColor.r, paramColor.g, paramColor.b);
  }

  public AmbientCubemap add(Color paramColor, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return add(paramColor.r, paramColor.g, paramColor.b, paramFloat1, paramFloat2, paramFloat3);
  }

  public AmbientCubemap add(Color paramColor, Vector3 paramVector3)
  {
    return add(paramColor.r, paramColor.g, paramColor.b, paramVector3.x, paramVector3.y, paramVector3.z);
  }

  public AmbientCubemap add(Color paramColor, Vector3 paramVector31, Vector3 paramVector32)
  {
    return add(paramColor.r, paramColor.g, paramColor.b, paramVector32.x - paramVector31.x, paramVector32.y - paramVector31.y, paramVector32.z - paramVector31.z);
  }

  public AmbientCubemap add(Color paramColor, Vector3 paramVector31, Vector3 paramVector32, float paramFloat)
  {
    float f = paramFloat / (1.0F + paramVector32.dst(paramVector31));
    return add(f * paramColor.r, f * paramColor.g, f * paramColor.b, paramVector32.x - paramVector31.x, paramVector32.y - paramVector31.y, paramVector32.z - paramVector31.z);
  }

  public AmbientCubemap clamp()
  {
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = clamp(this.data[i]);
    return this;
  }

  public AmbientCubemap clear()
  {
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = 0.0F;
    return this;
  }

  public Color getColor(Color paramColor, int paramInt)
  {
    int i = paramInt * 3;
    return paramColor.set(this.data[i], this.data[(i + 1)], this.data[(i + 2)], 1.0F);
  }

  public AmbientCubemap set(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 0;
    while (i < this.data.length)
    {
      float[] arrayOfFloat1 = this.data;
      int j = i + 1;
      arrayOfFloat1[i] = paramFloat1;
      float[] arrayOfFloat2 = this.data;
      int k = j + 1;
      arrayOfFloat2[j] = paramFloat2;
      float[] arrayOfFloat3 = this.data;
      i = k + 1;
      arrayOfFloat3[k] = paramFloat3;
    }
    return this;
  }

  public AmbientCubemap set(Color paramColor)
  {
    return set(paramColor.r, paramColor.g, paramColor.b);
  }

  public AmbientCubemap set(AmbientCubemap paramAmbientCubemap)
  {
    return set(paramAmbientCubemap.data);
  }

  public AmbientCubemap set(float[] paramArrayOfFloat)
  {
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = paramArrayOfFloat[i];
    return this;
  }

  public String toString()
  {
    String str = "";
    for (int i = 0; i < this.data.length; i += 3)
      str = str + Float.toString(this.data[i]) + ", " + Float.toString(this.data[(i + 1)]) + ", " + Float.toString(this.data[(i + 2)]) + "\n";
    return str;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.environment.AmbientCubemap
 * JD-Core Version:    0.6.0
 */