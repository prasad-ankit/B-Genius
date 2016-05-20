package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class e
  implements Parcelable.Creator
{
  static void a(GetChangesRequest paramGetChangesRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGetChangesRequest.a);
    j.a(paramParcel, 2, paramGetChangesRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramGetChangesRequest.c);
    j.b(paramParcel, 4, paramGetChangesRequest.d, false);
    j.a(paramParcel, 5, paramGetChangesRequest.e);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.e
 * JD-Core Version:    0.6.0
 */