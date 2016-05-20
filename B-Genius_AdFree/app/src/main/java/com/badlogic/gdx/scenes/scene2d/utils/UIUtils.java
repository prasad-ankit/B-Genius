package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class UIUtils
{
  public static boolean isLinux;
  public static boolean isMac = System.getProperty("os.name").contains("OS X");
  public static boolean isWindows = System.getProperty("os.name").contains("Windows");

  static
  {
    isLinux = System.getProperty("os.name").contains("Linux");
  }

  public static boolean alt()
  {
    return (Gdx.input.isKeyPressed(57)) || (Gdx.input.isKeyPressed(58));
  }

  public static boolean alt(int paramInt)
  {
    return (paramInt == 57) || (paramInt == 58);
  }

  public static boolean ctrl()
  {
    if (isMac)
      return Gdx.input.isKeyPressed(63);
    return (Gdx.input.isKeyPressed(129)) || (Gdx.input.isKeyPressed(130));
  }

  public static boolean ctrl(int paramInt)
  {
    if (isMac)
      if (paramInt != 63);
    do
    {
      return true;
      return false;
    }
    while ((paramInt == 129) || (paramInt == 130));
    return false;
  }

  public static boolean left()
  {
    return Gdx.input.isButtonPressed(0);
  }

  public static boolean left(int paramInt)
  {
    return paramInt == 0;
  }

  public static boolean middle()
  {
    return Gdx.input.isButtonPressed(2);
  }

  public static boolean middle(int paramInt)
  {
    return paramInt == 2;
  }

  public static boolean right()
  {
    return Gdx.input.isButtonPressed(1);
  }

  public static boolean right(int paramInt)
  {
    return paramInt == 1;
  }

  public static boolean shift()
  {
    return (Gdx.input.isKeyPressed(59)) || (Gdx.input.isKeyPressed(60));
  }

  public static boolean shift(int paramInt)
  {
    return (paramInt == 59) || (paramInt == 60);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.UIUtils
 * JD-Core Version:    0.6.0
 */