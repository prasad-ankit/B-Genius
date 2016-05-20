package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class FloatFrameBuffer extends FrameBuffer
{
  public FloatFrameBuffer(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(null, paramInt1, paramInt2, paramBoolean);
  }

  protected Texture createColorTexture()
  {
    Texture localTexture = new Texture(new FloatTextureData(this.width, this.height));
    if ((Gdx.app.getType() == Application.ApplicationType.Desktop) || (Gdx.app.getType() == Application.ApplicationType.Applet))
      localTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    while (true)
    {
      localTexture.setWrap(Texture.TextureWrap.ClampToEdge, Texture.TextureWrap.ClampToEdge);
      return localTexture;
      localTexture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
    }
  }

  protected void disposeColorTexture(Texture paramTexture)
  {
    paramTexture.dispose();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.FloatFrameBuffer
 * JD-Core Version:    0.6.0
 */