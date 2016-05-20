package com.badlogic.gdx.physics.box2d;

import com.badlogic.gdx.math.Vector2;

public class EdgeShape extends Shape
{
  static final float[] vertex = new float[2];

  public EdgeShape()
  {
    this.addr = newEdgeShape();
  }

  EdgeShape(long paramLong)
  {
    this.addr = paramLong;
  }

  private native void jniGetVertex0(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetVertex1(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetVertex2(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetVertex3(long paramLong, float[] paramArrayOfFloat);

  private native boolean jniHasVertex0(long paramLong);

  private native boolean jniHasVertex3(long paramLong);

  private native void jniSet(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  private native void jniSetHasVertex0(long paramLong, boolean paramBoolean);

  private native void jniSetHasVertex3(long paramLong, boolean paramBoolean);

  private native void jniSetVertex0(long paramLong, float paramFloat1, float paramFloat2);

  private native void jniSetVertex3(long paramLong, float paramFloat1, float paramFloat2);

  private native long newEdgeShape();

  public Shape.Type getType()
  {
    return Shape.Type.Edge;
  }

  public void getVertex0(Vector2 paramVector2)
  {
    jniGetVertex0(this.addr, vertex);
    paramVector2.x = vertex[0];
    paramVector2.y = vertex[1];
  }

  public void getVertex1(Vector2 paramVector2)
  {
    jniGetVertex1(this.addr, vertex);
    paramVector2.x = vertex[0];
    paramVector2.y = vertex[1];
  }

  public void getVertex2(Vector2 paramVector2)
  {
    jniGetVertex2(this.addr, vertex);
    paramVector2.x = vertex[0];
    paramVector2.y = vertex[1];
  }

  public void getVertex3(Vector2 paramVector2)
  {
    jniGetVertex3(this.addr, vertex);
    paramVector2.x = vertex[0];
    paramVector2.y = vertex[1];
  }

  public boolean hasVertex0()
  {
    return jniHasVertex0(this.addr);
  }

  public boolean hasVertex3()
  {
    return jniHasVertex3(this.addr);
  }

  public void set(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    jniSet(this.addr, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }

  public void set(Vector2 paramVector21, Vector2 paramVector22)
  {
    set(paramVector21.x, paramVector21.y, paramVector22.x, paramVector22.y);
  }

  public void setHasVertex0(boolean paramBoolean)
  {
    jniSetHasVertex0(this.addr, paramBoolean);
  }

  public void setHasVertex3(boolean paramBoolean)
  {
    jniSetHasVertex3(this.addr, paramBoolean);
  }

  public void setVertex0(float paramFloat1, float paramFloat2)
  {
    jniSetVertex0(this.addr, paramFloat1, paramFloat2);
  }

  public void setVertex0(Vector2 paramVector2)
  {
    jniSetVertex0(this.addr, paramVector2.x, paramVector2.y);
  }

  public void setVertex3(float paramFloat1, float paramFloat2)
  {
    jniSetVertex3(this.addr, paramFloat1, paramFloat2);
  }

  public void setVertex3(Vector2 paramVector2)
  {
    jniSetVertex3(this.addr, paramVector2.x, paramVector2.y);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.EdgeShape
 * JD-Core Version:    0.6.0
 */