package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import android.support.v4.app.p;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class b
  implements Parcelable.Creator
{
  static void a(InvitationEntity paramInvitationEntity, Parcel paramParcel, int paramInt)
  {
    int i = j.b(paramParcel);
    j.a(paramParcel, 1, paramInvitationEntity.d(), paramInt, false);
    j.a(paramParcel, 1000, paramInvitationEntity.b());
    j.a(paramParcel, 2, paramInvitationEntity.e(), false);
    j.a(paramParcel, 3, paramInvitationEntity.g());
    j.a(paramParcel, 4, paramInvitationEntity.h());
    j.a(paramParcel, 5, paramInvitationEntity.f(), paramInt, false);
    j.b(paramParcel, 6, paramInvitationEntity.k(), false);
    j.a(paramParcel, 7, paramInvitationEntity.i());
    j.a(paramParcel, 8, paramInvitationEntity.j());
    j.x(paramParcel, i);
  }

  public InvitationEntity a(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = 0;
    int j = j.a(paramParcel);
    long l = 0L;
    int k = 0;
    ParticipantEntity localParticipantEntity = null;
    int m = 0;
    String str = null;
    GameEntity localGameEntity = null;
    int n = 0;
    while (paramParcel.dataPosition() < j)
    {
      int i1 = paramParcel.readInt();
      switch (0xFFFF & i1)
      {
      default:
        j.b(paramParcel, i1);
        break;
      case 1:
        localGameEntity = (GameEntity)j.a(paramParcel, i1, GameEntity.CREATOR);
        break;
      case 1000:
        n = j.e(paramParcel, i1);
        break;
      case 2:
        str = j.m(paramParcel, i1);
        break;
      case 3:
        l = j.g(paramParcel, i1);
        break;
      case 4:
        m = j.e(paramParcel, i1);
        break;
      case 5:
        localParticipantEntity = (ParticipantEntity)j.a(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 6:
        localArrayList = j.c(paramParcel, i1, ParticipantEntity.CREATOR);
        break;
      case 7:
        k = j.e(paramParcel, i1);
        break;
      case 8:
        i = j.e(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != j)
      throw new p("Overread allowed size end=" + j, paramParcel);
    return new InvitationEntity(n, localGameEntity, str, l, m, localParticipantEntity, localArrayList, k, i);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.b
 * JD-Core Version:    0.6.0
 */