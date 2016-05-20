package com.badlogic.gdx.utils;

import java.util.Comparator;

public class SnapshotArray extends Array
{
  private Object[] recycled;
  private Object[] snapshot;
  private int snapshots;

  public SnapshotArray()
  {
  }

  public SnapshotArray(int paramInt)
  {
    super(paramInt);
  }

  public SnapshotArray(Array paramArray)
  {
    super(paramArray);
  }

  public SnapshotArray(Class paramClass)
  {
    super(paramClass);
  }

  public SnapshotArray(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean, paramInt);
  }

  public SnapshotArray(boolean paramBoolean, int paramInt, Class paramClass)
  {
    super(paramBoolean, paramInt, paramClass);
  }

  public SnapshotArray(boolean paramBoolean, Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    super(paramBoolean, paramArrayOfObject, paramInt1, paramInt2);
  }

  public SnapshotArray(Object[] paramArrayOfObject)
  {
    super(paramArrayOfObject);
  }

  private void modified()
  {
    if ((this.snapshot == null) || (this.snapshot != this.items))
      return;
    if ((this.recycled != null) && (this.recycled.length >= this.size))
    {
      System.arraycopy(this.items, 0, this.recycled, 0, this.size);
      this.items = this.recycled;
      this.recycled = null;
      return;
    }
    resize(this.items.length);
  }

  public static SnapshotArray with(Object[] paramArrayOfObject)
  {
    return new SnapshotArray(paramArrayOfObject);
  }

  public Object[] begin()
  {
    modified();
    this.snapshot = this.items;
    this.snapshots = (1 + this.snapshots);
    return this.items;
  }

  public void clear()
  {
    modified();
    super.clear();
  }

  public void end()
  {
    int i = 0;
    this.snapshots = Math.max(0, -1 + this.snapshots);
    if (this.snapshot == null)
      return;
    if ((this.snapshot != this.items) && (this.snapshots == 0))
    {
      this.recycled = this.snapshot;
      int j = this.recycled.length;
      while (i < j)
      {
        this.recycled[i] = null;
        i++;
      }
    }
    this.snapshot = null;
  }

  public void insert(int paramInt, Object paramObject)
  {
    modified();
    super.insert(paramInt, paramObject);
  }

  public Object pop()
  {
    modified();
    return super.pop();
  }

  public boolean removeAll(Array paramArray, boolean paramBoolean)
  {
    modified();
    return super.removeAll(paramArray, paramBoolean);
  }

  public Object removeIndex(int paramInt)
  {
    modified();
    return super.removeIndex(paramInt);
  }

  public void removeRange(int paramInt1, int paramInt2)
  {
    modified();
    super.removeRange(paramInt1, paramInt2);
  }

  public boolean removeValue(Object paramObject, boolean paramBoolean)
  {
    modified();
    return super.removeValue(paramObject, paramBoolean);
  }

  public void reverse()
  {
    modified();
    super.reverse();
  }

  public void set(int paramInt, Object paramObject)
  {
    modified();
    super.set(paramInt, paramObject);
  }

  public void shuffle()
  {
    modified();
    super.shuffle();
  }

  public void sort()
  {
    modified();
    super.sort();
  }

  public void sort(Comparator paramComparator)
  {
    modified();
    super.sort(paramComparator);
  }

  public void swap(int paramInt1, int paramInt2)
  {
    modified();
    super.swap(paramInt1, paramInt2);
  }

  public void truncate(int paramInt)
  {
    modified();
    super.truncate(paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.SnapshotArray
 * JD-Core Version:    0.6.0
 */