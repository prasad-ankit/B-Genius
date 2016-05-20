package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IdentityMap$Entries extends IdentityMap.MapIterator
{
  private IdentityMap.Entry entry = new IdentityMap.Entry();

  public IdentityMap$Entries(IdentityMap paramIdentityMap)
  {
    super(paramIdentityMap);
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

  public IdentityMap.Entry next()
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
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IdentityMap.Entries
 * JD-Core Version:    0.6.0
 */