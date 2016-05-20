package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;
import java.util.Comparator;
import java.util.Iterator;

public class Attributes
  implements Comparable, Iterable, Comparator
{
  protected final Array attributes = new Array();
  protected long mask;
  protected boolean sorted = true;

  private final void disable(long paramLong)
  {
    this.mask &= (0xFFFFFFFF ^ paramLong);
  }

  private final void enable(long paramLong)
  {
    this.mask = (paramLong | this.mask);
  }

  public int attributesHash()
  {
    sort();
    int i = this.attributes.size;
    long l1 = 71L + this.mask;
    int j = 1;
    for (int k = 0; k < i; k++)
    {
      long l2 = this.mask * ((Attribute)this.attributes.get(k)).hashCode();
      j = 0xFFFF & j * 7;
      l1 += l2 * j;
    }
    return (int)(l1 ^ l1 >> 32);
  }

  public void clear()
  {
    this.mask = 0L;
    this.attributes.clear();
  }

  public final int compare(Attribute paramAttribute1, Attribute paramAttribute2)
  {
    return (int)(paramAttribute1.type - paramAttribute2.type);
  }

  public int compareTo(Attributes paramAttributes)
  {
    if (paramAttributes == this);
    while (true)
    {
      return 0;
      if (this.mask != paramAttributes.mask)
      {
        if (this.mask < paramAttributes.mask)
          return -1;
        return 1;
      }
      sort();
      paramAttributes.sort();
      for (int i = 0; i < this.attributes.size; i++)
      {
        int j = ((Attribute)this.attributes.get(i)).compareTo(paramAttributes.attributes.get(i));
        if (j != 0)
          return j;
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Attributes))
      bool = false;
    do
      return bool;
    while (paramObject == this);
    return same((Attributes)paramObject, bool);
  }

  public final Attribute get(long paramLong)
  {
    if (has(paramLong))
      for (int i = 0; i < this.attributes.size; i++)
        if (((Attribute)this.attributes.get(i)).type == paramLong)
          return (Attribute)this.attributes.get(i);
    return null;
  }

  public final Attribute get(Class paramClass, long paramLong)
  {
    return get(paramLong);
  }

  public final Array get(Array paramArray, long paramLong)
  {
    for (int i = 0; i < this.attributes.size; i++)
    {
      if ((paramLong & ((Attribute)this.attributes.get(i)).type) == 0L)
        continue;
      paramArray.add(this.attributes.get(i));
    }
    return paramArray;
  }

  public final long getMask()
  {
    return this.mask;
  }

  public final boolean has(long paramLong)
  {
    return (paramLong != 0L) && ((paramLong & this.mask) == paramLong);
  }

  public int hashCode()
  {
    return attributesHash();
  }

  protected int indexOf(long paramLong)
  {
    if (has(paramLong))
      for (int i = 0; i < this.attributes.size; i++)
        if (((Attribute)this.attributes.get(i)).type == paramLong)
          return i;
    return -1;
  }

  public final Iterator iterator()
  {
    return this.attributes.iterator();
  }

  public final void remove(long paramLong)
  {
    for (int i = -1 + this.attributes.size; i >= 0; i--)
    {
      long l = ((Attribute)this.attributes.get(i)).type;
      if ((paramLong & l) != l)
        continue;
      this.attributes.removeIndex(i);
      disable(l);
      this.sorted = false;
    }
  }

  public final boolean same(Attributes paramAttributes)
  {
    return same(paramAttributes, false);
  }

  public final boolean same(Attributes paramAttributes, boolean paramBoolean)
  {
    int i;
    if (paramAttributes == this)
      i = 1;
    boolean bool1;
    do
    {
      do
      {
        return i;
        i = 0;
      }
      while (paramAttributes == null);
      bool1 = this.mask < paramAttributes.mask;
      i = 0;
    }
    while (bool1);
    if (!paramBoolean)
      return true;
    sort();
    paramAttributes.sort();
    for (int j = 0; ; j++)
    {
      if (j >= this.attributes.size)
        break label104;
      boolean bool2 = ((Attribute)this.attributes.get(j)).equals((Attribute)paramAttributes.attributes.get(j));
      i = 0;
      if (!bool2)
        break;
    }
    label104: return true;
  }

  public final void set(Attribute paramAttribute)
  {
    int i = indexOf(paramAttribute.type);
    if (i < 0)
    {
      enable(paramAttribute.type);
      this.attributes.add(paramAttribute);
      this.sorted = false;
      return;
    }
    this.attributes.set(i, paramAttribute);
  }

  public final void set(Attribute paramAttribute1, Attribute paramAttribute2)
  {
    set(paramAttribute1);
    set(paramAttribute2);
  }

  public final void set(Attribute paramAttribute1, Attribute paramAttribute2, Attribute paramAttribute3)
  {
    set(paramAttribute1);
    set(paramAttribute2);
    set(paramAttribute3);
  }

  public final void set(Attribute paramAttribute1, Attribute paramAttribute2, Attribute paramAttribute3, Attribute paramAttribute4)
  {
    set(paramAttribute1);
    set(paramAttribute2);
    set(paramAttribute3);
    set(paramAttribute4);
  }

  public final void set(Iterable paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
      set((Attribute)localIterator.next());
  }

  public final void set(Attribute[] paramArrayOfAttribute)
  {
    int i = paramArrayOfAttribute.length;
    for (int j = 0; j < i; j++)
      set(paramArrayOfAttribute[j]);
  }

  public int size()
  {
    return this.attributes.size;
  }

  public final void sort()
  {
    if (!this.sorted)
    {
      this.attributes.sort(this);
      this.sorted = true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Attributes
 * JD-Core Version:    0.6.0
 */