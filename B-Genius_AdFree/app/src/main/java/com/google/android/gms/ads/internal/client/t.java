package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class t
  implements Parcelable.Creator
{
  public static AdSizeParcel a(Parcel paramParcel)
  {
    AdSizeParcel[] arrayOfAdSizeParcel = null;
    boolean bool1 = false;
    int i = j.a(paramParcel);
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 0;
    int k = 0;
    boolean bool4 = false;
    int m = 0;
    int n = 0;
    String str = null;
    int i1 = 0;
    while (paramParcel.dataPosition() < i)
    {
      int i2 = paramParcel.readInt();
      switch (0xFFFF & i2)
      {
      default:
        j.b(paramParcel, i2);
        break;
      case 1:
        i1 = j.e(paramParcel, i2);
        break;
      case 2:
        str = j.m(paramParcel, i2);
        break;
      case 3:
        n = j.e(paramParcel, i2);
        break;
      case 4:
        m = j.e(paramParcel, i2);
        break;
      case 5:
        bool4 = j.c(paramParcel, i2);
        break;
      case 6:
        k = j.e(paramParcel, i2);
        break;
      case 7:
        j = j.e(paramParcel, i2);
        break;
      case 8:
        arrayOfAdSizeParcel = (AdSizeParcel[])j.b(paramParcel, i2, AdSizeParcel.CREATOR);
        break;
      case 9:
        bool3 = j.c(paramParcel, i2);
        break;
      case 10:
        bool2 = j.c(paramParcel, i2);
        break;
      case 11:
        bool1 = j.c(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new AdSizeParcel(i1, str, n, m, bool4, k, j, arrayOfAdSizeParcel, bool3, bool2, bool1);
  }

  static void a(AdSizeParcel paramAdSizeParcel, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAdSizeParcel.a);
    j.a(paramParcel, 2, paramAdSizeParcel.b, false);
    j.a(paramParcel, 3, paramAdSizeParcel.c);
    j.a(paramParcel, 4, paramAdSizeParcel.d);
    j.a(paramParcel, 5, paramAdSizeParcel.e);
    j.a(paramParcel, 6, paramAdSizeParcel.f);
    j.a(paramParcel, 7, paramAdSizeParcel.g);
    j.a(paramParcel, 8, paramAdSizeParcel.h, paramInt, false);
    j.a(paramParcel, 9, paramAdSizeParcel.i);
    j.a(paramParcel, 10, paramAdSizeParcel.j);
    j.a(paramParcel, 11, paramAdSizeParcel.k);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.t
 * JD-Core Version:    0.6.0
 */