package com.badlogic.gdx.utils;

public class OrderedSet extends ObjectSet
{
  final Array items;
  OrderedSet.OrderedSetIterator iterator1;
  OrderedSet.OrderedSetIterator iterator2;

  public OrderedSet()
  {
    this.items = new Array();
  }

  public OrderedSet(int paramInt)
  {
    super(paramInt);
    this.items = new Array(this.capacity);
  }

  public OrderedSet(int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat);
    this.items = new Array(this.capacity);
  }

  public OrderedSet(OrderedSet paramOrderedSet)
  {
    super(paramOrderedSet);
    this.items = new Array(this.capacity);
    this.items.addAll(paramOrderedSet.items);
  }

  public boolean add(Object paramObject)
  {
    if (!contains(paramObject))
      this.items.add(paramObject);
    return super.add(paramObject);
  }

  public void clear()
  {
    this.items.clear();
    super.clear();
  }

  public void clear(int paramInt)
  {
    this.items.clear();
    super.clear(paramInt);
  }

  public OrderedSet.OrderedSetIterator iterator()
  {
    if (this.iterator1 == null)
    {
      this.iterator1 = new OrderedSet.OrderedSetIterator(this);
      this.iterator2 = new OrderedSet.OrderedSetIterator(this);
    }
    if (!this.iterator1.valid)
    {
      this.iterator1.reset();
      this.iterator1.valid = true;
      this.iterator2.valid = false;
      return this.iterator1;
    }
    this.iterator2.reset();
    this.iterator2.valid = true;
    this.iterator1.valid = false;
    return this.iterator2;
  }

  public Array orderedItems()
  {
    return this.items;
  }

  public boolean remove(Object paramObject)
  {
    this.items.removeValue(paramObject, false);
    return super.remove(paramObject);
  }

  public String toString()
  {
    if (this.size == 0)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('{');
    Array localArray = this.items;
    int i = 0;
    int j = localArray.size;
    while (i < j)
    {
      Object localObject = localArray.get(i);
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(localObject);
      i++;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.OrderedSet
 * JD-Core Version:    0.6.0
 */