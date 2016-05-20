package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class DragAndDrop$Payload
{
  Actor dragActor;
  Actor invalidDragActor;
  Object object;
  Actor validDragActor;

  public Actor getDragActor()
  {
    return this.dragActor;
  }

  public Actor getInvalidDragActor()
  {
    return this.invalidDragActor;
  }

  public Object getObject()
  {
    return this.object;
  }

  public Actor getValidDragActor()
  {
    return this.validDragActor;
  }

  public void setDragActor(Actor paramActor)
  {
    this.dragActor = paramActor;
  }

  public void setInvalidDragActor(Actor paramActor)
  {
    this.invalidDragActor = paramActor;
  }

  public void setObject(Object paramObject)
  {
    this.object = paramObject;
  }

  public void setValidDragActor(Actor paramActor)
  {
    this.validDragActor = paramActor;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Payload
 * JD-Core Version:    0.6.0
 */