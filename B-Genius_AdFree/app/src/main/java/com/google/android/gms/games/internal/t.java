package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class t
  implements Parcelable.Creator
{
  public static PopupLocationInfoParcelable a(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int i = j.a(paramParcel);
    int j = 0;
    Bundle localBundle = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = paramParcel.readInt();
      switch (0xFFFF & k)
      {
      default:
        j.b(paramParcel, k);
        break;
      case 1:
        localBundle = j.o(paramParcel, k);
        break;
      case 1000:
        j = j.e(paramParcel, k);
        break;
      case 2:
        localIBinder = j.n(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new PopupLocationInfoParcelable(j, localBundle, localIBinder);
  }

  static void a(PopupLocationInfoParcelable paramPopupLocationInfoParcelable, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPopupLocationInfoParcelable.b(), false);
    j.a(paramParcel, 1000, paramPopupLocationInfoParcelable.a());
    j.a(paramParcel, 2, paramPopupLocationInfoParcelable.c(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.t
 * JD-Core Version:    0.6.0
 */