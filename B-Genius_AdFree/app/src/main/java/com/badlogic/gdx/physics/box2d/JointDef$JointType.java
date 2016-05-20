package com.badlogic.gdx.physics.box2d;

public enum JointDef$JointType
{
  public static JointType[] valueTypes;
  private int value;

  static
  {
    RevoluteJoint = new JointType("RevoluteJoint", 1, 1);
    PrismaticJoint = new JointType("PrismaticJoint", 2, 2);
    DistanceJoint = new JointType("DistanceJoint", 3, 3);
    PulleyJoint = new JointType("PulleyJoint", 4, 4);
    MouseJoint = new JointType("MouseJoint", 5, 5);
    GearJoint = new JointType("GearJoint", 6, 6);
    WheelJoint = new JointType("WheelJoint", 7, 7);
    WeldJoint = new JointType("WeldJoint", 8, 8);
    FrictionJoint = new JointType("FrictionJoint", 9, 9);
    RopeJoint = new JointType("RopeJoint", 10, 10);
    MotorJoint = new JointType("MotorJoint", 11, 11);
    JointType[] arrayOfJointType1 = new JointType[12];
    arrayOfJointType1[0] = Unknown;
    arrayOfJointType1[1] = RevoluteJoint;
    arrayOfJointType1[2] = PrismaticJoint;
    arrayOfJointType1[3] = DistanceJoint;
    arrayOfJointType1[4] = PulleyJoint;
    arrayOfJointType1[5] = MouseJoint;
    arrayOfJointType1[6] = GearJoint;
    arrayOfJointType1[7] = WheelJoint;
    arrayOfJointType1[8] = WeldJoint;
    arrayOfJointType1[9] = FrictionJoint;
    arrayOfJointType1[10] = RopeJoint;
    arrayOfJointType1[11] = MotorJoint;
    $VALUES = arrayOfJointType1;
    JointType[] arrayOfJointType2 = new JointType[12];
    arrayOfJointType2[0] = Unknown;
    arrayOfJointType2[1] = RevoluteJoint;
    arrayOfJointType2[2] = PrismaticJoint;
    arrayOfJointType2[3] = DistanceJoint;
    arrayOfJointType2[4] = PulleyJoint;
    arrayOfJointType2[5] = MouseJoint;
    arrayOfJointType2[6] = GearJoint;
    arrayOfJointType2[7] = WheelJoint;
    arrayOfJointType2[8] = WeldJoint;
    arrayOfJointType2[9] = FrictionJoint;
    arrayOfJointType2[10] = RopeJoint;
    arrayOfJointType2[11] = MotorJoint;
    valueTypes = arrayOfJointType2;
  }

  private JointDef$JointType(int arg3)
  {
    int j;
    this.value = j;
  }

  public final int getValue()
  {
    return this.value;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.JointDef.JointType
 * JD-Core Version:    0.6.0
 */