package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.ObjectMap;

class Dialog$2 extends ChangeListener
{
  public void changed(ChangeListener.ChangeEvent paramChangeEvent, Actor paramActor)
  {
    if (!this.this$0.values.containsKey(paramActor))
      return;
    while (paramActor.getParent() != this.this$0.buttonTable)
      paramActor = paramActor.getParent();
    this.this$0.result(this.this$0.values.get(paramActor));
    if (!this.this$0.cancelHide)
      this.this$0.hide();
    this.this$0.cancelHide = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Dialog.2
 * JD-Core Version:    0.6.0
 */