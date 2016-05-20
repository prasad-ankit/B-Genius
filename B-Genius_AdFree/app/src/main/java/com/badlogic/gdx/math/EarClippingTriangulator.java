package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class EarClippingTriangulator
{
  private static final int CONCAVE = -1;
  private static final int CONVEX = 1;
  private static final int TANGENTIAL;
  private short[] indices;
  private final ShortArray indicesArray = new ShortArray();
  private final ShortArray triangles = new ShortArray();
  private int vertexCount;
  private final IntArray vertexTypes = new IntArray();
  private float[] vertices;

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
      int j = paramInt1;
      f1 = 0.0F;
      while (j < i)
      {
        float f5 = paramArrayOfFloat[j];
        float f6 = paramArrayOfFloat[(j + 1)];
        float f7 = paramArrayOfFloat[(j + 2)];
        f1 += f5 * paramArrayOfFloat[(j + 3)] - f6 * f7;
        j += 2;
      }
      f2 = paramArrayOfFloat[(-2 + (paramInt1 + paramInt2))];
      f3 = paramArrayOfFloat[(-1 + (paramInt1 + paramInt2))];
      f4 = paramArrayOfFloat[paramInt1];
    }
    while (f1 + f2 * paramArrayOfFloat[(paramInt1 + 1)] - f4 * f3 >= 0.0F);
    return true;
  }

  private int classifyVertex(int paramInt)
  {
    short[] arrayOfShort = this.indices;
    int i = arrayOfShort[previousIndex(paramInt)] << 1;
    int j = arrayOfShort[paramInt] << 1;
    int k = arrayOfShort[nextIndex(paramInt)] << 1;
    float[] arrayOfFloat = this.vertices;
    return computeSpannedAreaSign(arrayOfFloat[i], arrayOfFloat[(i + 1)], arrayOfFloat[j], arrayOfFloat[(j + 1)], arrayOfFloat[k], arrayOfFloat[(k + 1)]);
  }

  private static int computeSpannedAreaSign(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return (int)Math.signum(paramFloat1 * (paramFloat6 - paramFloat4) + paramFloat3 * (paramFloat2 - paramFloat6) + paramFloat5 * (paramFloat4 - paramFloat2));
  }

  private void cutEarTip(int paramInt)
  {
    short[] arrayOfShort = this.indices;
    ShortArray localShortArray = this.triangles;
    localShortArray.add(arrayOfShort[previousIndex(paramInt)]);
    localShortArray.add(arrayOfShort[paramInt]);
    localShortArray.add(arrayOfShort[nextIndex(paramInt)]);
    this.indicesArray.removeIndex(paramInt);
    this.vertexTypes.removeIndex(paramInt);
    this.vertexCount = (-1 + this.vertexCount);
  }

  private int findEarTip()
  {
    int i = this.vertexCount;
    for (int j = 0; j < i; j++)
      if (isEarTip(j))
        return j;
    int[] arrayOfInt = this.vertexTypes.items;
    for (j = 0; ; j++)
    {
      if (j >= i)
        break label56;
      if (arrayOfInt[j] != -1)
        break;
    }
    label56: return 0;
  }

  private boolean isEarTip(int paramInt)
  {
    int[] arrayOfInt = this.vertexTypes.items;
    if (arrayOfInt[paramInt] == -1)
      return false;
    int i = previousIndex(paramInt);
    int j = nextIndex(paramInt);
    short[] arrayOfShort = this.indices;
    int k = arrayOfShort[i] << 1;
    int m = arrayOfShort[paramInt] << 1;
    int n = arrayOfShort[j] << 1;
    float[] arrayOfFloat = this.vertices;
    float f1 = arrayOfFloat[k];
    float f2 = arrayOfFloat[(k + 1)];
    float f3 = arrayOfFloat[m];
    float f4 = arrayOfFloat[(m + 1)];
    float f5 = arrayOfFloat[n];
    float f6 = arrayOfFloat[(n + 1)];
    for (int i1 = nextIndex(j); i1 != i; i1 = nextIndex(i1))
    {
      if (arrayOfInt[i1] == 1)
        continue;
      int i2 = arrayOfShort[i1] << 1;
      float f7 = arrayOfFloat[i2];
      float f8 = arrayOfFloat[(i2 + 1)];
      if ((computeSpannedAreaSign(f5, f6, f1, f2, f7, f8) >= 0) && (computeSpannedAreaSign(f1, f2, f3, f4, f7, f8) >= 0) && (computeSpannedAreaSign(f3, f4, f5, f6, f7, f8) >= 0))
        return false;
    }
    return true;
  }

  private int nextIndex(int paramInt)
  {
    return (paramInt + 1) % this.vertexCount;
  }

  private int previousIndex(int paramInt)
  {
    if (paramInt == 0)
      paramInt = this.vertexCount;
    return paramInt - 1;
  }

  private void triangulate()
  {
    int[] arrayOfInt = this.vertexTypes.items;
    while (this.vertexCount > 3)
    {
      int i = findEarTip();
      cutEarTip(i);
      int j = previousIndex(i);
      if (i == this.vertexCount)
        i = 0;
      arrayOfInt[j] = classifyVertex(j);
      arrayOfInt[i] = classifyVertex(i);
    }
    if (this.vertexCount == 3)
    {
      ShortArray localShortArray = this.triangles;
      short[] arrayOfShort = this.indices;
      localShortArray.add(arrayOfShort[0]);
      localShortArray.add(arrayOfShort[1]);
      localShortArray.add(arrayOfShort[2]);
    }
  }

  public ShortArray computeTriangles(FloatArray paramFloatArray)
  {
    return computeTriangles(paramFloatArray.items, 0, paramFloatArray.size);
  }

  public ShortArray computeTriangles(float[] paramArrayOfFloat)
  {
    return computeTriangles(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public ShortArray computeTriangles(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.vertices = paramArrayOfFloat;
    int i = paramInt2 / 2;
    this.vertexCount = i;
    int j = paramInt1 / 2;
    ShortArray localShortArray1 = this.indicesArray;
    localShortArray1.clear();
    localShortArray1.ensureCapacity(i);
    localShortArray1.size = i;
    short[] arrayOfShort = localShortArray1.items;
    this.indices = arrayOfShort;
    if (areVerticesClockwise(paramArrayOfFloat, paramInt1, paramInt2))
      for (int i1 = 0; i1 < i; i1 = (short)(i1 + 1))
        arrayOfShort[i1] = (short)(j + i1);
    int k = i - 1;
    for (int m = 0; m < i; m++)
      arrayOfShort[m] = (short)(j + k - m);
    IntArray localIntArray = this.vertexTypes;
    localIntArray.clear();
    localIntArray.ensureCapacity(i);
    for (int n = 0; n < i; n++)
      localIntArray.add(classifyVertex(n));
    ShortArray localShortArray2 = this.triangles;
    localShortArray2.clear();
    localShortArray2.ensureCapacity(3 * Math.max(0, i - 2));
    triangulate();
    return localShortArray2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.EarClippingTriangulator
 * JD-Core Version:    0.6.0
 */