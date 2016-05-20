package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class RevoluteJoint extends Joint
{
  private final Vector2 localAnchorA = new Vector2();
  private final Vector2 localAnchorB = new Vector2();
  private final float[] tmp = new float[2];

  public RevoluteJoint(World paramWorld, long paramLong)
  {
    super(paramWorld, paramLong);
  }

  private native void jniEnableLimit(long paramLong, boolean paramBoolean);

  private native void jniEnableMotor(long paramLong, boolean paramBoolean);

  private native float jniGetJointAngle(long paramLong);

  private native float jniGetJointSpeed(long paramLong);

  private native void jniGetLocalAnchorA(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetLocalAnchorB(long paramLong, float[] paramArrayOfFloat);

  private native float jniGetLowerLimit(long paramLong);

  private native float jniGetMaxMotorTorque(long paramLong);

  private native float jniGetMotorSpeed(long paramLong);

  private native float jniGetMotorTorque(long paramLong, float paramFloat);

  private native float jniGetReferenceAngle(long paramLong);

  private native float jniGetUpperLimit(long paramLong);

  private native boolean jniIsLimitEnabled(long paramLong);

  private native boolean jniIsMotorEnabled(long paramLong);

  private native void jniSetLimits(long paramLong, float paramFloat1, float paramFloat2);

  private native void jniSetMaxMotorTorque(long paramLong, float paramFloat);

  private native void jniSetMotorSpeed(long paramLong, float paramFloat);

  public void enableLimit(boolean paramBoolean)
  {
    jniEnableLimit(this.addr, paramBoolean);
  }

  public void enableMotor(boolean paramBoolean)
  {
    jniEnableMotor(this.addr, paramBoolean);
  }

  public float getJointAngle()
  {
    return jniGetJointAngle(this.addr);
  }

  public float getJointSpeed()
  {
    return jniGetJointSpeed(this.addr);
  }

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

  public float getLowerLimit()
  {
    return jniGetLowerLimit(this.addr);
  }

  public float getMaxMotorTorque()
  {
    return jniGetMaxMotorTorque(this.addr);
  }

  public float getMotorSpeed()
  {
    return jniGetMotorSpeed(this.addr);
  }

  public float getMotorTorque(float paramFloat)
  {
    return jniGetMotorTorque(this.addr, paramFloat);
  }

  public float getReferenceAngle()
  {
    return jniGetReferenceAngle(this.addr);
  }

  public float getUpperLimit()
  {
    return jniGetUpperLimit(this.addr);
  }

  public boolean isLimitEnabled()
  {
    return jniIsLimitEnabled(this.addr);
  }

  public boolean isMotorEnabled()
  {
    return jniIsMotorEnabled(this.addr);
  }

  public void setLimits(float paramFloat1, float paramFloat2)
  {
    jniSetLimits(this.addr, paramFloat1, paramFloat2);
  }

  public void setMaxMotorTorque(float paramFloat)
  {
    jniSetMaxMotorTorque(this.addr, paramFloat);
  }

  public void setMotorSpeed(float paramFloat)
  {
    jniSetMotorSpeed(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.RevoluteJoint
 * JD-Core Version:    0.6.0
 */