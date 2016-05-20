package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class ak
  implements Parcelable.Creator
{
  static void a(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramCreateFileIntentSenderRequest.a);
    j.a(paramParcel, 2, paramCreateFileIntentSenderRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramCreateFileIntentSenderRequest.c);
    j.a(paramParcel, 4, paramCreateFileIntentSenderRequest.d, false);
    j.a(paramParcel, 5, paramCreateFileIntentSenderRequest.e, paramInt, false);
    j.a(paramParcel, 6, paramCreateFileIntentSenderRequest.f, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ak
 * JD-Core Version:    0.6.0
 */