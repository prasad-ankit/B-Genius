package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(ComparisonFilter paramComparisonFilter, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1000, paramComparisonFilter.c);
    j.a(paramParcel, 1, paramComparisonFilter.a, paramInt, false);
    j.a(paramParcel, 2, paramComparisonFilter.b, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.a
 * JD-Core Version:    0.6.0
 */