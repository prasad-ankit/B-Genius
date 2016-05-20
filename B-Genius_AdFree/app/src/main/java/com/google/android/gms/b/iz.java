package com.google.android.gms.b;

import android.content.Context;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

public final class iz
{
  public static is a(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, y paramy, VersionInfoParcel paramVersionInfoParcel, aR paramaR, k paramk)
  {
    iA localiA = new iA(iB.a(paramContext, paramAdSizeParcel, paramBoolean1, paramBoolean2, paramy, paramVersionInfoParcel, paramaR, paramk));
    localiA.setWebViewClient(P.g().a(localiA, paramBoolean2));
    localiA.setWebChromeClient(P.g().c(localiA));
    return localiA;
  }

  public final is a(Context paramContext, AdSizeParcel paramAdSizeParcel, boolean paramBoolean1, boolean paramBoolean2, y paramy, VersionInfoParcel paramVersionInfoParcel)
  {
    return a(paramContext, paramAdSizeParcel, false, false, paramy, paramVersionInfoParcel, null, null);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.iz
 * JD-Core Version:    0.6.0
 */