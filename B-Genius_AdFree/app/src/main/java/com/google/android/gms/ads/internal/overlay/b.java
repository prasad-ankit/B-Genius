package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class b
  implements Parcelable.Creator
{
  static void a(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdLauncherIntentInfoParcel.a);
    j.a(paramParcel, 2, paramAdLauncherIntentInfoParcel.b, false);
    j.a(paramParcel, 3, paramAdLauncherIntentInfoParcel.c, false);
    j.a(paramParcel, 4, paramAdLauncherIntentInfoParcel.d, false);
    j.a(paramParcel, 5, paramAdLauncherIntentInfoParcel.e, false);
    j.a(paramParcel, 6, paramAdLauncherIntentInfoParcel.f, false);
    j.a(paramParcel, 7, paramAdLauncherIntentInfoParcel.g, false);
    j.a(paramParcel, 8, paramAdLauncherIntentInfoParcel.h, false);
    j.a(paramParcel, 9, paramAdLauncherIntentInfoParcel.i, paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.b
 * JD-Core Version:    0.6.0
 */