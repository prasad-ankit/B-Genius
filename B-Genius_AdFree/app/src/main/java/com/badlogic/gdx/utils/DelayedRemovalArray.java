package com.badlogic.gdx.utils;

import java.util.Comparator;

public class DelayedRemovalArray extends Array
{
  private int iterating;
  private IntArray remove = new IntArray(0);

  public DelayedRemovalArray()
  {
  }

  public DelayedRemovalArray(int paramInt)
  {
    super(paramInt);
  }

  public DelayedRemovalArray(Array paramArray)
  {
    super(paramArray);
  }

  public DelayedRemovalArray(Class paramClass)
  {
    super(paramClass);
  }

  public DelayedRemovalArray(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }

  public DelayedRemovalArray(boolean paramBoolean, int paramInt, Class paramClass)
  {
    super(paramBoolean, paramInt, paramClass);
  }

  public DelayedRemovalArray(boolean paramBoolean, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    super(paramBoolean, paramArrayOfObject, paramInt1, paramInt2);
  }

  public DelayedRemovalArray(Object[] paramArrayOfObject)
  {
    super(paramArrayOfObject);
  }

  private void remove(int paramInt)
  {
    int i = 0;
    int j = this.remove.size;
    while (i < j)
    {
      int k = this.remove.get(i);
      if (paramInt == k)
        return;
      if (paramInt < k)
      {
        this.remove.insert(i, paramInt);
        return;
      }
      i++;
    }
    this.remove.add(paramInt);
  }

  public static DelayedRemovalArray with(Object[] paramArrayOfObject)
  {
    return new DelayedRemovalArray(paramArrayOfObject);
  }

  public void begin()
  {
    this.iterating = (1 + this.iterating);
  }

  public void clear()
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.clear();
  }

  public void end()
  {
    if (this.iterating == 0)
      throw new IllegalStateException("begin must be called before end.");
    this.iterating = (-1 + this.iterating);
    if (this.iterating == 0)
    {
      int i = 0;
      int j = this.remove.size;
      while (i < j)
      {
        removeIndex(this.remove.pop());
        i++;
      }
    }
  }

  public void insert(int paramInt, Object paramObject)
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.insert(paramInt, paramObject);
  }

  public Object pop()
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    return super.pop();
  }

  public Object removeIndex(int paramInt)
  {
    if (this.iterating > 0)
    {
      remove(paramInt);
      return get(paramInt);
    }
    return super.removeIndex(paramInt);
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    if (this.iterating > 0)
      while (paramInt2 >= paramInt1)
      {
        remove(paramInt2);
        paramInt2--;
      }
    super.removeRange(paramInt1, paramInt2);
  }

  public boolean removeValue(Object paramObject, boolean paramBoolean)
  {
    if (this.iterating > 0)
    {
      int i = indexOf(paramObject, paramBoolean);
      if (i == -1)
        return false;
      remove(i);
      return true;
    }
    return super.removeValue(paramObject, paramBoolean);
  }

  public void reverse()
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.reverse();
  }

  public void set(int paramInt, Object paramObject)
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.set(paramInt, paramObject);
  }

  public void shuffle()
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.shuffle();
  }

  public void sort()
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.sort();
  }

  public void sort(Comparator paramComparator)
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.sort(paramComparator);
  }

  public void swap(int paramInt1, int paramInt2)
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.swap(paramInt1, paramInt2);
  }

  public void truncate(int paramInt)
  {
    if (this.iterating > 0)
      throw new IllegalStateException("Invalid between begin/end.");
    super.truncate(paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.DelayedRemovalArray
 * JD-Core Version:    0.6.0
 */