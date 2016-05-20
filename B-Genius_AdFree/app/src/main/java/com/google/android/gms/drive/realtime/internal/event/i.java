package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class i
  implements Parcelable.Creator
{
  static void a(ValuesAddedDetails paramValuesAddedDetails, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramValuesAddedDetails.a);
    j.a(paramParcel, 2, paramValuesAddedDetails.b);
    j.a(paramParcel, 3, paramValuesAddedDetails.c);
    j.a(paramParcel, 4, paramValuesAddedDetails.d);
    j.a(paramParcel, 5, paramValuesAddedDetails.e, false);
    j.a(paramParcel, 6, paramValuesAddedDetails.f);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.i
 * JD-Core Version:    0.6.0
 */