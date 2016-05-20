package com.google.android.gms.b;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.y;

final class gz
  implements Runnable
{
  gz(gq paramgq, AdRequestInfoParcel paramAdRequestInfoParcel, y paramy)
  {
  }

  public final void run()
  {
    try
    {
      AdResponseParcel localAdResponseParcel2 = this.c.a(this.a);
      localAdResponseParcel1 = localAdResponseParcel2;
      if (localAdResponseParcel1 == null)
        localAdResponseParcel1 = new AdResponseParcel(0);
    }
    catch (Exception localException)
    {
      try
      {
        this.b.a(localAdResponseParcel1);
        return;
        localException = localException;
        P.h().a(localException, true);
        hc.c("Could not fetch ad response due to an Exception.", localException);
        AdResponseParcel localAdResponseParcel1 = null;
      }
      catch (RemoteException localRemoteException)
      {
        hc.c("Fail to forward ad response.", localRemoteException);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gz
 * JD-Core Version:    0.6.0
 */