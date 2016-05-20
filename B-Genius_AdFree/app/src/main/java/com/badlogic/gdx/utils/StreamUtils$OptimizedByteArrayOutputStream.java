package com.badlogic.gdx.utils;

import java.io.ByteArrayOutputStream;

public class StreamUtils$OptimizedByteArrayOutputStream extends ByteArrayOutputStream
{
  public StreamUtils$OptimizedByteArrayOutputStream(int paramInt)
  {
    super(paramInt);
  }

  public byte[] getBuffer()
  {
    return this.buf;
  }

  public byte[] toByteArray()
  {
    monitorenter;
    try
    {
      if (this.count == this.buf.length);
      byte[] arrayOfByte;
      for (Object localObject2 = this.buf; ; localObject2 = arrayOfByte)
      {
        return localObject2;
        arrayOfByte = super.toByteArray();
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject1;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.StreamUtils.OptimizedByteArrayOutputStream
 * JD-Core Version:    0.6.0
 */