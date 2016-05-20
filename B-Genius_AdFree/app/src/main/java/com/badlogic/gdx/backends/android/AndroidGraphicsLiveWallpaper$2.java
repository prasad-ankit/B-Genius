package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.view.SurfaceHolder;
import com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20;
import com.badlogic.gdx.backends.android.surfaceview.ResolutionStrategy;

class AndroidGraphicsLiveWallpaper$2 extends GLSurfaceView20
{
  public SurfaceHolder getHolder()
  {
    return this.this$0.getSurfaceHolder();
  }

  public void onDestroy()
  {
    onDetachedFromWindow();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidGraphicsLiveWallpaper.2
 * JD-Core Version:    0.6.0
 */