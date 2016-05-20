package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ParallelAction extends Action
{
  Array actions = new Array(4);
  private boolean complete;

  public ParallelAction()
  {
  }

  public ParallelAction(Action paramAction)
  {
    addAction(paramAction);
  }

  public ParallelAction(Action paramAction1, Action paramAction2)
  {
    addAction(paramAction1);
    addAction(paramAction2);
  }

  public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
  }

  public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
    addAction(paramAction4);
  }

  public ParallelAction(Action paramAction1, Action paramAction2, Action paramAction3, Action paramAction4, Action paramAction5)
  {
    addAction(paramAction1);
    addAction(paramAction2);
    addAction(paramAction3);
    addAction(paramAction4);
    addAction(paramAction5);
  }

  public boolean act(float paramFloat)
  {
    if (this.complete)
      return true;
    this.complete = true;
    Pool localPool = getPool();
    setPool(null);
    try
    {
      Array localArray = this.actions;
      int i = localArray.size;
      for (int j = 0; (j < i) && (this.actor != null); j++)
      {
        Action localAction = (Action)localArray.get(j);
        if ((localAction.getActor() != null) && (!localAction.act(paramFloat)))
          this.complete = false;
        Actor localActor = this.actor;
        if (localActor == null)
          return true;
      }
      boolean bool = this.complete;
      return bool;
    }
    finally
    {
      setPool(localPool);
    }
    throw localObject;
  }

  public void addAction(Action paramAction)
  {
    this.actions.add(paramAction);
    if (this.actor != null)
      paramAction.setActor(this.actor);
  }

  public Array getActions()
  {
    return this.actions;
  }

  public void reset()
  {
    super.reset();
    this.actions.clear();
  }

  public void restart()
  {
    this.complete = false;
    Array localArray = this.actions;
    int i = localArray.size;
    for (int j = 0; j < i; j++)
      ((Action)localArray.get(j)).restart();
  }

  public void setActor(Actor paramActor)
  {
    Array localArray = this.actions;
    int i = localArray.size;
    for (int j = 0; j < i; j++)
      ((Action)localArray.get(j)).setActor(paramActor);
    super.setActor(paramActor);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append(super.toString());
    localStringBuilder.append('(');
    Array localArray = this.actions;
    int i = 0;
    int j = localArray.size;
    while (i < j)
    {
      if (i > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(localArray.get(i));
      i++;
    }
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.ParallelAction
 * JD-Core Version:    0.6.0
 */