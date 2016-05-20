package com.badlogic.gdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

class ScrollPane$3 extends InputListener
{
  public boolean scrolled(InputEvent paramInputEvent, float paramFloat1, float paramFloat2, int paramInt)
  {
    this.this$0.resetFade();
    if (this.this$0.scrollY)
      this.this$0.setScrollY(this.this$0.amountY + this.this$0.getMouseWheelY() * paramInt);
    while (true)
    {
      return true;
      if (!this.this$0.scrollX)
        break;
      this.this$0.setScrollX(this.this$0.amountX + this.this$0.getMouseWheelX() * paramInt);
    }
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.ui.ScrollPane.3
 * JD-Core Version:    0.6.0
 */