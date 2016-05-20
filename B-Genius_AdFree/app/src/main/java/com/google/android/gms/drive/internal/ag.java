package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ag
  implements Parcelable.Creator
{
  static void a(CloseContentsAndUpdateMetadataRequest paramCloseContentsAndUpdateMetadataRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCloseContentsAndUpdateMetadataRequest.a);
    j.a(paramParcel, 2, paramCloseContentsAndUpdateMetadataRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramCloseContentsAndUpdateMetadataRequest.c, paramInt, false);
    j.a(paramParcel, 4, paramCloseContentsAndUpdateMetadataRequest.d, paramInt, false);
    j.a(paramParcel, 5, paramCloseContentsAndUpdateMetadataRequest.e);
    j.a(paramParcel, 6, paramCloseContentsAndUpdateMetadataRequest.f, false);
    j.a(paramParcel, 7, paramCloseContentsAndUpdateMetadataRequest.g);
    j.a(paramParcel, 8, paramCloseContentsAndUpdateMetadataRequest.h);
    j.a(paramParcel, 9, paramCloseContentsAndUpdateMetadataRequest.i);
    j.a(paramParcel, 10, paramCloseContentsAndUpdateMetadataRequest.j);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ag
 * JD-Core Version:    0.6.0
 */