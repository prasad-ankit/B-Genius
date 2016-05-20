package com.badlogic.gdx.utils;

class LongMap$MapIterator
{
  static final int INDEX_ILLEGAL = -2;
  static final int INDEX_ZERO = -1;
  int currentIndex;
  public boolean hasNext;
  final LongMap map;
  int nextIndex;
  boolean valid = true;

  public LongMap$MapIterator(LongMap paramLongMap)
  {
    this.map = paramLongMap;
    reset();
  }

  void findNextIndex()
  {
    this.hasNext = false;
    long[] arrayOfLong = this.map.keyTable;
    int i = this.map.capacity + this.map.stashSize;
    while (true)
    {
      int j = 1 + this.nextIndex;
      this.nextIndex = j;
      if (j >= i)
        break;
      if (arrayOfLong[this.nextIndex] == 0L)
        continue;
      this.hasNext = true;
    }
  }

  public void remove()
  {
    if ((this.currentIndex == -1) && (this.map.hasZeroValue))
    {
      this.map.zeroValue = null;
      this.map.hasZeroValue = false;
    }
    while (true)
    {
      this.currentIndex = -2;
      LongMap localLongMap = this.map;
      localLongMap.size = (-1 + localLongMap.size);
      return;
      if (this.currentIndex < 0)
        throw new IllegalStateException("next must be called before remove.");
      if (this.currentIndex >= this.map.capacity)
      {
        this.map.removeStashIndex(this.currentIndex);
        this.nextIndex = (-1 + this.currentIndex);
        findNextIndex();
        continue;
      }
      this.map.keyTable[this.currentIndex] = 0L;
      this.map.valueTable[this.currentIndex] = null;
    }
  }

  public void reset()
  {
    this.currentIndex = -2;
    this.nextIndex = -1;
    if (this.map.hasZeroValue)
    {
      this.hasNext = true;
      return;
    }
    findNextIndex();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.LongMap.MapIterator
 * JD-Core Version:    0.6.0
 */