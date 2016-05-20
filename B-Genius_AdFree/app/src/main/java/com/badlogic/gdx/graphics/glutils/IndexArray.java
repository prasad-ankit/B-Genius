package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class IndexArray
  implements IndexData
{
  static final IntBuffer tmpHandle = BufferUtils.newIntBuffer(1);
  ShortBuffer buffer;
  ByteBuffer byteBuffer;
  private final boolean empty;

  public IndexArray(int paramInt)
  {
    int j;
    if (paramInt == 0)
    {
      j = i;
      this.empty = j;
      if (!this.empty)
        break label67;
    }
    while (true)
    {
      this.byteBuffer = BufferUtils.newUnsafeByteBuffer(i << 1);
      this.buffer = this.byteBuffer.asShortBuffer();
      this.buffer.flip();
      this.byteBuffer.flip();
      return;
      j = 0;
      break;
      label67: i = paramInt;
    }
  }

  public void bind()
  {
  }

  public void dispose()
  {
    BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
  }

  public ShortBuffer getBuffer()
  {
    return this.buffer;
  }

  public int getNumIndices()
  {
    if (this.empty)
      return 0;
    return this.buffer.limit();
  }

  public int getNumMaxIndices()
  {
    if (this.empty)
      return 0;
    return this.buffer.capacity();
  }

  public void invalidate()
  {
  }

  public void setIndices(ShortBuffer paramShortBuffer)
  {
    int i = paramShortBuffer.position();
    this.buffer.clear();
    this.buffer.limit(paramShortBuffer.remaining());
    this.buffer.put(paramShortBuffer);
    this.buffer.flip();
    paramShortBuffer.position(i);
    this.byteBuffer.position(0);
    this.byteBuffer.limit(this.buffer.limit() << 1);
  }

  public void setIndices(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.buffer.clear();
    this.buffer.put(paramArrayOfShort, paramInt1, paramInt2);
    this.buffer.flip();
    this.byteBuffer.position(0);
    this.byteBuffer.limit(paramInt2 << 1);
  }

  public void unbind()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.IndexArray
 * JD-Core Version:    0.6.0
 */