package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class h
  implements Parcelable.Creator
{
  static void a(ChangeSequenceNumber paramChangeSequenceNumber, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramChangeSequenceNumber.a);
    j.a(paramParcel, 2, paramChangeSequenceNumber.b);
    j.a(paramParcel, 3, paramChangeSequenceNumber.c);
    j.a(paramParcel, 4, paramChangeSequenceNumber.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.h
 * JD-Core Version:    0.6.0
 */