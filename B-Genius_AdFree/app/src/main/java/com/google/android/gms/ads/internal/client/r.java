package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import java.util.ArrayList;

public final class r
  implements Parcelable.Creator
{
  public static AdRequestParcel a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    long l = 0L;
    Bundle localBundle1 = null;
    int k = 0;
    ArrayList localArrayList1 = null;
    boolean bool1 = false;
    int m = 0;
    boolean bool2 = false;
    String str1 = null;
    SearchAdRequestParcel localSearchAdRequestParcel = null;
    Location localLocation = null;
    String str2 = null;
    Bundle localBundle2 = null;
    Bundle localBundle3 = null;
    ArrayList localArrayList2 = null;
    String str3 = null;
    String str4 = null;
    boolean bool3 = false;
    while (paramParcel.dataPosition() < i)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default:
        j.b(paramParcel, n);
        break;
      case 1:
        j = j.e(paramParcel, n);
        break;
      case 2:
        l = j.g(paramParcel, n);
        break;
      case 3:
        localBundle1 = j.o(paramParcel, n);
        break;
      case 4:
        k = j.e(paramParcel, n);
        break;
      case 5:
        localArrayList1 = j.u(paramParcel, n);
        break;
      case 6:
        bool1 = j.c(paramParcel, n);
        break;
      case 7:
        m = j.e(paramParcel, n);
        break;
      case 8:
        bool2 = j.c(paramParcel, n);
        break;
      case 9:
        str1 = j.m(paramParcel, n);
        break;
      case 10:
        localSearchAdRequestParcel = (SearchAdRequestParcel)j.a(paramParcel, n, SearchAdRequestParcel.CREATOR);
        break;
      case 11:
        localLocation = (Location)j.a(paramParcel, n, Location.CREATOR);
        break;
      case 12:
        str2 = j.m(paramParcel, n);
        break;
      case 13:
        localBundle2 = j.o(paramParcel, n);
        break;
      case 14:
        localBundle3 = j.o(paramParcel, n);
        break;
      case 15:
        localArrayList2 = j.u(paramParcel, n);
        break;
      case 17:
        str4 = j.m(paramParcel, n);
        break;
      case 16:
        str3 = j.m(paramParcel, n);
        break;
      case 18:
        bool3 = j.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new AdRequestParcel(j, l, localBundle1, k, localArrayList1, bool1, m, bool2, str1, localSearchAdRequestParcel, localLocation, str2, localBundle2, localBundle3, localArrayList2, str3, str4, bool3);
  }

  static void a(AdRequestParcel paramAdRequestParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdRequestParcel.a);
    j.a(paramParcel, 2, paramAdRequestParcel.b);
    j.a(paramParcel, 3, paramAdRequestParcel.c, false);
    j.a(paramParcel, 4, paramAdRequestParcel.d);
    j.a(paramParcel, 5, paramAdRequestParcel.e, false);
    j.a(paramParcel, 6, paramAdRequestParcel.f);
    j.a(paramParcel, 7, paramAdRequestParcel.g);
    j.a(paramParcel, 8, paramAdRequestParcel.h);
    j.a(paramParcel, 9, paramAdRequestParcel.i, false);
    j.a(paramParcel, 10, paramAdRequestParcel.j, paramInt, false);
    j.a(paramParcel, 11, paramAdRequestParcel.k, paramInt, false);
    j.a(paramParcel, 12, paramAdRequestParcel.l, false);
    j.a(paramParcel, 13, paramAdRequestParcel.m, false);
    j.a(paramParcel, 14, paramAdRequestParcel.n, false);
    j.a(paramParcel, 15, paramAdRequestParcel.o, false);
    j.a(paramParcel, 17, paramAdRequestParcel.q, false);
    j.a(paramParcel, 16, paramAdRequestParcel.p, false);
    j.a(paramParcel, 18, paramAdRequestParcel.r);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.r
 * JD-Core Version:    0.6.0
 */