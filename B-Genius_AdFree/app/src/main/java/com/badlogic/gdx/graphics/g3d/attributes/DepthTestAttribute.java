package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;

public class DepthTestAttribute extends Attribute
{
  public static final String Alias = "depthStencil";
  protected static long Mask;
  public static final long Type;
  public int depthFunc;
  public boolean depthMask;
  public float depthRangeFar;
  public float depthRangeNear;

  static
  {
    long l = register("depthStencil");
    Type = l;
    Mask = l;
  }

  public DepthTestAttribute()
  {
    this(515);
  }

  public DepthTestAttribute(int paramInt)
  {
    this(paramInt, true);
  }

  public DepthTestAttribute(int paramInt, float paramFloat1, float paramFloat2)
  {
    this(paramInt, paramFloat1, paramFloat2, true);
  }

  public DepthTestAttribute(int paramInt, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this(Type, paramInt, paramFloat1, paramFloat2, paramBoolean);
  }

  public DepthTestAttribute(int paramInt, boolean paramBoolean)
  {
    this(paramInt, 0.0F, 1.0F, paramBoolean);
  }

  public DepthTestAttribute(long paramLong, int paramInt, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    super(paramLong);
    if (!is(paramLong))
      throw new GdxRuntimeException("Invalid type specified");
    this.depthFunc = paramInt;
    this.depthRangeNear = paramFloat1;
    this.depthRangeFar = paramFloat2;
    this.depthMask = paramBoolean;
  }

  public DepthTestAttribute(DepthTestAttribute paramDepthTestAttribute)
  {
    this(paramDepthTestAttribute.type, paramDepthTestAttribute.depthFunc, paramDepthTestAttribute.depthRangeNear, paramDepthTestAttribute.depthRangeFar, paramDepthTestAttribute.depthMask);
  }

  public DepthTestAttribute(boolean paramBoolean)
  {
    this(515, paramBoolean);
  }

  public static final boolean is(long paramLong)
  {
    return (paramLong & Mask) != 0L;
  }

  public int compareTo(Attribute paramAttribute)
  {
    int i = -1;
    if (this.type != paramAttribute.type)
      i = (int)(this.type - paramAttribute.type);
    while (true)
    {
      return i;
      DepthTestAttribute localDepthTestAttribute = (DepthTestAttribute)paramAttribute;
      if (this.depthFunc != localDepthTestAttribute.depthFunc)
        return this.depthFunc - localDepthTestAttribute.depthFunc;
      if (this.depthMask != localDepthTestAttribute.depthMask)
        if (!this.depthMask)
          return 1;
      if (!MathUtils.isEqual(this.depthRangeNear, localDepthTestAttribute.depthRangeNear))
        if (this.depthRangeNear >= localDepthTestAttribute.depthRangeNear)
          return 1;
      if (MathUtils.isEqual(this.depthRangeFar, localDepthTestAttribute.depthRangeFar))
        break;
      if (this.depthRangeFar >= localDepthTestAttribute.depthRangeFar)
        return 1;
    }
    return 0;
  }

  public Attribute copy()
  {
    return new DepthTestAttribute(this);
  }

  public int hashCode()
  {
    int i = 971 * (971 * (971 * (971 * super.hashCode() + this.depthFunc) + NumberUtils.floatToRawIntBits(this.depthRangeNear)) + NumberUtils.floatToRawIntBits(this.depthRangeFar));
    if (this.depthMask);
    for (int j = 1; ; j = 0)
      return j + i;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.DepthTestAttribute
 * JD-Core Version:    0.6.0
 */