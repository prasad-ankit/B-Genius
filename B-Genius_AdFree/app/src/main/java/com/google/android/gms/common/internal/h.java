package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class h
  implements Parcelable.Creator
{
  static void a(GetServiceRequest paramGetServiceRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGetServiceRequest.a);
    j.a(paramParcel, 2, paramGetServiceRequest.b);
    j.a(paramParcel, 3, paramGetServiceRequest.c);
    j.a(paramParcel, 4, paramGetServiceRequest.d, false);
    j.a(paramParcel, 5, paramGetServiceRequest.e, false);
    j.a(paramParcel, 6, paramGetServiceRequest.f, paramInt, false);
    j.a(paramParcel, 7, paramGetServiceRequest.g, false);
    j.a(paramParcel, 8, paramGetServiceRequest.h, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.h
 * JD-Core Version:    0.6.0
 */