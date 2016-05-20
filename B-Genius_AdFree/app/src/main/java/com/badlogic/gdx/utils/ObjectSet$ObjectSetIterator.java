package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectSet$ObjectSetIterator
  implements Iterable, Iterator
{
  int currentIndex;
  public boolean hasNext;
  int nextIndex;
  final ObjectSet set;
  boolean valid = true;

  public ObjectSet$ObjectSetIterator(ObjectSet paramObjectSet)
  {
    this.set = paramObjectSet;
    reset();
  }

  void findNextIndex()
  {
    this.hasNext = false;
    Object[] arrayOfObject = this.set.keyTable;
    int i = this.set.capacity + this.set.stashSize;
    while (true)
    {
      int j = 1 + this.nextIndex;
      this.nextIndex = j;
      if (j >= i)
        break;
      if (arrayOfObject[this.nextIndex] == null)
        continue;
      this.hasNext = true;
    }
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public ObjectSetIterator iterator()
  {
    return this;
  }

  public Object next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object localObject = this.set.keyTable[this.nextIndex];
    this.currentIndex = this.nextIndex;
    findNextIndex();
    return localObject;
  }

  public void remove()
  {
    if (this.currentIndex < 0)
      throw new IllegalStateException("next must be called before remove.");
    if (this.currentIndex >= this.set.capacity)
    {
      this.set.removeStashIndex(this.currentIndex);
      this.nextIndex = (-1 + this.currentIndex);
      findNextIndex();
    }
    while (true)
    {
      this.currentIndex = -1;
      ObjectSet localObjectSet = this.set;
      localObjectSet.size = (-1 + localObjectSet.size);
      return;
      this.set.keyTable[this.currentIndex] = null;
    }
  }

  public void reset()
  {
    this.currentIndex = -1;
    this.nextIndex = -1;
    findNextIndex();
  }

  public Array toArray()
  {
    return toArray(new Array(true, this.set.size));
  }

  public Array toArray(Array paramArray)
  {
    while (this.hasNext)
      paramArray.add(next());
    return paramArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator
 * JD-Core Version:    0.6.0
 */