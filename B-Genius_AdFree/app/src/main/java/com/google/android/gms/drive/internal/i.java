package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class i
  implements Parcelable.Creator
{
  static void a(GetPermissionsResponse paramGetPermissionsResponse, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGetPermissionsResponse.a);
    j.b(paramParcel, 2, paramGetPermissionsResponse.b, false);
    j.a(paramParcel, 3, paramGetPermissionsResponse.c);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.i
 * JD-Core Version:    0.6.0
 */