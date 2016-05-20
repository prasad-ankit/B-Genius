package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;

public class RepeatAction extends DelegateAction
{
  public static final int FOREVER = -1;
  private int executedCount;
  private boolean finished;
  private int repeatCount;

  protected boolean delegate(float paramFloat)
  {
    if (this.executedCount == this.repeatCount);
    while (true)
    {
      return true;
      if (!this.action.act(paramFloat))
        break;
      if (this.finished)
        continue;
      if (this.repeatCount > 0)
        this.executedCount = (1 + this.executedCount);
      if (this.executedCount == this.repeatCount)
        continue;
      if (this.action == null)
        break;
      this.action.restart();
    }
    return false;
  }

  public void finish()
  {
    this.finished = true;
  }

  public int getCount()
  {
    return this.repeatCount;
  }

  public void restart()
  {
    super.restart();
    this.executedCount = 0;
    this.finished = false;
  }

  public void setCount(int paramInt)
  {
    this.repeatCount = paramInt;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RepeatAction
 * JD-Core Version:    0.6.0
 */