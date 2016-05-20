package com.badlogic.gdx.backends.android.surfaceview;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

class GLSurfaceView20$1 extends BaseInputConnection
{
  private void sendDownUpKeyEventForBackwardCompatibility(int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    super.sendKeyEvent(new KeyEvent(l, l, 0, paramInt, 0, 0, -1, 0, 6));
    super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), l, 1, paramInt, 0, 0, -1, 0, 6));
  }

  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramInt1 == 1) && (paramInt2 == 0))
    {
      sendDownUpKeyEventForBackwardCompatibility(67);
      return true;
    }
    return super.deleteSurroundingText(paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.surfaceview.GLSurfaceView20.1
 * JD-Core Version:    0.6.0
 */