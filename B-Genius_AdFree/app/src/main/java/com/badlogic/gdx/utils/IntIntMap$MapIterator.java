package com.badlogic.gdx.utils;

class IntIntMap$MapIterator
{
  static final int INDEX_ILLEGAL = -2;
  static final int INDEX_ZERO = -1;
  int currentIndex;
  public boolean hasNext;
  final IntIntMap map;
  int nextIndex;
  boolean valid = true;

  public IntIntMap$MapIterator(IntIntMap paramIntIntMap)
  {
    this.map = paramIntIntMap;
    reset();
  }

  void findNextIndex()
  {
    this.hasNext = false;
    int[] arrayOfInt = this.map.keyTable;
    int i = this.map.capacity + this.map.stashSize;
    while (true)
    {
      int j = 1 + this.nextIndex;
      this.nextIndex = j;
      if (j >= i)
        break;
      if (arrayOfInt[this.nextIndex] == 0)
        continue;
      this.hasNext = true;
    }
  }

  public void remove()
  {
    if ((this.currentIndex == -1) && (this.map.hasZeroValue))
      this.map.hasZeroValue = false;
    while (true)
    {
      this.currentIndex = -2;
      IntIntMap localIntIntMap = this.map;
      localIntIntMap.size = (-1 + localIntIntMap.size);
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
      this.map.keyTable[this.currentIndex] = 0;
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
 * Qualified Name:     com.badlogic.gdx.utils.IntIntMap.MapIterator
 * JD-Core Version:    0.6.0
 */