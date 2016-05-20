package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class SequenceAction extends ParallelAction
{
  private int index;

  public SequenceAction()
  {
  }

  public SequenceAction(Action paramAction)
  {
    addAction(paramAction);
  }

  public SequenceAction(Action paramAction1, Action paramAction2)
  {
    addAction(paramAction1);
    addAction(paramAction2);
  }

  public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
  }

  public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
    addAction(paramAction4);
  }

  public SequenceAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
    addAction(paramAction4);
    addAction(paramAction5);
  }

  public boolean act(float paramFloat)
  {
    if (this.index >= this.actions.size)
      return true;
    Pool localPool = getPool();
    setPool(null);
    try
    {
      if (((Action)this.actions.get(this.index)).act(paramFloat))
      {
        Actor localActor = this.actor;
        if (localActor == null)
          return true;
        this.index = (1 + this.index);
        int i = this.index;
        int j = this.actions.size;
        if (i >= j)
          return true;
      }
      return false;
    }
    finally
    {
      setPool(localPool);
    }
    throw localObject;
  }

  public void restart()
  {
    super.restart();
    this.index = 0;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.SequenceAction
 * JD-Core Version:    0.6.0
 */