package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;

public class AddListenerAction extends Action
{
  private boolean capture;
  private EventListener listener;

  public boolean act(float paramFloat)
  {
    if (this.capture)
      this.target.addCaptureListener(this.listener);
    while (true)
    {
      return true;
      this.target.addListener(this.listener);
    }
  }

  public boolean getCapture()
  {
    return this.capture;
  }

  public EventListener getListener()
  {
    return this.listener;
  }

  public void reset()
  {
    super.reset();
    this.listener = null;
  }

  public void setCapture(boolean paramBoolean)
  {
    this.capture = paramBoolean;
  }

  public void setListener(EventListener paramEventListener)
  {
    this.listener = paramEventListener;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.AddListenerAction
 * JD-Core Version:    0.6.0
 */