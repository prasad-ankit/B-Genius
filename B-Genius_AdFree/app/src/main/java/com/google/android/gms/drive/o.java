package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class o
  implements Parcelable.Creator
{
  static void a(Permission paramPermission, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPermission.a);
    j.a(paramParcel, 2, paramPermission.a(), false);
    j.a(paramParcel, 3, paramPermission.b());
    j.a(paramParcel, 4, paramPermission.c(), false);
    j.a(paramParcel, 5, paramPermission.d(), false);
    j.a(paramParcel, 6, paramPermission.e());
    j.a(paramParcel, 7, paramPermission.f());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.o
 * JD-Core Version:    0.6.0
 */