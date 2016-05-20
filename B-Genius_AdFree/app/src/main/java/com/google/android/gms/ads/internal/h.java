package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.aS;
import com.google.android.gms.b.aW;
import com.google.android.gms.b.fT;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.is;

final class h
  implements Runnable
{
  h(e parame, gT paramgT, aR paramaR)
  {
  }

  public final void run()
  {
    if ((this.a.b.s) && (this.c.d.x != null))
    {
      String str1 = this.a.b.b;
      String str2 = null;
      if (str1 != null)
      {
        P.e();
        str2 = hu.a(this.a.b.b);
      }
      aS localaS = new aS(this.c, str2, this.a.b.c);
      this.c.d.D = 1;
      try
      {
        this.c.b = false;
        this.c.d.x.a(localaS);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        hc.c("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
        this.c.b = true;
      }
    }
    l locall = new l();
    is localis = this.c.a(this.a, locall);
    locall.a(new m(this.a, localis));
    localis.setOnTouchListener(new i(this, locall));
    localis.setOnClickListener(new j(this, locall));
    this.c.d.D = 0;
    Q localQ = this.c.d;
    P.d();
    localQ.h = fT.a(this.c.d.c, this.c, this.a, this.c.d.d, localis, this.c.h, this.c, this.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.h
 * JD-Core Version:    0.6.0
 */