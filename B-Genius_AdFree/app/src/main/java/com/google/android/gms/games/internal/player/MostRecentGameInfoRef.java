package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;

public final class MostRecentGameInfoRef extends h
  implements MostRecentGameInfo
{
  private final b c;

  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, b paramb)
  {
    super(paramDataHolder, paramInt);
    this.c = paramb;
  }

  private MostRecentGameInfo h()
  {
    return new MostRecentGameInfoEntity(this);
  }

  public final String a()
  {
    return e(this.c.s);
  }

  public final String b()
  {
    return e(this.c.t);
  }

  public final long d()
  {
    return b(this.c.u);
  }

  public final int describeContents()
  {
    return 0;
  }

  public final Uri e()
  {
    return f(this.c.v);
  }

  public final boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.a(this, paramObject);
  }

  public final Uri f()
  {
    return f(this.c.w);
  }

  public final Uri g()
  {
    return f(this.c.x);
  }

  public final int hashCode()
  {
    return MostRecentGameInfoEntity.a(this);
  }

  public final String toString()
  {
    return MostRecentGameInfoEntity.b(this);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)h()).writeToParcel(paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoRef
 * JD-Core Version:    0.6.0
 */