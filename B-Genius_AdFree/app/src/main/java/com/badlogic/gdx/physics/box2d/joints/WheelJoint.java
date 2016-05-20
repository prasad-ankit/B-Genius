package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class WheelJoint extends Joint
{
  private final Vector2 localAnchorA = new Vector2();
  private final Vector2 localAnchorB = new Vector2();
  private final Vector2 localAxisA = new Vector2();
  private final float[] tmp = new float[2];

  public WheelJoint(World paramWorld, long paramLong)
  {
    super(paramWorld, paramLong);
  }

  private native void jniEnableMotor(long paramLong, boolean paramBoolean);

  private native float jniGetJointSpeed(long paramLong);

  private native float jniGetJointTranslation(long paramLong);

  private native void jniGetLocalAnchorA(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetLocalAnchorB(long paramLong, float[] paramArrayOfFloat);

  private native void jniGetLocalAxisA(long paramLong, float[] paramArrayOfFloat);

  private native float jniGetMaxMotorTorque(long paramLong);

  private native float jniGetMotorSpeed(long paramLong);

  private native float jniGetMotorTorque(long paramLong, float paramFloat);

  private native float jniGetSpringDampingRatio(long paramLong);

  private native float jniGetSpringFrequencyHz(long paramLong);

  private native boolean jniIsMotorEnabled(long paramLong);

  private native void jniSetMaxMotorTorque(long paramLong, float paramFloat);

  private native void jniSetMotorSpeed(long paramLong, float paramFloat);

  private native void jniSetSpringDampingRatio(long paramLong, float paramFloat);

  private native void jniSetSpringFrequencyHz(long paramLong, float paramFloat);

  public void enableMotor(boolean paramBoolean)
  {
    jniEnableMotor(this.addr, paramBoolean);
  }

  public float getJointSpeed()
  {
    return jniGetJointSpeed(this.addr);
  }

  public float getJointTranslation()
  {
    return jniGetJointTranslation(this.addr);
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

  public Vector2 getLocalAxisA()
  {
    jniGetLocalAxisA(this.addr, this.tmp);
    this.localAxisA.set(this.tmp[0], this.tmp[1]);
    return this.localAxisA;
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

  public float getSpringDampingRatio()
  {
    return jniGetSpringDampingRatio(this.addr);
  }

  public float getSpringFrequencyHz()
  {
    return jniGetSpringFrequencyHz(this.addr);
  }

  public boolean isMotorEnabled()
  {
    return jniIsMotorEnabled(this.addr);
  }

  public void setMaxMotorTorque(float paramFloat)
  {
    jniSetMaxMotorTorque(this.addr, paramFloat);
  }

  public void setMotorSpeed(float paramFloat)
  {
    jniSetMotorSpeed(this.addr, paramFloat);
  }

  public void setSpringDampingRatio(float paramFloat)
  {
    jniSetSpringDampingRatio(this.addr, paramFloat);
  }

  public void setSpringFrequencyHz(float paramFloat)
  {
    jniSetSpringFrequencyHz(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.WheelJoint
 * JD-Core Version:    0.6.0
 */