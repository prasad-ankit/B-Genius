package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class FrameBuffer extends GLFrameBuffer
{
  public FrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(paramFormat, paramInt1, paramInt2, paramBoolean, false);
  }

  public FrameBuffer(Pixmap.Format paramFormat, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramFormat, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  public static void unbind()
  {
    GLFrameBuffer.unbind();
  }

  protected Texture createColorTexture()
  {
    Texture localTexture = new Texture(this.width, this.height, this.format);
    localTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    localTexture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
    return localTexture;
  }

  protected void disposeColorTexture(Texture paramTexture)
  {
    paramTexture.dispose();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.FrameBuffer
 * JD-Core Version:    0.6.0
 */