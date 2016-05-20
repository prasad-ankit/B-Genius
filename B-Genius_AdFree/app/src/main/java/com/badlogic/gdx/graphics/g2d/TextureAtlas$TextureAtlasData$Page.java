package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class TextureAtlas$TextureAtlasData$Page
{
  public final Pixmap.Format format;
  public final float height;
  public final Texture.TextureFilter magFilter;
  public final Texture.TextureFilter minFilter;
  public Texture texture;
  public final FileHandle textureFile;
  public final Texture.TextureWrap uWrap;
  public final boolean useMipMaps;
  public final Texture.TextureWrap vWrap;
  public final float width;

  public TextureAtlas$TextureAtlasData$Page(FileHandle paramFileHandle, float paramFloat1, float paramFloat2, boolean paramBoolean, Pixmap.Format paramFormat, Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, Texture.TextureWrap paramTextureWrap1, Texture.TextureWrap paramTextureWrap2)
  {
    this.width = paramFloat1;
    this.height = paramFloat2;
    this.textureFile = paramFileHandle;
    this.useMipMaps = paramBoolean;
    this.format = paramFormat;
    this.minFilter = paramTextureFilter1;
    this.magFilter = paramTextureFilter2;
    this.uWrap = paramTextureWrap1;
    this.vWrap = paramTextureWrap2;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page
 * JD-Core Version:    0.6.0
 */