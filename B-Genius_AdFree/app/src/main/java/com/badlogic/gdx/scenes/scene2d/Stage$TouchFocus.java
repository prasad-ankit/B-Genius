package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.utils.Pool.Poolable;

public final class Stage$TouchFocus
  implements Pool.Poolable
{
  int button;
  EventListener listener;
  Actor listenerActor;
  int pointer;
  Actor target;

  public final void reset()
  {
    this.listenerActor = null;
    this.listener = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Stage.TouchFocus
 * JD-Core Version:    0.6.0
 */