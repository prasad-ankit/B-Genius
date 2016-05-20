package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class IntIntMap$Keys extends IntIntMap.MapIterator
{
  public IntIntMap$Keys(IntIntMap paramIntIntMap)
  {
    super(paramIntIntMap);
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public int next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    if (this.nextIndex == -1);
    for (int i = 0; ; i = this.map.keyTable[this.nextIndex])
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return i;
    }
  }

  public IntArray toArray()
  {
    IntArray localIntArray = new IntArray(true, this.map.size);
    while (this.hasNext)
      localIntArray.add(next());
    return localIntArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IntIntMap.Keys
 * JD-Core Version:    0.6.0
 */