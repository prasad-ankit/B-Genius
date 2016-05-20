package com.badlogic.gdx.scenes.scene2d.utils;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.utils.Timer.Task;

class DragScrollListener$1 extends Timer.Task
{
  public void run()
  {
    this.val$scroll.setScrollY(this.val$scroll.getScrollY() - this.this$0.getScrollPixels());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.utils.DragScrollListener.1
 * JD-Core Version:    0.6.0
 */