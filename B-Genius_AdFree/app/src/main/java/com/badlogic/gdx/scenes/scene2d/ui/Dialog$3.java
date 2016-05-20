package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener;
import com.badlogic.gdx.scenes.scene2d.utils.FocusListener.FocusEvent;
import com.badlogic.gdx.utils.SnapshotArray;

class Dialog$3 extends FocusListener
{
  private void focusChanged(FocusListener.FocusEvent paramFocusEvent)
  {
    Stage localStage = this.this$0.getStage();
    if ((this.this$0.isModal) && (localStage != null) && (localStage.getRoot().getChildren().size > 0) && (localStage.getRoot().getChildren().peek() == this.this$0))
    {
      Actor localActor = paramFocusEvent.getRelatedActor();
      if ((localActor != null) && (!localActor.isDescendantOf(this.this$0)) && (!localActor.equals(this.this$0.previousKeyboardFocus)) && (!localActor.equals(this.this$0.previousScrollFocus)))
        paramFocusEvent.cancel();
    }
  }

  public void keyboardFocusChanged(FocusListener.FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean)
  {
    if (!paramBoolean)
      focusChanged(paramFocusEvent);
  }

  public void scrollFocusChanged(FocusListener.FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean)
  {
    if (!paramBoolean)
      focusChanged(paramFocusEvent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Dialog.3
 * JD-Core Version:    0.6.0
 */