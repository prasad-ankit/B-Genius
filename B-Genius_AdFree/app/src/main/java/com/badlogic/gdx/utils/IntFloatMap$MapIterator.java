package com.badlogic.gdx.utils;

class IntFloatMap$MapIterator
{
  static final int INDEX_ILLEGAL = -2;
  static final int INDEX_ZERO = -1;
  int currentIndex;
  public boolean hasNext;
  final IntFloatMap map;
  int nextIndex;
  boolean valid = true;

  public IntFloatMap$MapIterator(IntFloatMap paramIntFloatMap)
  {
    this.map = paramIntFloatMap;
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
      IntFloatMap localIntFloatMap = this.map;
      localIntFloatMap.size = (-1 + localIntFloatMap.size);
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
 * Qualified Name:     com.badlogic.gdx.utils.IntFloatMap.MapIterator
 * JD-Core Version:    0.6.0
 */