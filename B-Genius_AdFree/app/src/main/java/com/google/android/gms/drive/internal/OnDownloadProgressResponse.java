package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR;
  final int a;
  final long b;
  final long c;
  final int d;
  final List e;

  static
  {
    Collections.emptyList();
    CREATOR = new z();
  }

  OnDownloadProgressResponse(int paramInt1, long paramLong1, long paramLong2, int paramInt2, List paramList)
  {
    this.a = paramInt1;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramInt2;
    this.e = paramList;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.OnDownloadProgressResponse
 * JD-Core Version:    0.6.0
 */