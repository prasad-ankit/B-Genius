package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class IntMap
  implements Iterable
{
  private static final int EMPTY = 0;
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private IntMap.Entries entries1;
  private IntMap.Entries entries2;
  boolean hasZeroValue;
  private int hashShift;
  int[] keyTable;
  private IntMap.Keys keys1;
  private IntMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  Object[] valueTable;
  private IntMap.Values values1;
  private IntMap.Values values2;
  Object zeroValue;

  public IntMap()
  {
    this(32, 0.8F);
  }

  public IntMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public IntMap(int paramInt, float paramFloat)
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
    this.valueTable = ((Object[])new Object[this.keyTable.length]);
  }

  public IntMap(IntMap paramIntMap)
  {
    this(paramIntMap.capacity, paramIntMap.loadFactor);
    this.stashSize = paramIntMap.stashSize;
    System.arraycopy(paramIntMap.keyTable, 0, this.keyTable, 0, paramIntMap.keyTable.length);
    System.arraycopy(paramIntMap.valueTable, 0, this.valueTable, 0, paramIntMap.valueTable.length);
    this.size = paramIntMap.size;
    this.zeroValue = paramIntMap.zeroValue;
    this.hasZeroValue = paramIntMap.hasZeroValue;
  }

  private boolean containsKeyStash(int paramInt)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
        return true;
      i++;
    }
    return false;
  }

  private Object getStash(int paramInt, Object paramObject)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt)
          paramObject = this.valueTable[i];
      }
      else
        return paramObject;
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

  private void push(int paramInt1, Object paramObject, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label255: 
    do
    {
      switch (MathUtils.random(2))
      {
      default:
        Object localObject3 = arrayOfObject[paramInt6];
        arrayOfInt[paramInt6] = paramInt1;
        arrayOfObject[paramInt6] = paramObject;
        paramObject = localObject3;
        paramInt1 = paramInt7;
        paramInt2 = paramInt1 & i;
        paramInt3 = arrayOfInt[paramInt2];
        if (paramInt3 == 0)
        {
          arrayOfInt[paramInt2] = paramInt1;
          arrayOfObject[paramInt2] = paramObject;
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
          Object localObject2 = arrayOfObject[paramInt2];
          arrayOfInt[paramInt2] = paramInt1;
          arrayOfObject[paramInt2] = paramObject;
          paramObject = localObject2;
          paramInt1 = paramInt3;
          break;
          Object localObject1 = arrayOfObject[paramInt4];
          arrayOfInt[paramInt4] = paramInt1;
          arrayOfObject[paramInt4] = paramObject;
          paramObject = localObject1;
          paramInt1 = paramInt5;
          break;
          paramInt4 = hash2(paramInt1);
          paramInt5 = arrayOfInt[paramInt4];
          if (paramInt5 != 0)
            break label255;
          arrayOfInt[paramInt4] = paramInt1;
          arrayOfObject[paramInt4] = paramObject;
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
        arrayOfObject[paramInt6] = paramObject;
        m = this.size;
        this.size = (m + 1);
      }
      while (m < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    label320: putStash(paramInt1, paramObject);
  }

  private void putResize(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      this.zeroValue = paramObject;
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
        this.valueTable[i] = paramObject;
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
        this.valueTable[k] = paramObject;
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
      this.valueTable[n] = paramObject;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt, paramObject, i, j, k, m, n, i1);
  }

  private void putStash(int paramInt, Object paramObject)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramInt, paramObject);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramInt;
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
    this.hashShift = (31 - Integer.numberOfTrailingZeros(paramInt));
    this.stashCapacity = Math.max(3, (int)Math.ceil(Math.log(paramInt)) << 1);
    this.pushIterations = Math.max(Math.min(paramInt, 8), (int)Math.sqrt(paramInt) / 8);
    int[] arrayOfInt = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    this.keyTable = new int[paramInt + this.stashCapacity];
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
        int n = arrayOfInt[m];
        if (n != 0)
          putResize(n, arrayOfObject[m]);
        m++;
      }
    }
  }

  public void clear()
  {
    if (this.size == 0)
      return;
    int[] arrayOfInt = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      arrayOfInt[j] = 0;
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

  public boolean containsValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.valueTable;
    if (paramObject == null)
      if ((!this.hasZeroValue) || (this.zeroValue != null));
    while (true)
    {
      return true;
      int[] arrayOfInt = this.keyTable;
      int i1;
      for (int n = this.capacity + this.stashSize; ; n = i1)
      {
        i1 = n - 1;
        if (n <= 0)
          break label182;
        if ((arrayOfInt[i1] != 0) && (arrayOfObject[i1] == null))
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
            break label182;
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
          break label182;
        if (paramObject.equals(arrayOfObject[j]))
          break;
      }
    }
    label182: return false;
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public IntMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new IntMap.Entries(this);
      this.entries2 = new IntMap.Entries(this);
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
      if (!(paramObject instanceof IntMap))
        return false;
      IntMap localIntMap = (IntMap)paramObject;
      if (localIntMap.size != this.size)
        return false;
      if (localIntMap.hasZeroValue != this.hasZeroValue)
        return false;
      if (this.hasZeroValue)
        if (localIntMap.zeroValue == null)
        {
          if (this.zeroValue != null)
            return false;
        }
        else if (!localIntMap.zeroValue.equals(this.zeroValue))
          return false;
      int[] arrayOfInt = this.keyTable;
      Object[] arrayOfObject = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        int k = arrayOfInt[j];
        if (k == 0)
          continue;
        Object localObject = arrayOfObject[j];
        if (localObject == null)
        {
          if ((!localIntMap.containsKey(k)) || (localIntMap.get(k) != null))
            return false;
        }
        else if (!localObject.equals(localIntMap.get(k)))
          return false;
      }
    }
  }

  public int findKey(Object paramObject, boolean paramBoolean, int paramInt)
  {
    Object[] arrayOfObject = this.valueTable;
    int[] arrayOfInt;
    if (paramObject == null)
    {
      if ((this.hasZeroValue) && (this.zeroValue == null))
      {
        paramInt = 0;
        return paramInt;
      }
      arrayOfInt = this.keyTable;
    }
    int i1;
    for (int n = this.capacity + this.stashSize; ; n = i1)
    {
      i1 = n - 1;
      if (n <= 0)
        break;
      if ((arrayOfInt[i1] != 0) && (arrayOfObject[i1] == null))
      {
        return arrayOfInt[i1];
        if (paramBoolean)
          if (paramObject == this.zeroValue)
            return 0;
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
              return 0;
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

  public Object get(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return null;
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
          return getStash(paramInt, null);
      }
    }
    return this.valueTable[i];
  }

  public Object get(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return paramObject;
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
          return getStash(paramInt, paramObject);
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
      int[] arrayOfInt = this.keyTable;
      Object[] arrayOfObject = this.valueTable;
      int k = this.capacity + this.stashSize;
      while (i < k)
      {
        int m = arrayOfInt[i];
        if (m != 0)
        {
          j += m * 31;
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

  public IntMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new IntMap.Keys(this);
      this.keys2 = new IntMap.Keys(this);
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

  public Object put(int paramInt, Object paramObject)
  {
    if (paramInt == 0)
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
    int[] arrayOfInt = this.keyTable;
    int i = paramInt & this.mask;
    int j = arrayOfInt[i];
    if (j == paramInt)
    {
      Object localObject4 = this.valueTable[i];
      this.valueTable[i] = paramObject;
      return localObject4;
    }
    int k = hash2(paramInt);
    int m = arrayOfInt[k];
    if (m == paramInt)
    {
      Object localObject3 = this.valueTable[k];
      this.valueTable[k] = paramObject;
      return localObject3;
    }
    int n = hash3(paramInt);
    int i1 = arrayOfInt[n];
    if (i1 == paramInt)
    {
      Object localObject2 = this.valueTable[n];
      this.valueTable[n] = paramObject;
      return localObject2;
    }
    int i2 = this.capacity;
    int i3 = i2 + this.stashSize;
    for (int i4 = i2; i4 < i3; i4++)
    {
      if (arrayOfInt[i4] != paramInt)
        continue;
      Object localObject1 = this.valueTable[i4];
      this.valueTable[i4] = paramObject;
      return localObject1;
    }
    if (j == 0)
    {
      arrayOfInt[i] = paramInt;
      this.valueTable[i] = paramObject;
      int i7 = this.size;
      this.size = (i7 + 1);
      if (i7 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (m == 0)
    {
      arrayOfInt[k] = paramInt;
      this.valueTable[k] = paramObject;
      int i6 = this.size;
      this.size = (i6 + 1);
      if (i6 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (i1 == 0)
    {
      arrayOfInt[n] = paramInt;
      this.valueTable[n] = paramObject;
      int i5 = this.size;
      this.size = (i5 + 1);
      if (i5 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    push(paramInt, paramObject, i, j, k, m, n, i1);
    return null;
  }

  public void putAll(IntMap paramIntMap)
  {
    Iterator localIterator = paramIntMap.entries().iterator();
    while (localIterator.hasNext())
    {
      IntMap.Entry localEntry = (IntMap.Entry)localIterator.next();
      put(localEntry.key, localEntry.value);
    }
  }

  public Object remove(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return null;
      Object localObject4 = this.zeroValue;
      this.zeroValue = null;
      this.hasZeroValue = false;
      this.size = (-1 + this.size);
      return localObject4;
    }
    int i = paramInt & this.mask;
    if (this.keyTable[i] == paramInt)
    {
      this.keyTable[i] = 0;
      Object localObject3 = this.valueTable[i];
      this.valueTable[i] = null;
      this.size = (-1 + this.size);
      return localObject3;
    }
    int j = hash2(paramInt);
    if (this.keyTable[j] == paramInt)
    {
      this.keyTable[j] = 0;
      Object localObject2 = this.valueTable[j];
      this.valueTable[j] = null;
      this.size = (-1 + this.size);
      return localObject2;
    }
    int k = hash3(paramInt);
    if (this.keyTable[k] == paramInt)
    {
      this.keyTable[k] = 0;
      Object localObject1 = this.valueTable[k];
      this.valueTable[k] = null;
      this.size = (-1 + this.size);
      return localObject1;
    }
    return removeStash(paramInt);
  }

  Object removeStash(int paramInt)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    for (int k = i; k < j; k++)
    {
      if (arrayOfInt[k] != paramInt)
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
    int[] arrayOfInt = this.keyTable;
    Object[] arrayOfObject = this.valueTable;
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
          localStringBuilder.append(arrayOfObject[m]);
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
          localStringBuilder.append(arrayOfObject[i]);
          continue;
        }
      }
      else
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      i = m;
    }
  }

  public IntMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new IntMap.Values(this);
      this.values2 = new IntMap.Values(this);
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
 * Qualified Name:     com.badlogic.gdx.utils.IntMap
 * JD-Core Version:    0.6.0
 */