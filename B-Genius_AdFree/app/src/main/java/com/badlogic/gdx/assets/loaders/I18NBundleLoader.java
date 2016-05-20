package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.I18NBundle;
import java.util.Locale;

public class I18NBundleLoader extends AsynchronousAssetLoader
{
  I18NBundle bundle;

  public I18NBundleLoader(FileHandleResolver paramFileHandleResolver)
  {
    super(paramFileHandleResolver);
  }

  public Array getDependencies(String paramString, FileHandle paramFileHandle, I18NBundleLoader.I18NBundleParameter paramI18NBundleParameter)
  {
    return null;
  }

  public void loadAsync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, I18NBundleLoader.I18NBundleParameter paramI18NBundleParameter)
  {
    Object localObject1 = null;
    this.bundle = null;
    Object localObject2;
    if (paramI18NBundleParameter == null)
    {
      localObject2 = Locale.getDefault();
      if (localObject1 == null)
      {
        this.bundle = I18NBundle.createBundle(paramFileHandle, (Locale)localObject2);
        return;
      }
    }
    else
    {
      if (paramI18NBundleParameter.locale == null);
      for (Locale localLocale = Locale.getDefault(); ; localLocale = paramI18NBundleParameter.locale)
      {
        String str = paramI18NBundleParameter.encoding;
        localObject2 = localLocale;
        localObject1 = str;
        break;
      }
    }
    this.bundle = I18NBundle.createBundle(paramFileHandle, (Locale)localObject2, localObject1);
  }

  public I18NBundle loadSync(AssetManager paramAssetManager, String paramString, FileHandle paramFileHandle, I18NBundleLoader.I18NBundleParameter paramI18NBundleParameter)
  {
    I18NBundle localI18NBundle = this.bundle;
    this.bundle = null;
    return localI18NBundle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.loaders.I18NBundleLoader
 * JD-Core Version:    0.6.0
 */