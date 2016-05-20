package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(FastJsonResponse.Field paramField, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramField.a());
    j.a(paramParcel, 2, paramField.b());
    j.a(paramParcel, 3, paramField.c());
    j.a(paramParcel, 4, paramField.d());
    j.a(paramParcel, 5, paramField.e());
    j.a(paramParcel, 6, paramField.f(), false);
    j.a(paramParcel, 7, paramField.g());
    j.a(paramParcel, 8, paramField.i(), false);
    j.a(paramParcel, 9, paramField.k(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.b
 * JD-Core Version:    0.6.0
 */