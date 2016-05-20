package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Pool.Poolable;

public class MeshPartBuilder$VertexInfo
  implements Pool.Poolable
{
  public final Color color = new Color(1.0F, 1.0F, 1.0F, 1.0F);
  public boolean hasColor;
  public boolean hasNormal;
  public boolean hasPosition;
  public boolean hasUV;
  public final Vector3 normal = new Vector3(0.0F, 1.0F, 0.0F);
  public final Vector3 position = new Vector3();
  public final Vector2 uv = new Vector2();

  public VertexInfo lerp(VertexInfo paramVertexInfo, float paramFloat)
  {
    if ((this.hasPosition) && (paramVertexInfo.hasPosition))
      this.position.lerp(paramVertexInfo.position, paramFloat);
    if ((this.hasNormal) && (paramVertexInfo.hasNormal))
      this.normal.lerp(paramVertexInfo.normal, paramFloat);
    if ((this.hasColor) && (paramVertexInfo.hasColor))
      this.color.lerp(paramVertexInfo.color, paramFloat);
    if ((this.hasUV) && (paramVertexInfo.hasUV))
      this.uv.lerp(paramVertexInfo.uv, paramFloat);
    return this;
  }

  public void reset()
  {
    this.position.set(0.0F, 0.0F, 0.0F);
    this.normal.set(0.0F, 1.0F, 0.0F);
    this.color.set(1.0F, 1.0F, 1.0F, 1.0F);
    this.uv.set(0.0F, 0.0F);
  }

  public VertexInfo set(VertexInfo paramVertexInfo)
  {
    if (paramVertexInfo == null)
      return set(null, null, null, null);
    this.hasPosition = paramVertexInfo.hasPosition;
    this.position.set(paramVertexInfo.position);
    this.hasNormal = paramVertexInfo.hasNormal;
    this.normal.set(paramVertexInfo.normal);
    this.hasColor = paramVertexInfo.hasColor;
    this.color.set(paramVertexInfo.color);
    this.hasUV = paramVertexInfo.hasUV;
    this.uv.set(paramVertexInfo.uv);
    return this;
  }

  public VertexInfo set(Vector3 paramVector31, Vector3 paramVector32, Color paramColor, Vector2 paramVector2)
  {
    reset();
    boolean bool1;
    boolean bool2;
    if (paramVector31 != null)
    {
      bool1 = true;
      this.hasPosition = bool1;
      if (bool1 == true)
        this.position.set(paramVector31);
      if (paramVector32 == null)
        break label129;
      bool2 = true;
      label39: this.hasNormal = bool2;
      if (bool2 == true)
        this.normal.set(paramVector32);
      if (paramColor == null)
        break label135;
    }
    label129: label135: for (boolean bool3 = true; ; bool3 = false)
    {
      this.hasColor = bool3;
      if (bool3 == true)
        this.color.set(paramColor);
      boolean bool4 = false;
      if (paramVector2 != null)
        bool4 = true;
      this.hasUV = bool4;
      if (bool4 == true)
        this.uv.set(paramVector2);
      return this;
      bool1 = false;
      break;
      bool2 = false;
      break label39;
    }
  }

  public VertexInfo setCol(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.color.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.hasColor = true;
    return this;
  }

  public VertexInfo setCol(Color paramColor)
  {
    if (paramColor != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasColor = bool;
      if (bool == true)
        this.color.set(paramColor);
      return this;
    }
  }

  public VertexInfo setNor(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.normal.set(paramFloat1, paramFloat2, paramFloat3);
    this.hasNormal = true;
    return this;
  }

  public VertexInfo setNor(Vector3 paramVector3)
  {
    if (paramVector3 != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasNormal = bool;
      if (bool == true)
        this.normal.set(paramVector3);
      return this;
    }
  }

  public VertexInfo setPos(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.position.set(paramFloat1, paramFloat2, paramFloat3);
    this.hasPosition = true;
    return this;
  }

  public VertexInfo setPos(Vector3 paramVector3)
  {
    if (paramVector3 != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasPosition = bool;
      if (bool == true)
        this.position.set(paramVector3);
      return this;
    }
  }

  public VertexInfo setUV(float paramFloat1, float paramFloat2)
  {
    this.uv.set(paramFloat1, paramFloat2);
    this.hasUV = true;
    return this;
  }

  public VertexInfo setUV(Vector2 paramVector2)
  {
    if (paramVector2 != null);
    for (boolean bool = true; ; bool = false)
    {
      this.hasUV = bool;
      if (bool == true)
        this.uv.set(paramVector2);
      return this;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder.VertexInfo
 * JD-Core Version:    0.6.0
 */