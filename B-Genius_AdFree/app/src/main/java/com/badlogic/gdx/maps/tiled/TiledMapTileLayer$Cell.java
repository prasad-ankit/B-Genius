package com.badlogic.gdx.maps.tiled;

public class TiledMapTileLayer$Cell
{
  public static final int ROTATE_0 = 0;
  public static final int ROTATE_180 = 2;
  public static final int ROTATE_270 = 3;
  public static final int ROTATE_90 = 1;
  private boolean flipHorizontally;
  private boolean flipVertically;
  private int rotation;
  private TiledMapTile tile;

  public boolean getFlipHorizontally()
  {
    return this.flipHorizontally;
  }

  public boolean getFlipVertically()
  {
    return this.flipVertically;
  }

  public int getRotation()
  {
    return this.rotation;
  }

  public TiledMapTile getTile()
  {
    return this.tile;
  }

  public void setFlipHorizontally(boolean paramBoolean)
  {
    this.flipHorizontally = paramBoolean;
  }

  public void setFlipVertically(boolean paramBoolean)
  {
    this.flipVertically = paramBoolean;
  }

  public void setRotation(int paramInt)
  {
    this.rotation = paramInt;
  }

  public void setTile(TiledMapTile paramTiledMapTile)
  {
    this.tile = paramTiledMapTile;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell
 * JD-Core Version:    0.6.0
 */