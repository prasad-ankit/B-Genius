package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.Arrays;

public final class InvitationEntity extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final GameEntity b;
  private final String c;
  private final long d;
  private final int e;
  private final ParticipantEntity f;
  private final ArrayList g;
  private final int h;
  private final int i;

  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList paramArrayList, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramGameEntity;
    this.c = paramString;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramParticipantEntity;
    this.g = paramArrayList;
    this.h = paramInt3;
    this.i = paramInt4;
  }

  public final int b()
  {
    return this.a;
  }

  public final Game d()
  {
    return this.b;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.c;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Invitation))
    {
      if (this == paramObject);
      Invitation localInvitation;
      do
      {
        return true;
        localInvitation = (Invitation)paramObject;
      }
      while ((f.a(localInvitation.d(), d())) && (f.a(localInvitation.e(), e())) && (f.a(Long.valueOf(localInvitation.g()), Long.valueOf(g()))) && (f.a(Integer.valueOf(localInvitation.h()), Integer.valueOf(h()))) && (f.a(localInvitation.f(), f())) && (f.a(localInvitation.k(), k())) && (f.a(Integer.valueOf(localInvitation.i()), Integer.valueOf(i()))) && (f.a(Integer.valueOf(localInvitation.j()), Integer.valueOf(j()))));
    }
    return false;
  }

  public final Participant f()
  {
    return this.f;
  }

  public final long g()
  {
    return this.d;
  }

  public final int h()
  {
    return this.e;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = d();
    arrayOfObject[1] = e();
    arrayOfObject[2] = Long.valueOf(g());
    arrayOfObject[3] = Integer.valueOf(h());
    arrayOfObject[4] = f();
    arrayOfObject[5] = k();
    arrayOfObject[6] = Integer.valueOf(i());
    arrayOfObject[7] = Integer.valueOf(j());
    return Arrays.hashCode(arrayOfObject);
  }

  public final int i()
  {
    return this.h;
  }

  public final int j()
  {
    return this.i;
  }

  public final ArrayList k()
  {
    return new ArrayList(this.g);
  }

  public final String toString()
  {
    return f.a(this).a("Game", d()).a("InvitationId", e()).a("CreationTimestamp", Long.valueOf(g())).a("InvitationType", Integer.valueOf(h())).a("Inviter", f()).a("Participants", k()).a("Variant", Integer.valueOf(i())).a("AvailableAutoMatchSlots", Integer.valueOf(j())).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.InvitationEntity
 * JD-Core Version:    0.6.0
 */