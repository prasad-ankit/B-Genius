package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class LongMap
  implements Iterable
{
  private static final int EMPTY = 0;
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private LongMap.Entries entries1;
  private LongMap.Entries entries2;
  boolean hasZeroValue;
  private int hashShift;
  long[] keyTable;
  private LongMap.Keys keys1;
  private LongMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  Object[] valueTable;
  private LongMap.Values values1;
  private LongMap.Values values2;
  Object zeroValue;

  public LongMap()
  {
    this(32, 0.8F);
  }

  public LongMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public LongMap(int paramInt, float paramFloat)
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
    this.hashShift = (63 - Long.numberOfTrailingZeros(this.capacity));
    this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(this.capacity)) << 1);
    this.pushIterations = Math.max(Math.min(this.capacity, 8), (int)Math.sqrt(this.capacity) / 8);
    this.keyTable = new long[this.capacity + this.stashCapacity];
    this.valueTable = ((Object[])new Object[this.keyTable.length]);
  }

  public LongMap(LongMap paramLongMap)
  {
    this(paramLongMap.capacity, paramLongMap.loadFactor);
    this.stashSize = paramLongMap.stashSize;
    System.arraycopy(paramLongMap.keyTable, 0, this.keyTable, 0, paramLongMap.keyTable.length);
    System.arraycopy(paramLongMap.valueTable, 0, this.valueTable, 0, paramLongMap.valueTable.length);
    this.size = paramLongMap.size;
    this.zeroValue = paramLongMap.zeroValue;
    this.hasZeroValue = paramLongMap.hasZeroValue;
  }

  private boolean containsKeyStash(long paramLong)
  {
    long[] arrayOfLong = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong)
        return true;
      i++;
    }
    return false;
  }

  private Object getStash(long paramLong, Object paramObject)
  {
    long[] arrayOfLong = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (arrayOfLong[i] == paramLong)
          paramObject = this.valueTable[i];
      }
      else
        return paramObject;
      i++;
    }
  }

  private int hash2(long paramLong)
  {
    long l = -1262997959L * paramLong;
    return (int)((l ^ l >>> this.hashShift) & this.mask);
  }

  private int hash3(long paramLong)
  {
    long l = -825114047L * paramLong;
    return (int)((l ^ l >>> this.hashShift) & this.mask);
  }

  private void push(long paramLong1, Object paramObject, int paramInt1, long paramLong2, int paramInt2, long paramLong3, int paramInt3, long paramLong4)
  {
    long[] arrayOfLong = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label268: label335: 
    do
    {
      switch (MathUtils.random(2))
      {
      default:
        Object localObject3 = arrayOfObject[paramInt3];
        arrayOfLong[paramInt3] = paramLong1;
        arrayOfObject[paramInt3] = paramObject;
        paramObject = localObject3;
        paramLong1 = paramLong4;
        paramInt1 = (int)(paramLong1 & i);
        paramLong2 = arrayOfLong[paramInt1];
        if (paramLong2 == 0L)
        {
          arrayOfLong[paramInt1] = paramLong1;
          arrayOfObject[paramInt1] = paramObject;
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
          Object localObject2 = arrayOfObject[paramInt1];
          arrayOfLong[paramInt1] = paramLong1;
          arrayOfObject[paramInt1] = paramObject;
          paramObject = localObject2;
          paramLong1 = paramLong2;
          break;
          Object localObject1 = arrayOfObject[paramInt2];
          arrayOfLong[paramInt2] = paramLong1;
          arrayOfObject[paramInt2] = paramObject;
          paramObject = localObject1;
          paramLong1 = paramLong3;
          break;
          paramInt2 = hash2(paramLong1);
          paramLong3 = arrayOfLong[paramInt2];
          if (paramLong3 != 0L)
            break label268;
          arrayOfLong[paramInt2] = paramLong1;
          arrayOfObject[paramInt2] = paramObject;
          n = this.size;
          this.size = (n + 1);
        }
        while (n < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt3 = hash3(paramLong1);
        paramLong4 = arrayOfLong[paramInt3];
        if (paramLong4 != 0L)
          break label335;
        arrayOfLong[paramInt3] = paramLong1;
        arrayOfObject[paramInt3] = paramObject;
        m = this.size;
        this.size = (m + 1);
      }
      while (m < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    putStash(paramLong1, paramObject);
  }

  private void putResize(long paramLong, Object paramObject)
  {
    if (paramLong == 0L)
    {
      this.zeroValue = paramObject;
      this.hasZeroValue = true;
    }
    int i;
    long l1;
    int j;
    long l2;
    int k;
    long l3;
    while (true)
    {
      return;
      i = (int)(paramLong & this.mask);
      l1 = this.keyTable[i];
      if (l1 == 0L)
      {
        this.keyTable[i] = paramLong;
        this.valueTable[i] = paramObject;
        int i1 = this.size;
        this.size = (i1 + 1);
        if (i1 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      j = hash2(paramLong);
      l2 = this.keyTable[j];
      if (l2 == 0L)
      {
        this.keyTable[j] = paramLong;
        this.valueTable[j] = paramObject;
        int n = this.size;
        this.size = (n + 1);
        if (n < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      k = hash3(paramLong);
      l3 = this.keyTable[k];
      if (l3 != 0L)
        break;
      this.keyTable[k] = paramLong;
      this.valueTable[k] = paramObject;
      int m = this.size;
      this.size = (m + 1);
      if (m < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramLong, paramObject, i, l1, j, l2, k, l3);
  }

  private void putStash(long paramLong, Object paramObject)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramLong, paramObject);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramLong;
    this.valueTable[i] = paramObject;
    this.stashSize = (1 + this.stashSize);
    this.size = (1 + this.size);
  }

  private void resize(int paramInt)
  {
    int i = this.capacity + this.stashSize;
    this.capacity = paramInt;
    this.threshold = (int)(paramInt * this.loadFactor);
    this.mask = (paramInt - 1);
    this.hashShift = (63 - Long.numberOfTrailingZeros(paramInt));
    this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(paramInt)) << 1);
    this.pushIterations = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    long[] arrayOfLong = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    this.keyTable = new long[paramInt + this.stashCapacity];
    this.valueTable = ((Object[])new Object[paramInt + this.stashCapacity]);
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
        long l = arrayOfLong[m];
        if (l != 0L)
          putResize(l, arrayOfObject[m]);
        m++;
      }
    }
  }

  public void clear()
  {
    if (this.size == 0)
      return;
    long[] arrayOfLong = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      arrayOfLong[j] = 0L;
      arrayOfObject[j] = null;
    }
    this.size = 0;
    this.stashSize = 0;
    this.zeroValue = null;
    this.hasZeroValue = false;
  }

  public void clear(int paramInt)
  {
    if (this.capacity <= paramInt)
    {
      clear();
      return;
    }
    this.zeroValue = null;
    this.hasZeroValue = false;
    this.size = 0;
    resize(paramInt);
  }

  public boolean containsKey(long paramLong)
  {
    if (paramLong == 0L)
      return this.hasZeroValue;
    int i = (int)(paramLong & this.mask);
    if (this.keyTable[i] != paramLong)
    {
      int j = hash2(paramLong);
      if (this.keyTable[j] != paramLong)
      {
        int k = hash3(paramLong);
        if (this.keyTable[k] != paramLong)
          return containsKeyStash(paramLong);
      }
    }
    return true;
  }

  public boolean containsValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.valueTable;
    if (paramObject == null)
      if ((!this.hasZeroValue) || (this.zeroValue != null));
    while (true)
    {
      return true;
      long[] arrayOfLong = this.keyTable;
      int i1;
      for (int n = this.capacity + this.stashSize; ; n = i1)
      {
        i1 = n - 1;
        if (n <= 0)
          break label184;
        if ((arrayOfLong[i1] != 0L) && (arrayOfObject[i1] == null))
          break;
      }
      if (paramBoolean)
      {
        if (paramObject == this.zeroValue)
          continue;
        int m;
        for (int k = this.capacity + this.stashSize; ; k = m)
        {
          m = k - 1;
          if (k <= 0)
            break label184;
          if (arrayOfObject[m] == paramObject)
            break;
        }
      }
      if ((this.hasZeroValue) && (paramObject.equals(this.zeroValue)))
        continue;
      int j;
      for (int i = this.capacity + this.stashSize; ; i = j)
      {
        j = i - 1;
        if (i <= 0)
          break label184;
        if (paramObject.equals(arrayOfObject[j]))
          break;
      }
    }
    label184: return false;
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public LongMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new LongMap.Entries(this);
      this.entries2 = new LongMap.Entries(this);
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
      if (!(paramObject instanceof LongMap))
        return false;
      LongMap localLongMap = (LongMap)paramObject;
      if (localLongMap.size != this.size)
        return false;
      if (localLongMap.hasZeroValue != this.hasZeroValue)
        return false;
      if (this.hasZeroValue)
        if (localLongMap.zeroValue == null)
        {
          if (this.zeroValue != null)
            return false;
        }
        else if (!localLongMap.zeroValue.equals(this.zeroValue))
          return false;
      long[] arrayOfLong = this.keyTable;
      Object[] arrayOfObject = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        long l = arrayOfLong[j];
        if (l == 0L)
          continue;
        Object localObject = arrayOfObject[j];
        if (localObject == null)
        {
          if ((!localLongMap.containsKey(l)) || (localLongMap.get(l) != null))
            return false;
        }
        else if (!localObject.equals(localLongMap.get(l)))
          return false;
      }
    }
  }

  public long findKey(Object paramObject, boolean paramBoolean, long paramLong)
  {
    Object[] arrayOfObject = this.valueTable;
    long[] arrayOfLong;
    if (paramObject == null)
    {
      if ((this.hasZeroValue) && (this.zeroValue == null))
      {
        paramLong = 0L;
        return paramLong;
      }
      arrayOfLong = this.keyTable;
    }
    int i1;
    for (int n = this.capacity + this.stashSize; ; n = i1)
    {
      i1 = n - 1;
      if (n <= 0)
        break;
      if ((arrayOfLong[i1] != 0L) && (arrayOfObject[i1] == null))
      {
        return arrayOfLong[i1];
        if (paramBoolean)
          if (paramObject == this.zeroValue)
            return 0L;
        int m;
        for (int k = this.capacity + this.stashSize; ; k = m)
        {
          m = k - 1;
          if (k <= 0)
            break;
          if (arrayOfObject[m] == paramObject)
          {
            return this.keyTable[m];
            if ((this.hasZeroValue) && (paramObject.equals(this.zeroValue)))
              return 0L;
            int j;
            for (int i = this.capacity + this.stashSize; ; i = j)
            {
              j = i - 1;
              if (i <= 0)
                break;
              if (paramObject.equals(arrayOfObject[j]))
                return this.keyTable[j];
            }
          }
        }
      }
    }
  }

  public Object get(long paramLong)
  {
    if (paramLong == 0L)
    {
      if (!this.hasZeroValue)
        return null;
      return this.zeroValue;
    }
    int i = (int)(paramLong & this.mask);
    if (this.keyTable[i] != paramLong)
    {
      i = hash2(paramLong);
      if (this.keyTable[i] != paramLong)
      {
        i = hash3(paramLong);
        if (this.keyTable[i] != paramLong)
          return getStash(paramLong, null);
      }
    }
    return this.valueTable[i];
  }

  public Object get(long paramLong, Object paramObject)
  {
    if (paramLong == 0L)
    {
      if (!this.hasZeroValue)
        return paramObject;
      return this.zeroValue;
    }
    int i = (int)(paramLong & this.mask);
    if (this.keyTable[i] != paramLong)
    {
      i = hash2(paramLong);
      if (this.keyTable[i] != paramLong)
      {
        i = hash3(paramLong);
        if (this.keyTable[i] != paramLong)
          return getStash(paramLong, paramObject);
      }
    }
    return this.valueTable[i];
  }

  public int hashCode()
  {
    int i = 0;
    if ((this.hasZeroValue) && (this.zeroValue != null));
    for (int j = 0 + this.zeroValue.hashCode(); ; j = 0)
    {
      long[] arrayOfLong = this.keyTable;
      Object[] arrayOfObject = this.valueTable;
      int k = this.capacity + this.stashSize;
      while (i < k)
      {
        long l = arrayOfLong[i];
        if (l != 0L)
        {
          j += 31 * (int)(l ^ l >>> 32);
          Object localObject = arrayOfObject[i];
          if (localObject != null)
            j += localObject.hashCode();
        }
        i++;
      }
      return j;
    }
  }

  public Iterator iterator()
  {
    return entries();
  }

  public LongMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new LongMap.Keys(this);
      this.keys2 = new LongMap.Keys(this);
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

  public Object put(long paramLong, Object paramObject)
  {
    if (paramLong == 0L)
    {
      Object localObject5 = this.zeroValue;
      this.zeroValue = paramObject;
      if (!this.hasZeroValue)
      {
        this.hasZeroValue = true;
        this.size = (1 + this.size);
      }
      return localObject5;
    }
    long[] arrayOfLong = this.keyTable;
    int i = (int)(paramLong & this.mask);
    long l1 = arrayOfLong[i];
    if (l1 == paramLong)
    {
      Object localObject4 = this.valueTable[i];
      this.valueTable[i] = paramObject;
      return localObject4;
    }
    int j = hash2(paramLong);
    long l2 = arrayOfLong[j];
    if (l2 == paramLong)
    {
      Object localObject3 = this.valueTable[j];
      this.valueTable[j] = paramObject;
      return localObject3;
    }
    int k = hash3(paramLong);
    long l3 = arrayOfLong[k];
    if (l3 == paramLong)
    {
      Object localObject2 = this.valueTable[k];
      this.valueTable[k] = paramObject;
      return localObject2;
    }
    int m = this.capacity;
    int n = m + this.stashSize;
    for (int i1 = m; i1 < n; i1++)
    {
      if (arrayOfLong[i1] != paramLong)
        continue;
      Object localObject1 = this.valueTable[i1];
      this.valueTable[i1] = paramObject;
      return localObject1;
    }
    if (l1 == 0L)
    {
      arrayOfLong[i] = paramLong;
      this.valueTable[i] = paramObject;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (l2 == 0L)
    {
      arrayOfLong[j] = paramLong;
      this.valueTable[j] = paramObject;
      int i3 = this.size;
      this.size = (i3 + 1);
      if (i3 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (l3 == 0L)
    {
      arrayOfLong[k] = paramLong;
      this.valueTable[k] = paramObject;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    push(paramLong, paramObject, i, l1, j, l2, k, l3);
    return null;
  }

  public void putAll(LongMap paramLongMap)
  {
    Iterator localIterator = paramLongMap.entries().iterator();
    while (localIterator.hasNext())
    {
      LongMap.Entry localEntry = (LongMap.Entry)localIterator.next();
      put(localEntry.key, localEntry.value);
    }
  }

  public Object remove(long paramLong)
  {
    if (paramLong == 0L)
    {
      if (!this.hasZeroValue)
        return null;
      Object localObject4 = this.zeroValue;
      this.zeroValue = null;
      this.hasZeroValue = false;
      this.size = (-1 + this.size);
      return localObject4;
    }
    int i = (int)(paramLong & this.mask);
    if (this.keyTable[i] == paramLong)
    {
      this.keyTable[i] = 0L;
      Object localObject3 = this.valueTable[i];
      this.valueTable[i] = null;
      this.size = (-1 + this.size);
      return localObject3;
    }
    int j = hash2(paramLong);
    if (this.keyTable[j] == paramLong)
    {
      this.keyTable[j] = 0L;
      Object localObject2 = this.valueTable[j];
      this.valueTable[j] = null;
      this.size = (-1 + this.size);
      return localObject2;
    }
    int k = hash3(paramLong);
    if (this.keyTable[k] == paramLong)
    {
      this.keyTable[k] = 0L;
      Object localObject1 = this.valueTable[k];
      this.valueTable[k] = null;
      this.size = (-1 + this.size);
      return localObject1;
    }
    return removeStash(paramLong);
  }

  Object removeStash(long paramLong)
  {
    long[] arrayOfLong = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    for (int k = i; k < j; k++)
    {
      if (arrayOfLong[k] != paramLong)
        continue;
      Object localObject = this.valueTable[k];
      removeStashIndex(k);
      this.size = (-1 + this.size);
      return localObject;
    }
    return null;
  }

  void removeStashIndex(int paramInt)
  {
    this.stashSize = (-1 + this.stashSize);
    int i = this.capacity + this.stashSize;
    if (paramInt < i)
    {
      this.keyTable[paramInt] = this.keyTable[i];
      this.valueTable[paramInt] = this.valueTable[i];
      this.valueTable[i] = null;
      return;
    }
    this.valueTable[paramInt] = null;
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
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    long[] arrayOfLong = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    int j;
    for (int i = arrayOfLong.length; ; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        long l2 = arrayOfLong[j];
        if (l2 == 0L)
          continue;
        localStringBuilder.append(l2);
        localStringBuilder.append('=');
        localStringBuilder.append(arrayOfObject[j]);
      }
      while (true)
      {
        int k = j - 1;
        if (j > 0)
        {
          long l1 = arrayOfLong[k];
          if (l1 != 0L)
          {
            localStringBuilder.append(", ");
            localStringBuilder.append(l1);
            localStringBuilder.append('=');
            localStringBuilder.append(arrayOfObject[k]);
            j = k;
            continue;
          }
        }
        else
        {
          localStringBuilder.append(']');
          return localStringBuilder.toString();
        }
        j = k;
      }
    }
  }

  public LongMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new LongMap.Values(this);
      this.values2 = new LongMap.Values(this);
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
 * Qualified Name:     com.badlogic.gdx.utils.LongMap
 * JD-Core Version:    0.6.0
 */