package com.badlogic.gdx.backends.android;

import android.os.Handler;
import android.view.View.OnSystemUiVisibilityChangeListener;

class AndroidVisibilityListener$1
  implements View.OnSystemUiVisibilityChangeListener
{
  public void onSystemUiVisibilityChange(int paramInt)
  {
    this.val$application.getHandler().post(new AndroidVisibilityListener.1.1(this));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidVisibilityListener.1
 * JD-Core Version:    0.6.0
 */