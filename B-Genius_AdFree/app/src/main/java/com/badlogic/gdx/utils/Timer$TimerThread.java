package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.LifecycleListener;

class Timer$TimerThread
  implements LifecycleListener, Runnable
{
  Application app;
  private long pauseMillis;

  public Timer$TimerThread()
  {
    Gdx.app.addLifecycleListener(this);
    resume();
  }

  public void dispose()
  {
    pause();
    Gdx.app.removeLifecycleListener(this);
    Timer.instances.clear();
    Timer.instance = null;
  }

  public void pause()
  {
    this.pauseMillis = (System.nanoTime() / 1000000L);
    synchronized (Timer.instances)
    {
      this.app = null;
      Timer.wake();
      Timer.thread = null;
      return;
    }
  }

  public void resume()
  {
    long l = System.nanoTime() / 1000000L - this.pauseMillis;
    synchronized (Timer.instances)
    {
      int i = Timer.instances.size;
      for (int j = 0; j < i; j++)
        ((Timer)Timer.instances.get(j)).delay(l);
      this.app = Gdx.app;
      Thread localThread = new Thread(this, "Timer");
      localThread.setDaemon(true);
      localThread.start();
      Timer.thread = this;
      return;
    }
  }

  public void run()
  {
    while (true)
    {
      long l2;
      synchronized (Timer.instances)
      {
        if (this.app != Gdx.app)
          return;
        long l1 = System.nanoTime() / 1000000L;
        int i = Timer.instances.size;
        l2 = 5000L;
        int j = 0;
        if (j < i)
          try
          {
            long l3 = ((Timer)Timer.instances.get(j)).update(l1, l2);
            l2 = l3;
            j++;
          }
          catch (Throwable localThrowable)
          {
            throw new GdxRuntimeException("Task failed: " + ((Timer)Timer.instances.get(j)).getClass().getName(), localThrowable);
          }
      }
      if (this.app != Gdx.app)
      {
        monitorexit;
        return;
      }
      if (l2 > 0L);
      try
      {
        Timer.instances.wait(l2);
        label156: monitorexit;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label156;
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Timer.TimerThread
 * JD-Core Version:    0.6.0
 */