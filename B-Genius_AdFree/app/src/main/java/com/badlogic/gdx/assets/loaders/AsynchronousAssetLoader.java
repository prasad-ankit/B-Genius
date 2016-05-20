package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;

public abstract class AsynchronousAssetLoader extends AssetLoader
{
  public AsynchronousAssetLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public abstract void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AssetLoaderParameters paramAssetLoaderParameters);

  public abstract Object loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, AssetLoaderParameters paramAssetLoaderParameters);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader
 * JD-Core Version:    0.6.0
 */