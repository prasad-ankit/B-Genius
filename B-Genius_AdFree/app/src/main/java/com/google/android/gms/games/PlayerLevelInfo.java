package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new q();
  private final int a;
  private final long b;
  private final long c;
  private final PlayerLevel d;
  private final PlayerLevel e;

  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L);
    for (boolean bool = true; ; bool = false)
    {
      w.b(bool);
      w.a(paramPlayerLevel1);
      w.a(paramPlayerLevel2);
      this.a = paramInt;
      this.b = paramLong1;
      this.c = paramLong2;
      this.d = paramPlayerLevel1;
      this.e = paramPlayerLevel2;
      return;
    }
  }

  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }

  public final int a()
  {
    return this.a;
  }

  public final long b()
  {
    return this.b;
  }

  public final long c()
  {
    return this.c;
  }

  public final PlayerLevel d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final PlayerLevel e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlayerLevelInfo));
    PlayerLevelInfo localPlayerLevelInfo;
    do
    {
      return false;
      if (paramObject == this)
        return true;
      localPlayerLevelInfo = (PlayerLevelInfo)paramObject;
    }
    while ((!f.a(Long.valueOf(this.b), Long.valueOf(localPlayerLevelInfo.b))) || (!f.a(Long.valueOf(this.c), Long.valueOf(localPlayerLevelInfo.c))) || (!f.a(this.d, localPlayerLevelInfo.d)) || (!f.a(this.e, localPlayerLevelInfo.e)));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Long.valueOf(this.b);
    arrayOfObject[1] = Long.valueOf(this.c);
    arrayOfObject[2] = this.d;
    arrayOfObject[3] = this.e;
    return Arrays.hashCode(arrayOfObject);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevelInfo
 * JD-Core Version:    0.6.0
 */