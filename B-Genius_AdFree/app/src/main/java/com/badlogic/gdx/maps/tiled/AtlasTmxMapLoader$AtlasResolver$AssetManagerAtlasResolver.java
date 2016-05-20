package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AtlasTmxMapLoader$AtlasResolver$AssetManagerAtlasResolver
  implements AtlasTmxMapLoader.AtlasResolver
{
  private final AssetManager assetManager;

  public AtlasTmxMapLoader$AtlasResolver$AssetManagerAtlasResolver(AssetManager paramAssetManager)
  {
    this.assetManager = paramAssetManager;
  }

  public TextureAtlas getAtlas(String paramString)
  {
    return (TextureAtlas)this.assetManager.get(paramString, TextureAtlas.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.AtlasTmxMapLoader.AtlasResolver.AssetManagerAtlasResolver
 * JD-Core Version:    0.6.0
 */