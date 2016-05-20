package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class q
  implements Parcelable.Creator
{
  static void a(PlayerLevelInfo paramPlayerLevelInfo, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPlayerLevelInfo.b());
    j.a(paramParcel, 1000, paramPlayerLevelInfo.a());
    j.a(paramParcel, 2, paramPlayerLevelInfo.c());
    j.a(paramParcel, 3, paramPlayerLevelInfo.d(), paramInt, false);
    j.a(paramParcel, 4, paramPlayerLevelInfo.e(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.q
 * JD-Core Version:    0.6.0
 */