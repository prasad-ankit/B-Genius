package com.google.android.gms.b;

import android.os.Handler;
import java.util.concurrent.Executor;

final class db
  implements Executor
{
  db(jx paramjx, Handler paramHandler)
  {
  }

  public final void execute(Runnable paramRunnable)
  {
    this.a.post(paramRunnable);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.db
 * JD-Core Version:    0.6.0
 */