package com.badlogic.gdx.utils.async;

import java.util.concurrent.ThreadFactory;

class AsyncExecutor$1
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = new Thread(paramRunnable, "AsynchExecutor-Thread");
    localThread.setDaemon(true);
    return localThread;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.badlogic.gdx.utils.async.AsyncExecutor.1
 * JD-Core Version:    0.6.0
 */