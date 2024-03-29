package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class MotorJoint extends Joint
{
  private final Vector2 linearOffset = new Vector2();
  private final float[] tmp = new float[2];

  public MotorJoint(World paramWorld, long paramLong)
  {
    super(paramWorld, paramLong);
  }

  private native float jniGetAngularOffset(long paramLong);

  private native float jniGetCorrectionFactor(long paramLong);

  private native void jniGetLinearOffset(long paramLong, float[] paramArrayOfFloat);

  private native float jniGetMaxForce(long paramLong);

  private native float jniGetMaxTorque(long paramLong);

  private native void jniSetAngularOffset(long paramLong, float paramFloat);

  private native void jniSetCorrectionFactor(long paramLong, float paramFloat);

  private native void jniSetLinearOffset(long paramLong, float paramFloat1, float paramFloat2);

  private native void jniSetMaxForce(long paramLong, float paramFloat);

  private native void jniSetMaxTorque(long paramLong, float paramFloat);

  public float getAngularOffset()
  {
    return jniGetAngularOffset(this.addr);
  }

  public float getCorrectionFactor()
  {
    return jniGetCorrectionFactor(this.addr);
  }

  public Vector2 getLinearOffset()
  {
    jniGetLinearOffset(this.addr, this.tmp);
    this.linearOffset.set(this.tmp[0], this.tmp[1]);
    return this.linearOffset;
  }

  public float getMaxForce()
  {
    return jniGetMaxForce(this.addr);
  }

  public float getMaxTorque()
  {
    return jniGetMaxTorque(this.addr);
  }

  public void setAngularOffset(float paramFloat)
  {
    jniSetAngularOffset(this.addr, paramFloat);
  }

  public void setCorrectionFactor(float paramFloat)
  {
    jniSetCorrectionFactor(this.addr, paramFloat);
  }

  public void setLinearOffset(Vector2 paramVector2)
  {
    jniSetLinearOffset(this.addr, paramVector2.x, paramVector2.y);
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
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.MotorJoint
 * JD-Core Version:    0.6.0
 */