package com.badlogic.gdx.maps.tiled;

import com.badlogic.gdx.maps.Map;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import java.util.Iterator;

public class TiledMap extends Map
{
  private Array ownedResources;
  private TiledMapTileSets tilesets = new TiledMapTileSets();

  public void dispose()
  {
    if (this.ownedResources != null)
    {
      Iterator localIterator = this.ownedResources.iterator();
      while (localIterator.hasNext())
        ((Disposable)localIterator.next()).dispose();
    }
  }

  public TiledMapTileSets getTileSets()
  {
    return this.tilesets;
  }

  public void setOwnedResources(Array paramArray)
  {
    this.ownedResources = paramArray;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.tiled.TiledMap
 * JD-Core Version:    0.6.0
 */