package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.utils.ObjectMap;

public class SkinLoader$SkinParameter extends AssetLoaderParameters
{
  public final ObjectMap resources;
  public final String textureAtlasPath;

  public SkinLoader$SkinParameter()
  {
    this(null, null);
  }

  public SkinLoader$SkinParameter(ObjectMap paramObjectMap)
  {
    this(null, paramObjectMap);
  }

  public SkinLoader$SkinParameter(String paramString)
  {
    this(paramString, null);
  }

  public SkinLoader$SkinParameter(String paramString, ObjectMap paramObjectMap)
  {
    this.textureAtlasPath = paramString;
    this.resources = paramObjectMap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter
 * JD-Core Version:    0.6.0
 */