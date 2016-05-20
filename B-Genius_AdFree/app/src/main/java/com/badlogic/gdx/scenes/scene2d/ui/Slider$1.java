package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.Pools;

class Slider$1 extends InputListener
{
  public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if (paramInt == -1)
      this.this$0.mouseOver = true;
  }

  public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if (paramInt == -1)
      this.this$0.mouseOver = false;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.this$0.disabled);
    do
      return false;
    while (this.this$0.draggingPointer != -1);
    this.this$0.draggingPointer = paramInt1;
    this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2);
    return true;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2);
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 != this.this$0.draggingPointer);
    do
    {
      return;
      this.this$0.draggingPointer = -1;
    }
    while (this.this$0.calculatePositionAndValue(paramFloat1, paramFloat2));
    ChangeListener.ChangeEvent localChangeEvent = (ChangeListener.ChangeEvent)Pools.obtain(ChangeListener.ChangeEvent.class);
    this.this$0.fire(localChangeEvent);
    Pools.free(localChangeEvent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Slider.1
 * JD-Core Version:    0.6.0
 */