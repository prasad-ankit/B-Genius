package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.Array;

public class BSpline
  implements Path
{
  private static final float d6 = 0.1666667F;
  public boolean continuous;
  public Vector[] controlPoints;
  public int degree;
  public Array knots;
  public int spanCount;
  private Vector tmp;
  private Vector tmp2;
  private Vector tmp3;

  public BSpline()
  {
  }

  public BSpline(Vector[] paramArrayOfVector, int paramInt, boolean paramBoolean)
  {
    set(paramArrayOfVector, paramInt, paramBoolean);
  }

  public static Vector calculate(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, int paramInt, boolean paramBoolean, Vector paramVector2)
  {
    int i;
    float f;
    if (paramBoolean)
    {
      i = paramArrayOfVector.length;
      f = paramFloat * i;
      if (paramFloat < 1.0F)
        break label56;
    }
    label56: for (int j = i - 1; ; j = (int)f)
    {
      return calculate(paramVector1, j, f - j, paramArrayOfVector, paramInt, paramBoolean, paramVector2);
      i = paramArrayOfVector.length - paramInt;
      break;
    }
  }

  public static Vector calculate(Vector paramVector1, int paramInt1, float paramFloat, Vector[] paramArrayOfVector, int paramInt2, boolean paramBoolean, Vector paramVector2)
  {
    switch (paramInt2)
    {
    default:
      return paramVector1;
    case 3:
    }
    return cubic(paramVector1, paramInt1, paramFloat, paramArrayOfVector, paramBoolean, paramVector2);
  }

  public static Vector cubic(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i;
    float f;
    if (paramBoolean)
    {
      i = paramArrayOfVector.length;
      f = paramFloat * i;
      if (paramFloat < 1.0F)
        break label54;
    }
    label54: for (int j = i - 1; ; j = (int)f)
    {
      return cubic(paramVector1, j, f - j, paramArrayOfVector, paramBoolean, paramVector2);
      i = -3 + paramArrayOfVector.length;
      break;
    }
  }

  public static Vector cubic(Vector paramVector1, int paramInt, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i = paramArrayOfVector.length;
    float f1 = 1.0F - paramFloat;
    float f2 = paramFloat * paramFloat;
    float f3 = f2 * paramFloat;
    paramVector1.set(paramArrayOfVector[paramInt]).scl(0.1666667F * (4.0F + (3.0F * f3 - 6.0F * f2)));
    if ((paramBoolean) || (paramInt > 0))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((-1 + (i + paramInt)) % i)]).scl(0.1666667F * (f1 * (f1 * f1))));
    if ((paramBoolean) || (paramInt < i - 1))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 1) % i)]).scl(0.1666667F * (1.0F + (-3.0F * f3 + f2 * 3.0F + 3.0F * paramFloat))));
    if ((paramBoolean) || (paramInt < i - 2))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 2) % i)]).scl(f3 * 0.1666667F));
    return paramVector1;
  }

  public static Vector cubic_derivative(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i;
    float f;
    if (paramBoolean)
    {
      i = paramArrayOfVector.length;
      f = paramFloat * i;
      if (paramFloat < 1.0F)
        break label54;
    }
    label54: for (int j = i - 1; ; j = (int)f)
    {
      return cubic(paramVector1, j, f - j, paramArrayOfVector, paramBoolean, paramVector2);
      i = -3 + paramArrayOfVector.length;
      break;
    }
  }

  public static Vector cubic_derivative(Vector paramVector1, int paramInt, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i = paramArrayOfVector.length;
    float f1 = 1.0F - paramFloat;
    float f2 = paramFloat * paramFloat;
    paramVector1.set(paramArrayOfVector[paramInt]).scl(1.5F * f2 - 2.0F * paramFloat);
    if ((paramBoolean) || (paramInt > 0))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((-1 + (i + paramInt)) % i)]).scl(f1 * (0.5F * f1)));
    if ((paramBoolean) || (paramInt < i - 1))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 1) % i)]).scl(0.5F + (paramFloat + -1.5F * f2)));
    if ((paramBoolean) || (paramInt < i - 2))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 2) % i)]).scl(0.5F * f2));
    return paramVector1;
  }

  public static Vector derivative(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, int paramInt, boolean paramBoolean, Vector paramVector2)
  {
    int i;
    float f;
    if (paramBoolean)
    {
      i = paramArrayOfVector.length;
      f = paramFloat * i;
      if (paramFloat < 1.0F)
        break label56;
    }
    label56: for (int j = i - 1; ; j = (int)f)
    {
      return derivative(paramVector1, j, f - j, paramArrayOfVector, paramInt, paramBoolean, paramVector2);
      i = paramArrayOfVector.length - paramInt;
      break;
    }
  }

  public static Vector derivative(Vector paramVector1, int paramInt1, float paramFloat, Vector[] paramArrayOfVector, int paramInt2, boolean paramBoolean, Vector paramVector2)
  {
    switch (paramInt2)
    {
    default:
      return paramVector1;
    case 3:
    }
    return cubic_derivative(paramVector1, paramInt1, paramFloat, paramArrayOfVector, paramBoolean, paramVector2);
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
    return approximate(paramVector, nearest(paramVector));
  }

  public float approximate(Vector paramVector, int paramInt)
  {
    Object localObject1 = (Vector)this.knots.get(paramInt);
    Array localArray = this.knots;
    if (paramInt > 0);
    Vector localVector;
    Object localObject2;
    for (int i = paramInt - 1; ; i = -1 + this.spanCount)
    {
      localVector = (Vector)localArray.get(i);
      localObject2 = (Vector)this.knots.get((paramInt + 1) % this.spanCount);
      float f1 = paramVector.dst2(localVector);
      if (paramVector.dst2((Vector)localObject2) >= f1)
        break;
      float f2 = ((Vector)localObject1).dst2((Vector)localObject2);
      float f3 = paramVector.dst2((Vector)localObject2);
      float f4 = paramVector.dst2((Vector)localObject1);
      float f5 = (float)Math.sqrt(f2);
      return (MathUtils.clamp((f5 - (f2 + f3 - f4) / (2.0F * f5)) / f5, 0.0F, 1.0F) + paramInt) / this.spanCount;
    }
    if (paramInt > 0);
    for (int j = paramInt - 1; ; j = -1 + this.spanCount)
    {
      paramInt = j;
      localObject2 = localObject1;
      localObject1 = localVector;
      break;
    }
  }

  public float approximate(Vector paramVector, int paramInt1, int paramInt2)
  {
    return approximate(paramVector, nearest(paramVector, paramInt1, paramInt2));
  }

  public Vector derivativeAt(Vector paramVector, float paramFloat)
  {
    int i = this.spanCount;
    float f = paramFloat * i;
    if (paramFloat >= 1.0F);
    for (int j = i - 1; ; j = (int)f)
      return derivativeAt(paramVector, j, f - j);
  }

  public Vector derivativeAt(Vector paramVector, int paramInt, float paramFloat)
  {
    if (this.continuous);
    for (int i = paramInt; ; i = paramInt + (int)(0.5F * this.degree))
      return derivative(paramVector, i, paramFloat, this.controlPoints, this.degree, this.continuous, this.tmp);
  }

  public float locate(Vector paramVector)
  {
    return approximate(paramVector);
  }

  public int nearest(Vector paramVector)
  {
    return nearest(paramVector, 0, this.spanCount);
  }

  public int nearest(Vector paramVector, int paramInt1, int paramInt2)
  {
    while (paramInt1 < 0)
      paramInt1 += this.spanCount;
    int i = paramInt1 % this.spanCount;
    float f1 = paramVector.dst2((Vector)this.knots.get(i));
    int j = 1;
    int k;
    float f2;
    if (j < paramInt2)
    {
      k = (paramInt1 + j) % this.spanCount;
      f2 = paramVector.dst2((Vector)this.knots.get(k));
      if (f2 >= f1)
        break label111;
    }
    for (int m = k; ; m = i)
    {
      j++;
      i = m;
      f1 = f2;
      break;
      return i;
      label111: f2 = f1;
    }
  }

  public BSpline set(Vector[] paramArrayOfVector, int paramInt, boolean paramBoolean)
  {
    if (this.tmp == null)
      this.tmp = paramArrayOfVector[0].cpy();
    if (this.tmp2 == null)
      this.tmp2 = paramArrayOfVector[0].cpy();
    if (this.tmp3 == null)
      this.tmp3 = paramArrayOfVector[0].cpy();
    this.controlPoints = paramArrayOfVector;
    this.degree = paramInt;
    this.continuous = paramBoolean;
    int i;
    label108: int j;
    label111: Array localArray;
    Vector localVector;
    if (paramBoolean)
    {
      i = paramArrayOfVector.length;
      this.spanCount = i;
      if (this.knots != null)
        break label179;
      this.knots = new Array(this.spanCount);
      j = 0;
      if (j >= this.spanCount)
        break label216;
      localArray = this.knots;
      localVector = paramArrayOfVector[0].cpy();
      if (!paramBoolean)
        break label201;
    }
    label179: label201: for (int k = j; ; k = (int)(j + 0.5F * paramInt))
    {
      localArray.add(calculate(localVector, k, 0.0F, paramArrayOfVector, paramInt, paramBoolean, this.tmp));
      j++;
      break label111;
      i = paramArrayOfVector.length - paramInt;
      break;
      this.knots.clear();
      this.knots.ensureCapacity(this.spanCount);
      break label108;
    }
    label216: return this;
  }

  public Vector valueAt(Vector paramVector, float paramFloat)
  {
    int i = this.spanCount;
    float f = paramFloat * i;
    if (paramFloat >= 1.0F);
    for (int j = i - 1; ; j = (int)f)
      return valueAt(paramVector, j, f - j);
  }

  public Vector valueAt(Vector paramVector, int paramInt, float paramFloat)
  {
    if (this.continuous);
    for (int i = paramInt; ; i = paramInt + (int)(0.5F * this.degree))
      return calculate(paramVector, i, paramFloat, this.controlPoints, this.degree, this.continuous, this.tmp);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.BSpline
 * JD-Core Version:    0.6.0
 */