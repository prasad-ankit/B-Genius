package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IdentityMap$Values extends IdentityMap.MapIterator
{
  public IdentityMap$Values(IdentityMap paramIdentityMap)
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

  public Object next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object localObject = this.map.valueTable[this.nextIndex];
    this.currentIndex = this.nextIndex;
    findNextIndex();
    return localObject;
  }

  public Array toArray()
  {
    Array localArray = new Array(true, this.map.size);
    while (this.hasNext)
      localArray.add(next());
    return localArray;
  }

  public void toArray(Array paramArray)
  {
    while (this.hasNext)
      paramArray.add(next());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.IdentityMap.Values
 * JD-Core Version:    0.6.0
 */