package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AddAction extends Action
{
  private Action action;

  public boolean act(float paramFloat)
  {
    this.target.addAction(this.action);
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

  public void restart()
  {
    if (this.action != null)
      this.action.restart();
  }

  public void setAction(Action paramAction)
  {
    this.action = paramAction;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.AddAction
 * JD-Core Version:    0.6.0
 */