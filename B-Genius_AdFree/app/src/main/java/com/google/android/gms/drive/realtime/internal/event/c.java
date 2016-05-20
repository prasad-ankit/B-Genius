package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class c
  implements Parcelable.Creator
{
  static void a(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramParcelableEvent.a);
    j.a(paramParcel, 2, paramParcelableEvent.b, false);
    j.a(paramParcel, 3, paramParcelableEvent.c, false);
    j.a(paramParcel, 4, paramParcelableEvent.d, false);
    j.a(paramParcel, 5, paramParcelableEvent.e);
    j.a(paramParcel, 6, paramParcelableEvent.h, false);
    j.a(paramParcel, 7, paramParcelableEvent.i, false);
    j.a(paramParcel, 8, paramParcelableEvent.j, paramInt, false);
    j.a(paramParcel, 9, paramParcelableEvent.k, paramInt, false);
    j.a(paramParcel, 10, paramParcelableEvent.l, paramInt, false);
    j.a(paramParcel, 11, paramParcelableEvent.m, paramInt, false);
    j.a(paramParcel, 12, paramParcelableEvent.n, paramInt, false);
    j.a(paramParcel, 13, paramParcelableEvent.o, paramInt, false);
    j.a(paramParcel, 14, paramParcelableEvent.p, paramInt, false);
    j.a(paramParcel, 15, paramParcelableEvent.q, paramInt, false);
    j.a(paramParcel, 17, paramParcelableEvent.g);
    j.a(paramParcel, 16, paramParcelableEvent.f);
    j.a(paramParcel, 18, paramParcelableEvent.r, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.event.c
 * JD-Core Version:    0.6.0
 */