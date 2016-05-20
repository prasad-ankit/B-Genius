package com.google.android.gms.ads.internal.overlay;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import com.google.android.gms.a.a;
import com.google.android.gms.a.d;

public final class s
  implements Parcelable.Creator
{
  static void a(AdOverlayInfoParcel paramAdOverlayInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdOverlayInfoParcel.a);
    j.a(paramParcel, 2, paramAdOverlayInfoParcel.b, paramInt, false);
    j.a(paramParcel, 3, d.a(paramAdOverlayInfoParcel.c).asBinder(), false);
    j.a(paramParcel, 4, d.a(paramAdOverlayInfoParcel.d).asBinder(), false);
    j.a(paramParcel, 5, d.a(paramAdOverlayInfoParcel.e).asBinder(), false);
    j.a(paramParcel, 6, d.a(paramAdOverlayInfoParcel.f).asBinder(), false);
    j.a(paramParcel, 7, paramAdOverlayInfoParcel.g, false);
    j.a(paramParcel, 8, paramAdOverlayInfoParcel.h);
    j.a(paramParcel, 9, paramAdOverlayInfoParcel.i, false);
    j.a(paramParcel, 10, d.a(paramAdOverlayInfoParcel.j).asBinder(), false);
    j.a(paramParcel, 11, paramAdOverlayInfoParcel.k);
    j.a(paramParcel, 12, paramAdOverlayInfoParcel.l);
    j.a(paramParcel, 13, paramAdOverlayInfoParcel.m, false);
    j.a(paramParcel, 14, paramAdOverlayInfoParcel.n, paramInt, false);
    j.a(paramParcel, 15, d.a(paramAdOverlayInfoParcel.o).asBinder(), false);
    j.a(paramParcel, 17, paramAdOverlayInfoParcel.q, paramInt, false);
    j.a(paramParcel, 16, paramAdOverlayInfoParcel.p, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.s
 * JD-Core Version:    0.6.0
 */