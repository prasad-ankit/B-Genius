package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;

public class IntSet
{
  private static final int EMPTY = 0;
  private static final int PRIME1 = -1105259343;
  private static final int PRIME2 = -1262997959;
  private static final int PRIME3 = -825114047;
  int capacity;
  boolean hasZeroValue;
  private int hashShift;
  private IntSet.IntSetIterator iterator1;
  private IntSet.IntSetIterator iterator2;
  int[] keyTable;
  private float loadFactor;
  private int mask;
  private int pushIterations;
  public int size;
  private int stashCapacity;
  int stashSize;
  private int threshold;

  public IntSet()
  {
    this(32, 0.8F);
  }

  public IntSet(int paramInt)
  {
    this(paramInt, 0.8F);
  }

  public IntSet(int paramInt, float paramFloat)
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
  }

  public IntSet(IntSet paramIntSet)
  {
    this(paramIntSet.capacity, paramIntSet.loadFactor);
    this.stashSize = paramIntSet.stashSize;
    System.arraycopy(paramIntSet.keyTable, 0, this.keyTable, 0, paramIntSet.keyTable.length);
    this.size = paramIntSet.size;
    this.hasZeroValue = paramIntSet.hasZeroValue;
  }

  private void addResize(int paramInt)
  {
    if (paramInt == 0)
      this.hasZeroValue = true;
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
      int i2 = this.size;
      this.size = (i2 + 1);
      if (i2 < this.threshold)
        continue;
      resize(this.capacity << 1);
      return;
    }
    push(paramInt, i, j, k, m, n, i1);
  }

  private void addStash(int paramInt)
  {
    if (this.stashSize == this.stashCapacity)
    {
      resize(this.capacity << 1);
      add(paramInt);
      return;
    }
    int i = this.capacity + this.stashSize;
    this.keyTable[i] = paramInt;
    this.stashSize = (1 + this.stashSize);
    this.size = (1 + this.size);
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

  private void push(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.mask;
    int j = 0;
    int k = this.pushIterations;
    label191: label250: 
    do
    {
      switch (MathUtils.random(2))
      {
      default:
        arrayOfInt[paramInt6] = paramInt1;
        paramInt1 = paramInt7;
        paramInt2 = paramInt1 & i;
        paramInt3 = arrayOfInt[paramInt2];
        if (paramInt3 == 0)
        {
          arrayOfInt[paramInt2] = paramInt1;
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
          arrayOfInt[paramInt2] = paramInt1;
          paramInt1 = paramInt3;
          break;
          arrayOfInt[paramInt4] = paramInt1;
          paramInt1 = paramInt5;
          break;
          paramInt4 = hash2(paramInt1);
          paramInt5 = arrayOfInt[paramInt4];
          if (paramInt5 != 0)
            break label191;
          arrayOfInt[paramInt4] = paramInt1;
          n = this.size;
          this.size = (n + 1);
        }
        while (n < this.threshold);
        resize(this.capacity << 1);
        return;
        paramInt6 = hash3(paramInt1);
        paramInt7 = arrayOfInt[paramInt6];
        if (paramInt7 != 0)
          break label250;
        arrayOfInt[paramInt6] = paramInt1;
        m = this.size;
        this.size = (m + 1);
      }
      while (m < this.threshold);
      resize(this.capacity << 1);
      return;
      j++;
    }
    while (j != k);
    addStash(paramInt1);
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
    this.keyTable = new int[paramInt + this.stashCapacity];
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
          addResize(n);
        m++;
      }
    }
  }

  public static IntSet with(int[] paramArrayOfInt)
  {
    IntSet localIntSet = new IntSet();
    localIntSet.addAll(paramArrayOfInt);
    return localIntSet;
  }

  public boolean add(int paramInt)
  {
    if (paramInt == 0)
      if (!this.hasZeroValue);
    int[] arrayOfInt;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        do
        {
          return false;
          this.hasZeroValue = true;
          this.size = (1 + this.size);
          return true;
          arrayOfInt = this.keyTable;
          i = paramInt & this.mask;
          j = arrayOfInt[i];
        }
        while (j == paramInt);
        k = hash2(paramInt);
        m = arrayOfInt[k];
      }
      while (m == paramInt);
      n = hash3(paramInt);
      i1 = arrayOfInt[n];
    }
    while (i1 == paramInt);
    int i2 = this.capacity;
    int i3 = i2 + this.stashSize;
    while (true)
    {
      if (i2 >= i3)
        break label127;
      if (arrayOfInt[i2] == paramInt)
        break;
      i2++;
    }
    label127: if (j == 0)
    {
      arrayOfInt[i] = paramInt;
      int i6 = this.size;
      this.size = (i6 + 1);
      if (i6 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    if (m == 0)
    {
      arrayOfInt[k] = paramInt;
      int i5 = this.size;
      this.size = (i5 + 1);
      if (i5 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    if (i1 == 0)
    {
      arrayOfInt[n] = paramInt;
      int i4 = this.size;
      this.size = (i4 + 1);
      if (i4 >= this.threshold)
        resize(this.capacity << 1);
      return true;
    }
    push(paramInt, i, j, k, m, n, i1);
    return true;
  }

  public void addAll(IntArray paramIntArray)
  {
    addAll(paramIntArray, 0, paramIntArray.size);
  }

  public void addAll(IntArray paramIntArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramIntArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramIntArray.size);
    addAll(paramIntArray.items, paramInt1, paramInt2);
  }

  public void addAll(IntSet paramIntSet)
  {
    ensureCapacity(paramIntSet.size);
    IntSet.IntSetIterator localIntSetIterator = paramIntSet.iterator();
    while (localIntSetIterator.hasNext)
      add(localIntSetIterator.next());
  }

  public void addAll(int[] paramArrayOfInt)
  {
    addAll(paramArrayOfInt, 0, paramArrayOfInt.length);
  }

  public void addAll(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    ensureCapacity(paramInt2);
    int i = paramInt1 + paramInt2;
    while (paramInt1 < i)
    {
      add(paramArrayOfInt[paramInt1]);
      paramInt1++;
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

  public boolean contains(int paramInt)
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

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.threshold)
      resize(MathUtils.nextPowerOfTwo((int)(i / this.loadFactor)));
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof IntSet));
    IntSet localIntSet;
    do
    {
      return false;
      localIntSet = (IntSet)paramObject;
    }
    while ((localIntSet.size != this.size) || (localIntSet.hasZeroValue != this.hasZeroValue));
    int i = this.capacity + this.stashSize;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label85;
      if ((this.keyTable[j] != 0) && (!localIntSet.contains(this.keyTable[j])))
        break;
    }
    label85: return true;
  }

  public int first()
  {
    int i = 0;
    if (this.hasZeroValue)
      return 0;
    int[] arrayOfInt = this.keyTable;
    int j = this.capacity + this.stashSize;
    while (i < j)
    {
      if (arrayOfInt[i] != 0)
        return arrayOfInt[i];
      i++;
    }
    throw new IllegalStateException("IntSet is empty.");
  }

  public int hashCode()
  {
    int i = 0;
    int j = this.capacity + this.stashSize;
    for (int k = 0; k < j; k++)
    {
      if (this.keyTable[k] == 0)
        continue;
      i += this.keyTable[k];
    }
    return i;
  }

  public IntSet.IntSetIterator iterator()
  {
    if (this.iterator1 == null)
    {
      this.iterator1 = new IntSet.IntSetIterator(this);
      this.iterator2 = new IntSet.IntSetIterator(this);
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

  public boolean remove(int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.hasZeroValue)
        return false;
      this.hasZeroValue = false;
      this.size = (-1 + this.size);
      return true;
    }
    int i = paramInt & this.mask;
    if (this.keyTable[i] == paramInt)
    {
      this.keyTable[i] = 0;
      this.size = (-1 + this.size);
      return true;
    }
    int j = hash2(paramInt);
    if (this.keyTable[j] == paramInt)
    {
      this.keyTable[j] = 0;
      this.size = (-1 + this.size);
      return true;
    }
    int k = hash3(paramInt);
    if (this.keyTable[k] == paramInt)
    {
      this.keyTable[k] = 0;
      this.size = (-1 + this.size);
      return true;
    }
    return removeStash(paramInt);
  }

  boolean removeStash(int paramInt)
  {
    int[] arrayOfInt = this.keyTable;
    int i = this.capacity;
    int j = i + this.stashSize;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
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
    if (this.size == 0)
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    int[] arrayOfInt = this.keyTable;
    int i = arrayOfInt.length;
    if (this.hasZeroValue)
      localStringBuilder.append("0");
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
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IntSet
 * JD-Core Version:    0.6.0
 */