package com.google.android.gms.ads.internal.purchase;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import com.google.android.gms.a.d;

public final class a
  implements Parcelable.Creator
{
  static void a(GInAppPurchaseManagerInfoParcel paramGInAppPurchaseManagerInfoParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramGInAppPurchaseManagerInfoParcel.a);
    j.a(paramParcel, 3, d.a(paramGInAppPurchaseManagerInfoParcel.b).asBinder(), false);
    j.a(paramParcel, 4, d.a(paramGInAppPurchaseManagerInfoParcel.c).asBinder(), false);
    j.a(paramParcel, 5, d.a(paramGInAppPurchaseManagerInfoParcel.d).asBinder(), false);
    j.a(paramParcel, 6, d.a(paramGInAppPurchaseManagerInfoParcel.e).asBinder(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.a
 * JD-Core Version:    0.6.0
 */