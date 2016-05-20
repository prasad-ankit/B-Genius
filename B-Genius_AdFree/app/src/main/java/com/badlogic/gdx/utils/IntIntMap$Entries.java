package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntIntMap$Entries extends IntIntMap.MapIterator
  implements Iterable, Iterator
{
  private IntIntMap.Entry entry = new IntIntMap.Entry();

  public IntIntMap$Entries(IntIntMap paramIntIntMap)
  {
    super(paramIntIntMap);
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

  public IntIntMap.Entry next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    int[] arrayOfInt = this.map.keyTable;
    if (this.nextIndex == -1)
      this.entry.key = 0;
    for (this.entry.value = this.map.zeroValue; ; this.entry.value = this.map.valueTable[this.nextIndex])
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return this.entry;
      this.entry.key = arrayOfInt[this.nextIndex];
    }
  }

  public void remove()
  {
    super.remove();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IntIntMap.Entries
 * JD-Core Version:    0.6.0
 */