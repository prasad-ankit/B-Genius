package com.badlogic.gdx.utils;

import com.badlogic.gdx.math.Vector2;

public enum Scaling
{
  private static final Vector2 temp;

  static
  {
    fill = new Scaling("fill", 1);
    fillX = new Scaling("fillX", 2);
    fillY = new Scaling("fillY", 3);
    stretch = new Scaling("stretch", 4);
    stretchX = new Scaling("stretchX", 5);
    stretchY = new Scaling("stretchY", 6);
    none = new Scaling("none", 7);
    Scaling[] arrayOfScaling = new Scaling[8];
    arrayOfScaling[0] = fit;
    arrayOfScaling[1] = fill;
    arrayOfScaling[2] = fillX;
    arrayOfScaling[3] = fillY;
    arrayOfScaling[4] = stretch;
    arrayOfScaling[5] = stretchX;
    arrayOfScaling[6] = stretchY;
    arrayOfScaling[7] = none;
    $VALUES = arrayOfScaling;
    temp = new Vector2();
  }

  public final Vector2 apply(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    switch (Scaling.1.$SwitchMap$com$badlogic$gdx$utils$Scaling[ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return temp;
      float f4;
      if (paramFloat4 / paramFloat3 > paramFloat2 / paramFloat1)
        f4 = paramFloat3 / paramFloat1;
      while (true)
      {
        temp.x = (paramFloat1 * f4);
        temp.y = (f4 * paramFloat2);
        break;
        f4 = paramFloat4 / paramFloat2;
      }
      float f3;
      if (paramFloat4 / paramFloat3 < paramFloat2 / paramFloat1)
        f3 = paramFloat3 / paramFloat1;
      while (true)
      {
        temp.x = (paramFloat1 * f3);
        temp.y = (f3 * paramFloat2);
        break;
        f3 = paramFloat4 / paramFloat2;
      }
      float f2 = paramFloat3 / paramFloat1;
      temp.x = (paramFloat1 * f2);
      temp.y = (f2 * paramFloat2);
      continue;
      float f1 = paramFloat4 / paramFloat2;
      temp.x = (paramFloat1 * f1);
      temp.y = (f1 * paramFloat2);
      continue;
      temp.x = paramFloat3;
      temp.y = paramFloat4;
      continue;
      temp.x = paramFloat3;
      temp.y = paramFloat2;
      continue;
      temp.x = paramFloat1;
      temp.y = paramFloat4;
      continue;
      temp.x = paramFloat1;
      temp.y = paramFloat2;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Scaling
 * JD-Core Version:    0.6.0
 */