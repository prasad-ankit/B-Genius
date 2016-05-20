package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.utils.reflect.ClassReflection;

class EventAction$1
  implements EventListener
{
  public boolean handle(Event paramEvent)
  {
    if ((!this.this$0.active) || (!ClassReflection.isInstance(this.this$0.eventClass, paramEvent)))
      return false;
    this.this$0.result = this.this$0.handle(paramEvent);
    return this.this$0.result;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.actions.EventAction.1
 * JD-Core Version:    0.6.0
 */