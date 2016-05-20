package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.utils.Array;

public class PixmapLoader extends AsynchronousAssetLoader
{
  Pixmap pixmap;

  public PixmapLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, PixmapLoader.PixmapParameter paramPixmapParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PixmapLoader.PixmapParameter paramPixmapParameter)
  {
    this.pixmap = null;
    this.pixmap = new Pixmap(paramFileHandle);
  }

  public Pixmap loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, PixmapLoader.PixmapParameter paramPixmapParameter)
  {
    Pixmap localPixmap = this.pixmap;
    this.pixmap = null;
    return localPixmap;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.PixmapLoader
 * JD-Core Version:    0.6.0
 */