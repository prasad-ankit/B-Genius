package com.badlogic.gdx.maps.tiled.objects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

public class TiledMapTileMapObject extends TextureMapObject
{
  private boolean flipHorizontally;
  private boolean flipVertically;
  private TiledMapTile tile;

  public TiledMapTileMapObject(TiledMapTile paramTiledMapTile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.flipHorizontally = paramBoolean1;
    this.flipVertically = paramBoolean2;
    this.tile = paramTiledMapTile;
    TextureRegion localTextureRegion = new TextureRegion(paramTiledMapTile.getTextureRegion());
    localTextureRegion.flip(paramBoolean1, paramBoolean2);
    setTextureRegion(localTextureRegion);
  }

  public TiledMapTile getTile()
  {
    return this.tile;
  }

  public boolean isFlipHorizontally()
  {
    return this.flipHorizontally;
  }

  public boolean isFlipVertically()
  {
    return this.flipVertically;
  }

  public void setFlipHorizontally(boolean paramBoolean)
  {
    this.flipHorizontally = paramBoolean;
  }

  public void setFlipVertically(boolean paramBoolean)
  {
    this.flipVertically = paramBoolean;
  }

  public void setTile(TiledMapTile paramTiledMapTile)
  {
    this.tile = paramTiledMapTile;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.objects.TiledMapTileMapObject
 * JD-Core Version:    0.6.0
 */