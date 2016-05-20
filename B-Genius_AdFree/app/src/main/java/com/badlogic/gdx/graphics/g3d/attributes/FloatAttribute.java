package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.NumberUtils;

public class FloatAttribute extends Attribute
{
  public static final long AlphaTest = 0L;
  public static final String AlphaTestAlias = "alphaTest";
  public static final long Shininess = 0L;
  public static final String ShininessAlias = "shininess";
  public float value;

  static
  {
    AlphaTest = register("alphaTest");
  }

  public FloatAttribute(long paramLong)
  {
    super(paramLong);
  }

  public FloatAttribute(long paramLong, float paramFloat)
  {
    super(paramLong);
    this.value = paramFloat;
  }

  public static FloatAttribute createAlphaTest(float paramFloat)
  {
    return new FloatAttribute(AlphaTest, paramFloat);
  }

  public static FloatAttribute createShininess(float paramFloat)
  {
    return new FloatAttribute(Shininess, paramFloat);
  }

  public int compareTo(Attribute paramAttribute)
  {
    if (this.type != paramAttribute.type)
      return (int)(this.type - paramAttribute.type);
    float f = ((FloatAttribute)paramAttribute).value;
    if (MathUtils.isEqual(this.value, f))
      return 0;
    if (this.value < f)
      return -1;
    return 1;
  }

  public Attribute copy()
  {
    return new FloatAttribute(this.type, this.value);
  }

  public int hashCode()
  {
    return 977 * super.hashCode() + NumberUtils.floatToRawIntBits(this.value);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.FloatAttribute
 * JD-Core Version:    0.6.0
 */