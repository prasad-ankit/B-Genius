package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.reflect.ArrayReflection;
import java.util.Comparator;
import java.util.Iterator;

public class Array
  implements Iterable
{
  public Object[] items;
  private Array.ArrayIterable iterable;
  public boolean ordered;
  private Predicate.PredicateIterable predicateIterable;
  public int size;

  public Array()
  {
    this(true, 16);
  }

  public Array(int paramInt)
  {
    this(true, paramInt);
  }

  public Array(Array paramArray)
  {
    this(paramArray.ordered, paramArray.size, paramArray.items.getClass().getComponentType());
    this.size = paramArray.size;
    System.arraycopy(paramArray.items, 0, this.items, 0, this.size);
  }

  public Array(Class paramClass)
  {
    this(true, 16, paramClass);
  }

  public Array(boolean paramBoolean, int paramInt)
  {
    this.ordered = paramBoolean;
    this.items = ((Object[])new Object[paramInt]);
  }

  public Array(boolean paramBoolean, int paramInt, Class paramClass)
  {
    this.ordered = paramBoolean;
    this.items = ((Object[])ArrayReflection.newInstance(paramClass, paramInt));
  }

  public Array(boolean paramBoolean, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    this(paramBoolean, paramInt2, paramArrayOfObject.getClass().getComponentType());
    this.size = paramInt2;
    System.arraycopy(paramArrayOfObject, paramInt1, this.items, 0, this.size);
  }

  public Array(Object[] paramArrayOfObject)
  {
    this(true, paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  public static Array of(Class paramClass)
  {
    return new Array(paramClass);
  }

  public static Array of(boolean paramBoolean, int paramInt, Class paramClass)
  {
    return new Array(paramBoolean, paramInt, paramClass);
  }

  public static Array with(Object[] paramArrayOfObject)
  {
    return new Array(paramArrayOfObject);
  }

  public void add(Object paramObject)
  {
    Object[] arrayOfObject = this.items;
    if (this.size == arrayOfObject.length)
      arrayOfObject = resize(Math.max(8, (int)(1.75F * this.size)));
    int i = this.size;
    this.size = (i + 1);
    arrayOfObject[i] = paramObject;
  }

  public void addAll(Array paramArray)
  {
    addAll(paramArray, 0, paramArray.size);
  }

  public void addAll(Array paramArray, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramArray.size)
      throw new IllegalArgumentException("start + count must be <= size: " + paramInt1 + " + " + paramInt2 + " <= " + paramArray.size);
    addAll((Object[])paramArray.items, paramInt1, paramInt2);
  }

  public void addAll(Object[] paramArrayOfObject)
  {
    addAll(paramArrayOfObject, 0, paramArrayOfObject.length);
  }

  public void addAll(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject = this.items;
    int i = paramInt2 + this.size;
    if (i > arrayOfObject.length)
      arrayOfObject = resize(Math.max(8, (int)(1.75F * i)));
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, this.size, paramInt2);
    this.size = (paramInt2 + this.size);
  }

  public void clear()
  {
    Object[] arrayOfObject = this.items;
    int i = this.size;
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = null;
    this.size = 0;
  }

  public boolean contains(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.items;
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

  public Object[] ensureCapacity(int paramInt)
  {
    int i = paramInt + this.size;
    if (i > this.items.length)
      resize(Math.max(8, i));
    return this.items;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!this.ordered)
      return false;
    if (!(paramObject instanceof Array))
      return false;
    Array localArray = (Array)paramObject;
    if (!localArray.ordered)
      return false;
    int i = this.size;
    if (i != localArray.size)
      return false;
    Object[] arrayOfObject1 = this.items;
    Object[] arrayOfObject2 = localArray.items;
    int j = 0;
    label69: Object localObject1;
    Object localObject2;
    if (j < i)
    {
      localObject1 = arrayOfObject1[j];
      localObject2 = arrayOfObject2[j];
      if (localObject1 != null)
        break label105;
      if (localObject2 != null)
        break label115;
    }
    label105: 
    do
    {
      j++;
      break label69;
      break;
    }
    while (localObject1.equals(localObject2));
    label115: return false;
  }

  public Object first()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[0];
  }

  public Object get(int paramInt)
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
      Object[] arrayOfObject = this.items;
      int i = this.size;
      j = 1;
      for (int k = 0; k < i; k++)
      {
        j *= 31;
        Object localObject = arrayOfObject[k];
        if (localObject == null)
          continue;
        j += localObject.hashCode();
      }
    }
  }

  public int indexOf(Object paramObject, boolean paramBoolean)
  {
    int i = 0;
    Object[] arrayOfObject = this.items;
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

  public void insert(int paramInt, Object paramObject)
  {
    if (paramInt > this.size)
      throw new IndexOutOfBoundsException("index can't be > size: " + paramInt + " > " + this.size);
    Object[] arrayOfObject = this.items;
    if (this.size == arrayOfObject.length)
      arrayOfObject = resize(Math.max(8, (int)(1.75F * this.size)));
    if (this.ordered)
      System.arraycopy(arrayOfObject, paramInt, arrayOfObject, paramInt + 1, this.size - paramInt);
    while (true)
    {
      this.size = (1 + this.size);
      arrayOfObject[paramInt] = paramObject;
      return;
      arrayOfObject[this.size] = arrayOfObject[paramInt];
    }
  }

  public Iterator iterator()
  {
    if (this.iterable == null)
      this.iterable = new Array.ArrayIterable(this);
    return this.iterable.iterator();
  }

  public int lastIndexOf(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.items;
    int i;
    if ((paramBoolean) || (paramObject == null))
      i = -1 + this.size;
    while (i >= 0)
    {
      if (arrayOfObject[i] == paramObject)
        return i;
      i--;
      continue;
      for (i = -1 + this.size; ; i--)
      {
        if (i < 0)
          break label73;
        if (paramObject.equals(arrayOfObject[i]))
          break;
      }
    }
    label73: return -1;
  }

  public Object peek()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    return this.items[(-1 + this.size)];
  }

  public Object pop()
  {
    if (this.size == 0)
      throw new IllegalStateException("Array is empty.");
    this.size = (-1 + this.size);
    Object localObject = this.items[this.size];
    this.items[this.size] = null;
    return localObject;
  }

  public Object random()
  {
    if (this.size == 0)
      return null;
    return this.items[MathUtils.random(0, -1 + this.size)];
  }

  public boolean removeAll(Array paramArray, boolean paramBoolean)
  {
    int i = this.size;
    Object[] arrayOfObject = this.items;
    int k;
    if (paramBoolean)
    {
      int i1 = paramArray.size;
      k = i;
      int i2 = 0;
      if (i2 < i1)
      {
        Object localObject2 = paramArray.get(i2);
        for (int i3 = 0; ; i3++)
        {
          if (i3 < k)
          {
            if (localObject2 != arrayOfObject[i3])
              continue;
            removeIndex(i3);
            k--;
          }
          i2++;
          break;
        }
      }
    }
    else
    {
      int j = paramArray.size;
      k = i;
      int m = 0;
      if (m < j)
      {
        Object localObject1 = paramArray.get(m);
        for (int n = 0; ; n++)
        {
          if (n < k)
          {
            if (!localObject1.equals(arrayOfObject[n]))
              continue;
            removeIndex(n);
            k--;
          }
          m++;
          break;
        }
      }
    }
    return k != i;
  }

  public Object removeIndex(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    Object[] arrayOfObject = this.items;
    Object localObject = arrayOfObject[paramInt];
    this.size = (-1 + this.size);
    if (this.ordered)
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, this.size - paramInt);
    while (true)
    {
      arrayOfObject[this.size] = null;
      return localObject;
      arrayOfObject[paramInt] = arrayOfObject[this.size];
    }
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("end can't be >= size: " + paramInt2 + " >= " + this.size);
    if (paramInt1 > paramInt2)
      throw new IndexOutOfBoundsException("start can't be > end: " + paramInt1 + " > " + paramInt2);
    Object[] arrayOfObject = this.items;
    int i = 1 + (paramInt2 - paramInt1);
    if (this.ordered)
      System.arraycopy(arrayOfObject, paramInt1 + i, arrayOfObject, paramInt1, this.size - (paramInt1 + i));
    while (true)
    {
      this.size -= i;
      return;
      int j = -1 + this.size;
      for (int k = 0; k < i; k++)
        arrayOfObject[(paramInt1 + k)] = arrayOfObject[(j - k)];
    }
  }

  public boolean removeValue(Object paramObject, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.items;
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

  protected Object[] resize(int paramInt)
  {
    Object[] arrayOfObject1 = this.items;
    Object[] arrayOfObject2 = (Object[])ArrayReflection.newInstance(arrayOfObject1.getClass().getComponentType(), paramInt);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, Math.min(this.size, arrayOfObject2.length));
    this.items = arrayOfObject2;
    return arrayOfObject2;
  }

  public void reverse()
  {
    Object[] arrayOfObject = this.items;
    int i = 0;
    int j = -1 + this.size;
    int k = this.size / 2;
    while (i < k)
    {
      int m = j - i;
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = arrayOfObject[m];
      arrayOfObject[m] = localObject;
      i++;
    }
  }

  public Iterable select(Predicate paramPredicate)
  {
    if (this.predicateIterable == null)
      this.predicateIterable = new Predicate.PredicateIterable(this, paramPredicate);
    while (true)
    {
      return this.predicateIterable;
      this.predicateIterable.set(this, paramPredicate);
    }
  }

  public Object selectRanked(Comparator paramComparator, int paramInt)
  {
    if (paramInt <= 0)
      throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    return Select.instance().select(this.items, paramComparator, paramInt, this.size);
  }

  public int selectRankedIndex(Comparator paramComparator, int paramInt)
  {
    if (paramInt <= 0)
      throw new GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    return Select.instance().selectIndex(this.items, paramComparator, paramInt, this.size);
  }

  public void set(int paramInt, Object paramObject)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException("index can't be >= size: " + paramInt + " >= " + this.size);
    this.items[paramInt] = paramObject;
  }

  public Object[] shrink()
  {
    if (this.items.length != this.size)
      resize(this.size);
    return this.items;
  }

  public void shuffle()
  {
    Object[] arrayOfObject = this.items;
    for (int i = -1 + this.size; i >= 0; i--)
    {
      int j = MathUtils.random(i);
      Object localObject = arrayOfObject[i];
      arrayOfObject[i] = arrayOfObject[j];
      arrayOfObject[j] = localObject;
    }
  }

  public void sort()
  {
    Sort.instance().sort(this.items, 0, this.size);
  }

  public void sort(Comparator paramComparator)
  {
    Sort.instance().sort(this.items, paramComparator, 0, this.size);
  }

  public void swap(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= this.size)
      throw new IndexOutOfBoundsException("first can't be >= size: " + paramInt1 + " >= " + this.size);
    if (paramInt2 >= this.size)
      throw new IndexOutOfBoundsException("second can't be >= size: " + paramInt2 + " >= " + this.size);
    Object[] arrayOfObject = this.items;
    Object localObject = arrayOfObject[paramInt1];
    arrayOfObject[paramInt1] = arrayOfObject[paramInt2];
    arrayOfObject[paramInt2] = localObject;
  }

  public Object[] toArray()
  {
    return (Object[])toArray(this.items.getClass().getComponentType());
  }

  public Object[] toArray(Class paramClass)
  {
    Object[] arrayOfObject = (Object[])ArrayReflection.newInstance(paramClass, this.size);
    System.arraycopy(this.items, 0, arrayOfObject, 0, this.size);
    return arrayOfObject;
  }

  public String toString()
  {
    if (this.size == 0)
      return "[]";
    Object[] arrayOfObject = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfObject[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfObject[i]);
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }

  public String toString(String paramString)
  {
    if (this.size == 0)
      return "";
    Object[] arrayOfObject = this.items;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append(arrayOfObject[0]);
    for (int i = 1; i < this.size; i++)
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(arrayOfObject[i]);
    }
    return localStringBuilder.toString();
  }

  public void truncate(int paramInt)
  {
    if (this.size <= paramInt)
      return;
    for (int i = paramInt; i < this.size; i++)
      this.items[i] = null;
    this.size = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Array
 * JD-Core Version:    0.6.0
 */