package com.google.android.gms.games.achievement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;

public final class a
  implements Parcelable.Creator
{
  static void a(AchievementEntity paramAchievementEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramAchievementEntity.a(), false);
    j.a(paramParcel, 2, paramAchievementEntity.b());
    j.a(paramParcel, 3, paramAchievementEntity.d(), false);
    j.a(paramParcel, 4, paramAchievementEntity.e(), false);
    j.a(paramParcel, 5, paramAchievementEntity.m(), paramInt, false);
    j.a(paramParcel, 6, paramAchievementEntity.n(), false);
    j.a(paramParcel, 7, paramAchievementEntity.o(), paramInt, false);
    j.a(paramParcel, 8, paramAchievementEntity.p(), false);
    j.a(paramParcel, 9, paramAchievementEntity.q());
    j.a(paramParcel, 10, paramAchievementEntity.r(), false);
    j.a(paramParcel, 11, paramAchievementEntity.g(), paramInt, false);
    j.a(paramParcel, 12, paramAchievementEntity.h());
    j.a(paramParcel, 13, paramAchievementEntity.s());
    j.a(paramParcel, 14, paramAchievementEntity.t(), false);
    j.a(paramParcel, 15, paramAchievementEntity.j());
    j.a(paramParcel, 16, paramAchievementEntity.k());
    j.a(paramParcel, 1000, paramAchievementEntity.l());
    j.x(paramParcel, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.a
 * JD-Core Version:    0.6.0
 */