package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ad
  implements Parcelable.Creator
{
  static void a(CancelPendingActionsRequest paramCancelPendingActionsRequest, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCancelPendingActionsRequest.a);
    j.a(paramParcel, 2, paramCancelPendingActionsRequest.b, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ad
 * JD-Core Version:    0.6.0
 */