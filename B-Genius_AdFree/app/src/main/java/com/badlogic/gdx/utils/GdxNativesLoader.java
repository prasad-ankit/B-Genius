package com.badlogic.gdx.utils;

import java.io.PrintStream;

public class GdxNativesLoader
{
  public static boolean disableNativesLoading = false;
  private static boolean nativesLoaded;

  public static void load()
  {
    monitorenter;
    while (true)
    {
      try
      {
        boolean bool = nativesLoaded;
        if (bool)
          return;
        nativesLoaded = true;
        if (disableNativesLoading)
        {
          System.out.println("Native loading is disabled.");
          continue;
        }
      }
      finally
      {
        monitorexit;
      }
      new SharedLibraryLoader().load("gdx");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.GdxNativesLoader
 * JD-Core Version:    0.6.0
 */