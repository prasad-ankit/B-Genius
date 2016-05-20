package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.MipMapGenerator;
import com.badlogic.gdx.utils.Disposable;

public abstract class GLTexture
  implements Disposable
{
  protected int glHandle;
  public final int glTarget;
  protected Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
  protected Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
  protected Texture.TextureWrap uWrap = Texture.TextureWrap.ClampToEdge;
  protected Texture.TextureWrap vWrap = Texture.TextureWrap.ClampToEdge;

  public GLTexture(int paramInt)
  {
    this(paramInt, Gdx.gl.glGenTexture());
  }

  public GLTexture(int paramInt1, int paramInt2)
  {
    this.glTarget = paramInt1;
    this.glHandle = paramInt2;
  }

  protected static void uploadImageData(int paramInt, TextureData paramTextureData)
  {
    uploadImageData(paramInt, paramTextureData, 0);
  }

  public static void uploadImageData(int paramInt1, TextureData paramTextureData, int paramInt2)
  {
    if (paramTextureData == null);
    while (true)
    {
      return;
      if (!paramTextureData.isPrepared())
        paramTextureData.prepare();
      if (paramTextureData.getType() == TextureData.TextureDataType.Custom)
      {
        paramTextureData.consumeCustomData(paramInt1);
        return;
      }
      Object localObject = paramTextureData.consumePixmap();
      boolean bool = paramTextureData.disposePixmap();
      if (paramTextureData.getFormat() != ((Pixmap)localObject).getFormat())
      {
        Pixmap localPixmap = new Pixmap(((Pixmap)localObject).getWidth(), ((Pixmap)localObject).getHeight(), paramTextureData.getFormat());
        Pixmap.Blending localBlending = Pixmap.getBlending();
        Pixmap.setBlending(Pixmap.Blending.None);
        localPixmap.drawPixmap((Pixmap)localObject, 0, 0, 0, 0, ((Pixmap)localObject).getWidth(), ((Pixmap)localObject).getHeight());
        Pixmap.setBlending(localBlending);
        if (paramTextureData.disposePixmap())
          ((Pixmap)localObject).dispose();
        localObject = localPixmap;
        bool = true;
      }
      Gdx.gl.glPixelStorei(3317, 1);
      if (paramTextureData.useMipMaps())
        MipMapGenerator.generateMipMap(paramInt1, (Pixmap)localObject, ((Pixmap)localObject).getWidth(), ((Pixmap)localObject).getHeight());
      while (bool)
      {
        ((Pixmap)localObject).dispose();
        return;
        Gdx.gl.glTexImage2D(paramInt1, paramInt2, ((Pixmap)localObject).getGLInternalFormat(), ((Pixmap)localObject).getWidth(), ((Pixmap)localObject).getHeight(), 0, ((Pixmap)localObject).getGLFormat(), ((Pixmap)localObject).getGLType(), ((Pixmap)localObject).getPixels());
      }
    }
  }

  public void bind()
  {
    Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
  }

  public void bind(int paramInt)
  {
    Gdx.gl.glActiveTexture(33984 + paramInt);
    Gdx.gl.glBindTexture(this.glTarget, this.glHandle);
  }

  protected void delete()
  {
    if (this.glHandle != 0)
    {
      Gdx.gl.glDeleteTexture(this.glHandle);
      this.glHandle = 0;
    }
  }

  public void dispose()
  {
    delete();
  }

  public abstract int getDepth();

  public abstract int getHeight();

  public Texture.TextureFilter getMagFilter()
  {
    return this.magFilter;
  }

  public Texture.TextureFilter getMinFilter()
  {
    return this.minFilter;
  }

  public int getTextureObjectHandle()
  {
    return this.glHandle;
  }

  public Texture.TextureWrap getUWrap()
  {
    return this.uWrap;
  }

  public Texture.TextureWrap getVWrap()
  {
    return this.vWrap;
  }

  public abstract int getWidth();

  public abstract boolean isManaged();

  protected abstract void reload();

  public void setFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2)
  {
    this.minFilter = paramTextureFilter1;
    this.magFilter = paramTextureFilter2;
    bind();
    Gdx.gl.glTexParameterf(this.glTarget, 10241, paramTextureFilter1.getGLEnum());
    Gdx.gl.glTexParameterf(this.glTarget, 10240, paramTextureFilter2.getGLEnum());
  }

  public void setWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2)
  {
    this.uWrap = paramTextureWrap1;
    this.vWrap = paramTextureWrap2;
    bind();
    Gdx.gl.glTexParameterf(this.glTarget, 10242, paramTextureWrap1.getGLEnum());
    Gdx.gl.glTexParameterf(this.glTarget, 10243, paramTextureWrap2.getGLEnum());
  }

  public void unsafeSetFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2)
  {
    unsafeSetFilter(paramTextureFilter1, paramTextureFilter2, false);
  }

  public void unsafeSetFilter(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    if ((paramTextureFilter1 != null) && ((paramBoolean) || (this.minFilter != paramTextureFilter1)))
    {
      Gdx.gl.glTexParameterf(this.glTarget, 10241, paramTextureFilter1.getGLEnum());
      this.minFilter = paramTextureFilter1;
    }
    if ((paramTextureFilter2 != null) && ((paramBoolean) || (this.magFilter != paramTextureFilter2)))
    {
      Gdx.gl.glTexParameterf(this.glTarget, 10240, paramTextureFilter2.getGLEnum());
      this.magFilter = paramTextureFilter2;
    }
  }

  public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2)
  {
    unsafeSetWrap(paramTextureWrap1, paramTextureWrap2, false);
  }

  public void unsafeSetWrap(Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2, boolean paramBoolean)
  {
    if ((paramTextureWrap1 != null) && ((paramBoolean) || (this.uWrap != paramTextureWrap1)))
    {
      Gdx.gl.glTexParameterf(this.glTarget, 10242, paramTextureWrap1.getGLEnum());
      this.uWrap = paramTextureWrap1;
    }
    if ((paramTextureWrap2 != null) && ((paramBoolean) || (this.vWrap != paramTextureWrap2)))
    {
      Gdx.gl.glTexParameterf(this.glTarget, 10243, paramTextureWrap2.getGLEnum());
      this.vWrap = paramTextureWrap2;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.GLTexture
 * JD-Core Version:    0.6.0
 */