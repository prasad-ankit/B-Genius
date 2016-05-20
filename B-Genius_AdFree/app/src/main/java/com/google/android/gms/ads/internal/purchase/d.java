package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.b.fF;
import com.google.android.gms.b.hc;

final class d
  implements Runnable
{
  d(c paramc, g paramg, Intent paramIntent)
  {
  }

  public final void run()
  {
    try
    {
      if (c.a(this.c).a(this.a.b, this.b))
      {
        c.c(this.c).a(new h(c.b(this.c), this.a.c, true, -1, this.b, this.a));
        return;
      }
      c.c(this.c).a(new h(c.b(this.c), this.a.c, false, -1, this.b, this.a));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.d("Fail to verify and dispatch pending transaction");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.d
 * JD-Core Version:    0.6.0
 */