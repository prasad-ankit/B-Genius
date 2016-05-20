package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(VersionInfoParcel paramVersionInfoParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramVersionInfoParcel.a);
    j.a(paramParcel, 2, paramVersionInfoParcel.b, false);
    j.a(paramParcel, 3, paramVersionInfoParcel.c);
    j.a(paramParcel, 4, paramVersionInfoParcel.d);
    j.a(paramParcel, 5, paramVersionInfoParcel.e);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.util.client.b
 * JD-Core Version:    0.6.0
 */