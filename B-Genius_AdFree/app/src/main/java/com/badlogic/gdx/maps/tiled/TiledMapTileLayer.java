package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapLayer;
import java.lang.reflect.Array;

public class TiledMapTileLayer extends MapLayer
{
  private TiledMapTileLayer.Cell[][] cells;
  private int height;
  private float tileHeight;
  private float tileWidth;
  private int width;

  public TiledMapTileLayer(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.tileWidth = paramInt3;
    this.tileHeight = paramInt4;
    this.cells = ((TiledMapTileLayer.Cell[][])Array.newInstance(TiledMapTileLayer.Cell.class, new int[] { paramInt1, paramInt2 }));
  }

  public TiledMapTileLayer.Cell getCell(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.width));
    do
      return null;
    while ((paramInt2 < 0) || (paramInt2 >= this.height));
    return this.cells[paramInt1][paramInt2];
  }

  public int getHeight()
  {
    return this.height;
  }

  public float getTileHeight()
  {
    return this.tileHeight;
  }

  public float getTileWidth()
  {
    return this.tileWidth;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void setCell(int paramInt1, int paramInt2, TiledMapTileLayer.Cell paramCell)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.width));
    do
      return;
    while ((paramInt2 < 0) || (paramInt2 >= this.height));
    this.cells[paramInt1][paramInt2] = paramCell;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapTileLayer
 * JD-Core Version:    0.6.0
 */