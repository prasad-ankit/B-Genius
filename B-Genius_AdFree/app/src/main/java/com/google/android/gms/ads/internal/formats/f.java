package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.app.w;
import com.google.android.gms.ads.internal.H;
import com.google.android.gms.b.eB;
import com.google.android.gms.b.ey;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.y;

public final class f extends g
{
  private ey a;
  private eB b;
  private final H c;
  private Object d = new Object();

  private f(Context paramContext, H paramH, y paramy)
  {
    super(paramContext, paramH, null, paramy, null, null, null);
    this.c = paramH;
  }

  public f(Context paramContext, H paramH, y paramy, eB parameB)
  {
    this(paramContext, paramH, paramy);
    this.b = parameB;
  }

  public f(Context paramContext, H paramH, y paramy, ey paramey)
  {
    this(paramContext, paramH, paramy);
    this.a = paramey;
  }

  public final void a()
  {
    w.b("recordImpression must be called on the main UI thread.");
    synchronized (this.d)
    {
      try
      {
        if ((this.a != null) && (!this.a.j()))
          this.a.i();
        while (true)
        {
          this.c.w();
          return;
          if ((this.b == null) || (this.b.h()))
            continue;
          this.b.g();
        }
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          hc.c("Failed to call recordImpression", localRemoteException);
      }
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.f
 * JD-Core Version:    0.6.0
 */