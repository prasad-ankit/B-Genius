package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class SignInRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new l();
  final int a;
  final ResolveAccountRequest b;

  SignInRequest(int paramInt, ResolveAccountRequest paramResolveAccountRequest)
  {
    this.a = paramInt;
    this.b = paramResolveAccountRequest;
  }

  public SignInRequest(ResolveAccountRequest paramResolveAccountRequest)
  {
    this(1, paramResolveAccountRequest);
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.SignInRequest
 * JD-Core Version:    0.6.0
 */