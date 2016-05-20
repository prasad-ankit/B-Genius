package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IInterface;
import com.google.android.gms.common.internal.A;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.M;
import com.google.android.gms.common.internal.ResolveAccountRequest;

public abstract interface g extends IInterface
{
  public abstract void a(int paramInt);

  public abstract void a(int paramInt, Account paramAccount, d paramd);

  public abstract void a(A paramA, int paramInt, boolean paramBoolean);

  public abstract void a(AuthAccountRequest paramAuthAccountRequest, d paramd);

  public abstract void a(ResolveAccountRequest paramResolveAccountRequest, M paramM);

  public abstract void a(CheckServerAuthResult paramCheckServerAuthResult);

  public abstract void a(RecordConsentRequest paramRecordConsentRequest, d paramd);

  public abstract void a(SignInRequest paramSignInRequest, d paramd);

  public abstract void a(d paramd);

  public abstract void a(boolean paramBoolean);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.g
 * JD-Core Version:    0.6.0
 */