package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoveToAction extends TemporalAction
{
  private int alignment = 12;
  private float endX;
  private float endY;
  private float startX;
  private float startY;

  protected void begin()
  {
    this.startX = this.target.getX(this.alignment);
    this.startY = this.target.getY(this.alignment);
  }

  public int getAlignment()
  {
    return this.alignment;
  }

  public float getX()
  {
    return this.endX;
  }

  public float getY()
  {
    return this.endY;
  }

  public void reset()
  {
    super.reset();
    this.alignment = 12;
  }

  public void setAlignment(int paramInt)
  {
    this.alignment = paramInt;
  }

  public void setPosition(float paramFloat1, float paramFloat2)
  {
    this.endX = paramFloat1;
    this.endY = paramFloat2;
  }

  public void setPosition(float paramFloat1, float paramFloat2, int paramInt)
  {
    this.endX = paramFloat1;
    this.endY = paramFloat2;
    this.alignment = paramInt;
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
    this.target.setPosition(this.startX + paramFloat * (this.endX - this.startX), this.startY + paramFloat * (this.endY - this.startY), this.alignment);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.MoveToAction
 * JD-Core Version:    0.6.0
 */