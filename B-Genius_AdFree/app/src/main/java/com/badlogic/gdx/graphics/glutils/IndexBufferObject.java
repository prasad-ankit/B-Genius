package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObject
  implements IndexData
{
  ShortBuffer buffer;
  int bufferHandle;
  ByteBuffer byteBuffer;
  private final boolean empty;
  boolean isBound = false;
  final boolean isDirect;
  boolean isDirty = true;
  final int usage;

  public IndexBufferObject(int paramInt)
  {
    this(true, paramInt);
  }

  public IndexBufferObject(boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (paramInt == 0)
      bool = true;
    this.empty = bool;
    if (this.empty)
      paramInt = 1;
    this.byteBuffer = BufferUtils.newUnsafeByteBuffer(paramInt << 1);
    this.isDirect = true;
    this.buffer = this.byteBuffer.asShortBuffer();
    this.buffer.flip();
    this.byteBuffer.flip();
    this.bufferHandle = Gdx.gl20.glGenBuffer();
    if (paramBoolean);
    for (int i = 35044; ; i = 35048)
    {
      this.usage = i;
      return;
    }
  }

  public void bind()
  {
    if (this.bufferHandle == 0)
      throw new GdxRuntimeException("No buffer allocated!");
    Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
    if (this.isDirty)
    {
      this.byteBuffer.limit(this.buffer.limit() << 1);
      Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
    this.isBound = true;
  }

  public void dispose()
  {
    Gdx.gl20.glBindBuffer(34963, 0);
    Gdx.gl20.glDeleteBuffer(this.bufferHandle);
    this.bufferHandle = 0;
    BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
  }

  public ShortBuffer getBuffer()
  {
    this.isDirty = true;
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
    this.bufferHandle = Gdx.gl20.glGenBuffer();
    this.isDirty = true;
  }

  public void setIndices(ShortBuffer paramShortBuffer)
  {
    this.isDirty = true;
    int i = paramShortBuffer.position();
    this.buffer.clear();
    this.buffer.put(paramShortBuffer);
    this.buffer.flip();
    paramShortBuffer.position(i);
    this.byteBuffer.position(0);
    this.byteBuffer.limit(this.buffer.limit() << 1);
    if (this.isBound)
    {
      Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
  }

  public void setIndices(short[] paramArrayOfShort, int paramInt1, int paramInt2)
  {
    this.isDirty = true;
    this.buffer.clear();
    this.buffer.put(paramArrayOfShort, paramInt1, paramInt2);
    this.buffer.flip();
    this.byteBuffer.position(0);
    this.byteBuffer.limit(paramInt2 << 1);
    if (this.isBound)
    {
      Gdx.gl20.glBufferData(34963, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
  }

  public void unbind()
  {
    Gdx.gl20.glBindBuffer(34963, 0);
    this.isBound = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.IndexBufferObject
 * JD-Core Version:    0.6.0
 */