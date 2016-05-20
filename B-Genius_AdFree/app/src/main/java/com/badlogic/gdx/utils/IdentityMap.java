package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class IdentityMap
  implements Iterable
{
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private IdentityMap.Entries entries1;
  private IdentityMap.Entries entries2;
  private int hashShift;
  Object[] keyTable;
  private IdentityMap.Keys keys1;
  private IdentityMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  Object[] valueTable;
  private IdentityMap.Values values1;
  private IdentityMap.Values values2;

  public IdentityMap()
  {
    this(32, 0.8F);
  }

  public IdentityMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public IdentityMap(int paramInt, float paramFloat)
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
    this.keyTable = ((Object[])new Object[this.capacity + this.stashCapacity]);
    this.valueTable = ((Object[])new Object[this.keyTable.length]);
  }

  public IdentityMap(IdentityMap paramIdentityMap)
  {
    this(paramIdentityMap.capacity, paramIdentityMap.loadFactor);
    this.stashSize = paramIdentityMap.stashSize;
    System.arraycopy(paramIdentityMap.keyTable, 0, this.keyTable, 0, paramIdentityMap.keyTable.length);
    System.arraycopy(paramIdentityMap.valueTable, 0, this.valueTable, 0, paramIdentityMap.valueTable.length);
    this.size = paramIdentityMap.size;
  }

  private boolean containsKeyStash(Object paramObject)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (arrayOfObject[i] == paramObject)
        return true;
      i++;
    }
    return false;
  }

  private Object getStash(Object paramObject1, Object paramObject2)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (arrayOfObject[i] == paramObject1)
          paramObject2 = this.valueTable[i];
      }
      else
        return paramObject2;
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

  private void push(Object paramObject1, Object paramObject2, int paramInt1, Object paramObject3, int paramInt2, Object paramObject4, int paramInt3, Object paramObject5)
  {
    Object[] arrayOfObject1 = this.keyTable;
    Object[] arrayOfObject2 = this.valueTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label263: label329: 
    do
    {
      int m;
      switch (MathUtils.random(2))
      {
      default:
        Object localObject3 = arrayOfObject2[paramInt3];
        arrayOfObject1[paramInt3] = paramObject1;
        arrayOfObject2[paramInt3] = paramObject2;
        paramObject2 = localObject3;
        paramObject1 = paramObject5;
        m = System.identityHashCode(paramObject1);
        paramInt1 = m & i;
        paramObject3 = arrayOfObject1[paramInt1];
        if (paramObject3 == null)
        {
          arrayOfObject1[paramInt1] = paramObject1;
          arrayOfObject2[paramInt1] = paramObject2;
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
          Object localObject2 = arrayOfObject2[paramInt1];
          arrayOfObject1[paramInt1] = paramObject1;
          arrayOfObject2[paramInt1] = paramObject2;
          paramObject2 = localObject2;
          paramObject1 = paramObject3;
          break;
          Object localObject1 = arrayOfObject2[paramInt2];
          arrayOfObject1[paramInt2] = paramObject1;
          arrayOfObject2[paramInt2] = paramObject2;
          paramObject2 = localObject1;
          paramObject1 = paramObject4;
          break;
          paramInt2 = hash2(m);
          paramObject4 = arrayOfObject1[paramInt2];
          if (paramObject4 != null)
            break label263;
          arrayOfObject1[paramInt2] = paramObject1;
          arrayOfObject2[paramInt2] = paramObject2;
          i1 = this.size;
          this.size = (i1 + 1);
        }
        while (i1 < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt3 = hash3(m);
        paramObject5 = arrayOfObject1[paramInt3];
        if (paramObject5 != null)
          break label329;
        arrayOfObject1[paramInt3] = paramObject1;
        arrayOfObject2[paramInt3] = paramObject2;
        n = this.size;
        this.size = (n + 1);
      }
      while (n < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    putStash(paramObject1, paramObject2);
  }

  private void putResize(Object paramObject1, Object paramObject2)
  {
    int i = System.identityHashCode(paramObject1);
    int j = i & this.mask;
    Object localObject1 = this.keyTable[j];
    if (localObject1 == null)
    {
      this.keyTable[j] = paramObject1;
      this.valueTable[j] = paramObject2;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 >= this.threshold)
        resize(this.capacity << 1);
    }
    int k;
    Object localObject2;
    int m;
    Object localObject3;
    while (true)
    {
      return;
      k = hash2(i);
      localObject2 = this.keyTable[k];
      if (localObject2 == null)
      {
        this.keyTable[k] = paramObject1;
        this.valueTable[k] = paramObject2;
        int i1 = this.size;
        this.size = (i1 + 1);
        if (i1 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      m = hash3(i);
      localObject3 = this.keyTable[m];
      if (localObject3 != null)
        break;
      this.keyTable[m] = paramObject1;
      this.valueTable[m] = paramObject2;
      int n = this.size;
      this.size = (n + 1);
      if (n < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramObject1, paramObject2, j, localObject1, k, localObject2, m, localObject3);
  }

  private void putStash(Object paramObject1, Object paramObject2)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramObject1, paramObject2);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramObject1;
    this.valueTable[i] = paramObject2;
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
    Object[] arrayOfObject1 = this.keyTable;
    Object[] arrayOfObject2 = this.valueTable;
    this.keyTable = ((Object[])new Object[paramInt + this.stashCapacity]);
    this.valueTable = ((Object[])new Object[paramInt + this.stashCapacity]);
    int j = this.size;
    this.size = 0;
    this.stashSize = 0;
    if (j > 0)
      for (int k = 0; k < i; k++)
      {
        Object localObject = arrayOfObject1[k];
        if (localObject == null)
          continue;
        putResize(localObject, arrayOfObject2[k]);
      }
  }

  public void clear()
  {
    if (this.size == 0)
      return;
    Object[] arrayOfObject1 = this.keyTable;
    Object[] arrayOfObject2 = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      arrayOfObject1[j] = null;
      arrayOfObject2[j] = null;
    }
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
    this.size = 0;
    resize(paramInt);
  }

  public boolean containsKey(Object paramObject)
  {
    int i = System.identityHashCode(paramObject);
    int j = i & this.mask;
    if (paramObject != this.keyTable[j])
    {
      int k = hash2(i);
      if (paramObject != this.keyTable[k])
      {
        int m = hash3(i);
        if (paramObject != this.keyTable[m])
          return containsKeyStash(paramObject);
      }
    }
    return true;
  }

  public boolean containsValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject1 = this.valueTable;
    Object[] arrayOfObject2;
    if (paramObject == null)
      arrayOfObject2 = this.keyTable;
    int i1;
    for (int n = this.capacity + this.stashSize; ; n = i1)
    {
      i1 = n - 1;
      if (n > 0)
      {
        if ((arrayOfObject2[i1] != null) && (arrayOfObject1[i1] == null))
        {
          return true;
          if (paramBoolean)
          {
            int m;
            for (int k = this.capacity + this.stashSize; ; k = m)
            {
              m = k - 1;
              if (k <= 0)
                break label135;
              if (arrayOfObject1[m] == paramObject)
                break;
            }
          }
          int j;
          for (int i = this.capacity + this.stashSize; ; i = j)
          {
            j = i - 1;
            if (i <= 0)
              break label135;
            if (paramObject.equals(arrayOfObject1[j]))
              break;
          }
        }
      }
      else
        label135: return false;
    }
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public IdentityMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new IdentityMap.Entries(this);
      this.entries2 = new IdentityMap.Entries(this);
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
      if (!(paramObject instanceof IdentityMap))
        return false;
      IdentityMap localIdentityMap = (IdentityMap)paramObject;
      if (localIdentityMap.size != this.size)
        return false;
      Object[] arrayOfObject1 = this.keyTable;
      Object[] arrayOfObject2 = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        Object localObject1 = arrayOfObject1[j];
        if (localObject1 == null)
          continue;
        Object localObject2 = arrayOfObject2[j];
        if (localObject2 == null)
        {
          if ((!localIdentityMap.containsKey(localObject1)) || (localIdentityMap.get(localObject1) != null))
            return false;
        }
        else if (!localObject2.equals(localIdentityMap.get(localObject1)))
          return false;
      }
    }
  }

  public Object findKey(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject1 = this.valueTable;
    Object[] arrayOfObject2;
    if (paramObject == null)
      arrayOfObject2 = this.keyTable;
    int i1;
    for (int n = this.capacity + this.stashSize; ; n = i1)
    {
      i1 = n - 1;
      if (n > 0)
      {
        if ((arrayOfObject2[i1] == null) || (arrayOfObject1[i1] != null))
          continue;
        return arrayOfObject2[i1];
        if (!paramBoolean);
      }
      int m;
      for (int k = this.capacity + this.stashSize; ; k = m)
      {
        m = k - 1;
        if (k > 0)
        {
          if (arrayOfObject1[m] == paramObject)
            return this.keyTable[m];
        }
        else
        {
          int j;
          for (int i = this.capacity + this.stashSize; ; i = j)
          {
            j = i - 1;
            if (i > 0)
            {
              if (paramObject.equals(arrayOfObject1[j]))
                return this.keyTable[j];
            }
            else
              return null;
          }
        }
      }
    }
  }

  public Object get(Object paramObject)
  {
    int i = System.identityHashCode(paramObject);
    int j = i & this.mask;
    if (paramObject != this.keyTable[j])
    {
      j = hash2(i);
      if (paramObject != this.keyTable[j])
      {
        j = hash3(i);
        if (paramObject != this.keyTable[j])
          return getStash(paramObject, null);
      }
    }
    return this.valueTable[j];
  }

  public Object get(Object paramObject1, Object paramObject2)
  {
    int i = System.identityHashCode(paramObject1);
    int j = i & this.mask;
    if (paramObject1 != this.keyTable[j])
    {
      j = hash2(i);
      if (paramObject1 != this.keyTable[j])
      {
        j = hash3(i);
        if (paramObject1 != this.keyTable[j])
          return getStash(paramObject1, paramObject2);
      }
    }
    return this.valueTable[j];
  }

  public int hashCode()
  {
    int i = 0;
    Object[] arrayOfObject1 = this.keyTable;
    Object[] arrayOfObject2 = this.valueTable;
    int j = this.capacity + this.stashSize;
    for (int k = 0; k < j; k++)
    {
      Object localObject1 = arrayOfObject1[k];
      if (localObject1 == null)
        continue;
      i += 31 * localObject1.hashCode();
      Object localObject2 = arrayOfObject2[k];
      if (localObject2 == null)
        continue;
      i += localObject2.hashCode();
    }
    return i;
  }

  public Iterator iterator()
  {
    return entries();
  }

  public IdentityMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new IdentityMap.Keys(this);
      this.keys2 = new IdentityMap.Keys(this);
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

  public Object put(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
      throw new IllegalArgumentException("key cannot be null.");
    Object[] arrayOfObject = this.keyTable;
    int i = System.identityHashCode(paramObject1);
    int j = i & this.mask;
    Object localObject1 = arrayOfObject[j];
    if (localObject1 == paramObject1)
    {
      Object localObject7 = this.valueTable[j];
      this.valueTable[j] = paramObject2;
      return localObject7;
    }
    int k = hash2(i);
    Object localObject2 = arrayOfObject[k];
    if (localObject2 == paramObject1)
    {
      Object localObject6 = this.valueTable[k];
      this.valueTable[k] = paramObject2;
      return localObject6;
    }
    int m = hash3(i);
    Object localObject3 = arrayOfObject[m];
    if (localObject3 == paramObject1)
    {
      Object localObject5 = this.valueTable[m];
      this.valueTable[m] = paramObject2;
      return localObject5;
    }
    int n = this.capacity;
    int i1 = n + this.stashSize;
    for (int i2 = n; i2 < i1; i2++)
    {
      if (arrayOfObject[i2] != paramObject1)
        continue;
      Object localObject4 = this.valueTable[i2];
      this.valueTable[i2] = paramObject2;
      return localObject4;
    }
    if (localObject1 == null)
    {
      arrayOfObject[j] = paramObject1;
      this.valueTable[j] = paramObject2;
      int i5 = this.size;
      this.size = (i5 + 1);
      if (i5 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (localObject2 == null)
    {
      arrayOfObject[k] = paramObject1;
      this.valueTable[k] = paramObject2;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    if (localObject3 == null)
    {
      arrayOfObject[m] = paramObject1;
      this.valueTable[m] = paramObject2;
      int i3 = this.size;
      this.size = (i3 + 1);
      if (i3 >= this.threshold)
        resize(this.capacity << 1);
      return null;
    }
    push(paramObject1, paramObject2, j, localObject1, k, localObject2, m, localObject3);
    return null;
  }

  public Object remove(Object paramObject)
  {
    int i = System.identityHashCode(paramObject);
    int j = i & this.mask;
    if (this.keyTable[j] == paramObject)
    {
      this.keyTable[j] = null;
      Object localObject3 = this.valueTable[j];
      this.valueTable[j] = null;
      this.size = (-1 + this.size);
      return localObject3;
    }
    int k = hash2(i);
    if (this.keyTable[k] == paramObject)
    {
      this.keyTable[k] = null;
      Object localObject2 = this.valueTable[k];
      this.valueTable[k] = null;
      this.size = (-1 + this.size);
      return localObject2;
    }
    int m = hash3(i);
    if (this.keyTable[m] == paramObject)
    {
      this.keyTable[m] = null;
      Object localObject1 = this.valueTable[m];
      this.valueTable[m] = null;
      this.size = (-1 + this.size);
      return localObject1;
    }
    return removeStash(paramObject);
  }

  Object removeStash(Object paramObject)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    for (int k = i; k < j; k++)
    {
      if (arrayOfObject[k] != paramObject)
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
    Object[] arrayOfObject1 = this.keyTable;
    Object[] arrayOfObject2 = this.valueTable;
    int j;
    for (int i = arrayOfObject1.length; ; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        Object localObject2 = arrayOfObject1[j];
        if (localObject2 == null)
          continue;
        localStringBuilder.append(localObject2);
        localStringBuilder.append('=');
        localStringBuilder.append(arrayOfObject2[j]);
      }
      while (true)
      {
        int k = j - 1;
        if (j > 0)
        {
          Object localObject1 = arrayOfObject1[k];
          if (localObject1 != null)
          {
            localStringBuilder.append(", ");
            localStringBuilder.append(localObject1);
            localStringBuilder.append('=');
            localStringBuilder.append(arrayOfObject2[k]);
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

  public IdentityMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new IdentityMap.Values(this);
      this.values2 = new IdentityMap.Values(this);
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
 * Qualified Name:     com.badlogic.gdx.utils.IdentityMap
 * JD-Core Version:    0.6.0
 */