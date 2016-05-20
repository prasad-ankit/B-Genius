package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;

public final class i
  implements Parcelable.Creator
{
  public static DataHolder a(Parcel paramParcel)
  {
    int i = 0;
    Bundle localBundle = null;
    int j = j.a(paramParcel);
    CursorWindow[] arrayOfCursorWindow = null;
    String[] arrayOfString = null;
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
        arrayOfString = j.t(paramParcel, m);
        break;
      case 1000:
        k = j.e(paramParcel, m);
        break;
      case 2:
        arrayOfCursorWindow = (CursorWindow[])j.b(paramParcel, m, CursorWindow.CREATOR);
        break;
      case 3:
        i = j.e(paramParcel, m);
        break;
      case 4:
        localBundle = j.o(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new p("Overread allowed size end=" + j, paramParcel);
    DataHolder localDataHolder = new DataHolder(k, arrayOfString, arrayOfCursorWindow, i, localBundle);
    localDataHolder.a();
    return localDataHolder;
  }

  static void a(DataHolder paramDataHolder, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramDataHolder.c(), false);
    j.a(paramParcel, 1000, paramDataHolder.b());
    j.a(paramParcel, 2, paramDataHolder.d(), paramInt, false);
    j.a(paramParcel, 3, paramDataHolder.e());
    j.a(paramParcel, 4, paramDataHolder.f(), false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.i
 * JD-Core Version:    0.6.0
 */