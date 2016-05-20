package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class ShortArray
{
  public short[] items;
  public boolean ordered;
  public int size;

  public ShortArray()
  {
    this(true, 16);
  }

  public ShortArray(int paramInt)
  {
    this(true, paramInt);
  }

  public ShortArray(ShortArray paramShortArray)
  {
    this.ordered = paramShortArray.ordered;
    this.size = paramShortArray.size;
    this.items = new short[this.size];
    System.arraycopy(paramShortArray.items, 0, this.items, 0, this.size);
  }

  public ShortArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new short[paramInt];
  }

  public ShortArray(boolean paramBoolean, short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfShort, paramInt1, this.items, 0, paramInt2);
  }

  public ShortArray(short[] paramArrayOfShort)
  {
    this(true, paramArrayOfShort, 0, paramArrayOfShort.length);
  }

  public static ShortArray with(short[] paramArrayOfShort)
  {
    return new ShortArray(paramArrayOfShort);
  }

  public void add(int paramInt)
  {
    short[] arrayOfShort = this.items;
    if (this.size == arrayOfShort.length)
      arrayOfShort = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfShort[i] = (short)paramInt;
  }

  public void add(short paramShort)
  {
    short[] arrayOfShort = this.items;
    if (this.size == arrayOfShort.length)
      arrayOfShort = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfShort[i] = paramShort;
  }

  public void addAll(ShortArray paramShortArray)
  {
    addAll(paramShortArray, 0, paramShortArray.size);
  }

  public void addAll(ShortArray paramShortArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramShortArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramShortArray.size);
    addAll(paramShortArray.items, paramInt1, paramInt2);
  }

  public void addAll(short[] paramArrayOfShort)
  {
    addAll(paramArrayOfShort, 0, paramArrayOfShort.length);
  }

  public void addAll(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    short[] arrayOfShort = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfShort.length)
      arrayOfShort = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfShort, paramInt1, arrayOfShort, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(short paramShort)
  {
    int i = -1 + this.size;
    short[] arrayOfShort = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfShort[i] == paramShort)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public short[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof ShortArray))
        return false;
      ShortArray localShortArray = (ShortArray)paramObject;
      if (!localShortArray.ordered)
        return false;
      int i = this.size;
      if (i != localShortArray.size)
        return false;
      for (int j = 0; j < i; j++)
        if (this.items[j] != localShortArray.items[j])
          return false;
    }
  }

  public short first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public short get(int paramInt)
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
      short[] arrayOfShort = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + arrayOfShort[k];
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt, short paramShort)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    short[] arrayOfShort = this.items;
    arrayOfShort[paramInt] = (short)(paramShort + arrayOfShort[paramInt]);
  }

  public int indexOf(short paramShort)
  {
    short[] arrayOfShort = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfShort[i] == paramShort)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt, short paramShort)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    short[] arrayOfShort = this.items;
    if (this.size == arrayOfShort.length)
      arrayOfShort = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfShort, paramInt, arrayOfShort, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfShort[paramInt] = paramShort;
      return;
      arrayOfShort[this.size] = arrayOfShort[paramInt];
    }
  }

  public int lastIndexOf(char paramChar)
  {
    short[] arrayOfShort = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfShort[i] == paramChar)
        return i;
    return -1;
  }

  public void mul(int paramInt, short paramShort)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    short[] arrayOfShort = this.items;
    arrayOfShort[paramInt] = (short)(paramShort * arrayOfShort[paramInt]);
  }

  public short peek()
  {
    return this.items[(-1 + this.size)];
  }

  public short pop()
  {
    short[] arrayOfShort = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfShort[i];
  }

  public short random()
  {
    if (this.size == 0)
      return 0;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(ShortArray paramShortArray)
  {
    int i = this.size;
    short[] arrayOfShort = this.items;
    int j = paramShortArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      int n = paramShortArray.get(k);
      for (int i1 = 0; ; i1++)
      {
        if (i1 < m)
        {
          if (n != arrayOfShort[i1])
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

  public short removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    short[] arrayOfShort = this.items;
    int i = arrayOfShort[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfShort, paramInt + 1, arrayOfShort, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfShort[paramInt] = arrayOfShort[this.size];
    return i;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    short[] arrayOfShort = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfShort, paramInt1 + i, arrayOfShort, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfShort[(paramInt1 + k)] = arrayOfShort[(j - k)];
    }
  }

  public boolean removeValue(short paramShort)
  {
    short[] arrayOfShort = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfShort[j] != paramShort)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected short[] resize(int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    System.arraycopy(this.items, 0, arrayOfShort, 0, Math.min(this.size, paramInt));
    this.items = arrayOfShort;
    return arrayOfShort;
  }

  public void reverse()
  {
    short[] arrayOfShort = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = arrayOfShort[i];
      arrayOfShort[i] = arrayOfShort[m];
      arrayOfShort[m] = n;
      i++;
    }
  }

  public void set(int paramInt, short paramShort)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramShort;
  }

  public short[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    short[] arrayOfShort = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      int k = arrayOfShort[i];
      arrayOfShort[i] = arrayOfShort[j];
      arrayOfShort[j] = k;
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
    short[] arrayOfShort = this.items;
    int i = arrayOfShort[paramInt1];
    arrayOfShort[paramInt1] = arrayOfShort[paramInt2];
    arrayOfShort[paramInt2] = i;
  }

  public short[] toArray()
  {
    short[] arrayOfShort = new short[this.size];
    System.arraycopy(this.items, 0, arrayOfShort, 0, this.size);
    return arrayOfShort;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    short[] arrayOfShort = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfShort[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfShort[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    short[] arrayOfShort = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfShort[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfShort[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.ShortArray
 * JD-Core Version:    0.6.0
 */