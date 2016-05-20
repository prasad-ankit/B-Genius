package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.IntBuffer;

public final class DefaultTextureBinder
  implements TextureBinder
{
  public static final int MAX_GLES_UNITS = 32;
  public static final int ROUNDROBIN = 0;
  public static final int WEIGHTED = 1;
  private int bindCount = 0;
  private final int count;
  private int currentTexture = 0;
  private final int method;
  private final int offset;
  private int reuseCount = 0;
  private final int reuseWeight;
  private boolean reused;
  private final TextureDescriptor tempDesc = new TextureDescriptor();
  private final GLTexture[] textures;
  private final int[] weights;

  public DefaultTextureBinder(int paramInt)
  {
    this(paramInt, 0);
  }

  public DefaultTextureBinder(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, -1);
  }

  public DefaultTextureBinder(int paramInt1, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramInt2, paramInt3, 10);
  }

  public DefaultTextureBinder(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = Math.min(getMaxTextureUnits(), 32);
    if (paramInt3 < 0)
      paramInt3 = i - paramInt2;
    if ((paramInt2 < 0) || (paramInt3 < 0) || (paramInt2 + paramInt3 > i) || (paramInt4 <= 0))
      throw new GdxRuntimeException("Illegal arguments");
    this.method = paramInt1;
    this.offset = paramInt2;
    this.count = paramInt3;
    this.textures = new GLTexture[paramInt3];
    this.reuseWeight = paramInt4;
    if (paramInt1 == 1);
    for (int[] arrayOfInt = new int[paramInt3]; ; arrayOfInt = null)
    {
      this.weights = arrayOfInt;
      return;
    }
  }

  private final int bindTexture(TextureDescriptor paramTextureDescriptor, boolean paramBoolean)
  {
    GLTexture localGLTexture = paramTextureDescriptor.texture;
    this.reused = false;
    int i;
    switch (this.method)
    {
    default:
      return -1;
    case 0:
      i = this.offset + bindTextureRoundRobin(localGLTexture);
      if (this.reused)
      {
        this.reuseCount = (1 + this.reuseCount);
        if (!paramBoolean)
          break;
        localGLTexture.bind(i);
      }
    case 1:
    }
    while (true)
    {
      localGLTexture.unsafeSetWrap(paramTextureDescriptor.uWrap, paramTextureDescriptor.vWrap);
      localGLTexture.unsafeSetFilter(paramTextureDescriptor.minFilter, paramTextureDescriptor.magFilter);
      return i;
      i = this.offset + bindTextureWeighted(localGLTexture);
      break;
      Gdx.gl.glActiveTexture(33984 + i);
      continue;
      this.bindCount = (1 + this.bindCount);
    }
  }

  private final int bindTextureRoundRobin(GLTexture paramGLTexture)
  {
    for (int i = 0; i < this.count; i++)
    {
      int j = (i + this.currentTexture) % this.count;
      if (this.textures[j] != paramGLTexture)
        continue;
      this.reused = true;
      return j;
    }
    this.currentTexture = ((1 + this.currentTexture) % this.count);
    this.textures[this.currentTexture] = paramGLTexture;
    paramGLTexture.bind(this.offset + this.currentTexture);
    return this.currentTexture;
  }

  private final int bindTextureWeighted(GLTexture paramGLTexture)
  {
    int i = 0;
    int j = this.weights[0];
    int k = -1;
    int m = j;
    int n = 0;
    if (i < this.count)
    {
      if (this.textures[i] == paramGLTexture)
      {
        int[] arrayOfInt2 = this.weights;
        arrayOfInt2[i] += this.reuseWeight;
        k = i;
      }
      while (true)
      {
        i++;
        break;
        if (this.weights[i] >= 0)
        {
          int[] arrayOfInt1 = this.weights;
          int i1 = -1 + arrayOfInt1[i];
          arrayOfInt1[i] = i1;
          if (i1 >= m)
            continue;
        }
        m = this.weights[i];
        n = i;
      }
    }
    if (k < 0)
    {
      this.textures[n] = paramGLTexture;
      this.weights[n] = 100;
      paramGLTexture.bind(n + this.offset);
      return n;
    }
    this.reused = true;
    return k;
  }

  private static int getMaxTextureUnits()
  {
    IntBuffer localIntBuffer = BufferUtils.newIntBuffer(16);
    Gdx.gl.glGetIntegerv(34930, localIntBuffer);
    return localIntBuffer.get(0);
  }

  public final void begin()
  {
    for (int i = 0; i < this.count; i++)
    {
      this.textures[i] = null;
      if (this.weights == null)
        continue;
      this.weights[i] = 0;
    }
  }

  public final int bind(GLTexture paramGLTexture)
  {
    this.tempDesc.set(paramGLTexture, null, null, null, null);
    return bindTexture(this.tempDesc, false);
  }

  public final int bind(TextureDescriptor paramTextureDescriptor)
  {
    return bindTexture(paramTextureDescriptor, false);
  }

  public final void end()
  {
    Gdx.gl.glActiveTexture(33984);
  }

  public final int getBindCount()
  {
    return this.bindCount;
  }

  public final int getReuseCount()
  {
    return this.reuseCount;
  }

  public final void resetCounts()
  {
    this.reuseCount = 0;
    this.bindCount = 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.DefaultTextureBinder
 * JD-Core Version:    0.6.0
 */