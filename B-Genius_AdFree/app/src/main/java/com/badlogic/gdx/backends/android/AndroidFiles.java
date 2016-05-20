package com.badlogic.gdx.backends.android;

import android.content.res.AssetManager;
import android.os.Environment;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AndroidFiles
  implements Files
{
  protected final AssetManager assets;
  private ZipResourceFile expansionFile = null;
  protected final String localpath;
  protected final String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";

  public AndroidFiles(AssetManager paramAssetManager)
  {
    this.assets = paramAssetManager;
    this.localpath = this.sdcard;
  }

  public AndroidFiles(AssetManager paramAssetManager, String paramString)
  {
    this.assets = paramAssetManager;
    if (paramString.endsWith("/"));
    while (true)
    {
      this.localpath = paramString;
      return;
      paramString = paramString + "/";
    }
  }

  private FileHandle getZipFileHandleIfExists(FileHandle paramFileHandle, String paramString)
  {
    AndroidZipFileHandle localAndroidZipFileHandle;
    try
    {
      this.assets.open(paramString).close();
      return paramFileHandle;
    }
    catch (Exception localException)
    {
      do
      {
        localAndroidZipFileHandle = new AndroidZipFileHandle(paramString);
        if (!localAndroidZipFileHandle.isDirectory())
          return localAndroidZipFileHandle;
      }
      while (!localAndroidZipFileHandle.exists());
    }
    return localAndroidZipFileHandle;
  }

  public FileHandle absolute(String paramString)
  {
    return new AndroidFileHandle(null, paramString, Files.FileType.Absolute);
  }

  public FileHandle classpath(String paramString)
  {
    return new AndroidFileHandle(null, paramString, Files.FileType.Classpath);
  }

  public FileHandle external(String paramString)
  {
    return new AndroidFileHandle(null, paramString, Files.FileType.External);
  }

  public ZipResourceFile getExpansionFile()
  {
    return this.expansionFile;
  }

  public String getExternalStoragePath()
  {
    return this.sdcard;
  }

  public FileHandle getFileHandle(String paramString, Files.FileType paramFileType)
  {
    if (paramFileType == Files.FileType.Internal);
    AndroidFileHandle localAndroidFileHandle;
    for (AssetManager localAssetManager = this.assets; ; localAssetManager = null)
    {
      localAndroidFileHandle = new AndroidFileHandle(localAssetManager, paramString, paramFileType);
      if ((this.expansionFile == null) || (paramFileType != Files.FileType.Internal))
        break;
      return getZipFileHandleIfExists(localAndroidFileHandle, paramString);
    }
    return localAndroidFileHandle;
  }

  public String getLocalStoragePath()
  {
    return this.localpath;
  }

  public FileHandle internal(String paramString)
  {
    Object localObject = new AndroidFileHandle(this.assets, paramString, Files.FileType.Internal);
    if (this.expansionFile != null)
      localObject = getZipFileHandleIfExists((FileHandle)localObject, paramString);
    return (FileHandle)localObject;
  }

  public boolean isExternalStorageAvailable()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }

  public boolean isLocalStorageAvailable()
  {
    return true;
  }

  public FileHandle local(String paramString)
  {
    return new AndroidFileHandle(null, paramString, Files.FileType.Local);
  }

  public boolean setAPKExpansion(int paramInt1, int paramInt2)
  {
    try
    {
      this.expansionFile = APKExpansionSupport.getAPKExpansionZipFile(((AndroidApplication)Gdx.app).getBaseContext(), paramInt1, paramInt2);
      if (this.expansionFile != null)
        return true;
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("APK expansion main version " + paramInt1 + " or patch version " + paramInt2 + " couldn't be opened!");
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidFiles
 * JD-Core Version:    0.6.0
 */