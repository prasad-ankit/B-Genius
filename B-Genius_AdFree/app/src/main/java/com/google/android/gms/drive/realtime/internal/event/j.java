package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class j
  implements Parcelable.Creator
{
  static void a(ValuesRemovedDetails paramValuesRemovedDetails, Parcel paramParcel)
  {
    int i = android.support.v4.app.j.b(paramParcel);
    android.support.v4.app.j.a(paramParcel, 1, paramValuesRemovedDetails.a);
    android.support.v4.app.j.a(paramParcel, 2, paramValuesRemovedDetails.b);
    android.support.v4.app.j.a(paramParcel, 3, paramValuesRemovedDetails.c);
    android.support.v4.app.j.a(paramParcel, 4, paramValuesRemovedDetails.d);
    android.support.v4.app.j.a(paramParcel, 5, paramValuesRemovedDetails.e, false);
    android.support.v4.app.j.a(paramParcel, 6, paramValuesRemovedDetails.f);
    android.support.v4.app.j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.j
 * JD-Core Version:    0.6.0
 */