package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.google.android.gms.common.stats.b;
import java.util.HashMap;

final class u extends t
  implements Handler.Callback
{
  private final HashMap a = new HashMap();
  private final Context b;
  private final Handler c;
  private final b d;
  private final long e;

  u(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new Handler(paramContext.getMainLooper(), this);
    this.d = b.a();
    this.e = 5000L;
  }

  private boolean a(v paramv, ServiceConnection paramServiceConnection, String paramString)
  {
    android.support.v4.app.w.a(paramServiceConnection, "ServiceConnection must not be null");
    while (true)
    {
      w localw;
      synchronized (this.a)
      {
        localw = (w)this.a.get(paramv);
        if (localw != null)
          continue;
        localw = new w(this, paramv);
        localw.a(paramServiceConnection, paramString);
        localw.a(paramString);
        this.a.put(paramv, localw);
        boolean bool = localw.b();
        return bool;
        this.c.removeMessages(0, localw);
        if (localw.b(paramServiceConnection))
          throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + paramv);
      }
      localw.a(paramServiceConnection, paramString);
      switch (localw.c())
      {
      case 1:
        paramServiceConnection.onServiceConnected(localw.f(), localw.e());
        break;
      case 2:
        localw.a(paramString);
        continue;
      }
    }
  }

  public final boolean a(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    return a(new v(paramString1), paramServiceConnection, paramString2);
  }

  public final void b(String paramString1, ServiceConnection paramServiceConnection, String paramString2)
  {
    v localv = new v(paramString1);
    android.support.v4.app.w.a(paramServiceConnection, "ServiceConnection must not be null");
    w localw;
    synchronized (this.a)
    {
      localw = (w)this.a.get(localv);
      if (localw == null)
        throw new IllegalStateException("Nonexistent connection status for service config: " + localv);
    }
    if (!localw.b(paramServiceConnection))
      throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + localv);
    localw.a(paramServiceConnection);
    if (localw.d())
    {
      Message localMessage = this.c.obtainMessage(0, localw);
      this.c.sendMessageDelayed(localMessage, 5000L);
    }
    monitorexit;
  }

  public final boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 0:
    }
    w localw = (w)paramMessage.obj;
    synchronized (this.a)
    {
      if (localw.d())
      {
        if (localw.b())
          localw.a();
        this.a.remove(w.a(localw));
      }
      return true;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.u
 * JD-Core Version:    0.6.0
 */