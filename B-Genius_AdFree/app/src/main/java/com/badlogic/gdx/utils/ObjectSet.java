package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Iterator;

public class ObjectSet
  implements Iterable
{
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  private int hashShift;
  private ObjectSet.ObjectSetIterator iterator1;
  private ObjectSet.ObjectSetIterator iterator2;
  Object[] keyTable;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;

  public ObjectSet()
  {
    this(32, 0.8F);
  }

  public ObjectSet(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public ObjectSet(int paramInt, float paramFloat)
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
  }

  public ObjectSet(ObjectSet paramObjectSet)
  {
    this(paramObjectSet.capacity, paramObjectSet.loadFactor);
    this.stashSize = paramObjectSet.stashSize;
    System.arraycopy(paramObjectSet.keyTable, 0, this.keyTable, 0, paramObjectSet.keyTable.length);
    this.size = paramObjectSet.size;
  }

  private void addResize(Object paramObject)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    Object localObject1 = this.keyTable[j];
    if (localObject1 == null)
    {
      this.keyTable[j] = paramObject;
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
      int n = this.size;
      this.size = (n + 1);
      if (n < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramObject, j, localObject1, k, localObject2, m, localObject3);
  }

  private void addStash(Object paramObject)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      add(paramObject);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramObject;
    this.stashSize = (1 + this.stashSize);
    this.size = (1 + this.size);
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

  private void push(Object paramObject1, int paramInt1, Object paramObject2, int paramInt2, Object paramObject3, int paramInt3, Object paramObject4)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label199: 
    do
    {
      int m;
      switch (MathUtils.random(2))
      {
      default:
        arrayOfObject[paramInt3] = paramObject1;
        paramObject1 = paramObject4;
        m = paramObject1.hashCode();
        paramInt1 = m & i;
        paramObject2 = arrayOfObject[paramInt1];
        if (paramObject2 == null)
        {
          arrayOfObject[paramInt1] = paramObject1;
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
          arrayOfObject[paramInt1] = paramObject1;
          paramObject1 = paramObject2;
          break;
          arrayOfObject[paramInt2] = paramObject1;
          paramObject1 = paramObject3;
          break;
          paramInt2 = hash2(m);
          paramObject3 = arrayOfObject[paramInt2];
          if (paramObject3 != null)
            break label199;
          arrayOfObject[paramInt2] = paramObject1;
          i1 = this.size;
          this.size = (i1 + 1);
        }
        while (i1 < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt3 = hash3(m);
        paramObject4 = arrayOfObject[paramInt3];
        if (paramObject4 != null)
          break label259;
        arrayOfObject[paramInt3] = paramObject1;
        n = this.size;
        this.size = (n + 1);
      }
      while (n < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    label259: addStash(paramObject1);
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
    this.keyTable = ((Object[])new Object[paramInt + this.stashCapacity]);
    int j = this.size;
    this.size = 0;
    this.stashSize = 0;
    if (j > 0)
      for (int k = 0; k < i; k++)
      {
        Object localObject = arrayOfObject[k];
        if (localObject == null)
          continue;
        addResize(localObject);
      }
  }

  public static ObjectSet with(Object[] paramArrayOfObject)
  {
    ObjectSet localObjectSet = new ObjectSet();
    localObjectSet.addAll(paramArrayOfObject);
    return localObjectSet;
  }

  public boolean add(Object paramObject)
  {
    if (paramObject == null)
      throw new IllegalArgumentException("key cannot be null.");
    Object[] arrayOfObject = this.keyTable;
    int i = paramObject.hashCode();
    int j = i & this.mask;
    Object localObject1 = arrayOfObject[j];
    if (paramObject.equals(localObject1));
    int k;
    Object localObject2;
    int m;
    Object localObject3;
    do
    {
      do
      {
        return false;
        k = hash2(i);
        localObject2 = arrayOfObject[k];
      }
      while (paramObject.equals(localObject2));
      m = hash3(i);
      localObject3 = arrayOfObject[m];
    }
    while (paramObject.equals(localObject3));
    int n = this.capacity;
    int i1 = n + this.stashSize;
    while (true)
    {
      if (n >= i1)
        break label132;
      if (paramObject.equals(arrayOfObject[n]))
        break;
      n++;
    }
    label132: if (localObject1 == null)
    {
      arrayOfObject[j] = paramObject;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    if (localObject2 == null)
    {
      arrayOfObject[k] = paramObject;
      int i3 = this.size;
      this.size = (i3 + 1);
      if (i3 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    if (localObject3 == null)
    {
      arrayOfObject[m] = paramObject;
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    push(paramObject, j, localObject1, k, localObject2, m, localObject3);
    return true;
  }

  public void addAll(Array paramArray)
  {
    addAll(paramArray, 0, paramArray.size);
  }

  public void addAll(Array paramArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArray.size);
    addAll((Object[])paramArray.items, paramInt1, paramInt2);
  }

  public void addAll(ObjectSet paramObjectSet)
  {
    ensureCapacity(paramObjectSet.size);
    ObjectSet.ObjectSetIterator localObjectSetIterator = paramObjectSet.iterator();
    while (localObjectSetIterator.hasNext())
      add(localObjectSetIterator.next());
  }

  public void addAll(Object[] paramArrayOfObject)
  {
    addAll(paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  public void addAll(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    ensureCapacity(paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      add(paramArrayOfObject[paramInt1]);
      paramInt1++;
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

  public boolean contains(Object paramObject)
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

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ObjectSet));
    ObjectSet localObjectSet;
    do
    {
      return false;
      localObjectSet = (ObjectSet)paramObject;
    }
    while (localObjectSet.size != this.size);
    int i = this.capacity + this.stashSize;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label74;
      if ((this.keyTable[j] != null) && (!localObjectSet.contains(this.keyTable[j])))
        break;
    }
    label74: return true;
  }

  public Object first()
  {
    Object[] arrayOfObject = this.keyTable;
    int i = 0;
    int j = this.capacity + this.stashSize;
    while (i < j)
    {
      if (arrayOfObject[i] != null)
        return arrayOfObject[i];
      i++;
    }
    throw new IllegalStateException("ObjectSet is empty.");
  }

  public int hashCode()
  {
    int i = 0;
    int j = this.capacity + this.stashSize;
    for (int k = 0; k < j; k++)
    {
      if (this.keyTable[k] == null)
        continue;
      i += this.keyTable[k].hashCode();
    }
    return i;
  }

  public ObjectSet.ObjectSetIterator iterator()
  {
    if (this.iterator1 == null)
    {
      this.iterator1 = new ObjectSet.ObjectSetIterator(this);
      this.iterator2 = new ObjectSet.ObjectSetIterator(this);
    }
    if (!this.iterator1.valid)
    {
      this.iterator1.reset();
      this.iterator1.valid = true;
      this.iterator2.valid = false;
      return this.iterator1;
    }
    this.iterator2.reset();
    this.iterator2.valid = true;
    this.iterator1.valid = false;
    return this.iterator2;
  }

  public boolean remove(Object paramObject)
  {
    int i = paramObject.hashCode();
    int j = i & this.mask;
    if (paramObject.equals(this.keyTable[j]))
    {
      this.keyTable[j] = null;
      this.size = (-1 + this.size);
      return true;
    }
    int k = hash2(i);
    if (paramObject.equals(this.keyTable[k]))
    {
      this.keyTable[k] = null;
      this.size = (-1 + this.size);
      return true;
    }
    int m = hash3(i);
    if (paramObject.equals(this.keyTable[m]))
    {
      this.keyTable[m] = null;
      this.size = (-1 + this.size);
      return true;
    }
    return removeStash(paramObject);
  }

  boolean removeStash(Object paramObject)
  {
    Object[] arrayOfObject = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i]))
      {
        removeStashIndex(i);
        this.size = (-1 + this.size);
        return true;
      }
      i++;
    }
    return false;
  }

  void removeStashIndex(int paramInt)
  {
    this.stashSize = (-1 + this.stashSize);
    int i = this.capacity + this.stashSize;
    if (paramInt < i)
      this.keyTable[paramInt] = this.keyTable[i];
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
    return "{" + toString(", ") + '}';
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    StringBuilder localStringBuilder = new StringBuilder(32);
    Object[] arrayOfObject = this.keyTable;
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
      }
      while (true)
      {
        int k = j - 1;
        if (j > 0)
        {
          Object localObject1 = arrayOfObject[k];
          if (localObject1 != null)
          {
            localStringBuilder.append(paramString);
            localStringBuilder.append(localObject1);
            j = k;
            continue;
          }
        }
        else
        {
          return localStringBuilder.toString();
        }
        j = k;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectSet
 * JD-Core Version:    0.6.0
 */