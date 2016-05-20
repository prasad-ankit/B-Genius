package com.badlogic.gdx.scenes.scene2d.actions;

public abstract class RelativeTemporalAction extends TemporalAction
{
  private float lastPercent;

  protected void begin()
  {
    this.lastPercent = 0.0F;
  }

  protected void update(float paramFloat)
  {
    updateRelative(paramFloat - this.lastPercent);
    this.lastPercent = paramFloat;
  }

  protected abstract void updateRelative(float paramFloat);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction
 * JD-Core Version:    0.6.0
 */