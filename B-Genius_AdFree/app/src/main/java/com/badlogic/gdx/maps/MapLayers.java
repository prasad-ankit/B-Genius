package com.badlogic.gdx.maps;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class MapLayers
  implements Iterable
{
  private Array layers = new Array();

  public void add(MapLayer paramMapLayer)
  {
    this.layers.add(paramMapLayer);
  }

  public MapLayer get(int paramInt)
  {
    return (MapLayer)this.layers.get(paramInt);
  }

  public MapLayer get(String paramString)
  {
    int i = this.layers.size;
    for (int j = 0; j < i; j++)
    {
      MapLayer localMapLayer = (MapLayer)this.layers.get(j);
      if (paramString.equals(localMapLayer.getName()))
        return localMapLayer;
    }
    return null;
  }

  public Array getByType(Class paramClass)
  {
    return getByType(paramClass, new Array());
  }

  public Array getByType(Class paramClass, Array paramArray)
  {
    paramArray.clear();
    int i = this.layers.size;
    for (int j = 0; j < i; j++)
    {
      MapLayer localMapLayer = (MapLayer)this.layers.get(j);
      if (!ClassReflection.isInstance(paramClass, localMapLayer))
        continue;
      paramArray.add(localMapLayer);
    }
    return paramArray;
  }

  public int getCount()
  {
    return this.layers.size;
  }

  public int getIndex(MapLayer paramMapLayer)
  {
    return this.layers.indexOf(paramMapLayer, true);
  }

  public int getIndex(String paramString)
  {
    return getIndex(get(paramString));
  }

  public Iterator iterator()
  {
    return this.layers.iterator();
  }

  public void remove(int paramInt)
  {
    this.layers.removeIndex(paramInt);
  }

  public void remove(MapLayer paramMapLayer)
  {
    this.layers.removeValue(paramMapLayer, true);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.MapLayers
 * JD-Core Version:    0.6.0
 */