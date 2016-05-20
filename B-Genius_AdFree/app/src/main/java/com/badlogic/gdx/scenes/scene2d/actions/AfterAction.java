package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class AfterAction extends DelegateAction
{
  private Array waitForActions = new Array(false, 4);

  protected boolean delegate(float paramFloat)
  {
    Array localArray = this.target.getActions();
    if (localArray.size == 1)
      this.waitForActions.clear();
    for (int i = -1 + this.waitForActions.size; i >= 0; i--)
    {
      if (localArray.indexOf((Action)this.waitForActions.get(i), true) != -1)
        continue;
      this.waitForActions.removeIndex(i);
    }
    if (this.waitForActions.size > 0)
      return false;
    return this.action.act(paramFloat);
  }

  public void restart()
  {
    super.restart();
    this.waitForActions.clear();
  }

  public void setTarget(Actor paramActor)
  {
    if (paramActor != null)
      this.waitForActions.addAll(paramActor.getActions());
    super.setTarget(paramActor);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.AfterAction
 * JD-Core Version:    0.6.0
 */