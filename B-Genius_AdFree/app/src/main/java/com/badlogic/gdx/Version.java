package com.badlogic.gdx;

import com.badlogic.gdx.utils.GdxRuntimeException;

public class Version
{
  public static final int MAJOR = 0;
  public static final int MINOR = 0;
  public static final int REVISION = 0;
  public static final String VERSION = "1.7.1";

  static
  {
    try
    {
      String[] arrayOfString = "1.7.1".split("\\.");
      int i;
      int j;
      label27: int m;
      if (arrayOfString.length <= 0)
      {
        i = 0;
        MAJOR = i;
        if (arrayOfString.length >= 2)
          break label63;
        j = 0;
        MINOR = j;
        int k = arrayOfString.length;
        m = 0;
        if (k >= 3)
          break label76;
      }
      while (true)
      {
        REVISION = m;
        return;
        i = Integer.valueOf(arrayOfString[0]).intValue();
        break;
        label63: j = Integer.valueOf(arrayOfString[1]).intValue();
        break label27;
        label76: int n = Integer.valueOf(arrayOfString[2]).intValue();
        m = n;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    throw new GdxRuntimeException("Invalid version 1.7.1", localThrowable);
  }

  public static boolean isHigher(int paramInt1, int paramInt2, int paramInt3)
  {
    return isHigherEqual(paramInt1, paramInt2, paramInt3 + 1);
  }

  public static boolean isHigherEqual(int paramInt1, int paramInt2, int paramInt3)
  {
    if (MAJOR != paramInt1)
      if (MAJOR <= paramInt1);
    do
      while (true)
      {
        return true;
        return false;
        if (MINOR == paramInt2)
          break;
        if (MINOR <= paramInt2)
          return false;
      }
    while (REVISION >= paramInt3);
    return false;
  }

  public static boolean isLower(int paramInt1, int paramInt2, int paramInt3)
  {
    return isLowerEqual(paramInt1, paramInt2, paramInt3 - 1);
  }

  public static boolean isLowerEqual(int paramInt1, int paramInt2, int paramInt3)
  {
    if (MAJOR != paramInt1)
      if (MAJOR >= paramInt1);
    do
      while (true)
      {
        return true;
        return false;
        if (MINOR == paramInt2)
          break;
        if (MINOR >= paramInt2)
          return false;
      }
    while (REVISION <= paramInt3);
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.Version
 * JD-Core Version:    0.6.0
 */