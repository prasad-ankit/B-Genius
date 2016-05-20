package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

class Dialog$4 extends InputListener
{
  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    if (this.val$keycode == paramInt)
    {
      this.this$0.result(this.val$object);
      if (!this.this$0.cancelHide)
        this.this$0.hide();
      this.this$0.cancelHide = false;
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Dialog.4
 * JD-Core Version:    0.6.0
 */