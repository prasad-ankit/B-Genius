package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final GameEntity b;
  private final PlayerEntity c;
  private final byte[] d;
  private final String e;
  private final ArrayList f;
  private final int g;
  private final long h;
  private final long i;
  private final Bundle j;
  private final int k;

  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramGameEntity;
    this.c = paramPlayerEntity;
    this.d = paramArrayOfByte;
    this.e = paramString;
    this.f = paramArrayList;
    this.g = paramInt2;
    this.h = paramLong1;
    this.i = paramLong2;
    this.j = paramBundle;
    this.k = paramInt3;
  }

  private static int[] a(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.k();
    int m = localList.size();
    int[] arrayOfInt = new int[m];
    for (int n = 0; n < m; n++)
      arrayOfInt[n] = paramGameRequest.a(((Player)localList.get(n)).a());
    return arrayOfInt;
  }

  public final int a()
  {
    return this.a;
  }

  public final int a(String paramString)
  {
    return this.j.getInt(paramString, 0);
  }

  public final int b()
  {
    return this.k;
  }

  public final String d()
  {
    return this.e;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final Game e()
  {
    return this.b;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof GameRequest))
    {
      if (this == paramObject);
      GameRequest localGameRequest;
      do
      {
        return true;
        localGameRequest = (GameRequest)paramObject;
      }
      while ((f.a(localGameRequest.e(), e())) && (f.a(localGameRequest.k(), k())) && (f.a(localGameRequest.d(), d())) && (f.a(localGameRequest.f(), f())) && (Arrays.equals(a(localGameRequest), a(this))) && (f.a(Integer.valueOf(localGameRequest.h()), Integer.valueOf(h()))) && (f.a(Long.valueOf(localGameRequest.i()), Long.valueOf(i()))) && (f.a(Long.valueOf(localGameRequest.j()), Long.valueOf(j()))));
    }
    return false;
  }

  public final Player f()
  {
    return this.c;
  }

  public final byte[] g()
  {
    return this.d;
  }

  public final int h()
  {
    return this.g;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = e();
    arrayOfObject[1] = k();
    arrayOfObject[2] = d();
    arrayOfObject[3] = f();
    arrayOfObject[4] = a(this);
    arrayOfObject[5] = Integer.valueOf(h());
    arrayOfObject[6] = Long.valueOf(i());
    arrayOfObject[7] = Long.valueOf(j());
    return Arrays.hashCode(arrayOfObject);
  }

  public final long i()
  {
    return this.h;
  }

  public final long j()
  {
    return this.i;
  }

  public final List k()
  {
    return new ArrayList(this.f);
  }

  public final Bundle l()
  {
    return this.j;
  }

  public final String toString()
  {
    return f.a(this).a("Game", e()).a("Sender", f()).a("Recipients", k()).a("Data", g()).a("RequestId", d()).a("Type", Integer.valueOf(h())).a("CreationTimestamp", Long.valueOf(i())).a("ExpirationTimestamp", Long.valueOf(j())).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestEntity
 * JD-Core Version:    0.6.0
 */