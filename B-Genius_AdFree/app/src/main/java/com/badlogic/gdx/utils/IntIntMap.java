package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class IntIntMap
  implements Iterable
{
  private static final int EMPTY = 0;
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private IntIntMap.Entries entries1;
  private IntIntMap.Entries entries2;
  boolean hasZeroValue;
  private int hashShift;
  int[] keyTable;
  private IntIntMap.Keys keys1;
  private IntIntMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  int[] valueTable;
  private IntIntMap.Values values1;
  private IntIntMap.Values values2;
  int zeroValue;

  public IntIntMap()
  {
    this(32, 0.8F);
  }

  public IntIntMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public IntIntMap(int paramInt, float paramFloat)
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
    this.valueTable = new int[this.keyTable.length];
  }

  public IntIntMap(IntIntMap paramIntIntMap)
  {
    this(paramIntIntMap.capacity, paramIntIntMap.loadFactor);
    this.stashSize = paramIntIntMap.stashSize;
    System.arraycopy(paramIntIntMap.keyTable, 0, this.keyTable, 0, paramIntIntMap.keyTable.length);
    System.arraycopy(paramIntIntMap.valueTable, 0, this.valueTable, 0, paramIntIntMap.valueTable.length);
    this.size = paramIntIntMap.size;
    this.zeroValue = paramIntIntMap.zeroValue;
    this.hasZeroValue = paramIntIntMap.hasZeroValue;
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

  private int getAndIncrementStash(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramInt1 == arrayOfInt[i])
      {
        int k = this.valueTable[i];
        this.valueTable[i] = (k + paramInt3);
        return k;
      }
      i++;
    }
    put(paramInt1, paramInt2 + paramInt3);
    return paramInt2;
  }

  private int getStash(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramInt1 == arrayOfInt[i])
          paramInt2 = this.valueTable[i];
      }
      else
        return paramInt2;
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

  private void push(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    int[] arrayOfInt1 = this.keyTable;
    int[] arrayOfInt2 = this.valueTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label255: 
    do
    {
      switch (MathUtils.random(2))
      {
      default:
        int i4 = arrayOfInt2[paramInt7];
        arrayOfInt1[paramInt7] = paramInt1;
        arrayOfInt2[paramInt7] = paramInt2;
        paramInt2 = i4;
        paramInt1 = paramInt8;
        paramInt3 = paramInt1 & i;
        paramInt4 = arrayOfInt1[paramInt3];
        if (paramInt4 == 0)
        {
          arrayOfInt1[paramInt3] = paramInt1;
          arrayOfInt2[paramInt3] = paramInt2;
          int i2 = this.size;
          this.size = (i2 + 1);
          if (i2 < this.threshold)
            break;
          resize(this.capacity << 1);
        }
      case 0:
      case 1:
      }
      int n;
      do
      {
        int i1;
        do
        {
          return;
          int i3 = arrayOfInt2[paramInt3];
          arrayOfInt1[paramInt3] = paramInt1;
          arrayOfInt2[paramInt3] = paramInt2;
          paramInt2 = i3;
          paramInt1 = paramInt4;
          break;
          int m = arrayOfInt2[paramInt5];
          arrayOfInt1[paramInt5] = paramInt1;
          arrayOfInt2[paramInt5] = paramInt2;
          paramInt2 = m;
          paramInt1 = paramInt6;
          break;
          paramInt5 = hash2(paramInt1);
          paramInt6 = arrayOfInt1[paramInt5];
          if (paramInt6 != 0)
            break label255;
          arrayOfInt1[paramInt5] = paramInt1;
          arrayOfInt2[paramInt5] = paramInt2;
          i1 = this.size;
          this.size = (i1 + 1);
        }
        while (i1 < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt7 = hash3(paramInt1);
        paramInt8 = arrayOfInt1[paramInt7];
        if (paramInt8 != 0)
          break label320;
        arrayOfInt1[paramInt7] = paramInt1;
        arrayOfInt2[paramInt7] = paramInt2;
        n = this.size;
        this.size = (n + 1);
      }
      while (n < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    label320: putStash(paramInt1, paramInt2);
  }

  private void putResize(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.zeroValue = paramInt2;
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
      i = paramInt1 & this.mask;
      j = this.keyTable[i];
      if (j == 0)
      {
        this.keyTable[i] = paramInt1;
        this.valueTable[i] = paramInt2;
        int i4 = this.size;
        this.size = (i4 + 1);
        if (i4 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      k = hash2(paramInt1);
      m = this.keyTable[k];
      if (m == 0)
      {
        this.keyTable[k] = paramInt1;
        this.valueTable[k] = paramInt2;
        int i3 = this.size;
        this.size = (i3 + 1);
        if (i3 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      n = hash3(paramInt1);
      i1 = this.keyTable[n];
      if (i1 != 0)
        break;
      this.keyTable[n] = paramInt1;
      this.valueTable[n] = paramInt2;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt1, paramInt2, i, j, k, m, n, i1);
  }

  private void putStash(int paramInt1, int paramInt2)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramInt1, paramInt2);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramInt1;
    this.valueTable[i] = paramInt2;
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
    int[] arrayOfInt1 = this.keyTable;
    int[] arrayOfInt2 = this.valueTable;
    this.keyTable = new int[paramInt + this.stashCapacity];
    this.valueTable = new int[paramInt + this.stashCapacity];
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
        int n = arrayOfInt1[m];
        if (n != 0)
          putResize(n, arrayOfInt2[m]);
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
    this.size = 0;
    this.stashSize = 0;
    this.hasZeroValue = false;
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

  public boolean containsValue(int paramInt)
  {
    if ((this.hasZeroValue) && (this.zeroValue == paramInt))
      return true;
    int[] arrayOfInt1 = this.keyTable;
    int[] arrayOfInt2 = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break label71;
      if ((arrayOfInt1[j] != 0) && (arrayOfInt2[j] == paramInt))
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

  public IntIntMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new IntIntMap.Entries(this);
      this.entries2 = new IntIntMap.Entries(this);
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
      if (!(paramObject instanceof IntIntMap))
        return false;
      IntIntMap localIntIntMap = (IntIntMap)paramObject;
      if (localIntIntMap.size != this.size)
        return false;
      if (localIntIntMap.hasZeroValue != this.hasZeroValue)
        return false;
      if ((this.hasZeroValue) && (localIntIntMap.zeroValue != this.zeroValue))
        return false;
      int[] arrayOfInt1 = this.keyTable;
      int[] arrayOfInt2 = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        int k = arrayOfInt1[j];
        if (k == 0)
          continue;
        int m = localIntIntMap.get(k, 0);
        if ((m == 0) && (!localIntIntMap.containsKey(k)))
          return false;
        if (m != arrayOfInt2[j])
          return false;
      }
    }
  }

  public int findKey(int paramInt1, int paramInt2)
  {
    if ((this.hasZeroValue) && (this.zeroValue == paramInt1))
    {
      paramInt2 = 0;
      return paramInt2;
    }
    int[] arrayOfInt1 = this.keyTable;
    int[] arrayOfInt2 = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      if ((arrayOfInt1[j] != 0) && (arrayOfInt2[j] == paramInt1))
        return arrayOfInt1[j];
    }
  }

  public int get(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (!this.hasZeroValue)
        return paramInt2;
      return this.zeroValue;
    }
    int i = paramInt1 & this.mask;
    if (this.keyTable[i] != paramInt1)
    {
      i = hash2(paramInt1);
      if (this.keyTable[i] != paramInt1)
      {
        i = hash3(paramInt1);
        if (this.keyTable[i] != paramInt1)
          return getStash(paramInt1, paramInt2);
      }
    }
    return this.valueTable[i];
  }

  public int getAndIncrement(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      if (this.hasZeroValue)
      {
        int k = this.zeroValue;
        this.zeroValue = (paramInt3 + this.zeroValue);
        return k;
      }
      this.hasZeroValue = true;
      this.zeroValue = (paramInt2 + paramInt3);
      this.size = (1 + this.size);
      return paramInt2;
    }
    int i = paramInt1 & this.mask;
    if (paramInt1 != this.keyTable[i])
    {
      i = hash2(paramInt1);
      if (paramInt1 != this.keyTable[i])
      {
        i = hash3(paramInt1);
        if (paramInt1 != this.keyTable[i])
          return getAndIncrementStash(paramInt1, paramInt2, paramInt3);
      }
    }
    int j = this.valueTable[i];
    this.valueTable[i] = (j + paramInt3);
    return j;
  }

  public int hashCode()
  {
    int i = 0;
    if (this.hasZeroValue);
    for (int j = 0 + Float.floatToIntBits(this.zeroValue); ; j = 0)
    {
      int[] arrayOfInt1 = this.keyTable;
      int[] arrayOfInt2 = this.valueTable;
      int k = this.capacity + this.stashSize;
      while (i < k)
      {
        int m = arrayOfInt1[i];
        if (m != 0)
          j = j + m * 31 + arrayOfInt2[i];
        i++;
      }
      return j;
    }
  }

  public Iterator iterator()
  {
    return entries();
  }

  public IntIntMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new IntIntMap.Keys(this);
      this.keys2 = new IntIntMap.Keys(this);
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

  public void put(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.zeroValue = paramInt2;
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
      i = paramInt1 & this.mask;
      j = arrayOfInt[i];
      if (paramInt1 == j)
      {
        this.valueTable[i] = paramInt2;
        return;
      }
      k = hash2(paramInt1);
      m = arrayOfInt[k];
      if (paramInt1 == m)
      {
        this.valueTable[k] = paramInt2;
        return;
      }
      n = hash3(paramInt1);
      i1 = arrayOfInt[n];
      if (paramInt1 == i1)
      {
        this.valueTable[n] = paramInt2;
        return;
      }
      int i2 = this.capacity;
      int i3 = i2 + this.stashSize;
      while (i2 < i3)
      {
        if (paramInt1 == arrayOfInt[i2])
        {
          this.valueTable[i2] = paramInt2;
          return;
        }
        i2++;
      }
      if (j == 0)
      {
        arrayOfInt[i] = paramInt1;
        this.valueTable[i] = paramInt2;
        int i6 = this.size;
        this.size = (i6 + 1);
        if (i6 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (m == 0)
      {
        arrayOfInt[k] = paramInt1;
        this.valueTable[k] = paramInt2;
        int i5 = this.size;
        this.size = (i5 + 1);
        if (i5 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (i1 != 0)
        break;
      arrayOfInt[n] = paramInt1;
      this.valueTable[n] = paramInt2;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt1, paramInt2, i, j, k, m, n, i1);
  }

  public void putAll(IntIntMap paramIntIntMap)
  {
    Iterator localIterator = paramIntIntMap.entries().iterator();
    while (localIterator.hasNext())
    {
      IntIntMap.Entry localEntry = (IntIntMap.Entry)localIterator.next();
      put(localEntry.key, localEntry.value);
    }
  }

  public int remove(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (!this.hasZeroValue)
        return paramInt2;
      this.hasZeroValue = false;
      this.size = (-1 + this.size);
      return this.zeroValue;
    }
    int i = paramInt1 & this.mask;
    if (paramInt1 == this.keyTable[i])
    {
      this.keyTable[i] = 0;
      int i1 = this.valueTable[i];
      this.size = (-1 + this.size);
      return i1;
    }
    int j = hash2(paramInt1);
    if (paramInt1 == this.keyTable[j])
    {
      this.keyTable[j] = 0;
      int n = this.valueTable[j];
      this.size = (-1 + this.size);
      return n;
    }
    int k = hash3(paramInt1);
    if (paramInt1 == this.keyTable[k])
    {
      this.keyTable[k] = 0;
      int m = this.valueTable[k];
      this.size = (-1 + this.size);
      return m;
    }
    return removeStash(paramInt1, paramInt2);
  }

  int removeStash(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramInt1 == arrayOfInt[i])
        {
          paramInt2 = this.valueTable[i];
          removeStashIndex(i);
          this.size = (-1 + this.size);
        }
      }
      else
        return paramInt2;
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
    int[] arrayOfInt1 = this.keyTable;
    int[] arrayOfInt2 = this.valueTable;
    int i = arrayOfInt1.length;
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
        int n = arrayOfInt1[m];
        if (n != 0)
        {
          localStringBuilder.append(", ");
          localStringBuilder.append(n);
          localStringBuilder.append('=');
          localStringBuilder.append(arrayOfInt2[m]);
          i = m;
          continue;
          int k;
          do
          {
            int j = i;
            i = j - 1;
            if (j <= 0)
              break;
            k = arrayOfInt1[i];
          }
          while (k == 0);
          localStringBuilder.append(k);
          localStringBuilder.append('=');
          localStringBuilder.append(arrayOfInt2[i]);
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

  public IntIntMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new IntIntMap.Values(this);
      this.values2 = new IntIntMap.Values(this);
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
 * Qualified Name:     com.badlogic.gdx.utils.IntIntMap
 * JD-Core Version:    0.6.0
 */