package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public abstract class DragAndDrop$Source
{
  final Actor actor;

  public DragAndDrop$Source(Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    this.actor = paramActor;
  }

  public abstract DragAndDrop.Payload dragStart(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt);

  public void dragStop(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt, DragAndDrop.Payload paramPayload, DragAndDrop.Target paramTarget)
  {
  }

  public Actor getActor()
  {
    return this.actor;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Source
 * JD-Core Version:    0.6.0
 */