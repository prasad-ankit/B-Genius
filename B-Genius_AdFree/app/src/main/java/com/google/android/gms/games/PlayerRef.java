package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.b;

public final class PlayerRef extends h
  implements Player
{
  private final b c = new b(null);
  private final PlayerLevelInfo d;
  private final MostRecentGameInfoRef e;

  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }

  private PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.e = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.c);
    int i;
    int k;
    PlayerLevel localPlayerLevel1;
    if ((!g(this.c.j)) && (b(this.c.j) != -1L))
    {
      i = 1;
      if (i == 0)
        break label218;
      int j = c(this.c.k);
      k = c(this.c.n);
      localPlayerLevel1 = new PlayerLevel(j, b(this.c.l), b(this.c.m));
      if (j == k)
        break label224;
    }
    label218: label224: for (PlayerLevel localPlayerLevel2 = new PlayerLevel(k, b(this.c.m), b(this.c.o)); ; localPlayerLevel2 = localPlayerLevel1)
    {
      this.d = new PlayerLevelInfo(b(this.c.j), b(this.c.p), localPlayerLevel1, localPlayerLevel2);
      return;
      i = 0;
      break;
      this.d = null;
      return;
    }
  }

  private Player r()
  {
    return new PlayerEntity(this);
  }

  public final String a()
  {
    return e(this.c.a);
  }

  public final String b()
  {
    return e(this.c.b);
  }

  public final String d()
  {
    return e(this.c.z);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return e(this.c.A);
  }

  public final boolean equals(Object paramObject)
  {
    return PlayerEntity.a(this, paramObject);
  }

  public final boolean f()
  {
    return d(this.c.y);
  }

  public final Uri g()
  {
    return f(this.c.c);
  }

  public final String getBannerImageLandscapeUrl()
  {
    return e(this.c.C);
  }

  public final String getBannerImagePortraitUrl()
  {
    return e(this.c.E);
  }

  public final String getHiResImageUrl()
  {
    return e(this.c.f);
  }

  public final String getIconImageUrl()
  {
    return e(this.c.d);
  }

  public final Uri h()
  {
    return f(this.c.e);
  }

  public final int hashCode()
  {
    return PlayerEntity.a(this);
  }

  public final long i()
  {
    return b(this.c.g);
  }

  public final long j()
  {
    if ((!a(this.c.i)) || (g(this.c.i)))
      return -1L;
    return b(this.c.i);
  }

  public final int k()
  {
    return c(this.c.h);
  }

  public final boolean l()
  {
    return d(this.c.r);
  }

  public final String m()
  {
    return e(this.c.q);
  }

  public final PlayerLevelInfo n()
  {
    return this.d;
  }

  public final MostRecentGameInfo o()
  {
    if (g(this.c.s))
      return null;
    return this.e;
  }

  public final Uri p()
  {
    return f(this.c.B);
  }

  public final Uri q()
  {
    return f(this.c.D);
  }

  public final String toString()
  {
    return PlayerEntity.b(this);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)r()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerRef
 * JD-Core Version:    0.6.0
 */