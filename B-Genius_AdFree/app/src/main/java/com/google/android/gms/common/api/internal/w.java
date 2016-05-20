package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

abstract class w
  implements Runnable
{
  private w(n paramn)
  {
  }

  protected abstract void a();

  public void run()
  {
    n.c(this.a).lock();
    try
    {
      boolean bool = Thread.interrupted();
      if (bool)
        return;
      a();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      n.d(this.a).a(localRuntimeException);
      return;
    }
    finally
    {
      n.c(this.a).unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.w
 * JD-Core Version:    0.6.0
 */