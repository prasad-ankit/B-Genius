package com.badlogic.gdx.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class GestureDetector extends InputAdapter
{
  private long gestureStartTime;
  private boolean inTapSquare;
  private final Vector2 initialPointer1 = new Vector2();
  private final Vector2 initialPointer2 = new Vector2();
  private int lastTapButton;
  private int lastTapPointer;
  private long lastTapTime;
  private float lastTapX;
  private float lastTapY;
  final GestureDetector.GestureListener listener;
  boolean longPressFired;
  private float longPressSeconds;
  private final Timer.Task longPressTask = new GestureDetector.1(this);
  private long maxFlingDelay;
  private boolean panning;
  private boolean pinching;
  Vector2 pointer1 = new Vector2();
  private final Vector2 pointer2 = new Vector2();
  private int tapCount;
  private long tapCountInterval;
  private float tapSquareCenterX;
  private float tapSquareCenterY;
  private float tapSquareSize;
  private final GestureDetector.VelocityTracker tracker = new GestureDetector.VelocityTracker();

  public GestureDetector(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GestureDetector.GestureListener paramGestureListener)
  {
    this.tapSquareSize = paramFloat1;
    this.tapCountInterval = ()(paramFloat2 * 1.0E+009F);
    this.longPressSeconds = paramFloat3;
    this.maxFlingDelay = ()(paramFloat4 * 1.0E+009F);
    this.listener = paramGestureListener;
  }

  public GestureDetector(GestureDetector.GestureListener paramGestureListener)
  {
    this(20.0F, 0.4F, 1.1F, 0.15F, paramGestureListener);
  }

  private boolean isWithinTapSquare(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (Math.abs(paramFloat1 - paramFloat3) < this.tapSquareSize) && (Math.abs(paramFloat2 - paramFloat4) < this.tapSquareSize);
  }

  public void cancel()
  {
    this.longPressTask.cancel();
    this.longPressFired = true;
  }

  public void invalidateTapSquare()
  {
    this.inTapSquare = false;
  }

  public boolean isLongPressed()
  {
    return isLongPressed(this.longPressSeconds);
  }

  public boolean isLongPressed(float paramFloat)
  {
    if (this.gestureStartTime == 0L);
    do
      return false;
    while (TimeUtils.nanoTime() - this.gestureStartTime <= ()(1.0E+009F * paramFloat));
    return true;
  }

  public boolean isPanning()
  {
    return this.panning;
  }

  public void reset()
  {
    this.gestureStartTime = 0L;
    this.panning = false;
    this.inTapSquare = false;
  }

  public void setLongPressSeconds(float paramFloat)
  {
    this.longPressSeconds = paramFloat;
  }

  public void setMaxFlingDelay(long paramLong)
  {
    this.maxFlingDelay = paramLong;
  }

  public void setTapCountInterval(float paramFloat)
  {
    this.tapCountInterval = ()(1.0E+009F * paramFloat);
  }

  public void setTapSquareSize(float paramFloat)
  {
    this.tapSquareSize = paramFloat;
  }

  public boolean touchDown(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 1)
      return false;
    if (paramInt1 == 0)
    {
      this.pointer1.set(paramFloat1, paramFloat2);
      this.gestureStartTime = Gdx.input.getCurrentEventTime();
      this.tracker.start(paramFloat1, paramFloat2, this.gestureStartTime);
      if (Gdx.input.isTouched(1))
      {
        this.inTapSquare = false;
        this.pinching = true;
        this.initialPointer1.set(this.pointer1);
        this.initialPointer2.set(this.pointer2);
        this.longPressTask.cancel();
      }
    }
    while (true)
    {
      return this.listener.touchDown(paramFloat1, paramFloat2, paramInt1, paramInt2);
      this.inTapSquare = true;
      this.pinching = false;
      this.longPressFired = false;
      this.tapSquareCenterX = paramFloat1;
      this.tapSquareCenterY = paramFloat2;
      if (this.longPressTask.isScheduled())
        continue;
      Timer.schedule(this.longPressTask, this.longPressSeconds);
      continue;
      this.pointer2.set(paramFloat1, paramFloat2);
      this.inTapSquare = false;
      this.pinching = true;
      this.initialPointer1.set(this.pointer1);
      this.initialPointer2.set(this.pointer2);
      this.longPressTask.cancel();
    }
  }

  public boolean touchDown(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return touchDown(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean touchDragged(float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramInt > 1);
    label123: 
    do
    {
      do
        return false;
      while (this.longPressFired);
      if (paramInt == 0)
        this.pointer1.set(paramFloat1, paramFloat2);
      while (true)
      {
        if (!this.pinching)
          break label123;
        if (this.listener == null)
          break;
        boolean bool = this.listener.pinch(this.initialPointer1, this.initialPointer2, this.pointer1, this.pointer2);
        if ((!this.listener.zoom(this.initialPointer1.dst(this.initialPointer2), this.pointer1.dst(this.pointer2))) && (!bool))
          break;
        return true;
        this.pointer2.set(paramFloat1, paramFloat2);
      }
      this.tracker.update(paramFloat1, paramFloat2, Gdx.input.getCurrentEventTime());
      if ((!this.inTapSquare) || (isWithinTapSquare(paramFloat1, paramFloat2, this.tapSquareCenterX, this.tapSquareCenterY)))
        continue;
      this.longPressTask.cancel();
      this.inTapSquare = false;
    }
    while (this.inTapSquare);
    this.panning = true;
    return this.listener.pan(paramFloat1, paramFloat2, this.tracker.deltaX, this.tracker.deltaY);
  }

  public boolean touchDragged(int paramInt1, int paramInt2, int paramInt3)
  {
    return touchDragged(paramInt1, paramInt2, paramInt3);
  }

  public boolean touchUp(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 1);
    boolean bool1;
    do
    {
      return false;
      if ((this.inTapSquare) && (!isWithinTapSquare(paramFloat1, paramFloat2, this.tapSquareCenterX, this.tapSquareCenterY)))
        this.inTapSquare = false;
      bool1 = this.panning;
      this.panning = false;
      this.longPressTask.cancel();
    }
    while (this.longPressFired);
    if (this.inTapSquare)
    {
      if ((this.lastTapButton != paramInt2) || (this.lastTapPointer != paramInt1) || (TimeUtils.nanoTime() - this.lastTapTime > this.tapCountInterval) || (!isWithinTapSquare(paramFloat1, paramFloat2, this.lastTapX, this.lastTapY)))
        this.tapCount = 0;
      this.tapCount = (1 + this.tapCount);
      this.lastTapTime = TimeUtils.nanoTime();
      this.lastTapX = paramFloat1;
      this.lastTapY = paramFloat2;
      this.lastTapButton = paramInt2;
      this.lastTapPointer = paramInt1;
      this.gestureStartTime = 0L;
      return this.listener.tap(paramFloat1, paramFloat2, this.tapCount, paramInt2);
    }
    if (this.pinching)
    {
      this.pinching = false;
      this.panning = true;
      if (paramInt1 == 0)
      {
        this.tracker.start(this.pointer2.x, this.pointer2.y, Gdx.input.getCurrentEventTime());
        return false;
      }
      this.tracker.start(this.pointer1.x, this.pointer1.y, Gdx.input.getCurrentEventTime());
      return false;
    }
    if ((bool1) && (!this.panning));
    for (boolean bool2 = this.listener.panStop(paramFloat1, paramFloat2, paramInt1, paramInt2); ; bool2 = false)
    {
      this.gestureStartTime = 0L;
      long l = Gdx.input.getCurrentEventTime();
      if (l - this.tracker.lastTime < this.maxFlingDelay)
      {
        this.tracker.update(paramFloat1, paramFloat2, l);
        if ((!this.listener.fling(this.tracker.getVelocityX(), this.tracker.getVelocityY(), paramInt2)) && (!bool2))
          break;
        return true;
      }
      return bool2;
    }
  }

  public boolean touchUp(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return touchUp(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.input.GestureDetector
 * JD-Core Version:    0.6.0
 */