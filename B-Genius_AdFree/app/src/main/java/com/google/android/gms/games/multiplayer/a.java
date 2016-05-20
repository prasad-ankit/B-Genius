package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

final class a extends b
{
  public final InvitationEntity a(Parcel paramParcel)
  {
    if ((InvitationEntity.a(InvitationEntity.l())) || (InvitationEntity.b(InvitationEntity.class.getCanonicalName())))
      return super.a(paramParcel);
    GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
    String str = paramParcel.readString();
    long l = paramParcel.readLong();
    int i = paramParcel.readInt();
    ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
    int j = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(j);
    for (int k = 0; k < j; k++)
      localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
    return new InvitationEntity(2, localGameEntity, str, l, i, localParticipantEntity, localArrayList, -1, 0);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.a
 * JD-Core Version:    0.6.0
 */