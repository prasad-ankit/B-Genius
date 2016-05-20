package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;

public abstract class FocusListener
  implements EventListener
{
  public boolean handle(Event paramEvent)
  {
    if (!(paramEvent instanceof FocusListener.FocusEvent))
      return false;
    FocusListener.FocusEvent localFocusEvent = (FocusListener.FocusEvent)paramEvent;
    switch (FocusListener.1.$SwitchMap$com$badlogic$gdx$scenes$scene2d$utils$FocusListener$FocusEvent$Type[localFocusEvent.getType().ordinal()])
    {
    default:
      return false;
    case 1:
      keyboardFocusChanged(localFocusEvent, paramEvent.getTarget(), localFocusEvent.isFocused());
      return false;
    case 2:
    }
    scrollFocusChanged(localFocusEvent, paramEvent.getTarget(), localFocusEvent.isFocused());
    return false;
  }

  public void keyboardFocusChanged(FocusListener.FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean)
  {
  }

  public void scrollFocusChanged(FocusListener.FocusEvent paramFocusEvent, Actor paramActor, boolean paramBoolean)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.FocusListener
 * JD-Core Version:    0.6.0
 */