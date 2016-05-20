package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

class ScrollPane$2 extends ActorGestureListener
{
  public void fling(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (Math.abs(paramFloat1) > 150.0F)
    {
      this.this$0.flingTimer = this.this$0.flingTime;
      this.this$0.velocityX = paramFloat1;
      if (this.this$0.cancelTouchFocus)
        this.this$0.cancelTouchFocus();
    }
    if (Math.abs(paramFloat2) > 150.0F)
    {
      this.this$0.flingTimer = this.this$0.flingTime;
      this.this$0.velocityY = (-paramFloat2);
      if (this.this$0.cancelTouchFocus)
        this.this$0.cancelTouchFocus();
    }
  }

  public boolean handle(Event paramEvent)
  {
    if (super.handle(paramEvent))
    {
      if (((InputEvent)paramEvent).getType() == InputEvent.Type.touchDown)
        this.this$0.flingTimer = 0.0F;
      return true;
    }
    return false;
  }

  public void pan(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.this$0.resetFade();
    ScrollPane localScrollPane1 = this.this$0;
    localScrollPane1.amountX -= paramFloat3;
    ScrollPane localScrollPane2 = this.this$0;
    localScrollPane2.amountY = (paramFloat4 + localScrollPane2.amountY);
    this.this$0.clamp();
    if (this.this$0.cancelTouchFocus)
      this.this$0.cancelTouchFocus();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.2
 * JD-Core Version:    0.6.0
 */