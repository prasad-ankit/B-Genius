package com.google.android.gms.b;

import android.os.Process;
import com.google.android.gms.ads.internal.P;
import java.util.concurrent.Callable;

final class hr
  implements Runnable
{
  hr(ic paramic, Callable paramCallable)
  {
  }

  public final void run()
  {
    try
    {
      Process.setThreadPriority(10);
      this.a.b(this.b.call());
      return;
    }
    catch (Exception localException)
    {
      P.h().a(localException, true);
      this.a.cancel(true);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hr
 * JD-Core Version:    0.6.0
 */