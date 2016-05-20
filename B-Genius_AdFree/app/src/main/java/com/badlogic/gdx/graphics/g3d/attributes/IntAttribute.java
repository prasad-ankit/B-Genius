package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;

public class IntAttribute extends Attribute
{
  public static final long CullFace = 0L;
  public static final String CullFaceAlias = "cullface";
  public int value;

  public IntAttribute(long paramLong)
  {
    super(paramLong);
  }

  public IntAttribute(long paramLong, int paramInt)
  {
    super(paramLong);
    this.value = paramInt;
  }

  public static IntAttribute createCullFace(int paramInt)
  {
    return new IntAttribute(CullFace, paramInt);
  }

  public int compareTo(Attribute paramAttribute)
  {
    if (this.type != paramAttribute.type)
      return (int)(this.type - paramAttribute.type);
    return this.value - ((IntAttribute)paramAttribute).value;
  }

  public Attribute copy()
  {
    return new IntAttribute(this.type, this.value);
  }

  public int hashCode()
  {
    return 983 * super.hashCode() + this.value;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.IntAttribute
 * JD-Core Version:    0.6.0
 */