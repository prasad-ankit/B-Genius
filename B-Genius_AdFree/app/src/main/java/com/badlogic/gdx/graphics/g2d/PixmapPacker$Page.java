package com.badlogic.gdx.graphics.g2d;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.glutils.PixmapTextureData;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.OrderedMap;

public class PixmapPacker$Page
{
  final Array addedRects = new Array();
  boolean dirty;
  Pixmap image;
  OrderedMap rects;
  PixmapPacker.Node root;
  Texture texture;

  public Pixmap getPixmap()
  {
    return this.image;
  }

  public OrderedMap getRects()
  {
    return this.rects;
  }

  public Texture getTexture()
  {
    return this.texture;
  }

  public boolean updateTexture(Texture.TextureFilter paramTextureFilter1, Texture.TextureFilter paramTextureFilter2, boolean paramBoolean)
  {
    if (this.texture != null)
    {
      if (!this.dirty)
        return false;
      this.texture.load(this.texture.getTextureData());
    }
    while (true)
    {
      this.dirty = false;
      return true;
      this.texture = new PixmapPacker.Page.1(this, new PixmapTextureData(this.image, this.image.getFormat(), paramBoolean, false, true));
      this.texture.setFilter(paramTextureFilter1, paramTextureFilter2);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g2d.PixmapPacker.Page
 * JD-Core Version:    0.6.0
 */