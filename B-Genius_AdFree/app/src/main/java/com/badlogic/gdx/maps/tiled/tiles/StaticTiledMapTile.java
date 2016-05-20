package com.badlogic.gdx.maps.tiled.tiles;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTile.BlendMode;

public class StaticTiledMapTile
  implements TiledMapTile
{
  private TiledMapTile.BlendMode blendMode = TiledMapTile.BlendMode.ALPHA;
  private int id;
  private float offsetX;
  private float offsetY;
  private MapProperties properties;
  private TextureRegion textureRegion;

  public StaticTiledMapTile(TextureRegion paramTextureRegion)
  {
    this.textureRegion = paramTextureRegion;
  }

  public StaticTiledMapTile(StaticTiledMapTile paramStaticTiledMapTile)
  {
    if (paramStaticTiledMapTile.properties != null)
      getProperties().putAll(paramStaticTiledMapTile.properties);
    this.textureRegion = paramStaticTiledMapTile.textureRegion;
    this.id = paramStaticTiledMapTile.id;
  }

  public TiledMapTile.BlendMode getBlendMode()
  {
    return this.blendMode;
  }

  public int getId()
  {
    return this.id;
  }

  public float getOffsetX()
  {
    return this.offsetX;
  }

  public float getOffsetY()
  {
    return this.offsetY;
  }

  public MapProperties getProperties()
  {
    if (this.properties == null)
      this.properties = new MapProperties();
    return this.properties;
  }

  public TextureRegion getTextureRegion()
  {
    return this.textureRegion;
  }

  public void setBlendMode(TiledMapTile.BlendMode paramBlendMode)
  {
    this.blendMode = paramBlendMode;
  }

  public void setId(int paramInt)
  {
    this.id = paramInt;
  }

  public void setOffsetX(float paramFloat)
  {
    this.offsetX = paramFloat;
  }

  public void setOffsetY(float paramFloat)
  {
    this.offsetY = paramFloat;
  }

  public void setTextureRegion(TextureRegion paramTextureRegion)
  {
    this.textureRegion = paramTextureRegion;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile
 * JD-Core Version:    0.6.0
 */