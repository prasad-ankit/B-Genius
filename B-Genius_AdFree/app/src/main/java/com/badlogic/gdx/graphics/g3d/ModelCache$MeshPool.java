package com.badlogic.gdx.graphics.g3d;

import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.Disposable;

public abstract interface ModelCache$MeshPool extends Disposable
{
  public abstract void flush();

  public abstract Mesh obtain(VertexAttributes paramVertexAttributes, int paramInt1, int paramInt2);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.ModelCache.MeshPool
 * JD-Core Version:    0.6.0
 */