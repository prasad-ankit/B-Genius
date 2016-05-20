package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.VertexAttribute;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.BufferUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class VertexArray
  implements VertexData
{
  final VertexAttributes attributes;
  final FloatBuffer buffer;
  final ByteBuffer byteBuffer;
  boolean isBound = false;

  public VertexArray(int paramInt, VertexAttributes paramVertexAttributes)
  {
    this.attributes = paramVertexAttributes;
    this.byteBuffer = BufferUtils.newUnsafeByteBuffer(paramInt * this.attributes.vertexSize);
    this.buffer = this.byteBuffer.asFloatBuffer();
    this.buffer.flip();
    this.byteBuffer.flip();
  }

  public VertexArray(int paramInt, VertexAttribute[] paramArrayOfVertexAttribute)
  {
    this(paramInt, new VertexAttributes(paramArrayOfVertexAttribute));
  }

  public void bind(ShaderProgram paramShaderProgram)
  {
    bind(paramShaderProgram, null);
  }

  public void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
    int i = this.attributes.size();
    this.byteBuffer.limit(this.buffer.limit() << 2);
    if (paramArrayOfInt == null)
    {
      int m = 0;
      if (m < i)
      {
        VertexAttribute localVertexAttribute2 = this.attributes.get(m);
        int n = paramShaderProgram.getAttributeLocation(localVertexAttribute2.alias);
        if (n >= 0)
        {
          paramShaderProgram.enableVertexAttribute(n);
          if (localVertexAttribute2.type != 5126)
            break label135;
          this.buffer.position(localVertexAttribute2.offset / 4);
          paramShaderProgram.setVertexAttribute(n, localVertexAttribute2.numComponents, localVertexAttribute2.type, localVertexAttribute2.normalized, this.attributes.vertexSize, this.buffer);
        }
        while (true)
        {
          m++;
          break;
          label135: this.byteBuffer.position(localVertexAttribute2.offset);
          paramShaderProgram.setVertexAttribute(n, localVertexAttribute2.numComponents, localVertexAttribute2.type, localVertexAttribute2.normalized, this.attributes.vertexSize, this.byteBuffer);
        }
      }
    }
    else
    {
      int j = 0;
      if (j < i)
      {
        VertexAttribute localVertexAttribute1 = this.attributes.get(j);
        int k = paramArrayOfInt[j];
        if (k >= 0)
        {
          paramShaderProgram.enableVertexAttribute(k);
          if (localVertexAttribute1.type != 5126)
            break label284;
          this.buffer.position(localVertexAttribute1.offset / 4);
          paramShaderProgram.setVertexAttribute(k, localVertexAttribute1.numComponents, localVertexAttribute1.type, localVertexAttribute1.normalized, this.attributes.vertexSize, this.buffer);
        }
        while (true)
        {
          j++;
          break;
          label284: this.byteBuffer.position(localVertexAttribute1.offset);
          paramShaderProgram.setVertexAttribute(k, localVertexAttribute1.numComponents, localVertexAttribute1.type, localVertexAttribute1.normalized, this.attributes.vertexSize, this.byteBuffer);
        }
      }
    }
    this.isBound = true;
  }

  public void dispose()
  {
    BufferUtils.disposeUnsafeByteBuffer(this.byteBuffer);
  }

  public VertexAttributes getAttributes()
  {
    return this.attributes;
  }

  public FloatBuffer getBuffer()
  {
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
  }

  public void setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    BufferUtils.copy(paramArrayOfFloat, this.byteBuffer, paramInt2, paramInt1);
    this.buffer.position(0);
    this.buffer.limit(paramInt2);
  }

  public void unbind(ShaderProgram paramShaderProgram)
  {
    unbind(paramShaderProgram, null);
  }

  public void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt)
  {
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
    this.isBound = false;
  }

  public void updateVertices(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3)
  {
    int i = this.byteBuffer.position();
    this.byteBuffer.position(paramInt1 << 2);
    BufferUtils.copy(paramArrayOfFloat, paramInt2, paramInt3, this.byteBuffer);
    this.byteBuffer.position(i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.VertexArray
 * JD-Core Version:    0.6.0
 */