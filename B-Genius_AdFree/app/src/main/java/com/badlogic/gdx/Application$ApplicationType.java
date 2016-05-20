package com.badlogic.gdx;

public enum Application$ApplicationType
{
  static
  {
    Applet = new ApplicationType("Applet", 3);
    WebGL = new ApplicationType("WebGL", 4);
    iOS = new ApplicationType("iOS", 5);
    ApplicationType[] arrayOfApplicationType = new ApplicationType[6];
    arrayOfApplicationType[0] = Android;
    arrayOfApplicationType[1] = Desktop;
    arrayOfApplicationType[2] = HeadlessDesktop;
    arrayOfApplicationType[3] = Applet;
    arrayOfApplicationType[4] = WebGL;
    arrayOfApplicationType[5] = iOS;
    $VALUES = arrayOfApplicationType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Application.ApplicationType
 * JD-Core Version:    0.6.0
 */