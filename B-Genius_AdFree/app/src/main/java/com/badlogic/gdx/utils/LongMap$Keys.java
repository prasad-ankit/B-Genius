package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class LongMap$Keys extends LongMap.MapIterator
{
  public LongMap$Keys(LongMap paramLongMap)
  {
    super(paramLongMap);
  }

  public long next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    long l;
    if (this.nextIndex == -1)
      l = 0L;
    while (true)
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return l;
      l = this.map.keyTable[this.nextIndex];
    }
  }

  public LongArray toArray()
  {
    LongArray localLongArray = new LongArray(true, this.map.size);
    while (this.hasNext)
      localLongArray.add(next());
    return localLongArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.LongMap.Keys
 * JD-Core Version:    0.6.0
 */