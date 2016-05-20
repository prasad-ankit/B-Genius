package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.TextureData.Factory;
import com.badlogic.gdx.utils.Array;

public class TextureLoader extends AsynchronousAssetLoader
{
  TextureLoader.TextureLoaderInfo info = new TextureLoader.TextureLoaderInfo();

  public TextureLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter)
  {
    this.info.filename = paramString;
    if ((paramTextureParameter == null) || (paramTextureParameter.textureData == null))
    {
      this.info.texture = null;
      boolean bool = false;
      Pixmap.Format localFormat = null;
      if (paramTextureParameter != null)
      {
        localFormat = paramTextureParameter.format;
        bool = paramTextureParameter.genMipMaps;
        this.info.texture = paramTextureParameter.texture;
      }
      this.info.data = TextureData.Factory.loadFromFile(paramFileHandle, localFormat, bool);
    }
    while (true)
    {
      if (!this.info.data.isPrepared())
        this.info.data.prepare();
      return;
      this.info.data = paramTextureParameter.textureData;
      this.info.texture = paramTextureParameter.texture;
    }
  }

  public Texture loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureLoader.TextureParameter paramTextureParameter)
  {
    Texture localTexture;
    if (this.info == null)
      localTexture = null;
    while (true)
    {
      return localTexture;
      localTexture = this.info.texture;
      if (localTexture != null)
        localTexture.load(this.info.data);
      while (paramTextureParameter != null)
      {
        localTexture.setFilter(paramTextureParameter.minFilter, paramTextureParameter.magFilter);
        localTexture.setWrap(paramTextureParameter.wrapU, paramTextureParameter.wrapV);
        return localTexture;
        localTexture = new Texture(this.info.data);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.TextureLoader
 * JD-Core Version:    0.6.0
 */