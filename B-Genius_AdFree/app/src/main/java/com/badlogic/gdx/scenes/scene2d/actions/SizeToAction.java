package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class SizeToAction extends TemporalAction
{
  private float endHeight;
  private float endWidth;
  private float startHeight;
  private float startWidth;

  protected void begin()
  {
    this.startWidth = this.target.getWidth();
    this.startHeight = this.target.getHeight();
  }

  public float getHeight()
  {
    return this.endHeight;
  }

  public float getWidth()
  {
    return this.endWidth;
  }

  public void setHeight(float paramFloat)
  {
    this.endHeight = paramFloat;
  }

  public void setSize(float paramFloat1, float paramFloat2)
  {
    this.endWidth = paramFloat1;
    this.endHeight = paramFloat2;
  }

  public void setWidth(float paramFloat)
  {
    this.endWidth = paramFloat;
  }

  protected void update(float paramFloat)
  {
    this.target.setSize(this.startWidth + paramFloat * (this.endWidth - this.startWidth), this.startHeight + paramFloat * (this.endHeight - this.startHeight));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.SizeToAction
 * JD-Core Version:    0.6.0
 */