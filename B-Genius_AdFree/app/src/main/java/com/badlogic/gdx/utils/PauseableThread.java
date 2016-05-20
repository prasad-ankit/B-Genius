package com.badlogic.gdx.utils;

public class PauseableThread extends Thread
{
  boolean exit = false;
  boolean paused = false;
  final Runnable runnable;

  public PauseableThread(Runnable paramRunnable)
  {
    this.runnable = paramRunnable;
  }

  public boolean isPaused()
  {
    return this.paused;
  }

  public void onPause()
  {
    this.paused = true;
  }

  public void onResume()
  {
    monitorenter;
    try
    {
      this.paused = false;
      notifyAll();
      return;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void run()
  {
    while (true)
    {
      monitorenter;
      try
      {
        while (this.paused)
          wait();
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        monitorexit;
        if (this.exit)
          return;
      }
      finally
      {
        monitorexit;
      }
      this.runnable.run();
    }
  }

  public void stopThread()
  {
    this.exit = true;
    if (this.paused)
      onResume();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.PauseableThread
 * JD-Core Version:    0.6.0
 */