package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class e
  implements Parcelable.Creator
{
  static void a(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramReferenceShiftedDetails.a);
    j.a(paramParcel, 2, paramReferenceShiftedDetails.b, false);
    j.a(paramParcel, 3, paramReferenceShiftedDetails.c, false);
    j.a(paramParcel, 4, paramReferenceShiftedDetails.d);
    j.a(paramParcel, 5, paramReferenceShiftedDetails.e);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.e
 * JD-Core Version:    0.6.0
 */