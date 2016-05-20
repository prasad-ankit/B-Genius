package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new m();
  final int a;
  private final ConnectionResult b;
  private final ResolveAccountResponse c;

  public SignInResponse(int paramInt)
  {
    this(new ConnectionResult(8, null), null);
  }

  SignInResponse(int paramInt, ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this.a = paramInt;
    this.b = paramConnectionResult;
    this.c = paramResolveAccountResponse;
  }

  private SignInResponse(ConnectionResult paramConnectionResult, ResolveAccountResponse paramResolveAccountResponse)
  {
    this(1, paramConnectionResult, null);
  }

  public final ConnectionResult a()
  {
    return this.b;
  }

  public final ResolveAccountResponse b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    m.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInResponse
 * JD-Core Version:    0.6.0
 */