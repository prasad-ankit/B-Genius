package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class a
  implements Parcelable.Creator
{
  public static FavaDiagnosticsEntity a(Parcel paramParcel)
  {
    int i = 0;
    int j = j.a(paramParcel);
    String str = null;
    int k = 0;
    while (paramParcel.dataPosition() < j)
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
        str = j.m(paramParcel, m);
        break;
      case 3:
        i = j.e(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new p("Overread allowed size end=" + j, paramParcel);
    return new FavaDiagnosticsEntity(k, str, i);
  }

  static void a(FavaDiagnosticsEntity paramFavaDiagnosticsEntity, Parcel paramParcel)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramFavaDiagnosticsEntity.a);
    j.a(paramParcel, 2, paramFavaDiagnosticsEntity.b, false);
    j.a(paramParcel, 3, paramFavaDiagnosticsEntity.c);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.a
 * JD-Core Version:    0.6.0
 */