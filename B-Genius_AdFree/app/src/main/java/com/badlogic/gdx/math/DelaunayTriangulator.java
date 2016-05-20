package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.BooleanArray;
import com.badlogic.gdx.utils.FloatArray;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.ShortArray;

public class DelaunayTriangulator
{
  private static final int COMPLETE = 1;
  private static final float EPSILON = 1.0E-006F;
  private static final int INCOMPLETE = 2;
  private static final int INSIDE;
  private final Vector2 centroid = new Vector2();
  private final BooleanArray complete = new BooleanArray(false, 16);
  private final IntArray edges = new IntArray();
  private final ShortArray originalIndices = new ShortArray(false, 0);
  private final IntArray quicksortStack = new IntArray();
  private float[] sortedPoints;
  private final float[] superTriangle = new float[6];
  private final ShortArray triangles = new ShortArray(false, 16);

  private int circumCircle(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = Math.abs(paramFloat4 - paramFloat6);
    float f2 = Math.abs(paramFloat6 - paramFloat8);
    float f8;
    float f9;
    if (f1 < 1.0E-006F)
    {
      if (f2 < 1.0E-006F)
        return 2;
      float f16 = -(paramFloat7 - paramFloat5) / (paramFloat8 - paramFloat6);
      float f17 = (paramFloat5 + paramFloat7) / 2.0F;
      float f18 = (paramFloat6 + paramFloat8) / 2.0F;
      f8 = (paramFloat5 + paramFloat3) / 2.0F;
      f9 = f18 + f16 * (f8 - f17);
    }
    float f12;
    float f14;
    while (true)
    {
      float f10 = paramFloat5 - f8;
      float f11 = paramFloat6 - f9;
      f12 = f10 * f10 + f11 * f11;
      float f13 = paramFloat1 - f8;
      f14 = f13 * f13;
      float f15 = paramFloat2 - f9;
      if (f14 + f15 * f15 - f12 > 1.0E-006F)
        break;
      return 0;
      float f3 = -(paramFloat5 - paramFloat3) / (paramFloat6 - paramFloat4);
      float f4 = (paramFloat3 + paramFloat5) / 2.0F;
      float f5 = (paramFloat4 + paramFloat6) / 2.0F;
      if (f2 < 1.0E-006F)
      {
        f8 = (paramFloat7 + paramFloat5) / 2.0F;
        f9 = f5 + f3 * (f8 - f4);
        continue;
      }
      float f6 = -(paramFloat7 - paramFloat5) / (paramFloat8 - paramFloat6);
      float f7 = (paramFloat5 + paramFloat7) / 2.0F;
      f8 = ((paramFloat6 + paramFloat8) / 2.0F + (f3 * f4 - f7 * f6) - f5) / (f3 - f6);
      f9 = f5 + f3 * (f8 - f4);
    }
    if ((paramFloat1 > f8) && (f14 > f12))
      return 1;
    return 2;
  }

  private int quicksortPartition(float[] paramArrayOfFloat, int paramInt1, int paramInt2, short[] paramArrayOfShort)
  {
    float f1 = paramArrayOfFloat[paramInt1];
    int i = paramInt1 + 2;
    int j = paramInt2;
    while (i < j)
    {
      while ((i < j) && (paramArrayOfFloat[i] <= f1))
        i += 2;
      while (paramArrayOfFloat[j] > f1)
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
    float f2 = paramArrayOfFloat[(paramInt1 + 1)];
    paramArrayOfFloat[(paramInt1 + 1)] = paramArrayOfFloat[(j + 1)];
    paramArrayOfFloat[(j + 1)] = f2;
    int k = paramArrayOfShort[(paramInt1 / 2)];
    paramArrayOfShort[(paramInt1 / 2)] = paramArrayOfShort[(j / 2)];
    paramArrayOfShort[(j / 2)] = k;
    return j;
  }

  private void sort(float[] paramArrayOfFloat, int paramInt)
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
      int i1 = quicksortPartition(paramArrayOfFloat, n, m, arrayOfShort);
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

  public ShortArray computeTriangles(FloatArray paramFloatArray, boolean paramBoolean)
  {
    return computeTriangles(paramFloatArray.items, 0, paramFloatArray.size, paramBoolean);
  }

  public ShortArray computeTriangles(float[] paramArrayOfFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ShortArray localShortArray = this.triangles;
    localShortArray.clear();
    if (paramInt2 < 6)
      return localShortArray;
    localShortArray.ensureCapacity(paramInt2);
    if (!paramBoolean)
    {
      if ((this.sortedPoints == null) || (this.sortedPoints.length < paramInt2))
        this.sortedPoints = new float[paramInt2];
      float[] arrayOfFloat2 = this.sortedPoints;
      System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat2, 0, paramInt2);
      paramArrayOfFloat = this.sortedPoints;
      paramInt1 = 0;
      sort(paramArrayOfFloat, paramInt2);
    }
    int i = paramInt1 + paramInt2;
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    int j = paramInt1 + 2;
    float f3 = f2;
    float f4 = f1;
    float f18;
    if (j < i)
    {
      f18 = paramArrayOfFloat[j];
      if (f18 < f4)
        f4 = f18;
      if (f18 <= f1)
        break label1142;
    }
    while (true)
    {
      int i21 = j + 1;
      float f19 = paramArrayOfFloat[i21];
      float f20;
      if (f19 < f3)
        f20 = f19;
      while (true)
      {
        if (f19 > f2);
        while (true)
        {
          int i22 = i21 + 1;
          f3 = f20;
          j = i22;
          f2 = f19;
          f1 = f18;
          break;
          float f5 = f1 - f4;
          float f6 = f2 - f3;
          float[] arrayOfFloat1;
          IntArray localIntArray;
          BooleanArray localBooleanArray;
          if (f5 > f6)
          {
            float f7 = f5 * 20.0F;
            float f8 = (f1 + f4) / 2.0F;
            float f9 = (f2 + f3) / 2.0F;
            arrayOfFloat1 = this.superTriangle;
            arrayOfFloat1[0] = (f8 - f7);
            arrayOfFloat1[1] = (f9 - f7);
            arrayOfFloat1[2] = f8;
            arrayOfFloat1[3] = (f9 + f7);
            arrayOfFloat1[4] = (f8 + f7);
            arrayOfFloat1[5] = (f9 - f7);
            localIntArray = this.edges;
            localIntArray.ensureCapacity(paramInt2 / 2);
            localBooleanArray = this.complete;
            localBooleanArray.clear();
            localBooleanArray.ensureCapacity(paramInt2);
            localShortArray.add(i);
            localShortArray.add(i + 2);
            localShortArray.add(i + 4);
            localBooleanArray.add(false);
          }
          for (int k = paramInt1; ; k += 2)
          {
            if (k >= i)
              break label903;
            float f10 = paramArrayOfFloat[k];
            float f11 = paramArrayOfFloat[(k + 1)];
            short[] arrayOfShort3 = localShortArray.items;
            boolean[] arrayOfBoolean = localBooleanArray.items;
            int i6 = -1 + localShortArray.size;
            label416: if (i6 >= 0)
            {
              int i14 = i6 / 3;
              int i15;
              int i16;
              int i17;
              float f12;
              float f13;
              label490: float f14;
              float f15;
              float f16;
              float f17;
              if (arrayOfBoolean[i14] == 0)
              {
                i15 = arrayOfShort3[(i6 - 2)];
                i16 = arrayOfShort3[(i6 - 1)];
                i17 = arrayOfShort3[i6];
                if (i15 < i)
                  break label605;
                int i20 = i15 - i;
                f12 = arrayOfFloat1[i20];
                f13 = arrayOfFloat1[(i20 + 1)];
                if (i16 < i)
                  break label622;
                int i19 = i16 - i;
                f14 = arrayOfFloat1[i19];
                f15 = arrayOfFloat1[(i19 + 1)];
                if (i17 < i)
                  break label639;
                int i18 = i17 - i;
                f16 = arrayOfFloat1[i18];
                f17 = arrayOfFloat1[(i18 + 1)];
                label550: switch (circumCircle(f10, f11, f12, f13, f14, f15, f16, f17))
                {
                default:
                case 1:
                case 0:
                }
              }
              while (true)
              {
                i6 -= 3;
                break label416;
                f5 = f6;
                break;
                label605: f12 = paramArrayOfFloat[i15];
                f13 = paramArrayOfFloat[(i15 + 1)];
                break label490;
                label622: f14 = paramArrayOfFloat[i16];
                f15 = paramArrayOfFloat[(i16 + 1)];
                break label520;
                label639: f16 = paramArrayOfFloat[i17];
                f17 = paramArrayOfFloat[(i17 + 1)];
                break label550;
                arrayOfBoolean[i14] = true;
                continue;
                localIntArray.add(i15);
                localIntArray.add(i16);
                localIntArray.add(i16);
                localIntArray.add(i17);
                localIntArray.add(i17);
                localIntArray.add(i15);
                localShortArray.removeIndex(i6);
                localShortArray.removeIndex(i6 - 1);
                localShortArray.removeIndex(i6 - 2);
                localBooleanArray.removeIndex(i14);
              }
            }
            label520: int[] arrayOfInt = localIntArray.items;
            int i7 = localIntArray.size;
            for (int i8 = 0; i8 < i7; i8 += 2)
            {
              int i9 = arrayOfInt[i8];
              if (i9 == -1)
                continue;
              int i10 = arrayOfInt[(i8 + 1)];
              int i11 = i8 + 2;
              int i12 = 0;
              for (int i13 = i11; i13 < i7; i13 += 2)
              {
                if ((i9 != arrayOfInt[(i13 + 1)]) || (i10 != arrayOfInt[i13]))
                  continue;
                i12 = 1;
                arrayOfInt[i13] = -1;
              }
              if (i12 != 0)
                continue;
              localShortArray.add(i9);
              localShortArray.add(arrayOfInt[(i8 + 1)]);
              localShortArray.add(k);
              localBooleanArray.add(false);
            }
            localIntArray.clear();
          }
          label903: short[] arrayOfShort1 = localShortArray.items;
          for (int m = -1 + localShortArray.size; m >= 0; m -= 3)
          {
            if ((arrayOfShort1[m] < i) && (arrayOfShort1[(m - 1)] < i) && (arrayOfShort1[(m - 2)] < i))
              continue;
            localShortArray.removeIndex(m);
            localShortArray.removeIndex(m - 1);
            localShortArray.removeIndex(m - 2);
          }
          if (!paramBoolean)
          {
            short[] arrayOfShort2 = this.originalIndices.items;
            int i4 = 0;
            int i5 = localShortArray.size;
            while (i4 < i5)
            {
              arrayOfShort1[i4] = (short)(arrayOfShort2[(arrayOfShort1[i4] / 2)] << 1);
              i4++;
            }
          }
          if (paramInt1 == 0)
          {
            int i2 = 0;
            int i3 = localShortArray.size;
            while (i2 < i3)
            {
              arrayOfShort1[i2] = (short)(arrayOfShort1[i2] / 2);
              i2++;
            }
          }
          int n = 0;
          int i1 = localShortArray.size;
          while (n < i1)
          {
            arrayOfShort1[n] = (short)((arrayOfShort1[n] - paramInt1) / 2);
            n++;
          }
          return localShortArray;
          f19 = f2;
        }
        f20 = f3;
      }
      label1142: f18 = f1;
    }
  }

  public ShortArray computeTriangles(float[] paramArrayOfFloat, boolean paramBoolean)
  {
    return computeTriangles(paramArrayOfFloat, 0, paramArrayOfFloat.length, paramBoolean);
  }

  public void trim(ShortArray paramShortArray, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int paramInt1, int paramInt2)
  {
    short[] arrayOfShort = paramShortArray.items;
    for (int i = -1 + paramShortArray.size; i >= 0; i -= 3)
    {
      int j = arrayOfShort[(i - 2)] << 1;
      int k = arrayOfShort[(i - 1)] << 1;
      int m = arrayOfShort[i] << 1;
      GeometryUtils.triangleCentroid(paramArrayOfFloat1[j], paramArrayOfFloat1[(j + 1)], paramArrayOfFloat1[k], paramArrayOfFloat1[(k + 1)], paramArrayOfFloat1[m], paramArrayOfFloat1[(m + 1)], this.centroid);
      if (Intersector.isPointInPolygon(paramArrayOfFloat2, paramInt1, paramInt2, this.centroid.x, this.centroid.y))
        continue;
      paramShortArray.removeIndex(i);
      paramShortArray.removeIndex(i - 1);
      paramShortArray.removeIndex(i - 2);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.DelaunayTriangulator
 * JD-Core Version:    0.6.0
 */