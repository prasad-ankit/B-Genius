package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;

public class ChainShape extends Shape
{
  private static float[] verts = new float[2];
  boolean isLooped = false;

  public ChainShape()
  {
    this.addr = newChainShape();
  }

  ChainShape(long paramLong)
  {
    this.addr = paramLong;
  }

  private native void jniCreateChain(long paramLong, float[] paramArrayOfFloat, int paramInt);

  private native void jniCreateLoop(long paramLong, float[] paramArrayOfFloat, int paramInt);

  private native void jniGetVertex(long paramLong, int paramInt, float[] paramArrayOfFloat);

  private native int jniGetVertexCount(long paramLong);

  private native void jniSetNextVertex(long paramLong, float paramFloat1, float paramFloat2);

  private native void jniSetPrevVertex(long paramLong, float paramFloat1, float paramFloat2);

  private native long newChainShape();

  public void createChain(float[] paramArrayOfFloat)
  {
    jniCreateChain(this.addr, paramArrayOfFloat, paramArrayOfFloat.length / 2);
    this.isLooped = false;
  }

  public void createChain(Vector2[] paramArrayOfVector2)
  {
    int i = 0;
    float[] arrayOfFloat = new float[paramArrayOfVector2.length << 1];
    int j = 0;
    while (j < paramArrayOfVector2.length << 1)
    {
      arrayOfFloat[j] = paramArrayOfVector2[i].x;
      arrayOfFloat[(j + 1)] = paramArrayOfVector2[i].y;
      j += 2;
      i++;
    }
    createChain(arrayOfFloat);
  }

  public void createLoop(float[] paramArrayOfFloat)
  {
    jniCreateLoop(this.addr, paramArrayOfFloat, paramArrayOfFloat.length / 2);
    this.isLooped = true;
  }

  public void createLoop(Vector2[] paramArrayOfVector2)
  {
    int i = 0;
    float[] arrayOfFloat = new float[paramArrayOfVector2.length << 1];
    int j = 0;
    while (j < paramArrayOfVector2.length << 1)
    {
      arrayOfFloat[j] = paramArrayOfVector2[i].x;
      arrayOfFloat[(j + 1)] = paramArrayOfVector2[i].y;
      j += 2;
      i++;
    }
    jniCreateLoop(this.addr, arrayOfFloat, arrayOfFloat.length / 2);
    this.isLooped = true;
  }

  public Shape.Type getType()
  {
    return Shape.Type.Chain;
  }

  public void getVertex(int paramInt, Vector2 paramVector2)
  {
    jniGetVertex(this.addr, paramInt, verts);
    paramVector2.x = verts[0];
    paramVector2.y = verts[1];
  }

  public int getVertexCount()
  {
    return jniGetVertexCount(this.addr);
  }

  public boolean isLooped()
  {
    return this.isLooped;
  }

  public void setNextVertex(float paramFloat1, float paramFloat2)
  {
    jniSetNextVertex(this.addr, paramFloat1, paramFloat2);
  }

  public void setNextVertex(Vector2 paramVector2)
  {
    setNextVertex(paramVector2.x, paramVector2.y);
  }

  public void setPrevVertex(float paramFloat1, float paramFloat2)
  {
    jniSetPrevVertex(this.addr, paramFloat1, paramFloat2);
  }

  public void setPrevVertex(Vector2 paramVector2)
  {
    setPrevVertex(paramVector2.x, paramVector2.y);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.ChainShape
 * JD-Core Version:    0.6.0
 */