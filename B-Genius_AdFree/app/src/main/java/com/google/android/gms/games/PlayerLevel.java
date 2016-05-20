package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class PlayerLevel
  implements SafeParcelable
{
  public static final Parcelable.Creator CREATOR = new p();
  private final int a;
  private final int b;
  private final long c;
  private final long d;

  PlayerLevel(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    boolean bool2;
    if (paramLong1 >= 0L)
    {
      bool2 = bool1;
      w.a(bool2, "Min XP must be positive!");
      if (paramLong2 <= paramLong1)
        break label66;
    }
    while (true)
    {
      w.a(bool1, "Max XP must be more than min XP!");
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramLong1;
      this.d = paramLong2;
      return;
      bool2 = false;
      break;
      label66: bool1 = false;
    }
  }

  public PlayerLevel(int paramInt, long paramLong1, long paramLong2)
  {
    this(1, paramInt, paramLong1, paramLong2);
  }

  public final int a()
  {
    return this.a;
  }

  public final int b()
  {
    return this.b;
  }

  public final long c()
  {
    return this.c;
  }

  public final long d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof PlayerLevel));
    PlayerLevel localPlayerLevel;
    do
    {
      return false;
      if (this == paramObject)
        return true;
      localPlayerLevel = (PlayerLevel)paramObject;
    }
    while ((!f.a(Integer.valueOf(localPlayerLevel.b), Integer.valueOf(this.b))) || (!f.a(Long.valueOf(localPlayerLevel.c), Long.valueOf(this.c))) || (!f.a(Long.valueOf(localPlayerLevel.d), Long.valueOf(this.d))));
    return true;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.b);
    arrayOfObject[1] = Long.valueOf(this.c);
    arrayOfObject[2] = Long.valueOf(this.d);
    return Arrays.hashCode(arrayOfObject);
  }

  public final String toString()
  {
    return f.a(this).a("LevelNumber", Integer.valueOf(this.b)).a("MinXp", Long.valueOf(this.c)).a("MaxXp", Long.valueOf(this.d)).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerLevel
 * JD-Core Version:    0.6.0
 */