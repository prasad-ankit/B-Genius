package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapRenderer;

public abstract interface TiledMapRenderer extends MapRenderer
{
  public abstract void renderImageLayer(TiledMapImageLayer paramTiledMapImageLayer);

  public abstract void renderObject(MapObject paramMapObject);

  public abstract void renderObjects(MapLayer paramMapLayer);

  public abstract void renderTileLayer(TiledMapTileLayer paramTiledMapTileLayer);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapRenderer
 * JD-Core Version:    0.6.0
 */