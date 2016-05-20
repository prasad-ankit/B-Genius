package com.badlogic.gdx;

public enum Graphics$GraphicsType
{
  static
  {
    Angle = new GraphicsType("Angle", 2);
    WebGL = new GraphicsType("WebGL", 3);
    iOSGL = new GraphicsType("iOSGL", 4);
    JGLFW = new GraphicsType("JGLFW", 5);
    Mock = new GraphicsType("Mock", 6);
    GraphicsType[] arrayOfGraphicsType = new GraphicsType[7];
    arrayOfGraphicsType[0] = AndroidGL;
    arrayOfGraphicsType[1] = LWJGL;
    arrayOfGraphicsType[2] = Angle;
    arrayOfGraphicsType[3] = WebGL;
    arrayOfGraphicsType[4] = iOSGL;
    arrayOfGraphicsType[5] = JGLFW;
    arrayOfGraphicsType[6] = Mock;
    $VALUES = arrayOfGraphicsType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Graphics.GraphicsType
 * JD-Core Version:    0.6.0
 */