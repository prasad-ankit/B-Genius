package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class m
  implements Parcelable.Creator
{
  static void a(SignInResponse paramSignInResponse, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramSignInResponse.a);
    j.a(paramParcel, 2, paramSignInResponse.a(), paramInt, false);
    j.a(paramParcel, 3, paramSignInResponse.b(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.m
 * JD-Core Version:    0.6.0
 */