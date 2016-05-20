package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Pool;

public abstract class DelegateAction extends Action
{
  protected Action action;

  public final boolean act(float paramFloat)
  {
    Pool localPool = getPool();
    setPool(null);
    try
    {
      boolean bool = delegate(paramFloat);
      return bool;
    }
    finally
    {
      setPool(localPool);
    }
    throw localObject;
  }

  protected abstract boolean delegate(float paramFloat);

  public Action getAction()
  {
    return this.action;
  }

  public void reset()
  {
    super.reset();
    this.action = null;
  }

  public void restart()
  {
    if (this.action != null)
      this.action.restart();
  }

  public void setAction(Action paramAction)
  {
    this.action = paramAction;
  }

  public void setActor(Actor paramActor)
  {
    if (this.action != null)
      this.action.setActor(paramActor);
    super.setActor(paramActor);
  }

  public void setTarget(Actor paramActor)
  {
    if (this.action != null)
      this.action.setTarget(paramActor);
    super.setTarget(paramActor);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString());
    if (this.action == null);
    for (String str = ""; ; str = "(" + this.action + ")")
      return str;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.DelegateAction
 * JD-Core Version:    0.6.0
 */