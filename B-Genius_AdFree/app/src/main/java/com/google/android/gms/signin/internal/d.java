package com.google.android.gms.signin.internal;

import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract interface d extends IInterface
{
  public abstract void a(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult);

  public abstract void a(Status paramStatus);

  public abstract void a(Status paramStatus, GoogleSignInAccount paramGoogleSignInAccount);

  public abstract void a(SignInResponse paramSignInResponse);

  public abstract void b(Status paramStatus);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.d
 * JD-Core Version:    0.6.0
 */