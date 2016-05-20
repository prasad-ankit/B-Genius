package com.badlogic.gdx.utils;

public class DataBuffer extends DataOutput
{
  private final StreamUtils.OptimizedByteArrayOutputStream outStream = (StreamUtils.OptimizedByteArrayOutputStream)this.out;

  public DataBuffer()
  {
    this(32);
  }

  public DataBuffer(int paramInt)
  {
    super(new StreamUtils.OptimizedByteArrayOutputStream(paramInt));
  }

  public byte[] getBuffer()
  {
    return this.outStream.getBuffer();
  }

  public byte[] toArray()
  {
    return this.outStream.toByteArray();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.DataBuffer
 * JD-Core Version:    0.6.0
 */