package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class IntSet$IntSetIterator
{
  static final int INDEX_ILLEGAL = -2;
  static final int INDEX_ZERO = -1;
  int currentIndex;
  public boolean hasNext;
  int nextIndex;
  final IntSet set;
  boolean valid = true;

  public IntSet$IntSetIterator(IntSet paramIntSet)
  {
    this.set = paramIntSet;
    reset();
  }

  void findNextIndex()
  {
    this.hasNext = false;
    int[] arrayOfInt = this.set.keyTable;
    int i = this.set.capacity + this.set.stashSize;
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

  public int next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    if (this.nextIndex == -1);
    for (int i = 0; ; i = this.set.keyTable[this.nextIndex])
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return i;
    }
  }

  public void remove()
  {
    if ((this.currentIndex == -1) && (this.set.hasZeroValue))
      this.set.hasZeroValue = false;
    while (true)
    {
      this.currentIndex = -2;
      IntSet localIntSet = this.set;
      localIntSet.size = (-1 + localIntSet.size);
      return;
      if (this.currentIndex < 0)
        throw new IllegalStateException("next must be called before remove.");
      if (this.currentIndex >= this.set.capacity)
      {
        this.set.removeStashIndex(this.currentIndex);
        this.nextIndex = (-1 + this.currentIndex);
        findNextIndex();
        continue;
      }
      this.set.keyTable[this.currentIndex] = 0;
    }
  }

  public void reset()
  {
    this.currentIndex = -2;
    this.nextIndex = -1;
    if (this.set.hasZeroValue)
    {
      this.hasNext = true;
      return;
    }
    findNextIndex();
  }

  public IntArray toArray()
  {
    IntArray localIntArray = new IntArray(true, this.set.size);
    while (this.hasNext)
      localIntArray.add(next());
    return localIntArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IntSet.IntSetIterator
 * JD-Core Version:    0.6.0
 */