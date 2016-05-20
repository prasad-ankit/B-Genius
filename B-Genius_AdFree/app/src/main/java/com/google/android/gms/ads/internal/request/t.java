package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.ArrayList;

public final class t
  implements Parcelable.Creator
{
  public static AdResponseParcel a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    ArrayList localArrayList1 = null;
    int k = 0;
    ArrayList localArrayList2 = null;
    long l1 = 0L;
    boolean bool1 = false;
    long l2 = 0L;
    ArrayList localArrayList3 = null;
    long l3 = 0L;
    int m = 0;
    String str3 = null;
    long l4 = 0L;
    String str4 = null;
    boolean bool2 = false;
    String str5 = null;
    String str6 = null;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    int n = 0;
    LargeParcelTeleporter localLargeParcelTeleporter = null;
    String str7 = null;
    String str8 = null;
    boolean bool8 = false;
    boolean bool9 = false;
    RewardItemParcel localRewardItemParcel = null;
    ArrayList localArrayList4 = null;
    ArrayList localArrayList5 = null;
    boolean bool10 = false;
    while (paramParcel.dataPosition() < i)
    {
      int i1 = paramParcel.readInt();
      switch (0xFFFF & i1)
      {
      case 16:
      case 17:
      case 20:
      default:
        j.b(paramParcel, i1);
        break;
      case 1:
        j = j.e(paramParcel, i1);
        break;
      case 2:
        str1 = j.m(paramParcel, i1);
        break;
      case 3:
        str2 = j.m(paramParcel, i1);
        break;
      case 4:
        localArrayList1 = j.u(paramParcel, i1);
        break;
      case 5:
        k = j.e(paramParcel, i1);
        break;
      case 6:
        localArrayList2 = j.u(paramParcel, i1);
        break;
      case 7:
        l1 = j.g(paramParcel, i1);
        break;
      case 8:
        bool1 = j.c(paramParcel, i1);
        break;
      case 9:
        l2 = j.g(paramParcel, i1);
        break;
      case 10:
        localArrayList3 = j.u(paramParcel, i1);
        break;
      case 11:
        l3 = j.g(paramParcel, i1);
        break;
      case 12:
        m = j.e(paramParcel, i1);
        break;
      case 13:
        str3 = j.m(paramParcel, i1);
        break;
      case 14:
        l4 = j.g(paramParcel, i1);
        break;
      case 15:
        str4 = j.m(paramParcel, i1);
        break;
      case 19:
        str5 = j.m(paramParcel, i1);
        break;
      case 18:
        bool2 = j.c(paramParcel, i1);
        break;
      case 21:
        str6 = j.m(paramParcel, i1);
        break;
      case 23:
        bool4 = j.c(paramParcel, i1);
        break;
      case 22:
        bool3 = j.c(paramParcel, i1);
        break;
      case 25:
        bool6 = j.c(paramParcel, i1);
        break;
      case 24:
        bool5 = j.c(paramParcel, i1);
        break;
      case 27:
        n = j.e(paramParcel, i1);
        break;
      case 26:
        bool7 = j.c(paramParcel, i1);
        break;
      case 29:
        str7 = j.m(paramParcel, i1);
        break;
      case 28:
        localLargeParcelTeleporter = (LargeParcelTeleporter)j.a(paramParcel, i1, LargeParcelTeleporter.CREATOR);
        break;
      case 31:
        bool8 = j.c(paramParcel, i1);
        break;
      case 30:
        str8 = j.m(paramParcel, i1);
        break;
      case 34:
        localArrayList4 = j.u(paramParcel, i1);
        break;
      case 35:
        localArrayList5 = j.u(paramParcel, i1);
        break;
      case 32:
        bool9 = j.c(paramParcel, i1);
        break;
      case 33:
        localRewardItemParcel = (RewardItemParcel)j.a(paramParcel, i1, RewardItemParcel.CREATOR);
        break;
      case 36:
        bool10 = j.c(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new AdResponseParcel(j, str1, str2, localArrayList1, k, localArrayList2, l1, bool1, l2, localArrayList3, l3, m, str3, l4, str4, bool2, str5, str6, bool3, bool4, bool5, bool6, bool7, n, localLargeParcelTeleporter, str7, str8, bool8, bool9, localRewardItemParcel, localArrayList4, localArrayList5, bool10);
  }

  static void a(AdResponseParcel paramAdResponseParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdResponseParcel.a);
    j.a(paramParcel, 2, paramAdResponseParcel.b, false);
    j.a(paramParcel, 3, paramAdResponseParcel.c, false);
    j.a(paramParcel, 4, paramAdResponseParcel.d, false);
    j.a(paramParcel, 5, paramAdResponseParcel.e);
    j.a(paramParcel, 6, paramAdResponseParcel.f, false);
    j.a(paramParcel, 7, paramAdResponseParcel.g);
    j.a(paramParcel, 8, paramAdResponseParcel.h);
    j.a(paramParcel, 9, paramAdResponseParcel.i);
    j.a(paramParcel, 10, paramAdResponseParcel.j, false);
    j.a(paramParcel, 11, paramAdResponseParcel.k);
    j.a(paramParcel, 12, paramAdResponseParcel.l);
    j.a(paramParcel, 13, paramAdResponseParcel.m, false);
    j.a(paramParcel, 14, paramAdResponseParcel.n);
    j.a(paramParcel, 15, paramAdResponseParcel.o, false);
    j.a(paramParcel, 19, paramAdResponseParcel.q, false);
    j.a(paramParcel, 18, paramAdResponseParcel.p);
    j.a(paramParcel, 21, paramAdResponseParcel.r, false);
    j.a(paramParcel, 23, paramAdResponseParcel.t);
    j.a(paramParcel, 22, paramAdResponseParcel.s);
    j.a(paramParcel, 25, paramAdResponseParcel.v);
    j.a(paramParcel, 24, paramAdResponseParcel.u);
    j.a(paramParcel, 27, paramAdResponseParcel.x);
    j.a(paramParcel, 26, paramAdResponseParcel.w);
    j.a(paramParcel, 29, paramAdResponseParcel.z, false);
    j.a(paramParcel, 28, paramAdResponseParcel.y, paramInt, false);
    j.a(paramParcel, 31, paramAdResponseParcel.B);
    j.a(paramParcel, 30, paramAdResponseParcel.A, false);
    j.a(paramParcel, 34, paramAdResponseParcel.E, false);
    j.a(paramParcel, 35, paramAdResponseParcel.F, false);
    j.a(paramParcel, 32, paramAdResponseParcel.C);
    j.a(paramParcel, 33, paramAdResponseParcel.D, paramInt, false);
    j.a(paramParcel, 36, paramAdResponseParcel.G);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.t
 * JD-Core Version:    0.6.0
 */