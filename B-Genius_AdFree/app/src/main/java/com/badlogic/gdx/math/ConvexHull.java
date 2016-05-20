package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class ConvexHull
{
  private final FloatArray hull = new FloatArray();
  private final IntArray indices = new IntArray();
  private final ShortArray originalIndices = new ShortArray(false, 0);
  private final IntArray quicksortStack = new IntArray();
  private float[] sortedPoints;

  private float ccw(float paramFloat1, float paramFloat2)
  {
    FloatArray localFloatArray = this.hull;
    int i = localFloatArray.size;
    float f1 = localFloatArray.get(i - 4);
    float f2 = localFloatArray.get(i - 3);
    float f3 = localFloatArray.get(i - 2);
    float f4 = localFloatArray.peek();
    return (f3 - f1) * (paramFloat2 - f2) - (f4 - f2) * (paramFloat1 - f1);
  }

  private int quicksortPartition(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f1 = paramArrayOfFloat[paramInt1];
    float f2 = paramArrayOfFloat[(paramInt1 + 1)];
    int i = paramInt1;
    int j = paramInt2;
    while (i < j)
    {
      while ((i < j) && (paramArrayOfFloat[i] <= f1))
        i += 2;
      while ((paramArrayOfFloat[j] > f1) || ((paramArrayOfFloat[j] == f1) && (paramArrayOfFloat[(j + 1)] < f2)))
        j -= 2;
      if (i >= j)
        continue;
      float f3 = paramArrayOfFloat[i];
      paramArrayOfFloat[i] = paramArrayOfFloat[j];
      paramArrayOfFloat[j] = f3;
      float f4 = paramArrayOfFloat[(i + 1)];
      paramArrayOfFloat[(i + 1)] = paramArrayOfFloat[(j + 1)];
      paramArrayOfFloat[(j + 1)] = f4;
    }
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[j];
    paramArrayOfFloat[j] = f1;
    paramArrayOfFloat[(paramInt1 + 1)] = paramArrayOfFloat[(j + 1)];
    paramArrayOfFloat[(j + 1)] = f2;
    return j;
  }

  private int quicksortPartitionWithIndices(float[] paramArrayOfFloat, int paramInt1, int paramInt2, boolean paramBoolean, short[] paramArrayOfShort)
  {
    float f1 = paramArrayOfFloat[paramInt1];
    float f2 = paramArrayOfFloat[(paramInt1 + 1)];
    int i = paramInt1;
    int j = paramInt2;
    while (i < j)
    {
      while ((i < j) && (paramArrayOfFloat[i] <= f1))
        i += 2;
      if (paramBoolean)
        while ((paramArrayOfFloat[j] > f1) || ((paramArrayOfFloat[j] == f1) && (paramArrayOfFloat[(j + 1)] < f2)))
          j -= 2;
      while ((paramArrayOfFloat[j] > f1) || ((paramArrayOfFloat[j] == f1) && (paramArrayOfFloat[(j + 1)] > f2)))
        j -= 2;
      if (i >= j)
        continue;
      float f3 = paramArrayOfFloat[i];
      paramArrayOfFloat[i] = paramArrayOfFloat[j];
      paramArrayOfFloat[j] = f3;
      float f4 = paramArrayOfFloat[(i + 1)];
      paramArrayOfFloat[(i + 1)] = paramArrayOfFloat[(j + 1)];
      paramArrayOfFloat[(j + 1)] = f4;
      int m = paramArrayOfShort[(i / 2)];
      paramArrayOfShort[(i / 2)] = paramArrayOfShort[(j / 2)];
      paramArrayOfShort[(j / 2)] = m;
    }
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[j];
    paramArrayOfFloat[j] = f1;
    paramArrayOfFloat[(paramInt1 + 1)] = paramArrayOfFloat[(j + 1)];
    paramArrayOfFloat[(j + 1)] = f2;
    int k = paramArrayOfShort[(paramInt1 / 2)];
    paramArrayOfShort[(paramInt1 / 2)] = paramArrayOfShort[(j / 2)];
    paramArrayOfShort[(j / 2)] = k;
    return j;
  }

  private void sort(float[] paramArrayOfFloat, int paramInt)
  {
    int i = paramInt - 1;
    IntArray localIntArray = this.quicksortStack;
    localIntArray.add(0);
    localIntArray.add(i - 1);
    while (localIntArray.size > 0)
    {
      int j = localIntArray.pop();
      int k = localIntArray.pop();
      if (j <= k)
        continue;
      int m = quicksortPartition(paramArrayOfFloat, k, j);
      if (m - k > j - m)
      {
        localIntArray.add(k);
        localIntArray.add(m - 2);
      }
      localIntArray.add(m + 2);
      localIntArray.add(j);
      if (j - m < m - k)
        continue;
      localIntArray.add(k);
      localIntArray.add(m - 2);
    }
  }

  private void sortWithIndices(float[] paramArrayOfFloat, int paramInt, boolean paramBoolean)
  {
    int i = paramInt / 2;
    this.originalIndices.clear();
    this.originalIndices.ensureCapacity(i);
    short[] arrayOfShort = this.originalIndices.items;
    for (int j = 0; j < i; j = (short)(j + 1))
      arrayOfShort[j] = j;
    int k = paramInt - 1;
    IntArray localIntArray = this.quicksortStack;
    localIntArray.add(0);
    localIntArray.add(k - 1);
    while (localIntArray.size > 0)
    {
      int m = localIntArray.pop();
      int n = localIntArray.pop();
      if (m <= n)
        continue;
      int i1 = quicksortPartitionWithIndices(paramArrayOfFloat, n, m, paramBoolean, arrayOfShort);
      if (i1 - n > m - i1)
      {
        localIntArray.add(n);
        localIntArray.add(i1 - 2);
      }
      localIntArray.add(i1 + 2);
      localIntArray.add(m);
      if (m - i1 < i1 - n)
        continue;
      localIntArray.add(n);
      localIntArray.add(i1 - 2);
    }
  }

  public IntArray computeIndices(FloatArray paramFloatArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    return computeIndices(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean1, paramBoolean2);
  }

  public IntArray computeIndices(float[] paramArrayOfFloat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt1 + paramInt2;
    if (!paramBoolean1)
    {
      if ((this.sortedPoints == null) || (this.sortedPoints.length < paramInt2))
        this.sortedPoints = new float[paramInt2];
      System.arraycopy(paramArrayOfFloat, paramInt1, this.sortedPoints, 0, paramInt2);
      paramArrayOfFloat = this.sortedPoints;
      paramInt1 = 0;
      sortWithIndices(paramArrayOfFloat, paramInt2, paramBoolean2);
    }
    IntArray localIntArray = this.indices;
    localIntArray.clear();
    FloatArray localFloatArray = this.hull;
    localFloatArray.clear();
    int j = paramInt1 / 2;
    int k = paramInt1;
    while (k < i)
    {
      float f3 = paramArrayOfFloat[k];
      float f4 = paramArrayOfFloat[(k + 1)];
      while ((localFloatArray.size >= 4) && (ccw(f3, f4) <= 0.0F))
      {
        localFloatArray.size = (-2 + localFloatArray.size);
        localIntArray.size = (-1 + localIntArray.size);
      }
      localFloatArray.add(f3);
      localFloatArray.add(f4);
      localIntArray.add(j);
      k += 2;
      j++;
    }
    int m = i - 4;
    int n = m / 2;
    int i1 = 2 + localFloatArray.size;
    while (m >= paramInt1)
    {
      float f1 = paramArrayOfFloat[m];
      float f2 = paramArrayOfFloat[(m + 1)];
      while ((localFloatArray.size >= i1) && (ccw(f1, f2) <= 0.0F))
      {
        localFloatArray.size = (-2 + localFloatArray.size);
        localIntArray.size = (-1 + localIntArray.size);
      }
      localFloatArray.add(f1);
      localFloatArray.add(f2);
      localIntArray.add(n);
      m -= 2;
      n--;
    }
    if (!paramBoolean1)
    {
      short[] arrayOfShort = this.originalIndices.items;
      int[] arrayOfInt = localIntArray.items;
      int i2 = 0;
      int i3 = localIntArray.size;
      while (i2 < i3)
      {
        arrayOfInt[i2] = arrayOfShort[arrayOfInt[i2]];
        i2++;
      }
    }
    return localIntArray;
  }

  public IntArray computeIndices(float[] paramArrayOfFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    return computeIndices(paramArrayOfFloat, 0, paramArrayOfFloat.length, paramBoolean1, paramBoolean2);
  }

  public FloatArray computePolygon(FloatArray paramFloatArray, boolean paramBoolean)
  {
    return computePolygon(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean);
  }

  public FloatArray computePolygon(float[] paramArrayOfFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = paramInt1 + paramInt2;
    if (!paramBoolean)
    {
      if ((this.sortedPoints == null) || (this.sortedPoints.length < paramInt2))
        this.sortedPoints = new float[paramInt2];
      System.arraycopy(paramArrayOfFloat, paramInt1, this.sortedPoints, 0, paramInt2);
      paramArrayOfFloat = this.sortedPoints;
      sort(paramArrayOfFloat, paramInt2);
      paramInt1 = 0;
    }
    FloatArray localFloatArray = this.hull;
    localFloatArray.clear();
    for (int j = paramInt1; j < i; j += 2)
    {
      float f3 = paramArrayOfFloat[j];
      float f4 = paramArrayOfFloat[(j + 1)];
      while ((localFloatArray.size >= 4) && (ccw(f3, f4) <= 0.0F))
        localFloatArray.size = (-2 + localFloatArray.size);
      localFloatArray.add(f3);
      localFloatArray.add(f4);
    }
    int k = i - 4;
    int m = 2 + localFloatArray.size;
    while (k >= paramInt1)
    {
      float f1 = paramArrayOfFloat[k];
      float f2 = paramArrayOfFloat[(k + 1)];
      while ((localFloatArray.size >= m) && (ccw(f1, f2) <= 0.0F))
        localFloatArray.size = (-2 + localFloatArray.size);
      localFloatArray.add(f1);
      localFloatArray.add(f2);
      k -= 2;
    }
    return localFloatArray;
  }

  public FloatArray computePolygon(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    return computePolygon(paramArrayOfFloat, 0, paramArrayOfFloat.length, paramBoolean);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.ConvexHull
 * JD-Core Version:    0.6.0
 */