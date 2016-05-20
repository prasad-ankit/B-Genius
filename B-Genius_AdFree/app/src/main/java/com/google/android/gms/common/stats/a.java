package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(ConnectionEvent paramConnectionEvent, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramConnectionEvent.a);
    j.a(paramParcel, 2, paramConnectionEvent.a());
    j.a(paramParcel, 4, paramConnectionEvent.c(), false);
    j.a(paramParcel, 5, paramConnectionEvent.d(), false);
    j.a(paramParcel, 6, paramConnectionEvent.e(), false);
    j.a(paramParcel, 7, paramConnectionEvent.f(), false);
    j.a(paramParcel, 8, paramConnectionEvent.g(), false);
    j.a(paramParcel, 10, paramConnectionEvent.k());
    j.a(paramParcel, 11, paramConnectionEvent.j());
    j.a(paramParcel, 12, paramConnectionEvent.b());
    j.a(paramParcel, 13, paramConnectionEvent.h(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.a
 * JD-Core Version:    0.6.0
 */