package com.google.android.gms.b;

import android.support.v4.app.w;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class jz
  implements ThreadFactory
{
  private final String a;
  private final int b;
  private final AtomicInteger c = new AtomicInteger();
  private final ThreadFactory d = Executors.defaultThreadFactory();

  public jz(String paramString)
  {
    this(paramString, 0);
  }

  private jz(String paramString, int paramInt)
  {
    this.a = ((String)w.a(paramString, "Name must not be null"));
    this.b = 0;
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = this.d.newThread(new jA(paramRunnable, this.b));
    localThread.setName(this.a + "[" + this.c.getAndIncrement() + "]");
    return localThread;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.jz
 * JD-Core Version:    0.6.0
 */