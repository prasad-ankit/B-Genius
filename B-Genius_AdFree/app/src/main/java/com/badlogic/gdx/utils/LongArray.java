package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class LongArray
{
  public long[] items;
  public boolean ordered;
  public int size;

  public LongArray()
  {
    this(true, 16);
  }

  public LongArray(int paramInt)
  {
    this(true, paramInt);
  }

  public LongArray(LongArray paramLongArray)
  {
    this.ordered = paramLongArray.ordered;
    this.size = paramLongArray.size;
    this.items = new long[this.size];
    System.arraycopy(paramLongArray.items, 0, this.items, 0, this.size);
  }

  public LongArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new long[paramInt];
  }

  public LongArray(boolean paramBoolean, long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfLong, paramInt1, this.items, 0, paramInt2);
  }

  public LongArray(long[] paramArrayOfLong)
  {
    this(true, paramArrayOfLong, 0, paramArrayOfLong.length);
  }

  public static LongArray with(long[] paramArrayOfLong)
  {
    return new LongArray(paramArrayOfLong);
  }

  public void add(long paramLong)
  {
    long[] arrayOfLong = this.items;
    if (this.size == arrayOfLong.length)
      arrayOfLong = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfLong[i] = paramLong;
  }

  public void addAll(LongArray paramLongArray)
  {
    addAll(paramLongArray, 0, paramLongArray.size);
  }

  public void addAll(LongArray paramLongArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramLongArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramLongArray.size);
    addAll(paramLongArray.items, paramInt1, paramInt2);
  }

  public void addAll(long[] paramArrayOfLong)
  {
    addAll(paramArrayOfLong, 0, paramArrayOfLong.length);
  }

  public void addAll(long[] paramArrayOfLong, int paramInt1, int paramInt2)
  {
    long[] arrayOfLong = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfLong.length)
      arrayOfLong = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfLong, paramInt1, arrayOfLong, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(long paramLong)
  {
    int i = -1 + this.size;
    long[] arrayOfLong = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfLong[i] == paramLong)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public long[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof LongArray))
        return false;
      LongArray localLongArray = (LongArray)paramObject;
      if (!localLongArray.ordered)
        return false;
      int i = this.size;
      if (i != localLongArray.size)
        return false;
      for (int j = 0; j < i; j++)
        if (this.items[j] != localLongArray.items[j])
          return false;
    }
  }

  public long first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public long get(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    return this.items[paramInt];
  }

  public int hashCode()
  {
    int j;
    if (!this.ordered)
      j = super.hashCode();
    while (true)
    {
      return j;
      long[] arrayOfLong = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + (int)(arrayOfLong[k] ^ arrayOfLong[k] >>> 32);
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt, long paramLong)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    long[] arrayOfLong = this.items;
    arrayOfLong[paramInt] = (paramLong + arrayOfLong[paramInt]);
  }

  public int indexOf(long paramLong)
  {
    long[] arrayOfLong = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfLong[i] == paramLong)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt, long paramLong)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    long[] arrayOfLong = this.items;
    if (this.size == arrayOfLong.length)
      arrayOfLong = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfLong, paramInt, arrayOfLong, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfLong[paramInt] = paramLong;
      return;
      arrayOfLong[this.size] = arrayOfLong[paramInt];
    }
  }

  public int lastIndexOf(char paramChar)
  {
    long[] arrayOfLong = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfLong[i] == paramChar)
        return i;
    return -1;
  }

  public void mul(int paramInt, long paramLong)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    long[] arrayOfLong = this.items;
    arrayOfLong[paramInt] = (paramLong * arrayOfLong[paramInt]);
  }

  public long peek()
  {
    return this.items[(-1 + this.size)];
  }

  public long pop()
  {
    long[] arrayOfLong = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfLong[i];
  }

  public long random()
  {
    if (this.size == 0)
      return 0L;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(LongArray paramLongArray)
  {
    int i = this.size;
    long[] arrayOfLong = this.items;
    int j = paramLongArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      long l = paramLongArray.get(k);
      for (int n = 0; ; n++)
      {
        if (n < m)
        {
          if (l != arrayOfLong[n])
            continue;
          removeIndex(n);
          m--;
        }
        k++;
        break;
      }
    }
    return m != i;
  }

  public long removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    long[] arrayOfLong = this.items;
    long l = arrayOfLong[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfLong, paramInt + 1, arrayOfLong, paramInt, this.size - paramInt);
      return l;
    }
    arrayOfLong[paramInt] = arrayOfLong[this.size];
    return l;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    long[] arrayOfLong = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfLong, paramInt1 + i, arrayOfLong, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfLong[(paramInt1 + k)] = arrayOfLong[(j - k)];
    }
  }

  public boolean removeValue(long paramLong)
  {
    long[] arrayOfLong = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfLong[j] != paramLong)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected long[] resize(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    System.arraycopy(this.items, 0, arrayOfLong, 0, Math.min(this.size, paramInt));
    this.items = arrayOfLong;
    return arrayOfLong;
  }

  public void reverse()
  {
    long[] arrayOfLong = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      long l = arrayOfLong[i];
      arrayOfLong[i] = arrayOfLong[m];
      arrayOfLong[m] = l;
      i++;
    }
  }

  public void set(int paramInt, long paramLong)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramLong;
  }

  public long[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    long[] arrayOfLong = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      long l = arrayOfLong[i];
      arrayOfLong[i] = arrayOfLong[j];
      arrayOfLong[j] = l;
    }
  }

  public void sort()
  {
    Arrays.sort(this.items, 0, this.size);
  }

  public void swap(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size);
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
    long[] arrayOfLong = this.items;
    long l = arrayOfLong[paramInt1];
    arrayOfLong[paramInt1] = arrayOfLong[paramInt2];
    arrayOfLong[paramInt2] = l;
  }

  public long[] toArray()
  {
    long[] arrayOfLong = new long[this.size];
    System.arraycopy(this.items, 0, arrayOfLong, 0, this.size);
    return arrayOfLong;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    long[] arrayOfLong = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfLong[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfLong[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    long[] arrayOfLong = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfLong[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfLong[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.LongArray
 * JD-Core Version:    0.6.0
 */