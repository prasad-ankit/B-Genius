package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.TimeUtils;

public class ClickListener extends InputListener
{
  public static float visualPressedDuration = 0.1F;
  private int button;
  private boolean cancelled;
  private long lastTapTime;
  private boolean over;
  private boolean pressed;
  private int pressedButton = -1;
  private int pressedPointer = -1;
  private int tapCount;
  private long tapCountInterval = 400000000L;
  private float tapSquareSize = 14.0F;
  private float touchDownX = -1.0F;
  private float touchDownY = -1.0F;
  private long visualPressedTime;

  public ClickListener()
  {
  }

  public ClickListener(int paramInt)
  {
    this.button = paramInt;
  }

  public void cancel()
  {
    if (this.pressedPointer == -1)
      return;
    this.cancelled = true;
    this.pressed = false;
  }

  public void clicked(InputEvent paramInputEvent, float paramFloat1, float paramFloat2)
  {
  }

  public void enter(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if ((paramInt == -1) && (!this.cancelled))
      this.over = true;
  }

  public void exit(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, Actor paramActor)
  {
    if ((paramInt == -1) && (!this.cancelled))
      this.over = false;
  }

  public int getButton()
  {
    return this.button;
  }

  public int getPressedButton()
  {
    return this.pressedButton;
  }

  public int getPressedPointer()
  {
    return this.pressedPointer;
  }

  public int getTapCount()
  {
    return this.tapCount;
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

  public boolean inTapSquare()
  {
    return this.touchDownX != -1.0F;
  }

  public boolean inTapSquare(float paramFloat1, float paramFloat2)
  {
    if ((this.touchDownX == -1.0F) && (this.touchDownY == -1.0F));
    do
      return false;
    while ((Math.abs(paramFloat1 - this.touchDownX) >= this.tapSquareSize) || (Math.abs(paramFloat2 - this.touchDownY) >= this.tapSquareSize));
    return true;
  }

  public void invalidateTapSquare()
  {
    this.touchDownX = -1.0F;
    this.touchDownY = -1.0F;
  }

  public boolean isOver()
  {
    return (this.over) || (this.pressed);
  }

  public boolean isOver(Actor paramActor, float paramFloat1, float paramFloat2)
  {
    boolean bool = true;
    Actor localActor = paramActor.hit(paramFloat1, paramFloat2, bool);
    if ((localActor == null) || (!localActor.isDescendantOf(paramActor)))
      bool = inTapSquare(paramFloat1, paramFloat2);
    return bool;
  }

  public boolean isPressed()
  {
    return this.pressed;
  }

  public boolean isVisualPressed()
  {
    if (this.pressed);
    do
    {
      return true;
      if (this.visualPressedTime <= 0L)
        return false;
    }
    while (this.visualPressedTime > TimeUtils.millis());
    this.visualPressedTime = 0L;
    return false;
  }

  public void setButton(int paramInt)
  {
    this.button = paramInt;
  }

  public void setTapCountInterval(float paramFloat)
  {
    this.tapCountInterval = ()(1.0E+009F * paramFloat);
  }

  public void setTapSquareSize(float paramFloat)
  {
    this.tapSquareSize = paramFloat;
  }

  public boolean touchDown(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (this.pressed);
    do
      return false;
    while ((paramInt1 == 0) && (this.button != -1) && (paramInt2 != this.button));
    this.pressed = true;
    this.pressedPointer = paramInt1;
    this.pressedButton = paramInt2;
    this.touchDownX = paramFloat1;
    this.touchDownY = paramFloat2;
    this.visualPressedTime = (TimeUtils.millis() + ()(1000.0F * visualPressedDuration));
    return true;
  }

  public void touchDragged(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if ((paramInt != this.pressedPointer) || (this.cancelled));
    do
    {
      return;
      this.pressed = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
      if ((!this.pressed) || (paramInt != 0) || (this.button == -1) || (Gdx.input.isButtonPressed(this.button)))
        continue;
      this.pressed = false;
    }
    while (this.pressed);
    invalidateTapSquare();
  }

  public void touchUp(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.pressedPointer)
    {
      if (!this.cancelled)
      {
        boolean bool = isOver(paramInputEvent.getListenerActor(), paramFloat1, paramFloat2);
        if ((bool) && (paramInt1 == 0) && (this.button != -1) && (paramInt2 != this.button))
          bool = false;
        if (bool)
        {
          long l = TimeUtils.nanoTime();
          if (l - this.lastTapTime > this.tapCountInterval)
            this.tapCount = 0;
          this.tapCount = (1 + this.tapCount);
          this.lastTapTime = l;
          clicked(paramInputEvent, paramFloat1, paramFloat2);
        }
      }
      this.pressed = false;
      this.pressedPointer = -1;
      this.pressedButton = -1;
      this.cancelled = false;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.ClickListener
 * JD-Core Version:    0.6.0
 */