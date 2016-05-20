package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Event;

public class CountdownEventAction extends EventAction
{
  int count;
  int current;

  public CountdownEventAction(Class paramClass, int paramInt)
  {
    super(paramClass);
    this.count = paramInt;
  }

  public boolean handle(Event paramEvent)
  {
    this.current = (1 + this.current);
    return this.current >= this.count;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.CountdownEventAction
 * JD-Core Version:    0.6.0
 */