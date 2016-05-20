package com.badlogic.gdx.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SharedLibraryLoader
{
  public static String abi;
  public static boolean is64Bit;
  public static boolean isARM;
  public static boolean isAndroid;
  public static boolean isIos;
  public static boolean isLinux;
  public static boolean isMac;
  public static boolean isWindows = System.getProperty("os.name").contains("Windows");
  private static final HashSet loadedLibraries;
  private String nativesJar;

  static
  {
    isLinux = System.getProperty("os.name").contains("Linux");
    isMac = System.getProperty("os.name").contains("Mac");
    isIos = false;
    isAndroid = false;
    isARM = System.getProperty("os.arch").startsWith("arm");
    boolean bool;
    if ((System.getProperty("os.arch").equals("amd64")) || (System.getProperty("os.arch").equals("x86_64")))
    {
      bool = true;
      is64Bit = bool;
      if (System.getProperty("sun.arch.abi") == null)
        break label197;
    }
    label197: for (String str1 = System.getProperty("sun.arch.abi"); ; str1 = "")
    {
      abi = str1;
      String str2 = System.getProperty("java.runtime.name");
      if ((str2 != null) && (str2.contains("Android Runtime")))
      {
        isAndroid = true;
        isWindows = false;
        isLinux = false;
        isMac = false;
        is64Bit = false;
      }
      if ((!isAndroid) && (!isWindows) && (!isLinux) && (!isMac))
      {
        isIos = true;
        is64Bit = false;
      }
      loadedLibraries = new HashSet();
      return;
      bool = false;
      break;
    }
  }

  public SharedLibraryLoader()
  {
  }

  public SharedLibraryLoader(String paramString)
  {
    this.nativesJar = paramString;
  }

  private boolean canExecute(File paramFile)
  {
    try
    {
      Method localMethod1 = File.class.getMethod("canExecute", new Class[0]);
      if (((Boolean)localMethod1.invoke(paramFile, new Object[0])).booleanValue())
        return true;
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Boolean.TYPE;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod2 = File.class.getMethod("setExecutable", arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Boolean.valueOf(true);
      arrayOfObject[1] = Boolean.valueOf(false);
      localMethod2.invoke(paramFile, arrayOfObject);
      boolean bool = ((Boolean)localMethod1.invoke(paramFile, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  // ERROR //
  private boolean canWrite(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 132	java/io/File:getParentFile	()Ljava/io/File;
    //   4: astore_2
    //   5: aload_1
    //   6: invokevirtual 135	java/io/File:exists	()Z
    //   9: ifeq +65 -> 74
    //   12: aload_1
    //   13: invokevirtual 137	java/io/File:canWrite	()Z
    //   16: ifeq +11 -> 27
    //   19: aload_0
    //   20: aload_1
    //   21: invokespecial 139	com/badlogic/gdx/utils/SharedLibraryLoader:canExecute	(Ljava/io/File;)Z
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: new 96	java/io/File
    //   32: dup
    //   33: aload_2
    //   34: invokestatic 145	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   37: invokevirtual 149	java/util/UUID:toString	()Ljava/lang/String;
    //   40: invokespecial 152	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_1
    //   44: new 154	java/io/FileOutputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 157	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   52: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   55: aload_0
    //   56: aload_1
    //   57: invokespecial 139	com/badlogic/gdx/utils/SharedLibraryLoader:canExecute	(Ljava/io/File;)Z
    //   60: istore 8
    //   62: iload 8
    //   64: ifne +24 -> 88
    //   67: aload_1
    //   68: invokevirtual 163	java/io/File:delete	()Z
    //   71: pop
    //   72: iconst_0
    //   73: ireturn
    //   74: aload_2
    //   75: invokevirtual 166	java/io/File:mkdirs	()Z
    //   78: pop
    //   79: aload_2
    //   80: invokevirtual 169	java/io/File:isDirectory	()Z
    //   83: ifne -39 -> 44
    //   86: iconst_0
    //   87: ireturn
    //   88: aload_1
    //   89: invokevirtual 163	java/io/File:delete	()Z
    //   92: pop
    //   93: iconst_1
    //   94: ireturn
    //   95: astore 6
    //   97: aload_1
    //   98: invokevirtual 163	java/io/File:delete	()Z
    //   101: pop
    //   102: iconst_0
    //   103: ireturn
    //   104: astore 4
    //   106: aload_1
    //   107: invokevirtual 163	java/io/File:delete	()Z
    //   110: pop
    //   111: aload 4
    //   113: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   44	62	95	java/lang/Throwable
    //   44	62	104	finally
  }

  private File extractFile(String paramString1, String paramString2, File paramFile)
  {
    boolean bool = paramFile.exists();
    Object localObject = null;
    if (bool);
    try
    {
      String str = crc(new FileInputStream(paramFile));
      localObject = str;
      if ((localObject == null) || (!localObject.equals(paramString2)))
      {
        InputStream localInputStream;
        FileOutputStream localFileOutputStream;
        try
        {
          localInputStream = readFile(paramString1);
          paramFile.getParentFile().mkdirs();
          localFileOutputStream = new FileOutputStream(paramFile);
          byte[] arrayOfByte = new byte[4096];
          while (true)
          {
            int i = localInputStream.read(arrayOfByte);
            if (i == -1)
              break;
            localFileOutputStream.write(arrayOfByte, 0, i);
          }
        }
        catch (IOException localIOException)
        {
          throw new GdxRuntimeException("Error extracting file: " + paramString1 + "\nTo: " + paramFile.getAbsolutePath(), localIOException);
        }
        localInputStream.close();
        localFileOutputStream.close();
      }
      return paramFile;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      while (true)
        localObject = null;
    }
  }

  private File getExtractedFile(String paramString1, String paramString2)
  {
    File localFile1 = new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + paramString1, paramString2);
    if (canWrite(localFile1));
    File localFile3;
    do
    {
      return localFile1;
      try
      {
        File localFile4 = File.createTempFile(paramString1, null);
        if (localFile4.delete())
        {
          File localFile5 = new File(localFile4, paramString2);
          boolean bool = canWrite(localFile5);
          if (bool)
            return localFile5;
        }
      }
      catch (IOException localIOException)
      {
        File localFile2 = new File(System.getProperty("user.home") + "/.libgdx/" + paramString1, paramString2);
        if (canWrite(localFile2))
          return localFile2;
        localFile3 = new File(".temp/" + paramString1, paramString2);
      }
    }
    while (!canWrite(localFile3));
    return localFile3;
  }

  private Throwable loadFile(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      System.load(extractFile(paramString1, paramString2, paramFile).getAbsolutePath());
      return null;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localThrowable;
  }

  private void loadFile(String paramString)
  {
    String str1 = crc(readFile(paramString));
    String str2 = new File(paramString).getName();
    Throwable localThrowable1 = loadFile(paramString, str1, new File(System.getProperty("java.io.tmpdir") + "/libgdx" + System.getProperty("user.name") + "/" + str1, str2));
    if (localThrowable1 == null);
    while (true)
    {
      return;
      try
      {
        File localFile2 = File.createTempFile(str1, null);
        if (localFile2.delete())
        {
          Throwable localThrowable3 = loadFile(paramString, str1, localFile2);
          if (localThrowable3 == null)
            continue;
        }
        label114: if ((loadFile(paramString, str1, new File(System.getProperty("user.home") + "/.libgdx/" + str1, str2)) == null) || (loadFile(paramString, str1, new File(".temp/" + str1, str2)) == null))
          continue;
        File localFile1 = new File(System.getProperty("java.library.path"), paramString);
        if (localFile1.exists())
        {
          System.load(localFile1.getAbsolutePath());
          return;
        }
        throw new GdxRuntimeException(localThrowable1);
      }
      catch (Throwable localThrowable2)
      {
        break label114;
      }
    }
  }

  private InputStream readFile(String paramString)
  {
    Object localObject;
    if (this.nativesJar == null)
    {
      localObject = SharedLibraryLoader.class.getResourceAsStream("/" + paramString);
      if (localObject == null)
        throw new GdxRuntimeException("Unable to read file for extraction: " + paramString);
    }
    else
    {
      ZipFile localZipFile;
      ZipEntry localZipEntry;
      try
      {
        localZipFile = new ZipFile(this.nativesJar);
        localZipEntry = localZipFile.getEntry(paramString);
        if (localZipEntry == null)
          throw new GdxRuntimeException("Couldn't find '" + paramString + "' in JAR: " + this.nativesJar);
      }
      catch (IOException localIOException)
      {
        throw new GdxRuntimeException("Error reading '" + paramString + "' in JAR: " + this.nativesJar, localIOException);
      }
      InputStream localInputStream = localZipFile.getInputStream(localZipEntry);
      localObject = localInputStream;
    }
    return (InputStream)localObject;
  }

  public String crc(InputStream paramInputStream)
  {
    if (paramInputStream == null)
      throw new IllegalArgumentException("input cannot be null.");
    CRC32 localCRC32 = new CRC32();
    byte[] arrayOfByte = new byte[4096];
    try
    {
      while (true)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        localCRC32.update(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      StreamUtils.closeQuietly(paramInputStream);
    }
    return Long.toString(localCRC32.getValue(), 16);
  }

  public File extractFile(String paramString1, String paramString2)
  {
    try
    {
      String str = crc(readFile(paramString1));
      if (paramString2 == null)
        paramString2 = str;
      File localFile2 = extractFile(paramString1, str, getExtractedFile(paramString2, new File(paramString1).getName()));
      localFile1 = localFile2;
      return localFile1;
    }
    catch (RuntimeException localRuntimeException)
    {
      File localFile1;
      do
        localFile1 = new File(System.getProperty("java.library.path"), paramString1);
      while (localFile1.exists());
    }
    throw localRuntimeException;
  }

  // ERROR //
  public void load(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 47	com/badlogic/gdx/utils/SharedLibraryLoader:isIos	Z
    //   5: istore_3
    //   6: iload_3
    //   7: ifeq +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 320	com/badlogic/gdx/utils/SharedLibraryLoader:mapLibraryName	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore 4
    //   20: getstatic 84	com/badlogic/gdx/utils/SharedLibraryLoader:loadedLibraries	Ljava/util/HashSet;
    //   23: aload 4
    //   25: invokevirtual 322	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   28: istore 5
    //   30: iload 5
    //   32: ifne -22 -> 10
    //   35: getstatic 49	com/badlogic/gdx/utils/SharedLibraryLoader:isAndroid	Z
    //   38: ifeq +25 -> 63
    //   41: aload 4
    //   43: invokestatic 325	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   46: getstatic 84	com/badlogic/gdx/utils/SharedLibraryLoader:loadedLibraries	Ljava/util/HashSet;
    //   49: aload 4
    //   51: invokevirtual 328	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: goto -45 -> 10
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    //   63: aload_0
    //   64: aload 4
    //   66: invokespecial 330	com/badlogic/gdx/utils/SharedLibraryLoader:loadFile	(Ljava/lang/String;)V
    //   69: goto -23 -> 46
    //   72: astore 6
    //   74: new 200	java/lang/StringBuilder
    //   77: dup
    //   78: ldc_w 332
    //   81: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 334
    //   92: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 21
    //   97: invokestatic 27	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 7
    //   105: getstatic 69	com/badlogic/gdx/utils/SharedLibraryLoader:is64Bit	Z
    //   108: ifeq +28 -> 136
    //   111: ldc_w 336
    //   114: astore 8
    //   116: new 198	com/badlogic/gdx/utils/GdxRuntimeException
    //   119: dup
    //   120: aload 7
    //   122: aload 8
    //   124: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: aload 6
    //   132: invokespecial 217	com/badlogic/gdx/utils/GdxRuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: athrow
    //   136: ldc_w 338
    //   139: astore 8
    //   141: goto -25 -> 116
    //
    // Exception table:
    //   from	to	target	type
    //   2	6	58	finally
    //   13	30	58	finally
    //   35	46	58	finally
    //   46	55	58	finally
    //   63	69	58	finally
    //   74	111	58	finally
    //   116	136	58	finally
    //   35	46	72	java/lang/Throwable
    //   63	69	72	java/lang/Throwable
  }

  public String mapLibraryName(String paramString)
  {
    String str4;
    if (isWindows)
    {
      StringBuilder localStringBuilder4 = new StringBuilder().append(paramString);
      if (is64Bit)
      {
        str4 = "64.dll";
        paramString = str4;
      }
    }
    label137: 
    do
    {
      return paramString;
      str4 = ".dll";
      break;
      if (!isLinux)
        continue;
      StringBuilder localStringBuilder2 = new StringBuilder("lib").append(paramString);
      String str2;
      StringBuilder localStringBuilder3;
      if (isARM)
      {
        str2 = "arm" + abi;
        localStringBuilder3 = localStringBuilder2.append(str2);
        if (!is64Bit)
          break label137;
      }
      for (String str3 = "64.so"; ; str3 = ".so")
      {
        return str3;
        str2 = "";
        break;
      }
    }
    while (!isMac);
    StringBuilder localStringBuilder1 = new StringBuilder("lib").append(paramString);
    if (is64Bit);
    for (String str1 = "64.dylib"; ; str1 = ".dylib")
      return str1;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.SharedLibraryLoader
 * JD-Core Version:    0.6.0
 */