package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class ScaleToAction extends TemporalAction
{
  private float endX;
  private float endY;
  private float startX;
  private float startY;

  protected void begin()
  {
    this.startX = this.target.getScaleX();
    this.startY = this.target.getScaleY();
  }

  public float getX()
  {
    return this.endX;
  }

  public float getY()
  {
    return this.endY;
  }

  public void setScale(float paramFloat)
  {
    this.endX = paramFloat;
    this.endY = paramFloat;
  }

  public void setScale(float paramFloat1, float paramFloat2)
  {
    this.endX = paramFloat1;
    this.endY = paramFloat2;
  }

  public void setX(float paramFloat)
  {
    this.endX = paramFloat;
  }

  public void setY(float paramFloat)
  {
    this.endY = paramFloat;
  }

  protected void update(float paramFloat)
  {
    this.target.setScale(this.startX + paramFloat * (this.endX - this.startX), this.startY + paramFloat * (this.endY - this.startY));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction
 * JD-Core Version:    0.6.0
 */