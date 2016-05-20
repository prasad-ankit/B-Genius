package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.utils.Array;

public abstract interface AndroidApplicationBase extends Application
{
  public static final int MINIMUM_SDK = 8;

  public abstract Window getApplicationWindow();

  public abstract Context getContext();

  public abstract Array getExecutedRunnables();

  public abstract Handler getHandler();

  public abstract AndroidInput getInput();

  public abstract Array getLifecycleListeners();

  public abstract Array getRunnables();

  public abstract WindowManager getWindowManager();

  public abstract void runOnUiThread(Runnable paramRunnable);

  public abstract void startActivity(Intent paramIntent);

  public abstract void useImmersiveMode(boolean paramBoolean);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidApplicationBase
 * JD-Core Version:    0.6.0
 */