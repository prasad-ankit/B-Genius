package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class d
  implements Parcelable.Creator
{
  static void a(AuthAccountRequest paramAuthAccountRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAuthAccountRequest.a);
    j.a(paramParcel, 2, paramAuthAccountRequest.b, false);
    j.a(paramParcel, 3, paramAuthAccountRequest.c, paramInt, false);
    j.a(paramParcel, 4, paramAuthAccountRequest.d, false);
    j.a(paramParcel, 5, paramAuthAccountRequest.e, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.d
 * JD-Core Version:    0.6.0
 */