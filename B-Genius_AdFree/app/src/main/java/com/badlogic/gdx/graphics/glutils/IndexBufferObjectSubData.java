package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class IndexBufferObjectSubData
  implements IndexData
{
  ShortBuffer buffer;
  int bufferHandle;
  ByteBuffer byteBuffer;
  boolean isBound = false;
  final boolean isDirect;
  boolean isDirty = true;
  final int usage;

  public IndexBufferObjectSubData(int paramInt)
  {
    this.byteBuffer = BufferUtils.newByteBuffer(paramInt << 1);
    this.isDirect = true;
    this.usage = 35044;
    this.buffer = this.byteBuffer.asShortBuffer();
    this.buffer.flip();
    this.byteBuffer.flip();
    this.bufferHandle = createBufferObject();
  }

  public IndexBufferObjectSubData(boolean paramBoolean, int paramInt)
  {
    this.byteBuffer = BufferUtils.newByteBuffer(paramInt << 1);
    this.isDirect = true;
    if (paramBoolean);
    for (int i = 35044; ; i = 35048)
    {
      this.usage = i;
      this.buffer = this.byteBuffer.asShortBuffer();
      this.buffer.flip();
      this.byteBuffer.flip();
      this.bufferHandle = createBufferObject();
      return;
    }
  }

  private int createBufferObject()
  {
    int i = Gdx.gl20.glGenBuffer();
    Gdx.gl20.glBindBuffer(34963, i);
    Gdx.gl20.glBufferData(34963, this.byteBuffer.capacity(), null, this.usage);
    Gdx.gl20.glBindBuffer(34963, 0);
    return i;
  }

  public void bind()
  {
    if (this.bufferHandle == 0)
      throw new GdxRuntimeException("buuh");
    Gdx.gl20.glBindBuffer(34963, this.bufferHandle);
    if (this.isDirty)
    {
      this.byteBuffer.limit(this.buffer.limit() << 1);
      Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
      this.isDirty = false;
    }
    this.isBound = true;
  }

  public void dispose()
  {
    GL20 localGL20 = Gdx.gl20;
    localGL20.glBindBuffer(34963, 0);
    localGL20.glDeleteBuffer(this.bufferHandle);
    this.bufferHandle = 0;
  }

  public ShortBuffer getBuffer()
  {
    this.isDirty = true;
    return this.buffer;
  }

  public int getNumIndices()
  {
    return this.buffer.limit();
  }

  public int getNumMaxIndices()
  {
    return this.buffer.capacity();
  }

  public void invalidate()
  {
    this.bufferHandle = createBufferObject();
    this.isDirty = true;
  }

  public void setIndices(ShortBuffer paramShortBuffer)
  {
    int i = paramShortBuffer.position();
    this.isDirty = true;
    this.buffer.clear();
    this.buffer.put(paramShortBuffer);
    this.buffer.flip();
    paramShortBuffer.position(i);
    this.byteBuffer.position(0);
    this.byteBuffer.limit(this.buffer.limit() << 1);
    if (this.isBound)
    {
      Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
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
      Gdx.gl20.glBufferSubData(34963, 0, this.byteBuffer.limit(), this.byteBuffer);
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
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.IndexBufferObjectSubData
 * JD-Core Version:    0.6.0
 */