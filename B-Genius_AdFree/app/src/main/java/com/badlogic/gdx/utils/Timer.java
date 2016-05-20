package com.badlogic.gdx.utils;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class Timer
{
  private static final int CANCELLED = -1;
  private static final int FOREVER = -2;
  static Timer instance;
  static final Array instances = new Array(1);
  static Timer.TimerThread thread;
  private final Array tasks = new Array(false, 8);

  static
  {
    instance = new Timer();
  }

  public Timer()
  {
    start();
  }

  public static Timer instance()
  {
    if (instance == null)
      instance = new Timer();
    return instance;
  }

  public static Timer.Task post(Timer.Task paramTask)
  {
    return instance().postTask(paramTask);
  }

  public static Timer.Task schedule(Timer.Task paramTask, float paramFloat)
  {
    return instance().scheduleTask(paramTask, paramFloat);
  }

  public static Timer.Task schedule(Timer.Task paramTask, float paramFloat1, float paramFloat2)
  {
    return instance().scheduleTask(paramTask, paramFloat1, paramFloat2);
  }

  public static Timer.Task schedule(Timer.Task paramTask, float paramFloat1, float paramFloat2, int paramInt)
  {
    return instance().scheduleTask(paramTask, paramFloat1, paramFloat2, paramInt);
  }

  static void wake()
  {
    synchronized (instances)
    {
      instances.notifyAll();
      return;
    }
  }

  public void clear()
  {
    synchronized (this.tasks)
    {
      int i = this.tasks.size;
      for (int j = 0; j < i; j++)
        ((Timer.Task)this.tasks.get(j)).cancel();
      this.tasks.clear();
      return;
    }
  }

  public void delay(long paramLong)
  {
    synchronized (this.tasks)
    {
      int i = this.tasks.size;
      for (int j = 0; j < i; j++)
      {
        Timer.Task localTask = (Timer.Task)this.tasks.get(j);
        localTask.executeTimeMillis = (paramLong + localTask.executeTimeMillis);
      }
      return;
    }
  }

  public Timer.Task postTask(Timer.Task paramTask)
  {
    return scheduleTask(paramTask, 0.0F, 0.0F, 0);
  }

  public Timer.Task scheduleTask(Timer.Task paramTask, float paramFloat)
  {
    return scheduleTask(paramTask, paramFloat, 0.0F, 0);
  }

  public Timer.Task scheduleTask(Timer.Task paramTask, float paramFloat1, float paramFloat2)
  {
    return scheduleTask(paramTask, paramFloat1, paramFloat2, -2);
  }

  public Timer.Task scheduleTask(Timer.Task paramTask, float paramFloat1, float paramFloat2, int paramInt)
  {
    if (paramTask.repeatCount != -1)
      throw new IllegalArgumentException("The same task may not be scheduled twice.");
    paramTask.executeTimeMillis = (System.nanoTime() / 1000000L + ()(paramFloat1 * 1000.0F));
    paramTask.intervalMillis = ()(paramFloat2 * 1000.0F);
    paramTask.repeatCount = paramInt;
    synchronized (this.tasks)
    {
      this.tasks.add(paramTask);
      wake();
      return paramTask;
    }
  }

  public void start()
  {
    synchronized (instances)
    {
      if (instances.contains(this, true))
        return;
      instances.add(this);
      if (thread == null)
        thread = new Timer.TimerThread();
      wake();
      return;
    }
  }

  public void stop()
  {
    synchronized (instances)
    {
      instances.removeValue(this, true);
      return;
    }
  }

  long update(long paramLong1, long paramLong2)
  {
    Array localArray = this.tasks;
    monitorenter;
    int i = 0;
    int j;
    long l1;
    int k;
    int m;
    long l3;
    long l2;
    try
    {
      j = this.tasks.size;
      l1 = paramLong2;
      if (i < j)
      {
        Timer.Task localTask = (Timer.Task)this.tasks.get(i);
        if (localTask.executeTimeMillis > paramLong1)
        {
          long l4 = Math.min(l1, localTask.executeTimeMillis - paramLong1);
          k = j;
          m = i;
          l3 = l4;
        }
        else
        {
          if (localTask.repeatCount != -1)
          {
            if (localTask.repeatCount == 0)
              localTask.repeatCount = -1;
            Gdx.app.postRunnable(localTask);
          }
          if (localTask.repeatCount == -1)
          {
            this.tasks.removeIndex(i);
            int i1 = i - 1;
            k = j - 1;
            m = i1;
            l3 = l1;
          }
          else
          {
            localTask.executeTimeMillis = (paramLong1 + localTask.intervalMillis);
            l2 = Math.min(l1, localTask.intervalMillis);
            if (localTask.repeatCount <= 0)
              break label241;
            localTask.repeatCount = (-1 + localTask.repeatCount);
            break label241;
          }
        }
      }
      else
      {
        return l1;
      }
    }
    finally
    {
      monitorexit;
    }
    while (true)
    {
      int n = m + 1;
      l1 = l3;
      i = n;
      j = k;
      break;
      label241: k = j;
      m = i;
      l3 = l2;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.Timer
 * JD-Core Version:    0.6.0
 */