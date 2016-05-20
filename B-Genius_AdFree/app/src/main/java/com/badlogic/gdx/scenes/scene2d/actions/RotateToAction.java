package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class RotateToAction extends TemporalAction
{
  private float end;
  private float start;

  protected void begin()
  {
    this.start = this.target.getRotation();
  }

  public float getRotation()
  {
    return this.end;
  }

  public void setRotation(float paramFloat)
  {
    this.end = paramFloat;
  }

  protected void update(float paramFloat)
  {
    this.target.setRotation(this.start + paramFloat * (this.end - this.start));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RotateToAction
 * JD-Core Version:    0.6.0
 */