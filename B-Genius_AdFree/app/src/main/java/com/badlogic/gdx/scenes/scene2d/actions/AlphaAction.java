package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AlphaAction extends TemporalAction
{
  private Color color;
  private float end;
  private float start;

  protected void begin()
  {
    if (this.color == null)
      this.color = this.target.getColor();
    this.start = this.color.a;
  }

  public float getAlpha()
  {
    return this.end;
  }

  public Color getColor()
  {
    return this.color;
  }

  public void reset()
  {
    super.reset();
    this.color = null;
  }

  public void setAlpha(float paramFloat)
  {
    this.end = paramFloat;
  }

  public void setColor(Color paramColor)
  {
    this.color = paramColor;
  }

  protected void update(float paramFloat)
  {
    this.color.a = (this.start + paramFloat * (this.end - this.start));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.AlphaAction
 * JD-Core Version:    0.6.0
 */