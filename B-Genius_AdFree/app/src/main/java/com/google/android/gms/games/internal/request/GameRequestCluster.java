package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.support.v4.app.j;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import java.util.Arrays;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final a CREATOR = new a();
  private final int a;
  private final ArrayList b;

  GameRequestCluster(int paramInt, ArrayList paramArrayList)
  {
    this.a = paramInt;
    this.b = paramArrayList;
    l();
  }

  private void l()
  {
    boolean bool1;
    GameRequest localGameRequest1;
    int j;
    label39: GameRequest localGameRequest2;
    if (!this.b.isEmpty())
    {
      bool1 = true;
      j.a(bool1);
      localGameRequest1 = (GameRequest)this.b.get(0);
      int i = this.b.size();
      j = 1;
      if (j >= i)
        return;
      localGameRequest2 = (GameRequest)this.b.get(j);
      if (localGameRequest1.h() != localGameRequest2.h())
        break label117;
    }
    label117: for (boolean bool2 = true; ; bool2 = false)
    {
      j.a(bool2, "All the requests must be of the same type");
      j.a(localGameRequest1.f().equals(localGameRequest2.f()), "All the requests must be from the same sender");
      j++;
      break label39;
      bool1 = false;
      break;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final int a(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final ArrayList b()
  {
    return new ArrayList(this.b);
  }

  public final String d()
  {
    return ((GameRequestEntity)this.b.get(0)).d();
  }

  public final int describeContents()
  {
    return 0;
  }

  public final Game e()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GameRequestCluster))
      return false;
    if (this == paramObject)
      return true;
    GameRequestCluster localGameRequestCluster = (GameRequestCluster)paramObject;
    if (localGameRequestCluster.b.size() != this.b.size())
      return false;
    int i = this.b.size();
    for (int j = 0; j < i; j++)
      if (!((GameRequest)this.b.get(j)).equals((GameRequest)localGameRequestCluster.b.get(j)))
        return false;
    return true;
  }

  public final Player f()
  {
    return ((GameRequestEntity)this.b.get(0)).f();
  }

  public final byte[] g()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final int h()
  {
    return ((GameRequestEntity)this.b.get(0)).h();
  }

  public final int hashCode()
  {
    return Arrays.hashCode(this.b.toArray());
  }

  public final long i()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final long j()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestCluster
 * JD-Core Version:    0.6.0
 */