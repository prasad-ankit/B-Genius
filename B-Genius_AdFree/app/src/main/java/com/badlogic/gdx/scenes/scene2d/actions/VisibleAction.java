package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class VisibleAction extends Action
{
  private boolean visible;

  public boolean act(float paramFloat)
  {
    this.target.setVisible(this.visible);
    return true;
  }

  public boolean isVisible()
  {
    return this.visible;
  }

  public void setVisible(boolean paramBoolean)
  {
    this.visible = paramBoolean;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.VisibleAction
 * JD-Core Version:    0.6.0
 */