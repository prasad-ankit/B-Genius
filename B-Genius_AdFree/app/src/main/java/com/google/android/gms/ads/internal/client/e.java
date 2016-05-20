package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.a.k;
import com.google.android.gms.b.ek;

public final class e
{
  private final ek a = new ek();
  private final Context b;
  private final s c;
  private com.google.android.gms.ads.a d;
  private a e;
  private N f;
  private String g;
  private com.google.android.gms.ads.d.b h;
  private String i;
  private boolean j;

  public e(Context paramContext)
  {
    this(paramContext, s.a(), null);
  }

  private e(Context paramContext, s params, com.google.android.gms.ads.a.b paramb)
  {
    this.b = paramContext;
    this.c = params;
  }

  private void c(String paramString)
  {
    if (this.f == null)
      throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + paramString + " is called.");
  }

  public final void a(com.google.android.gms.ads.a parama)
  {
    try
    {
      this.d = parama;
      N localN;
      if (this.f != null)
      {
        localN = this.f;
        if (parama == null)
          break label40;
      }
      label40: for (n localn = new n(parama); ; localn = null)
      {
        localN.a(localn);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to set the AdListener.", localRemoteException);
    }
  }

  public final void a(com.google.android.gms.ads.d.b paramb)
  {
    try
    {
      this.h = paramb;
      N localN;
      if (this.f != null)
      {
        localN = this.f;
        if (paramb == null)
          break label40;
      }
      label40: for (k localk = new k(paramb); ; localk = null)
      {
        localN.a(localk);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to set the AdListener.", localRemoteException);
    }
  }

  public final void a(a parama)
  {
    try
    {
      this.e = parama;
      N localN;
      if (this.f != null)
      {
        localN = this.f;
        if (parama == null)
          break label40;
      }
      label40: for (m localm = new m(parama); ; localm = null)
      {
        localN.a(localm);
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to set the AdClickListener.", localRemoteException);
    }
  }

  public final void a(b paramb)
  {
    try
    {
      if (this.f == null)
      {
        if (this.g == null)
          c("loadAd");
        if (!this.j)
          break label187;
      }
      label187: for (AdSizeParcel localAdSizeParcel = AdSizeParcel.b(); ; localAdSizeParcel = new AdSizeParcel())
      {
        this.f = x.b().b(this.b, localAdSizeParcel, this.g, this.a);
        if (this.d != null)
          this.f.a(new n(this.d));
        if (this.e != null)
          this.f.a(new m(this.e));
        if (this.h != null)
          this.f.a(new k(this.h));
        if (this.i != null)
          this.f.a(this.i);
        if (!this.f.a(s.a(this.b, paramb)))
          break;
        this.a.a(paramb.j());
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to load ad.", localRemoteException);
    }
  }

  public final void a(String paramString)
  {
    if (this.g != null)
      throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    this.g = paramString;
  }

  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public final boolean a()
  {
    try
    {
      if (this.f == null)
        return false;
      boolean bool = this.f.c();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to check if ad is ready.", localRemoteException);
    }
    return false;
  }

  public final void b()
  {
    try
    {
      c("show");
      this.f.f();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to show interstitial.", localRemoteException);
    }
  }

  public final void b(String paramString)
  {
    try
    {
      this.i = paramString;
      if (this.f != null)
        this.f.a(paramString);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to set the AdListener.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.e
 * JD-Core Version:    0.6.0
 */