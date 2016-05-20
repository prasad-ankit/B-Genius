package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(AddEventListenerRequest paramAddEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAddEventListenerRequest.a);
    j.a(paramParcel, 2, paramAddEventListenerRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramAddEventListenerRequest.c);
    j.a(paramParcel, 4, paramAddEventListenerRequest.d, paramInt, false);
    j.a(paramParcel, 5, paramAddEventListenerRequest.e, paramInt, false);
    j.a(paramParcel, 6, paramAddEventListenerRequest.f, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.a
 * JD-Core Version:    0.6.0
 */