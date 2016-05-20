package com.badlogic.gdx.maps;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageResolver$AssetManagerImageResolver
  implements ImageResolver
{
  private final AssetManager assetManager;

  public ImageResolver$AssetManagerImageResolver(AssetManager paramAssetManager)
  {
    this.assetManager = paramAssetManager;
  }

  public TextureRegion getImage(String paramString)
  {
    return new TextureRegion((Texture)this.assetManager.get(paramString, Texture.class));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.ImageResolver.AssetManagerImageResolver
 * JD-Core Version:    0.6.0
 */