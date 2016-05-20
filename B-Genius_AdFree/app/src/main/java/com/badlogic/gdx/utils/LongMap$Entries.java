package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LongMap$Entries extends LongMap.MapIterator
  implements Iterable, Iterator
{
  private LongMap.Entry entry = new LongMap.Entry();

  public LongMap$Entries(LongMap paramLongMap)
  {
    super(paramLongMap);
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public Iterator iterator()
  {
    return this;
  }

  public LongMap.Entry next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    long[] arrayOfLong = this.map.keyTable;
    if (this.nextIndex == -1)
      this.entry.key = 0L;
    for (this.entry.value = this.map.zeroValue; ; this.entry.value = this.map.valueTable[this.nextIndex])
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return this.entry;
      this.entry.key = arrayOfLong[this.nextIndex];
    }
  }

  public void remove()
  {
    super.remove();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.LongMap.Entries
 * JD-Core Version:    0.6.0
 */