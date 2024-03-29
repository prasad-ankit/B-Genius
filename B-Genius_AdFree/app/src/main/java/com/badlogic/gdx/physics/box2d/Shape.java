package com.badlogic.gdx.physics.box2d;

public abstract class Shape
{
  protected long addr;

  private native void jniDispose(long paramLong);

  private native int jniGetChildCount(long paramLong);

  private native float jniGetRadius(long paramLong);

  protected static native int jniGetType(long paramLong);

  private native void jniSetRadius(long paramLong, float paramFloat);

  public void dispose()
  {
    jniDispose(this.addr);
  }

  public int getChildCount()
  {
    return jniGetChildCount(this.addr);
  }

  public float getRadius()
  {
    return jniGetRadius(this.addr);
  }

  public abstract Shape.Type getType();

  public void setRadius(float paramFloat)
  {
    jniSetRadius(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.Shape
 * JD-Core Version:    0.6.0
 */