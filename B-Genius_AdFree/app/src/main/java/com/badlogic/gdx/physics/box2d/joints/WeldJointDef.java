package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.JointDef.JointType;

public class WeldJointDef extends JointDef
{
  public float dampingRatio = 0.0F;
  public float frequencyHz = 0.0F;
  public final Vector2 localAnchorA = new Vector2();
  public final Vector2 localAnchorB = new Vector2();
  public float referenceAngle = 0.0F;

  public WeldJointDef()
  {
    this.type = JointDef.JointType.WeldJoint;
  }

  public void initialize(Body paramBody1, Body paramBody2, Vector2 paramVector2)
  {
    this.bodyA = paramBody1;
    this.bodyB = paramBody2;
    this.localAnchorA.set(paramBody1.getLocalPoint(paramVector2));
    this.localAnchorB.set(paramBody2.getLocalPoint(paramVector2));
    this.referenceAngle = (paramBody2.getAngle() - paramBody1.getAngle());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.WeldJointDef
 * JD-Core Version:    0.6.0
 */