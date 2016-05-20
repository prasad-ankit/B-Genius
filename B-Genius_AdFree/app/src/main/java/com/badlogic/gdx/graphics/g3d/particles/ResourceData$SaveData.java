package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;

public class ResourceData$SaveData
  implements Json.Serializable
{
  IntArray assets = new IntArray();
  ObjectMap data = new ObjectMap();
  private int loadIndex = 0;
  protected ResourceData resources;

  public ResourceData$SaveData()
  {
  }

  public ResourceData$SaveData(ResourceData paramResourceData)
  {
    this.resources = paramResourceData;
  }

  public Object load(String paramString)
  {
    return this.data.get(paramString);
  }

  public AssetDescriptor loadAsset()
  {
    if (this.loadIndex == this.assets.size)
      return null;
    Array localArray = this.resources.sharedAssets;
    IntArray localIntArray = this.assets;
    int i = this.loadIndex;
    this.loadIndex = (i + 1);
    ResourceData.AssetData localAssetData = (ResourceData.AssetData)localArray.get(localIntArray.get(i));
    return new AssetDescriptor(localAssetData.filename, localAssetData.type);
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.data = ((ObjectMap)paramJson.readValue("data", ObjectMap.class, paramJsonValue));
    this.assets.addAll((int[])paramJson.readValue("indices", [I.class, paramJsonValue));
  }

  public void save(String paramString, Object paramObject)
  {
    this.data.put(paramString, paramObject);
  }

  public void saveAsset(String paramString, Class paramClass)
  {
    int i = this.resources.getAssetData(paramString, paramClass);
    if (i == -1)
    {
      this.resources.sharedAssets.add(new ResourceData.AssetData(paramString, paramClass));
      i = -1 + this.resources.sharedAssets.size;
    }
    this.assets.add(i);
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("data", this.data, ObjectMap.class);
    paramJson.writeValue("indices", this.assets.toArray(), [I.class);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ResourceData.SaveData
 * JD-Core Version:    0.6.0
 */