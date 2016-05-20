package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

final class Table$2 extends Value
{
  public final float get(Actor paramActor)
  {
    Drawable localDrawable = ((Table)paramActor).background;
    if (localDrawable == null)
      return 0.0F;
    return localDrawable.getTopHeight();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Table.2
 * JD-Core Version:    0.6.0
 */