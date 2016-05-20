package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Actor;

class TextTooltip$1 extends Value
{
  public float get(Actor paramActor)
  {
    return Math.min(this.val$manager.maxWidth, ((Label)this.this$0.container.getActor()).getGlyphLayout().width);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.TextTooltip.1
 * JD-Core Version:    0.6.0
 */