package com.badlogic.gdx.utils;

import java.util.Iterator;

abstract class ObjectMap$MapIterator
  implements Iterable, Iterator
{
  int currentIndex;
  public boolean hasNext;
  final ObjectMap map;
  int nextIndex;
  boolean valid = true;

  public ObjectMap$MapIterator(ObjectMap paramObjectMap)
  {
    this.map = paramObjectMap;
    reset();
  }

  void findNextIndex()
  {
    this.hasNext = false;
    Object[] arrayOfObject = this.map.keyTable;
    int i = this.map.capacity + this.map.stashSize;
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

  public void remove()
  {
    if (this.currentIndex < 0)
      throw new IllegalStateException("next must be called before remove.");
    if (this.currentIndex >= this.map.capacity)
    {
      this.map.removeStashIndex(this.currentIndex);
      this.nextIndex = (-1 + this.currentIndex);
      findNextIndex();
    }
    while (true)
    {
      this.currentIndex = -1;
      ObjectMap localObjectMap = this.map;
      localObjectMap.size = (-1 + localObjectMap.size);
      return;
      this.map.keyTable[this.currentIndex] = null;
      this.map.valueTable[this.currentIndex] = null;
    }
  }

  public void reset()
  {
    this.currentIndex = -1;
    this.nextIndex = -1;
    findNextIndex();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectMap.MapIterator
 * JD-Core Version:    0.6.0
 */