package com.badlogic.gdx.graphics;

import com.badlogic.gdx.math.Vector3;

public enum Cubemap$CubemapSide
{
  public final Vector3 direction;
  public final int glEnum;
  public final int index;
  public final Vector3 up;

  static
  {
    NegativeX = new CubemapSide("NegativeX", 1, 1, 34070, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    PositiveY = new CubemapSide("PositiveY", 2, 2, 34071, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F);
    NegativeY = new CubemapSide("NegativeY", 3, 3, 34072, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F);
    PositiveZ = new CubemapSide("PositiveZ", 4, 4, 34073, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F);
    NegativeZ = new CubemapSide("NegativeZ", 5, 5, 34074, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F);
    CubemapSide[] arrayOfCubemapSide = new CubemapSide[6];
    arrayOfCubemapSide[0] = PositiveX;
    arrayOfCubemapSide[1] = NegativeX;
    arrayOfCubemapSide[2] = PositiveY;
    arrayOfCubemapSide[3] = NegativeY;
    arrayOfCubemapSide[4] = PositiveZ;
    arrayOfCubemapSide[5] = NegativeZ;
    $VALUES = arrayOfCubemapSide;
  }

  private Cubemap$CubemapSide(int paramFloat1, int paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float arg9, float arg10)
  {
    this.index = paramFloat1;
    this.glEnum = paramFloat2;
    this.up = new Vector3(paramFloat3, paramFloat4, paramFloat5);
    Object localObject1;
    Object localObject2;
    this.direction = new Vector3(paramFloat6, localObject1, localObject2);
  }

  public final Vector3 getDirection(Vector3 paramVector3)
  {
    return paramVector3.set(this.direction);
  }

  public final int getGLEnum()
  {
    return this.glEnum;
  }

  public final Vector3 getUp(Vector3 paramVector3)
  {
    return paramVector3.set(this.up);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.Cubemap.CubemapSide
 * JD-Core Version:    0.6.0
 */