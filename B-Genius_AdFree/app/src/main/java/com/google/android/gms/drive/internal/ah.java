package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ah
  implements Parcelable.Creator
{
  static void a(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCloseContentsRequest.a);
    j.a(paramParcel, 2, paramCloseContentsRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramCloseContentsRequest.c, false);
    j.a(paramParcel, 4, paramCloseContentsRequest.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ah
 * JD-Core Version:    0.6.0
 */