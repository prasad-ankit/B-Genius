package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new R();
  final int a;
  private final Account b;
  private final int c;
  private final GoogleSignInAccount d;

  ResolveAccountRequest(int paramInt1, Account paramAccount, int paramInt2, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.a = paramInt1;
    this.b = paramAccount;
    this.c = paramInt2;
    this.d = paramGoogleSignInAccount;
  }

  public ResolveAccountRequest(Account paramAccount, int paramInt, GoogleSignInAccount paramGoogleSignInAccount)
  {
    this(2, paramAccount, paramInt, paramGoogleSignInAccount);
  }

  public final Account a()
  {
    return this.b;
  }

  public final int b()
  {
    return this.c;
  }

  public final GoogleSignInAccount c()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    R.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.ResolveAccountRequest
 * JD-Core Version:    0.6.0
 */