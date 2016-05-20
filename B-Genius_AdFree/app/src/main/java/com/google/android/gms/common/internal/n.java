package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.w;

public final class n
  implements ServiceConnection
{
  private final int a;

  public n(i parami, int paramInt)
  {
    this.a = paramInt;
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    w.a(paramIBinder, "Expecting a valid IBinder");
    synchronized (i.a(this.b))
    {
      i.a(this.b, K.a(paramIBinder));
      this.b.a(0, this.a);
      return;
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (i.a(this.b))
    {
      i.a(this.b, null);
      this.b.a.sendMessage(this.b.a.obtainMessage(4, this.a, 1));
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.n
 * JD-Core Version:    0.6.0
 */