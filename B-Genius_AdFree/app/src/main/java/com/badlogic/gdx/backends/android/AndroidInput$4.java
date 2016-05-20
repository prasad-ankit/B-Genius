package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.badlogic.gdx.Application;

class AndroidInput$4
  implements Runnable
{
  public void run()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$0.context.getSystemService("input_method");
    if (this.val$visible)
    {
      View localView = ((AndroidGraphics)this.this$0.app.getGraphics()).getView();
      localView.setFocusable(true);
      localView.setFocusableInTouchMode(true);
      localInputMethodManager.showSoftInput(((AndroidGraphics)this.this$0.app.getGraphics()).getView(), 0);
      return;
    }
    localInputMethodManager.hideSoftInputFromWindow(((AndroidGraphics)this.this$0.app.getGraphics()).getView().getWindowToken(), 0);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidInput.4
 * JD-Core Version:    0.6.0
 */