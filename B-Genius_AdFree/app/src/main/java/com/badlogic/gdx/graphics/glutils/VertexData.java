package com.badlogic.gdx.graphics.glutils;

import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.utils.Disposable;
import java.nio.FloatBuffer;

public abstract interface VertexData extends Disposable
{
  public abstract void bind(ShaderProgram paramShaderProgram);

  public abstract void bind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt);

  public abstract void dispose();

  public abstract VertexAttributes getAttributes();

  public abstract FloatBuffer getBuffer();

  public abstract int getNumMaxVertices();

  public abstract int getNumVertices();

  public abstract void invalidate();

  public abstract void setVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2);

  public abstract void unbind(ShaderProgram paramShaderProgram);

  public abstract void unbind(ShaderProgram paramShaderProgram, int[] paramArrayOfInt);

  public abstract void updateVertices(int paramInt1, float[] paramArrayOfFloat, int paramInt2, int paramInt3);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.graphics.glutils.VertexData
 * JD-Core Version:    0.6.0
 */