package com.badlogic.gdx.backends.android;

import android.content.Context;
import android.text.Editable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

final class AndroidOnscreenKeyboard$1 extends TextView
{
  Editable editable = new AndroidOnscreenKeyboard.PassThroughEditable();

  protected final boolean getDefaultEditable()
  {
    return true;
  }

  protected final MovementMethod getDefaultMovementMethod()
  {
    return ArrowKeyMovementMethod.getInstance();
  }

  public final Editable getEditableText()
  {
    return this.editable;
  }

  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Log.d("Test", "down keycode: " + paramKeyEvent.getKeyCode());
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    Log.d("Test", "up keycode: " + paramKeyEvent.getKeyCode());
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.backends.android.AndroidOnscreenKeyboard.1
 * JD-Core Version:    0.6.0
 */