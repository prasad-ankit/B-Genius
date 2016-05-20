package com.badlogic.gdx.math;

public final class GeometryUtils
{
  private static final Vector2 tmp1 = new Vector2();
  private static final Vector2 tmp2 = new Vector2();
  private static final Vector2 tmp3 = new Vector2();

  private static boolean areVerticesClockwise(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 2);
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      return false;
      int i = -3 + (paramInt1 + paramInt2);
      f1 = 0.0F;
      while (paramInt1 < i)
      {
        float f5 = paramArrayOfFloat[paramInt1];
        float f6 = paramArrayOfFloat[(paramInt1 + 1)];
        float f7 = paramArrayOfFloat[(paramInt1 + 2)];
        f1 += f5 * paramArrayOfFloat[(paramInt1 + 3)] - f6 * f7;
        paramInt1 += 2;
      }
      f2 = paramArrayOfFloat[(paramInt2 - 2)];
      f3 = paramArrayOfFloat[(paramInt2 - 1)];
      f4 = paramArrayOfFloat[0];
    }
    while (f1 + f2 * paramArrayOfFloat[1] - f4 * f3 >= 0.0F);
    return true;
  }

  public static boolean barycoordInsideTriangle(Vector2 paramVector2)
  {
    return (paramVector2.x >= 0.0F) && (paramVector2.y >= 0.0F) && (paramVector2.x + paramVector2.y <= 1.0F);
  }

  public static boolean colinear(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = paramFloat5 - paramFloat3;
    float f4 = paramFloat6 - paramFloat4;
    return Math.abs(f2 * f3 - f1 * f4) < 1.0E-006F;
  }

  public static void ensureCCW(float[] paramArrayOfFloat)
  {
    int i = 0;
    if (!areVerticesClockwise(paramArrayOfFloat, 0, paramArrayOfFloat.length));
    while (true)
    {
      return;
      int j = -2 + paramArrayOfFloat.length;
      int k = paramArrayOfFloat.length / 2;
      while (i < k)
      {
        int m = j - i;
        float f1 = paramArrayOfFloat[i];
        float f2 = paramArrayOfFloat[(i + 1)];
        paramArrayOfFloat[i] = paramArrayOfFloat[m];
        paramArrayOfFloat[(i + 1)] = paramArrayOfFloat[(m + 1)];
        paramArrayOfFloat[m] = f1;
        paramArrayOfFloat[(m + 1)] = f2;
        i += 2;
      }
    }
  }

  public static float fromBarycoord(Vector2 paramVector2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 * (1.0F - paramVector2.x - paramVector2.y) + paramFloat2 * paramVector2.x + paramFloat3 * paramVector2.y;
  }

  public static Vector2 fromBarycoord(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25)
  {
    float f = 1.0F - paramVector21.x - paramVector21.y;
    paramVector25.x = (f * paramVector22.x + paramVector21.x * paramVector23.x + paramVector21.y * paramVector24.x);
    paramVector25.y = (f * paramVector22.y + paramVector21.x * paramVector23.y + paramVector21.y * paramVector24.y);
    return paramVector25;
  }

  public static float lowestPositiveRoot(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat2 * paramFloat2 - paramFloat3 * (4.0F * paramFloat1);
    if (f1 < 0.0F)
      return (0.0F / 0.0F);
    float f2 = (float)Math.sqrt(f1);
    float f3 = 1.0F / (2.0F * paramFloat1);
    float f4 = f3 * (-paramFloat2 - f2);
    float f5 = f3 * (f2 + -paramFloat2);
    if (f4 > f5);
    while (true)
    {
      if (f5 > 0.0F)
        return f5;
      if (f4 <= 0.0F)
        break;
      return f4;
      float f6 = f4;
      f4 = f5;
      f5 = f6;
    }
  }

  public static float polygonArea(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = paramInt1;
    float f1 = 0.0F;
    while (j < i)
    {
      int k = j + 1;
      int m = (j + 2) % i;
      if (m < paramInt1)
        m += paramInt1;
      int n = (j + 3) % i;
      if (n < paramInt1)
        n += paramInt1;
      float f2 = f1 + paramArrayOfFloat[j] * paramArrayOfFloat[n] - paramArrayOfFloat[m] * paramArrayOfFloat[k];
      j += 2;
      f1 = f2;
    }
    return 0.5F * f1;
  }

  public static Vector2 polygonCentroid(float[] paramArrayOfFloat, int paramInt1, int paramInt2, Vector2 paramVector2)
  {
    if (paramInt2 < 6)
      throw new IllegalArgumentException("A polygon must have 3 or more coordinate pairs.");
    int i = -2 + (paramInt1 + paramInt2);
    float f1 = 0.0F;
    float f2 = 0.0F;
    float f3 = 0.0F;
    for (int j = paramInt1; j < i; j += 2)
    {
      float f13 = paramArrayOfFloat[j];
      float f14 = paramArrayOfFloat[(j + 1)];
      float f15 = paramArrayOfFloat[(j + 2)];
      float f16 = paramArrayOfFloat[(j + 3)];
      float f17 = f13 * f16 - f15 * f14;
      f3 += f17;
      f1 += f17 * (f13 + f15);
      f2 += f17 * (f14 + f16);
    }
    float f4 = paramArrayOfFloat[j];
    float f5 = paramArrayOfFloat[(j + 1)];
    float f6 = paramArrayOfFloat[paramInt1];
    float f7 = paramArrayOfFloat[(paramInt1 + 1)];
    float f8 = f4 * f7 - f6 * f5;
    float f9 = f3 + f8;
    float f10 = f1 + f8 * (f4 + f6);
    float f11 = f2 + f8 * (f5 + f7);
    if (f9 == 0.0F)
    {
      paramVector2.x = 0.0F;
      paramVector2.y = 0.0F;
      return paramVector2;
    }
    float f12 = f9 * 0.5F;
    paramVector2.x = (f10 / (6.0F * f12));
    paramVector2.y = (f11 / (f12 * 6.0F));
    return paramVector2;
  }

  public static Vector2 quadrilateralCentroid(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8, Vector2 paramVector2)
  {
    float f1 = (paramFloat5 + (paramFloat1 + paramFloat3)) / 3.0F;
    float f2 = (paramFloat6 + (paramFloat2 + paramFloat4)) / 3.0F;
    float f3 = (paramFloat5 + (paramFloat1 + paramFloat7)) / 3.0F;
    float f4 = (paramFloat6 + (paramFloat2 + paramFloat8)) / 3.0F;
    paramVector2.x = (f1 - (f1 - f3) / 2.0F);
    paramVector2.y = (f2 - (f2 - f4) / 2.0F);
    return paramVector2;
  }

  public static Vector2 toBarycoord(Vector2 paramVector21, Vector2 paramVector22, Vector2 paramVector23, Vector2 paramVector24, Vector2 paramVector25)
  {
    Vector2 localVector21 = tmp1.set(paramVector23).sub(paramVector22);
    Vector2 localVector22 = tmp2.set(paramVector24).sub(paramVector22);
    Vector2 localVector23 = tmp3.set(paramVector21).sub(paramVector22);
    float f1 = localVector21.dot(localVector21);
    float f2 = localVector21.dot(localVector22);
    float f3 = localVector22.dot(localVector22);
    float f4 = localVector23.dot(localVector21);
    float f5 = localVector23.dot(localVector22);
    float f6 = f1 * f3 - f2 * f2;
    paramVector25.x = ((f3 * f4 - f2 * f5) / f6);
    paramVector25.y = ((f5 * f1 - f4 * f2) / f6);
    return paramVector25;
  }

  public static float triangleArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return 0.5F * Math.abs((paramFloat1 - paramFloat5) * (paramFloat4 - paramFloat2) - (paramFloat1 - paramFloat3) * (paramFloat6 - paramFloat2));
  }

  public static Vector2 triangleCentroid(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2)
  {
    paramVector2.x = ((paramFloat5 + (paramFloat1 + paramFloat3)) / 3.0F);
    paramVector2.y = ((paramFloat6 + (paramFloat2 + paramFloat4)) / 3.0F);
    return paramVector2;
  }

  public static Vector2 triangleCircumcenter(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, Vector2 paramVector2)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = paramFloat5 - paramFloat3;
    float f4 = paramFloat6 - paramFloat4;
    float f5 = paramFloat1 - paramFloat5;
    float f6 = paramFloat2 - paramFloat6;
    float f7 = f3 * f2 - f1 * f4;
    if (Math.abs(f7) < 1.0E-006F)
      throw new IllegalArgumentException("Triangle points must not be colinear.");
    float f8 = f7 * 2.0F;
    float f9 = paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2;
    float f10 = paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4;
    float f11 = paramFloat5 * paramFloat5 + paramFloat6 * paramFloat6;
    paramVector2.set((f4 * f9 + f6 * f10 + f2 * f11) / f8, -(f3 * f9 + f10 * f5 + f1 * f11) / f8);
    return paramVector2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.GeometryUtils
 * JD-Core Version:    0.6.0
 */