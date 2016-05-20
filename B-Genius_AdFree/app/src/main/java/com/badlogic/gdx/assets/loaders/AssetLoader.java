package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;

public abstract class AssetLoader
{
  private FileHandleResolver resolver;

  public AssetLoader(FileHandleResolver paramFileHandleResolver)
  {
    this.resolver = paramFileHandleResolver;
  }

  public abstract Array getDependencies(String paramString, FileHandle paramFileHandle, AssetLoaderParameters paramAssetLoaderParameters);

  public FileHandle resolve(String paramString)
  {
    return this.resolver.resolve(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.AssetLoader
 * JD-Core Version:    0.6.0
 */