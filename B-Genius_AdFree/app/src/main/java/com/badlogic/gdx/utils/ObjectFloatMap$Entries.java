package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ObjectFloatMap$Entries extends ObjectFloatMap.MapIterator
  implements Iterable, Iterator
{
  private ObjectFloatMap.Entry entry = new ObjectFloatMap.Entry();

  public ObjectFloatMap$Entries(ObjectFloatMap paramObjectFloatMap)
  {
    super(paramObjectFloatMap);
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public Entries iterator()
  {
    return this;
  }

  public ObjectFloatMap.Entry next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object[] arrayOfObject = this.map.keyTable;
    this.entry.key = arrayOfObject[this.nextIndex];
    this.entry.value = this.map.valueTable[this.nextIndex];
    this.currentIndex = this.nextIndex;
    findNextIndex();
    return this.entry;
  }

  public void remove()
  {
    super.remove();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectFloatMap.Entries
 * JD-Core Version:    0.6.0
 */