package com.badlogic.gdx.backends.android;

import com.badlogic.gdx.LifecycleListener;

class AndroidApplication$1
  implements LifecycleListener
{
  public void dispose()
  {
    this.this$0.audio.dispose();
  }

  public void pause()
  {
    this.this$0.audio.pause();
  }

  public void resume()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidApplication.1
 * JD-Core Version:    0.6.0
 */