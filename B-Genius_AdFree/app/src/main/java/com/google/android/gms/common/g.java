package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
  implements ServiceConnection
{
  private boolean a = false;
  private final BlockingQueue b = new LinkedBlockingQueue();

  public final IBinder a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
      throw new IllegalStateException("BlockingServiceConnection.getService() called on main thread");
    if (this.a)
      throw new IllegalStateException();
    this.a = true;
    return (IBinder)this.b.take();
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.b.add(paramIBinder);
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.g
 * JD-Core Version:    0.6.0
 */