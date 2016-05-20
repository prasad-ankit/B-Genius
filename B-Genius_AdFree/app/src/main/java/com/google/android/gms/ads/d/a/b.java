package com.google.android.gms.ads.d.a;

import android.os.RemoteException;
import android.support.v4.app.w;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.b.hc;

public class b
{
  private final com.google.android.gms.ads.internal.reward.mediation.client.a a;

  public b(com.google.android.gms.ads.internal.reward.mediation.client.a parama)
  {
    this.a = parama;
  }

  public void a(a parama)
  {
    w.b("onInitializationSucceeded must be called on the main UI thread.");
    hc.a("Adapter called onInitializationSucceeded.");
    try
    {
      this.a.a(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onInitializationSucceeded.", localRemoteException);
    }
  }

  public void a(a parama, int paramInt)
  {
    w.b("onAdFailedToLoad must be called on the main UI thread.");
    hc.a("Adapter called onAdFailedToLoad.");
    try
    {
      this.a.b(d.a(parama), paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void a(a parama, com.google.android.gms.ads.d.a parama1)
  {
    w.b("onRewarded must be called on the main UI thread.");
    hc.a("Adapter called onRewarded.");
    if (parama1 != null);
    try
    {
      this.a.a(d.a(parama), new RewardItemParcel(parama1));
      return;
      this.a.a(d.a(parama), new RewardItemParcel(parama.getClass().getName(), 1));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onRewarded.", localRemoteException);
    }
  }

  public void b(a parama)
  {
    w.b("onAdLoaded must be called on the main UI thread.");
    hc.a("Adapter called onAdLoaded.");
    try
    {
      this.a.b(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void c(a parama)
  {
    w.b("onAdOpened must be called on the main UI thread.");
    hc.a("Adapter called onAdOpened.");
    try
    {
      this.a.c(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void d(a parama)
  {
    w.b("onVideoStarted must be called on the main UI thread.");
    hc.a("Adapter called onVideoStarted.");
    try
    {
      this.a.d(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onVideoStarted.", localRemoteException);
    }
  }

  public void e(a parama)
  {
    w.b("onAdClosed must be called on the main UI thread.");
    hc.a("Adapter called onAdClosed.");
    try
    {
      this.a.e(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void f(a parama)
  {
    w.b("onAdLeftApplication must be called on the main UI thread.");
    hc.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.g(d.a(parama));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.d.a.b
 * JD-Core Version:    0.6.0
 */