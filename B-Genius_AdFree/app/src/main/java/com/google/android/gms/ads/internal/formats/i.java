package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class i
  implements Parcelable.Creator
{
  public static NativeAdOptionsParcel a(Parcel paramParcel)
  {
    boolean bool1 = false;
    int i = j.a(paramParcel);
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    while (paramParcel.dataPosition() < i)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default:
        j.b(paramParcel, m);
        break;
      case 1:
        k = j.e(paramParcel, m);
        break;
      case 2:
        bool2 = j.c(paramParcel, m);
        break;
      case 3:
        j = j.e(paramParcel, m);
        break;
      case 4:
        bool1 = j.c(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new NativeAdOptionsParcel(k, bool2, j, bool1);
  }

  static void a(NativeAdOptionsParcel paramNativeAdOptionsParcel, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramNativeAdOptionsParcel.a);
    j.a(paramParcel, 2, paramNativeAdOptionsParcel.b);
    j.a(paramParcel, 3, paramNativeAdOptionsParcel.c);
    j.a(paramParcel, 4, paramNativeAdOptionsParcel.d);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.i
 * JD-Core Version:    0.6.0
 */