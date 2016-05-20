package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.utils.Array;

public abstract class Attribute
  implements Comparable
{
  private static final Array types = new Array();
  public final long type;
  private final int typeBit;

  protected Attribute(long paramLong)
  {
    this.type = paramLong;
    this.typeBit = Long.numberOfTrailingZeros(paramLong);
  }

  public static final String getAttributeAlias(long paramLong)
  {
    int i = -1;
    do
    {
      if (paramLong == 0L)
        break;
      i++;
    }
    while ((i < 63) && ((1L & paramLong >> i) == 0L));
    if ((i >= 0) && (i < types.size))
      return (String)types.get(i);
    return null;
  }

  public static final long getAttributeType(String paramString)
  {
    for (int i = 0; i < types.size; i++)
      if (((String)types.get(i)).compareTo(paramString) == 0)
        return 1L << i;
    return 0L;
  }

  protected static final long register(String paramString)
  {
    long l = getAttributeType(paramString);
    if (l > 0L)
      return l;
    types.add(paramString);
    return 1L << -1 + types.size;
  }

  public abstract Attribute copy();

  protected boolean equals(Attribute paramAttribute)
  {
    return paramAttribute.hashCode() == hashCode();
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    Attribute localAttribute;
    do
    {
      do
      {
        return false;
        if (paramObject == this)
          return true;
      }
      while (!(paramObject instanceof Attribute));
      localAttribute = (Attribute)paramObject;
    }
    while (this.type != localAttribute.type);
    return equals(localAttribute);
  }

  public int hashCode()
  {
    return 7489 * this.typeBit;
  }

  public String toString()
  {
    return getAttributeAlias(this.type);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.Attribute
 * JD-Core Version:    0.6.0
 */