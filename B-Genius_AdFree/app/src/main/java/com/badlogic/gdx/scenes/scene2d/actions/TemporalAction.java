package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;

public abstract class TemporalAction extends Action
{
  private boolean began;
  private boolean complete;
  private float duration;
  private Interpolation interpolation;
  private boolean reverse;
  private float time;

  public TemporalAction()
  {
  }

  public TemporalAction(float paramFloat)
  {
    this.duration = paramFloat;
  }

  public TemporalAction(float paramFloat, Interpolation paramInterpolation)
  {
    this.duration = paramFloat;
    this.interpolation = paramInterpolation;
  }

  public boolean act(float paramFloat)
  {
    boolean bool1 = true;
    if (this.complete)
      return bool1;
    Pool localPool = getPool();
    setPool(null);
    try
    {
      if (!this.began)
      {
        begin();
        this.began = true;
      }
      this.time = (paramFloat + this.time);
      float f1;
      if (this.time >= this.duration)
      {
        this.complete = bool1;
        if (!this.complete)
          break label123;
        f1 = 1.0F;
      }
      while (true)
      {
        if (this.reverse)
          f1 = 1.0F - f1;
        update(f1);
        if (this.complete)
          end();
        boolean bool2 = this.complete;
        return bool2;
        bool1 = false;
        break;
        label123: f1 = this.time / this.duration;
        if (this.interpolation == null)
          continue;
        float f2 = this.interpolation.apply(f1);
        f1 = f2;
      }
    }
    finally
    {
      setPool(localPool);
    }
    throw localObject;
  }

  protected void begin()
  {
  }

  protected void end()
  {
  }

  public void finish()
  {
    this.time = this.duration;
  }

  public float getDuration()
  {
    return this.duration;
  }

  public Interpolation getInterpolation()
  {
    return this.interpolation;
  }

  public float getTime()
  {
    return this.time;
  }

  public boolean isReverse()
  {
    return this.reverse;
  }

  public void reset()
  {
    super.reset();
    this.reverse = false;
    this.interpolation = null;
  }

  public void restart()
  {
    this.time = 0.0F;
    this.began = false;
    this.complete = false;
  }

  public void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }

  public void setInterpolation(Interpolation paramInterpolation)
  {
    this.interpolation = paramInterpolation;
  }

  public void setReverse(boolean paramBoolean)
  {
    this.reverse = paramBoolean;
  }

  public void setTime(float paramFloat)
  {
    this.time = paramFloat;
  }

  protected abstract void update(float paramFloat);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.TemporalAction
 * JD-Core Version:    0.6.0
 */