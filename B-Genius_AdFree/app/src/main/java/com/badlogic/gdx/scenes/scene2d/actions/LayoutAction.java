package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;
import com.badlogic.gdx.utils.GdxRuntimeException;

public class LayoutAction extends Action
{
  private boolean enabled;

  public boolean act(float paramFloat)
  {
    ((Layout)this.target).setLayoutEnabled(this.enabled);
    return true;
  }

  public boolean isEnabled()
  {
    return this.enabled;
  }

  public void setLayoutEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }

  public void setTarget(Actor paramActor)
  {
    if ((paramActor != null) && (!(paramActor instanceof Layout)))
      throw new GdxRuntimeException("Actor must implement layout: " + paramActor);
    super.setTarget(paramActor);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.LayoutAction
 * JD-Core Version:    0.6.0
 */