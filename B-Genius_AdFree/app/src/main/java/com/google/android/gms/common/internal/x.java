package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;

public final class x
  implements ServiceConnection
{
  public x(w paramw)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (u.a(this.a.a))
    {
      w.a(this.a, paramIBinder);
      w.a(this.a, paramComponentName);
      Iterator localIterator = w.b(this.a).iterator();
      if (localIterator.hasNext())
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
    }
    w.a(this.a, 1);
    monitorexit;
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (u.a(this.a.a))
    {
      w.a(this.a, null);
      w.a(this.a, paramComponentName);
      Iterator localIterator = w.b(this.a).iterator();
      if (localIterator.hasNext())
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
    }
    w.a(this.a, 2);
    monitorexit;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.x
 * JD-Core Version:    0.6.0
 */