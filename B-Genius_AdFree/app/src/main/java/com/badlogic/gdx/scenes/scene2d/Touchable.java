package com.badlogic.gdx.scenes.scene2d;

public enum Touchable
{
  static
  {
    disabled = new Touchable("disabled", 1);
    childrenOnly = new Touchable("childrenOnly", 2);
    Touchable[] arrayOfTouchable = new Touchable[3];
    arrayOfTouchable[0] = enabled;
    arrayOfTouchable[1] = disabled;
    arrayOfTouchable[2] = childrenOnly;
    $VALUES = arrayOfTouchable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Touchable
 * JD-Core Version:    0.6.0
 */