package com.google.android.gms.b;

import android.os.RemoteException;

final class ej
  implements Runnable
{
  ej(ei paramei, ec paramec)
  {
  }

  public final void run()
  {
    try
    {
      this.a.c.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not destroy mediation adapter.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ej
 * JD-Core Version:    0.6.0
 */