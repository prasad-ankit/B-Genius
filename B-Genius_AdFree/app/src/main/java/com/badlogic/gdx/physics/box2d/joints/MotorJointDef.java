package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.JointDef.JointType;

public class MotorJointDef extends JointDef
{
  public float angularOffset = 0.0F;
  public float correctionFactor = 0.3F;
  public final Vector2 linearOffset = new Vector2();
  public float maxForce = 1.0F;
  public float maxTorque = 1.0F;

  public MotorJointDef()
  {
    this.type = JointDef.JointType.MotorJoint;
  }

  public void initialize(Body paramBody1, Body paramBody2)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.linearOffset.set(this.bodyA.getLocalPoint(this.bodyB.getPosition()));
    this.angularOffset = (this.bodyB.getAngle() - this.bodyA.getAngle());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.MotorJointDef
 * JD-Core Version:    0.6.0
 */