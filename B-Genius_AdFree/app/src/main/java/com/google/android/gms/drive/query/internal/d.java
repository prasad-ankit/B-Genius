package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(FilterHolder paramFilterHolder, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramFilterHolder.b, paramInt, false);
    j.a(paramParcel, 1000, paramFilterHolder.a);
    j.a(paramParcel, 2, paramFilterHolder.c, paramInt, false);
    j.a(paramParcel, 3, paramFilterHolder.d, paramInt, false);
    j.a(paramParcel, 4, paramFilterHolder.e, paramInt, false);
    j.a(paramParcel, 5, paramFilterHolder.f, paramInt, false);
    j.a(paramParcel, 6, paramFilterHolder.g, paramInt, false);
    j.a(paramParcel, 7, paramFilterHolder.h, paramInt, false);
    j.a(paramParcel, 8, paramFilterHolder.i, paramInt, false);
    j.a(paramParcel, 9, paramFilterHolder.j, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.d
 * JD-Core Version:    0.6.0
 */