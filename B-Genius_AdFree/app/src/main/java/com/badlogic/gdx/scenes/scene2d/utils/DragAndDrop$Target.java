package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class DragAndDrop$Target
{
  final Actor actor;

  public DragAndDrop$Target(Actor paramActor)
  {
    if (paramActor == null)
      throw new IllegalArgumentException("actor cannot be null.");
    this.actor = paramActor;
    Stage localStage = paramActor.getStage();
    if ((localStage != null) && (paramActor == localStage.getRoot()))
      throw new IllegalArgumentException("The stage root cannot be a drag and drop target.");
  }

  public abstract boolean drag(DragAndDrop.Source paramSource, DragAndDrop.Payload paramPayload, float paramFloat1, float paramFloat2, int paramInt);

  public abstract void drop(DragAndDrop.Source paramSource, DragAndDrop.Payload paramPayload, float paramFloat1, float paramFloat2, int paramInt);

  public Actor getActor()
  {
    return this.actor;
  }

  public void reset(DragAndDrop.Source paramSource, DragAndDrop.Payload paramPayload)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop.Target
 * JD-Core Version:    0.6.0
 */