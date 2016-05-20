package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class TextureProvider$FileTextureProvider
  implements TextureProvider
{
  public Texture load(String paramString)
  {
    Texture localTexture = new Texture(Gdx.files.internal(paramString));
    localTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
    localTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
    return localTexture;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.TextureProvider.FileTextureProvider
 * JD-Core Version:    0.6.0
 */