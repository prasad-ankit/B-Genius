package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class TiledMapTileSets
  implements Iterable
{
  private Array tilesets = new Array();

  public void addTileSet(TiledMapTileSet paramTiledMapTileSet)
  {
    this.tilesets.add(paramTiledMapTileSet);
  }

  public TiledMapTile getTile(int paramInt)
  {
    for (int i = -1 + this.tilesets.size; i >= 0; i--)
    {
      TiledMapTile localTiledMapTile = ((TiledMapTileSet)this.tilesets.get(i)).getTile(paramInt);
      if (localTiledMapTile != null)
        return localTiledMapTile;
    }
    return null;
  }

  public TiledMapTileSet getTileSet(int paramInt)
  {
    return (TiledMapTileSet)this.tilesets.get(paramInt);
  }

  public TiledMapTileSet getTileSet(String paramString)
  {
    Iterator localIterator = this.tilesets.iterator();
    while (localIterator.hasNext())
    {
      TiledMapTileSet localTiledMapTileSet = (TiledMapTileSet)localIterator.next();
      if (paramString.equals(localTiledMapTileSet.getName()))
        return localTiledMapTileSet;
    }
    return null;
  }

  public Iterator iterator()
  {
    return this.tilesets.iterator();
  }

  public void removeTileSet(int paramInt)
  {
    this.tilesets.removeIndex(paramInt);
  }

  public void removeTileSet(TiledMapTileSet paramTiledMapTileSet)
  {
    this.tilesets.removeValue(paramTiledMapTileSet, true);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMapTileSets
 * JD-Core Version:    0.6.0
 */