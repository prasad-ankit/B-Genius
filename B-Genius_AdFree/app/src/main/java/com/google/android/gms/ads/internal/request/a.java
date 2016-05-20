package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.hG;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.ij;
import java.util.List;

public class a
{
  public final String A;
  public final float B;
  public final int C;
  public final int D;
  public final Bundle a;
  public final AdRequestParcel b;
  public final AdSizeParcel c;
  public final String d;
  public final ApplicationInfo e;
  public final PackageInfo f;
  public final String g;
  public final String h;
  public final Bundle i;
  public final VersionInfoParcel j;
  public final int k;
  public final List l;
  public final List m;
  public final Bundle n;
  public final boolean o;
  public final Messenger p;
  public final int q;
  public final int r;
  public final float s;
  public final String t;
  public final long u;
  public final String v;
  public final List w;
  public final String x;
  public final NativeAdOptionsParcel y;
  public final CapabilityParcel z;

  public a(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, List paramList1, List paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt1, int paramInt2, float paramFloat1, String paramString4, long paramLong, String paramString5, List paramList3, String paramString6, NativeAdOptionsParcel paramNativeAdOptionsParcel, CapabilityParcel paramCapabilityParcel, String paramString7, float paramFloat2, int paramInt3, int paramInt4)
  {
    this.a = paramBundle1;
    this.b = paramAdRequestParcel;
    this.c = paramAdSizeParcel;
    this.d = paramString1;
    this.e = paramApplicationInfo;
    this.f = paramPackageInfo;
    this.g = paramString2;
    this.h = paramString3;
    this.j = paramVersionInfoParcel;
    this.i = paramBundle2;
    this.o = paramBoolean;
    this.p = paramMessenger;
    this.q = paramInt1;
    this.r = paramInt2;
    this.s = paramFloat1;
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      this.k = 3;
      this.l = paramList1;
      this.m = paramList2;
      this.n = paramBundle3;
      this.t = paramString4;
      this.u = paramLong;
      this.v = paramString5;
      this.w = paramList3;
      this.x = paramString6;
      this.y = paramNativeAdOptionsParcel;
      this.z = paramCapabilityParcel;
      this.A = paramString7;
      this.B = paramFloat2;
      this.C = paramInt3;
      this.D = paramInt4;
      return;
    }
    if (paramAdSizeParcel.k);
    for (this.k = 4; ; this.k = 0)
    {
      this.l = null;
      this.m = null;
      break;
    }
  }

  public static hG a(Context paramContext, VersionInfoParcel paramVersionInfoParcel, ij paramij, j paramj)
  {
    if (new i(paramContext).a(paramVersionInfoParcel))
    {
      hc.a("Fetching ad response from local ad request service.");
      o localo = new o(paramContext, paramij, paramj);
      localo.c();
      return localo;
    }
    hc.a("Fetching ad response from remote ad request service.");
    x.a();
    if (!com.google.android.gms.ads.internal.util.client.a.b(paramContext))
    {
      hc.d("Failed to connect to remote ad request service.");
      return null;
    }
    return new p(paramContext, paramVersionInfoParcel, paramij, paramj);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.a
 * JD-Core Version:    0.6.0
 */