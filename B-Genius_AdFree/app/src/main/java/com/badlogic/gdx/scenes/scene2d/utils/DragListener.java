package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class DragListener extends InputListener
{
  private int button;
  private float deltaX;
  private float deltaY;
  private boolean dragging;
  private int pressedPointer = -1;
  private float stageTouchDownX = -1.0F;
  private float stageTouchDownY = -1.0F;
  private float tapSquareSize = 14.0F;
  private float touchDownX = -1.0F;
  private float touchDownY = -1.0F;

  public void cancel()
  {
    this.dragging = false;
    this.pressedPointer = -1;
  }

  public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
  }

  public void dragStart(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
  }

  public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
  }

  public int getButton()
  {
    return this.button;
  }

  public float getDeltaX()
  {
    return this.deltaX;
  }

  public float getDeltaY()
  {
    return this.deltaY;
  }

  public float getStageTouchDownX()
  {
    return this.stageTouchDownX;
  }

  public float getStageTouchDownY()
  {
    return this.stageTouchDownY;
  }

  public float getTapSquareSize()
  {
    return this.tapSquareSize;
  }

  public float getTouchDownX()
  {
    return this.touchDownX;
  }

  public float getTouchDownY()
  {
    return this.touchDownY;
  }

  public boolean isDragging()
  {
    return this.dragging;
  }

  public void setButton(int paramInt)
  {
    this.button = paramInt;
  }

  public void setTapSquareSize(float paramFloat)
  {
    this.tapSquareSize = paramFloat;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.pressedPointer != -1);
    do
      return false;
    while ((paramInt1 == 0) && (this.button != -1) && (paramInt2 != this.button));
    this.pressedPointer = paramInt1;
    this.touchDownX = paramFloat1;
    this.touchDownY = paramFloat2;
    this.stageTouchDownX = paramInputEvent.getStageX();
    this.stageTouchDownY = paramInputEvent.getStageY();
    return true;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt != this.pressedPointer);
    do
    {
      return;
      if ((this.dragging) || ((Math.abs(this.touchDownX - paramFloat1) <= this.tapSquareSize) && (Math.abs(this.touchDownY - paramFloat2) <= this.tapSquareSize)))
        continue;
      this.dragging = true;
      dragStart(paramInputEvent, paramFloat1, paramFloat2, paramInt);
      this.deltaX = paramFloat1;
      this.deltaY = paramFloat2;
    }
    while (!this.dragging);
    this.deltaX -= paramFloat1;
    this.deltaY -= paramFloat2;
    drag(paramInputEvent, paramFloat1, paramFloat2, paramInt);
    this.deltaX = paramFloat1;
    this.deltaY = paramFloat2;
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.pressedPointer)
    {
      if (this.dragging)
        dragStop(paramInputEvent, paramFloat1, paramFloat2, paramInt1);
      cancel();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragListener
 * JD-Core Version:    0.6.0
 */