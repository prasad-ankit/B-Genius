package com.badlogic.gdx.utils;

import java.util.Arrays;
import java.util.Comparator;

class TimSort
{
  private static final boolean DEBUG = false;
  private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
  private static final int MIN_GALLOP = 7;
  private static final int MIN_MERGE = 32;
  private Object[] a;
  private Comparator c;
  private int minGallop = 7;
  private final int[] runBase;
  private final int[] runLen;
  private int stackSize = 0;
  private Object[] tmp;
  private int tmpCount;

  TimSort()
  {
    this.tmp = ((Object[])new Object[256]);
    this.runBase = new int[40];
    this.runLen = new int[40];
  }

  private TimSort(Object[] paramArrayOfObject, Comparator paramComparator)
  {
    this.a = paramArrayOfObject;
    this.c = paramComparator;
    int i = paramArrayOfObject.length;
    int j;
    int k;
    if (i < 512)
    {
      j = i >>> 1;
      this.tmp = ((Object[])new Object[j]);
      if (i >= 120)
        break label86;
      k = 5;
    }
    while (true)
    {
      this.runBase = new int[k];
      this.runLen = new int[k];
      return;
      j = 256;
      break;
      label86: if (i < 1542)
      {
        k = 10;
        continue;
      }
      if (i < 119151)
      {
        k = 19;
        continue;
      }
      k = 40;
    }
  }

  private static void binarySort(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, Comparator paramComparator)
  {
    int i;
    if (paramInt3 == paramInt1)
      i = paramInt3 + 1;
    while (true)
    {
      if (i < paramInt2)
      {
        Object localObject = paramArrayOfObject[i];
        int j = i;
        int k = paramInt1;
        while (k < j)
        {
          int n = k + j >>> 1;
          if (paramComparator.compare(localObject, paramArrayOfObject[n]) < 0)
          {
            j = n;
            continue;
          }
          k = n + 1;
        }
        int m = i - k;
        switch (m)
        {
        default:
          System.arraycopy(paramArrayOfObject, k, paramArrayOfObject, k + 1, m);
        case 2:
        case 1:
        }
        while (true)
        {
          paramArrayOfObject[k] = localObject;
          i++;
          break;
          paramArrayOfObject[(k + 2)] = paramArrayOfObject[(k + 1)];
          paramArrayOfObject[(k + 1)] = paramArrayOfObject[k];
        }
      }
      return;
      i = paramInt3;
    }
  }

  private static int countRunAndMakeAscending(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Comparator paramComparator)
  {
    int i = paramInt1 + 1;
    if (i == paramInt2)
      return 1;
    int j = i + 1;
    if (paramComparator.compare(paramArrayOfObject[i], paramArrayOfObject[paramInt1]) < 0)
    {
      while ((j < paramInt2) && (paramComparator.compare(paramArrayOfObject[j], paramArrayOfObject[(j - 1)]) < 0))
        j++;
      reverseRange(paramArrayOfObject, paramInt1, j);
    }
    while (true)
    {
      return j - paramInt1;
      while ((j < paramInt2) && (paramComparator.compare(paramArrayOfObject[j], paramArrayOfObject[(j - 1)]) >= 0))
        j++;
    }
  }

  private Object[] ensureCapacity(int paramInt)
  {
    this.tmpCount = Math.max(this.tmpCount, paramInt);
    int n;
    if (this.tmp.length < paramInt)
    {
      int i = paramInt | paramInt >> 1;
      int j = i | i >> 2;
      int k = j | j >> 4;
      int m = k | k >> 8;
      n = 1 + (m | m >> 16);
      if (n >= 0)
        break label83;
    }
    while (true)
    {
      this.tmp = ((Object[])new Object[paramInt]);
      return this.tmp;
      label83: paramInt = Math.min(n, this.a.length >>> 1);
    }
  }

  private static int gallopLeft(Object paramObject, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, Comparator paramComparator)
  {
    int i = 0;
    int j = 1;
    int i4;
    if (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + paramInt3)]) > 0)
      i4 = paramInt2 - paramInt3;
    while (true)
    {
      int i5;
      if ((j < i4) && (paramComparator.compare(paramObject, paramArrayOfObject[(j + (paramInt1 + paramInt3))]) > 0))
      {
        i5 = 1 + (j << 1);
        if (i5 <= 0)
        {
          i = j;
          j = i4;
          continue;
        }
      }
      else
      {
        if (j > i4);
        while (true)
        {
          int m = i + paramInt3;
          int n = i4 + paramInt3;
          int i1 = m + 1;
          label107: int i2;
          int k;
          while (true)
          {
            if (i1 >= n)
              break label240;
            i2 = i1 + (n - i1 >>> 1);
            if (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + i2)]) <= 0)
              break;
            i1 = i2 + 1;
            continue;
            k = paramInt3 + 1;
          }
          while (true)
          {
            int i3;
            if ((j < k) && (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + paramInt3 - j)]) <= 0))
            {
              i3 = 1 + (j << 1);
              if (i3 <= 0)
              {
                i = j;
                j = k;
                continue;
              }
            }
            else
            {
              if (j > k);
              while (true)
              {
                m = paramInt3 - k;
                n = paramInt3 - i;
                break;
                n = i2;
                break label107;
                label240: return n;
                k = j;
              }
            }
            i = j;
            j = i3;
          }
          i4 = j;
        }
      }
      i = j;
      j = i5;
    }
  }

  private static int gallopRight(Object paramObject, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3, Comparator paramComparator)
  {
    int i6;
    int i7;
    int i8;
    if (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + paramInt3)]) < 0)
    {
      i6 = paramInt3 + 1;
      i7 = 1;
      i8 = 0;
    }
    while (true)
    {
      int i9;
      if ((i7 < i6) && (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + paramInt3 - i7)]) < 0))
      {
        i9 = 1 + (i7 << 1);
        if (i9 <= 0)
        {
          i8 = i7;
          i7 = i6;
          continue;
        }
      }
      else
      {
        if (i7 > i6);
        while (true)
        {
          int i1 = paramInt3 - i6;
          int n = paramInt3 - i8;
          int i2 = i1 + 1;
          label107: int i3;
          int i;
          int j;
          int k;
          while (true)
          {
            if (i2 >= n)
              break label250;
            i3 = i2 + (n - i2 >>> 1);
            if (paramComparator.compare(paramObject, paramArrayOfObject[(paramInt1 + i3)]) >= 0)
              break;
            n = i3;
            continue;
            i = paramInt2 - paramInt3;
            j = 1;
            k = 0;
          }
          while (true)
          {
            int i4;
            if ((j < i) && (paramComparator.compare(paramObject, paramArrayOfObject[(j + (paramInt1 + paramInt3))]) >= 0))
            {
              i4 = 1 + (j << 1);
              if (i4 <= 0)
              {
                k = j;
                j = i;
                continue;
              }
            }
            else
            {
              if (j > i);
              while (true)
              {
                int m = k + paramInt3;
                n = i + paramInt3;
                i1 = m;
                break;
                i2 = i3 + 1;
                break label107;
                label250: return n;
                i = j;
              }
            }
            int i5 = j;
            j = i4;
            k = i5;
          }
          i6 = i7;
        }
      }
      int i10 = i7;
      i7 = i9;
      i8 = i10;
    }
  }

  private void mergeAt(int paramInt)
  {
    int i = this.runBase[paramInt];
    int j = this.runLen[paramInt];
    int k = this.runBase[(paramInt + 1)];
    int m = this.runLen[(paramInt + 1)];
    this.runLen[paramInt] = (j + m);
    if (paramInt == -3 + this.stackSize)
    {
      this.runBase[(paramInt + 1)] = this.runBase[(paramInt + 2)];
      this.runLen[(paramInt + 1)] = this.runLen[(paramInt + 2)];
    }
    this.stackSize = (-1 + this.stackSize);
    int n = gallopRight(this.a[k], this.a, i, j, 0, this.c);
    int i1 = i + n;
    int i2 = j - n;
    if (i2 == 0);
    int i3;
    do
    {
      return;
      i3 = gallopLeft(this.a[(-1 + (i1 + i2))], this.a, k, m, m - 1, this.c);
    }
    while (i3 == 0);
    if (i2 <= i3)
    {
      mergeLo(i1, i2, k, i3);
      return;
    }
    mergeHi(i1, i2, k, i3);
  }

  private void mergeCollapse()
  {
    if (this.stackSize > 1)
    {
      int i = -2 + this.stackSize;
      if (((i > 0) && (this.runLen[(i - 1)] <= this.runLen[i] + this.runLen[(i + 1)])) || ((i >= 2) && (this.runLen[(i - 2)] <= this.runLen[i] + this.runLen[(i - 1)])))
        if (this.runLen[(i - 1)] < this.runLen[(i + 1)])
          i--;
      do
      {
        mergeAt(i);
        break;
      }
      while (this.runLen[i] <= this.runLen[(i + 1)]);
    }
  }

  private void mergeForceCollapse()
  {
    while (this.stackSize > 1)
    {
      int i = -2 + this.stackSize;
      if ((i > 0) && (this.runLen[(i - 1)] < this.runLen[(i + 1)]))
        i--;
      mergeAt(i);
    }
  }

  private void mergeHi(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject1 = this.a;
    Object[] arrayOfObject2 = ensureCapacity(paramInt4);
    System.arraycopy(arrayOfObject1, paramInt3, arrayOfObject2, 0, paramInt4);
    int i = -1 + (paramInt1 + paramInt2);
    int j = paramInt4 - 1;
    int k = -1 + (paramInt3 + paramInt4);
    int m = k - 1;
    int n = i - 1;
    arrayOfObject1[k] = arrayOfObject1[i];
    int i1 = paramInt2 - 1;
    if (i1 == 0)
    {
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, m - j, paramInt4);
      return;
    }
    if (paramInt4 == 1)
    {
      int i31 = m - i1;
      System.arraycopy(arrayOfObject1, 1 + (n - i1), arrayOfObject1, i31 + 1, i1);
      arrayOfObject1[i31] = arrayOfObject2[j];
      return;
    }
    Comparator localComparator = this.c;
    int i2 = this.minGallop;
    int i3 = m;
    int i4 = j;
    int i5 = 0;
    int i6 = n;
    int i7 = 0;
    int i8 = i1;
    int i9 = i6;
    label661: label700: label837: 
    while (true)
    {
      int i28;
      int i29;
      int i30;
      int i12;
      int i13;
      label247: int i10;
      int i11;
      if (localComparator.compare(arrayOfObject2[i4], arrayOfObject1[i9]) < 0)
      {
        i28 = i3 - 1;
        i29 = i9 - 1;
        arrayOfObject1[i3] = arrayOfObject1[i9];
        i30 = i7 + 1;
        i12 = i8 - 1;
        if (i12 != 0)
          break label817;
        i9 = i29;
        i13 = i28;
        j = i4;
        if (i2 <= 0)
          i2 = 1;
        this.minGallop = i2;
        if (paramInt4 == 1)
        {
          int i14 = i13 - i12;
          System.arraycopy(arrayOfObject1, 1 + (i9 - i12), arrayOfObject1, i14 + 1, i12);
          arrayOfObject1[i14] = arrayOfObject2[j];
          return;
        }
      }
      else
      {
        i10 = i3 - 1;
        i11 = i4 - 1;
        arrayOfObject1[i3] = arrayOfObject2[i4];
        i5++;
        paramInt4--;
        if (paramInt4 == 1)
          break label802;
        i3 = i10;
        i7 = 0;
        i4 = i11;
      }
      while (true)
      {
        if ((i7 | i5) < i2)
          break label837;
        int i15 = i2;
        int i16 = i8;
        int i17 = i3;
        int i18 = i9;
        int i19 = i4;
        label380: int i20 = i16 - gallopRight(arrayOfObject2[i19], arrayOfObject1, paramInt1, i16, i16 - 1, localComparator);
        if (i20 != 0)
        {
          i17 -= i20;
          i18 -= i20;
          i16 -= i20;
          System.arraycopy(arrayOfObject1, i18 + 1, arrayOfObject1, i17 + 1, i20);
          if (i16 == 0);
        }
        else
        {
          int i21 = i18;
          i12 = i16;
          i13 = i17 - 1;
          j = i19 - 1;
          arrayOfObject1[i17] = arrayOfObject2[i19];
          int i22 = paramInt4 - 1;
          if (i22 != 1)
          {
            int i23 = i22 - gallopLeft(arrayOfObject1[i21], arrayOfObject2, 0, i22, i22 - 1, localComparator);
            if (i23 != 0)
            {
              i13 -= i23;
              j -= i23;
              paramInt4 = i22 - i23;
              System.arraycopy(arrayOfObject2, j + 1, arrayOfObject1, i13 + 1, i23);
              if (paramInt4 <= 1);
            }
            for (int i24 = i13; ; i24 = i13)
            {
              m = i24 - 1;
              n = i21 - 1;
              arrayOfObject1[i24] = arrayOfObject1[i21];
              i1 = i12 - 1;
              if (i1 != 0)
              {
                int i25 = i15 - 1;
                int i26;
                if (i20 >= 7)
                {
                  i26 = 1;
                  label620: if (i23 < 7)
                    break label661;
                }
                for (int i27 = 1; ; i27 = 0)
                {
                  if ((i27 | i26) != 0)
                    break label700;
                  if (i25 < 0)
                    i25 = 0;
                  i2 = i25 + 2;
                  break;
                  i26 = 0;
                  break label620;
                }
                if (paramInt4 == 0)
                  throw new IllegalArgumentException("Comparison method violates its general contract!");
                System.arraycopy(arrayOfObject2, 0, arrayOfObject1, i13 - (paramInt4 - 1), paramInt4);
                return;
                i15 = i25;
                i18 = n;
                i17 = m;
                i16 = i1;
                i19 = j;
                break label380;
              }
              i2 = i15;
              i12 = i1;
              i9 = n;
              i13 = m;
              break label247;
              i9 = i21;
              i2 = i15;
              break label247;
              paramInt4 = i22;
            }
          }
          i9 = i21;
          paramInt4 = i22;
          i2 = i15;
          break label247;
        }
        i2 = i15;
        j = i19;
        i12 = i16;
        i13 = i17;
        i9 = i18;
        break label247;
        j = i11;
        i12 = i8;
        i13 = i10;
        break label247;
        i3 = i28;
        i8 = i12;
        i7 = i30;
        i9 = i29;
        i5 = 0;
      }
    }
  }

  private void mergeLo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject1 = this.a;
    Object[] arrayOfObject2 = ensureCapacity(paramInt2);
    System.arraycopy(arrayOfObject1, paramInt1, arrayOfObject2, 0, paramInt2);
    int i = 0;
    int j = paramInt1 + 1;
    int k = paramInt3 + 1;
    arrayOfObject1[paramInt1] = arrayOfObject1[paramInt3];
    int m = paramInt4 - 1;
    if (m == 0)
    {
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, j, paramInt2);
      return;
    }
    if (paramInt2 == 1)
    {
      System.arraycopy(arrayOfObject1, k, arrayOfObject1, j, m);
      arrayOfObject1[(j + m)] = arrayOfObject2[0];
      return;
    }
    Comparator localComparator = this.c;
    int n = this.minGallop;
    int i1 = i;
    int i2 = j;
    int i3 = 0;
    int i4 = k;
    int i5 = 0;
    int i6 = m;
    int i7 = i4;
    label774: 
    while (true)
    {
      int i28;
      int i29;
      int i9;
      int i11;
      int i12;
      label205: int i8;
      int i10;
      if (localComparator.compare(arrayOfObject1[i7], arrayOfObject2[i1]) < 0)
      {
        i28 = i2 + 1;
        i29 = i7 + 1;
        arrayOfObject1[i2] = arrayOfObject1[i7];
        i3++;
        i6--;
        if (i6 != 0)
          break label762;
        i9 = i1;
        i11 = n;
        i12 = i28;
        k = i29;
        if (i11 <= 0)
          i11 = 1;
        this.minGallop = i11;
        if (paramInt2 == 1)
        {
          System.arraycopy(arrayOfObject1, k, arrayOfObject1, i12, i6);
          arrayOfObject1[(i12 + i6)] = arrayOfObject2[i9];
          return;
        }
      }
      else
      {
        i8 = i2 + 1;
        i9 = i1 + 1;
        arrayOfObject1[i2] = arrayOfObject2[i1];
        i10 = i5 + 1;
        paramInt2--;
        if (paramInt2 == 1)
          break label747;
        i1 = i9;
        i2 = i8;
        i3 = 0;
      }
      for (i5 = i10; ; i5 = 0)
      {
        if ((i5 | i3) < n)
          break label774;
        int i13 = i1;
        int i14 = i6;
        int i15 = n;
        int i16 = i7;
        i12 = i2;
        int i17 = paramInt2;
        label335: int i18 = gallopRight(arrayOfObject1[i16], arrayOfObject2, i13, i17, 0, localComparator);
        if (i18 != 0)
        {
          System.arraycopy(arrayOfObject2, i13, arrayOfObject1, i12, i18);
          i12 += i18;
          i13 += i18;
          i17 -= i18;
          if (i17 <= 1);
        }
        else
        {
          i9 = i13;
          int i19 = i17;
          int i20 = i12 + 1;
          int i21 = i16 + 1;
          arrayOfObject1[i12] = arrayOfObject1[i16];
          i6 = i14 - 1;
          if (i6 != 0)
          {
            int i22 = gallopLeft(arrayOfObject2[i9], arrayOfObject1, i21, i6, 0, localComparator);
            int i27;
            int i23;
            if (i22 != 0)
            {
              System.arraycopy(arrayOfObject1, i21, arrayOfObject1, i20, i22);
              i27 = i20 + i22;
              k = i21 + i22;
              m = i6 - i22;
              if (m != 0)
                i23 = i27;
            }
            while (true)
            {
              j = i23 + 1;
              i = i9 + 1;
              arrayOfObject1[i23] = arrayOfObject2[i9];
              paramInt2 = i19 - 1;
              if (paramInt2 != 1)
              {
                int i24 = i15 - 1;
                int i25;
                if (i18 >= 7)
                {
                  i25 = 1;
                  label555: if (i22 < 7)
                    break label596;
                }
                label596: for (int i26 = 1; ; i26 = 0)
                {
                  if ((i26 | i25) != 0)
                    break label629;
                  if (i24 < 0)
                    i24 = 0;
                  n = i24 + 2;
                  break;
                  i25 = 0;
                  break label555;
                }
                if (paramInt2 == 0)
                  throw new IllegalArgumentException("Comparison method violates its general contract!");
                System.arraycopy(arrayOfObject2, i9, arrayOfObject1, i12, paramInt2);
                return;
                label629: i16 = k;
                i14 = m;
                i15 = i24;
                i12 = j;
                i13 = i;
                i17 = paramInt2;
                break label335;
              }
              i12 = j;
              i9 = i;
              i6 = m;
              i11 = i15;
              break label205;
              i12 = i27;
              i6 = m;
              paramInt2 = i19;
              i11 = i15;
              break label205;
              i23 = i20;
              k = i21;
              m = i6;
            }
          }
          i12 = i20;
          k = i21;
          paramInt2 = i19;
          i11 = i15;
          break label205;
        }
        i9 = i13;
        i11 = i15;
        paramInt2 = i17;
        k = i16;
        i6 = i14;
        break label205;
        label747: k = i7;
        i11 = n;
        i12 = i8;
        break label205;
        label762: i7 = i29;
        i2 = i28;
      }
    }
  }

  private static int minRunLength(int paramInt)
  {
    int i = 0;
    while (paramInt >= 32)
    {
      i |= paramInt & 0x1;
      paramInt >>= 1;
    }
    return i + paramInt;
  }

  private void pushRun(int paramInt1, int paramInt2)
  {
    this.runBase[this.stackSize] = paramInt1;
    this.runLen[this.stackSize] = paramInt2;
    this.stackSize = (1 + this.stackSize);
  }

  private static void rangeCheck(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3)
      throw new IllegalArgumentException("fromIndex(" + paramInt2 + ") > toIndex(" + paramInt3 + ")");
    if (paramInt2 < 0)
      throw new ArrayIndexOutOfBoundsException(paramInt2);
    if (paramInt3 > paramInt1)
      throw new ArrayIndexOutOfBoundsException(paramInt3);
  }

  private static void reverseRange(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - 1;
    while (paramInt1 < i)
    {
      Object localObject = paramArrayOfObject[paramInt1];
      int j = paramInt1 + 1;
      paramArrayOfObject[paramInt1] = paramArrayOfObject[i];
      int k = i - 1;
      paramArrayOfObject[i] = localObject;
      i = k;
      paramInt1 = j;
    }
  }

  static void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2, Comparator paramComparator)
  {
    if (paramComparator == null)
      Arrays.sort(paramArrayOfObject, paramInt1, paramInt2);
    int i;
    do
    {
      return;
      rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
      i = paramInt2 - paramInt1;
    }
    while (i < 2);
    if (i < 32)
    {
      binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2, paramComparator), paramComparator);
      return;
    }
    TimSort localTimSort = new TimSort(paramArrayOfObject, paramComparator);
    int j = minRunLength(i);
    int k = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2, paramComparator);
    int m;
    if (k < j)
      if (i <= j)
      {
        m = i;
        label98: binarySort(paramArrayOfObject, paramInt1, paramInt1 + m, k + paramInt1, paramComparator);
      }
    while (true)
    {
      localTimSort.pushRun(paramInt1, m);
      localTimSort.mergeCollapse();
      paramInt1 += m;
      i -= m;
      if (i != 0)
        break;
      localTimSort.mergeForceCollapse();
      return;
      m = j;
      break label98;
      m = k;
    }
  }

  static void sort(Object[] paramArrayOfObject, Comparator paramComparator)
  {
    sort(paramArrayOfObject, 0, paramArrayOfObject.length, paramComparator);
  }

  public void doSort(Object[] paramArrayOfObject, Comparator paramComparator, int paramInt1, int paramInt2)
  {
    this.stackSize = 0;
    rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if (i < 2)
      return;
    if (i < 32)
    {
      binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2, paramComparator), paramComparator);
      return;
    }
    this.a = paramArrayOfObject;
    this.c = paramComparator;
    this.tmpCount = 0;
    int j = minRunLength(i);
    label74: int k = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2, paramComparator);
    int m;
    if (k < j)
      if (i <= j)
      {
        m = i;
        label102: binarySort(paramArrayOfObject, paramInt1, paramInt1 + m, k + paramInt1, paramComparator);
      }
    while (true)
    {
      pushRun(paramInt1, m);
      mergeCollapse();
      paramInt1 += m;
      i -= m;
      if (i != 0)
        break label74;
      mergeForceCollapse();
      this.a = null;
      this.c = null;
      Object[] arrayOfObject = this.tmp;
      int n = this.tmpCount;
      for (int i1 = 0; i1 < n; i1++)
        arrayOfObject[i1] = null;
      break;
      m = j;
      break label102;
      m = k;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.TimSort
 * JD-Core Version:    0.6.0
 */