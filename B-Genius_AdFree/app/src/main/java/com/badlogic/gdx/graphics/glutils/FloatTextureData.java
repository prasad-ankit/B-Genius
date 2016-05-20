package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.TextureDataType;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.FloatBuffer;

public class FloatTextureData
  implements TextureData
{
  FloatBuffer buffer;
  int height = 0;
  boolean isPrepared = false;
  int width = 0;

  public FloatTextureData(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public void consumeCustomData(int paramInt)
  {
    if (!Gdx.graphics.supportsExtension("texture_float"))
      throw new GdxRuntimeException("Extension OES_TEXTURE_FLOAT not supported!");
    if ((Gdx.app.getType() == Application.ApplicationType.Android) || (Gdx.app.getType() == Application.ApplicationType.iOS) || (Gdx.app.getType() == Application.ApplicationType.WebGL))
    {
      Gdx.gl.glTexImage2D(paramInt, 0, 6408, this.width, this.height, 0, 6408, 5126, this.buffer);
      return;
    }
    Gdx.gl.glTexImage2D(paramInt, 0, 34836, this.width, this.height, 0, 6408, 5126, this.buffer);
  }

  public Pixmap consumePixmap()
  {
    throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
  }

  public boolean disposePixmap()
  {
    throw new GdxRuntimeException("This TextureData implementation does not return a Pixmap");
  }

  public Pixmap.Format getFormat()
  {
    return Pixmap.Format.RGBA8888;
  }

  public int getHeight()
  {
    return this.height;
  }

  public TextureData.TextureDataType getType()
  {
    return TextureData.TextureDataType.Custom;
  }

  public int getWidth()
  {
    return this.width;
  }

  public boolean isManaged()
  {
    return true;
  }

  public boolean isPrepared()
  {
    return this.isPrepared;
  }

  public void prepare()
  {
    if (this.isPrepared)
      throw new GdxRuntimeException("Already prepared");
    this.buffer = BufferUtils.newFloatBuffer(this.width * this.height << 2);
    this.isPrepared = true;
  }

  public boolean useMipMaps()
  {
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.FloatTextureData
 * JD-Core Version:    0.6.0
 */