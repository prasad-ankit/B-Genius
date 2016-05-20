package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RemoveAction extends Action
{
  private Action action;

  public boolean act(float paramFloat)
  {
    this.target.removeAction(this.action);
    return true;
  }

  public Action getAction()
  {
    return this.action;
  }

  public void reset()
  {
    super.reset();
    this.action = null;
  }

  public void setAction(Action paramAction)
  {
    this.action = paramAction;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RemoveAction
 * JD-Core Version:    0.6.0
 */