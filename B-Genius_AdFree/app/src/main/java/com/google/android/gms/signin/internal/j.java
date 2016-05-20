package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class j
  implements Parcelable.Creator
{
  static void a(RecordConsentRequest paramRecordConsentRequest, Parcel paramParcel, int paramInt)
  {
    int i = android.support.v4.app.j.b(paramParcel);
    android.support.v4.app.j.a(paramParcel, 1, paramRecordConsentRequest.a);
    android.support.v4.app.j.a(paramParcel, 2, paramRecordConsentRequest.a(), paramInt, false);
    android.support.v4.app.j.a(paramParcel, 3, paramRecordConsentRequest.b(), paramInt, false);
    android.support.v4.app.j.a(paramParcel, 4, paramRecordConsentRequest.c(), false);
    android.support.v4.app.j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.signin.internal.j
 * JD-Core Version:    0.6.0
 */