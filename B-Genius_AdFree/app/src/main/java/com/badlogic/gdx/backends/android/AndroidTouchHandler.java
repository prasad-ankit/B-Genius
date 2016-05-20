package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.view.MotionEvent;

public abstract interface AndroidTouchHandler
{
  public abstract void onTouch(MotionEvent paramMotionEvent, AndroidInput paramAndroidInput);

  public abstract boolean supportsMultitouch(Context paramContext);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidTouchHandler
 * JD-Core Version:    0.6.0
 */