package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class c
  implements Parcelable.Creator
{
  static void a(CheckServerAuthResult paramCheckServerAuthResult, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCheckServerAuthResult.a);
    j.a(paramParcel, 2, paramCheckServerAuthResult.b);
    j.b(paramParcel, 3, paramCheckServerAuthResult.c, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.c
 * JD-Core Version:    0.6.0
 */