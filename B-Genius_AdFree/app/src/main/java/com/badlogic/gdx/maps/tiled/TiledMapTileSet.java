package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.utils.IntMap;
import com.badlogic.gdx.utils.IntMap.Values;
import java.util.Iterator;

public class TiledMapTileSet
  implements Iterable
{
  private String name;
  private MapProperties properties = new MapProperties();
  private IntMap tiles = new IntMap();

  public String getName()
  {
    return this.name;
  }

  public MapProperties getProperties()
  {
    return this.properties;
  }

  public TiledMapTile getTile(int paramInt)
  {
    return (TiledMapTile)this.tiles.get(paramInt);
  }

  public Iterator iterator()
  {
    return this.tiles.values().iterator();
  }

  public void putTile(int paramInt, TiledMapTile paramTiledMapTile)
  {
    this.tiles.put(paramInt, paramTiledMapTile);
  }

  public void removeTile(int paramInt)
  {
    this.tiles.remove(paramInt);
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public int size()
  {
    return this.tiles.size;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapTileSet
 * JD-Core Version:    0.6.0
 */