package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;

public final class r
  implements Parcelable.Creator
{
  public static AdRequestInfoParcel a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    Bundle localBundle1 = null;
    AdRequestParcel localAdRequestParcel = null;
    AdSizeParcel localAdSizeParcel = null;
    String str1 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList1 = null;
    Bundle localBundle3 = null;
    boolean bool = false;
    Messenger localMessenger = null;
    int m = 0;
    int n = 0;
    float f1 = 0.0F;
    String str5 = null;
    long l1 = 0L;
    String str6 = null;
    ArrayList localArrayList2 = null;
    String str7 = null;
    NativeAdOptionsParcel localNativeAdOptionsParcel = null;
    ArrayList localArrayList3 = null;
    long l2 = 0L;
    CapabilityParcel localCapabilityParcel = null;
    String str8 = null;
    float f2 = 0.0F;
    int i1 = 0;
    int i2 = 0;
    while (paramParcel.dataPosition() < i)
    {
      int i3 = paramParcel.readInt();
      switch (0xFFFF & i3)
      {
      case 22:
      case 23:
      case 24:
      default:
        j.b(paramParcel, i3);
        break;
      case 1:
        j = j.e(paramParcel, i3);
        break;
      case 2:
        localBundle1 = j.o(paramParcel, i3);
        break;
      case 3:
        localAdRequestParcel = (AdRequestParcel)j.a(paramParcel, i3, AdRequestParcel.CREATOR);
        break;
      case 4:
        localAdSizeParcel = (AdSizeParcel)j.a(paramParcel, i3, AdSizeParcel.CREATOR);
        break;
      case 5:
        str1 = j.m(paramParcel, i3);
        break;
      case 6:
        localApplicationInfo = (ApplicationInfo)j.a(paramParcel, i3, ApplicationInfo.CREATOR);
        break;
      case 7:
        localPackageInfo = (PackageInfo)j.a(paramParcel, i3, PackageInfo.CREATOR);
        break;
      case 8:
        str2 = j.m(paramParcel, i3);
        break;
      case 9:
        str3 = j.m(paramParcel, i3);
        break;
      case 10:
        str4 = j.m(paramParcel, i3);
        break;
      case 11:
        localVersionInfoParcel = (VersionInfoParcel)j.a(paramParcel, i3, VersionInfoParcel.CREATOR);
        break;
      case 12:
        localBundle2 = j.o(paramParcel, i3);
        break;
      case 13:
        k = j.e(paramParcel, i3);
        break;
      case 14:
        localArrayList1 = j.u(paramParcel, i3);
        break;
      case 15:
        localBundle3 = j.o(paramParcel, i3);
        break;
      case 17:
        localMessenger = (Messenger)j.a(paramParcel, i3, Messenger.CREATOR);
        break;
      case 16:
        bool = j.c(paramParcel, i3);
        break;
      case 19:
        n = j.e(paramParcel, i3);
        break;
      case 18:
        m = j.e(paramParcel, i3);
        break;
      case 21:
        str5 = j.m(paramParcel, i3);
        break;
      case 20:
        f1 = j.j(paramParcel, i3);
        break;
      case 25:
        l1 = j.g(paramParcel, i3);
        break;
      case 27:
        localArrayList2 = j.u(paramParcel, i3);
        break;
      case 26:
        str6 = j.m(paramParcel, i3);
        break;
      case 29:
        localNativeAdOptionsParcel = (NativeAdOptionsParcel)j.a(paramParcel, i3, NativeAdOptionsParcel.CREATOR);
        break;
      case 28:
        str7 = j.m(paramParcel, i3);
        break;
      case 31:
        l2 = j.g(paramParcel, i3);
        break;
      case 30:
        localArrayList3 = j.u(paramParcel, i3);
        break;
      case 34:
        f2 = j.j(paramParcel, i3);
        break;
      case 35:
        i1 = j.e(paramParcel, i3);
        break;
      case 32:
        localCapabilityParcel = (CapabilityParcel)j.a(paramParcel, i3, CapabilityParcel.CREATOR);
        break;
      case 33:
        str8 = j.m(paramParcel, i3);
        break;
      case 36:
        i2 = j.e(paramParcel, i3);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new AdRequestInfoParcel(j, localBundle1, localAdRequestParcel, localAdSizeParcel, str1, localApplicationInfo, localPackageInfo, str2, str3, str4, localVersionInfoParcel, localBundle2, k, localArrayList1, localBundle3, bool, localMessenger, m, n, f1, str5, l1, str6, localArrayList2, str7, localNativeAdOptionsParcel, localArrayList3, l2, localCapabilityParcel, str8, f2, i1, i2);
  }

  static void a(AdRequestInfoParcel paramAdRequestInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdRequestInfoParcel.a);
    j.a(paramParcel, 2, paramAdRequestInfoParcel.b, false);
    j.a(paramParcel, 3, paramAdRequestInfoParcel.c, paramInt, false);
    j.a(paramParcel, 4, paramAdRequestInfoParcel.d, paramInt, false);
    j.a(paramParcel, 5, paramAdRequestInfoParcel.e, false);
    j.a(paramParcel, 6, paramAdRequestInfoParcel.f, paramInt, false);
    j.a(paramParcel, 7, paramAdRequestInfoParcel.g, paramInt, false);
    j.a(paramParcel, 8, paramAdRequestInfoParcel.h, false);
    j.a(paramParcel, 9, paramAdRequestInfoParcel.i, false);
    j.a(paramParcel, 10, paramAdRequestInfoParcel.j, false);
    j.a(paramParcel, 11, paramAdRequestInfoParcel.k, paramInt, false);
    j.a(paramParcel, 12, paramAdRequestInfoParcel.l, false);
    j.a(paramParcel, 13, paramAdRequestInfoParcel.m);
    j.a(paramParcel, 14, paramAdRequestInfoParcel.n, false);
    j.a(paramParcel, 15, paramAdRequestInfoParcel.o, false);
    j.a(paramParcel, 17, paramAdRequestInfoParcel.q, paramInt, false);
    j.a(paramParcel, 16, paramAdRequestInfoParcel.p);
    j.a(paramParcel, 19, paramAdRequestInfoParcel.s);
    j.a(paramParcel, 18, paramAdRequestInfoParcel.r);
    j.a(paramParcel, 21, paramAdRequestInfoParcel.u, false);
    j.a(paramParcel, 20, paramAdRequestInfoParcel.t);
    j.a(paramParcel, 25, paramAdRequestInfoParcel.v);
    j.a(paramParcel, 27, paramAdRequestInfoParcel.x, false);
    j.a(paramParcel, 26, paramAdRequestInfoParcel.w, false);
    j.a(paramParcel, 29, paramAdRequestInfoParcel.z, paramInt, false);
    j.a(paramParcel, 28, paramAdRequestInfoParcel.y, false);
    j.a(paramParcel, 31, paramAdRequestInfoParcel.B);
    j.a(paramParcel, 30, paramAdRequestInfoParcel.A, false);
    j.a(paramParcel, 34, paramAdRequestInfoParcel.E);
    j.a(paramParcel, 35, paramAdRequestInfoParcel.F);
    j.a(paramParcel, 32, paramAdRequestInfoParcel.C, paramInt, false);
    j.a(paramParcel, 33, paramAdRequestInfoParcel.D, false);
    j.a(paramParcel, 36, paramAdRequestInfoParcel.G);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.r
 * JD-Core Version:    0.6.0
 */