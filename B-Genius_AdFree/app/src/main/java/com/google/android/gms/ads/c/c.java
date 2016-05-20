package com.google.android.gms.ads.c;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class c extends Thread
{
  CountDownLatch a;
  boolean b;
  private WeakReference c;
  private long d;

  public c(a parama, long paramLong)
  {
    this.c = new WeakReference(parama);
    this.d = paramLong;
    this.a = new CountDownLatch(1);
    this.b = false;
    start();
  }

  private void a()
  {
    a locala = (a)this.c.get();
    if (locala != null)
    {
      locala.c();
      this.b = true;
    }
  }

  public final void run()
  {
    try
    {
      if (!this.a.await(this.d, TimeUnit.MILLISECONDS))
        a();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      a();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.c.c
 * JD-Core Version:    0.6.0
 */