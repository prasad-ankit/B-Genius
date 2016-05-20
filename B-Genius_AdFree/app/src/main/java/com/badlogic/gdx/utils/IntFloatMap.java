package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class IntFloatMap
  implements Iterable
{
  private static final int EMPTY = 0;
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private IntFloatMap.Entries entries1;
  private IntFloatMap.Entries entries2;
  boolean hasZeroValue;
  private int hashShift;
  int[] keyTable;
  private IntFloatMap.Keys keys1;
  private IntFloatMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  float[] valueTable;
  private IntFloatMap.Values values1;
  private IntFloatMap.Values values2;
  float zeroValue;

  public IntFloatMap()
  {
    this(32, 0.8F);
  }

  public IntFloatMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public IntFloatMap(int paramInt, float paramFloat)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("initialCapacity must be >= 0: " + paramInt);
    if (paramInt > 1073741824)
      throw new IllegalArgumentException("initialCapacity is too large: " + paramInt);
    this.capacity = MathUtils.nextPowerOfTwo(paramInt);
    if (paramFloat <= 0.0F)
      throw new IllegalArgumentException("loadFactor must be > 0: " + paramFloat);
    this.loadFactor = paramFloat;
    this.threshold = (int)(paramFloat * this.capacity);
    this.mask = (-1 + this.capacity);
    this.hashShift = (31 - Integer.numberOfTrailingZeros(this.capacity));
    this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(this.capacity)) << 1);
    this.pushIterations = Math.max(Math.min(this.capacity, 8), (int)Math.sqrt(this.capacity) / 8);
    this.keyTable = new int[this.capacity + this.stashCapacity];
    this.valueTable = new float[this.keyTable.length];
  }

  public IntFloatMap(IntFloatMap paramIntFloatMap)
  {
    this(paramIntFloatMap.capacity, paramIntFloatMap.loadFactor);
    this.stashSize = paramIntFloatMap.stashSize;
    System.arraycopy(paramIntFloatMap.keyTable, 0, this.keyTable, 0, paramIntFloatMap.keyTable.length);
    System.arraycopy(paramIntFloatMap.valueTable, 0, this.valueTable, 0, paramIntFloatMap.valueTable.length);
    this.size = paramIntFloatMap.size;
    this.zeroValue = paramIntFloatMap.zeroValue;
    this.hasZeroValue = paramIntFloatMap.hasZeroValue;
  }

  private boolean containsKeyStash(int paramInt)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i])
        return true;
      i++;
    }
    return false;
  }

  private float getAndIncrementStash(int paramInt, float paramFloat1, float paramFloat2)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramInt == arrayOfInt[i])
      {
        float f = this.valueTable[i];
        this.valueTable[i] = (f + paramFloat2);
        return f;
      }
      i++;
    }
    put(paramInt, paramFloat1 + paramFloat2);
    return paramFloat1;
  }

  private float getStash(int paramInt, float paramFloat)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramInt == arrayOfInt[i])
          paramFloat = this.valueTable[i];
      }
      else
        return paramFloat;
      i++;
    }
  }

  private int hash2(int paramInt)
  {
    int i = -1262997959 * paramInt;
    return (i ^ i >>> this.hashShift) & this.mask;
  }

  private int hash3(int paramInt)
  {
    int i = -825114047 * paramInt;
    return (i ^ i >>> this.hashShift) & this.mask;
  }

  private void push(int paramInt1, float paramFloat, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label255: 
    do
    {
      switch (MathUtils.random(2))
      {
      default:
        float f3 = arrayOfFloat[paramInt6];
        arrayOfInt[paramInt6] = paramInt1;
        arrayOfFloat[paramInt6] = paramFloat;
        paramFloat = f3;
        paramInt1 = paramInt7;
        paramInt2 = paramInt1 & i;
        paramInt3 = arrayOfInt[paramInt2];
        if (paramInt3 == 0)
        {
          arrayOfInt[paramInt2] = paramInt1;
          arrayOfFloat[paramInt2] = paramFloat;
          int i1 = this.size;
          this.size = (i1 + 1);
          if (i1 < this.threshold)
            break;
          resize(this.capacity << 1);
        }
      case 0:
      case 1:
      }
      int m;
      do
      {
        int n;
        do
        {
          return;
          float f2 = arrayOfFloat[paramInt2];
          arrayOfInt[paramInt2] = paramInt1;
          arrayOfFloat[paramInt2] = paramFloat;
          paramFloat = f2;
          paramInt1 = paramInt3;
          break;
          float f1 = arrayOfFloat[paramInt4];
          arrayOfInt[paramInt4] = paramInt1;
          arrayOfFloat[paramInt4] = paramFloat;
          paramFloat = f1;
          paramInt1 = paramInt5;
          break;
          paramInt4 = hash2(paramInt1);
          paramInt5 = arrayOfInt[paramInt4];
          if (paramInt5 != 0)
            break label255;
          arrayOfInt[paramInt4] = paramInt1;
          arrayOfFloat[paramInt4] = paramFloat;
          n = this.size;
          this.size = (n + 1);
        }
        while (n < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt6 = hash3(paramInt1);
        paramInt7 = arrayOfInt[paramInt6];
        if (paramInt7 != 0)
          break label320;
        arrayOfInt[paramInt6] = paramInt1;
        arrayOfFloat[paramInt6] = paramFloat;
        m = this.size;
        this.size = (m + 1);
      }
      while (m < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    label320: putStash(paramInt1, paramFloat);
  }

  private void putResize(int paramInt, float paramFloat)
  {
    if (paramInt == 0)
    {
      this.zeroValue = paramFloat;
      this.hasZeroValue = true;
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    while (true)
    {
      return;
      i = paramInt & this.mask;
      j = this.keyTable[i];
      if (j == 0)
      {
        this.keyTable[i] = paramInt;
        this.valueTable[i] = paramFloat;
        int i4 = this.size;
        this.size = (i4 + 1);
        if (i4 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      k = hash2(paramInt);
      m = this.keyTable[k];
      if (m == 0)
      {
        this.keyTable[k] = paramInt;
        this.valueTable[k] = paramFloat;
        int i3 = this.size;
        this.size = (i3 + 1);
        if (i3 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      n = hash3(paramInt);
      i1 = this.keyTable[n];
      if (i1 != 0)
        break;
      this.keyTable[n] = paramInt;
      this.valueTable[n] = paramFloat;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt, paramFloat, i, j, k, m, n, i1);
  }

  private void putStash(int paramInt, float paramFloat)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramInt, paramFloat);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramInt;
    this.valueTable[i] = paramFloat;
    this.stashSize = (1 + this.stashSize);
    this.size = (1 + this.size);
  }

  private void resize(int paramInt)
  {
    int i = this.capacity + this.stashSize;
    this.capacity = paramInt;
    this.threshold = (int)(paramInt * this.loadFactor);
    this.mask = (paramInt - 1);
    this.hashShift = (31 - Integer.numberOfTrailingZeros(paramInt));
    this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(paramInt)) << 1);
    this.pushIterations = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    int[] arrayOfInt = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    this.keyTable = new int[paramInt + this.stashCapacity];
    this.valueTable = new float[paramInt + this.stashCapacity];
    int j = this.size;
    if (this.hasZeroValue);
    for (int k = 1; ; k = 0)
    {
      this.size = k;
      this.stashSize = 0;
      int m = 0;
      if (j <= 0)
        break;
      while (m < i)
      {
        int n = arrayOfInt[m];
        if (n != 0)
          putResize(n, arrayOfFloat[m]);
        m++;
      }
    }
  }

  public void clear()
  {
    if (this.size == 0)
      return;
    int[] arrayOfInt = this.keyTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      arrayOfInt[j] = 0;
    }
    this.hasZeroValue = false;
    this.size = 0;
    this.stashSize = 0;
  }

  public void clear(int paramInt)
  {
    if (this.capacity <= paramInt)
    {
      clear();
      return;
    }
    this.hasZeroValue = false;
    this.size = 0;
    resize(paramInt);
  }

  public boolean containsKey(int paramInt)
  {
    if (paramInt == 0)
      return this.hasZeroValue;
    int i = paramInt & this.mask;
    if (this.keyTable[i] != paramInt)
    {
      int j = hash2(paramInt);
      if (this.keyTable[j] != paramInt)
      {
        int k = hash3(paramInt);
        if (this.keyTable[k] != paramInt)
          return containsKeyStash(paramInt);
      }
    }
    return true;
  }

  public boolean containsValue(float paramFloat)
  {
    if ((this.hasZeroValue) && (this.zeroValue == paramFloat))
      return true;
    int[] arrayOfInt = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break label73;
      if ((arrayOfInt[j] != 0) && (arrayOfFloat[j] == paramFloat))
        break;
    }
    label73: return false;
  }

  public boolean containsValue(float paramFloat1, float paramFloat2)
  {
    if ((this.hasZeroValue) && (Math.abs(this.zeroValue - paramFloat1) <= paramFloat2))
      return true;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break label71;
      if (Math.abs(arrayOfFloat[j] - paramFloat1) <= paramFloat2)
        break;
    }
    label71: return false;
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public IntFloatMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new IntFloatMap.Entries(this);
      this.entries2 = new IntFloatMap.Entries(this);
    }
    if (!this.entries1.valid)
    {
      this.entries1.reset();
      this.entries1.valid = true;
      this.entries2.valid = false;
      return this.entries1;
    }
    this.entries2.reset();
    this.entries2.valid = true;
    this.entries1.valid = false;
    return this.entries2;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof IntFloatMap))
        return false;
      IntFloatMap localIntFloatMap = (IntFloatMap)paramObject;
      if (localIntFloatMap.size != this.size)
        return false;
      if (localIntFloatMap.hasZeroValue != this.hasZeroValue)
        return false;
      if ((this.hasZeroValue) && (localIntFloatMap.zeroValue != this.zeroValue))
        return false;
      int[] arrayOfInt = this.keyTable;
      float[] arrayOfFloat = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        int k = arrayOfInt[j];
        if (k == 0)
          continue;
        float f = localIntFloatMap.get(k, 0.0F);
        if ((f == 0.0F) && (!localIntFloatMap.containsKey(k)))
          return false;
        if (f != arrayOfFloat[j])
          return false;
      }
    }
  }

  public int findKey(float paramFloat, int paramInt)
  {
    if ((this.hasZeroValue) && (this.zeroValue == paramFloat))
    {
      paramInt = 0;
      return paramInt;
    }
    int[] arrayOfInt = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      if ((arrayOfInt[j] != 0) && (arrayOfFloat[j] == paramFloat))
        return arrayOfInt[j];
    }
  }

  public float get(int paramInt, float paramFloat)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return paramFloat;
      return this.zeroValue;
    }
    int i = paramInt & this.mask;
    if (this.keyTable[i] != paramInt)
    {
      i = hash2(paramInt);
      if (this.keyTable[i] != paramInt)
      {
        i = hash3(paramInt);
        if (this.keyTable[i] != paramInt)
          return getStash(paramInt, paramFloat);
      }
    }
    return this.valueTable[i];
  }

  public float getAndIncrement(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      if (this.hasZeroValue)
      {
        float f2 = this.zeroValue;
        this.zeroValue = (paramFloat2 + this.zeroValue);
        return f2;
      }
      this.hasZeroValue = true;
      this.zeroValue = (paramFloat1 + paramFloat2);
      this.size = (1 + this.size);
      return paramFloat1;
    }
    int i = paramInt & this.mask;
    if (paramInt != this.keyTable[i])
    {
      i = hash2(paramInt);
      if (paramInt != this.keyTable[i])
      {
        i = hash3(paramInt);
        if (paramInt != this.keyTable[i])
          return getAndIncrementStash(paramInt, paramFloat1, paramFloat2);
      }
    }
    float f1 = this.valueTable[i];
    this.valueTable[i] = (f1 + paramFloat2);
    return f1;
  }

  public int hashCode()
  {
    int i = 0;
    if (this.hasZeroValue);
    for (int j = 0 + Float.floatToIntBits(this.zeroValue); ; j = 0)
    {
      int[] arrayOfInt = this.keyTable;
      float[] arrayOfFloat = this.valueTable;
      int k = this.capacity + this.stashSize;
      while (i < k)
      {
        int m = arrayOfInt[i];
        if (m != 0)
          j = j + m * 31 + Float.floatToIntBits(arrayOfFloat[i]);
        i++;
      }
      return j;
    }
  }

  public Iterator iterator()
  {
    return entries();
  }

  public IntFloatMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new IntFloatMap.Keys(this);
      this.keys2 = new IntFloatMap.Keys(this);
    }
    if (!this.keys1.valid)
    {
      this.keys1.reset();
      this.keys1.valid = true;
      this.keys2.valid = false;
      return this.keys1;
    }
    this.keys2.reset();
    this.keys2.valid = true;
    this.keys1.valid = false;
    return this.keys2;
  }

  public void put(int paramInt, float paramFloat)
  {
    if (paramInt == 0)
    {
      this.zeroValue = paramFloat;
      if (!this.hasZeroValue)
      {
        this.hasZeroValue = true;
        this.size = (1 + this.size);
      }
    }
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    while (true)
    {
      return;
      int[] arrayOfInt = this.keyTable;
      i = paramInt & this.mask;
      j = arrayOfInt[i];
      if (paramInt == j)
      {
        this.valueTable[i] = paramFloat;
        return;
      }
      k = hash2(paramInt);
      m = arrayOfInt[k];
      if (paramInt == m)
      {
        this.valueTable[k] = paramFloat;
        return;
      }
      n = hash3(paramInt);
      i1 = arrayOfInt[n];
      if (paramInt == i1)
      {
        this.valueTable[n] = paramFloat;
        return;
      }
      int i2 = this.capacity;
      int i3 = i2 + this.stashSize;
      while (i2 < i3)
      {
        if (paramInt == arrayOfInt[i2])
        {
          this.valueTable[i2] = paramFloat;
          return;
        }
        i2++;
      }
      if (j == 0)
      {
        arrayOfInt[i] = paramInt;
        this.valueTable[i] = paramFloat;
        int i6 = this.size;
        this.size = (i6 + 1);
        if (i6 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (m == 0)
      {
        arrayOfInt[k] = paramInt;
        this.valueTable[k] = paramFloat;
        int i5 = this.size;
        this.size = (i5 + 1);
        if (i5 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (i1 != 0)
        break;
      arrayOfInt[n] = paramInt;
      this.valueTable[n] = paramFloat;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt, paramFloat, i, j, k, m, n, i1);
  }

  public void putAll(IntFloatMap paramIntFloatMap)
  {
    Iterator localIterator = paramIntFloatMap.entries().iterator();
    while (localIterator.hasNext())
    {
      IntFloatMap.Entry localEntry = (IntFloatMap.Entry)localIterator.next();
      put(localEntry.key, localEntry.value);
    }
  }

  public float remove(int paramInt, float paramFloat)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return paramFloat;
      this.hasZeroValue = false;
      this.size = (-1 + this.size);
      return this.zeroValue;
    }
    int i = paramInt & this.mask;
    if (paramInt == this.keyTable[i])
    {
      this.keyTable[i] = 0;
      float f3 = this.valueTable[i];
      this.size = (-1 + this.size);
      return f3;
    }
    int j = hash2(paramInt);
    if (paramInt == this.keyTable[j])
    {
      this.keyTable[j] = 0;
      float f2 = this.valueTable[j];
      this.size = (-1 + this.size);
      return f2;
    }
    int k = hash3(paramInt);
    if (paramInt == this.keyTable[k])
    {
      this.keyTable[k] = 0;
      float f1 = this.valueTable[k];
      this.size = (-1 + this.size);
      return f1;
    }
    return removeStash(paramInt, paramFloat);
  }

  float removeStash(int paramInt, float paramFloat)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramInt == arrayOfInt[i])
        {
          paramFloat = this.valueTable[i];
          removeStashIndex(i);
          this.size = (-1 + this.size);
        }
      }
      else
        return paramFloat;
      i++;
    }
  }

  void removeStashIndex(int paramInt)
  {
    this.stashSize = (-1 + this.stashSize);
    int i = this.capacity + this.stashSize;
    if (paramInt < i)
    {
      this.keyTable[paramInt] = this.keyTable[i];
      this.valueTable[paramInt] = this.valueTable[i];
    }
  }

  public void shrink(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("maximumCapacity must be >= 0: " + paramInt);
    if (this.size > paramInt)
      paramInt = this.size;
    if (this.capacity <= paramInt)
      return;
    resize(MathUtils.nextPowerOfTwo(paramInt));
  }

  public String toString()
  {
    if (this.size == 0)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('{');
    int[] arrayOfInt = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int i = arrayOfInt.length;
    if (this.hasZeroValue)
    {
      localStringBuilder.append("0=");
      localStringBuilder.append(this.zeroValue);
    }
    while (true)
    {
      int m = i - 1;
      if (i > 0)
      {
        int n = arrayOfInt[m];
        if (n != 0)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(n);
          localStringBuilder.append('=');
          localStringBuilder.append(arrayOfFloat[m]);
          i = m;
          continue;
          int k;
          do
          {
            int j = i;
            i = j - 1;
            if (j <= 0)
              break;
            k = arrayOfInt[i];
          }
          while (k == 0);
          localStringBuilder.append(k);
          localStringBuilder.append('=');
          localStringBuilder.append(arrayOfFloat[i]);
          continue;
        }
      }
      else
      {
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      i = m;
    }
  }

  public IntFloatMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new IntFloatMap.Values(this);
      this.values2 = new IntFloatMap.Values(this);
    }
    if (!this.values1.valid)
    {
      this.values1.reset();
      this.values1.valid = true;
      this.values2.valid = false;
      return this.values1;
    }
    this.values2.reset();
    this.values2.valid = true;
    this.values1.valid = false;
    return this.values2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IntFloatMap
 * JD-Core Version:    0.6.0
 */