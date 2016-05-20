package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class OrderedMap$OrderedMapValues extends ObjectMap.Values
{
  private Array keys;

  public OrderedMap$OrderedMapValues(OrderedMap paramOrderedMap)
  {
    super(paramOrderedMap);
    this.keys = paramOrderedMap.keys;
  }

  public Object next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object localObject = this.map.get(this.keys.get(this.nextIndex));
    this.nextIndex = (1 + this.nextIndex);
    if (this.nextIndex < this.map.size);
    for (boolean bool = true; ; bool = false)
    {
      this.hasNext = bool;
      return localObject;
    }
  }

  public void remove()
  {
    if (this.currentIndex < 0)
      throw new IllegalStateException("next must be called before remove.");
    this.map.remove(this.keys.get(-1 + this.nextIndex));
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
 * Qualified Name:     com.badlogic.gdx.utils.OrderedMap.OrderedMapValues
 * JD-Core Version:    0.6.0
 */