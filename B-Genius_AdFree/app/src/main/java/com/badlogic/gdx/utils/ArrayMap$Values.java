package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayMap$Values
  implements Iterable, Iterator
{
  int index;
  private final ArrayMap map;
  boolean valid = true;

  public ArrayMap$Values(ArrayMap paramArrayMap)
  {
    this.map = paramArrayMap;
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.index < this.map.size;
  }

  public Iterator iterator()
  {
    return this;
  }

  public Object next()
  {
    if (this.index >= this.map.size)
      throw new NoSuchElementException(String.valueOf(this.index));
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object[] arrayOfObject = this.map.values;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfObject[i];
  }

  public void remove()
  {
    this.index = (-1 + this.index);
    this.map.removeIndex(this.index);
  }

  public void reset()
  {
    this.index = 0;
  }

  public Array toArray()
  {
    return new Array(true, this.map.values, this.index, this.map.size - this.index);
  }

  public Array toArray(Array paramArray)
  {
    paramArray.addAll(this.map.values, this.index, this.map.size - this.index);
    return paramArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ArrayMap.Values
 * JD-Core Version:    0.6.0
 */