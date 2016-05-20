package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class ObjectFloatMap
  implements Iterable
{
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private ObjectFloatMap.Entries entries1;
  private ObjectFloatMap.Entries entries2;
  private int hashShift;
  Object[] keyTable;
  private ObjectFloatMap.Keys keys1;
  private ObjectFloatMap.Keys keys2;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;
  float[] valueTable;
  private ObjectFloatMap.Values values1;
  private ObjectFloatMap.Values values2;

  public ObjectFloatMap()
  {
    this(32, 0.8F);
  }

  public ObjectFloatMap(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public ObjectFloatMap(int paramInt, float paramFloat)
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
    this.valueTable = new float[this.keyTable.length];
  }

  public ObjectFloatMap(ObjectFloatMap paramObjectFloatMap)
  {
    this(paramObjectFloatMap.capacity, paramObjectFloatMap.loadFactor);
    this.stashSize = paramObjectFloatMap.stashSize;
    System.arraycopy(paramObjectFloatMap.keyTable, 0, this.keyTable, 0, paramObjectFloatMap.keyTable.length);
    System.arraycopy(paramObjectFloatMap.valueTable, 0, this.valueTable, 0, paramObjectFloatMap.valueTable.length);
    this.size = paramObjectFloatMap.size;
  }

  private boolean containsKeyStash(Object paramObject)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i]))
        return true;
      i++;
    }
    return false;
  }

  private float getAndIncrementStash(Object paramObject, float paramFloat1, float paramFloat2)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i]))
      {
        float f = this.valueTable[i];
        this.valueTable[i] = (f + paramFloat2);
        return f;
      }
      i++;
    }
    put(paramObject, paramFloat1 + paramFloat2);
    return paramFloat1;
  }

  private float getStash(Object paramObject, float paramFloat)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramObject.equals(arrayOfObject[i]))
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

  private void push(Object paramObject1, float paramFloat, int paramInt1, Object paramObject2, int paramInt2, Object paramObject3, int paramInt3, Object paramObject4)
  {
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
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
        float f3 = arrayOfFloat[paramInt3];
        arrayOfObject[paramInt3] = paramObject1;
        arrayOfFloat[paramInt3] = paramFloat;
        paramFloat = f3;
        paramObject1 = paramObject4;
        m = paramObject1.hashCode();
        paramInt1 = m & i;
        paramObject2 = arrayOfObject[paramInt1];
        if (paramObject2 == null)
        {
          arrayOfObject[paramInt1] = paramObject1;
          arrayOfFloat[paramInt1] = paramFloat;
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
          float f2 = arrayOfFloat[paramInt1];
          arrayOfObject[paramInt1] = paramObject1;
          arrayOfFloat[paramInt1] = paramFloat;
          paramFloat = f2;
          paramObject1 = paramObject2;
          break;
          float f1 = arrayOfFloat[paramInt2];
          arrayOfObject[paramInt2] = paramObject1;
          arrayOfFloat[paramInt2] = paramFloat;
          paramFloat = f1;
          paramObject1 = paramObject3;
          break;
          paramInt2 = hash2(m);
          paramObject3 = arrayOfObject[paramInt2];
          if (paramObject3 != null)
            break label263;
          arrayOfObject[paramInt2] = paramObject1;
          arrayOfFloat[paramInt2] = paramFloat;
          i1 = this.size;
          this.size = (i1 + 1);
        }
        while (i1 < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt3 = hash3(m);
        paramObject4 = arrayOfObject[paramInt3];
        if (paramObject4 != null)
          break label329;
        arrayOfObject[paramInt3] = paramObject1;
        arrayOfFloat[paramInt3] = paramFloat;
        n = this.size;
        this.size = (n + 1);
      }
      while (n < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    putStash(paramObject1, paramFloat);
  }

  private void putResize(Object paramObject, float paramFloat)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    Object localObject1 = this.keyTable[j];
    if (localObject1 == null)
    {
      this.keyTable[j] = paramObject;
      this.valueTable[j] = paramFloat;
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
        this.keyTable[k] = paramObject;
        this.valueTable[k] = paramFloat;
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
      this.keyTable[m] = paramObject;
      this.valueTable[m] = paramFloat;
      int n = this.size;
      this.size = (n + 1);
      if (n < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramObject, paramFloat, j, localObject1, k, localObject2, m, localObject3);
  }

  private void putStash(Object paramObject, float paramFloat)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      put(paramObject, paramFloat);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramObject;
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
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    this.keyTable = ((Object[])new Object[paramInt + this.stashCapacity]);
    this.valueTable = new float[paramInt + this.stashCapacity];
    int j = this.size;
    this.size = 0;
    this.stashSize = 0;
    if (j > 0)
      for (int k = 0; k < i; k++)
      {
        Object localObject = arrayOfObject[k];
        if (localObject == null)
          continue;
        putResize(localObject, arrayOfFloat[k]);
      }
  }

  public void clear()
  {
    if (this.size == 0)
      return;
    Object[] arrayOfObject = this.keyTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i <= 0)
        break;
      arrayOfObject[j] = null;
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
    int i = paramObject.hashCode();
    int j = i & this.mask;
    if (!paramObject.equals(this.keyTable[j]))
    {
      int k = hash2(i);
      if (!paramObject.equals(this.keyTable[k]))
      {
        int m = hash3(i);
        if (!paramObject.equals(this.keyTable[m]))
          return containsKeyStash(paramObject);
      }
    }
    return true;
  }

  public boolean containsValue(float paramFloat)
  {
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject[j] != null) && (arrayOfFloat[j] == paramFloat))
          return true;
      }
      else
        return false;
    }
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public ObjectFloatMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new ObjectFloatMap.Entries(this);
      this.entries2 = new ObjectFloatMap.Entries(this);
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
      if (!(paramObject instanceof ObjectFloatMap))
        return false;
      ObjectFloatMap localObjectFloatMap = (ObjectFloatMap)paramObject;
      if (localObjectFloatMap.size != this.size)
        return false;
      Object[] arrayOfObject = this.keyTable;
      float[] arrayOfFloat = this.valueTable;
      int i = this.capacity + this.stashSize;
      for (int j = 0; j < i; j++)
      {
        Object localObject = arrayOfObject[j];
        if (localObject == null)
          continue;
        float f = localObjectFloatMap.get(localObject, 0.0F);
        if ((f == 0.0F) && (!localObjectFloatMap.containsKey(localObject)))
          return false;
        if (f != arrayOfFloat[j])
          return false;
      }
    }
  }

  public Object findKey(float paramFloat)
  {
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = this.capacity + this.stashSize; ; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((arrayOfObject[j] != null) && (arrayOfFloat[j] == paramFloat))
          return arrayOfObject[j];
      }
      else
        return null;
    }
  }

  public float get(Object paramObject, float paramFloat)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    if (!paramObject.equals(this.keyTable[j]))
    {
      j = hash2(i);
      if (!paramObject.equals(this.keyTable[j]))
      {
        j = hash3(i);
        if (!paramObject.equals(this.keyTable[j]))
          return getStash(paramObject, paramFloat);
      }
    }
    return this.valueTable[j];
  }

  public float getAndIncrement(Object paramObject, float paramFloat1, float paramFloat2)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    if (!paramObject.equals(this.keyTable[j]))
    {
      j = hash2(i);
      if (!paramObject.equals(this.keyTable[j]))
      {
        j = hash3(i);
        if (!paramObject.equals(this.keyTable[j]))
          return getAndIncrementStash(paramObject, paramFloat1, paramFloat2);
      }
    }
    float f = this.valueTable[j];
    this.valueTable[j] = (f + paramFloat2);
    return f;
  }

  public int hashCode()
  {
    int i = 0;
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j = this.capacity + this.stashSize;
    for (int k = 0; k < j; k++)
    {
      Object localObject = arrayOfObject[k];
      if (localObject == null)
        continue;
      i = i + 31 * localObject.hashCode() + Float.floatToIntBits(arrayOfFloat[k]);
    }
    return i;
  }

  public ObjectFloatMap.Entries iterator()
  {
    return entries();
  }

  public ObjectFloatMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new ObjectFloatMap.Keys(this);
      this.keys2 = new ObjectFloatMap.Keys(this);
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

  public void put(Object paramObject, float paramFloat)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("key cannot be null.");
    Object[] arrayOfObject = this.keyTable;
    int i = paramObject.hashCode();
    int j = i & this.mask;
    Object localObject1 = arrayOfObject[j];
    if (paramObject.equals(localObject1))
      this.valueTable[j] = paramFloat;
    int k;
    Object localObject2;
    int m;
    Object localObject3;
    while (true)
    {
      return;
      k = hash2(i);
      localObject2 = arrayOfObject[k];
      if (paramObject.equals(localObject2))
      {
        this.valueTable[k] = paramFloat;
        return;
      }
      m = hash3(i);
      localObject3 = arrayOfObject[m];
      if (paramObject.equals(localObject3))
      {
        this.valueTable[m] = paramFloat;
        return;
      }
      int n = this.capacity;
      int i1 = n + this.stashSize;
      while (n < i1)
      {
        if (paramObject.equals(arrayOfObject[n]))
        {
          this.valueTable[n] = paramFloat;
          return;
        }
        n++;
      }
      if (localObject1 == null)
      {
        arrayOfObject[j] = paramObject;
        this.valueTable[j] = paramFloat;
        int i4 = this.size;
        this.size = (i4 + 1);
        if (i4 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (localObject2 == null)
      {
        arrayOfObject[k] = paramObject;
        this.valueTable[k] = paramFloat;
        int i3 = this.size;
        this.size = (i3 + 1);
        if (i3 < this.threshold)
          continue;
        resize(this.capacity << 1);
        return;
      }
      if (localObject3 != null)
        break;
      arrayOfObject[m] = paramObject;
      this.valueTable[m] = paramFloat;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramObject, paramFloat, j, localObject1, k, localObject2, m, localObject3);
  }

  public void putAll(ObjectFloatMap paramObjectFloatMap)
  {
    ObjectFloatMap.Entries localEntries = paramObjectFloatMap.entries().iterator();
    while (localEntries.hasNext())
    {
      ObjectFloatMap.Entry localEntry = (ObjectFloatMap.Entry)localEntries.next();
      put(localEntry.key, localEntry.value);
    }
  }

  public float remove(Object paramObject, float paramFloat)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    if (paramObject.equals(this.keyTable[j]))
    {
      this.keyTable[j] = null;
      float f3 = this.valueTable[j];
      this.size = (-1 + this.size);
      return f3;
    }
    int k = hash2(i);
    if (paramObject.equals(this.keyTable[k]))
    {
      this.keyTable[k] = null;
      float f2 = this.valueTable[k];
      this.size = (-1 + this.size);
      return f2;
    }
    int m = hash3(i);
    if (paramObject.equals(this.keyTable[m]))
    {
      this.keyTable[m] = null;
      float f1 = this.valueTable[m];
      this.size = (-1 + this.size);
      return f1;
    }
    return removeStash(paramObject, paramFloat);
  }

  float removeStash(Object paramObject, float paramFloat)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (true)
    {
      if (i < j)
      {
        if (paramObject.equals(arrayOfObject[i]))
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
    Object[] arrayOfObject = this.keyTable;
    float[] arrayOfFloat = this.valueTable;
    int j;
    for (int i = arrayOfObject.length; ; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        Object localObject2 = arrayOfObject[j];
        if (localObject2 == null)
          continue;
        localStringBuilder.append(localObject2);
        localStringBuilder.append('=');
        localStringBuilder.append(arrayOfFloat[j]);
      }
      while (true)
      {
        int k = j - 1;
        if (j > 0)
        {
          Object localObject1 = arrayOfObject[k];
          if (localObject1 != null)
          {
            localStringBuilder.append(", ");
            localStringBuilder.append(localObject1);
            localStringBuilder.append('=');
            localStringBuilder.append(arrayOfFloat[k]);
            j = k;
            continue;
          }
        }
        else
        {
          localStringBuilder.append('}');
          return localStringBuilder.toString();
        }
        j = k;
      }
    }
  }

  public ObjectFloatMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new ObjectFloatMap.Values(this);
      this.values2 = new ObjectFloatMap.Values(this);
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
 * Qualified Name:     com.badlogic.gdx.utils.ObjectFloatMap
 * JD-Core Version:    0.6.0
 */