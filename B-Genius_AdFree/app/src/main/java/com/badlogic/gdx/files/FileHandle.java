package com.badlogic.gdx.files;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class FileHandle
{
  protected File file;
  protected Files.FileType type;

  protected FileHandle()
  {
  }

  public FileHandle(File paramFile)
  {
    this.file = paramFile;
    this.type = Files.FileType.Absolute;
  }

  protected FileHandle(File paramFile, Files.FileType paramFileType)
  {
    this.file = paramFile;
    this.type = paramFileType;
  }

  public FileHandle(String paramString)
  {
    this.file = new File(paramString);
    this.type = Files.FileType.Absolute;
  }

  protected FileHandle(String paramString, Files.FileType paramFileType)
  {
    this.type = paramFileType;
    this.file = new File(paramString);
  }

  private static void copyDirectory(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    paramFileHandle2.mkdirs();
    FileHandle[] arrayOfFileHandle = paramFileHandle1.list();
    int i = 0;
    int j = arrayOfFileHandle.length;
    if (i < j)
    {
      FileHandle localFileHandle1 = arrayOfFileHandle[i];
      FileHandle localFileHandle2 = paramFileHandle2.child(localFileHandle1.name());
      if (localFileHandle1.isDirectory())
        copyDirectory(localFileHandle1, localFileHandle2);
      while (true)
      {
        i++;
        break;
        copyFile(localFileHandle1, localFileHandle2);
      }
    }
  }

  private static void copyFile(FileHandle paramFileHandle1, FileHandle paramFileHandle2)
  {
    try
    {
      paramFileHandle2.write(paramFileHandle1.read(), false);
      return;
    }
    catch (Exception localException)
    {
    }
    throw new GdxRuntimeException("Error copying source file: " + paramFileHandle1.file + " (" + paramFileHandle1.type + ")\nTo destination: " + paramFileHandle2.file + " (" + paramFileHandle2.type + ")", localException);
  }

  private static boolean deleteDirectory(File paramFile)
  {
    emptyDirectory(paramFile, false);
    return paramFile.delete();
  }

  private static void emptyDirectory(File paramFile, boolean paramBoolean)
  {
    if (paramFile.exists())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        int j = arrayOfFile.length;
        if (i < j)
        {
          if (!arrayOfFile[i].isDirectory())
            arrayOfFile[i].delete();
          while (true)
          {
            i++;
            break;
            if (paramBoolean)
            {
              emptyDirectory(arrayOfFile[i], true);
              continue;
            }
            deleteDirectory(arrayOfFile[i]);
          }
        }
      }
    }
  }

  private int estimateLength()
  {
    int i = (int)length();
    if (i != 0)
      return i;
    return 512;
  }

  public static FileHandle tempDirectory(String paramString)
  {
    File localFile;
    try
    {
      localFile = File.createTempFile(paramString, null);
      if (!localFile.delete())
        throw new IOException("Unable to delete temp file: " + localFile);
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Unable to create temp file.", localIOException);
    }
    if (!localFile.mkdir())
      throw new IOException("Unable to create temp directory: " + localFile);
    FileHandle localFileHandle = new FileHandle(localFile);
    return localFileHandle;
  }

  public static FileHandle tempFile(String paramString)
  {
    try
    {
      FileHandle localFileHandle = new FileHandle(File.createTempFile(paramString, null));
      return localFileHandle;
    }
    catch (IOException localIOException)
    {
    }
    throw new GdxRuntimeException("Unable to create temp file.", localIOException);
  }

  public FileHandle child(String paramString)
  {
    if (this.file.getPath().length() == 0)
      return new FileHandle(new File(paramString), this.type);
    return new FileHandle(new File(this.file, paramString), this.type);
  }

  public void copyTo(FileHandle paramFileHandle)
  {
    boolean bool = isDirectory();
    if (!bool)
    {
      if (paramFileHandle.isDirectory())
        paramFileHandle = paramFileHandle.child(name());
      copyFile(this, paramFileHandle);
      return;
    }
    if (paramFileHandle.exists())
    {
      if (!paramFileHandle.isDirectory())
        throw new GdxRuntimeException("Destination exists but is not a directory: " + paramFileHandle);
    }
    else
    {
      paramFileHandle.mkdirs();
      if (!paramFileHandle.isDirectory())
        throw new GdxRuntimeException("Destination directory cannot be created: " + paramFileHandle);
    }
    if (!bool)
      paramFileHandle = paramFileHandle.child(name());
    copyDirectory(this, paramFileHandle);
  }

  public boolean delete()
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
    return file().delete();
  }

  public boolean deleteDirectory()
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
    return deleteDirectory(file());
  }

  public void emptyDirectory()
  {
    emptyDirectory(false);
  }

  public void emptyDirectory(boolean paramBoolean)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot delete a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot delete an internal file: " + this.file);
    emptyDirectory(file(), paramBoolean);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FileHandle));
    FileHandle localFileHandle;
    do
    {
      return false;
      localFileHandle = (FileHandle)paramObject;
    }
    while ((this.type != localFileHandle.type) || (!path().equals(localFileHandle.path())));
    return true;
  }

  public boolean exists()
  {
    boolean bool = true;
    switch (FileHandle.1.$SwitchMap$com$badlogic$gdx$Files$FileType[this.type.ordinal()])
    {
    default:
      bool = file().exists();
    case 1:
    case 2:
    }
    do
      return bool;
    while ((file().exists()) || (FileHandle.class.getResource("/" + this.file.getPath().replace('\\', '/')) != null));
    return false;
  }

  public String extension()
  {
    String str = this.file.getName();
    int i = str.lastIndexOf('.');
    if (i == -1)
      return "";
    return str.substring(i + 1);
  }

  public File file()
  {
    if (this.type == Files.FileType.External)
      return new File(Gdx.files.getExternalStoragePath(), this.file.getPath());
    return this.file;
  }

  public int hashCode()
  {
    return 67 * (37 + this.type.hashCode()) + path().hashCode();
  }

  public boolean isDirectory()
  {
    if (this.type == Files.FileType.Classpath)
      return false;
    return file().isDirectory();
  }

  public long lastModified()
  {
    return file().lastModified();
  }

  // ERROR //
  public long length()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/badlogic/gdx/files/FileHandle:type	Lcom/badlogic/gdx/Files$FileType;
    //   4: getstatic 159	com/badlogic/gdx/Files$FileType:Classpath	Lcom/badlogic/gdx/Files$FileType;
    //   7: if_acmpeq +23 -> 30
    //   10: aload_0
    //   11: getfield 22	com/badlogic/gdx/files/FileHandle:type	Lcom/badlogic/gdx/Files$FileType;
    //   14: getstatic 164	com/badlogic/gdx/Files$FileType:Internal	Lcom/badlogic/gdx/Files$FileType;
    //   17: if_acmpne +50 -> 67
    //   20: aload_0
    //   21: getfield 15	com/badlogic/gdx/files/FileHandle:file	Ljava/io/File;
    //   24: invokevirtual 103	java/io/File:exists	()Z
    //   27: ifne +40 -> 67
    //   30: aload_0
    //   31: invokevirtual 61	com/badlogic/gdx/files/FileHandle:read	()Ljava/io/InputStream;
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 243	java/io/InputStream:available	()I
    //   39: istore 4
    //   41: iload 4
    //   43: i2l
    //   44: lstore 5
    //   46: aload_1
    //   47: invokestatic 249	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   50: lload 5
    //   52: lreturn
    //   53: astore_3
    //   54: aload_1
    //   55: invokestatic 249	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   58: lconst_0
    //   59: lreturn
    //   60: astore_2
    //   61: aload_1
    //   62: invokestatic 249	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   65: aload_2
    //   66: athrow
    //   67: aload_0
    //   68: invokevirtual 169	com/badlogic/gdx/files/FileHandle:file	()Ljava/io/File;
    //   71: invokevirtual 250	java/io/File:length	()J
    //   74: lreturn
    //
    // Exception table:
    //   from	to	target	type
    //   35	41	53	java/lang/Exception
    //   35	41	60	finally
  }

  public FileHandle[] list()
  {
    int i = 0;
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
    String[] arrayOfString = file().list();
    FileHandle[] arrayOfFileHandle;
    if (arrayOfString == null)
      arrayOfFileHandle = new FileHandle[0];
    while (true)
    {
      return arrayOfFileHandle;
      arrayOfFileHandle = new FileHandle[arrayOfString.length];
      int j = arrayOfString.length;
      while (i < j)
      {
        arrayOfFileHandle[i] = child(arrayOfString[i]);
        i++;
      }
    }
  }

  public FileHandle[] list(FileFilter paramFileFilter)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
    String[] arrayOfString = file().list();
    if (arrayOfString == null)
      return new FileHandle[0];
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
    int i = arrayOfString.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      FileHandle localFileHandle = child(arrayOfString[j]);
      if (paramFileFilter.accept(localFileHandle.file()))
      {
        arrayOfFileHandle1[k] = localFileHandle;
        k++;
      }
      j++;
    }
    if (k < arrayOfString.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public FileHandle[] list(FilenameFilter paramFilenameFilter)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
    File localFile = file();
    String[] arrayOfString = localFile.list();
    if (arrayOfString == null)
      return new FileHandle[0];
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
    int i = arrayOfString.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      if (paramFilenameFilter.accept(localFile, str))
      {
        arrayOfFileHandle1[k] = child(str);
        k++;
      }
      j++;
    }
    if (k < arrayOfString.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public FileHandle[] list(String paramString)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot list a classpath directory: " + this.file);
    String[] arrayOfString = file().list();
    if (arrayOfString == null)
      return new FileHandle[0];
    FileHandle[] arrayOfFileHandle1 = new FileHandle[arrayOfString.length];
    int i = arrayOfString.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      if (str.endsWith(paramString))
      {
        arrayOfFileHandle1[k] = child(str);
        k++;
      }
      j++;
    }
    if (k < arrayOfString.length)
    {
      FileHandle[] arrayOfFileHandle2 = new FileHandle[k];
      System.arraycopy(arrayOfFileHandle1, 0, arrayOfFileHandle2, 0, k);
      return arrayOfFileHandle2;
    }
    return arrayOfFileHandle1;
  }

  public void mkdirs()
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot mkdirs with a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot mkdirs with an internal file: " + this.file);
    file().mkdirs();
  }

  public void moveTo(FileHandle paramFileHandle)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot move a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot move an internal file: " + this.file);
    copyTo(paramFileHandle);
    delete();
    if ((exists()) && (isDirectory()))
      deleteDirectory();
  }

  public String name()
  {
    return this.file.getName();
  }

  public String nameWithoutExtension()
  {
    String str = this.file.getName();
    int i = str.lastIndexOf('.');
    if (i == -1)
      return str;
    return str.substring(0, i);
  }

  public FileHandle parent()
  {
    File localFile = this.file.getParentFile();
    if (localFile == null)
      if (this.type != Files.FileType.Absolute)
        break label45;
    label45: for (localFile = new File("/"); ; localFile = new File(""))
      return new FileHandle(localFile, this.type);
  }

  public String path()
  {
    return this.file.getPath().replace('\\', '/');
  }

  public String pathWithoutExtension()
  {
    String str = this.file.getPath().replace('\\', '/');
    int i = str.lastIndexOf('.');
    if (i == -1)
      return str;
    return str.substring(0, i);
  }

  public BufferedInputStream read(int paramInt)
  {
    return new BufferedInputStream(read(), paramInt);
  }

  public InputStream read()
  {
    Object localObject;
    if ((this.type == Files.FileType.Classpath) || ((this.type == Files.FileType.Internal) && (!file().exists())) || ((this.type == Files.FileType.Local) && (!file().exists())))
    {
      localObject = FileHandle.class.getResourceAsStream("/" + this.file.getPath().replace('\\', '/'));
      if (localObject != null)
        break label146;
      throw new GdxRuntimeException("File not found: " + this.file + " (" + this.type + ")");
    }
    try
    {
      localObject = new FileInputStream(file());
      label146: return localObject;
    }
    catch (Exception localException)
    {
      if (file().isDirectory())
        throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", localException);
    }
    throw new GdxRuntimeException("Error reading file: " + this.file + " (" + this.type + ")", localException);
  }

  public int readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    InputStream localInputStream = read();
    int i = 0;
    while (true)
    {
      int j = paramInt1 + i;
      int k = paramInt2 - i;
      try
      {
        int m = localInputStream.read(paramArrayOfByte, j, k);
        if (m > 0)
        {
          i += m;
          continue;
        }
        return i - paramInt1;
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error reading file: " + this, localIOException);
      }
      finally
      {
        StreamUtils.closeQuietly(localInputStream);
      }
    }
    throw localObject;
  }

  public byte[] readBytes()
  {
    InputStream localInputStream = read();
    try
    {
      byte[] arrayOfByte = StreamUtils.copyStreamToByteArray(localInputStream, estimateLength());
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Error reading file: " + this, localIOException);
    }
    finally
    {
      StreamUtils.closeQuietly(localInputStream);
    }
    throw localObject;
  }

  public String readString()
  {
    return readString(null);
  }

  public String readString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(estimateLength());
    Object localObject1 = null;
    if (paramString == null);
    while (true)
    {
      try
      {
        localObject1 = new InputStreamReader(read());
        char[] arrayOfChar = new char[256];
        int i = ((InputStreamReader)localObject1).read(arrayOfChar);
        if (i == -1)
          break;
        localStringBuilder.append(arrayOfChar, 0, i);
        continue;
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error reading layout file: " + this, localIOException);
      }
      finally
      {
        StreamUtils.closeQuietly((Closeable)localObject1);
      }
      InputStreamReader localInputStreamReader = new InputStreamReader(read(), paramString);
      localObject1 = localInputStreamReader;
    }
    StreamUtils.closeQuietly((Closeable)localObject1);
    return (String)localStringBuilder.toString();
  }

  public BufferedReader reader(int paramInt)
  {
    return new BufferedReader(new InputStreamReader(read()), paramInt);
  }

  public BufferedReader reader(int paramInt, String paramString)
  {
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(read(), paramString), paramInt);
      return localBufferedReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw new GdxRuntimeException("Error reading file: " + this, localUnsupportedEncodingException);
  }

  public Reader reader()
  {
    return new InputStreamReader(read());
  }

  public Reader reader(String paramString)
  {
    InputStream localInputStream = read();
    try
    {
      InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream, paramString);
      return localInputStreamReader;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      StreamUtils.closeQuietly(localInputStream);
    }
    throw new GdxRuntimeException("Error reading file: " + this, localUnsupportedEncodingException);
  }

  public FileHandle sibling(String paramString)
  {
    if (this.file.getPath().length() == 0)
      throw new GdxRuntimeException("Cannot get the sibling of the root.");
    return new FileHandle(new File(this.file.getParent(), paramString), this.type);
  }

  public String toString()
  {
    return this.file.getPath().replace('\\', '/');
  }

  public Files.FileType type()
  {
    return this.type;
  }

  public OutputStream write(boolean paramBoolean)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot write to an internal file: " + this.file);
    parent().mkdirs();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(file(), paramBoolean);
      return localFileOutputStream;
    }
    catch (Exception localException)
    {
      if (file().isDirectory())
        throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", localException);
    }
    throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", localException);
  }

  public OutputStream write(boolean paramBoolean, int paramInt)
  {
    return new BufferedOutputStream(write(paramBoolean), paramInt);
  }

  public void write(InputStream paramInputStream, boolean paramBoolean)
  {
    OutputStream localOutputStream = null;
    try
    {
      localOutputStream = write(paramBoolean);
      StreamUtils.copyStream(paramInputStream, localOutputStream);
      return;
    }
    catch (Exception localException)
    {
      throw new GdxRuntimeException("Error stream writing to file: " + this.file + " (" + this.type + ")", localException);
    }
    finally
    {
      StreamUtils.closeQuietly(paramInputStream);
      StreamUtils.closeQuietly(localOutputStream);
    }
    throw localObject;
  }

  public void writeBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    OutputStream localOutputStream = write(paramBoolean);
    try
    {
      localOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", localIOException);
    }
    finally
    {
      StreamUtils.closeQuietly(localOutputStream);
    }
    throw localObject;
  }

  public void writeBytes(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    OutputStream localOutputStream = write(paramBoolean);
    try
    {
      localOutputStream.write(paramArrayOfByte);
      return;
    }
    catch (IOException localIOException)
    {
      throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", localIOException);
    }
    finally
    {
      StreamUtils.closeQuietly(localOutputStream);
    }
    throw localObject;
  }

  public void writeString(String paramString, boolean paramBoolean)
  {
    writeString(paramString, paramBoolean, null);
  }

  public void writeString(String paramString1, boolean paramBoolean, String paramString2)
  {
    Writer localWriter = null;
    try
    {
      localWriter = writer(paramBoolean, paramString2);
      localWriter.write(paramString1);
      return;
    }
    catch (Exception localException)
    {
      throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", localException);
    }
    finally
    {
      StreamUtils.closeQuietly(localWriter);
    }
    throw localObject;
  }

  public Writer writer(boolean paramBoolean)
  {
    return writer(paramBoolean, null);
  }

  public Writer writer(boolean paramBoolean, String paramString)
  {
    if (this.type == Files.FileType.Classpath)
      throw new GdxRuntimeException("Cannot write to a classpath file: " + this.file);
    if (this.type == Files.FileType.Internal)
      throw new GdxRuntimeException("Cannot write to an internal file: " + this.file);
    parent().mkdirs();
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(file(), paramBoolean);
      if (paramString == null)
        return new OutputStreamWriter(localFileOutputStream);
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localFileOutputStream, paramString);
      return localOutputStreamWriter;
    }
    catch (IOException localIOException)
    {
      if (file().isDirectory())
        throw new GdxRuntimeException("Cannot open a stream to a directory: " + this.file + " (" + this.type + ")", localIOException);
    }
    throw new GdxRuntimeException("Error writing file: " + this.file + " (" + this.type + ")", localIOException);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.files.FileHandle
 * JD-Core Version:    0.6.0
 */