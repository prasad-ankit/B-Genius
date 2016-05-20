package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.p;
import com.google.android.gms.common.api.q;

public final class e extends Handler
{
  public e()
  {
    this(Looper.getMainLooper());
  }

  public e(Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void a(q paramq, p paramp)
  {
    sendMessage(obtainMessage(1, new Pair(paramq, paramp)));
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      Log.wtf("BasePendingResult", "Don't know how to handle message: " + paramMessage.what, new Exception());
      return;
    case 1:
      Pair localPair = (Pair)paramMessage.obj;
      q localq = (q)localPair.first;
      p localp = (p)localPair.second;
      try
      {
        localq.a(localp);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        d.b(localp);
        throw localRuntimeException;
      }
    case 2:
    }
    ((d)paramMessage.obj).b(Status.c);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.e
 * JD-Core Version:    0.6.0
 */