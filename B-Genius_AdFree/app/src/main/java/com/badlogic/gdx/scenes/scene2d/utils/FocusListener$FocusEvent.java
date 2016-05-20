package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;

public class FocusListener$FocusEvent extends Event
{
  private boolean focused;
  private Actor relatedActor;
  private FocusListener.FocusEvent.Type type;

  public Actor getRelatedActor()
  {
    return this.relatedActor;
  }

  public FocusListener.FocusEvent.Type getType()
  {
    return this.type;
  }

  public boolean isFocused()
  {
    return this.focused;
  }

  public void reset()
  {
    super.reset();
    this.relatedActor = null;
  }

  public void setFocused(boolean paramBoolean)
  {
    this.focused = paramBoolean;
  }

  public void setRelatedActor(Actor paramActor)
  {
    this.relatedActor = paramActor;
  }

  public void setType(FocusListener.FocusEvent.Type paramType)
  {
    this.type = paramType;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.FocusListener.FocusEvent
 * JD-Core Version:    0.6.0
 */