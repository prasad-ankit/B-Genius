package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

public class AndroidZipFileHandle extends AndroidFileHandle
{
  private AssetFileDescriptor assetFd;
  private ZipResourceFile expansionFile;
  private String path;

  public AndroidZipFileHandle(File paramFile, Files.FileType paramFileType)
  {
    super(null, paramFile, paramFileType);
    initialize();
  }

  public AndroidZipFileHandle(String paramString)
  {
    super(null, paramString, Files.FileType.Internal);
    initialize();
  }

  private String getPath()
  {
    return this.path;
  }

  private void initialize()
  {
    this.path = this.file.getPath().replace('\\', '/');
    this.expansionFile = ((AndroidFiles)Gdx.files).getExpansionFile();
    this.assetFd = this.expansionFile.getAssetFileDescriptor(getPath());
    if (isDirectory())
      this.path += "/";
  }

  public FileHandle child(String paramString)
  {
    if (this.file.getPath().length() == 0)
      return new AndroidZipFileHandle(new File(paramString), this.type);
    return new AndroidZipFileHandle(new File(this.file, paramString), this.type);
  }

  public boolean exists()
  {
    return (this.assetFd != null) || (this.expansionFile.getEntriesAt(getPath()).length != 0);
  }

  public AssetFileDescriptor getAssetFileDescriptor()
  {
    return this.assetFd;
  }

  public boolean isDirectory()
  {
    return this.assetFd == null;
  }

  public long length()
  {
    if (this.assetFd != null)
      return this.assetFd.getLength();
    return 0L;
  }

  public FileHandle[] list()
  {
    ZipResourceFile.ZipEntryRO[] arrayOfZipEntryRO = this.expansionFile.getEntriesAt(getPath());
    FileHandle[] arrayOfFileHandle = new FileHandle[arrayOfZipEntryRO.length];
    int i = 0;
    int j = arrayOfFileHandle.length;
    while (i < j)
    {
      arrayOfFileHandle[i] = new AndroidZipFileHandle(arrayOfZipEntryRO[i].mFileName);
      i++;
    }
    return arrayOfFileHandle;
  }

  public FileHandle[] list(FileFilter paramFileFilter)
  {
    ZipResourceFile.ZipEntryRO[] arrayOfZipEntryRO = this.expansionFile.getEntriesAt(getPath());
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfZipEntryRO.length];
    int i = arrayOfFileHandle1.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      AndroidZipFileHandle localAndroidZipFileHandle = new AndroidZipFileHandle(arrayOfZipEntryRO[j].mFileName);
      if (paramFileFilter.accept(localAndroidZipFileHandle.file()))
      {
        arrayOfFileHandle1[k] = localAndroidZipFileHandle;
        k++;
      }
      j++;
    }
    if (k < arrayOfZipEntryRO.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public FileHandle[] list(FilenameFilter paramFilenameFilter)
  {
    ZipResourceFile.ZipEntryRO[] arrayOfZipEntryRO = this.expansionFile.getEntriesAt(getPath());
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfZipEntryRO.length];
    int i = arrayOfFileHandle1.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = arrayOfZipEntryRO[j].mFileName;
      if (paramFilenameFilter.accept(this.file, str))
      {
        arrayOfFileHandle1[k] = new AndroidZipFileHandle(str);
        k++;
      }
      j++;
    }
    if (k < arrayOfZipEntryRO.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public FileHandle[] list(String paramString)
  {
    ZipResourceFile.ZipEntryRO[] arrayOfZipEntryRO = this.expansionFile.getEntriesAt(getPath());
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfZipEntryRO.length];
    int i = arrayOfFileHandle1.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = arrayOfZipEntryRO[j].mFileName;
      if (str.endsWith(paramString))
      {
        arrayOfFileHandle1[k] = new AndroidZipFileHandle(str);
        k++;
      }
      j++;
    }
    if (k < arrayOfZipEntryRO.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public FileHandle parent()
  {
    File localFile = this.file.getParentFile();
    if (localFile == null)
      localFile = new File("");
    return new AndroidZipFileHandle(localFile.getPath());
  }

  public InputStream read()
  {
    try
    {
      InputStream localInputStream = this.expansionFile.getInputStream(getPath());
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    throw new GdxRuntimeException("Error reading file: " + this.file + " (ZipResourceFile)", localIOException);
  }

  public FileHandle sibling(String paramString)
  {
    if (this.file.getPath().length() == 0)
      throw new GdxRuntimeException("Cannot get the sibling of the root.");
    return Gdx.files.getFileHandle(new File(this.file.getParent(), paramString).getPath(), this.type);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidZipFileHandle
 * JD-Core Version:    0.6.0
 */