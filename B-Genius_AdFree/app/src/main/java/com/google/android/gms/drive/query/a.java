package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1000, paramQuery.h);
    j.a(paramParcel, 1, paramQuery.a, paramInt, false);
    j.a(paramParcel, 3, paramQuery.b, false);
    j.a(paramParcel, 4, paramQuery.c, paramInt, false);
    j.a(paramParcel, 5, paramQuery.d, false);
    j.a(paramParcel, 6, paramQuery.e);
    j.b(paramParcel, 7, paramQuery.f, false);
    j.a(paramParcel, 8, paramQuery.g);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.a
 * JD-Core Version:    0.6.0
 */