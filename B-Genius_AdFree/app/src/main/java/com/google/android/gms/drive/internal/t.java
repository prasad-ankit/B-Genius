package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class t
  implements Parcelable.Creator
{
  static void a(LoadRealtimeRequest paramLoadRealtimeRequest, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramLoadRealtimeRequest.a);
    j.a(paramParcel, 2, paramLoadRealtimeRequest.b, paramInt, false);
    j.a(paramParcel, 3, paramLoadRealtimeRequest.c);
    j.a(paramParcel, 4, paramLoadRealtimeRequest.d, false);
    j.a(paramParcel, 5, paramLoadRealtimeRequest.e);
    j.a(paramParcel, 6, paramLoadRealtimeRequest.f, paramInt, false);
    j.a(paramParcel, 7, paramLoadRealtimeRequest.g, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.t
 * JD-Core Version:    0.6.0
 */