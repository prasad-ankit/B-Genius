package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramBeginCompoundOperationRequest.a);
    j.a(paramParcel, 2, paramBeginCompoundOperationRequest.b);
    j.a(paramParcel, 3, paramBeginCompoundOperationRequest.c, false);
    j.a(paramParcel, 4, paramBeginCompoundOperationRequest.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.a
 * JD-Core Version:    0.6.0
 */