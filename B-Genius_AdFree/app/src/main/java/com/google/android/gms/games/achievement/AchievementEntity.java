package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.Arrays;

public final class AchievementEntity
  implements SafeParcelable, Achievement
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final String b;
  private final int c;
  private final String d;
  private final String e;
  private final Uri f;
  private final String g;
  private final Uri h;
  private final String i;
  private final int j;
  private final String k;
  private final PlayerEntity l;
  private final int m;
  private final int n;
  private final String o;
  private final long p;
  private final long q;

  AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramInt2;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramUri1;
    this.g = paramString4;
    this.h = paramUri2;
    this.i = paramString5;
    this.j = paramInt3;
    this.k = paramString6;
    this.l = paramPlayerEntity;
    this.m = paramInt4;
    this.n = paramInt5;
    this.o = paramString7;
    this.p = paramLong1;
    this.q = paramLong2;
  }

  public final String a()
  {
    return this.b;
  }

  public final int b()
  {
    return this.c;
  }

  public final String d()
  {
    return this.d;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Achievement))
      if (this != paramObject);
    while (true)
    {
      return true;
      Achievement localAchievement = (Achievement)paramObject;
      boolean bool2;
      boolean bool1;
      if (b() == 1)
      {
        bool2 = f.a(Integer.valueOf(localAchievement.i()), Integer.valueOf(i()));
        bool1 = f.a(Integer.valueOf(localAchievement.f()), Integer.valueOf(f()));
      }
      while ((!f.a(localAchievement.a(), a())) || (!f.a(localAchievement.d(), d())) || (!f.a(Integer.valueOf(localAchievement.b()), Integer.valueOf(b()))) || (!f.a(localAchievement.e(), e())) || (!f.a(Long.valueOf(localAchievement.k()), Long.valueOf(k()))) || (!f.a(Integer.valueOf(localAchievement.h()), Integer.valueOf(h()))) || (!f.a(Long.valueOf(localAchievement.j()), Long.valueOf(j()))) || (!f.a(localAchievement.g(), g())) || (!bool2) || (!bool1))
      {
        return false;
        bool1 = true;
        bool2 = true;
      }
    }
  }

  public final int f()
  {
    int i1 = 1;
    if (this.c == i1);
    while (true)
    {
      j.a(i1);
      return this.j;
      int i2 = 0;
    }
  }

  public final Player g()
  {
    return this.l;
  }

  public final int h()
  {
    return this.m;
  }

  public final int hashCode()
  {
    int i2;
    int i1;
    if (b() == 1)
    {
      i2 = i();
      i1 = f();
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[10];
      arrayOfObject[0] = a();
      arrayOfObject[1] = d();
      arrayOfObject[2] = Integer.valueOf(b());
      arrayOfObject[3] = e();
      arrayOfObject[4] = Long.valueOf(k());
      arrayOfObject[5] = Integer.valueOf(h());
      arrayOfObject[6] = Long.valueOf(j());
      arrayOfObject[7] = g();
      arrayOfObject[8] = Integer.valueOf(i2);
      arrayOfObject[9] = Integer.valueOf(i1);
      return Arrays.hashCode(arrayOfObject);
      i1 = 0;
      i2 = 0;
    }
  }

  public final int i()
  {
    int i1 = 1;
    if (this.c == i1);
    while (true)
    {
      j.a(i1);
      return this.n;
      int i2 = 0;
    }
  }

  public final long j()
  {
    return this.p;
  }

  public final long k()
  {
    return this.q;
  }

  public final int l()
  {
    return this.a;
  }

  public final Uri m()
  {
    return this.f;
  }

  public final String n()
  {
    return this.g;
  }

  public final Uri o()
  {
    return this.h;
  }

  public final String p()
  {
    return this.i;
  }

  public final int q()
  {
    return this.j;
  }

  public final String r()
  {
    return this.k;
  }

  public final int s()
  {
    return this.n;
  }

  public final String t()
  {
    return this.o;
  }

  public final String toString()
  {
    Q localQ = f.a(this).a("Id", a()).a("Type", Integer.valueOf(b())).a("Name", d()).a("Description", e()).a("Player", g()).a("State", Integer.valueOf(h()));
    if (b() == 1)
    {
      localQ.a("CurrentSteps", Integer.valueOf(i()));
      localQ.a("TotalSteps", Integer.valueOf(f()));
    }
    return localQ.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.achievement.AchievementEntity
 * JD-Core Version:    0.6.0
 */