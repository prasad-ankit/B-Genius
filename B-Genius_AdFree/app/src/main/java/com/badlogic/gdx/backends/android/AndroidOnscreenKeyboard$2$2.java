package com.badlogic.gdx.backends.android;

import android.app.Dialog;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class AndroidOnscreenKeyboard$2$2
  implements ViewTreeObserver.OnPreDrawListener
{
  private int keyboardHeight;
  private boolean keyboardShowing;
  int[] screenloc = new int[2];

  public boolean onPreDraw()
  {
    this.val$content.getLocationOnScreen(this.screenloc);
    this.keyboardHeight = Math.abs(this.screenloc[1]);
    if (this.keyboardHeight > 0)
      this.keyboardShowing = true;
    if ((this.keyboardHeight == 0) && (this.keyboardShowing))
    {
      this.this$1.this$0.dialog.dismiss();
      this.this$1.this$0.dialog = null;
    }
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.2.2
 * JD-Core Version:    0.6.0
 */