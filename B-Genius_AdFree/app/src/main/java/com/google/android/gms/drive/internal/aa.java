package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class aa
  implements Parcelable.Creator
{
  static void a(AuthorizeAccessRequest paramAuthorizeAccessRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAuthorizeAccessRequest.a);
    j.a(paramParcel, 2, paramAuthorizeAccessRequest.b);
    j.a(paramParcel, 3, paramAuthorizeAccessRequest.c, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aa
 * JD-Core Version:    0.6.0
 */