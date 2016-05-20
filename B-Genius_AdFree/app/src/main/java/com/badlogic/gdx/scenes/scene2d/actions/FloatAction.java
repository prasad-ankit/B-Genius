package com.badlogic.gdx.scenes.scene2d.actions;

public class FloatAction extends TemporalAction
{
  private float end;
  private float start;
  private float value;

  public FloatAction()
  {
    this.start = 0.0F;
    this.end = 1.0F;
  }

  public FloatAction(float paramFloat1, float paramFloat2)
  {
    this.start = paramFloat1;
    this.end = paramFloat2;
  }

  protected void begin()
  {
    this.value = this.start;
  }

  public float getEnd()
  {
    return this.end;
  }

  public float getStart()
  {
    return this.start;
  }

  public float getValue()
  {
    return this.value;
  }

  public void setEnd(float paramFloat)
  {
    this.end = paramFloat;
  }

  public void setStart(float paramFloat)
  {
    this.start = paramFloat;
  }

  public void setValue(float paramFloat)
  {
    this.value = paramFloat;
  }

  protected void update(float paramFloat)
  {
    this.value = (this.start + paramFloat * (this.end - this.start));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.FloatAction
 * JD-Core Version:    0.6.0
 */