package com.badlogic.gdx.math;

public enum Plane$PlaneSide
{
  static
  {
    Back = new PlaneSide("Back", 1);
    Front = new PlaneSide("Front", 2);
    PlaneSide[] arrayOfPlaneSide = new PlaneSide[3];
    arrayOfPlaneSide[0] = OnPlane;
    arrayOfPlaneSide[1] = Back;
    arrayOfPlaneSide[2] = Front;
    $VALUES = arrayOfPlaneSide;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.math.Plane.PlaneSide
 * JD-Core Version:    0.6.0
 */