package com.badlogic.gdx.utils;

import java.util.Iterator;

public class SortedIntList
  implements Iterable
{
  SortedIntList.Node first;
  private SortedIntList.Iterator iterator;
  private SortedIntList.NodePool nodePool = new SortedIntList.NodePool();
  int size = 0;

  public void clear()
  {
    while (this.first != null)
    {
      this.nodePool.free(this.first);
      this.first = this.first.n;
    }
    this.size = 0;
  }

  public Object get(int paramInt)
  {
    if (this.first != null)
    {
      for (SortedIntList.Node localNode = this.first; (localNode.n != null) && (localNode.index < paramInt); localNode = localNode.n);
      if (localNode.index == paramInt)
        return localNode.value;
    }
    return null;
  }

  public Object insert(int paramInt, Object paramObject)
  {
    if (this.first != null)
    {
      for (SortedIntList.Node localNode1 = this.first; (localNode1.n != null) && (localNode1.n.index <= paramInt); localNode1 = localNode1.n);
      if (paramInt > localNode1.index)
      {
        localNode1.n = this.nodePool.obtain(localNode1, localNode1.n, paramObject, paramInt);
        if (localNode1.n.n != null)
          localNode1.n.n.p = localNode1.n;
        this.size = (1 + this.size);
        return null;
      }
      if (paramInt < localNode1.index)
      {
        SortedIntList.Node localNode2 = this.nodePool.obtain(null, this.first, paramObject, paramInt);
        this.first.p = localNode2;
        this.first = localNode2;
        this.size = (1 + this.size);
        return null;
      }
      localNode1.value = paramObject;
      return null;
    }
    this.first = this.nodePool.obtain(null, null, paramObject, paramInt);
    this.size = (1 + this.size);
    return null;
  }

  public Iterator iterator()
  {
    if (this.iterator == null)
      this.iterator = new SortedIntList.Iterator(this);
    return this.iterator.reset();
  }

  public int size()
  {
    return this.size;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.SortedIntList
 * JD-Core Version:    0.6.0
 */