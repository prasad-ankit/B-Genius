package com.badlogic.gdx.math;

public class CatmullRomSpline
  implements Path
{
  public boolean continuous;
  public Vector[] controlPoints;
  public int spanCount;
  private Vector tmp;
  private Vector tmp2;
  private Vector tmp3;

  public CatmullRomSpline()
  {
  }

  public CatmullRomSpline(Vector[] paramArrayOfVector, boolean paramBoolean)
  {
    set(paramArrayOfVector, paramBoolean);
  }

  public static Vector calculate(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
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
      return calculate(paramVector1, j, f - j, paramArrayOfVector, paramBoolean, paramVector2);
      i = -3 + paramArrayOfVector.length;
      break;
    }
  }

  public static Vector calculate(Vector paramVector1, int paramInt, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i = paramArrayOfVector.length;
    float f1 = paramFloat * paramFloat;
    float f2 = f1 * paramFloat;
    paramVector1.set(paramArrayOfVector[paramInt]).scl(1.0F + (1.5F * f2 - 2.5F * f1));
    if ((paramBoolean) || (paramInt > 0))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((-1 + (i + paramInt)) % i)]).scl(f1 + -0.5F * f2 - 0.5F * paramFloat));
    if ((paramBoolean) || (paramInt < i - 1))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 1) % i)]).scl(-1.5F * f2 + 2.0F * f1 + 0.5F * paramFloat));
    if ((paramBoolean) || (paramInt < i - 2))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 2) % i)]).scl(f2 * 0.5F - f1 * 0.5F));
    return paramVector1;
  }

  public static Vector derivative(Vector paramVector1, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
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
      return derivative(paramVector1, j, f - j, paramArrayOfVector, paramBoolean, paramVector2);
      i = -3 + paramArrayOfVector.length;
      break;
    }
  }

  public static Vector derivative(Vector paramVector1, int paramInt, float paramFloat, Vector[] paramArrayOfVector, boolean paramBoolean, Vector paramVector2)
  {
    int i = paramArrayOfVector.length;
    float f = paramFloat * paramFloat;
    paramVector1.set(paramArrayOfVector[paramInt]).scl(5.0F * -paramFloat + f * 4.5F);
    if ((paramBoolean) || (paramInt > 0))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((-1 + (i + paramInt)) % i)]).scl(-0.5F + 2.0F * paramFloat - f * 1.5F));
    if ((paramBoolean) || (paramInt < i - 1))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 1) % i)]).scl(0.5F + 4.0F * paramFloat - f * 4.5F));
    if ((paramBoolean) || (paramInt < i - 2))
      paramVector1.add(paramVector2.set(paramArrayOfVector[((paramInt + 2) % i)]).scl(-paramFloat + f * 1.5F));
    return paramVector1;
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
    Object localObject1 = this.controlPoints[paramInt];
    Vector[] arrayOfVector = this.controlPoints;
    if (paramInt > 0);
    Vector localVector1;
    Object localObject2;
    for (int i = paramInt - 1; ; i = -1 + this.spanCount)
    {
      localVector1 = arrayOfVector[i];
      Vector localVector2 = this.controlPoints[((paramInt + 1) % this.spanCount)];
      float f1 = paramVector.dst2(localVector1);
      if (paramVector.dst2(localVector2) >= f1)
        break;
      Object localObject3 = localObject1;
      localObject1 = localVector2;
      localObject2 = localObject3;
      float f2 = ((Vector)localObject2).dst2((Vector)localObject1);
      float f3 = paramVector.dst2((Vector)localObject1);
      float f4 = paramVector.dst2((Vector)localObject2);
      float f5 = (float)Math.sqrt(f2);
      return (MathUtils.clamp((f5 - (f3 + f2 - f4) / (2.0F * f5)) / f5, 0.0F, 1.0F) + paramInt) / this.spanCount;
    }
    if (paramInt > 0);
    for (int j = paramInt - 1; ; j = -1 + this.spanCount)
    {
      paramInt = j;
      localObject2 = localVector1;
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
    for (int i = paramInt; ; i = paramInt + 1)
      return derivative(paramVector, i, paramFloat, this.controlPoints, this.continuous, this.tmp);
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
    float f1 = paramVector.dst2(this.controlPoints[i]);
    int j = 1;
    int k;
    float f2;
    if (j < paramInt2)
    {
      k = (paramInt1 + j) % this.spanCount;
      f2 = paramVector.dst2(this.controlPoints[k]);
      if (f2 >= f1)
        break label101;
    }
    for (int m = k; ; m = i)
    {
      j++;
      i = m;
      f1 = f2;
      break;
      return i;
      label101: f2 = f1;
    }
  }

  public CatmullRomSpline set(Vector[] paramArrayOfVector, boolean paramBoolean)
  {
    if (this.tmp == null)
      this.tmp = paramArrayOfVector[0].cpy();
    if (this.tmp2 == null)
      this.tmp2 = paramArrayOfVector[0].cpy();
    if (this.tmp3 == null)
      this.tmp3 = paramArrayOfVector[0].cpy();
    this.controlPoints = paramArrayOfVector;
    this.continuous = paramBoolean;
    if (paramBoolean);
    for (int i = paramArrayOfVector.length; ; i = -3 + paramArrayOfVector.length)
    {
      this.spanCount = i;
      return this;
    }
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
    for (int i = paramInt; ; i = paramInt + 1)
      return calculate(paramVector, i, paramFloat, this.controlPoints, this.continuous, this.tmp);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.CatmullRomSpline
 * JD-Core Version:    0.6.0
 */