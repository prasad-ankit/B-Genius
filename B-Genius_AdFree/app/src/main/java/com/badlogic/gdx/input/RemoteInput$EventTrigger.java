package com.badlogic.gdx.input;

import com.badlogic.gdx.InputProcessor;

class RemoteInput$EventTrigger
  implements Runnable
{
  RemoteInput.KeyEvent keyEvent;
  RemoteInput.TouchEvent touchEvent;

  public RemoteInput$EventTrigger(RemoteInput paramRemoteInput, RemoteInput.TouchEvent paramTouchEvent, RemoteInput.KeyEvent paramKeyEvent)
  {
    this.touchEvent = paramTouchEvent;
    this.keyEvent = paramKeyEvent;
  }

  public void run()
  {
    this.this$0.justTouched = false;
    if (this.this$0.keyJustPressed)
    {
      this.this$0.keyJustPressed = false;
      for (int i = 0; i < this.this$0.justPressedKeys.length; i++)
        this.this$0.justPressedKeys[i] = false;
    }
    if (this.this$0.processor != null)
    {
      if (this.touchEvent != null)
      {
        this.this$0.touchX[this.touchEvent.pointer] = this.touchEvent.x;
        this.this$0.touchY[this.touchEvent.pointer] = this.touchEvent.y;
      }
      switch (this.touchEvent.type)
      {
      default:
        if (this.keyEvent == null)
          break;
        switch (this.keyEvent.type)
        {
        default:
        case 0:
        case 1:
        case 2:
        }
      case 0:
      case 1:
      case 2:
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.this$0.processor.touchDown(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
          this.this$0.isTouched[this.touchEvent.pointer] = true;
          this.this$0.justTouched = true;
          break;
          this.this$0.processor.touchUp(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer, 0);
          this.this$0.isTouched[this.touchEvent.pointer] = false;
          break;
          this.this$0.processor.touchDragged(this.touchEvent.x, this.touchEvent.y, this.touchEvent.pointer);
          break;
          this.this$0.processor.keyDown(this.keyEvent.keyCode);
          if (this.this$0.keys[this.keyEvent.keyCode] == 0)
          {
            RemoteInput localRemoteInput4 = this.this$0;
            localRemoteInput4.keyCount = (1 + localRemoteInput4.keyCount);
            this.this$0.keys[this.keyEvent.keyCode] = true;
          }
          this.this$0.keyJustPressed = true;
          this.this$0.justPressedKeys[this.keyEvent.keyCode] = true;
          return;
          this.this$0.processor.keyUp(this.keyEvent.keyCode);
        }
        while (this.this$0.keys[this.keyEvent.keyCode] == 0);
        RemoteInput localRemoteInput3 = this.this$0;
        localRemoteInput3.keyCount = (-1 + localRemoteInput3.keyCount);
        this.this$0.keys[this.keyEvent.keyCode] = false;
        return;
        this.this$0.processor.keyTyped(this.keyEvent.keyChar);
        return;
        if (this.touchEvent == null)
          continue;
        this.this$0.touchX[this.touchEvent.pointer] = this.touchEvent.x;
        this.this$0.touchY[this.touchEvent.pointer] = this.touchEvent.y;
        if (this.touchEvent.type == 0)
        {
          this.this$0.isTouched[this.touchEvent.pointer] = true;
          this.this$0.justTouched = true;
        }
        if (this.touchEvent.type != 1)
          continue;
        this.this$0.isTouched[this.touchEvent.pointer] = false;
      }
      while (this.keyEvent == null);
      if (this.keyEvent.type != 0)
        continue;
      if (this.this$0.keys[this.keyEvent.keyCode] == 0)
      {
        RemoteInput localRemoteInput2 = this.this$0;
        localRemoteInput2.keyCount = (1 + localRemoteInput2.keyCount);
        this.this$0.keys[this.keyEvent.keyCode] = true;
      }
      this.this$0.keyJustPressed = true;
      this.this$0.justPressedKeys[this.keyEvent.keyCode] = true;
    }
    while ((this.keyEvent.type != 1) || (this.this$0.keys[this.keyEvent.keyCode] == 0));
    RemoteInput localRemoteInput1 = this.this$0;
    localRemoteInput1.keyCount = (-1 + localRemoteInput1.keyCount);
    this.this$0.keys[this.keyEvent.keyCode] = false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.input.RemoteInput.EventTrigger
 * JD-Core Version:    0.6.0
 */