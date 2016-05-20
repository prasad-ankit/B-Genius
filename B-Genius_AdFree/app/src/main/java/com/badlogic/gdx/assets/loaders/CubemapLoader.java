package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.CubemapData;
import com.badlogic.gdx.graphics.glutils.KTXTextureData;
import com.badlogic.gdx.utils.Array;

public class CubemapLoader extends AsynchronousAssetLoader
{
  CubemapLoader.CubemapLoaderInfo info = new CubemapLoader.CubemapLoaderInfo();

  public CubemapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, CubemapLoader.CubemapParameter paramCubemapParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, CubemapLoader.CubemapParameter paramCubemapParameter)
  {
    this.info.filename = paramString;
    if ((paramCubemapParameter == null) || (paramCubemapParameter.cubemapData == null))
    {
      this.info.cubemap = null;
      if (paramCubemapParameter != null)
        this.info.cubemap = paramCubemapParameter.cubemap;
      if ((paramString.contains(".ktx")) || (paramString.contains(".zktx")))
        this.info.data = new KTXTextureData(paramFileHandle, false);
    }
    while (true)
    {
      if (!this.info.data.isPrepared())
        this.info.data.prepare();
      return;
      this.info.data = paramCubemapParameter.cubemapData;
      this.info.cubemap = paramCubemapParameter.cubemap;
    }
  }

  public Cubemap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, CubemapLoader.CubemapParameter paramCubemapParameter)
  {
    Cubemap localCubemap;
    if (this.info == null)
      localCubemap = null;
    while (true)
    {
      return localCubemap;
      localCubemap = this.info.cubemap;
      if (localCubemap != null)
        localCubemap.load(this.info.data);
      while (paramCubemapParameter != null)
      {
        localCubemap.setFilter(paramCubemapParameter.minFilter, paramCubemapParameter.magFilter);
        localCubemap.setWrap(paramCubemapParameter.wrapU, paramCubemapParameter.wrapV);
        return localCubemap;
        localCubemap = new Cubemap(this.info.data);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.CubemapLoader
 * JD-Core Version:    0.6.0
 */