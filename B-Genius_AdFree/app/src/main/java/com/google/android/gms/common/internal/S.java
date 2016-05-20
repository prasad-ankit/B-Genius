package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class S
  implements Parcelable.Creator
{
  static void a(ResolveAccountResponse paramResolveAccountResponse, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramResolveAccountResponse.a);
    j.a(paramParcel, 2, paramResolveAccountResponse.b, false);
    j.a(paramParcel, 3, paramResolveAccountResponse.b(), paramInt, false);
    j.a(paramParcel, 4, paramResolveAccountResponse.c());
    j.a(paramParcel, 5, paramResolveAccountResponse.d());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.S
 * JD-Core Version:    0.6.0
 */