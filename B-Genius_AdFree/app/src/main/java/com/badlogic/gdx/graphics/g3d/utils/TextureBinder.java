package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.graphics.GLTexture;

public abstract interface TextureBinder
{
  public abstract void begin();

  public abstract int bind(GLTexture paramGLTexture);

  public abstract int bind(TextureDescriptor paramTextureDescriptor);

  public abstract void end();

  public abstract int getBindCount();

  public abstract int getReuseCount();

  public abstract void resetCounts();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.TextureBinder
 * JD-Core Version:    0.6.0
 */