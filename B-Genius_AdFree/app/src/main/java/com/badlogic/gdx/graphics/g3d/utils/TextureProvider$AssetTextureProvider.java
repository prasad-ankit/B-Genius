package com.badlogic.gdx.graphics.g3d.utils;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class TextureProvider$AssetTextureProvider
  implements TextureProvider
{
  public final AssetManager assetManager;

  public TextureProvider$AssetTextureProvider(AssetManager paramAssetManager)
  {
    this.assetManager = paramAssetManager;
  }

  public Texture load(String paramString)
  {
    return (Texture)this.assetManager.get(paramString, Texture.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.utils.TextureProvider.AssetTextureProvider
 * JD-Core Version:    0.6.0
 */