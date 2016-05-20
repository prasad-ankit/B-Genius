package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class TextureDescriptor
  implements Comparable
{
  public Texture.TextureFilter magFilter;
  public Texture.TextureFilter minFilter;
  public GLTexture texture = null;
  public Texture.TextureWrap uWrap;
  public Texture.TextureWrap vWrap;

  public TextureDescriptor()
  {
  }

  public TextureDescriptor(GLTexture paramGLTexture)
  {
    this(paramGLTexture, null, null, null, null);
  }

  public TextureDescriptor(GLTexture paramGLTexture, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2)
  {
    set(paramGLTexture, paramTextureFilter1, paramTextureFilter2, paramTextureWrap1, paramTextureWrap2);
  }

  public int compareTo(TextureDescriptor paramTextureDescriptor)
  {
    if (paramTextureDescriptor == this);
    label45: label56: label101: label113: 
    do
    {
      return 0;
      int i;
      if (this.texture == null)
      {
        i = 0;
        if (paramTextureDescriptor.texture != null)
          break label45;
      }
      for (int j = 0; ; j = paramTextureDescriptor.texture.glTarget)
      {
        if (i == j)
          break label56;
        return i - j;
        i = this.texture.glTarget;
        break;
      }
      int k;
      if (this.texture == null)
      {
        k = 0;
        if (paramTextureDescriptor.texture != null)
          break label101;
      }
      for (int m = 0; ; m = paramTextureDescriptor.texture.getTextureObjectHandle())
      {
        if (k == m)
          break label113;
        return k - m;
        k = this.texture.getTextureObjectHandle();
        break;
      }
      if (this.minFilter != paramTextureDescriptor.minFilter)
      {
        int i6;
        int i7;
        if (this.minFilter == null)
        {
          i6 = 0;
          Texture.TextureFilter localTextureFilter2 = paramTextureDescriptor.minFilter;
          i7 = 0;
          if (localTextureFilter2 != null)
            break label166;
        }
        while (true)
        {
          return i6 - i7;
          i6 = this.minFilter.getGLEnum();
          break;
          i7 = paramTextureDescriptor.minFilter.getGLEnum();
        }
      }
      if (this.magFilter != paramTextureDescriptor.magFilter)
      {
        int i4;
        int i5;
        if (this.magFilter == null)
        {
          i4 = 0;
          Texture.TextureFilter localTextureFilter1 = paramTextureDescriptor.magFilter;
          i5 = 0;
          if (localTextureFilter1 != null)
            break label231;
        }
        while (true)
        {
          return i4 - i5;
          i4 = this.magFilter.getGLEnum();
          break;
          i5 = paramTextureDescriptor.magFilter.getGLEnum();
        }
      }
      if (this.uWrap == paramTextureDescriptor.uWrap)
        continue;
      int i2;
      int i3;
      if (this.uWrap == null)
      {
        i2 = 0;
        Texture.TextureWrap localTextureWrap2 = paramTextureDescriptor.uWrap;
        i3 = 0;
        if (localTextureWrap2 != null)
          break label296;
      }
      while (true)
      {
        return i2 - i3;
        i2 = this.uWrap.getGLEnum();
        break;
        i3 = paramTextureDescriptor.uWrap.getGLEnum();
      }
    }
    while (this.vWrap == paramTextureDescriptor.vWrap);
    label166: label231: int n;
    label296: int i1;
    if (this.vWrap == null)
    {
      n = 0;
      Texture.TextureWrap localTextureWrap1 = paramTextureDescriptor.vWrap;
      i1 = 0;
      if (localTextureWrap1 != null)
        break label361;
    }
    while (true)
    {
      return n - i1;
      n = this.vWrap.getGLEnum();
      break;
      label361: i1 = paramTextureDescriptor.vWrap.getGLEnum();
    }
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    TextureDescriptor localTextureDescriptor;
    do
    {
      do
      {
        return false;
        if (paramObject == this)
          return true;
      }
      while (!(paramObject instanceof TextureDescriptor));
      localTextureDescriptor = (TextureDescriptor)paramObject;
    }
    while ((localTextureDescriptor.texture != this.texture) || (localTextureDescriptor.minFilter != this.minFilter) || (localTextureDescriptor.magFilter != this.magFilter) || (localTextureDescriptor.uWrap != this.uWrap) || (localTextureDescriptor.vWrap != this.vWrap));
    return true;
  }

  public int hashCode()
  {
    int i;
    int j;
    label26: int k;
    label47: int m;
    label69: int n;
    label91: long l5;
    int i1;
    if (this.texture == null)
    {
      i = 0;
      long l1 = 811L * i;
      if (this.texture != null)
        break label146;
      j = 0;
      long l2 = 811L * (l1 + j);
      if (this.minFilter != null)
        break label158;
      k = 0;
      long l3 = 811L * (l2 + k);
      if (this.magFilter != null)
        break label170;
      m = 0;
      long l4 = 811L * (l3 + m);
      if (this.uWrap != null)
        break label182;
      n = 0;
      l5 = 811L * (l4 + n);
      Texture.TextureWrap localTextureWrap = this.vWrap;
      i1 = 0;
      if (localTextureWrap != null)
        break label194;
    }
    while (true)
    {
      long l6 = l5 + i1;
      return (int)(l6 ^ l6 >> 32);
      i = this.texture.glTarget;
      break;
      label146: j = this.texture.getTextureObjectHandle();
      break label26;
      label158: k = this.minFilter.getGLEnum();
      break label47;
      label170: m = this.magFilter.getGLEnum();
      break label69;
      label182: n = this.uWrap.getGLEnum();
      break label91;
      label194: i1 = this.vWrap.getGLEnum();
    }
  }

  public void set(GLTexture paramGLTexture, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2)
  {
    this.texture = paramGLTexture;
    this.minFilter = paramTextureFilter1;
    this.magFilter = paramTextureFilter2;
    this.uWrap = paramTextureWrap1;
    this.vWrap = paramTextureWrap2;
  }

  public void set(TextureDescriptor paramTextureDescriptor)
  {
    this.texture = paramTextureDescriptor.texture;
    this.minFilter = paramTextureDescriptor.minFilter;
    this.magFilter = paramTextureDescriptor.magFilter;
    this.uWrap = paramTextureDescriptor.uWrap;
    this.vWrap = paramTextureDescriptor.vWrap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.TextureDescriptor
 * JD-Core Version:    0.6.0
 */