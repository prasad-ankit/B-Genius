package com.badlogic.gdx.maps;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import java.util.Iterator;

public class MapObjects
  implements Iterable
{
  private Array objects = new Array();

  public void add(MapObject paramMapObject)
  {
    this.objects.add(paramMapObject);
  }

  public MapObject get(int paramInt)
  {
    return (MapObject)this.objects.get(paramInt);
  }

  public MapObject get(String paramString)
  {
    int i = this.objects.size;
    for (int j = 0; j < i; j++)
    {
      MapObject localMapObject = (MapObject)this.objects.get(j);
      if (paramString.equals(localMapObject.getName()))
        return localMapObject;
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
    int i = this.objects.size;
    for (int j = 0; j < i; j++)
    {
      MapObject localMapObject = (MapObject)this.objects.get(j);
      if (!ClassReflection.isInstance(paramClass, localMapObject))
        continue;
      paramArray.add(localMapObject);
    }
    return paramArray;
  }

  public int getCount()
  {
    return this.objects.size;
  }

  public int getIndex(MapObject paramMapObject)
  {
    return this.objects.indexOf(paramMapObject, true);
  }

  public int getIndex(String paramString)
  {
    return getIndex(get(paramString));
  }

  public Iterator iterator()
  {
    return this.objects.iterator();
  }

  public void remove(int paramInt)
  {
    this.objects.removeIndex(paramInt);
  }

  public void remove(MapObject paramMapObject)
  {
    this.objects.removeValue(paramMapObject, true);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.MapObjects
 * JD-Core Version:    0.6.0
 */