package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.f;
import com.google.android.gms.b.ek;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
{
  private final ek a = new ek();
  private final s b;
  private com.google.android.gms.ads.a c;
  private a d;
  private N e;
  private f[] f;
  private String g;
  private ViewGroup h;
  private boolean i;

  private d(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, s params, N paramN, boolean paramBoolean2)
  {
    this.h = paramViewGroup;
    this.b = params;
    this.e = null;
    new AtomicBoolean(false);
    this.i = paramBoolean2;
    Context localContext;
    if (paramAttributeSet != null)
      localContext = paramViewGroup.getContext();
    try
    {
      u localu = new u(localContext, paramAttributeSet);
      this.f = localu.a(paramBoolean1);
      this.g = localu.a();
      if (paramViewGroup.isInEditMode())
      {
        com.google.android.gms.ads.internal.util.client.a locala = x.a();
        f localf = this.f[0];
        boolean bool = this.i;
        AdSizeParcel localAdSizeParcel = new AdSizeParcel(localContext, localf);
        localAdSizeParcel.k = bool;
        locala.a(paramViewGroup, localAdSizeParcel, "Ads by Google");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      x.a().a(paramViewGroup, new AdSizeParcel(localContext, f.a), localIllegalArgumentException.getMessage(), localIllegalArgumentException.getMessage());
    }
  }

  private d(ViewGroup paramViewGroup, AttributeSet paramAttributeSet, boolean paramBoolean1, s params, boolean paramBoolean2)
  {
    this(paramViewGroup, null, false, params, null, paramBoolean2);
  }

  public d(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    this(paramViewGroup, null, false, s.a(), paramBoolean);
  }

  private static AdSizeParcel a(Context paramContext, f[] paramArrayOff, boolean paramBoolean)
  {
    AdSizeParcel localAdSizeParcel = new AdSizeParcel(paramContext, paramArrayOff);
    localAdSizeParcel.k = paramBoolean;
    return localAdSizeParcel;
  }

  private void e()
  {
    try
    {
      com.google.android.gms.a.a locala = this.e.a();
      if (locala == null)
        return;
      this.h.addView((View)com.google.android.gms.a.d.a(locala));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to get an ad frame.", localRemoteException);
    }
  }

  public final void a()
  {
    try
    {
      if (this.e != null)
        this.e.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to destroy AdView.", localRemoteException);
    }
  }

  public final void a(com.google.android.gms.ads.a parama)
  {
    try
    {
      this.c = parama;
      N localN;
      if (this.e != null)
      {
        localN = this.e;
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

  public final void a(a parama)
  {
    try
    {
      this.d = parama;
      N localN;
      if (this.e != null)
      {
        localN = this.e;
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
    do
    {
      try
      {
        if (this.e != null)
          continue;
        if (((this.f == null) || (this.g == null)) && (this.e == null))
          throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
      }
      catch (RemoteException localRemoteException)
      {
        android.support.v4.a.a.c("Failed to load ad.", localRemoteException);
        return;
      }
      Context localContext = this.h.getContext();
      this.e = x.b().a(localContext, a(localContext, this.f, this.i), this.g, this.a);
      if (this.c != null)
        this.e.a(new n(this.c));
      if (this.d != null)
        this.e.a(new m(this.d));
      this.e.a(false);
      e();
    }
    while (!this.e.a(s.a(this.h.getContext(), paramb)));
    this.a.a(paramb.j());
  }

  public final void a(String paramString)
  {
    if (this.g != null)
      throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    this.g = paramString;
  }

  public final void a(f[] paramArrayOff)
  {
    if (this.f != null)
      throw new IllegalStateException("The ad size can only be set once on AdView.");
    this.f = paramArrayOff;
    try
    {
      if (this.e != null)
        this.e.a(a(this.h.getContext(), this.f, this.i));
      this.h.requestLayout();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        android.support.v4.a.a.c("Failed to set the ad size.", localRemoteException);
    }
  }

  public final f b()
  {
    try
    {
      if (this.e != null)
      {
        AdSizeParcel localAdSizeParcel = this.e.i();
        if (localAdSizeParcel != null)
        {
          f localf = localAdSizeParcel.c();
          return localf;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to get the current AdSize.", localRemoteException);
      if (this.f != null)
        return this.f[0];
    }
    return null;
  }

  public final void c()
  {
    try
    {
      if (this.e != null)
        this.e.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to call pause.", localRemoteException);
    }
  }

  public final void d()
  {
    try
    {
      if (this.e != null)
        this.e.c_();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to call resume.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.d
 * JD-Core Version:    0.6.0
 */