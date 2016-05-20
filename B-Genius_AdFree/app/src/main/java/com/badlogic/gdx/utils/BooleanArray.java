package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;

public class BooleanArray
{
  public boolean[] items;
  public boolean ordered;
  public int size;

  public BooleanArray()
  {
    this(true, 16);
  }

  public BooleanArray(int paramInt)
  {
    this(true, paramInt);
  }

  public BooleanArray(BooleanArray paramBooleanArray)
  {
    this.ordered = paramBooleanArray.ordered;
    this.size = paramBooleanArray.size;
    this.items = new boolean[this.size];
    System.arraycopy(paramBooleanArray.items, 0, this.items, 0, this.size);
  }

  public BooleanArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new boolean[paramInt];
  }

  public BooleanArray(boolean paramBoolean, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfBoolean, paramInt1, this.items, 0, paramInt2);
  }

  public BooleanArray(boolean[] paramArrayOfBoolean)
  {
    this(true, paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
  }

  public static BooleanArray with(boolean[] paramArrayOfBoolean)
  {
    return new BooleanArray(paramArrayOfBoolean);
  }

  public void add(boolean paramBoolean)
  {
    boolean[] arrayOfBoolean = this.items;
    if (this.size == arrayOfBoolean.length)
      arrayOfBoolean = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfBoolean[i] = paramBoolean;
  }

  public void addAll(BooleanArray paramBooleanArray)
  {
    addAll(paramBooleanArray, 0, paramBooleanArray.size);
  }

  public void addAll(BooleanArray paramBooleanArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramBooleanArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramBooleanArray.size);
    addAll(paramBooleanArray.items, paramInt1, paramInt2);
  }

  public void addAll(boolean[] paramArrayOfBoolean)
  {
    addAll(paramArrayOfBoolean, 0, paramArrayOfBoolean.length);
  }

  public void addAll(boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    boolean[] arrayOfBoolean = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfBoolean.length)
      arrayOfBoolean = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfBoolean, paramInt1, arrayOfBoolean, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean[] ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i > this.items.length)
      resize(Math.max(8, i));
    return this.items;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!this.ordered)
        return false;
      if (!(paramObject instanceof BooleanArray))
        return false;
      BooleanArray localBooleanArray = (BooleanArray)paramObject;
      if (!localBooleanArray.ordered)
        return false;
      int i = this.size;
      if (i != localBooleanArray.size)
        return false;
      boolean[] arrayOfBoolean1 = this.items;
      boolean[] arrayOfBoolean2 = localBooleanArray.items;
      for (int j = 0; j < i; j++)
        if (arrayOfBoolean1[j] != arrayOfBoolean2[j])
          return false;
    }
  }

  public boolean first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public boolean get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    return this.items[paramInt];
  }

  public int hashCode()
  {
    if (!this.ordered)
    {
      j = super.hashCode();
      return j;
    }
    boolean[] arrayOfBoolean = this.items;
    int i = this.size;
    int j = 1;
    int k = 0;
    label29: int m;
    if (k < i)
    {
      m = j * 31;
      if (arrayOfBoolean[k] == 0)
        break label69;
    }
    label69: for (int n = 1231; ; n = 1237)
    {
      int i1 = m + n;
      k++;
      j = i1;
      break label29;
      break;
    }
  }

  public void insert(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    boolean[] arrayOfBoolean = this.items;
    if (this.size == arrayOfBoolean.length)
      arrayOfBoolean = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfBoolean, paramInt, arrayOfBoolean, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfBoolean[paramInt] = paramBoolean;
      return;
      arrayOfBoolean[this.size] = arrayOfBoolean[paramInt];
    }
  }

  public boolean peek()
  {
    return this.items[(-1 + this.size)];
  }

  public boolean pop()
  {
    boolean[] arrayOfBoolean = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfBoolean[i];
  }

  public boolean random()
  {
    if (this.size == 0)
      return false;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(BooleanArray paramBooleanArray)
  {
    int i = this.size;
    boolean[] arrayOfBoolean = this.items;
    int j = paramBooleanArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      int n = paramBooleanArray.get(k);
      for (int i1 = 0; ; i1++)
      {
        if (i1 < m)
        {
          if (n != arrayOfBoolean[i1])
            continue;
          removeIndex(i1);
          m--;
        }
        k++;
        break;
      }
    }
    return m != i;
  }

  public boolean removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    boolean[] arrayOfBoolean = this.items;
    int i = arrayOfBoolean[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfBoolean, paramInt + 1, arrayOfBoolean, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfBoolean[paramInt] = arrayOfBoolean[this.size];
    return i;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    boolean[] arrayOfBoolean = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfBoolean, paramInt1 + i, arrayOfBoolean, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfBoolean[(paramInt1 + k)] = arrayOfBoolean[(j - k)];
    }
  }

  protected boolean[] resize(int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    System.arraycopy(this.items, 0, arrayOfBoolean, 0, Math.min(this.size, paramInt));
    this.items = arrayOfBoolean;
    return arrayOfBoolean;
  }

  public void reverse()
  {
    boolean[] arrayOfBoolean = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = arrayOfBoolean[i];
      arrayOfBoolean[i] = arrayOfBoolean[m];
      arrayOfBoolean[m] = n;
      i++;
    }
  }

  public void set(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramBoolean;
  }

  public boolean[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    boolean[] arrayOfBoolean = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      int k = arrayOfBoolean[i];
      arrayOfBoolean[i] = arrayOfBoolean[j];
      arrayOfBoolean[j] = k;
    }
  }

  public void swap(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size);
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
    boolean[] arrayOfBoolean = this.items;
    int i = arrayOfBoolean[paramInt1];
    arrayOfBoolean[paramInt1] = arrayOfBoolean[paramInt2];
    arrayOfBoolean[paramInt2] = i;
  }

  public boolean[] toArray()
  {
    boolean[] arrayOfBoolean = new boolean[this.size];
    System.arraycopy(this.items, 0, arrayOfBoolean, 0, this.size);
    return arrayOfBoolean;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    boolean[] arrayOfBoolean = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfBoolean[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfBoolean[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    boolean[] arrayOfBoolean = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfBoolean[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfBoolean[i]);
    }
    return localStringBuilder.toString();
  }

  public void truncate(int paramInt)
  {
    if (this.size > paramInt)
      this.size = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.BooleanArray
 * JD-Core Version:    0.6.0
 */