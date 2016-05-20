package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.ObjectMap.Entries;
import com.badlogic.gdx.utils.ObjectMap.Entry;
import java.util.Iterator;

public class SkinLoader extends AsynchronousAssetLoader
{
  public SkinLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, SkinLoader.SkinParameter paramSkinParameter)
  {
    Array localArray = new Array();
    if ((paramSkinParameter == null) || (paramSkinParameter.textureAtlasPath == null))
      localArray.add(new AssetDescriptor(paramFileHandle.pathWithoutExtension() + ".atlas", TextureAtlas.class));
    do
      return localArray;
    while (paramSkinParameter.textureAtlasPath == null);
    localArray.add(new AssetDescriptor(paramSkinParameter.textureAtlasPath, TextureAtlas.class));
    return localArray;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SkinLoader.SkinParameter paramSkinParameter)
  {
  }

  public Skin loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, SkinLoader.SkinParameter paramSkinParameter)
  {
    String str = paramFileHandle.pathWithoutExtension() + ".atlas";
    ObjectMap localObjectMap1 = null;
    if (paramSkinParameter != null)
    {
      if (paramSkinParameter.textureAtlasPath != null)
        str = paramSkinParameter.textureAtlasPath;
      ObjectMap localObjectMap2 = paramSkinParameter.resources;
      localObjectMap1 = null;
      if (localObjectMap2 != null)
        localObjectMap1 = paramSkinParameter.resources;
    }
    Skin localSkin = new Skin((TextureAtlas)paramAssetManager.get(str, TextureAtlas.class));
    if (localObjectMap1 != null)
    {
      ObjectMap.Entries localEntries = localObjectMap1.entries().iterator();
      while (localEntries.hasNext())
      {
        ObjectMap.Entry localEntry = (ObjectMap.Entry)localEntries.next();
        localSkin.add((String)localEntry.key, localEntry.value);
      }
    }
    localSkin.load(paramFileHandle);
    return localSkin;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.SkinLoader
 * JD-Core Version:    0.6.0
 */