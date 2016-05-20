package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

class Touchpad$1 extends InputListener
{
  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.this$0.touched)
      return false;
    this.this$0.touched = true;
    this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2, false);
    return true;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2, false);
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.this$0.touched = false;
    this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2, this.this$0.resetOnTouchUp);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Touchpad.1
 * JD-Core Version:    0.6.0
 */