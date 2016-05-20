package com.google.android.gms.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class ht
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);

  ht(String paramString)
  {
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AdWorker(" + this.b + ") #" + this.a.getAndIncrement());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ht
 * JD-Core Version:    0.6.0
 */