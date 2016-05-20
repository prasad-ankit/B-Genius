package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class al
  implements Parcelable.Creator
{
  static void a(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCreateFileRequest.a);
    j.a(paramParcel, 2, paramCreateFileRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramCreateFileRequest.c, paramInt, false);
    j.a(paramParcel, 4, paramCreateFileRequest.d, paramInt, false);
    j.a(paramParcel, 5, paramCreateFileRequest.e, false);
    j.a(paramParcel, 6, paramCreateFileRequest.f);
    j.a(paramParcel, 7, paramCreateFileRequest.g, false);
    j.a(paramParcel, 8, paramCreateFileRequest.h);
    j.a(paramParcel, 9, paramCreateFileRequest.i);
    j.a(paramParcel, 10, paramCreateFileRequest.j, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.al
 * JD-Core Version:    0.6.0
 */