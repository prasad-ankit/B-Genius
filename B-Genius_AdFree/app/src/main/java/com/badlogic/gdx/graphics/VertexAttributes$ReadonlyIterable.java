package com.badlogic.gdx.graphics;

import java.util.Iterator;

class VertexAttributes$ReadonlyIterable
  implements Iterable
{
  private final Object[] array;
  private VertexAttributes.ReadonlyIterator iterator1;
  private VertexAttributes.ReadonlyIterator iterator2;

  public VertexAttributes$ReadonlyIterable(Object[] paramArrayOfObject)
  {
    this.array = paramArrayOfObject;
  }

  public Iterator iterator()
  {
    if (this.iterator1 == null)
    {
      this.iterator1 = new VertexAttributes.ReadonlyIterator(this.array);
      this.iterator2 = new VertexAttributes.ReadonlyIterator(this.array);
    }
    if (!this.iterator1.valid)
    {
      this.iterator1.index = 0;
      this.iterator1.valid = true;
      this.iterator2.valid = false;
      return this.iterator1;
    }
    this.iterator2.index = 0;
    this.iterator2.valid = true;
    this.iterator1.valid = false;
    return this.iterator2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.VertexAttributes.ReadonlyIterable
 * JD-Core Version:    0.6.0
 */