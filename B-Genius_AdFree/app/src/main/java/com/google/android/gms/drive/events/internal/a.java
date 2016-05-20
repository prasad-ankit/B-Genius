package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(TransferProgressData paramTransferProgressData, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramTransferProgressData.a);
    j.a(paramParcel, 2, paramTransferProgressData.b);
    j.a(paramParcel, 3, paramTransferProgressData.c, paramInt, false);
    j.a(paramParcel, 4, paramTransferProgressData.d);
    j.a(paramParcel, 5, paramTransferProgressData.e);
    j.a(paramParcel, 6, paramTransferProgressData.f);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.internal.a
 * JD-Core Version:    0.6.0
 */