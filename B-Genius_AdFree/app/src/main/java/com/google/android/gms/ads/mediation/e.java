package com.google.android.gms.ads.mediation;

import android.os.RemoteException;
import android.support.v4.a.a;
import android.support.v4.app.w;
import com.google.android.gms.b.er;

public class e
  implements g, i
{
  private final er a;
  private j b;

  public e(er paramer)
  {
    this.a = paramer;
  }

  public void a()
  {
    w.b("onAdLoaded must be called on the main UI thread.");
    a.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void a(int paramInt)
  {
    w.b("onAdFailedToLoad must be called on the main UI thread.");
    a.a("Adapter called onAdFailedToLoad with error. " + paramInt);
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void a(j paramj)
  {
    w.b("onAdLoaded must be called on the main UI thread.");
    a.a("Adapter called onAdLoaded.");
    this.b = paramj;
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void b()
  {
    w.b("onAdOpened must be called on the main UI thread.");
    a.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void b(int paramInt)
  {
    w.b("onAdFailedToLoad must be called on the main UI thread.");
    a.a("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void c()
  {
    w.b("onAdClosed must be called on the main UI thread.");
    a.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void c(int paramInt)
  {
    w.b("onAdFailedToLoad must be called on the main UI thread.");
    a.a("Adapter called onAdFailedToLoad with error " + paramInt + ".");
    try
    {
      this.a.a(paramInt);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdFailedToLoad.", localRemoteException);
    }
  }

  public void d()
  {
    w.b("onAdLeftApplication must be called on the main UI thread.");
    a.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void e()
  {
    w.b("onAdClicked must be called on the main UI thread.");
    a.a("Adapter called onAdClicked.");
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClicked.", localRemoteException);
    }
  }

  public void f()
  {
    w.b("onAdClicked must be called on the main UI thread.");
    a.a("Adapter called onAdClicked.");
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClicked.", localRemoteException);
    }
  }

  public void g()
  {
    w.b("onAdClosed must be called on the main UI thread.");
    a.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void h()
  {
    w.b("onAdLeftApplication must be called on the main UI thread.");
    a.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void i()
  {
    w.b("onAdOpened must be called on the main UI thread.");
    a.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void j()
  {
    w.b("onAdLoaded must be called on the main UI thread.");
    a.a("Adapter called onAdLoaded.");
    try
    {
      this.a.e();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLoaded.", localRemoteException);
    }
  }

  public void k()
  {
    w.b("onAdOpened must be called on the main UI thread.");
    a.a("Adapter called onAdOpened.");
    try
    {
      this.a.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdOpened.", localRemoteException);
    }
  }

  public void l()
  {
    w.b("onAdClosed must be called on the main UI thread.");
    a.a("Adapter called onAdClosed.");
    try
    {
      this.a.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClosed.", localRemoteException);
    }
  }

  public void m()
  {
    w.b("onAdLeftApplication must be called on the main UI thread.");
    a.a("Adapter called onAdLeftApplication.");
    try
    {
      this.a.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdLeftApplication.", localRemoteException);
    }
  }

  public void n()
  {
    w.b("onAdClicked must be called on the main UI thread.");
    a.a("Adapter called onAdClicked.");
    try
    {
      this.a.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.c("Could not call onAdClicked.", localRemoteException);
    }
  }

  public j o()
  {
    return this.b;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.e
 * JD-Core Version:    0.6.0
 */