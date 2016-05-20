package com.badlogic.gdx.graphics;

import java.util.Iterator;

public final class VertexAttributes
  implements Comparable, Iterable
{
  private final VertexAttribute[] attributes;
  private VertexAttributes.ReadonlyIterable iterable;
  private long mask = -1L;
  public final int vertexSize;

  public VertexAttributes(VertexAttribute[] paramArrayOfVertexAttribute)
  {
    if (paramArrayOfVertexAttribute.length == 0)
      throw new IllegalArgumentException("attributes must be >= 1");
    VertexAttribute[] arrayOfVertexAttribute = new VertexAttribute[paramArrayOfVertexAttribute.length];
    for (int i = 0; i < paramArrayOfVertexAttribute.length; i++)
      arrayOfVertexAttribute[i] = paramArrayOfVertexAttribute[i];
    this.attributes = arrayOfVertexAttribute;
    this.vertexSize = calculateOffsets();
  }

  private int calculateOffsets()
  {
    int i = 0;
    int j = 0;
    if (i < this.attributes.length)
    {
      VertexAttribute localVertexAttribute = this.attributes[i];
      localVertexAttribute.offset = j;
      if (localVertexAttribute.usage == 4)
        j += 4;
      while (true)
      {
        i++;
        break;
        j += 4 * localVertexAttribute.numComponents;
      }
    }
    return j;
  }

  public final int compareTo(VertexAttributes paramVertexAttributes)
  {
    int i = -1;
    if (this.attributes.length != paramVertexAttributes.attributes.length)
      i = this.attributes.length - paramVertexAttributes.attributes.length;
    while (true)
    {
      return i;
      long l1 = getMask();
      long l2 = paramVertexAttributes.getMask();
      if (l1 == l2)
        break;
      if (l1 >= l2)
        return 1;
    }
    for (int j = -1 + this.attributes.length; ; j--)
    {
      if (j < 0)
        break label217;
      VertexAttribute localVertexAttribute1 = this.attributes[j];
      VertexAttribute localVertexAttribute2 = paramVertexAttributes.attributes[j];
      if (localVertexAttribute1.usage != localVertexAttribute2.usage)
        return localVertexAttribute1.usage - localVertexAttribute2.usage;
      if (localVertexAttribute1.unit != localVertexAttribute2.unit)
        return localVertexAttribute1.unit - localVertexAttribute2.unit;
      if (localVertexAttribute1.numComponents != localVertexAttribute2.numComponents)
        return localVertexAttribute1.numComponents - localVertexAttribute2.numComponents;
      if (localVertexAttribute1.normalized != localVertexAttribute2.normalized)
      {
        if (!localVertexAttribute1.normalized)
          break;
        return 1;
      }
      if (localVertexAttribute1.type != localVertexAttribute2.type)
        return localVertexAttribute1.type - localVertexAttribute2.type;
    }
    label217: return 0;
  }

  public final boolean equals(Object paramObject)
  {
    int i;
    if (paramObject == this)
      i = 1;
    VertexAttributes localVertexAttributes;
    int j;
    int k;
    do
    {
      boolean bool1;
      do
      {
        return i;
        bool1 = paramObject instanceof VertexAttributes;
        i = 0;
      }
      while (!bool1);
      localVertexAttributes = (VertexAttributes)paramObject;
      j = this.attributes.length;
      k = localVertexAttributes.attributes.length;
      i = 0;
    }
    while (j != k);
    for (int m = 0; ; m++)
    {
      if (m >= this.attributes.length)
        break label96;
      boolean bool2 = this.attributes[m].equals(localVertexAttributes.attributes[m]);
      i = 0;
      if (!bool2)
        break;
    }
    label96: return true;
  }

  public final VertexAttribute findByUsage(int paramInt)
  {
    int i = size();
    for (int j = 0; j < i; j++)
      if (get(j).usage == paramInt)
        return get(j);
    return null;
  }

  public final VertexAttribute get(int paramInt)
  {
    return this.attributes[paramInt];
  }

  public final long getMask()
  {
    if (this.mask == -1L)
    {
      long l = 0L;
      for (int i = 0; i < this.attributes.length; i++)
        l |= this.attributes[i].usage;
      this.mask = l;
    }
    return this.mask;
  }

  public final int getOffset(int paramInt)
  {
    return getOffset(paramInt, 0);
  }

  public final int getOffset(int paramInt1, int paramInt2)
  {
    VertexAttribute localVertexAttribute = findByUsage(paramInt1);
    if (localVertexAttribute == null)
      return paramInt2;
    return localVertexAttribute.offset / 4;
  }

  public final int hashCode()
  {
    long l = 61 * this.attributes.length;
    for (int i = 0; i < this.attributes.length; i++)
      l = l * 61L + this.attributes[i].hashCode();
    return (int)(l ^ l >> 32);
  }

  public final Iterator iterator()
  {
    if (this.iterable == null)
      this.iterable = new VertexAttributes.ReadonlyIterable(this.attributes);
    return this.iterable.iterator();
  }

  public final int size()
  {
    return this.attributes.length;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    for (int i = 0; i < this.attributes.length; i++)
    {
      localStringBuilder.append("(");
      localStringBuilder.append(this.attributes[i].alias);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.attributes[i].usage);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.attributes[i].numComponents);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.attributes[i].offset);
      localStringBuilder.append(")");
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.VertexAttributes
 * JD-Core Version:    0.6.0
 */