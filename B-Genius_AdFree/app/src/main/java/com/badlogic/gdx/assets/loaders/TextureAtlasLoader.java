package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData.Page;
import com.badlogic.gdx.utils.Array;
import java.util.Iterator;

public class TextureAtlasLoader extends SynchronousAssetLoader
{
  TextureAtlas.TextureAtlasData data;

  public TextureAtlasLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, TextureAtlasLoader.TextureAtlasParameter paramTextureAtlasParameter)
  {
    FileHandle localFileHandle = paramFileHandle.parent();
    if (paramTextureAtlasParameter != null);
    Array localArray;
    for (this.data = new TextureAtlas.TextureAtlasData(paramFileHandle, localFileHandle, paramTextureAtlasParameter.flip); ; this.data = new TextureAtlas.TextureAtlasData(paramFileHandle, localFileHandle, false))
    {
      localArray = new Array();
      Iterator localIterator = this.data.getPages().iterator();
      while (localIterator.hasNext())
      {
        TextureAtlas.TextureAtlasData.Page localPage = (TextureAtlas.TextureAtlasData.Page)localIterator.next();
        TextureLoader.TextureParameter localTextureParameter = new TextureLoader.TextureParameter();
        localTextureParameter.format = localPage.format;
        localTextureParameter.genMipMaps = localPage.useMipMaps;
        localTextureParameter.minFilter = localPage.minFilter;
        localTextureParameter.magFilter = localPage.magFilter;
        localArray.add(new AssetDescriptor(localPage.textureFile, Texture.class, localTextureParameter));
      }
    }
    return localArray;
  }

  public TextureAtlas load(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, TextureAtlasLoader.TextureAtlasParameter paramTextureAtlasParameter)
  {
    Iterator localIterator = this.data.getPages().iterator();
    while (localIterator.hasNext())
    {
      TextureAtlas.TextureAtlasData.Page localPage = (TextureAtlas.TextureAtlasData.Page)localIterator.next();
      localPage.texture = ((Texture)paramAssetManager.get(localPage.textureFile.path().replaceAll("\\\\", "/"), Texture.class));
    }
    return new TextureAtlas(this.data);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.TextureAtlasLoader
 * JD-Core Version:    0.6.0
 */