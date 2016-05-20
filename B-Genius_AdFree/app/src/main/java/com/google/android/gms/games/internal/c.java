package com.google.android.gms.games.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.w;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.internal.b.b;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public final class c extends com.google.android.gms.common.internal.i
{
  private b c = new d(this);
  private final String d;
  private final u e;
  private boolean f = false;
  private final long g;
  private final com.google.android.gms.games.i h;

  public c(Context paramContext, Looper paramLooper, f paramf, com.google.android.gms.games.i parami, com.google.android.gms.common.api.j paramj, com.google.android.gms.common.api.k paramk)
  {
    super(paramContext, paramLooper, 1, paramf, paramj, paramk);
    this.d = paramf.g();
    new Binder();
    this.e = u.a(this, paramf.c());
    View localView = paramf.i();
    this.e.a(localView);
    this.g = hashCode();
    this.h = parami;
  }

  private static void a(RemoteException paramRemoteException)
  {
    j.a("GamesClientImpl", "service died", paramRemoteException);
  }

  public final Intent a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Intent localIntent = ((q)o()).a(paramString, paramInt1, paramInt2);
      return localIntent;
    }
    catch (RemoteException localRemoteException)
    {
      a(localRemoteException);
    }
    return null;
  }

  protected final String a()
  {
    return "com.google.android.gms.games.service.START";
  }

  protected final Set a(Set paramSet)
  {
    Scope localScope1 = new Scope("https://www.googleapis.com/auth/games");
    Scope localScope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
    Iterator localIterator = paramSet.iterator();
    int i = 0;
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      Scope localScope3 = (Scope)localIterator.next();
      if (localScope3.equals(localScope1))
      {
        bool1 = true;
        continue;
      }
      if (!localScope3.equals(localScope2))
        break label150;
    }
    label150: for (int j = 1; ; j = i)
    {
      i = j;
      break;
      if (i != 0)
      {
        if (!bool1);
        for (boolean bool2 = true; ; bool2 = false)
        {
          w.a(bool2, "Cannot have both %s and %s!", new Object[] { "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty" });
          return paramSet;
        }
      }
      w.a(bool1, "Games APIs requires %s to function.", new Object[] { "https://www.googleapis.com/auth/games" });
      return paramSet;
    }
  }

  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null))
    {
      paramBundle.setClassLoader(c.class.getClassLoader());
      this.f = paramBundle.getBoolean("show_welcome_popup");
      paramBundle.getParcelable("com.google.android.gms.games.current_player");
      paramBundle.getParcelable("com.google.android.gms.games.current_game");
    }
    super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
  }

  public final void a(IBinder paramIBinder, Bundle paramBundle)
  {
    if (e());
    try
    {
      ((q)o()).a(paramIBinder, paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a(localRemoteException);
    }
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    super.a(paramConnectionResult);
    this.f = false;
  }

  public final void a(com.google.android.gms.common.api.internal.c paramc)
  {
    this.c.a();
    ((q)o()).a(new i(paramc));
  }

  public final void a(com.google.android.gms.common.api.internal.c paramc, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    ((q)o()).a(new g(paramc), null, paramString2, paramInt1, paramInt2);
  }

  public final void a(l paraml)
  {
    super.a(paraml);
  }

  protected final String b()
  {
    return "com.google.android.gms.games.internal.IGamesService";
  }

  public final Bundle b_()
  {
    try
    {
      Bundle localBundle = ((q)o()).b();
      if (localBundle != null)
        localBundle.setClassLoader(c.class.getClassLoader());
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      a(localRemoteException);
    }
    return null;
  }

  public final void c()
  {
    if (e());
    try
    {
      ((q)o()).c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a(localRemoteException);
    }
  }

  public final void d()
  {
    this.f = false;
    if (e());
    try
    {
      q localq = (q)o();
      localq.c();
      this.c.a();
      localq.a(this.g);
      super.d();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        j.a("GamesClientImpl", "Failed to notify client disconnect.");
    }
  }

  public final boolean f()
  {
    return true;
  }

  protected final Bundle m()
  {
    String str = k().getResources().getConfiguration().locale.toString();
    com.google.android.gms.games.i locali = this.h;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("com.google.android.gms.games.key.isHeadless", locali.a);
    localBundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", locali.b);
    localBundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", locali.c);
    localBundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", locali.d);
    localBundle.putInt("com.google.android.gms.games.key.sdkVariant", locali.e);
    localBundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", locali.f);
    localBundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", locali.g);
    localBundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", locali.h);
    localBundle.putString("com.google.android.gms.games.key.gamePackageName", this.d);
    localBundle.putString("com.google.android.gms.games.key.desiredLocale", str);
    localBundle.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.e.b()));
    localBundle.putInt("com.google.android.gms.games.key.API_VERSION", 3);
    localBundle.putBundle("com.google.android.gms.games.key.signInOptions", com.google.android.gms.signin.internal.k.a(l()));
    return localBundle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.c
 * JD-Core Version:    0.6.0
 */