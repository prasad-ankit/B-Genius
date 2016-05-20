package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.utils.Pool.Poolable;

public class Event
  implements Pool.Poolable
{
  private boolean bubbles = true;
  private boolean cancelled;
  private boolean capture;
  private boolean handled;
  private Actor listenerActor;
  private Stage stage;
  private boolean stopped;
  private Actor targetActor;

  public void cancel()
  {
    this.cancelled = true;
    this.stopped = true;
    this.handled = true;
  }

  public boolean getBubbles()
  {
    return this.bubbles;
  }

  public Actor getListenerActor()
  {
    return this.listenerActor;
  }

  public Stage getStage()
  {
    return this.stage;
  }

  public Actor getTarget()
  {
    return this.targetActor;
  }

  public void handle()
  {
    this.handled = true;
  }

  public boolean isCancelled()
  {
    return this.cancelled;
  }

  public boolean isCapture()
  {
    return this.capture;
  }

  public boolean isHandled()
  {
    return this.handled;
  }

  public boolean isStopped()
  {
    return this.stopped;
  }

  public void reset()
  {
    this.stage = null;
    this.targetActor = null;
    this.listenerActor = null;
    this.capture = false;
    this.bubbles = true;
    this.handled = false;
    this.stopped = false;
    this.cancelled = false;
  }

  public void setBubbles(boolean paramBoolean)
  {
    this.bubbles = paramBoolean;
  }

  public void setCapture(boolean paramBoolean)
  {
    this.capture = paramBoolean;
  }

  public void setListenerActor(Actor paramActor)
  {
    this.listenerActor = paramActor;
  }

  public void setStage(Stage paramStage)
  {
    this.stage = paramStage;
  }

  public void setTarget(Actor paramActor)
  {
    this.targetActor = paramActor;
  }

  public void stop()
  {
    this.stopped = true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Event
 * JD-Core Version:    0.6.0
 */