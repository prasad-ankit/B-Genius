package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import android.support.v4.app.j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;
import java.util.Arrays;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final a CREATOR = new a();
  private final int a;
  private final ArrayList b;

  ZInvitationCluster(int paramInt, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = paramArrayList;
    l();
  }

  private void l()
  {
    if (!this.b.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      j.a(bool);
      Invitation localInvitation1 = (Invitation)this.b.get(0);
      int i = this.b.size();
      for (int j = 1; j < i; j++)
      {
        Invitation localInvitation2 = (Invitation)this.b.get(j);
        j.a(localInvitation1.f().equals(localInvitation2.f()), "All the invitations must be from the same inviter");
      }
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final ArrayList b()
  {
    return new ArrayList(this.b);
  }

  public final Game d()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return ((InvitationEntity)this.b.get(0)).e();
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ZInvitationCluster))
      return false;
    if (this == paramObject)
      return true;
    ZInvitationCluster localZInvitationCluster = (ZInvitationCluster)paramObject;
    if (localZInvitationCluster.b.size() != this.b.size())
      return false;
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (!((Invitation)this.b.get(j)).equals((Invitation)localZInvitationCluster.b.get(j)))
        return false;
    return true;
  }

  public final Participant f()
  {
    return ((InvitationEntity)this.b.get(0)).f();
  }

  public final long g()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final int h()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final int hashCode()
  {
    return Arrays.hashCode(this.b.toArray());
  }

  public final int i()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final int j()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final ArrayList k()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.multiplayer.ZInvitationCluster
 * JD-Core Version:    0.6.0
 */