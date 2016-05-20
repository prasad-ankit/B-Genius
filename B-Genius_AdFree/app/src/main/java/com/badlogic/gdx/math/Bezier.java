package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class Bezier
  implements Path
{
  public Array points = new Array();
  private Vector tmp;
  private Vector tmp2;
  private Vector tmp3;

  public Bezier()
  {
  }

  public Bezier(Array paramArray, int paramInt1, int paramInt2)
  {
    set(paramArray, paramInt1, paramInt2);
  }

  public Bezier(Vector[] paramArrayOfVector)
  {
    set(paramArrayOfVector);
  }

  public Bezier(Vector[] paramArrayOfVector, int paramInt1, int paramInt2)
  {
    set(paramArrayOfVector, paramInt1, paramInt2);
  }

  public static Vector cubic(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4, Vector paramVector5, Vector paramVector6)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = f1 * f1;
    float f3 = paramFloat * paramFloat;
    return paramVector1.set(paramVector2).scl(f2 * f1).add(paramVector6.set(paramVector3).scl(paramFloat * (f2 * 3.0F))).add(paramVector6.set(paramVector4).scl(f3 * (f1 * 3.0F))).add(paramVector6.set(paramVector5).scl(f3 * paramFloat));
  }

  public static Vector cubic_derivative(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4, Vector paramVector5, Vector paramVector6)
  {
    float f1 = 1.0F - paramFloat;
    float f2 = f1 * f1;
    float f3 = paramFloat * paramFloat;
    return paramVector1.set(paramVector3).sub(paramVector2).scl(f2 * 3.0F).add(paramVector6.set(paramVector4).sub(paramVector3).scl(6.0F * (f1 * paramFloat))).add(paramVector6.set(paramVector5).sub(paramVector4).scl(f3 * 3.0F));
  }

  public static Vector linear(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4)
  {
    return paramVector1.set(paramVector2).scl(1.0F - paramFloat).add(paramVector4.set(paramVector3).scl(paramFloat));
  }

  public static Vector linear_derivative(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4)
  {
    return paramVector1.set(paramVector3).sub(paramVector2);
  }

  public static Vector quadratic(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4, Vector paramVector5)
  {
    float f = 1.0F - paramFloat;
    return paramVector1.set(paramVector2).scl(f * f).add(paramVector5.set(paramVector3).scl(paramFloat * (f * 2.0F))).add(paramVector5.set(paramVector4).scl(paramFloat * paramFloat));
  }

  public static Vector quadratic_derivative(Vector paramVector1, float paramFloat, Vector paramVector2, Vector paramVector3, Vector paramVector4, Vector paramVector5)
  {
    float f = 1.0F - paramFloat;
    return paramVector1.set(paramVector3).sub(paramVector2).scl(2.0F).scl(f).add(paramVector5.set(paramVector4).sub(paramVector3).scl(paramFloat).scl(2.0F));
  }

  public float approxLength(int paramInt)
  {
    float f = 0.0F;
    for (int i = 0; i < paramInt; i++)
    {
      this.tmp2.set(this.tmp3);
      valueAt(this.tmp3, i / (paramInt - 1.0F));
      if (i <= 0)
        continue;
      f += this.tmp2.dst(this.tmp3);
    }
    return f;
  }

  public float approximate(Vector paramVector)
  {
    Vector localVector1 = (Vector)this.points.get(0);
    Vector localVector2 = (Vector)this.points.get(-1 + this.points.size);
    float f1 = localVector1.dst2(localVector2);
    float f2 = paramVector.dst2(localVector2);
    float f3 = paramVector.dst2(localVector1);
    float f4 = (float)Math.sqrt(f1);
    return MathUtils.clamp((f4 - (f2 + f1 - f3) / (2.0F * f4)) / f4, 0.0F, 1.0F);
  }

  public Vector derivativeAt(Vector paramVector, float paramFloat)
  {
    int i = this.points.size;
    if (i == 2)
      linear_derivative(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), this.tmp);
    do
    {
      return paramVector;
      if (i != 3)
        continue;
      quadratic_derivative(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), this.tmp);
      return paramVector;
    }
    while (i != 4);
    cubic_derivative(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), (Vector)this.points.get(3), this.tmp);
    return paramVector;
  }

  public float locate(Vector paramVector)
  {
    return approximate(paramVector);
  }

  public Bezier set(Array paramArray, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 2) || (paramInt2 > 4))
      throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported.");
    if (this.tmp == null)
      this.tmp = ((Vector)paramArray.get(0)).cpy();
    this.points.clear();
    this.points.addAll(paramArray, paramInt1, paramInt2);
    return this;
  }

  public Bezier set(Vector[] paramArrayOfVector)
  {
    return set(paramArrayOfVector, 0, paramArrayOfVector.length);
  }

  public Bezier set(Vector[] paramArrayOfVector, int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 2) || (paramInt2 > 4))
      throw new GdxRuntimeException("Only first, second and third degree Bezier curves are supported.");
    if (this.tmp == null)
      this.tmp = paramArrayOfVector[0].cpy();
    if (this.tmp2 == null)
      this.tmp2 = paramArrayOfVector[0].cpy();
    if (this.tmp3 == null)
      this.tmp3 = paramArrayOfVector[0].cpy();
    this.points.clear();
    this.points.addAll(paramArrayOfVector, paramInt1, paramInt2);
    return this;
  }

  public Vector valueAt(Vector paramVector, float paramFloat)
  {
    int i = this.points.size;
    if (i == 2)
      linear(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), this.tmp);
    do
    {
      return paramVector;
      if (i != 3)
        continue;
      quadratic(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), this.tmp);
      return paramVector;
    }
    while (i != 4);
    cubic(paramVector, paramFloat, (Vector)this.points.get(0), (Vector)this.points.get(1), (Vector)this.points.get(2), (Vector)this.points.get(3), this.tmp);
    return paramVector;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Bezier
 * JD-Core Version:    0.6.0
 */