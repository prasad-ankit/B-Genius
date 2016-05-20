package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class h
  implements Parcelable.Creator
{
  static void a(ConnectionResult paramConnectionResult, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramConnectionResult.b);
    j.a(paramParcel, 2, paramConnectionResult.c());
    j.a(paramParcel, 3, paramConnectionResult.d(), paramInt, false);
    j.a(paramParcel, 4, paramConnectionResult.e(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.h
 * JD-Core Version:    0.6.0
 */