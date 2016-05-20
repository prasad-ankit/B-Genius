package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.a.b;
import com.google.android.gms.a.d;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.bG;
import com.google.android.gms.b.cc;
import com.google.android.gms.b.is;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class AdOverlayInfoParcel
  implements SafeParcelable
{
  public static final s CREATOR = new s();
  public final int a;
  public final AdLauncherIntentInfoParcel b;
  public final a c;
  public final t d;
  public final is e;
  public final bG f;
  public final String g;
  public final boolean h;
  public final String i;
  public final C j;
  public final int k;
  public final int l;
  public final String m;
  public final VersionInfoParcel n;
  public final cc o;
  public final String p;
  public final InterstitialAdParameterParcel q;

  AdOverlayInfoParcel(int paramInt1, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3, IBinder paramIBinder4, String paramString1, boolean paramBoolean, String paramString2, IBinder paramIBinder5, int paramInt2, int paramInt3, String paramString3, VersionInfoParcel paramVersionInfoParcel, IBinder paramIBinder6, String paramString4, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.a = paramInt1;
    this.b = paramAdLauncherIntentInfoParcel;
    this.c = ((a)d.a(b.a(paramIBinder1)));
    this.d = ((t)d.a(b.a(paramIBinder2)));
    this.e = ((is)d.a(b.a(paramIBinder3)));
    this.f = ((bG)d.a(b.a(paramIBinder4)));
    this.g = paramString1;
    this.h = paramBoolean;
    this.i = paramString2;
    this.j = ((C)d.a(b.a(paramIBinder5)));
    this.k = paramInt2;
    this.l = paramInt3;
    this.m = paramString3;
    this.n = paramVersionInfoParcel;
    this.o = ((cc)d.a(b.a(paramIBinder6)));
    this.p = paramString4;
    this.q = paramInterstitialAdParameterParcel;
  }

  public AdOverlayInfoParcel(a parama, t paramt, C paramC, is paramis, int paramInt, VersionInfoParcel paramVersionInfoParcel, String paramString, InterstitialAdParameterParcel paramInterstitialAdParameterParcel)
  {
    this.a = 4;
    this.b = null;
    this.c = parama;
    this.d = paramt;
    this.e = paramis;
    this.f = null;
    this.g = null;
    this.h = false;
    this.i = null;
    this.j = paramC;
    this.k = paramInt;
    this.l = 1;
    this.m = null;
    this.n = paramVersionInfoParcel;
    this.o = null;
    this.p = paramString;
    this.q = paramInterstitialAdParameterParcel;
  }

  public AdOverlayInfoParcel(a parama, t paramt, C paramC, is paramis, boolean paramBoolean, int paramInt, VersionInfoParcel paramVersionInfoParcel)
  {
    this.a = 4;
    this.b = null;
    this.c = parama;
    this.d = paramt;
    this.e = paramis;
    this.f = null;
    this.g = null;
    this.h = paramBoolean;
    this.i = null;
    this.j = paramC;
    this.k = paramInt;
    this.l = 2;
    this.m = null;
    this.n = paramVersionInfoParcel;
    this.o = null;
    this.p = null;
    this.q = null;
  }

  public AdOverlayInfoParcel(a parama, t paramt, bG parambG, C paramC, is paramis, boolean paramBoolean, int paramInt, String paramString, VersionInfoParcel paramVersionInfoParcel, cc paramcc)
  {
    this.a = 4;
    this.b = null;
    this.c = parama;
    this.d = paramt;
    this.e = paramis;
    this.f = parambG;
    this.g = null;
    this.h = paramBoolean;
    this.i = null;
    this.j = paramC;
    this.k = paramInt;
    this.l = 3;
    this.m = paramString;
    this.n = paramVersionInfoParcel;
    this.o = paramcc;
    this.p = null;
    this.q = null;
  }

  public AdOverlayInfoParcel(a parama, t paramt, bG parambG, C paramC, is paramis, boolean paramBoolean, int paramInt, String paramString1, String paramString2, VersionInfoParcel paramVersionInfoParcel, cc paramcc)
  {
    this.a = 4;
    this.b = null;
    this.c = parama;
    this.d = paramt;
    this.e = paramis;
    this.f = parambG;
    this.g = paramString2;
    this.h = paramBoolean;
    this.i = paramString1;
    this.j = paramC;
    this.k = paramInt;
    this.l = 3;
    this.m = null;
    this.n = paramVersionInfoParcel;
    this.o = paramcc;
    this.p = null;
    this.q = null;
  }

  public AdOverlayInfoParcel(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, a parama, t paramt, C paramC, VersionInfoParcel paramVersionInfoParcel)
  {
    this.a = 4;
    this.b = paramAdLauncherIntentInfoParcel;
    this.c = parama;
    this.d = paramt;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = false;
    this.i = null;
    this.j = paramC;
    this.k = -1;
    this.l = 4;
    this.m = null;
    this.n = paramVersionInfoParcel;
    this.o = null;
    this.p = null;
    this.q = null;
  }

  public static AdOverlayInfoParcel a(Intent paramIntent)
  {
    try
    {
      Bundle localBundle = paramIntent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      localBundle.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
      AdOverlayInfoParcel localAdOverlayInfoParcel = (AdOverlayInfoParcel)localBundle.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
      return localAdOverlayInfoParcel;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static void a(Intent paramIntent, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", paramAdOverlayInfoParcel);
    paramIntent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", localBundle);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 * JD-Core Version:    0.6.0
 */