package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class i
  implements Parcelable.Creator
{
  static void a(Contents paramContents, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramContents.a);
    j.a(paramParcel, 2, paramContents.b, paramInt, false);
    j.a(paramParcel, 3, paramContents.c);
    j.a(paramParcel, 4, paramContents.d);
    j.a(paramParcel, 5, paramContents.e, paramInt, false);
    j.a(paramParcel, 7, paramContents.f);
    j.a(paramParcel, 8, paramContents.g, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.i
 * JD-Core Version:    0.6.0
 */