package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public final class AdRequestInfoParcel
  implements SafeParcelable
{
  public static final r CREATOR = new r();
  public final List A;
  public final long B;
  public final CapabilityParcel C;
  public final String D;
  public final float E;
  public final int F;
  public final int G;
  public final int a;
  public final Bundle b;
  public final AdRequestParcel c;
  public final AdSizeParcel d;
  public final String e;
  public final ApplicationInfo f;
  public final PackageInfo g;
  public final String h;
  public final String i;
  public final String j;
  public final VersionInfoParcel k;
  public final Bundle l;
  public final int m;
  public final List n;
  public final Bundle o;
  public final boolean p;
  public final Messenger q;
  public final int r;
  public final int s;
  public final float t;
  public final String u;
  public final long v;
  public final String w;
  public final List x;
  public final String y;
  public final NativeAdOptionsParcel z;

  AdRequestInfoParcel(int paramInt1, Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt2, List paramList1, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt3, int paramInt4, float paramFloat1, String paramString5, long paramLong1, String paramString6, List paramList2, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, List paramList3, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8, float paramFloat2, int paramInt5, int paramInt6)
  {
    this.a = paramInt1;
    this.b = paramBundle1;
    this.c = paramAdRequestParcel;
    this.d = paramAdSizeParcel;
    this.e = paramString1;
    this.f = paramApplicationInfo;
    this.g = paramPackageInfo;
    this.h = paramString2;
    this.i = paramString3;
    this.j = paramString4;
    this.k = paramVersionInfoParcel;
    this.l = paramBundle2;
    this.m = paramInt2;
    this.n = paramList1;
    List localList1;
    if (paramList3 == null)
    {
      localList1 = Collections.emptyList();
      this.A = localList1;
      this.o = paramBundle3;
      this.p = paramBoolean;
      this.q = paramMessenger;
      this.r = paramInt3;
      this.s = paramInt4;
      this.t = paramFloat1;
      this.u = paramString5;
      this.v = paramLong1;
      this.w = paramString6;
      if (paramList2 != null)
        break label230;
    }
    label230: for (List localList2 = Collections.emptyList(); ; localList2 = Collections.unmodifiableList(paramList2))
    {
      this.x = localList2;
      this.y = paramString7;
      this.z = paramNativeAdOptionsParcel;
      this.B = paramLong2;
      this.C = paramCapabilityParcel;
      this.D = paramString8;
      this.E = paramFloat2;
      this.F = paramInt5;
      this.G = paramInt6;
      return;
      localList1 = Collections.unmodifiableList(paramList3);
      break;
    }
  }

  private AdRequestInfoParcel(Bundle paramBundle1, AdRequestParcel paramAdRequestParcel, AdSizeParcel paramAdSizeParcel, String paramString1, ApplicationInfo paramApplicationInfo, PackageInfo paramPackageInfo, String paramString2, String paramString3, String paramString4, VersionInfoParcel paramVersionInfoParcel, Bundle paramBundle2, int paramInt1, List paramList1, List paramList2, Bundle paramBundle3, boolean paramBoolean, Messenger paramMessenger, int paramInt2, int paramInt3, float paramFloat1, String paramString5, long paramLong1, String paramString6, List paramList3, String paramString7, NativeAdOptionsParcel paramNativeAdOptionsParcel, long paramLong2, CapabilityParcel paramCapabilityParcel, String paramString8, float paramFloat2, int paramInt4, int paramInt5)
  {
    this(15, paramBundle1, paramAdRequestParcel, paramAdSizeParcel, paramString1, paramApplicationInfo, paramPackageInfo, paramString2, paramString3, paramString4, paramVersionInfoParcel, paramBundle2, paramInt1, paramList1, paramBundle3, paramBoolean, paramMessenger, paramInt2, paramInt3, paramFloat1, paramString5, paramLong1, paramString6, paramList3, paramString7, paramNativeAdOptionsParcel, paramList2, paramLong2, paramCapabilityParcel, paramString8, paramFloat2, paramInt4, paramInt5);
  }

  public AdRequestInfoParcel(a parama, String paramString, long paramLong)
  {
    this(parama.a, parama.b, parama.c, parama.d, parama.e, parama.f, paramString, parama.g, parama.h, parama.j, parama.i, parama.k, parama.l, parama.m, parama.n, parama.o, parama.p, parama.q, parama.r, parama.s, parama.t, parama.u, parama.v, parama.w, parama.x, parama.y, paramLong, parama.z, parama.A, parama.B, parama.C, parama.D);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.AdRequestInfoParcel
 * JD-Core Version:    0.6.0
 */