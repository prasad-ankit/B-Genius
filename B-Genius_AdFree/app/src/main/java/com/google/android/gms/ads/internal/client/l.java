package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class l
  implements Parcelable.Creator
{
  static void a(SearchAdRequestParcel paramSearchAdRequestParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramSearchAdRequestParcel.a);
    j.a(paramParcel, 2, paramSearchAdRequestParcel.b);
    j.a(paramParcel, 3, paramSearchAdRequestParcel.c);
    j.a(paramParcel, 4, paramSearchAdRequestParcel.d);
    j.a(paramParcel, 5, paramSearchAdRequestParcel.e);
    j.a(paramParcel, 6, paramSearchAdRequestParcel.f);
    j.a(paramParcel, 7, paramSearchAdRequestParcel.g);
    j.a(paramParcel, 8, paramSearchAdRequestParcel.h);
    j.a(paramParcel, 9, paramSearchAdRequestParcel.i);
    j.a(paramParcel, 10, paramSearchAdRequestParcel.j, false);
    j.a(paramParcel, 11, paramSearchAdRequestParcel.k);
    j.a(paramParcel, 12, paramSearchAdRequestParcel.l, false);
    j.a(paramParcel, 13, paramSearchAdRequestParcel.m);
    j.a(paramParcel, 14, paramSearchAdRequestParcel.n);
    j.a(paramParcel, 15, paramSearchAdRequestParcel.o, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.l
 * JD-Core Version:    0.6.0
 */