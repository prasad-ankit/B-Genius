package com.badlogic.gdx.input;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

class GestureDetector$1 extends Timer.Task
{
  public void run()
  {
    if (!this.this$0.longPressFired)
      this.this$0.longPressFired = this.this$0.listener.longPress(this.this$0.pointer1.x, this.this$0.pointer1.y);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.input.GestureDetector.1
 * JD-Core Version:    0.6.0
 */