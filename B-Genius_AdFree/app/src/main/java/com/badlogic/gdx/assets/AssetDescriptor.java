package com.badlogic.gdx.assets;

import com.badlogic.gdx.files.FileHandle;

public class AssetDescriptor
{
  public FileHandle file;
  public final String fileName;
  public final AssetLoaderParameters params;
  public final Class type;

  public AssetDescriptor(FileHandle paramFileHandle, Class paramClass)
  {
    this(paramFileHandle, paramClass, null);
  }

  public AssetDescriptor(FileHandle paramFileHandle, Class paramClass, AssetLoaderParameters paramAssetLoaderParameters)
  {
    this.fileName = paramFileHandle.path().replaceAll("\\\\", "/");
    this.file = paramFileHandle;
    this.type = paramClass;
    this.params = paramAssetLoaderParameters;
  }

  public AssetDescriptor(String paramString, Class paramClass)
  {
    this(paramString, paramClass, null);
  }

  public AssetDescriptor(String paramString, Class paramClass, AssetLoaderParameters paramAssetLoaderParameters)
  {
    this.fileName = paramString.replaceAll("\\\\", "/");
    this.type = paramClass;
    this.params = paramAssetLoaderParameters;
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.fileName);
    localStringBuffer.append(", ");
    localStringBuffer.append(this.type.getName());
    return localStringBuffer.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.assets.AssetDescriptor
 * JD-Core Version:    0.6.0
 */