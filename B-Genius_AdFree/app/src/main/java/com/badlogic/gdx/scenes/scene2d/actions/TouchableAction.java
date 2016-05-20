package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

public class TouchableAction extends Action
{
  private Touchable touchable;

  public boolean act(float paramFloat)
  {
    this.target.setTouchable(this.touchable);
    return true;
  }

  public Touchable getTouchable()
  {
    return this.touchable;
  }

  public void setTouchable(Touchable paramTouchable)
  {
    this.touchable = paramTouchable;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.TouchableAction
 * JD-Core Version:    0.6.0
 */