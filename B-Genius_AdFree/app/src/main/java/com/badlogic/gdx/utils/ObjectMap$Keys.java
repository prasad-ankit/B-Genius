package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class ObjectMap$Keys extends ObjectMap.MapIterator
{
  public ObjectMap$Keys(ObjectMap paramObjectMap)
  {
    super(paramObjectMap);
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public Keys iterator()
  {
    return this;
  }

  public Object next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object localObject = this.map.keyTable[this.nextIndex];
    this.currentIndex = this.nextIndex;
    findNextIndex();
    return localObject;
  }

  public Array toArray()
  {
    return toArray(new Array(true, this.map.size));
  }

  public Array toArray(Array paramArray)
  {
    while (this.hasNext)
      paramArray.add(next());
    return paramArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectMap.Keys
 * JD-Core Version:    0.6.0
 */