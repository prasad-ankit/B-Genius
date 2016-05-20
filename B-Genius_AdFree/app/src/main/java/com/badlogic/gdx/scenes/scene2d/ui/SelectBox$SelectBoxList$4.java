package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ArraySelection;

class SelectBox$SelectBoxList$4 extends InputListener
{
  public boolean keyDown(InputEvent paramInputEvent, int paramInt)
  {
    if (paramInt == 131)
      this.this$0.hide();
    return false;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    Actor localActor = paramInputEvent.getTarget();
    if (this.this$0.isAscendantOf(localActor))
      return false;
    this.this$0.list.selection.set(this.val$selectBox.getSelected());
    this.this$0.hide();
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.SelectBox.SelectBoxList.4
 * JD-Core Version:    0.6.0
 */