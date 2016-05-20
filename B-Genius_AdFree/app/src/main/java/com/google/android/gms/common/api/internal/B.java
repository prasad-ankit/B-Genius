package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class B extends Handler
{
  B(y paramy, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      Log.w("GoogleApiClientImpl", "Unknown message id: " + paramMessage.what);
      return;
    case 1:
      y.c(this.a);
      return;
    case 2:
    }
    y.b(this.a);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.B
 * JD-Core Version:    0.6.0
 */