package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public class TimeScaleAction extends DelegateAction
{
  private float scale;

  protected boolean delegate(float paramFloat)
  {
    if (this.action == null)
      return true;
    return this.action.act(paramFloat * this.scale);
  }

  public float getScale()
  {
    return this.scale;
  }

  public void setScale(float paramFloat)
  {
    this.scale = paramFloat;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.TimeScaleAction
 * JD-Core Version:    0.6.0
 */