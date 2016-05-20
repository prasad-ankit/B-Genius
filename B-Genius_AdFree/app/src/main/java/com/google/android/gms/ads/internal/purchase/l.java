package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.hn;

final class l
  implements ServiceConnection
{
  l(k paramk, Context paramContext)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    b localb = new b(this.a.getApplicationContext(), false);
    localb.a(paramIBinder);
    int i = localb.a(3, this.a.getPackageName(), "inapp");
    hn localhn = P.h();
    boolean bool = false;
    if (i == 0)
      bool = true;
    localhn.b(bool);
    this.a.unbindService(this);
    localb.a = null;
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.l
 * JD-Core Version:    0.6.0
 */