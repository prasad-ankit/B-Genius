package com.badlogic.gdx.utils;

import java.util.NoSuchElementException;

public class OrderedSet$OrderedSetIterator extends ObjectSet.ObjectSetIterator
{
  private Array items;

  public OrderedSet$OrderedSetIterator(OrderedSet paramOrderedSet)
  {
    super(paramOrderedSet);
    this.items = paramOrderedSet.items;
  }

  public Object next()
  {
    if (!this.hasNext)
      throw new NoSuchElementException();
    if (!this.valid)
      throw new GdxRuntimeException("#iterator() cannot be used nested.");
    Object localObject = this.items.get(this.nextIndex);
    this.nextIndex = (1 + this.nextIndex);
    if (this.nextIndex < this.set.size);
    for (boolean bool = true; ; bool = false)
    {
      this.hasNext = bool;
      return localObject;
    }
  }

  public void remove()
  {
    if (this.nextIndex < 0)
      throw new IllegalStateException("next must be called before remove.");
    this.nextIndex = (-1 + this.nextIndex);
    this.set.remove(this.items.get(this.nextIndex));
  }

  public void reset()
  {
    this.nextIndex = 0;
    int i = this.set.size;
    boolean bool = false;
    if (i > 0)
      bool = true;
    this.hasNext = bool;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.OrderedSet.OrderedSetIterator
 * JD-Core Version:    0.6.0
 */