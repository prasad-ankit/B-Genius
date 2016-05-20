package com.badlogic.gdx.utils;

public class OrderedMap extends ObjectMap
{
  private ObjectMap.Entries entries1;
  private ObjectMap.Entries entries2;
  final Array keys;
  private ObjectMap.Keys keys1;
  private ObjectMap.Keys keys2;
  private ObjectMap.Values values1;
  private ObjectMap.Values values2;

  public OrderedMap()
  {
    this.keys = new Array();
  }

  public OrderedMap(int paramInt)
  {
    super(paramInt);
    this.keys = new Array(this.capacity);
  }

  public OrderedMap(int paramInt, float paramFloat)
  {
    super(paramInt, paramFloat);
    this.keys = new Array(this.capacity);
  }

  public OrderedMap(ObjectMap paramObjectMap)
  {
    super(paramObjectMap);
    this.keys = new Array(this.capacity);
  }

  public void clear()
  {
    this.keys.clear();
    super.clear();
  }

  public void clear(int paramInt)
  {
    this.keys.clear();
    super.clear(paramInt);
  }

  public ObjectMap.Entries entries()
  {
    if (this.entries1 == null)
    {
      this.entries1 = new OrderedMap.OrderedMapEntries(this);
      this.entries2 = new OrderedMap.OrderedMapEntries(this);
    }
    if (!this.entries1.valid)
    {
      this.entries1.reset();
      this.entries1.valid = true;
      this.entries2.valid = false;
      return this.entries1;
    }
    this.entries2.reset();
    this.entries2.valid = true;
    this.entries1.valid = false;
    return this.entries2;
  }

  public ObjectMap.Entries iterator()
  {
    return entries();
  }

  public ObjectMap.Keys keys()
  {
    if (this.keys1 == null)
    {
      this.keys1 = new OrderedMap.OrderedMapKeys(this);
      this.keys2 = new OrderedMap.OrderedMapKeys(this);
    }
    if (!this.keys1.valid)
    {
      this.keys1.reset();
      this.keys1.valid = true;
      this.keys2.valid = false;
      return this.keys1;
    }
    this.keys2.reset();
    this.keys2.valid = true;
    this.keys1.valid = false;
    return this.keys2;
  }

  public Array orderedKeys()
  {
    return this.keys;
  }

  public Object put(Object paramObject1, Object paramObject2)
  {
    if (!containsKey(paramObject1))
      this.keys.add(paramObject1);
    return super.put(paramObject1, paramObject2);
  }

  public Object remove(Object paramObject)
  {
    this.keys.removeValue(paramObject, false);
    return super.remove(paramObject);
  }

  public String toString()
  {
    if (this.size == 0)
      return "{}";
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('{');
    Array localArray = this.keys;
    int i = 0;
    int j = localArray.size;
    while (i < j)
    {
      Object localObject = localArray.get(i);
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(localObject);
      localStringBuilder.append('=');
      localStringBuilder.append(get(localObject));
      i++;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }

  public ObjectMap.Values values()
  {
    if (this.values1 == null)
    {
      this.values1 = new OrderedMap.OrderedMapValues(this);
      this.values2 = new OrderedMap.OrderedMapValues(this);
    }
    if (!this.values1.valid)
    {
      this.values1.reset();
      this.values1.valid = true;
      this.values2.valid = false;
      return this.values1;
    }
    this.values2.reset();
    this.values2.valid = true;
    this.values1.valid = false;
    return this.values2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.OrderedMap
 * JD-Core Version:    0.6.0
 */