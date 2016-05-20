package com.badlogic.gdx.graphics;

import com.badlogic.gdx.utils.GdxRuntimeException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class VertexAttributes$ReadonlyIterator
  implements Iterable, Iterator
{
  private final Object[] array;
  int index;
  boolean valid = true;

  public VertexAttributes$ReadonlyIterator(Object[] paramArrayOfObject)
  {
    this.array = paramArrayOfObject;
  }

  public boolean hasNext()
  {
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    return this.index < this.array.length;
  }

  public Iterator iterator()
  {
    return this;
  }

  public Object next()
  {
    if (this.index >= this.array.length)
      throw new NoSuchElementException(String.valueOf(this.index));
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object[] arrayOfObject = this.array;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfObject[i];
  }

  public void remove()
  {
    throw new GdxRuntimeException("Remove not allowed.");
  }

  public void reset()
  {
    this.index = 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterator
 * JD-Core Version:    0.6.0
 */