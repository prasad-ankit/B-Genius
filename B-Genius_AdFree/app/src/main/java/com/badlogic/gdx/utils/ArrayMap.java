package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import java.util.Iterator;

public class ArrayMap
  implements Iterable
{
  private ArrayMap.Entries entries1;
  private ArrayMap.Entries entries2;
  public Object[] keys;
  private ArrayMap.Keys keysIter1;
  private ArrayMap.Keys keysIter2;
  public boolean ordered;
  public int size;
  public Object[] values;
  private ArrayMap.Values valuesIter1;
  private ArrayMap.Values valuesIter2;

  public ArrayMap()
  {
    this(true, 16);
  }

  public ArrayMap(int paramInt)
  {
    this(true, paramInt);
  }

  public ArrayMap(ArrayMap paramArrayMap)
  {
    this(paramArrayMap.ordered, paramArrayMap.size, paramArrayMap.keys.getClass().getComponentType(), paramArrayMap.values.getClass().getComponentType());
    this.size = paramArrayMap.size;
    System.arraycopy(paramArrayMap.keys, 0, this.keys, 0, this.size);
    System.arraycopy(paramArrayMap.values, 0, this.values, 0, this.size);
  }

  public ArrayMap(Class paramClass1, Class paramClass2)
  {
    this(false, 16, paramClass1, paramClass2);
  }

  public ArrayMap(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.keys = ((Object[])new Object[paramInt]);
    this.values = ((Object[])new Object[paramInt]);
  }

  public ArrayMap(boolean paramBoolean, int paramInt, Class paramClass1, Class paramClass2)
  {
    this.ordered = paramBoolean;
    this.keys = ((Object[])ArrayReflection.newInstance(paramClass1, paramInt));
    this.values = ((Object[])ArrayReflection.newInstance(paramClass2, paramInt));
  }

  public void clear()
  {
    Object[] arrayOfObject1 = this.keys;
    Object[] arrayOfObject2 = this.values;
    int i = this.size;
    for (int j = 0; j < i; j++)
    {
      arrayOfObject1[j] = null;
      arrayOfObject2[j] = null;
    }
    this.size = 0;
  }

  public void clear(int paramInt)
  {
    if (this.keys.length <= paramInt)
    {
      clear();
      return;
    }
    this.size = 0;
    resize(paramInt);
  }

  public boolean containsKey(Object paramObject)
  {
    Object[] arrayOfObject = this.keys;
    int i = -1 + this.size;
    if (paramObject == null);
    while (true)
    {
      int k;
      if (i >= 0)
      {
        k = i - 1;
        if (arrayOfObject[i] == paramObject)
        {
          return true;
          while (true)
          {
            i = j;
            if (i < 0)
              break;
            int j = i - 1;
            if (paramObject.equals(arrayOfObject[i]))
              return true;
          }
        }
      }
      else
      {
        return false;
      }
      i = k;
    }
  }

  public boolean containsValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.values;
    int i = -1 + this.size;
    if ((paramBoolean) || (paramObject == null));
    while (true)
    {
      int j;
      if (i >= 0)
      {
        j = i - 1;
        if (arrayOfObject[i] == paramObject)
        {
          return true;
          while (true)
          {
            i = k;
            if (i < 0)
              break;
            int k = i - 1;
            if (paramObject.equals(arrayOfObject[i]))
              return true;
          }
        }
      }
      else
      {
        return false;
      }
      i = j;
    }
  }

  public void ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i >= this.keys.length)
      resize(Math.max(8, i));
  }

  public ArrayMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new ArrayMap.Entries(this);
      this.entries2 = new ArrayMap.Entries(this);
    }
    if (!this.entries1.valid)
    {
      this.entries1.index = 0;
      this.entries1.valid = true;
      this.entries2.valid = false;
      return this.entries1;
    }
    this.entries2.index = 0;
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
      if (!(paramObject instanceof ArrayMap))
        return false;
      ArrayMap localArrayMap = (ArrayMap)paramObject;
      if (localArrayMap.size != this.size)
        return false;
      Object[] arrayOfObject1 = this.keys;
      Object[] arrayOfObject2 = this.values;
      int i = this.size;
      for (int j = 0; j < i; j++)
      {
        Object localObject1 = arrayOfObject1[j];
        Object localObject2 = arrayOfObject2[j];
        if (localObject2 == null)
        {
          if ((!localArrayMap.containsKey(localObject1)) || (localArrayMap.get(localObject1) != null))
            return false;
        }
        else if (!localObject2.equals(localArrayMap.get(localObject1)))
          return false;
      }
    }
  }

  public Object firstKey()
  {
    if (this.size == 0)
      throw new IllegalStateException("Map is empty.");
    return this.keys[0];
  }

  public Object firstValue()
  {
    if (this.size == 0)
      throw new IllegalStateException("Map is empty.");
    return this.values[0];
  }

  public Object get(Object paramObject)
  {
    Object[] arrayOfObject = this.keys;
    int i = -1 + this.size;
    if (paramObject == null)
      while (i >= 0)
      {
        if (arrayOfObject[i] == paramObject)
          return this.values[i];
        i--;
      }
    while (true)
    {
      i--;
      if (i < 0)
        break;
      if (paramObject.equals(arrayOfObject[i]))
        return this.values[i];
    }
    return null;
  }

  public Object getKey(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.values;
    int i = -1 + this.size;
    if ((paramBoolean) || (paramObject == null));
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject)
        return this.keys[i];
      i--;
      continue;
      while (true)
      {
        i--;
        if (i < 0)
          break;
        if (paramObject.equals(arrayOfObject[i]))
          return this.keys[i];
      }
    }
    return null;
  }

  public Object getKeyAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    return this.keys[paramInt];
  }

  public Object getValueAt(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    return this.values[paramInt];
  }

  public int hashCode()
  {
    int i = 0;
    Object[] arrayOfObject1 = this.keys;
    Object[] arrayOfObject2 = this.values;
    int j = this.size;
    for (int k = 0; k < j; k++)
    {
      Object localObject1 = arrayOfObject1[k];
      Object localObject2 = arrayOfObject2[k];
      if (localObject1 != null)
        i += 31 * localObject1.hashCode();
      if (localObject2 == null)
        continue;
      i += localObject2.hashCode();
    }
    return i;
  }

  public int indexOfKey(Object paramObject)
  {
    int i = 0;
    Object[] arrayOfObject = this.keys;
    if (paramObject == null)
    {
      int k = this.size;
      while (i < k)
      {
        if (arrayOfObject[i] == paramObject)
          return i;
        i++;
      }
    }
    int j = this.size;
    while (true)
    {
      if (i >= j)
        break label66;
      if (paramObject.equals(arrayOfObject[i]))
        break;
      i++;
    }
    label66: return -1;
  }

  public int indexOfValue(Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    Object[] arrayOfObject = this.values;
    int j;
    if ((paramBoolean) || (paramObject == null))
      j = this.size;
    while (i < j)
    {
      if (arrayOfObject[i] == paramObject)
        return i;
      i++;
      continue;
      int k = this.size;
      while (true)
      {
        if (i >= k)
          break label73;
        if (paramObject.equals(arrayOfObject[i]))
          break;
        i++;
      }
    }
    label73: return -1;
  }

  public void insert(int paramInt, Object paramObject1, Object paramObject2)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    if (this.size == this.keys.length)
      resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
    {
      System.arraycopy(this.keys, paramInt, this.keys, paramInt + 1, this.size - paramInt);
      System.arraycopy(this.values, paramInt, this.values, paramInt + 1, this.size - paramInt);
    }
    while (true)
    {
      this.size = (1 + this.size);
      this.keys[paramInt] = paramObject1;
      this.values[paramInt] = paramObject2;
      return;
      this.keys[this.size] = this.keys[paramInt];
      this.values[this.size] = this.values[paramInt];
    }
  }

  public Iterator iterator()
  {
    return entries();
  }

  public ArrayMap.Keys keys()
  {
    if (this.keysIter1 == null)
    {
      this.keysIter1 = new ArrayMap.Keys(this);
      this.keysIter2 = new ArrayMap.Keys(this);
    }
    if (!this.keysIter1.valid)
    {
      this.keysIter1.index = 0;
      this.keysIter1.valid = true;
      this.keysIter2.valid = false;
      return this.keysIter1;
    }
    this.keysIter2.index = 0;
    this.keysIter2.valid = true;
    this.keysIter1.valid = false;
    return this.keysIter2;
  }

  public Object peekKey()
  {
    return this.keys[(-1 + this.size)];
  }

  public Object peekValue()
  {
    return this.values[(-1 + this.size)];
  }

  public int put(Object paramObject1, Object paramObject2)
  {
    int i = indexOfKey(paramObject1);
    if (i == -1)
    {
      if (this.size == this.keys.length)
        resize(Math.max(8, (int)(1.75F * this.size)));
      i = this.size;
      this.size = (i + 1);
    }
    this.keys[i] = paramObject1;
    this.values[i] = paramObject2;
    return i;
  }

  public int put(Object paramObject1, Object paramObject2, int paramInt)
  {
    int i = indexOfKey(paramObject1);
    if (i != -1)
      removeIndex(i);
    while (true)
    {
      System.arraycopy(this.keys, paramInt, this.keys, paramInt + 1, this.size - paramInt);
      System.arraycopy(this.values, paramInt, this.values, paramInt + 1, this.size - paramInt);
      this.keys[paramInt] = paramObject1;
      this.values[paramInt] = paramObject2;
      this.size = (1 + this.size);
      return paramInt;
      if (this.size != this.keys.length)
        continue;
      resize(Math.max(8, (int)(1.75F * this.size)));
    }
  }

  public void putAll(ArrayMap paramArrayMap)
  {
    putAll(paramArrayMap, 0, paramArrayMap.size);
  }

  public void putAll(ArrayMap paramArrayMap, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramArrayMap.size)
      throw new IllegalArgumentException("offset + length must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArrayMap.size);
    int i = paramInt2 + this.size - paramInt1;
    if (i >= this.keys.length)
      resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayMap.keys, paramInt1, this.keys, this.size, paramInt2);
    System.arraycopy(paramArrayMap.values, paramInt1, this.values, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    Object[] arrayOfObject = this.keys;
    this.size = (-1 + this.size);
    if (this.ordered)
    {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, this.size - paramInt);
      System.arraycopy(this.values, paramInt + 1, this.values, paramInt, this.size - paramInt);
    }
    while (true)
    {
      arrayOfObject[this.size] = null;
      this.values[this.size] = null;
      return;
      arrayOfObject[paramInt] = arrayOfObject[this.size];
      this.values[paramInt] = this.values[this.size];
    }
  }

  public Object removeKey(Object paramObject)
  {
    Object[] arrayOfObject = this.keys;
    if (paramObject == null)
    {
      int k = this.size;
      for (int m = 0; m < k; m++)
      {
        if (arrayOfObject[m] != paramObject)
          continue;
        Object localObject2 = this.values[m];
        removeIndex(m);
        return localObject2;
      }
    }
    int i = this.size;
    for (int j = 0; j < i; j++)
    {
      if (!paramObject.equals(arrayOfObject[j]))
        continue;
      Object localObject1 = this.values[j];
      removeIndex(j);
      return localObject1;
    }
    return null;
  }

  public boolean removeValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.values;
    int i;
    int j;
    if ((paramBoolean) || (paramObject == null))
    {
      i = this.size;
      j = 0;
    }
    while (j < i)
    {
      if (arrayOfObject[j] == paramObject)
      {
        removeIndex(j);
        return true;
      }
      j++;
      continue;
      int k = this.size;
      for (int m = 0; m < k; m++)
      {
        if (!paramObject.equals(arrayOfObject[m]))
          continue;
        removeIndex(m);
        return true;
      }
    }
    return false;
  }

  protected void resize(int paramInt)
  {
    Object[] arrayOfObject1 = (Object[])ArrayReflection.newInstance(this.keys.getClass().getComponentType(), paramInt);
    System.arraycopy(this.keys, 0, arrayOfObject1, 0, Math.min(this.size, arrayOfObject1.length));
    this.keys = arrayOfObject1;
    Object[] arrayOfObject2 = (Object[])ArrayReflection.newInstance(this.values.getClass().getComponentType(), paramInt);
    System.arraycopy(this.values, 0, arrayOfObject2, 0, Math.min(this.size, arrayOfObject2.length));
    this.values = arrayOfObject2;
  }

  public void reverse()
  {
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      Object localObject1 = this.keys[i];
      this.keys[i] = this.keys[m];
      this.keys[m] = localObject1;
      Object localObject2 = this.values[i];
      this.values[i] = this.values[m];
      this.values[m] = localObject2;
      i++;
    }
  }

  public void setKey(int paramInt, Object paramObject)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    this.keys[paramInt] = paramObject;
  }

  public void setValue(int paramInt, Object paramObject)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(String.valueOf(paramInt));
    this.values[paramInt] = paramObject;
  }

  public void shrink()
  {
    if (this.keys.length == this.size)
      return;
    resize(this.size);
  }

  public void shuffle()
  {
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      Object localObject1 = this.keys[i];
      this.keys[i] = this.keys[j];
      this.keys[j] = localObject1;
      Object localObject2 = this.values[i];
      this.values[i] = this.values[j];
      this.values[j] = localObject2;
    }
  }

  public String toString()
  {
    if (this.size == 0)
      return "{}";
    Object[] arrayOfObject1 = this.keys;
    Object[] arrayOfObject2 = this.values;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('{');
    localStringBuilder.append(arrayOfObject1[0]);
    localStringBuilder.append('=');
    localStringBuilder.append(arrayOfObject2[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfObject1[i]);
      localStringBuilder.append('=');
      localStringBuilder.append(arrayOfObject2[i]);
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public void truncate(int paramInt)
  {
    if (this.size <= paramInt)
      return;
    for (int i = paramInt; i < this.size; i++)
    {
      this.keys[i] = null;
      this.values[i] = null;
    }
    this.size = paramInt;
  }

  public ArrayMap.Values values()
  {
    if (this.valuesIter1 == null)
    {
      this.valuesIter1 = new ArrayMap.Values(this);
      this.valuesIter2 = new ArrayMap.Values(this);
    }
    if (!this.valuesIter1.valid)
    {
      this.valuesIter1.index = 0;
      this.valuesIter1.valid = true;
      this.valuesIter2.valid = false;
      return this.valuesIter1;
    }
    this.valuesIter2.index = 0;
    this.valuesIter2.valid = true;
    this.valuesIter1.valid = false;
    return this.valuesIter2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ArrayMap
 * JD-Core Version:    0.6.0
 */