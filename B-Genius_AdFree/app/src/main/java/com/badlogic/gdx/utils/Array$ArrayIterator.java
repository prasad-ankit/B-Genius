package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array$ArrayIterator
  implements Iterable, Iterator
{
  private final boolean allowRemove;
  private final Array array;
  int index;
  boolean valid = true;

  public Array$ArrayIterator(Array paramArray)
  {
    this(paramArray, true);
  }

  public Array$ArrayIterator(Array paramArray, boolean paramBoolean)
  {
    this.array = paramArray;
    this.allowRemove = paramBoolean;
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.index < this.array.size;
  }

  public Iterator iterator()
  {
    return this;
  }

  public Object next()
  {
    if (this.index >= this.array.size)
      throw new NoSuchElementException(String.valueOf(this.index));
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object[] arrayOfObject = this.array.items;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfObject[i];
  }

  public void remove()
  {
    if (!this.allowRemove)
      throw new GdxRuntimeException("Remove not allowed.");
    this.index = (-1 + this.index);
    this.array.removeIndex(this.index);
  }

  public void reset()
  {
    this.index = 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Array.ArrayIterator
 * JD-Core Version:    0.6.0
 */