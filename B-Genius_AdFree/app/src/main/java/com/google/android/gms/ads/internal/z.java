package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class z
  implements Parcelable.Creator
{
  static void a(InterstitialAdParameterParcel paramInterstitialAdParameterParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramInterstitialAdParameterParcel.a);
    j.a(paramParcel, 2, paramInterstitialAdParameterParcel.b);
    j.a(paramParcel, 3, paramInterstitialAdParameterParcel.c);
    j.a(paramParcel, 4, paramInterstitialAdParameterParcel.d, false);
    j.a(paramParcel, 5, paramInterstitialAdParameterParcel.e);
    j.a(paramParcel, 6, paramInterstitialAdParameterParcel.f);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.z
 * JD-Core Version:    0.6.0
 */