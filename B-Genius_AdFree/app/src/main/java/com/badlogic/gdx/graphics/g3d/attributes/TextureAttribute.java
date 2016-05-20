package com.badlogic.gdx.graphics.g3d.attributes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Attribute;
import com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;

public class TextureAttribute extends Attribute
{
  public static final long Ambient = 0L;
  public static final String AmbientAlias = "ambientTexture";
  public static final long Bump = 0L;
  public static final String BumpAlias = "bumpTexture";
  public static final long Diffuse = 0L;
  public static final String DiffuseAlias = "diffuseTexture";
  public static final long Emissive = 0L;
  public static final String EmissiveAlias = "emissiveTexture";
  protected static long Mask = 0L;
  public static final long Normal = 0L;
  public static final String NormalAlias = "normalTexture";
  public static final long Reflection = 0L;
  public static final String ReflectionAlias = "reflectionTexture";
  public static final long Specular = 0L;
  public static final String SpecularAlias = "specularTexture";
  public float offsetU = 0.0F;
  public float offsetV = 0.0F;
  public float scaleU = 1.0F;
  public float scaleV = 1.0F;
  public final TextureDescriptor textureDescription;
  public int uvIndex = 0;

  static
  {
    Bump = register("bumpTexture");
    Normal = register("normalTexture");
    Ambient = register("ambientTexture");
    Emissive = register("emissiveTexture");
    Reflection = register("reflectionTexture");
    Mask = Diffuse | Specular | Bump | Normal | Ambient | Emissive | Reflection;
  }

  public TextureAttribute(long paramLong)
  {
    super(paramLong);
    if (!is(paramLong))
      throw new GdxRuntimeException("Invalid type specified");
    this.textureDescription = new TextureDescriptor();
  }

  public TextureAttribute(long paramLong, Texture paramTexture)
  {
    this(paramLong);
    this.textureDescription.texture = paramTexture;
  }

  public TextureAttribute(long paramLong, TextureRegion paramTextureRegion)
  {
    this(paramLong);
    set(paramTextureRegion);
  }

  public TextureAttribute(long paramLong, TextureDescriptor paramTextureDescriptor)
  {
    this(paramLong);
    this.textureDescription.set(paramTextureDescriptor);
  }

  public TextureAttribute(long paramLong, TextureDescriptor paramTextureDescriptor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this(paramLong, paramTextureDescriptor, paramFloat1, paramFloat2, paramFloat3, paramFloat4, 0);
  }

  public TextureAttribute(long paramLong, TextureDescriptor paramTextureDescriptor, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    this(paramLong, paramTextureDescriptor);
    this.offsetU = paramFloat1;
    this.offsetV = paramFloat2;
    this.scaleU = paramFloat3;
    this.scaleV = paramFloat4;
    this.uvIndex = paramInt;
  }

  public TextureAttribute(TextureAttribute paramTextureAttribute)
  {
    this(paramTextureAttribute.type, paramTextureAttribute.textureDescription, paramTextureAttribute.offsetU, paramTextureAttribute.offsetV, paramTextureAttribute.scaleU, paramTextureAttribute.scaleV, paramTextureAttribute.uvIndex);
  }

  public static TextureAttribute createAmbient(Texture paramTexture)
  {
    return new TextureAttribute(Ambient, paramTexture);
  }

  public static TextureAttribute createAmbient(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Ambient, paramTextureRegion);
  }

  public static TextureAttribute createBump(Texture paramTexture)
  {
    return new TextureAttribute(Bump, paramTexture);
  }

  public static TextureAttribute createBump(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Bump, paramTextureRegion);
  }

  public static TextureAttribute createDiffuse(Texture paramTexture)
  {
    return new TextureAttribute(Diffuse, paramTexture);
  }

  public static TextureAttribute createDiffuse(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Diffuse, paramTextureRegion);
  }

  public static TextureAttribute createEmissive(Texture paramTexture)
  {
    return new TextureAttribute(Emissive, paramTexture);
  }

  public static TextureAttribute createEmissive(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Emissive, paramTextureRegion);
  }

  public static TextureAttribute createNormal(Texture paramTexture)
  {
    return new TextureAttribute(Normal, paramTexture);
  }

  public static TextureAttribute createNormal(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Normal, paramTextureRegion);
  }

  public static TextureAttribute createReflection(Texture paramTexture)
  {
    return new TextureAttribute(Reflection, paramTexture);
  }

  public static TextureAttribute createReflection(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Reflection, paramTextureRegion);
  }

  public static TextureAttribute createSpecular(Texture paramTexture)
  {
    return new TextureAttribute(Specular, paramTexture);
  }

  public static TextureAttribute createSpecular(TextureRegion paramTextureRegion)
  {
    return new TextureAttribute(Specular, paramTextureRegion);
  }

  public static final boolean is(long paramLong)
  {
    return (paramLong & Mask) != 0L;
  }

  public int compareTo(Attribute paramAttribute)
  {
    if (this.type != paramAttribute.type)
      if (this.type >= paramAttribute.type);
    while (true)
    {
      return -1;
      return 1;
      TextureAttribute localTextureAttribute = (TextureAttribute)paramAttribute;
      int i = this.textureDescription.compareTo(localTextureAttribute.textureDescription);
      if (i != 0)
        return i;
      if (this.uvIndex != localTextureAttribute.uvIndex)
        return this.uvIndex - localTextureAttribute.uvIndex;
      if (!MathUtils.isEqual(this.offsetU, localTextureAttribute.offsetU))
        if (this.offsetU < localTextureAttribute.offsetU)
          return 1;
      if (!MathUtils.isEqual(this.offsetV, localTextureAttribute.offsetV))
        if (this.offsetV < localTextureAttribute.offsetV)
          return 1;
      if (!MathUtils.isEqual(this.scaleU, localTextureAttribute.scaleU))
        if (this.scaleU < localTextureAttribute.scaleU)
          return 1;
      if (MathUtils.isEqual(this.scaleV, localTextureAttribute.scaleV))
        break;
      if (this.scaleV < localTextureAttribute.scaleV)
        return 1;
    }
    return 0;
  }

  public Attribute copy()
  {
    return new TextureAttribute(this);
  }

  public int hashCode()
  {
    return 991 * (991 * (991 * (991 * (991 * (991 * super.hashCode() + this.textureDescription.hashCode()) + NumberUtils.floatToRawIntBits(this.offsetU)) + NumberUtils.floatToRawIntBits(this.offsetV)) + NumberUtils.floatToRawIntBits(this.scaleU)) + NumberUtils.floatToRawIntBits(this.scaleV)) + this.uvIndex;
  }

  public void set(TextureRegion paramTextureRegion)
  {
    this.textureDescription.texture = paramTextureRegion.getTexture();
    this.offsetU = paramTextureRegion.getU();
    this.offsetV = paramTextureRegion.getV();
    this.scaleU = (paramTextureRegion.getU2() - this.offsetU);
    this.scaleV = (paramTextureRegion.getV2() - this.offsetV);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute
 * JD-Core Version:    0.6.0
 */