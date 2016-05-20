package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.util.Iterator;

public class ResourceData
  implements Json.Serializable
{
  private int currentLoadIndex = 0;
  private Array data = new Array(true, 3, ResourceData.SaveData.class);
  public Object resource;
  Array sharedAssets = new Array();
  private ObjectMap uniqueData = new ObjectMap();

  public ResourceData()
  {
  }

  public ResourceData(Object paramObject)
  {
    this();
    this.resource = paramObject;
  }

  public ResourceData.SaveData createSaveData()
  {
    ResourceData.SaveData localSaveData = new ResourceData.SaveData(this);
    this.data.add(localSaveData);
    return localSaveData;
  }

  public ResourceData.SaveData createSaveData(String paramString)
  {
    ResourceData.SaveData localSaveData = new ResourceData.SaveData(this);
    if (this.uniqueData.containsKey(paramString))
      throw new RuntimeException("Key already used, data must be unique, use a different key");
    this.uniqueData.put(paramString, localSaveData);
    return localSaveData;
  }

  int getAssetData(String paramString, Class paramClass)
  {
    Iterator localIterator = this.sharedAssets.iterator();
    for (int i = 0; localIterator.hasNext(); i++)
    {
      ResourceData.AssetData localAssetData = (ResourceData.AssetData)localIterator.next();
      if ((localAssetData.filename.equals(paramString)) && (localAssetData.type.equals(paramClass)))
        return i;
    }
    return -1;
  }

  public Array getAssetDescriptors()
  {
    Array localArray = new Array();
    Iterator localIterator = this.sharedAssets.iterator();
    while (localIterator.hasNext())
    {
      ResourceData.AssetData localAssetData = (ResourceData.AssetData)localIterator.next();
      localArray.add(new AssetDescriptor(localAssetData.filename, localAssetData.type));
    }
    return localArray;
  }

  public Array getAssets()
  {
    return this.sharedAssets;
  }

  public ResourceData.SaveData getSaveData()
  {
    Array localArray = this.data;
    int i = this.currentLoadIndex;
    this.currentLoadIndex = (i + 1);
    return (ResourceData.SaveData)localArray.get(i);
  }

  public ResourceData.SaveData getSaveData(String paramString)
  {
    return (ResourceData.SaveData)this.uniqueData.get(paramString);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.uniqueData = ((ObjectMap)paramJson.readValue("unique", ObjectMap.class, paramJsonValue));
    ObjectMap.Entries localEntries = this.uniqueData.entries().iterator();
    while (localEntries.hasNext())
      ((ResourceData.SaveData)((ObjectMap.Entry)localEntries.next()).value).resources = this;
    this.data = ((Array)paramJson.readValue("data", Array.class, ResourceData.SaveData.class, paramJsonValue));
    Iterator localIterator = this.data.iterator();
    while (localIterator.hasNext())
      ((ResourceData.SaveData)localIterator.next()).resources = this;
    this.sharedAssets.addAll((Array)paramJson.readValue("assets", Array.class, ResourceData.AssetData.class, paramJsonValue));
    this.resource = paramJson.readValue("resource", null, paramJsonValue);
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("unique", this.uniqueData, ObjectMap.class);
    paramJson.writeValue("data", this.data, Array.class, ResourceData.SaveData.class);
    paramJson.writeValue("assets", this.sharedAssets.toArray(ResourceData.AssetData.class), [Lcom.badlogic.gdx.graphics.g3d.particles.ResourceData.AssetData.class);
    paramJson.writeValue("resource", this.resource, null);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ResourceData
 * JD-Core Version:    0.6.0
 */