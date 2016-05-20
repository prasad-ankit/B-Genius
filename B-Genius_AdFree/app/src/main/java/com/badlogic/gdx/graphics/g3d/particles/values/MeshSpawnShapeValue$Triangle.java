package com.badlogic.gdx.graphics.g3d.particles.values;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;

public class MeshSpawnShapeValue$Triangle
{
  float x1;
  float x2;
  float x3;
  float y1;
  float y2;
  float y3;
  float z1;
  float z2;
  float z3;

  public MeshSpawnShapeValue$Triangle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9)
  {
    this.x1 = paramFloat1;
    this.y1 = paramFloat2;
    this.z1 = paramFloat3;
    this.x2 = paramFloat4;
    this.y2 = paramFloat5;
    this.z2 = paramFloat6;
    this.x3 = paramFloat7;
    this.y3 = paramFloat8;
    this.z3 = paramFloat9;
  }

  public static Vector3 pick(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, float paramFloat9, Vector3 paramVector3)
  {
    float f1 = MathUtils.random();
    float f2 = MathUtils.random();
    return paramVector3.set(paramFloat1 + f1 * (paramFloat4 - paramFloat1) + f2 * (paramFloat7 - paramFloat1), paramFloat2 + f1 * (paramFloat5 - paramFloat2) + f2 * (paramFloat8 - paramFloat2), paramFloat3 + f1 * (paramFloat6 - paramFloat3) + f2 * (paramFloat9 - paramFloat3));
  }

  public Vector3 pick(Vector3 paramVector3)
  {
    float f1 = MathUtils.random();
    float f2 = MathUtils.random();
    return paramVector3.set(this.x1 + f1 * (this.x2 - this.x1) + f2 * (this.x3 - this.x1), this.y1 + f1 * (this.y2 - this.y1) + f2 * (this.y3 - this.y1), this.z1 + f1 * (this.z2 - this.z1) + f2 * (this.z3 - this.z1));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.values.MeshSpawnShapeValue.Triangle
 * JD-Core Version:    0.6.0
 */