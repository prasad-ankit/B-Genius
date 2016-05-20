package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Cubemap.CubemapSide;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class FrameBufferCubemap extends GLFrameBuffer
{
  private int currentSide;

  public FrameBufferCubemap(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramFormat, paramInt1, paramInt2, paramBoolean, false);
  }

  public FrameBufferCubemap(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFormat, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  public void bind()
  {
    this.currentSide = -1;
    super.bind();
  }

  protected void bindSide(Cubemap.CubemapSide paramCubemapSide)
  {
    Gdx.gl20.glFramebufferTexture2D(36160, 36064, paramCubemapSide.glEnum, ((Cubemap)this.colorTexture).getTextureObjectHandle(), 0);
  }

  protected Cubemap createColorTexture()
  {
    Cubemap localCubemap = new Cubemap(this.width, this.height, this.width, this.format);
    localCubemap.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    localCubemap.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
    return localCubemap;
  }

  protected void disposeColorTexture(Cubemap paramCubemap)
  {
    paramCubemap.dispose();
  }

  public Cubemap.CubemapSide getSide()
  {
    if (this.currentSide < 0)
      return null;
    return Cubemap.CubemapSide.values()[this.currentSide];
  }

  public boolean nextSide()
  {
    if (this.currentSide > 5)
      throw new GdxRuntimeException("No remaining sides.");
    if (this.currentSide == 5)
      return false;
    this.currentSide = (1 + this.currentSide);
    bindSide(getSide());
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.FrameBufferCubemap
 * JD-Core Version:    0.6.0
 */