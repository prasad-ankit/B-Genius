package com.badlogic.gdx.backends.android;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
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

public class AndroidFileHandle extends FileHandle
{
  private final AssetManager assets;

  AndroidFileHandle(AssetManager paramAssetManager, File paramFile, Files.FileType paramFileType)
  {
    super(paramFile, paramFileType);
    this.assets = paramAssetManager;
  }

  AndroidFileHandle(AssetManager paramAssetManager, String paramString, Files.FileType paramFileType)
  {
    super(paramString.replace('\\', '/'), paramFileType);
    this.assets = paramAssetManager;
  }

  public FileHandle child(String paramString)
  {
    String str = paramString.replace('\\', '/');
    if (this.file.getPath().length() == 0)
      return new AndroidFileHandle(this.assets, new File(str), this.type);
    return new AndroidFileHandle(this.assets, new File(this.file, str), this.type);
  }

  public boolean exists()
  {
    if (this.type == Files.FileType.Internal)
    {
      String str = this.file.getPath();
      try
      {
        this.assets.open(str).close();
        return true;
      }
      catch (Exception localException1)
      {
        try
        {
          int i;
          do
            i = this.assets.list(str).length;
          while (i > 0);
          return false;
        }
        catch (Exception localException2)
        {
          return false;
        }
      }
    }
    return super.exists();
  }

  public File file()
  {
    if (this.type == Files.FileType.Local)
      return new File(Gdx.files.getLocalStoragePath(), this.file.getPath());
    return super.file();
  }

  public AssetFileDescriptor getAssetFileDescriptor()
  {
    if (this.assets != null)
      return this.assets.openFd(path());
    return null;
  }

  public boolean isDirectory()
  {
    if (this.type == Files.FileType.Internal);
    try
    {
      int i = this.assets.list(this.file.getPath()).length;
      int j = 0;
      if (i > 0)
        j = 1;
      return j;
      return super.isDirectory();
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public long lastModified()
  {
    return super.lastModified();
  }

  // ERROR //
  public long length()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/badlogic/gdx/backends/android/AndroidFileHandle:type	Lcom/badlogic/gdx/Files$FileType;
    //   4: getstatic 60	com/badlogic/gdx/Files$FileType:Internal	Lcom/badlogic/gdx/Files$FileType;
    //   7: if_acmpne +51 -> 58
    //   10: aconst_null
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 13	com/badlogic/gdx/backends/android/AndroidFileHandle:assets	Landroid/content/res/AssetManager;
    //   16: aload_0
    //   17: getfield 29	com/badlogic/gdx/backends/android/AndroidFileHandle:file	Ljava/io/File;
    //   20: invokevirtual 35	java/io/File:getPath	()Ljava/lang/String;
    //   23: invokevirtual 107	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   26: astore 8
    //   28: aload 8
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 121	android/content/res/AssetFileDescriptor:getLength	()J
    //   35: lstore 10
    //   37: aload_3
    //   38: ifnull +7 -> 45
    //   41: aload_3
    //   42: invokevirtual 122	android/content/res/AssetFileDescriptor:close	()V
    //   45: lload 10
    //   47: lreturn
    //   48: astore 6
    //   50: aload_1
    //   51: ifnull +7 -> 58
    //   54: aload_1
    //   55: invokevirtual 122	android/content/res/AssetFileDescriptor:close	()V
    //   58: aload_0
    //   59: invokespecial 124	com/badlogic/gdx/files/FileHandle:length	()J
    //   62: lreturn
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_2
    //   67: astore 4
    //   69: aload_3
    //   70: ifnull +7 -> 77
    //   73: aload_3
    //   74: invokevirtual 122	android/content/res/AssetFileDescriptor:close	()V
    //   77: aload 4
    //   79: athrow
    //   80: astore 12
    //   82: lload 10
    //   84: lreturn
    //   85: astore 7
    //   87: goto -29 -> 58
    //   90: astore 5
    //   92: goto -15 -> 77
    //   95: astore 4
    //   97: goto -28 -> 69
    //   100: astore 9
    //   102: aload_3
    //   103: astore_1
    //   104: goto -54 -> 50
    //
    // Exception table:
    //   from	to	target	type
    //   12	28	48	java/io/IOException
    //   12	28	63	finally
    //   41	45	80	java/io/IOException
    //   54	58	85	java/io/IOException
    //   73	77	90	java/io/IOException
    //   31	37	95	finally
    //   31	37	100	java/io/IOException
  }

  public FileHandle[] list()
  {
    FileHandle[] arrayOfFileHandle;
    if (this.type == Files.FileType.Internal)
      try
      {
        String[] arrayOfString = this.assets.list(this.file.getPath());
        arrayOfFileHandle = new FileHandle[arrayOfString.length];
        int i = 0;
        int j = arrayOfFileHandle.length;
        while (i < j)
        {
          arrayOfFileHandle[i] = new AndroidFileHandle(this.assets, new File(this.file, arrayOfString[i]), this.type);
          i++;
        }
      }
      catch (Exception localException)
      {
        throw new GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", localException);
      }
    else
      arrayOfFileHandle = super.list();
    return arrayOfFileHandle;
  }

  public FileHandle[] list(FileFilter paramFileFilter)
  {
    int i = 0;
    if (this.type == Files.FileType.Internal);
    while (true)
    {
      FileHandle[] arrayOfFileHandle1;
      int k;
      try
      {
        String[] arrayOfString = this.assets.list(this.file.getPath());
        arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
        int j = arrayOfFileHandle1.length;
        k = 0;
        if (k >= j)
          continue;
        String str = arrayOfString[k];
        AndroidFileHandle localAndroidFileHandle = new AndroidFileHandle(this.assets, new File(this.file, str), this.type);
        if (!paramFileFilter.accept(localAndroidFileHandle.file()))
          break label195;
        arrayOfFileHandle1[i] = localAndroidFileHandle;
        i++;
        break label195;
        if (i >= arrayOfString.length)
          break label192;
        FileHandle[] arrayOfFileHandle2 = new FileHandle[i];
        System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, i);
        return arrayOfFileHandle2;
      }
      catch (Exception localException)
      {
        throw new GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", localException);
      }
      return super.list(paramFileFilter);
      label192: return arrayOfFileHandle1;
      label195: k++;
    }
  }

  public FileHandle[] list(FilenameFilter paramFilenameFilter)
  {
    int i = 0;
    if (this.type == Files.FileType.Internal);
    while (true)
    {
      FileHandle[] arrayOfFileHandle1;
      int k;
      try
      {
        String[] arrayOfString = this.assets.list(this.file.getPath());
        arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
        int j = arrayOfFileHandle1.length;
        k = 0;
        if (k >= j)
          continue;
        String str = arrayOfString[k];
        if (!paramFilenameFilter.accept(this.file, str))
          break label192;
        arrayOfFileHandle1[i] = new AndroidFileHandle(this.assets, new File(this.file, str), this.type);
        i++;
        break label192;
        if (i >= arrayOfString.length)
          break label189;
        FileHandle[] arrayOfFileHandle2 = new FileHandle[i];
        System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, i);
        return arrayOfFileHandle2;
      }
      catch (Exception localException)
      {
        throw new GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", localException);
      }
      return super.list(paramFilenameFilter);
      label189: return arrayOfFileHandle1;
      label192: k++;
    }
  }

  public FileHandle[] list(String paramString)
  {
    int i = 0;
    if (this.type == Files.FileType.Internal);
    while (true)
    {
      FileHandle[] arrayOfFileHandle1;
      int k;
      try
      {
        String[] arrayOfString = this.assets.list(this.file.getPath());
        arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
        int j = arrayOfFileHandle1.length;
        k = 0;
        if (k >= j)
          continue;
        String str = arrayOfString[k];
        if (!str.endsWith(paramString))
          break label186;
        arrayOfFileHandle1[i] = new AndroidFileHandle(this.assets, new File(this.file, str), this.type);
        i++;
        break label186;
        if (i >= arrayOfString.length)
          break label183;
        FileHandle[] arrayOfFileHandle2 = new FileHandle[i];
        System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, i);
        return arrayOfFileHandle2;
      }
      catch (Exception localException)
      {
        throw new GdxRuntimeException("Error listing children: " + this.file + " (" + this.type + ")", localException);
      }
      return super.list(paramString);
      label183: return arrayOfFileHandle1;
      label186: k++;
    }
  }

  public FileHandle parent()
  {
    File localFile = this.file.getParentFile();
    if (localFile == null)
      if (this.type != Files.FileType.Absolute)
        break label49;
    label49: for (localFile = new File("/"); ; localFile = new File(""))
      return new AndroidFileHandle(this.assets, localFile, this.type);
  }

  public InputStream read()
  {
    if (this.type == Files.FileType.Internal)
      try
      {
        InputStream localInputStream = this.assets.open(this.file.getPath());
        return localInputStream;
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error reading file: " + this.file + " (" + this.type + ")", localIOException);
      }
    return super.read();
  }

  public FileHandle sibling(String paramString)
  {
    String str = paramString.replace('\\', '/');
    if (this.file.getPath().length() == 0)
      throw new GdxRuntimeException("Cannot get the sibling of the root.");
    return Gdx.files.getFileHandle(new File(this.file.getParent(), str).getPath(), this.type);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidFileHandle
 * JD-Core Version:    0.6.0
 */