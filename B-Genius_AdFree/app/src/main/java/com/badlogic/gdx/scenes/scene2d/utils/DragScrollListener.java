package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class DragScrollListener extends DragListener
{
  Interpolation interpolation = Interpolation.exp5In;
  float maxSpeed = 75.0F;
  float minSpeed = 15.0F;
  long rampTime = 1750L;
  private ScrollPane scroll;
  private Timer.Task scrollDown;
  private Timer.Task scrollUp;
  long startTime;
  float tickSecs = 0.05F;

  public DragScrollListener(ScrollPane paramScrollPane)
  {
    this.scroll = paramScrollPane;
    this.scrollUp = new DragScrollListener.1(this, paramScrollPane);
    this.scrollDown = new DragScrollListener.2(this, paramScrollPane);
  }

  public void drag(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    if ((paramFloat1 >= 0.0F) && (paramFloat1 < this.scroll.getWidth()))
    {
      if (paramFloat2 >= this.scroll.getHeight())
      {
        this.scrollDown.cancel();
        if (!this.scrollUp.isScheduled())
        {
          this.startTime = System.currentTimeMillis();
          Timer.schedule(this.scrollUp, this.tickSecs, this.tickSecs);
        }
      }
      while (true)
      {
        return;
        if (paramFloat2 >= 0.0F)
          break;
        this.scrollUp.cancel();
        if (this.scrollDown.isScheduled())
          continue;
        this.startTime = System.currentTimeMillis();
        Timer.schedule(this.scrollDown, this.tickSecs, this.tickSecs);
        return;
      }
    }
    this.scrollUp.cancel();
    this.scrollDown.cancel();
  }

  public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.scrollUp.cancel();
    this.scrollDown.cancel();
  }

  float getScrollPixels()
  {
    return this.interpolation.apply(this.minSpeed, this.maxSpeed, Math.min(1.0F, (float)(System.currentTimeMillis() - this.startTime) / (float)this.rampTime));
  }

  public void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.minSpeed = paramFloat1;
    this.maxSpeed = paramFloat2;
    this.tickSecs = paramFloat3;
    this.rampTime = ()(1000.0F * paramFloat4);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragScrollListener
 * JD-Core Version:    0.6.0
 */