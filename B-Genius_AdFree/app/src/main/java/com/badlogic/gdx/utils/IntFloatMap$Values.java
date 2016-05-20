package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class IntFloatMap$Values extends IntFloatMap.MapIterator
{
  public IntFloatMap$Values(IntFloatMap paramIntFloatMap)
  {
    super(paramIntFloatMap);
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
    float f;
    if (this.nextIndex == -1)
      f = this.map.zeroValue;
    while (true)
    {
      this.currentIndex = this.nextIndex;
      findNextIndex();
      return f;
      f = this.map.valueTable[this.nextIndex];
    }
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
 * Qualified Name:     com.badlogic.gdx.utils.IntFloatMap.Values
 * JD-Core Version:    0.6.0
 */