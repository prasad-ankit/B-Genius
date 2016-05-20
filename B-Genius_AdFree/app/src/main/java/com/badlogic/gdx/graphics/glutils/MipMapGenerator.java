package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Blending;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;

public class MipMapGenerator
{
  private static boolean useHWMipMap = true;

  public static void generateMipMap(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3)
  {
    if (!useHWMipMap)
    {
      generateMipMapCPU(paramInt1, paramPixmap, paramInt2, paramInt3);
      return;
    }
    if ((Gdx.app.getType() == Application.ApplicationType.Android) || (Gdx.app.getType() == Application.ApplicationType.WebGL) || (Gdx.app.getType() == Application.ApplicationType.iOS))
    {
      generateMipMapGLES20(paramInt1, paramPixmap);
      return;
    }
    generateMipMapDesktop(paramInt1, paramPixmap, paramInt2, paramInt3);
  }

  public static void generateMipMap(Pixmap paramPixmap, int paramInt1, int paramInt2)
  {
    generateMipMap(3553, paramPixmap, paramInt1, paramInt2);
  }

  private static void generateMipMapCPU(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3)
  {
    Gdx.gl.glTexImage2D(paramInt1, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
    if ((Gdx.gl20 == null) && (paramInt2 != paramInt3))
      throw new GdxRuntimeException("texture width and height must be square when using mipmapping.");
    int i = paramPixmap.getWidth() / 2;
    int j = paramPixmap.getHeight() / 2;
    Pixmap.Blending localBlending = Pixmap.getBlending();
    Pixmap.setBlending(Pixmap.Blending.None);
    int k = 1;
    Pixmap localPixmap;
    for (Object localObject = paramPixmap; (i > 0) && (j > 0); localObject = localPixmap)
    {
      localPixmap = new Pixmap(i, j, ((Pixmap)localObject).getFormat());
      localPixmap.drawPixmap((Pixmap)localObject, 0, 0, ((Pixmap)localObject).getWidth(), ((Pixmap)localObject).getHeight(), 0, 0, i, j);
      if (k > 1)
        ((Pixmap)localObject).dispose();
      GL20 localGL20 = Gdx.gl;
      int m = localPixmap.getGLInternalFormat();
      int n = localPixmap.getWidth();
      int i1 = localPixmap.getHeight();
      int i2 = localPixmap.getGLFormat();
      int i3 = localPixmap.getGLType();
      ByteBuffer localByteBuffer = localPixmap.getPixels();
      localGL20.glTexImage2D(paramInt1, k, m, n, i1, 0, i2, i3, localByteBuffer);
      i = localPixmap.getWidth() / 2;
      j = localPixmap.getHeight() / 2;
      k++;
    }
    Pixmap.setBlending(localBlending);
  }

  private static void generateMipMapDesktop(int paramInt1, Pixmap paramPixmap, int paramInt2, int paramInt3)
  {
    if ((Gdx.graphics.supportsExtension("GL_ARB_framebuffer_object")) || (Gdx.graphics.supportsExtension("GL_EXT_framebuffer_object")) || (Gdx.gl30 != null))
    {
      Gdx.gl.glTexImage2D(paramInt1, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
      Gdx.gl20.glGenerateMipmap(paramInt1);
      return;
    }
    generateMipMapCPU(paramInt1, paramPixmap, paramInt2, paramInt3);
  }

  private static void generateMipMapGLES20(int paramInt, Pixmap paramPixmap)
  {
    Gdx.gl.glTexImage2D(paramInt, 0, paramPixmap.getGLInternalFormat(), paramPixmap.getWidth(), paramPixmap.getHeight(), 0, paramPixmap.getGLFormat(), paramPixmap.getGLType(), paramPixmap.getPixels());
    Gdx.gl20.glGenerateMipmap(paramInt);
  }

  public static void setUseHardwareMipMap(boolean paramBoolean)
  {
    useHWMipMap = paramBoolean;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.MipMapGenerator
 * JD-Core Version:    0.6.0
 */