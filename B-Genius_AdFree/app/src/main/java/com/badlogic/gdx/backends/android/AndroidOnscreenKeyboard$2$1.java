package com.badlogic.gdx.backends.android;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

class AndroidOnscreenKeyboard$2$1
  implements Runnable
{
  public void run()
  {
    this.this$1.this$0.dialog.getWindow().setSoftInputMode(32);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.this$1.this$0.context.getSystemService("input_method");
    if (localInputMethodManager != null)
      localInputMethodManager.showSoftInput(this.this$1.this$0.textView, 2);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.2.1
 * JD-Core Version:    0.6.0
 */