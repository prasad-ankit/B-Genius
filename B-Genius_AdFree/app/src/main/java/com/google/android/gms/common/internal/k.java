package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.j;
import java.util.concurrent.atomic.AtomicInteger;

final class k extends Handler
{
  public k(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }

  private static void a(Message paramMessage)
  {
    ((l)paramMessage.obj).c();
  }

  private static boolean b(Message paramMessage)
  {
    return (paramMessage.what == 2) || (paramMessage.what == 1) || (paramMessage.what == 5);
  }

  public final void handleMessage(Message paramMessage)
  {
    if (this.a.b.get() != paramMessage.arg1)
    {
      if (b(paramMessage))
        a(paramMessage);
      return;
    }
    if (((paramMessage.what == 1) || (paramMessage.what == 5)) && (!this.a.j()))
    {
      a(paramMessage);
      return;
    }
    if (paramMessage.what == 3)
    {
      ConnectionResult localConnectionResult = new ConnectionResult(paramMessage.arg2, null);
      i.b(this.a).a(localConnectionResult);
      this.a.a(localConnectionResult);
      return;
    }
    if (paramMessage.what == 4)
    {
      i.a(this.a, 4, null);
      if (i.c(this.a) != null)
        i.c(this.a).a(paramMessage.arg2);
      this.a.a(paramMessage.arg2);
      i.a(this.a, 4, 1, null);
      return;
    }
    if ((paramMessage.what == 2) && (!this.a.e()))
    {
      a(paramMessage);
      return;
    }
    if (b(paramMessage))
    {
      ((l)paramMessage.obj).b();
      return;
    }
    Log.wtf("GmsClient", "Don't know how to handle message: " + paramMessage.what, new Exception());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.k
 * JD-Core Version:    0.6.0
 */