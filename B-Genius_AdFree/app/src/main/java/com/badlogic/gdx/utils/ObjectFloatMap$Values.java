package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class ObjectFloatMap$Values extends ObjectFloatMap.MapIterator
{
  public ObjectFloatMap$Values(ObjectFloatMap paramObjectFloatMap)
  {
    super(paramObjectFloatMap);
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.hasNext;
  }

  public float next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    float f = this.map.valueTable[this.nextIndex];
    this.currentIndex = this.nextIndex;
    findNextIndex();
    return f;
  }

  public FloatArray toArray()
  {
    FloatArray localFloatArray = new FloatArray(true, this.map.size);
    while (this.hasNext)
      localFloatArray.add(next());
    return localFloatArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ObjectFloatMap.Values
 * JD-Core Version:    0.6.0
 */