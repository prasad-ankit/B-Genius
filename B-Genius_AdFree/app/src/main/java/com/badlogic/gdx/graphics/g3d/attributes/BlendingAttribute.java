package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.NumberUtils;

public class BlendingAttribute extends Attribute
{
  public static final String Alias = "blended";
  public static final long Type = register("blended");
  public boolean blended;
  public int destFunction;
  public float opacity = 1.0F;
  public int sourceFunction;

  public BlendingAttribute()
  {
    this(null);
  }

  public BlendingAttribute(float paramFloat)
  {
    this(true, paramFloat);
  }

  public BlendingAttribute(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, 1.0F);
  }

  public BlendingAttribute(int paramInt1, int paramInt2, float paramFloat)
  {
    this(true, paramInt1, paramInt2, paramFloat);
  }

  public BlendingAttribute(BlendingAttribute paramBlendingAttribute)
  {
  }

  public BlendingAttribute(boolean paramBoolean, float paramFloat)
  {
    this(paramBoolean, 770, 771, paramFloat);
  }

  public BlendingAttribute(boolean paramBoolean, int paramInt1, int paramInt2, float paramFloat)
  {
    super(Type);
    this.blended = paramBoolean;
    this.sourceFunction = paramInt1;
    this.destFunction = paramInt2;
    this.opacity = paramFloat;
  }

  public static final boolean is(long paramLong)
  {
    return (paramLong & Type) == paramLong;
  }

  public int compareTo(Attribute paramAttribute)
  {
    int i = 1;
    if (this.type != paramAttribute.type)
      i = (int)(this.type - paramAttribute.type);
    BlendingAttribute localBlendingAttribute;
    do
    {
      while (true)
      {
        return i;
        localBlendingAttribute = (BlendingAttribute)paramAttribute;
        if (this.blended == localBlendingAttribute.blended)
          break;
        if (!this.blended)
          return -1;
      }
      if (this.sourceFunction != localBlendingAttribute.sourceFunction)
        return this.sourceFunction - localBlendingAttribute.sourceFunction;
      if (this.destFunction != localBlendingAttribute.destFunction)
        return this.destFunction - localBlendingAttribute.destFunction;
      if (MathUtils.isEqual(this.opacity, localBlendingAttribute.opacity))
        return 0;
    }
    while (this.opacity < localBlendingAttribute.opacity);
    return -1;
  }

  public BlendingAttribute copy()
  {
    return new BlendingAttribute(this);
  }

  public int hashCode()
  {
    int i = 947 * super.hashCode();
    if (this.blended);
    for (int j = 1; ; j = 0)
      return 947 * (947 * (947 * (j + i) + this.sourceFunction) + this.destFunction) + NumberUtils.floatToRawIntBits(this.opacity);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute
 * JD-Core Version:    0.6.0
 */