package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class OrderedMap$OrderedMapEntries extends ObjectMap.Entries
{
  private Array keys;

  public OrderedMap$OrderedMapEntries(OrderedMap paramOrderedMap)
  {
    super(paramOrderedMap);
    this.keys = paramOrderedMap.keys;
  }

  public ObjectMap.Entry next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    this.entry.key = this.keys.get(this.nextIndex);
    this.entry.value = this.map.get(this.entry.key);
    this.nextIndex = (1 + this.nextIndex);
    if (this.nextIndex < this.map.size);
    for (boolean bool = true; ; bool = false)
    {
      this.hasNext = bool;
      return this.entry;
    }
  }

  public void remove()
  {
    if (this.currentIndex < 0)
      throw new IllegalStateException("next must be called before remove.");
    this.map.remove(this.entry.key);
  }

  public void reset()
  {
    this.nextIndex = 0;
    int i = this.map.size;
    boolean bool = false;
    if (i > 0)
      bool = true;
    this.hasNext = bool;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.OrderedMap.OrderedMapEntries
 * JD-Core Version:    0.6.0
 */