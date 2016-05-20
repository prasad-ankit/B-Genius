package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class CubemapAttribute extends Attribute
{
  public static final long EnvironmentMap = 0L;
  public static final String EnvironmentMapAlias = "environmentMapTexture";
  protected static long Mask;
  public final TextureDescriptor textureDescription;

  static
  {
    long l = register("environmentMapTexture");
    EnvironmentMap = l;
    Mask = l;
  }

  public CubemapAttribute(long paramLong)
  {
    super(paramLong);
    if (!is(paramLong))
      throw new GdxRuntimeException("Invalid type specified");
    this.textureDescription = new TextureDescriptor();
  }

  public CubemapAttribute(long paramLong, Cubemap paramCubemap)
  {
    this(paramLong);
    this.textureDescription.texture = paramCubemap;
  }

  public CubemapAttribute(long paramLong, TextureDescriptor paramTextureDescriptor)
  {
    this(paramLong);
    this.textureDescription.set(paramTextureDescriptor);
  }

  public CubemapAttribute(CubemapAttribute paramCubemapAttribute)
  {
    this(paramCubemapAttribute.type, paramCubemapAttribute.textureDescription);
  }

  public static final boolean is(long paramLong)
  {
    return (paramLong & Mask) != 0L;
  }

  public int compareTo(Attribute paramAttribute)
  {
    if (this.type != paramAttribute.type)
      return (int)(this.type - paramAttribute.type);
    return this.textureDescription.compareTo(((CubemapAttribute)paramAttribute).textureDescription);
  }

  public Attribute copy()
  {
    return new CubemapAttribute(this);
  }

  public int hashCode()
  {
    return 967 * super.hashCode() + this.textureDescription.hashCode();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.CubemapAttribute
 * JD-Core Version:    0.6.0
 */