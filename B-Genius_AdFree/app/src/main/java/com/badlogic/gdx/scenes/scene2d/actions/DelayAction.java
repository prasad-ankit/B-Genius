package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public class DelayAction extends DelegateAction
{
  private float duration;
  private float time;

  public DelayAction()
  {
  }

  public DelayAction(float paramFloat)
  {
    this.duration = paramFloat;
  }

  protected boolean delegate(float paramFloat)
  {
    if (this.time < this.duration)
    {
      this.time = (paramFloat + this.time);
      if (this.time < this.duration)
        return false;
      paramFloat = this.time - this.duration;
    }
    if (this.action == null)
      return true;
    return this.action.act(paramFloat);
  }

  public void finish()
  {
    this.time = this.duration;
  }

  public float getDuration()
  {
    return this.duration;
  }

  public float getTime()
  {
    return this.time;
  }

  public void restart()
  {
    super.restart();
    this.time = 0.0F;
  }

  public void setDuration(float paramFloat)
  {
    this.duration = paramFloat;
  }

  public void setTime(float paramFloat)
  {
    this.time = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.DelayAction
 * JD-Core Version:    0.6.0
 */