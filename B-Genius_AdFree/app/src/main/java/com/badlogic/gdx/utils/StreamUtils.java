package com.badlogic.gdx.utils;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public final class StreamUtils
{
  public static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final byte[] EMPTY_BYTES = new byte[0];

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static int copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer, byte[] paramArrayOfByte)
  {
    int i = paramByteBuffer.position();
    int j = 0;
    while (true)
    {
      int k = paramInputStream.read(paramArrayOfByte);
      if (k == -1)
        break;
      BufferUtils.copy(paramArrayOfByte, 0, paramByteBuffer, k);
      j += k;
      paramByteBuffer.position(i + j);
    }
    paramByteBuffer.position(i);
    return j;
  }

  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    copyStream(paramInputStream, paramOutputStream, new byte[4096]);
  }

  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
  {
    copyStream(paramInputStream, paramOutputStream, new byte[paramInt]);
  }

  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    while (true)
    {
      int i = paramInputStream.read(paramArrayOfByte);
      if (i == -1)
        break;
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
  }

  public static void copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer)
  {
    copyStream(paramInputStream, paramByteBuffer, new byte[4096]);
  }

  public static void copyStream(InputStream paramInputStream, ByteBuffer paramByteBuffer, int paramInt)
  {
    copyStream(paramInputStream, paramByteBuffer, new byte[paramInt]);
  }

  public static byte[] copyStreamToByteArray(InputStream paramInputStream)
  {
    return copyStreamToByteArray(paramInputStream, paramInputStream.available());
  }

  public static byte[] copyStreamToByteArray(InputStream paramInputStream, int paramInt)
  {
    StreamUtils.OptimizedByteArrayOutputStream localOptimizedByteArrayOutputStream = new StreamUtils.OptimizedByteArrayOutputStream(Math.max(0, paramInt));
    copyStream(paramInputStream, localOptimizedByteArrayOutputStream);
    return localOptimizedByteArrayOutputStream.toByteArray();
  }

  public static String copyStreamToString(InputStream paramInputStream)
  {
    return copyStreamToString(paramInputStream, paramInputStream.available(), null);
  }

  public static String copyStreamToString(InputStream paramInputStream, int paramInt)
  {
    return copyStreamToString(paramInputStream, paramInt, null);
  }

  public static String copyStreamToString(InputStream paramInputStream, int paramInt, String paramString)
  {
    if (paramString == null);
    StringWriter localStringWriter;
    for (InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream); ; localInputStreamReader = new InputStreamReader(paramInputStream, paramString))
    {
      localStringWriter = new StringWriter(Math.max(0, paramInt));
      char[] arrayOfChar = new char[4096];
      while (true)
      {
        int i = localInputStreamReader.read(arrayOfChar);
        if (i == -1)
          break;
        localStringWriter.write(arrayOfChar, 0, i);
      }
    }
    return localStringWriter.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.StreamUtils
 * JD-Core Version:    0.6.0
 */