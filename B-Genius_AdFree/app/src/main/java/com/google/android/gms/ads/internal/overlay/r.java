package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.j;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.hu;

public final class r
{
  public static void a(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((paramAdOverlayInfoParcel.l == 4) && (paramAdOverlayInfoParcel.d == null))
    {
      if (paramAdOverlayInfoParcel.c != null)
        paramAdOverlayInfoParcel.c.e();
      P.b().a(paramContext, paramAdOverlayInfoParcel.b, paramAdOverlayInfoParcel.j);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramAdOverlayInfoParcel.n.e);
    localIntent.putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.a(localIntent, paramAdOverlayInfoParcel);
    if (!j.h())
      localIntent.addFlags(524288);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    P.e();
    hu.a(paramContext, localIntent);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.r
 * JD-Core Version:    0.6.0
 */