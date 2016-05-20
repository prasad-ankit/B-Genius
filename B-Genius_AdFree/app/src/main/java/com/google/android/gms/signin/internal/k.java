package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.app.w;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.a.a;
import com.google.android.gms.b.kg;
import com.google.android.gms.b.kh;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.internal.A;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.o;

public final class k extends i
  implements kg
{
  private final boolean c;
  private final f d;
  private final Bundle e;
  private Integer f;

  public k(Context paramContext, Looper paramLooper, boolean paramBoolean, f paramf, Bundle paramBundle, j paramj, com.google.android.gms.common.api.k paramk)
  {
    super(paramContext, paramLooper, 44, paramf, paramj, paramk);
    this.c = paramBoolean;
    this.d = paramf;
    this.e = paramBundle;
    this.f = paramf.k();
  }

  public k(Context paramContext, Looper paramLooper, boolean paramBoolean, f paramf, j paramj, com.google.android.gms.common.api.k paramk)
  {
    this(paramContext, paramLooper, true, paramf, a(paramf), paramj, paramk);
  }

  public static Bundle a(f paramf)
  {
    kh localkh = paramf.j();
    Integer localInteger = paramf.k();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", paramf.a());
    if (localInteger != null)
      localBundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", localInteger.intValue());
    if (localkh != null)
    {
      localBundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", localkh.a());
      localBundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", localkh.b());
      localBundle.putString("com.google.android.gms.signin.internal.serverClientId", localkh.c());
      localBundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
      localBundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", localkh.d());
      localBundle.putString("com.google.android.gms.signin.internal.hostedDomain", localkh.e());
      localBundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", localkh.f());
    }
    return localBundle;
  }

  protected final String a()
  {
    return "com.google.android.gms.signin.service.START";
  }

  public final void a(A paramA, boolean paramBoolean)
  {
    try
    {
      ((g)o()).a(paramA, this.f.intValue(), paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
    }
  }

  public final void a(d paramd)
  {
    w.a(paramd, "Expecting a valid ISignInCallbacks");
    try
    {
      Account localAccount = this.d.b();
      boolean bool = "<<default account>>".equals(localAccount.name);
      GoogleSignInAccount localGoogleSignInAccount = null;
      if (bool)
        localGoogleSignInAccount = a.a(k()).a();
      ResolveAccountRequest localResolveAccountRequest = new ResolveAccountRequest(localAccount, this.f.intValue(), localGoogleSignInAccount);
      ((g)o()).a(new SignInRequest(localResolveAccountRequest), paramd);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
      try
      {
        paramd.a(new SignInResponse(8));
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", localRemoteException1);
      }
    }
  }

  protected final String b()
  {
    return "com.google.android.gms.signin.internal.ISignInService";
  }

  public final void c()
  {
    try
    {
      ((g)o()).a(this.f.intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
    }
  }

  public final boolean f()
  {
    return this.c;
  }

  public final void i()
  {
    a(new o(this));
  }

  protected final Bundle m()
  {
    String str = this.d.g();
    if (!k().getPackageName().equals(str))
      this.e.putString("com.google.android.gms.signin.internal.realClientPackageName", this.d.g());
    return this.e;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.k
 * JD-Core Version:    0.6.0
 */