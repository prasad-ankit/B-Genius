package com.badlogic.gdx.graphics.g3d.particles;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

public class ResourceData$AssetData
  implements Json.Serializable
{
  public String filename;
  public Class type;

  public ResourceData$AssetData()
  {
  }

  public ResourceData$AssetData(String paramString, Class paramClass)
  {
    this.filename = paramString;
    this.type = paramClass;
  }

  public void read(Json paramJson, JsonValue paramJsonValue)
  {
    this.filename = ((String)paramJson.readValue("filename", String.class, paramJsonValue));
    String str = (String)paramJson.readValue("type", String.class, paramJsonValue);
    try
    {
      this.type = ClassReflection.forName(str);
      return;
    }
    catch (ReflectionException localReflectionException)
    {
    }
    throw new GdxRuntimeException("Class not found: " + str, localReflectionException);
  }

  public void write(Json paramJson)
  {
    paramJson.writeValue("filename", this.filename);
    paramJson.writeValue("type", this.type.getName());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.g3d.particles.ResourceData.AssetData
 * JD-Core Version:    0.6.0
 */