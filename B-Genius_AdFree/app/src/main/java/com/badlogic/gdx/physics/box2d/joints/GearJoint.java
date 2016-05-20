package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class GearJoint extends Joint
{
  private Joint joint1;
  private Joint joint2;

  public GearJoint(World paramWorld, long paramLong, Joint paramJoint1, Joint paramJoint2)
  {
    super(paramWorld, paramLong);
    this.joint1 = paramJoint1;
    this.joint2 = paramJoint2;
  }

  private native long jniGetJoint1(long paramLong);

  private native long jniGetJoint2(long paramLong);

  private native float jniGetRatio(long paramLong);

  private native void jniSetRatio(long paramLong, float paramFloat);

  public Joint getJoint1()
  {
    return this.joint1;
  }

  public Joint getJoint2()
  {
    return this.joint2;
  }

  public float getRatio()
  {
    return jniGetRatio(this.addr);
  }

  public void setRatio(float paramFloat)
  {
    jniSetRatio(this.addr, paramFloat);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.GearJoint
 * JD-Core Version:    0.6.0
 */