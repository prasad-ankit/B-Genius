package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ai
  implements Parcelable.Creator
{
  static void a(ControlProgressRequest paramControlProgressRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramControlProgressRequest.a);
    j.a(paramParcel, 2, paramControlProgressRequest.b);
    j.a(paramParcel, 3, paramControlProgressRequest.c);
    j.a(paramParcel, 4, paramControlProgressRequest.d, paramInt, false);
    j.a(paramParcel, 5, paramControlProgressRequest.e, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ai
 * JD-Core Version:    0.6.0
 */