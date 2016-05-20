package com.badlogic.gdx.graphics.g3d.environment;

import F;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class SphericalHarmonics
{
  private static final float[] coeff = { 0.282095F, 0.488603F, 0.488603F, 0.488603F, 1.092548F, 1.092548F, 1.092548F, 0.315392F, 0.546274F };
  public final float[] data;

  public SphericalHarmonics()
  {
    this.data = new float[27];
  }

  public SphericalHarmonics(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat.length != 27)
      throw new GdxRuntimeException("Incorrect array size");
    this.data = ((float[])paramArrayOfFloat.clone());
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

  public SphericalHarmonics set(float paramFloat1, float paramFloat2, float paramFloat3)
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

  public SphericalHarmonics set(Color paramColor)
  {
    return set(paramColor.r, paramColor.g, paramColor.b);
  }

  public SphericalHarmonics set(AmbientCubemap paramAmbientCubemap)
  {
    return set(paramAmbientCubemap.data);
  }

  public SphericalHarmonics set(float[] paramArrayOfFloat)
  {
    for (int i = 0; i < this.data.length; i++)
      this.data[i] = paramArrayOfFloat[i];
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.environment.SphericalHarmonics
 * JD-Core Version:    0.6.0
 */