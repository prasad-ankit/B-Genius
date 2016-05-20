package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.JointDef;
import com.badlogic.gdx.physics.box2d.JointDef.JointType;

public class RopeJointDef extends JointDef
{
  public final Vector2 localAnchorA = new Vector2(-1.0F, 0.0F);
  public final Vector2 localAnchorB = new Vector2(1.0F, 0.0F);
  public float maxLength = 0.0F;

  public RopeJointDef()
  {
    this.type = JointDef.JointType.RopeJoint;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.joints.RopeJointDef
 * JD-Core Version:    0.6.0
 */