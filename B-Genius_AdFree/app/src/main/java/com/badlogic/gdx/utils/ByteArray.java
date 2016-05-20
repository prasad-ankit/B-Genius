package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class ByteArray
{
  public byte[] items;
  public boolean ordered;
  public int size;

  public ByteArray()
  {
    this(true, 16);
  }

  public ByteArray(int paramInt)
  {
    this(true, paramInt);
  }

  public ByteArray(ByteArray paramByteArray)
  {
    this.ordered = paramByteArray.ordered;
    this.size = paramByteArray.size;
    this.items = new byte[this.size];
    System.arraycopy(paramByteArray.items, 0, this.items, 0, this.size);
  }

  public ByteArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new byte[paramInt];
  }

  public ByteArray(boolean paramBoolean, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfByte, paramInt1, this.items, 0, paramInt2);
  }

  public ByteArray(byte[] paramArrayOfByte)
  {
    this(true, paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static ByteArray with(byte[] paramArrayOfByte)
  {
    return new ByteArray(paramArrayOfByte);
  }

  public void add(byte paramByte)
  {
    byte[] arrayOfByte = this.items;
    if (this.size == arrayOfByte.length)
      arrayOfByte = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void addAll(ByteArray paramByteArray)
  {
    addAll(paramByteArray, 0, paramByteArray.size);
  }

  public void addAll(ByteArray paramByteArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramByteArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramByteArray.size);
    addAll(paramByteArray.items, paramInt1, paramInt2);
  }

  public void addAll(byte[] paramArrayOfByte)
  {
    addAll(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void addAll(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfByte.length)
      arrayOfByte = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(byte paramByte)
  {
    int i = -1 + this.size;
    byte[] arrayOfByte = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfByte[i] == paramByte)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public byte[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof ByteArray))
        return false;
      ByteArray localByteArray = (ByteArray)paramObject;
      if (!localByteArray.ordered)
        return false;
      int i = this.size;
      if (i != localByteArray.size)
        return false;
      byte[] arrayOfByte1 = this.items;
      byte[] arrayOfByte2 = localByteArray.items;
      for (int j = 0; j < i; j++)
        if (arrayOfByte1[j] != arrayOfByte2[j])
          return false;
    }
  }

  public byte first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public byte get(int paramInt)
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
      byte[] arrayOfByte = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + arrayOfByte[k];
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt, byte paramByte)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    byte[] arrayOfByte = this.items;
    arrayOfByte[paramInt] = (byte)(paramByte + arrayOfByte[paramInt]);
  }

  public int indexOf(byte paramByte)
  {
    byte[] arrayOfByte = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfByte[i] == paramByte)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt, byte paramByte)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    byte[] arrayOfByte = this.items;
    if (this.size == arrayOfByte.length)
      arrayOfByte = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfByte, paramInt, arrayOfByte, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfByte[paramInt] = paramByte;
      return;
      arrayOfByte[this.size] = arrayOfByte[paramInt];
    }
  }

  public int lastIndexOf(byte paramByte)
  {
    byte[] arrayOfByte = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfByte[i] == paramByte)
        return i;
    return -1;
  }

  public void mul(int paramInt, byte paramByte)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    byte[] arrayOfByte = this.items;
    arrayOfByte[paramInt] = (byte)(paramByte * arrayOfByte[paramInt]);
  }

  public byte peek()
  {
    return this.items[(-1 + this.size)];
  }

  public byte pop()
  {
    byte[] arrayOfByte = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfByte[i];
  }

  public byte random()
  {
    if (this.size == 0)
      return 0;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(ByteArray paramByteArray)
  {
    int i = this.size;
    byte[] arrayOfByte = this.items;
    int j = paramByteArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      int n = paramByteArray.get(k);
      for (int i1 = 0; ; i1++)
      {
        if (i1 < m)
        {
          if (n != arrayOfByte[i1])
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
    byte[] arrayOfByte = this.items;
    int i = arrayOfByte[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfByte, paramInt + 1, arrayOfByte, paramInt, this.size - paramInt);
      return i;
    }
    arrayOfByte[paramInt] = arrayOfByte[this.size];
    return i;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    byte[] arrayOfByte = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfByte, paramInt1 + i, arrayOfByte, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfByte[(paramInt1 + k)] = arrayOfByte[(j - k)];
    }
  }

  public boolean removeValue(byte paramByte)
  {
    byte[] arrayOfByte = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfByte[j] != paramByte)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected byte[] resize(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(this.items, 0, arrayOfByte, 0, Math.min(this.size, paramInt));
    this.items = arrayOfByte;
    return arrayOfByte;
  }

  public void reverse()
  {
    byte[] arrayOfByte = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      int n = arrayOfByte[i];
      arrayOfByte[i] = arrayOfByte[m];
      arrayOfByte[m] = n;
      i++;
    }
  }

  public void set(int paramInt, byte paramByte)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramByte;
  }

  public byte[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    byte[] arrayOfByte = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      int k = arrayOfByte[i];
      arrayOfByte[i] = arrayOfByte[j];
      arrayOfByte[j] = k;
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
    byte[] arrayOfByte = this.items;
    int i = arrayOfByte[paramInt1];
    arrayOfByte[paramInt1] = arrayOfByte[paramInt2];
    arrayOfByte[paramInt2] = i;
  }

  public byte[] toArray()
  {
    byte[] arrayOfByte = new byte[this.size];
    System.arraycopy(this.items, 0, arrayOfByte, 0, this.size);
    return arrayOfByte;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    byte[] arrayOfByte = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfByte[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfByte[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    byte[] arrayOfByte = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfByte[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfByte[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.ByteArray
 * JD-Core Version:    0.6.0
 */