package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramParcelableEventList.a);
    j.b(paramParcel, 2, paramParcelableEventList.b, false);
    j.a(paramParcel, 3, paramParcelableEventList.c, paramInt, false);
    j.a(paramParcel, 4, paramParcelableEventList.d);
    j.a(paramParcel, 5, paramParcelableEventList.e, false);
    j.a(paramParcel, 6, paramParcelableEventList.f, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.d
 * JD-Core Version:    0.6.0
 */