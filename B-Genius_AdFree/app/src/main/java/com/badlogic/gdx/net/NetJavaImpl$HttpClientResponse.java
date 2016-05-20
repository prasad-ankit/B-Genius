package com.badlogic.gdx.net;

import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.utils.StreamUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

class NetJavaImpl$HttpClientResponse
  implements Net.HttpResponse
{
  private final HttpURLConnection connection;
  private HttpStatus status;

  public NetJavaImpl$HttpClientResponse(HttpURLConnection paramHttpURLConnection)
  {
    this.connection = paramHttpURLConnection;
    try
    {
      this.status = new HttpStatus(paramHttpURLConnection.getResponseCode());
      return;
    }
    catch (IOException localIOException)
    {
      this.status = new HttpStatus(-1);
    }
  }

  private InputStream getInputStream()
  {
    try
    {
      InputStream localInputStream = this.connection.getInputStream();
      return localInputStream;
    }
    catch (IOException localIOException)
    {
    }
    return this.connection.getErrorStream();
  }

  public String getHeader(String paramString)
  {
    return this.connection.getHeaderField(paramString);
  }

  public Map getHeaders()
  {
    return this.connection.getHeaderFields();
  }

  public byte[] getResult()
  {
    InputStream localInputStream = getInputStream();
    if (localInputStream == null)
      return StreamUtils.EMPTY_BYTES;
    try
    {
      byte[] arrayOfByte2 = StreamUtils.copyStreamToByteArray(localInputStream, this.connection.getContentLength());
      return arrayOfByte2;
    }
    catch (IOException localIOException)
    {
      byte[] arrayOfByte1 = StreamUtils.EMPTY_BYTES;
      return arrayOfByte1;
    }
    finally
    {
      StreamUtils.closeQuietly(localInputStream);
    }
    throw localObject;
  }

  public InputStream getResultAsStream()
  {
    return getInputStream();
  }

  // ERROR //
  public String getResultAsString()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 52	com/badlogic/gdx/net/NetJavaImpl$HttpClientResponse:getInputStream	()Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +6 -> 12
    //   9: ldc 74
    //   11: areturn
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 19	com/badlogic/gdx/net/NetJavaImpl$HttpClientResponse:connection	Ljava/net/HttpURLConnection;
    //   17: invokevirtual 61	java/net/HttpURLConnection:getContentLength	()I
    //   20: invokestatic 78	com/badlogic/gdx/utils/StreamUtils:copyStreamToString	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   23: astore 4
    //   25: aload_1
    //   26: invokestatic 69	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   29: aload 4
    //   31: areturn
    //   32: astore_3
    //   33: aload_1
    //   34: invokestatic 69	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   37: ldc 74
    //   39: areturn
    //   40: astore_2
    //   41: aload_1
    //   42: invokestatic 69	com/badlogic/gdx/utils/StreamUtils:closeQuietly	(Ljava/io/Closeable;)V
    //   45: aload_2
    //   46: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   12	25	32	java/io/IOException
    //   12	25	40	finally
  }

  public HttpStatus getStatus()
  {
    return this.status;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.net.NetJavaImpl.HttpClientResponse
 * JD-Core Version:    0.6.0
 */