package com.google.android.gms.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

public final class ho
{
  private static final ExecutorService a = Executors.newFixedThreadPool(10, a("Default"));
  private static final ExecutorService b = Executors.newFixedThreadPool(5, a("Loader"));

  public static ih a(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1)
      return a(b, new hp(paramRunnable));
    return a(a, new hq(paramRunnable));
  }

  public static ih a(Runnable paramRunnable)
  {
    return a(0, paramRunnable);
  }

  public static ih a(Callable paramCallable)
  {
    return a(a, paramCallable);
  }

  public static ih a(ExecutorService paramExecutorService, Callable paramCallable)
  {
    ic localic = new ic();
    try
    {
      localic.b(new hs(localic, paramExecutorService.submit(new hr(localic, paramCallable))));
      return localic;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      hc.c("Thread execution is rejected.", localRejectedExecutionException);
      localic.cancel(true);
    }
    return localic;
  }

  private static ThreadFactory a(String paramString)
  {
    return new ht(paramString);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ho
 * JD-Core Version:    0.6.0
 */