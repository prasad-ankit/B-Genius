package com.badlogic.gdx.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import java.nio.ByteBuffer;

public final class ScreenUtils
{
  public static byte[] getFrameBufferPixels(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Gdx.gl.glPixelStorei(3333, 1);
    ByteBuffer localByteBuffer = BufferUtils.newByteBuffer(paramInt3 * paramInt4 << 2);
    Gdx.gl.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localByteBuffer);
    byte[] arrayOfByte = new byte[paramInt3 * paramInt4 << 2];
    if (paramBoolean)
    {
      int i = paramInt3 << 2;
      for (int j = 0; j < paramInt4; j++)
      {
        localByteBuffer.position(i * (-1 + (paramInt4 - j)));
        localByteBuffer.get(arrayOfByte, j * i, i);
      }
    }
    localByteBuffer.clear();
    localByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }

  public static byte[] getFrameBufferPixels(boolean paramBoolean)
  {
    return getFrameBufferPixels(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), paramBoolean);
  }

  public static Pixmap getFrameBufferPixmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Gdx.gl.glPixelStorei(3333, 1);
    Pixmap localPixmap = new Pixmap(paramInt3, paramInt4, Pixmap.Format.RGBA8888);
    ByteBuffer localByteBuffer = localPixmap.getPixels();
    Gdx.gl.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localByteBuffer);
    return localPixmap;
  }

  public static TextureRegion getFrameBufferTexture()
  {
    return getFrameBufferTexture(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
  }

  public static TextureRegion getFrameBufferTexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = MathUtils.nextPowerOfTwo(paramInt3);
    int j = MathUtils.nextPowerOfTwo(paramInt4);
    Pixmap localPixmap1 = getFrameBufferPixmap(paramInt1, paramInt2, paramInt3, paramInt4);
    Pixmap localPixmap2 = new Pixmap(i, j, Pixmap.Format.RGBA8888);
    localPixmap2.drawPixmap(localPixmap1, 0, 0);
    TextureRegion localTextureRegion = new TextureRegion(new Texture(localPixmap2), 0, paramInt4, paramInt3, -paramInt4);
    localPixmap2.dispose();
    localPixmap1.dispose();
    return localTextureRegion;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.ScreenUtils
 * JD-Core Version:    0.6.0
 */