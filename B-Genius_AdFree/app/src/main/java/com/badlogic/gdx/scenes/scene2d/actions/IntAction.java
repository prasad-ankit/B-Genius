package com.badlogic.gdx.scenes.scene2d.actions;

public class IntAction extends TemporalAction
{
  private int end;
  private int start;
  private int value;

  public IntAction()
  {
    this.start = 0;
    this.end = 1;
  }

  public IntAction(int paramInt1, int paramInt2)
  {
    this.start = paramInt1;
    this.end = paramInt2;
  }

  protected void begin()
  {
    this.value = this.start;
  }

  public int getEnd()
  {
    return this.end;
  }

  public int getStart()
  {
    return this.start;
  }

  public int getValue()
  {
    return this.value;
  }

  public void setEnd(int paramInt)
  {
    this.end = paramInt;
  }

  public void setStart(int paramInt)
  {
    this.start = paramInt;
  }

  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }

  protected void update(float paramFloat)
  {
    this.value = (int)(this.start + paramFloat * (this.end - this.start));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.IntAction
 * JD-Core Version:    0.6.0
 */