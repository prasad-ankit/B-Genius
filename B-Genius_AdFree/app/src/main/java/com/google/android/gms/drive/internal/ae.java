package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ae
  implements Parcelable.Creator
{
  static void a(ChangeResourceParentsRequest paramChangeResourceParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramChangeResourceParentsRequest.a);
    j.a(paramParcel, 2, paramChangeResourceParentsRequest.b, paramInt, false);
    j.b(paramParcel, 3, paramChangeResourceParentsRequest.c, false);
    j.b(paramParcel, 4, paramChangeResourceParentsRequest.d, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ae
 * JD-Core Version:    0.6.0
 */