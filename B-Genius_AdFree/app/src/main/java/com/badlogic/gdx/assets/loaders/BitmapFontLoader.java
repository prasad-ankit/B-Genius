package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class BitmapFontLoader extends AsynchronousAssetLoader
{
  BitmapFont.BitmapFontData data;

  public BitmapFontLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, BitmapFontLoader.BitmapFontParameter paramBitmapFontParameter)
  {
    Array localArray = new Array();
    if ((paramBitmapFontParameter != null) && (paramBitmapFontParameter.bitmapFontData != null))
    {
      this.data = paramBitmapFontParameter.bitmapFontData;
      return localArray;
    }
    boolean bool;
    int i;
    if (paramBitmapFontParameter != null)
    {
      bool = paramBitmapFontParameter.flip;
      this.data = new BitmapFont.BitmapFontData(paramFileHandle, bool);
      i = 0;
      if (paramBitmapFontParameter == null)
        break label103;
      String str = paramBitmapFontParameter.atlasName;
      i = 0;
      if (str == null)
        break label103;
      localArray.add(new AssetDescriptor(paramBitmapFontParameter.atlasName, TextureAtlas.class));
    }
    while (true)
    {
      return localArray;
      bool = false;
      break;
      label103: 
      while (i < this.data.getImagePaths().length)
      {
        FileHandle localFileHandle = resolve(this.data.getImagePath(i));
        TextureLoader.TextureParameter localTextureParameter = new TextureLoader.TextureParameter();
        if (paramBitmapFontParameter != null)
        {
          localTextureParameter.genMipMaps = paramBitmapFontParameter.genMipMaps;
          localTextureParameter.minFilter = paramBitmapFontParameter.minFilter;
          localTextureParameter.magFilter = paramBitmapFontParameter.magFilter;
        }
        localArray.add(new AssetDescriptor(localFileHandle, Texture.class, localTextureParameter));
        i++;
      }
    }
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BitmapFontLoader.BitmapFontParameter paramBitmapFontParameter)
  {
  }

  public BitmapFont loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, BitmapFontLoader.BitmapFontParameter paramBitmapFontParameter)
  {
    int i = 0;
    if ((paramBitmapFontParameter != null) && (paramBitmapFontParameter.atlasName != null))
    {
      TextureAtlas localTextureAtlas = (TextureAtlas)paramAssetManager.get(paramBitmapFontParameter.atlasName, TextureAtlas.class);
      String str = paramFileHandle.sibling(this.data.imagePaths[0]).nameWithoutExtension().toString();
      TextureAtlas.AtlasRegion localAtlasRegion = localTextureAtlas.findRegion(str);
      if (localAtlasRegion == null)
        throw new GdxRuntimeException("Could not find font region " + str + " in atlas " + paramBitmapFontParameter.atlasName);
      return new BitmapFont(paramFileHandle, localAtlasRegion);
    }
    int j = this.data.getImagePaths().length;
    Array localArray = new Array(j);
    while (i < j)
    {
      localArray.add(new TextureRegion((Texture)paramAssetManager.get(this.data.getImagePath(i), Texture.class)));
      i++;
    }
    return new BitmapFont(this.data, localArray, true);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.BitmapFontLoader
 * JD-Core Version:    0.6.0
 */