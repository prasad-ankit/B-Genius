package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Timer.Task;

class TextField$KeyRepeatTask extends Timer.Task
{
  int keycode;

  TextField$KeyRepeatTask(TextField paramTextField)
  {
  }

  public void run()
  {
    this.this$0.inputListener.keyDown(null, this.keycode);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextField.KeyRepeatTask
 * JD-Core Version:    0.6.0
 */