package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.app.w;
import com.google.android.gms.ads.b.g;
import com.google.android.gms.ads.b.i;
import com.google.android.gms.ads.internal.client.H;
import com.google.android.gms.ads.internal.client.n;
import com.google.android.gms.ads.internal.client.o;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.b.bD;
import com.google.android.gms.b.bE;
import com.google.android.gms.b.ek;

public class c
{
  private final Context a;
  private final H b;

  private c(Context paramContext, H paramH)
  {
    this.a = paramContext;
    this.b = paramH;
  }

  public c(Context paramContext, String paramString)
  {
    this((Context)w.a(paramContext, "context cannot be null"), o.a(paramContext, paramString, new ek()));
  }

  public static f a(int paramInt1, int paramInt2, String paramString)
  {
    return new f(paramInt1, paramInt2, paramString);
  }

  public final b a()
  {
    try
    {
      b localb = new b(this.a, this.b.a());
      return localb;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Failed to build AdLoader.", localRemoteException);
    }
    return null;
  }

  public final c a(a parama)
  {
    try
    {
      this.b.a(new n(parama));
      return this;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to set AdListener.", localRemoteException);
    }
    return this;
  }

  public final c a(com.google.android.gms.ads.b.c paramc)
  {
    try
    {
      this.b.a(new NativeAdOptionsParcel(paramc));
      return this;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to specify native ad options", localRemoteException);
    }
    return this;
  }

  public final c a(g paramg)
  {
    try
    {
      this.b.a(new bD(paramg));
      return this;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to add app install ad listener", localRemoteException);
    }
    return this;
  }

  public final c a(i parami)
  {
    try
    {
      this.b.a(new bE(parami));
      return this;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.c("Failed to add content ad listener", localRemoteException);
    }
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.c
 * JD-Core Version:    0.6.0
 */