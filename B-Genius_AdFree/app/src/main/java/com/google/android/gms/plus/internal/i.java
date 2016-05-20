package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class i
  implements Parcelable.Creator
{
  static void a(PlusSession paramPlusSession, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPlusSession.b(), false);
    j.a(paramParcel, 1000, paramPlusSession.a());
    j.a(paramParcel, 2, paramPlusSession.c(), false);
    j.a(paramParcel, 3, paramPlusSession.d(), false);
    j.a(paramParcel, 4, paramPlusSession.e(), false);
    j.a(paramParcel, 5, paramPlusSession.f(), false);
    j.a(paramParcel, 6, paramPlusSession.g(), false);
    j.a(paramParcel, 7, paramPlusSession.h(), false);
    j.a(paramParcel, 8, paramPlusSession.i(), false);
    j.a(paramParcel, 9, paramPlusSession.j(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.internal.i
 * JD-Core Version:    0.6.0
 */