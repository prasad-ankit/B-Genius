package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

public abstract class EventAction extends Action
{
  boolean active;
  final Class eventClass;
  private final EventListener listener = new EventAction.1(this);
  boolean result;

  public EventAction(Class paramClass)
  {
    this.eventClass = paramClass;
  }

  public boolean act(float paramFloat)
  {
    this.active = true;
    return this.result;
  }

  public abstract boolean handle(Event paramEvent);

  public boolean isActive()
  {
    return this.active;
  }

  public void restart()
  {
    this.result = false;
    this.active = false;
  }

  public void setActive(boolean paramBoolean)
  {
    this.active = paramBoolean;
  }

  public void setTarget(Actor paramActor)
  {
    if (this.target != null)
      this.target.removeListener(this.listener);
    super.setTarget(paramActor);
    if (paramActor != null)
      paramActor.addListener(this.listener);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.EventAction
 * JD-Core Version:    0.6.0
 */