package com.badlogic.gdx.maps;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ImageResolver$TextureAtlasImageResolver
  implements ImageResolver
{
  private final TextureAtlas atlas;

  public ImageResolver$TextureAtlasImageResolver(TextureAtlas paramTextureAtlas)
  {
    this.atlas = paramTextureAtlas;
  }

  public TextureRegion getImage(String paramString)
  {
    return this.atlas.findRegion(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.ImageResolver.TextureAtlasImageResolver
 * JD-Core Version:    0.6.0
 */