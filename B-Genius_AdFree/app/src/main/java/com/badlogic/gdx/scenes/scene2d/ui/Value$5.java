package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Layout;

final class Value$5 extends Value
{
  public final float get(Actor paramActor)
  {
    if ((paramActor instanceof Layout))
      return ((Layout)paramActor).getMaxWidth();
    if (paramActor == null)
      return 0.0F;
    return paramActor.getWidth();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Value.5
 * JD-Core Version:    0.6.0
 */