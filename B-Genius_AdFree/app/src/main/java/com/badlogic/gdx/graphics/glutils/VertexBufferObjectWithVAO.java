package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class VertexBufferObjectWithVAO
  implements VertexData
{
  static final IntBuffer tmpHandle = BufferUtils.newIntBuffer(1);
  final VertexAttributes attributes;
  final FloatBuffer buffer;
  int bufferHandle;
  final ByteBuffer byteBuffer;
  boolean isBound = false;
  boolean isDirty = false;
  final boolean isStatic;
  final int usage;
  boolean vaoDirty = true;
  int vaoHandle = -1;

  public VertexBufferObjectWithVAO(boolean paramBoolean, int paramInt, VertexAttributes paramVertexAttributes)
  {
    this.isStatic = paramBoolean;
    this.attributes = paramVertexAttributes;
    this.byteBuffer = BufferUtils.newUnsafeByteBuffer(paramInt * this.attributes.vertexSize);
    this.buffer = this.byteBuffer.asFloatBuffer();
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

  public VertexBufferObjectWithVAO(boolean paramBoolean, int paramInt, VertexAttribute[] paramArrayOfVertexAttribute)
  {
    this(paramBoolean, paramInt, new VertexAttributes(paramArrayOfVertexAttribute));
  }

  private void bindAttributes(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    Gdx.gl20.glBindBuffer(34962, this.bufferHandle);
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
  }

  private void bindData(GL20 paramGL20)
  {
    if (this.isDirty)
    {
      paramGL20.glBindBuffer(34962, this.bufferHandle);
      this.byteBuffer.limit(this.buffer.limit() << 2);
      paramGL20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
  }

  private void bufferChanged()
  {
    if (this.isBound)
    {
      Gdx.gl20.glBufferData(34962, this.byteBuffer.limit(), this.byteBuffer, this.usage);
      this.isDirty = false;
    }
  }

  public void bind(ShaderProgram paramShaderProgram)
  {
    bind(paramShaderProgram, null);
  }

  public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    GL30 localGL30 = Gdx.gl30;
    if ((this.vaoDirty) || (!localGL30.glIsVertexArray(this.vaoHandle)))
    {
      tmpHandle.clear();
      localGL30.glGenVertexArrays(1, tmpHandle);
      this.vaoHandle = tmpHandle.get(0);
      localGL30.glBindVertexArray(this.vaoHandle);
      this.vaoDirty = false;
    }
    while (true)
    {
      bindAttributes(paramShaderProgram, paramArrayOfInt);
      bindData(localGL30);
      this.isBound = true;
      return;
      localGL30.glBindVertexArray(this.vaoHandle);
    }
  }

  public void dispose()
  {
    GL30 localGL30 = Gdx.gl30;
    localGL30.glBindBuffer(34962, 0);
    localGL30.glDeleteBuffer(this.bufferHandle);
    this.bufferHandle = 0;
    BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
    if (localGL30.glIsVertexArray(this.vaoHandle))
    {
      tmpHandle.clear();
      tmpHandle.put(this.vaoHandle);
      tmpHandle.flip();
      localGL30.glDeleteVertexArrays(1, tmpHandle);
    }
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
    this.bufferHandle = Gdx.gl20.glGenBuffer();
    this.isDirty = true;
    this.vaoDirty = true;
  }

  public void setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    this.isDirty = true;
    BufferUtils.copy(paramArrayOfFloat, this.byteBuffer, paramInt2, paramInt1);
    this.buffer.position(0);
    this.buffer.limit(paramInt2);
    bufferChanged();
  }

  public void unbind(ShaderProgram paramShaderProgram)
  {
    unbind(paramShaderProgram, null);
  }

  public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    Gdx.gl30.glBindVertexArray(0);
    this.isBound = false;
  }

  public void updateVertices(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3)
  {
    this.isDirty = true;
    int i = this.byteBuffer.position();
    this.byteBuffer.position(paramInt1 << 2);
    BufferUtils.copy(paramArrayOfFloat, paramInt2, paramInt3, this.byteBuffer);
    this.byteBuffer.position(i);
    this.buffer.position(0);
    bufferChanged();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.VertexBufferObjectWithVAO
 * JD-Core Version:    0.6.0
 */