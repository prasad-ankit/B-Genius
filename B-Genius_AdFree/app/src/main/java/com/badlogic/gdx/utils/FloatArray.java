package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import java.util.Arrays;

public class FloatArray
{
  public float[] items;
  public boolean ordered;
  public int size;

  public FloatArray()
  {
    this(true, 16);
  }

  public FloatArray(int paramInt)
  {
    this(true, paramInt);
  }

  public FloatArray(FloatArray paramFloatArray)
  {
    this.ordered = paramFloatArray.ordered;
    this.size = paramFloatArray.size;
    this.items = new float[this.size];
    System.arraycopy(paramFloatArray.items, 0, this.items, 0, this.size);
  }

  public FloatArray(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = new float[paramInt];
  }

  public FloatArray(boolean paramBoolean, float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2);
    this.size = paramInt2;
    System.arraycopy(paramArrayOfFloat, paramInt1, this.items, 0, paramInt2);
  }

  public FloatArray(float[] paramArrayOfFloat)
  {
    this(true, paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public static FloatArray with(float[] paramArrayOfFloat)
  {
    return new FloatArray(paramArrayOfFloat);
  }

  public void add(float paramFloat)
  {
    float[] arrayOfFloat = this.items;
    if (this.size == arrayOfFloat.length)
      arrayOfFloat = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfFloat[i] = paramFloat;
  }

  public void addAll(FloatArray paramFloatArray)
  {
    addAll(paramFloatArray, 0, paramFloatArray.size);
  }

  public void addAll(FloatArray paramFloatArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramFloatArray.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramFloatArray.size);
    addAll(paramFloatArray.items, paramInt1, paramInt2);
  }

  public void addAll(float[] paramArrayOfFloat)
  {
    addAll(paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public void addAll(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float[] arrayOfFloat = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfFloat.length)
      arrayOfFloat = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfFloat, paramInt1, arrayOfFloat, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    this.size = 0;
  }

  public boolean contains(float paramFloat)
  {
    int i = -1 + this.size;
    float[] arrayOfFloat = this.items;
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfFloat[i] == paramFloat)
          return true;
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public float[] ensureCapacity(int paramInt)
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
      if (!(paramObject instanceof FloatArray))
        return false;
      FloatArray localFloatArray = (FloatArray)paramObject;
      if (!localFloatArray.ordered)
        return false;
      int i = this.size;
      if (i != localFloatArray.size)
        return false;
      float[] arrayOfFloat1 = this.items;
      float[] arrayOfFloat2 = localFloatArray.items;
      for (int j = 0; j < i; j++)
        if (arrayOfFloat1[j] != arrayOfFloat2[j])
          return false;
    }
  }

  public boolean equals(Object paramObject, float paramFloat)
  {
    if (paramObject == this);
    while (true)
    {
      return true;
      if (!(paramObject instanceof FloatArray))
        return false;
      FloatArray localFloatArray = (FloatArray)paramObject;
      int i = this.size;
      if (i != localFloatArray.size)
        return false;
      if (!this.ordered)
        return false;
      if (!localFloatArray.ordered)
        return false;
      float[] arrayOfFloat1 = this.items;
      float[] arrayOfFloat2 = localFloatArray.items;
      for (int j = 0; j < i; j++)
        if (Math.abs(arrayOfFloat1[j] - arrayOfFloat2[j]) > paramFloat)
          return false;
    }
  }

  public float first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public float get(int paramInt)
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
      float[] arrayOfFloat = this.items;
      int i = this.size;
      j = 1;
      int k = 0;
      while (k < i)
      {
        int m = j * 31 + Float.floatToIntBits(arrayOfFloat[k]);
        k++;
        j = m;
      }
    }
  }

  public void incr(int paramInt, float paramFloat)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    float[] arrayOfFloat = this.items;
    arrayOfFloat[paramInt] = (paramFloat + arrayOfFloat[paramInt]);
  }

  public int indexOf(float paramFloat)
  {
    float[] arrayOfFloat = this.items;
    int i = 0;
    int j = this.size;
    while (i < j)
    {
      if (arrayOfFloat[i] == paramFloat)
        return i;
      i++;
    }
    return -1;
  }

  public void insert(int paramInt, float paramFloat)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    float[] arrayOfFloat = this.items;
    if (this.size == arrayOfFloat.length)
      arrayOfFloat = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfFloat, paramInt, arrayOfFloat, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfFloat[paramInt] = paramFloat;
      return;
      arrayOfFloat[this.size] = arrayOfFloat[paramInt];
    }
  }

  public int lastIndexOf(char paramChar)
  {
    float[] arrayOfFloat = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
      if (arrayOfFloat[i] == paramChar)
        return i;
    return -1;
  }

  public void mul(int paramInt, float paramFloat)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    float[] arrayOfFloat = this.items;
    arrayOfFloat[paramInt] = (paramFloat * arrayOfFloat[paramInt]);
  }

  public float peek()
  {
    return this.items[(-1 + this.size)];
  }

  public float pop()
  {
    float[] arrayOfFloat = this.items;
    int i = -1 + this.size;
    this.size = i;
    return arrayOfFloat[i];
  }

  public float random()
  {
    if (this.size == 0)
      return 0.0F;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(FloatArray paramFloatArray)
  {
    int i = this.size;
    float[] arrayOfFloat = this.items;
    int j = paramFloatArray.size;
    int k = 0;
    int m = i;
    if (k < j)
    {
      float f = paramFloatArray.get(k);
      for (int n = 0; ; n++)
      {
        if (n < m)
        {
          if (f != arrayOfFloat[n])
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

  public float removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    float[] arrayOfFloat = this.items;
    float f = arrayOfFloat[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfFloat, paramInt + 1, arrayOfFloat, paramInt, this.size - paramInt);
      return f;
    }
    arrayOfFloat[paramInt] = arrayOfFloat[this.size];
    return f;
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    float[] arrayOfFloat = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfFloat, paramInt1 + i, arrayOfFloat, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfFloat[(paramInt1 + k)] = arrayOfFloat[(j - k)];
    }
  }

  public boolean removeValue(float paramFloat)
  {
    float[] arrayOfFloat = this.items;
    int i = this.size;
    for (int j = 0; ; j++)
    {
      int k = 0;
      if (j < i)
      {
        if (arrayOfFloat[j] != paramFloat)
          continue;
        removeIndex(j);
        k = 1;
      }
      return k;
    }
  }

  protected float[] resize(int paramInt)
  {
    float[] arrayOfFloat = new float[paramInt];
    System.arraycopy(this.items, 0, arrayOfFloat, 0, Math.min(this.size, paramInt));
    this.items = arrayOfFloat;
    return arrayOfFloat;
  }

  public void reverse()
  {
    float[] arrayOfFloat = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      float f = arrayOfFloat[i];
      arrayOfFloat[i] = arrayOfFloat[m];
      arrayOfFloat[m] = f;
      i++;
    }
  }

  public void set(int paramInt, float paramFloat)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramFloat;
  }

  public float[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    float[] arrayOfFloat = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      float f = arrayOfFloat[i];
      arrayOfFloat[i] = arrayOfFloat[j];
      arrayOfFloat[j] = f;
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
    float[] arrayOfFloat = this.items;
    float f = arrayOfFloat[paramInt1];
    arrayOfFloat[paramInt1] = arrayOfFloat[paramInt2];
    arrayOfFloat[paramInt2] = f;
  }

  public float[] toArray()
  {
    float[] arrayOfFloat = new float[this.size];
    System.arraycopy(this.items, 0, arrayOfFloat, 0, this.size);
    return arrayOfFloat;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    float[] arrayOfFloat = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfFloat[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfFloat[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    float[] arrayOfFloat = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfFloat[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfFloat[i]);
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
 * Qualified Name:     com.badlogic.gdx.utils.FloatArray
 * JD-Core Version:    0.6.0
 */