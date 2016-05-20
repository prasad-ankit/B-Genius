package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class RemoveActorAction extends Action
{
  private boolean removed;

  public boolean act(float paramFloat)
  {
    if (!this.removed)
    {
      this.removed = true;
      this.target.remove();
    }
    return true;
  }

  public void restart()
  {
    this.removed = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.RemoveActorAction
 * JD-Core Version:    0.6.0
 */