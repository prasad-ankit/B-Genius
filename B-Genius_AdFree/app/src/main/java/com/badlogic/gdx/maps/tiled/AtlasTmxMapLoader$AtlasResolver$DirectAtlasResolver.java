package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ObjectMap;

public class AtlasTmxMapLoader$AtlasResolver$DirectAtlasResolver
  implements AtlasTmxMapLoader.AtlasResolver
{
  private final ObjectMap atlases;

  public AtlasTmxMapLoader$AtlasResolver$DirectAtlasResolver(ObjectMap paramObjectMap)
  {
    this.atlases = paramObjectMap;
  }

  public TextureAtlas getAtlas(String paramString)
  {
    return (TextureAtlas)this.atlases.get(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.AtlasTmxMapLoader.AtlasResolver.DirectAtlasResolver
 * JD-Core Version:    0.6.0
 */