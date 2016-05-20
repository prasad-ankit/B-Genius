package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class z
  implements Parcelable.Creator
{
  static void a(OnDownloadProgressResponse paramOnDownloadProgressResponse, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramOnDownloadProgressResponse.a);
    j.a(paramParcel, 2, paramOnDownloadProgressResponse.b);
    j.a(paramParcel, 3, paramOnDownloadProgressResponse.c);
    j.a(paramParcel, 4, paramOnDownloadProgressResponse.d);
    j.b(paramParcel, 5, paramOnDownloadProgressResponse.e, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.z
 * JD-Core Version:    0.6.0
 */