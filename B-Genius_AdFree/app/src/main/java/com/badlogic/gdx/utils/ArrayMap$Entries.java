package com.badlogic.gdx.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayMap$Entries
  implements Iterable, Iterator
{
  ObjectMap.Entry entry = new ObjectMap.Entry();
  int index;
  private final ArrayMap map;
  boolean valid = true;

  public ArrayMap$Entries(ArrayMap paramArrayMap)
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

  public ObjectMap.Entry next()
  {
    if (this.index >= this.map.size)
      throw new NoSuchElementException(String.valueOf(this.index));
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    this.entry.key = this.map.keys[this.index];
    ObjectMap.Entry localEntry = this.entry;
    Object[] arrayOfObject = this.map.values;
    int i = this.index;
    this.index = (i + 1);
    localEntry.value = arrayOfObject[i];
    return this.entry;
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
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ArrayMap.Entries
 * JD-Core Version:    0.6.0
 */