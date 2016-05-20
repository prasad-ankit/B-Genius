package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.GdxRuntimeException;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class VertexBufferObjectSubData
  implements VertexData
{
  final VertexAttributes attributes;
  final FloatBuffer buffer;
  int bufferHandle;
  final ByteBuffer byteBuffer;
  boolean isBound = false;
  final boolean isDirect;
  boolean isDirty = false;
  final boolean isStatic;
  final int usage;

  public VertexBufferObjectSubData(boolean paramBoolean, int paramInt, VertexAttribute[] paramArrayOfVertexAttribute)
  {
    this.isStatic = paramBoolean;
    this.attributes = new VertexAttributes(paramArrayOfVertexAttribute);
    this.byteBuffer = BufferUtils.newByteBuffer(paramInt * this.attributes.vertexSize);
    this.isDirect = true;
    if (paramBoolean);
    for (int i = 35044; ; i = 35048)
    {
      this.usage = i;
      this.buffer = this.byteBuffer.asFloatBuffer();
      this.bufferHandle = createBufferObject();
      this.buffer.flip();
      this.byteBuffer.flip();
      return;
    }
  }

  private void bufferChanged()
  {
    if (this.isBound)
    {
      Gdx.gl20.glBufferSubData(34962, 0, this.byteBuffer.limit(), this.byteBuffer);
      this.isDirty = false;
    }
  }

  private int createBufferObject()
  {
    int i = Gdx.gl20.glGenBuffer();
    Gdx.gl20.glBindBuffer(34962, i);
    Gdx.gl20.glBufferData(34962, this.byteBuffer.capacity(), null, this.usage);
    Gdx.gl20.glBindBuffer(34962, 0);
    return i;
  }

  public void bind(ShaderProgram paramShaderProgram)
  {
    bind(paramShaderProgram, null);
  }

  public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    GL20 localGL20 = Gdx.gl20;
    localGL20.glBindBuffer(34962, this.bufferHandle);
    if (this.isDirty)
    {
      this.byteBuffer.limit(this.buffer.limit() << 2);
      localGL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
    int i = this.attributes.size();
    if (paramArrayOfInt == null)
      for (int m = 0; m < i; m++)
      {
        VertexAttribute localVertexAttribute2 = this.attributes.get(m);
        int n = paramShaderProgram.getAttributeLocation(localVertexAttribute2.alias);
        if (n < 0)
          continue;
        paramShaderProgram.enableVertexAttribute(n);
        paramShaderProgram.setVertexAttribute(n, localVertexAttribute2.numComponents, localVertexAttribute2.type, localVertexAttribute2.normalized, this.attributes.vertexSize, localVertexAttribute2.offset);
      }
    for (int j = 0; j < i; j++)
    {
      VertexAttribute localVertexAttribute1 = this.attributes.get(j);
      int k = paramArrayOfInt[j];
      if (k < 0)
        continue;
      paramShaderProgram.enableVertexAttribute(k);
      paramShaderProgram.setVertexAttribute(k, localVertexAttribute1.numComponents, localVertexAttribute1.type, localVertexAttribute1.normalized, this.attributes.vertexSize, localVertexAttribute1.offset);
    }
    this.isBound = true;
  }

  public void dispose()
  {
    GL20 localGL20 = Gdx.gl20;
    localGL20.glBindBuffer(34962, 0);
    localGL20.glDeleteBuffer(this.bufferHandle);
    this.bufferHandle = 0;
  }

  public VertexAttributes getAttributes()
  {
    return this.attributes;
  }

  public FloatBuffer getBuffer()
  {
    this.isDirty = true;
    return this.buffer;
  }

  public int getBufferHandle()
  {
    return this.bufferHandle;
  }

  public int getNumMaxVertices()
  {
    return this.byteBuffer.capacity() / this.attributes.vertexSize;
  }

  public int getNumVertices()
  {
    return (this.buffer.limit() << 2) / this.attributes.vertexSize;
  }

  public void invalidate()
  {
    this.bufferHandle = createBufferObject();
    this.isDirty = true;
  }

  public void setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.isDirty = true;
    if (this.isDirect)
    {
      BufferUtils.copy(paramArrayOfFloat, this.byteBuffer, paramInt2, paramInt1);
      this.buffer.position(0);
      this.buffer.limit(paramInt2);
    }
    while (true)
    {
      bufferChanged();
      return;
      this.buffer.clear();
      this.buffer.put(paramArrayOfFloat, paramInt1, paramInt2);
      this.buffer.flip();
      this.byteBuffer.position(0);
      this.byteBuffer.limit(this.buffer.limit() << 2);
    }
  }

  public void unbind(ShaderProgram paramShaderProgram)
  {
    unbind(paramShaderProgram, null);
  }

  public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    GL20 localGL20 = Gdx.gl20;
    int i = this.attributes.size();
    if (paramArrayOfInt == null)
      for (int m = 0; m < i; m++)
        paramShaderProgram.disableVertexAttribute(this.attributes.get(m).alias);
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfInt[j];
      if (k < 0)
        continue;
      paramShaderProgram.disableVertexAttribute(k);
    }
    localGL20.glBindBuffer(34962, 0);
    this.isBound = false;
  }

  public void updateVertices(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3)
  {
    this.isDirty = true;
    if (this.isDirect)
    {
      int i = this.byteBuffer.position();
      this.byteBuffer.position(paramInt1 << 2);
      BufferUtils.copy(paramArrayOfFloat, paramInt2, paramInt3, this.byteBuffer);
      this.byteBuffer.position(i);
      bufferChanged();
      return;
    }
    throw new GdxRuntimeException("Buffer must be allocated direct.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.VertexBufferObjectSubData
 * JD-Core Version:    0.6.0
 */