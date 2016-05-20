package com.google.android.gms.games.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(GameRequestEntity paramGameRequestEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGameRequestEntity.e(), paramInt, false);
    j.a(paramParcel, 1000, paramGameRequestEntity.a());
    j.a(paramParcel, 2, paramGameRequestEntity.f(), paramInt, false);
    j.a(paramParcel, 3, paramGameRequestEntity.g(), false);
    j.a(paramParcel, 4, paramGameRequestEntity.d(), false);
    j.b(paramParcel, 5, paramGameRequestEntity.k(), false);
    j.a(paramParcel, 7, paramGameRequestEntity.h());
    j.a(paramParcel, 9, paramGameRequestEntity.i());
    j.a(paramParcel, 10, paramGameRequestEntity.j());
    j.a(paramParcel, 11, paramGameRequestEntity.l(), false);
    j.a(paramParcel, 12, paramGameRequestEntity.b());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.a
 * JD-Core Version:    0.6.0
 */