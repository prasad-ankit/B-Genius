package com.badlogic.gdx.maps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ObjectMap;

public class ImageResolver$DirectImageResolver
  implements ImageResolver
{
  private final ObjectMap images;

  public ImageResolver$DirectImageResolver(ObjectMap paramObjectMap)
  {
    this.images = paramObjectMap;
  }

  public TextureRegion getImage(String paramString)
  {
    return new TextureRegion((Texture)this.images.get(paramString));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.ImageResolver.DirectImageResolver
 * JD-Core Version:    0.6.0
 */