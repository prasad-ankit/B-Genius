package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class t
  implements Parcelable.Creator
{
  static void a(Status paramStatus, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramStatus.f());
    j.a(paramParcel, 1000, paramStatus.d());
    j.a(paramParcel, 2, paramStatus.c(), false);
    j.a(paramParcel, 3, paramStatus.a(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.t
 * JD-Core Version:    0.6.0
 */