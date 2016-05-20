package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;

public class PolygonShape extends Shape
{
  private static float[] verts = new float[2];

  public PolygonShape()
  {
    this.addr = newPolygonShape();
  }

  protected PolygonShape(long paramLong)
  {
    this.addr = paramLong;
  }

  private native void jniGetVertex(long paramLong, int paramInt, float[] paramArrayOfFloat);

  private native int jniGetVertexCount(long paramLong);

  private native void jniSet(long paramLong, float[] paramArrayOfFloat, int paramInt1, int paramInt2);

  private native void jniSetAsBox(long paramLong, float paramFloat1, float paramFloat2);

  private native void jniSetAsBox(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);

  private native long newPolygonShape();

  public Shape.Type getType()
  {
    return Shape.Type.Polygon;
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

  public void set(float[] paramArrayOfFloat)
  {
    jniSet(this.addr, paramArrayOfFloat, 0, paramArrayOfFloat.length);
  }

  public void set(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    jniSet(this.addr, paramArrayOfFloat, paramInt1, paramInt2);
  }

  public void set(Vector2[] paramArrayOfVector2)
  {
    float[] arrayOfFloat = new float[paramArrayOfVector2.length << 1];
    int i = 0;
    int j = 0;
    while (j < paramArrayOfVector2.length << 1)
    {
      arrayOfFloat[j] = paramArrayOfVector2[i].x;
      arrayOfFloat[(j + 1)] = paramArrayOfVector2[i].y;
      j += 2;
      i++;
    }
    jniSet(this.addr, arrayOfFloat, 0, arrayOfFloat.length);
  }

  public void setAsBox(float paramFloat1, float paramFloat2)
  {
    jniSetAsBox(this.addr, paramFloat1, paramFloat2);
  }

  public void setAsBox(float paramFloat1, float paramFloat2, Vector2 paramVector2, float paramFloat3)
  {
    jniSetAsBox(this.addr, paramFloat1, paramFloat2, paramVector2.x, paramVector2.y, paramFloat3);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.PolygonShape
 * JD-Core Version:    0.6.0
 */