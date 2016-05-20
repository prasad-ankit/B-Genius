package com.badlogic.gdx.maps;

import com.badlogic.gdx.utils.Disposable;

public class Map
  implements Disposable
{
  private MapLayers layers = new MapLayers();
  private MapProperties properties = new MapProperties();

  public void dispose()
  {
  }

  public MapLayers getLayers()
  {
    return this.layers;
  }

  public MapProperties getProperties()
  {
    return this.properties;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.Map
 * JD-Core Version:    0.6.0
 */