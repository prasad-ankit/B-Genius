package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;

class Tooltip$1 extends Container
{
  public void act(float paramFloat)
  {
    super.act(paramFloat);
    if ((this.this$0.targetActor != null) && (this.this$0.targetActor.getStage() == null))
      remove();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.Tooltip.1
 * JD-Core Version:    0.6.0
 */