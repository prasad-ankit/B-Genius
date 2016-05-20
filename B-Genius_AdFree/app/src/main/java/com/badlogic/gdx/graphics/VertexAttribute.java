package com.badlogic.gdx.graphics;

public final class VertexAttribute
{
  public String alias;
  public final boolean normalized;
  public final int numComponents;
  public int offset;
  public final int type;
  public int unit;
  public final int usage;
  private final int usageIndex;

  private VertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString)
  {
    this(paramInt1, paramInt2, paramInt3, paramBoolean, paramString, 0);
  }

  private VertexAttribute(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString, int paramInt4)
  {
    this.usage = paramInt1;
    this.numComponents = paramInt2;
    this.type = paramInt3;
    this.normalized = paramBoolean;
    this.alias = paramString;
    this.unit = paramInt4;
    this.usageIndex = Integer.numberOfTrailingZeros(paramInt1);
  }

  public VertexAttribute(int paramInt1, int paramInt2, String paramString)
  {
    this(paramInt1, paramInt2, paramString, 0);
  }

  public VertexAttribute(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
  }

  public static VertexAttribute Binormal()
  {
    return new VertexAttribute(256, 3, "a_binormal");
  }

  public static VertexAttribute BoneWeight(int paramInt)
  {
    return new VertexAttribute(64, 2, "a_boneWeight" + paramInt, paramInt);
  }

  public static VertexAttribute ColorPacked()
  {
    return new VertexAttribute(4, 4, 5121, true, "a_color");
  }

  public static VertexAttribute ColorUnpacked()
  {
    return new VertexAttribute(2, 4, 5126, false, "a_color");
  }

  public static VertexAttribute Normal()
  {
    return new VertexAttribute(8, 3, "a_normal");
  }

  public static VertexAttribute Position()
  {
    return new VertexAttribute(1, 3, "a_position");
  }

  public static VertexAttribute Tangent()
  {
    return new VertexAttribute(128, 3, "a_tangent");
  }

  public static VertexAttribute TexCoords(int paramInt)
  {
    return new VertexAttribute(16, 2, "a_texCoord" + paramInt, paramInt);
  }

  public final boolean equals(VertexAttribute paramVertexAttribute)
  {
    return (paramVertexAttribute != null) && (this.usage == paramVertexAttribute.usage) && (this.numComponents == paramVertexAttribute.numComponents) && (this.alias.equals(paramVertexAttribute.alias)) && (this.unit == paramVertexAttribute.unit);
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof VertexAttribute))
      return false;
    return equals((VertexAttribute)paramObject);
  }

  public final int getKey()
  {
    return (this.usageIndex << 8) + (0xFF & this.unit);
  }

  public final int hashCode()
  {
    return 541 * (541 * getKey() + this.numComponents) + this.alias.hashCode();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.VertexAttribute
 * JD-Core Version:    0.6.0
 */