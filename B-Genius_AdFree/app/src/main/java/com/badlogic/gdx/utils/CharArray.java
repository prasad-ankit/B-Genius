package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class CharArray
{
  public char[] items;
  public boolean ordered;
  public int size;

  public CharArray()
  {
    this(true, 16);
  }

  public CharArray(int paramInt)
  {
    this(true, paramInt);
  }

  public CharArray(CharArray paramCharArray)
  {
    this.ordered = paramCharArray.ordered;
    this.size = paramCharArray.size;
    this.items = new char[this.size];
    System.arraycopy(paramCharArray.items, 0, this.items, 0, this.size);
  }

  public CharArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new char[paramInt];
  }

  public CharArray(boolean paramBoolean, char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfChar, paramInt1, this.items, 0, paramInt2);
  }

  public CharArray(char[] paramArrayOfChar)
  {
    this(true, paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public static CharArray with(char[] paramArrayOfChar)
  {
    return new CharArray(paramArrayOfChar);
  }

  public void add(char paramChar)
  {
    char[] arrayOfChar = this.items;
    if (this.size == arrayOfChar.length)
      arrayOfChar = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfChar[i] = paramChar;
  }

  public void addAll(CharArray paramCharArray)
  {
    addAll(paramCharArray, 0, paramCharArray.size);
  }

  public void addAll(CharArray paramCharArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramCharArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramCharArray.size);
    addAll(paramCharArray.items, paramInt1, paramInt2);
  }

  public void addAll(char[] paramArrayOfChar)
  {
    addAll(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public void addAll(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfChar.length)
      arrayOfChar = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(char paramChar)
  {
    int i = -1 + this.size;
    char[] arrayOfChar = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfChar[i] == paramChar)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public char[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof CharArray))
        return false;
      CharArray localCharArray = (CharArray)paramObject;
      if (!localCharArray.ordered)
        return false;
      int i = this.size;
      if (i != localCharArray.size)
        return false;
      char[] arrayOfChar1 = this.items;
      char[] arrayOfChar2 = localCharArray.items;
      for (int j = 0; j < i; j++)
        if (arrayOfChar1[j] != arrayOfChar2[j])
          return false;
    }
  }

  public char first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public char get(int paramInt)
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
      char[] arrayOfChar = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + arrayOfChar[k];
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt, char paramChar)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    char[] arrayOfChar = this.items;
    arrayOfChar[paramInt] = (char)(paramChar + arrayOfChar[paramInt]);
  }

  public int indexOf(char paramChar)
  {
    char[] arrayOfChar = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfChar[i] == paramChar)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt, char paramChar)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    char[] arrayOfChar = this.items;
    if (this.size == arrayOfChar.length)
      arrayOfChar = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfChar, paramInt, arrayOfChar, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfChar[paramInt] = paramChar;
      return;
      arrayOfChar[this.size] = arrayOfChar[paramInt];
    }
  }

  public int lastIndexOf(char paramChar)
  {
    char[] arrayOfChar = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfChar[i] == paramChar)
        return i;
    return -1;
  }

  public void mul(int paramInt, char paramChar)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    char[] arrayOfChar = this.items;
    arrayOfChar[paramInt] = (char)(paramChar * arrayOfChar[paramInt]);
  }

  public char peek()
  {
    return this.items[(-1 + this.size)];
  }

  public char pop()
  {
    char[] arrayOfChar = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfChar[i];
  }

  public char random()
  {
    if (this.size == 0)
      return '\000';
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(CharArray paramCharArray)
  {
    int i = this.size;
    char[] arrayOfChar = this.items;
    int j = paramCharArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      int n = paramCharArray.get(k);
      for (int i1 = 0; ; i1++)
      {
        if (i1 < m)
        {
          if (n != arrayOfChar[i1])
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

  public char removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    char[] arrayOfChar = this.items;
    int i = arrayOfChar[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfChar, paramInt + 1, arrayOfChar, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfChar[paramInt] = arrayOfChar[this.size];
    return i;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    char[] arrayOfChar = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfChar, paramInt1 + i, arrayOfChar, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfChar[(paramInt1 + k)] = arrayOfChar[(j - k)];
    }
  }

  public boolean removeValue(char paramChar)
  {
    char[] arrayOfChar = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfChar[j] != paramChar)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected char[] resize(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    System.arraycopy(this.items, 0, arrayOfChar, 0, Math.min(this.size, paramInt));
    this.items = arrayOfChar;
    return arrayOfChar;
  }

  public void reverse()
  {
    char[] arrayOfChar = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = arrayOfChar[i];
      arrayOfChar[i] = arrayOfChar[m];
      arrayOfChar[m] = n;
      i++;
    }
  }

  public void set(int paramInt, char paramChar)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramChar;
  }

  public char[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    char[] arrayOfChar = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      int k = arrayOfChar[i];
      arrayOfChar[i] = arrayOfChar[j];
      arrayOfChar[j] = k;
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
    char[] arrayOfChar = this.items;
    int i = arrayOfChar[paramInt1];
    arrayOfChar[paramInt1] = arrayOfChar[paramInt2];
    arrayOfChar[paramInt2] = i;
  }

  public char[] toArray()
  {
    char[] arrayOfChar = new char[this.size];
    System.arraycopy(this.items, 0, arrayOfChar, 0, this.size);
    return arrayOfChar;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    char[] arrayOfChar = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfChar[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfChar[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    char[] arrayOfChar = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfChar[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfChar[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.CharArray
 * JD-Core Version:    0.6.0
 */