package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;

public class RunnableAction extends Action
{
  private boolean ran;
  private Runnable runnable;

  public boolean act(float paramFloat)
  {
    if (!this.ran)
    {
      this.ran = true;
      run();
    }
    return true;
  }

  public Runnable getRunnable()
  {
    return this.runnable;
  }

  public void reset()
  {
    super.reset();
    this.runnable = null;
  }

  public void restart()
  {
    this.ran = false;
  }

  public void run()
  {
    Pool localPool = getPool();
    setPool(null);
    try
    {
      this.runnable.run();
      return;
    }
    finally
    {
      setPool(localPool);
    }
    throw localObject;
  }

  public void setRunnable(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RunnableAction
 * JD-Core Version:    0.6.0
 */