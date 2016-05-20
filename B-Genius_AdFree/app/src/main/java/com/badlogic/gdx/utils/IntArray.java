package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class IntArray
{
  public int[] items;
  public boolean ordered;
  public int size;

  public IntArray()
  {
    this(true, 16);
  }

  public IntArray(int paramInt)
  {
    this(true, paramInt);
  }

  public IntArray(IntArray paramIntArray)
  {
    this.ordered = paramIntArray.ordered;
    this.size = paramIntArray.size;
    this.items = new int[this.size];
    System.arraycopy(paramIntArray.items, 0, this.items, 0, this.size);
  }

  public IntArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new int[paramInt];
  }

  public IntArray(boolean paramBoolean, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfInt, paramInt1, this.items, 0, paramInt2);
  }

  public IntArray(int[] paramArrayOfInt)
  {
    this(true, paramArrayOfInt, 0, paramArrayOfInt.length);
  }

  public static IntArray with(int[] paramArrayOfInt)
  {
    return new IntArray(paramArrayOfInt);
  }

  public void add(int paramInt)
  {
    int[] arrayOfInt = this.items;
    if (this.size == arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfInt[i] = paramInt;
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

  public void addAll(int[] paramArrayOfInt)
  {
    addAll(paramArrayOfInt, 0, paramArrayOfInt.length);
  }

  public void addAll(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfInt, paramInt1, arrayOfInt, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(int paramInt)
  {
    int i = -1 + this.size;
    int[] arrayOfInt = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfInt[i] == paramInt)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public int[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof IntArray))
        return false;
      IntArray localIntArray = (IntArray)paramObject;
      if (!localIntArray.ordered)
        return false;
      int i = this.size;
      if (i != localIntArray.size)
        return false;
      for (int j = 0; j < i; j++)
        if (this.items[j] != localIntArray.items[j])
          return false;
    }
  }

  public int first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public int get(int paramInt)
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
      int[] arrayOfInt = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + arrayOfInt[k];
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size);
    int[] arrayOfInt = this.items;
    arrayOfInt[paramInt1] = (paramInt2 + arrayOfInt[paramInt1]);
  }

  public int indexOf(int paramInt)
  {
    int[] arrayOfInt = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt1 + " > " + this.size);
    int[] arrayOfInt = this.items;
    if (this.size == arrayOfInt.length)
      arrayOfInt = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfInt, paramInt1, arrayOfInt, paramInt1 + 1, this.size - paramInt1);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfInt[paramInt1] = paramInt2;
      return;
      arrayOfInt[this.size] = arrayOfInt[paramInt1];
    }
  }

  public int lastIndexOf(int paramInt)
  {
    int[] arrayOfInt = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfInt[i] == paramInt)
        return i;
    return -1;
  }

  public void mul(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size);
    int[] arrayOfInt = this.items;
    arrayOfInt[paramInt1] = (paramInt2 * arrayOfInt[paramInt1]);
  }

  public int peek()
  {
    return this.items[(-1 + this.size)];
  }

  public int pop()
  {
    int[] arrayOfInt = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfInt[i];
  }

  public int random()
  {
    if (this.size == 0)
      return 0;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(IntArray paramIntArray)
  {
    int i = this.size;
    int[] arrayOfInt = this.items;
    int j = paramIntArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      int n = paramIntArray.get(k);
      for (int i1 = 0; ; i1++)
      {
        if (i1 < m)
        {
          if (n != arrayOfInt[i1])
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

  public int removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    int[] arrayOfInt = this.items;
    int i = arrayOfInt[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfInt, paramInt + 1, arrayOfInt, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfInt[paramInt] = arrayOfInt[this.size];
    return i;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    int[] arrayOfInt = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfInt, paramInt1 + i, arrayOfInt, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfInt[(paramInt1 + k)] = arrayOfInt[(j - k)];
    }
  }

  public boolean removeValue(int paramInt)
  {
    int[] arrayOfInt = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfInt[j] != paramInt)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected int[] resize(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(this.items, 0, arrayOfInt, 0, Math.min(this.size, paramInt));
    this.items = arrayOfInt;
    return arrayOfInt;
  }

  public void reverse()
  {
    int[] arrayOfInt = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = arrayOfInt[i];
      arrayOfInt[i] = arrayOfInt[m];
      arrayOfInt[m] = n;
      i++;
    }
  }

  public void set(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt1 + " >= " + this.size);
    this.items[paramInt1] = paramInt2;
  }

  public int[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    int[] arrayOfInt = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      int k = arrayOfInt[i];
      arrayOfInt[i] = arrayOfInt[j];
      arrayOfInt[j] = k;
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
    int[] arrayOfInt = this.items;
    int i = arrayOfInt[paramInt1];
    arrayOfInt[paramInt1] = arrayOfInt[paramInt2];
    arrayOfInt[paramInt2] = i;
  }

  public int[] toArray()
  {
    int[] arrayOfInt = new int[this.size];
    System.arraycopy(this.items, 0, arrayOfInt, 0, this.size);
    return arrayOfInt;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    int[] arrayOfInt = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfInt[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfInt[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    int[] arrayOfInt = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfInt[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfInt[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.IntArray
 * JD-Core Version:    0.6.0
 */