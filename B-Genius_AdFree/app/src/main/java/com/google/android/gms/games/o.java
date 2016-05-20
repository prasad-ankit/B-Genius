package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class o
  implements Parcelable.Creator
{
  static void a(PlayerEntity paramPlayerEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramPlayerEntity.a(), false);
    j.a(paramParcel, 2, paramPlayerEntity.b(), false);
    j.a(paramParcel, 3, paramPlayerEntity.g(), paramInt, false);
    j.a(paramParcel, 4, paramPlayerEntity.h(), paramInt, false);
    j.a(paramParcel, 5, paramPlayerEntity.i());
    j.a(paramParcel, 6, paramPlayerEntity.k());
    j.a(paramParcel, 7, paramPlayerEntity.j());
    j.a(paramParcel, 8, paramPlayerEntity.getIconImageUrl(), false);
    j.a(paramParcel, 9, paramPlayerEntity.getHiResImageUrl(), false);
    j.a(paramParcel, 14, paramPlayerEntity.m(), false);
    j.a(paramParcel, 15, paramPlayerEntity.o(), paramInt, false);
    j.a(paramParcel, 16, paramPlayerEntity.n(), paramInt, false);
    j.a(paramParcel, 1000, paramPlayerEntity.r());
    j.a(paramParcel, 19, paramPlayerEntity.f());
    j.a(paramParcel, 18, paramPlayerEntity.l());
    j.a(paramParcel, 21, paramPlayerEntity.e(), false);
    j.a(paramParcel, 20, paramPlayerEntity.d(), false);
    j.a(paramParcel, 23, paramPlayerEntity.getBannerImageLandscapeUrl(), false);
    j.a(paramParcel, 22, paramPlayerEntity.p(), paramInt, false);
    j.a(paramParcel, 25, paramPlayerEntity.getBannerImagePortraitUrl(), false);
    j.a(paramParcel, 24, paramPlayerEntity.q(), paramInt, false);
    j.x(paramParcel, i);
  }

  public PlayerEntity a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    long l1 = 0L;
    int k = 0;
    long l2 = 0L;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    MostRecentGameInfoEntity localMostRecentGameInfoEntity = null;
    PlayerLevelInfo localPlayerLevelInfo = null;
    boolean bool1 = false;
    boolean bool2 = false;
    String str6 = null;
    String str7 = null;
    Uri localUri3 = null;
    String str8 = null;
    Uri localUri4 = null;
    String str9 = null;
    while (paramParcel.dataPosition() < i)
    {
      int m = paramParcel.readInt();
      switch (0xFFFF & m)
      {
      default:
        j.b(paramParcel, m);
        break;
      case 1:
        str1 = j.m(paramParcel, m);
        break;
      case 2:
        str2 = j.m(paramParcel, m);
        break;
      case 3:
        localUri1 = (Uri)j.a(paramParcel, m, Uri.CREATOR);
        break;
      case 4:
        localUri2 = (Uri)j.a(paramParcel, m, Uri.CREATOR);
        break;
      case 5:
        l1 = j.g(paramParcel, m);
        break;
      case 6:
        k = j.e(paramParcel, m);
        break;
      case 7:
        l2 = j.g(paramParcel, m);
        break;
      case 8:
        str3 = j.m(paramParcel, m);
        break;
      case 9:
        str4 = j.m(paramParcel, m);
        break;
      case 14:
        str5 = j.m(paramParcel, m);
        break;
      case 15:
        localMostRecentGameInfoEntity = (MostRecentGameInfoEntity)j.a(paramParcel, m, MostRecentGameInfoEntity.CREATOR);
        break;
      case 16:
        localPlayerLevelInfo = (PlayerLevelInfo)j.a(paramParcel, m, PlayerLevelInfo.CREATOR);
        break;
      case 1000:
        j = j.e(paramParcel, m);
        break;
      case 19:
        bool2 = j.c(paramParcel, m);
        break;
      case 18:
        bool1 = j.c(paramParcel, m);
        break;
      case 21:
        str7 = j.m(paramParcel, m);
        break;
      case 20:
        str6 = j.m(paramParcel, m);
        break;
      case 23:
        str8 = j.m(paramParcel, m);
        break;
      case 22:
        localUri3 = (Uri)j.a(paramParcel, m, Uri.CREATOR);
        break;
      case 25:
        str9 = j.m(paramParcel, m);
        break;
      case 24:
        localUri4 = (Uri)j.a(paramParcel, m, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new PlayerEntity(j, str1, str2, localUri1, localUri2, l1, k, l2, str3, str4, str5, localMostRecentGameInfoEntity, localPlayerLevelInfo, bool1, bool2, str6, str7, localUri3, str8, localUri4, str9);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.o
 * JD-Core Version:    0.6.0
 */