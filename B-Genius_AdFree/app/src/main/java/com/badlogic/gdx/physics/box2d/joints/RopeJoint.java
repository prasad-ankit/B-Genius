package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class RopeJoint extends Joint
{
  private final Vector2 localAnchorA = new Vector2();
  private final Vector2 localAnchorB = new Vector2();
  private final float[] tmp = new float[2];

  public RopeJoint(World paramWorld, long paramLong)
  {
    super(paramWorld, paramLong);
  }

  private native void jniGetLocalAnchorA(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetLocalAnchorB(long paramLong, float[] paramArrayOfFloat);

  private native float jniGetMaxLength(long paramLong);

  private native float jniSetMaxLength(long paramLong, float paramFloat);

  public Vector2 getLocalAnchorA()
  {
    jniGetLocalAnchorA(this.addr, this.tmp);
    this.localAnchorA.set(this.tmp[0], this.tmp[1]);
    return this.localAnchorA;
  }

  public Vector2 getLocalAnchorB()
  {
    jniGetLocalAnchorB(this.addr, this.tmp);
    this.localAnchorB.set(this.tmp[0], this.tmp[1]);
    return this.localAnchorB;
  }

  public float getMaxLength()
  {
    return jniGetMaxLength(this.addr);
  }

  public void setMaxLength(float paramFloat)
  {
    jniSetMaxLength(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.RopeJoint
 * JD-Core Version:    0.6.0
 */