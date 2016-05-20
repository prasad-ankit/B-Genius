package com.badlogic.gdx.utils;

import java.util.Iterator;

class SortedIntList$Iterator
  implements Iterator
{
  private SortedIntList.Node position;
  private SortedIntList.Node previousPosition;

  SortedIntList$Iterator(SortedIntList paramSortedIntList)
  {
  }

  public boolean hasNext()
  {
    return this.position != null;
  }

  public SortedIntList.Node next()
  {
    this.previousPosition = this.position;
    this.position = this.position.n;
    return this.previousPosition;
  }

  public void remove()
  {
    if (this.previousPosition != null)
    {
      if (this.previousPosition != this.this$0.first)
        break label48;
      this.this$0.first = this.position;
    }
    while (true)
    {
      SortedIntList localSortedIntList = this.this$0;
      localSortedIntList.size = (-1 + localSortedIntList.size);
      return;
      label48: this.previousPosition.p.n = this.position;
      if (this.position == null)
        continue;
      this.position.p = this.previousPosition.p;
    }
  }

  public Iterator reset()
  {
    this.position = this.this$0.first;
    this.previousPosition = null;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.SortedIntList.Iterator
 * JD-Core Version:    0.6.0
 */