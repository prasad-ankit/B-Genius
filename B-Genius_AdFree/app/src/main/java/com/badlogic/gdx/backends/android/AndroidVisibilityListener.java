package com.badlogic.gdx.backends.android;

import android.view.View;
import android.view.Window;

public class AndroidVisibilityListener
{
  public void createListener(AndroidApplicationBase paramAndroidApplicationBase)
  {
    try
    {
      paramAndroidApplicationBase.getApplicationWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new AndroidVisibilityListener.1(this, paramAndroidApplicationBase));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramAndroidApplicationBase.log("AndroidApplication", "Can't create OnSystemUiVisibilityChangeListener, unable to use immersive mode.", localThrowable);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidVisibilityListener
 * JD-Core Version:    0.6.0
 */