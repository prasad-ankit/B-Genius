package com.badlogic.gdx.utils;

class ComparableTimSort
{
  private static final boolean DEBUG = false;
  private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
  private static final int MIN_GALLOP = 7;
  private static final int MIN_MERGE = 32;
  private Object[] a;
  private int minGallop = 7;
  private final int[] runBase;
  private final int[] runLen;
  private int stackSize = 0;
  private Object[] tmp;

  ComparableTimSort()
  {
    this.tmp = new Object[256];
    this.runBase = new int[40];
    this.runLen = new int[40];
  }

  private ComparableTimSort(Object[] paramArrayOfObject)
  {
    this.a = paramArrayOfObject;
    int i = paramArrayOfObject.length;
    int j;
    int k;
    if (i < 512)
    {
      j = i >>> 1;
      this.tmp = new Object[j];
      if (i >= 120)
        break label75;
      k = 5;
    }
    while (true)
    {
      this.runBase = new int[k];
      this.runLen = new int[k];
      return;
      j = 256;
      break;
      label75: if (i < 1542)
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

  private static void binarySort(Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (paramInt3 == paramInt1)
      i = paramInt3 + 1;
    while (true)
    {
      if (i < paramInt2)
      {
        Comparable localComparable = (Comparable)paramArrayOfObject[i];
        int j = i;
        int k = paramInt1;
        while (k < j)
        {
          int n = k + j >>> 1;
          if (localComparable.compareTo(paramArrayOfObject[n]) < 0)
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
          paramArrayOfObject[k] = localComparable;
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

  private static int countRunAndMakeAscending(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 1;
    if (i == paramInt2)
      return 1;
    int j = i + 1;
    if (((Comparable)paramArrayOfObject[i]).compareTo(paramArrayOfObject[paramInt1]) < 0)
    {
      while ((j < paramInt2) && (((Comparable)paramArrayOfObject[j]).compareTo(paramArrayOfObject[(j - 1)]) < 0))
        j++;
      reverseRange(paramArrayOfObject, paramInt1, j);
    }
    for (int k = j; ; k = j)
    {
      return k - paramInt1;
      while ((j < paramInt2) && (((Comparable)paramArrayOfObject[j]).compareTo(paramArrayOfObject[(j - 1)]) >= 0))
        j++;
    }
  }

  private Object[] ensureCapacity(int paramInt)
  {
    int n;
    if (this.tmp.length < paramInt)
    {
      int i = paramInt | paramInt >> 1;
      int j = i | i >> 2;
      int k = j | j >> 4;
      int m = k | k >> 8;
      n = 1 + (m | m >> 16);
      if (n >= 0)
        break label68;
    }
    while (true)
    {
      this.tmp = new Object[paramInt];
      return this.tmp;
      label68: paramInt = Math.min(n, this.a.length >>> 1);
    }
  }

  private static int gallopLeft(Comparable paramComparable, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    int j = 1;
    int i4;
    if (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + paramInt3)]) > 0)
      i4 = paramInt2 - paramInt3;
    while (true)
    {
      int i5;
      if ((j < i4) && (paramComparable.compareTo(paramArrayOfObject[(j + (paramInt1 + paramInt3))]) > 0))
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
          label103: int i2;
          int k;
          while (true)
          {
            if (i1 >= n)
              break label232;
            i2 = i1 + (n - i1 >>> 1);
            if (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + i2)]) <= 0)
              break;
            i1 = i2 + 1;
            continue;
            k = paramInt3 + 1;
          }
          while (true)
          {
            int i3;
            if ((j < k) && (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + paramInt3 - j)]) <= 0))
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
                break label103;
                label232: return n;
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

  private static int gallopRight(Comparable paramComparable, Object[] paramArrayOfObject, int paramInt1, int paramInt2, int paramInt3)
  {
    int i6;
    int i7;
    int i8;
    if (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + paramInt3)]) < 0)
    {
      i6 = paramInt3 + 1;
      i7 = 1;
      i8 = 0;
    }
    while (true)
    {
      int i9;
      if ((i7 < i6) && (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + paramInt3 - i7)]) < 0))
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
          label103: int i3;
          int i;
          int j;
          int k;
          while (true)
          {
            if (i2 >= n)
              break label242;
            i3 = i2 + (n - i2 >>> 1);
            if (paramComparable.compareTo(paramArrayOfObject[(paramInt1 + i3)]) >= 0)
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
            if ((j < i) && (paramComparable.compareTo(paramArrayOfObject[(j + (paramInt1 + paramInt3))]) >= 0))
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
                break label103;
                label242: return n;
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
    int n = gallopRight((Comparable)this.a[k], this.a, i, j, 0);
    int i1 = i + n;
    int i2 = j - n;
    if (i2 == 0);
    int i3;
    do
    {
      return;
      i3 = gallopLeft((Comparable)this.a[(-1 + (i1 + i2))], this.a, k, m, m - 1);
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
    while (this.stackSize > 1)
    {
      int i = -2 + this.stackSize;
      if ((i > 0) && (this.runLen[(i - 1)] <= this.runLen[i] + this.runLen[(i + 1)]))
      {
        if (this.runLen[(i - 1)] < this.runLen[(i + 1)])
          i--;
        mergeAt(i);
        continue;
      }
      if (this.runLen[i] > this.runLen[(i + 1)])
        break;
      mergeAt(i);
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
      int i42 = m - i1;
      System.arraycopy(arrayOfObject1, 1 + (n - i1), arrayOfObject1, i42 + 1, i1);
      arrayOfObject1[i42] = arrayOfObject2[j];
      return;
    }
    int i2 = this.minGallop;
    int i3 = j;
    int i4 = i2;
    int i5 = i1;
    int i6 = i3;
    int i7 = m;
    int i8 = 0;
    int i9 = n;
    int i10 = 0;
    int i11 = i9;
    label178: int i39;
    int i40;
    int i41;
    int i16;
    int i19;
    int i18;
    int i15;
    label254: int i12;
    int i13;
    int i21;
    int i22;
    int i23;
    if (((Comparable)arrayOfObject2[i6]).compareTo(arrayOfObject1[i11]) < 0)
    {
      i39 = i7 - 1;
      i40 = i11 - 1;
      arrayOfObject1[i7] = arrayOfObject1[i11];
      i41 = i8 + 1;
      i16 = i5 - 1;
      if (i16 != 0)
        break label865;
      m = i39;
      i19 = i4;
      i18 = i6;
      i15 = i40;
      if (i19 <= 0)
        i19 = 1;
      this.minGallop = i19;
      if (paramInt4 == 1)
      {
        int i20 = m - i16;
        System.arraycopy(arrayOfObject1, 1 + (i15 - i16), arrayOfObject1, i20 + 1, i16);
        arrayOfObject1[i20] = arrayOfObject2[i18];
        return;
      }
    }
    else
    {
      i12 = i7 - 1;
      i13 = i6 - 1;
      arrayOfObject1[i7] = arrayOfObject2[i6];
      int i14 = i10 + 1;
      paramInt4--;
      if (paramInt4 == 1)
        break label838;
      i16 = i5;
      i15 = i11;
      i21 = i12;
      i22 = i14;
      i23 = 0;
    }
    while (true)
    {
      if ((i23 | i22) >= i4)
      {
        int i24 = i4;
        int i25 = i21;
        int i26 = i24;
        label390: int i27 = i16 - gallopRight((Comparable)arrayOfObject2[i13], arrayOfObject1, paramInt1, i16, i16 - 1);
        if (i27 != 0)
        {
          i25 -= i27;
          i15 -= i27;
          i16 -= i27;
          System.arraycopy(arrayOfObject1, i15 + 1, arrayOfObject1, i25 + 1, i27);
          if (i16 == 0);
        }
        else
        {
          int i28 = i25 - 1;
          int i29 = i13 - 1;
          arrayOfObject1[i25] = arrayOfObject2[i13];
          paramInt4--;
          if (paramInt4 != 1)
          {
            Comparable localComparable = (Comparable)arrayOfObject1[i15];
            int i30 = paramInt4 - 1;
            int i31 = paramInt4 - gallopLeft(localComparable, arrayOfObject2, 0, paramInt4, i30);
            int i32;
            if (i31 != 0)
            {
              i32 = i28 - i31;
              i18 = i29 - i31;
              paramInt4 -= i31;
              System.arraycopy(arrayOfObject2, i18 + 1, arrayOfObject1, i32 + 1, i31);
              if (paramInt4 <= 1);
            }
            while (true)
            {
              m = i32 - 1;
              n = i15 - 1;
              arrayOfObject1[i32] = arrayOfObject1[i15];
              i1 = i16 - 1;
              if (i1 != 0)
              {
                int i33 = i26 - 1;
                int i34;
                if (i27 >= 7)
                {
                  i34 = 1;
                  label625: if (i31 < 7)
                    break label674;
                }
                label674: for (int i35 = 1; ; i35 = 0)
                {
                  if ((i35 | i34) != 0)
                    break label713;
                  if (i33 < 0)
                    i33 = 0;
                  int i37 = i33 + 2;
                  i3 = i18;
                  i4 = i37;
                  break;
                  i34 = 0;
                  break label625;
                }
                if (paramInt4 == 0)
                  throw new IllegalArgumentException("Comparison method violates its general contract!");
                System.arraycopy(arrayOfObject2, 0, arrayOfObject1, m - (paramInt4 - 1), paramInt4);
                return;
                label713: i26 = i33;
                i16 = i1;
                i15 = n;
                int i36 = m;
                i13 = i18;
                i25 = i36;
                break label390;
              }
              i19 = i26;
              i16 = i1;
              i15 = n;
              break label254;
              m = i32;
              i19 = i26;
              break label254;
              i18 = i29;
              i32 = i28;
            }
          }
          i19 = i26;
          i18 = i29;
          m = i28;
          break label254;
        }
        i19 = i26;
        int i38 = i13;
        m = i25;
        i18 = i38;
        break label254;
      }
      i5 = i16;
      i7 = i21;
      i11 = i15;
      i6 = i13;
      i8 = i23;
      i10 = i22;
      break label178;
      label838: i15 = i11;
      i16 = i5;
      int i17 = i4;
      i18 = i13;
      m = i12;
      i19 = i17;
      break label254;
      label865: i13 = i6;
      i15 = i40;
      i23 = i41;
      i21 = i39;
      i22 = 0;
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
    int n = this.minGallop;
    int i1 = 0;
    int i2 = m;
    int i3 = k;
    int i4 = 0;
    int i5 = i;
    int i6 = j;
    label126: int i28;
    int i29;
    int i30;
    int i31;
    int i12;
    int i11;
    int i10;
    int i13;
    label206: int i7;
    int i8;
    int i14;
    int i15;
    int i16;
    int i18;
    if (((Comparable)arrayOfObject1[i3]).compareTo(arrayOfObject2[i5]) < 0)
    {
      i28 = i6 + 1;
      i29 = i3 + 1;
      arrayOfObject1[i6] = arrayOfObject1[i3];
      i30 = i4 + 1;
      i31 = i2 - 1;
      if (i31 != 0)
        break label761;
      i12 = i28;
      i11 = i5;
      i10 = i31;
      i13 = n;
      i3 = i29;
      if (i13 <= 0)
        i13 = 1;
      this.minGallop = i13;
      if (paramInt2 == 1)
      {
        System.arraycopy(arrayOfObject1, i3, arrayOfObject1, i12, i10);
        arrayOfObject1[(i12 + i10)] = arrayOfObject2[i11];
        return;
      }
    }
    else
    {
      i7 = i6 + 1;
      i8 = i5 + 1;
      arrayOfObject1[i6] = arrayOfObject2[i5];
      int i9 = i1 + 1;
      paramInt2--;
      if (paramInt2 == 1)
        break label742;
      i14 = i3;
      i15 = i8;
      i12 = i7;
      i16 = 0;
      int i17 = i2;
      i18 = i9;
      i10 = i17;
    }
    while (true)
    {
      if ((i18 | i16) >= n)
      {
        label325: int i19 = gallopRight((Comparable)arrayOfObject1[i14], arrayOfObject2, i15, paramInt2, 0);
        if (i19 != 0)
        {
          System.arraycopy(arrayOfObject2, i15, arrayOfObject1, i12, i19);
          i12 += i19;
          i15 += i19;
          paramInt2 -= i19;
          if (paramInt2 <= 1);
        }
        else
        {
          i11 = i15;
          int i20 = i12 + 1;
          int i21 = i14 + 1;
          arrayOfObject1[i12] = arrayOfObject1[i14];
          int i22 = i10 - 1;
          if (i22 != 0)
          {
            int i23 = gallopLeft((Comparable)arrayOfObject2[i11], arrayOfObject1, i21, i22, 0);
            int i27;
            int i24;
            if (i23 != 0)
            {
              System.arraycopy(arrayOfObject1, i21, arrayOfObject1, i20, i23);
              i27 = i20 + i23;
              k = i21 + i23;
              m = i22 - i23;
              if (m != 0)
                i24 = i27;
            }
            while (true)
            {
              j = i24 + 1;
              i = i11 + 1;
              arrayOfObject1[i24] = arrayOfObject2[i11];
              paramInt2--;
              if (paramInt2 != 1)
              {
                n--;
                int i25;
                if (i19 >= 7)
                {
                  i25 = 1;
                  label534: if (i23 < 7)
                    break label572;
                }
                label572: for (int i26 = 1; ; i26 = 0)
                {
                  if ((i26 | i25) != 0)
                    break label605;
                  if (n < 0)
                    n = 0;
                  n += 2;
                  break;
                  i25 = 0;
                  break label534;
                }
                if (paramInt2 == 0)
                  throw new IllegalArgumentException("Comparison method violates its general contract!");
                System.arraycopy(arrayOfObject2, i11, arrayOfObject1, i12, paramInt2);
                return;
                label605: i10 = m;
                i15 = i;
                i14 = k;
                i12 = j;
                break label325;
              }
              i11 = i;
              i10 = m;
              i3 = k;
              i12 = j;
              i13 = n;
              break label206;
              i10 = m;
              i3 = k;
              i12 = i27;
              i13 = n;
              break label206;
              i24 = i20;
              k = i21;
              m = i22;
            }
          }
          i12 = i20;
          i10 = i22;
          i13 = n;
          i3 = i21;
          break label206;
        }
        i11 = i15;
        i13 = n;
        i3 = i14;
        break label206;
      }
      i1 = i18;
      i2 = i10;
      i5 = i15;
      i3 = i14;
      i6 = i12;
      i4 = i16;
      break label126;
      label742: i10 = i2;
      i11 = i8;
      i12 = i7;
      i13 = n;
      break label206;
      label761: i14 = i29;
      i16 = i30;
      i12 = i28;
      i15 = i5;
      i10 = i31;
      i18 = 0;
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

  static void sort(Object[] paramArrayOfObject)
  {
    sort(paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  static void sort(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if (i < 2)
      return;
    if (i < 32)
    {
      binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2));
      return;
    }
    ComparableTimSort localComparableTimSort = new ComparableTimSort(paramArrayOfObject);
    int j = minRunLength(i);
    int k = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2);
    int m;
    if (k < j)
      if (i <= j)
      {
        m = i;
        label78: binarySort(paramArrayOfObject, paramInt1, paramInt1 + m, k + paramInt1);
      }
    while (true)
    {
      localComparableTimSort.pushRun(paramInt1, m);
      localComparableTimSort.mergeCollapse();
      paramInt1 += m;
      i -= m;
      if (i != 0)
        break;
      localComparableTimSort.mergeForceCollapse();
      return;
      m = j;
      break label78;
      m = k;
    }
  }

  public void doSort(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this.stackSize = 0;
    rangeCheck(paramArrayOfObject.length, paramInt1, paramInt2);
    int i = paramInt2 - paramInt1;
    if (i < 2)
      return;
    if (i < 32)
    {
      binarySort(paramArrayOfObject, paramInt1, paramInt2, paramInt1 + countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2));
      return;
    }
    this.a = paramArrayOfObject;
    int j = minRunLength(i);
    int k = countRunAndMakeAscending(paramArrayOfObject, paramInt1, paramInt2);
    int m;
    if (k < j)
      if (i <= j)
      {
        m = i;
        label84: binarySort(paramArrayOfObject, paramInt1, paramInt1 + m, k + paramInt1);
      }
    while (true)
    {
      pushRun(paramInt1, m);
      mergeCollapse();
      paramInt1 += m;
      i -= m;
      if (i != 0)
        break;
      mergeForceCollapse();
      return;
      m = j;
      break label84;
      m = k;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ComparableTimSort
 * JD-Core Version:    0.6.0
 */