package com.badlogic.gdx.scenes.scene2d;

import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

public abstract class Action
  implements Pool.Poolable
{
  protected Actor actor;
  private Pool pool;
  protected Actor target;

  public abstract boolean act(float paramFloat);

  public Actor getActor()
  {
    return this.actor;
  }

  public Pool getPool()
  {
    return this.pool;
  }

  public Actor getTarget()
  {
    return this.target;
  }

  public void reset()
  {
    this.actor = null;
    this.target = null;
    this.pool = null;
    restart();
  }

  public void restart()
  {
  }

  public void setActor(Actor paramActor)
  {
    this.actor = paramActor;
    if (this.target == null)
      setTarget(paramActor);
    if ((paramActor == null) && (this.pool != null))
    {
      this.pool.free(this);
      this.pool = null;
    }
  }

  public void setPool(Pool paramPool)
  {
    this.pool = paramPool;
  }

  public void setTarget(Actor paramActor)
  {
    this.target = paramActor;
  }

  public String toString()
  {
    String str = getClass().getName();
    int i = str.lastIndexOf('.');
    if (i != -1)
      str = str.substring(i + 1);
    if (str.endsWith("Action"))
      str = str.substring(0, -6 + str.length());
    return str;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.scenes.scene2d.Action
 * JD-Core Version:    0.6.0
 */