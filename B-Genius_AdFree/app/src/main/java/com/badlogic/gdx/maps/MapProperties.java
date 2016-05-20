package com.badlogic.gdx.maps;

import com.badlogic.gdx.utils.ObjectMap;
import java.util.Iterator;

public class MapProperties
{
  private ObjectMap properties = new ObjectMap();

  public void clear()
  {
    this.properties.clear();
  }

  public boolean containsKey(String paramString)
  {
    return this.properties.containsKey(paramString);
  }

  public Object get(String paramString)
  {
    return this.properties.get(paramString);
  }

  public Object get(String paramString, Class paramClass)
  {
    return get(paramString);
  }

  public Object get(String paramString, Object paramObject, Class paramClass)
  {
    Object localObject = get(paramString);
    if (localObject == null)
      return paramObject;
    return localObject;
  }

  public Iterator getKeys()
  {
    return this.properties.keys();
  }

  public Iterator getValues()
  {
    return this.properties.values();
  }

  public void put(String paramString, Object paramObject)
  {
    this.properties.put(paramString, paramObject);
  }

  public void putAll(MapProperties paramMapProperties)
  {
    this.properties.putAll(paramMapProperties.properties);
  }

  public void remove(String paramString)
  {
    this.properties.remove(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.maps.MapProperties
 * JD-Core Version:    0.6.0
 */