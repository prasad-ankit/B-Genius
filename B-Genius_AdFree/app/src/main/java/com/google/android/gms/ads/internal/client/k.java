package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.support.v4.a.a;

final class k
  implements Runnable
{
  k(j paramj)
  {
  }

  public final void run()
  {
    if (j.a(this.a) != null);
    try
    {
      j.a(this.a).a(1);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not notify onAdFailedToLoad event.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.k
 * JD-Core Version:    0.6.0
 */