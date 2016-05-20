package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class u
  implements Parcelable.Creator
{
  static void a(CapabilityParcel paramCapabilityParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCapabilityParcel.a);
    j.a(paramParcel, 2, paramCapabilityParcel.b);
    j.a(paramParcel, 3, paramCapabilityParcel.c);
    j.a(paramParcel, 4, paramCapabilityParcel.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.u
 * JD-Core Version:    0.6.0
 */