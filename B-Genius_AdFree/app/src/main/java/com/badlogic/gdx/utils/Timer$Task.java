package com.badlogic.gdx.utils;

public abstract class Timer$Task
  implements Runnable
{
  long executeTimeMillis;
  long intervalMillis;
  int repeatCount = -1;

  public void cancel()
  {
    this.executeTimeMillis = 0L;
    this.repeatCount = -1;
  }

  public long getExecuteTimeMillis()
  {
    return this.executeTimeMillis;
  }

  public boolean isScheduled()
  {
    return this.repeatCount != -1;
  }

  public abstract void run();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Timer.Task
 * JD-Core Version:    0.6.0
 */