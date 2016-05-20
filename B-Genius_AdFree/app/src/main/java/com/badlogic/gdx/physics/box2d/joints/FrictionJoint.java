package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class FrictionJoint extends Joint
{
  private final Vector2 localAnchorA = new Vector2();
  private final Vector2 localAnchorB = new Vector2();
  private final float[] tmp = new float[2];

  public FrictionJoint(World paramWorld, long paramLong)
  {
    super(paramWorld, paramLong);
  }

  private native void jniGetLocalAnchorA(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetLocalAnchorB(long paramLong, float[] paramArrayOfFloat);

  private native float jniGetMaxForce(long paramLong);

  private native float jniGetMaxTorque(long paramLong);

  private native void jniSetMaxForce(long paramLong, float paramFloat);

  private native void jniSetMaxTorque(long paramLong, float paramFloat);

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

  public float getMaxForce()
  {
    return jniGetMaxForce(this.addr);
  }

  public float getMaxTorque()
  {
    return jniGetMaxTorque(this.addr);
  }

  public void setMaxForce(float paramFloat)
  {
    jniSetMaxForce(this.addr, paramFloat);
  }

  public void setMaxTorque(float paramFloat)
  {
    jniSetMaxTorque(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.FrictionJoint
 * JD-Core Version:    0.6.0
 */