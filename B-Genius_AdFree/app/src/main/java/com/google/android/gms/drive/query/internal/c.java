package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class c
  implements Parcelable.Creator
{
  static void a(FieldWithSortOrder paramFieldWithSortOrder, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1000, paramFieldWithSortOrder.c);
    j.a(paramParcel, 1, paramFieldWithSortOrder.a, false);
    j.a(paramParcel, 2, paramFieldWithSortOrder.b);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.c
 * JD-Core Version:    0.6.0
 */