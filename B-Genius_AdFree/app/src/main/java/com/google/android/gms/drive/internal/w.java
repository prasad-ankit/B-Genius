package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class w
  implements Parcelable.Creator
{
  static void a(OnChangesResponse paramOnChangesResponse, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramOnChangesResponse.a);
    j.a(paramParcel, 2, paramOnChangesResponse.b, paramInt, false);
    j.b(paramParcel, 3, paramOnChangesResponse.c, false);
    j.a(paramParcel, 4, paramOnChangesResponse.d, paramInt, false);
    j.a(paramParcel, 5, paramOnChangesResponse.e);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.w
 * JD-Core Version:    0.6.0
 */