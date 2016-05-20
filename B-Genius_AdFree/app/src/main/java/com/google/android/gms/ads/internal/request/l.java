package com.google.android.gms.ads.internal.request;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.hG;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.ij;

public abstract class l
  implements j, hG
{
  private final ij a;
  private final j b;
  private final Object c = new Object();

  public l(ij paramij, j paramj)
  {
    this.a = paramij;
    this.b = paramj;
  }

  public abstract void a();

  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    synchronized (this.c)
    {
      this.b.a(paramAdResponseParcel);
      a();
      return;
    }
  }

  final boolean a(v paramv, AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    try
    {
      paramv.a(paramAdRequestInfoParcel, new s(this));
      return true;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not fetch ad response from ad request service.", localRemoteException);
      P.h().a(localRemoteException, true);
      this.b.a(new AdResponseParcel(0));
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
      {
        hc.c("Could not fetch ad response from ad request service due to an Exception.", localNullPointerException);
        P.h().a(localNullPointerException, true);
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
      {
        hc.c("Could not fetch ad response from ad request service due to an Exception.", localSecurityException);
        P.h().a(localSecurityException, true);
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        hc.c("Could not fetch ad response from ad request service due to an Exception.", localThrowable);
        P.h().a(localThrowable, true);
      }
    }
  }

  public abstract v b();

  public final Void c()
  {
    v localv = b();
    if (localv == null)
    {
      this.b.a(new AdResponseParcel(0));
      a();
      return null;
    }
    this.a.a(new m(this, localv), new n(this));
    return null;
  }

  public final void d()
  {
    a();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.l
 * JD-Core Version:    0.6.0
 */