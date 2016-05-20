package com.badlogic.gdx.utils;

import java.util.Iterator;

public class Array$ArrayIterable
  implements Iterable
{
  private final boolean allowRemove;
  private final Array array;
  private Array.ArrayIterator iterator1;
  private Array.ArrayIterator iterator2;

  public Array$ArrayIterable(Array paramArray)
  {
    this(paramArray, true);
  }

  public Array$ArrayIterable(Array paramArray, boolean paramBoolean)
  {
    this.array = paramArray;
    this.allowRemove = paramBoolean;
  }

  public Iterator iterator()
  {
    if (this.iterator1 == null)
    {
      this.iterator1 = new Array.ArrayIterator(this.array, this.allowRemove);
      this.iterator2 = new Array.ArrayIterator(this.array, this.allowRemove);
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
 * Qualified Name:     com.badlogic.gdx.utils.Array.ArrayIterable
 * JD-Core Version:    0.6.0
 */