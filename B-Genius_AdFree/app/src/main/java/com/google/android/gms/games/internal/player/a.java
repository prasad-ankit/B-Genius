package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(MostRecentGameInfoEntity paramMostRecentGameInfoEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramMostRecentGameInfoEntity.a(), false);
    j.a(paramParcel, 1000, paramMostRecentGameInfoEntity.h());
    j.a(paramParcel, 2, paramMostRecentGameInfoEntity.b(), false);
    j.a(paramParcel, 3, paramMostRecentGameInfoEntity.d());
    j.a(paramParcel, 4, paramMostRecentGameInfoEntity.e(), paramInt, false);
    j.a(paramParcel, 5, paramMostRecentGameInfoEntity.f(), paramInt, false);
    j.a(paramParcel, 6, paramMostRecentGameInfoEntity.g(), paramInt, false);
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.a
 * JD-Core Version:    0.6.0
 */