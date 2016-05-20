package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(GoogleSignInAccount paramGoogleSignInAccount, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGoogleSignInAccount.a);
    j.a(paramParcel, 2, paramGoogleSignInAccount.a(), false);
    j.a(paramParcel, 3, paramGoogleSignInAccount.b(), false);
    j.a(paramParcel, 4, paramGoogleSignInAccount.c(), false);
    j.a(paramParcel, 5, paramGoogleSignInAccount.d(), false);
    j.a(paramParcel, 6, paramGoogleSignInAccount.e(), paramInt, false);
    j.a(paramParcel, 7, paramGoogleSignInAccount.f(), false);
    j.a(paramParcel, 8, paramGoogleSignInAccount.g());
    j.a(paramParcel, 9, paramGoogleSignInAccount.h(), false);
    j.b(paramParcel, 10, paramGoogleSignInAccount.b, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.signin.b
 * JD-Core Version:    0.6.0
 */