package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class j
  implements Parcelable.Creator
{
  static void a(LogicalFilter paramLogicalFilter, Parcel paramParcel, int paramInt)
  {
    int i = android.support.v4.app.j.b(paramParcel);
    android.support.v4.app.j.a(paramParcel, 1000, paramLogicalFilter.c);
    android.support.v4.app.j.a(paramParcel, 1, paramLogicalFilter.a, paramInt, false);
    android.support.v4.app.j.b(paramParcel, 2, paramLogicalFilter.b, false);
    android.support.v4.app.j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.j
 * JD-Core Version:    0.6.0
 */