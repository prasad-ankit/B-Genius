package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.games.PlayerEntity;

public class f
  implements Parcelable.Creator
{
  static void a(ParticipantEntity paramParticipantEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramParticipantEntity.i(), false);
    j.a(paramParcel, 1000, paramParticipantEntity.l());
    j.a(paramParcel, 2, paramParticipantEntity.f(), false);
    j.a(paramParcel, 3, paramParticipantEntity.g(), paramInt, false);
    j.a(paramParcel, 4, paramParticipantEntity.h(), paramInt, false);
    j.a(paramParcel, 5, paramParticipantEntity.a());
    j.a(paramParcel, 6, paramParticipantEntity.b(), false);
    j.a(paramParcel, 7, paramParticipantEntity.e());
    j.a(paramParcel, 8, paramParticipantEntity.j(), paramInt, false);
    j.a(paramParcel, 9, paramParticipantEntity.d());
    j.a(paramParcel, 10, paramParticipantEntity.k(), paramInt, false);
    j.a(paramParcel, 11, paramParticipantEntity.getIconImageUrl(), false);
    j.a(paramParcel, 12, paramParticipantEntity.getHiResImageUrl(), false);
    j.x(paramParcel, i);
  }

  public ParticipantEntity a(Parcel paramParcel)
  {
    int i = j.a(paramParcel);
    int j = 0;
    String str1 = null;
    String str2 = null;
    Uri localUri1 = null;
    Uri localUri2 = null;
    int k = 0;
    String str3 = null;
    boolean bool = false;
    PlayerEntity localPlayerEntity = null;
    int m = 0;
    ParticipantResult localParticipantResult = null;
    String str4 = null;
    String str5 = null;
    while (paramParcel.dataPosition() < i)
    {
      int n = paramParcel.readInt();
      switch (0xFFFF & n)
      {
      default:
        j.b(paramParcel, n);
        break;
      case 1:
        str1 = j.m(paramParcel, n);
        break;
      case 1000:
        j = j.e(paramParcel, n);
        break;
      case 2:
        str2 = j.m(paramParcel, n);
        break;
      case 3:
        localUri1 = (Uri)j.a(paramParcel, n, Uri.CREATOR);
        break;
      case 4:
        localUri2 = (Uri)j.a(paramParcel, n, Uri.CREATOR);
        break;
      case 5:
        k = j.e(paramParcel, n);
        break;
      case 6:
        str3 = j.m(paramParcel, n);
        break;
      case 7:
        bool = j.c(paramParcel, n);
        break;
      case 8:
        localPlayerEntity = (PlayerEntity)j.a(paramParcel, n, PlayerEntity.CREATOR);
        break;
      case 9:
        m = j.e(paramParcel, n);
        break;
      case 10:
        localParticipantResult = (ParticipantResult)j.a(paramParcel, n, ParticipantResult.CREATOR);
        break;
      case 11:
        str4 = j.m(paramParcel, n);
        break;
      case 12:
        str5 = j.m(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i)
      throw new p("Overread allowed size end=" + i, paramParcel);
    return new ParticipantEntity(j, str1, str2, localUri1, localUri2, k, str3, bool, localPlayerEntity, m, localParticipantResult, str4, str5);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.f
 * JD-Core Version:    0.6.0
 */