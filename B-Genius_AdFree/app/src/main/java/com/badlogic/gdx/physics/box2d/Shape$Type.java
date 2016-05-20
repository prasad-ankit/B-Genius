package com.badlogic.gdx.physics.box2d;

public enum Shape$Type
{
  static
  {
    Chain = new Type("Chain", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = Circle;
    arrayOfType[1] = Edge;
    arrayOfType[2] = Polygon;
    arrayOfType[3] = Chain;
    $VALUES = arrayOfType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.physics.box2d.Shape.Type
 * JD-Core Version:    0.6.0
 */