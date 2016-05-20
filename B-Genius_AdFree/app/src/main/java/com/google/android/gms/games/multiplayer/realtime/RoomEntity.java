package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;
import java.util.Arrays;

public final class RoomEntity extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator CREATOR = new c();
  private final int a;
  private final String b;
  private final String c;
  private final long d;
  private final int e;
  private final String f;
  private final int g;
  private final Bundle h;
  private final ArrayList i;
  private final int j;

  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList paramArrayList, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramInt2;
    this.f = paramString3;
    this.g = paramInt3;
    this.h = paramBundle;
    this.i = paramArrayList;
    this.j = paramInt4;
  }

  public final String a()
  {
    return this.b;
  }

  public final String b()
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

  public final int e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Room))
    {
      if (this == paramObject);
      Room localRoom;
      do
      {
        return true;
        localRoom = (Room)paramObject;
      }
      while ((f.a(localRoom.a(), a())) && (f.a(localRoom.b(), b())) && (f.a(Long.valueOf(localRoom.d()), Long.valueOf(d()))) && (f.a(Integer.valueOf(localRoom.e()), Integer.valueOf(e()))) && (f.a(localRoom.f(), f())) && (f.a(Integer.valueOf(localRoom.g()), Integer.valueOf(g()))) && (f.a(localRoom.h(), h())) && (f.a(localRoom.k(), k())) && (f.a(Integer.valueOf(localRoom.i()), Integer.valueOf(i()))));
    }
    return false;
  }

  public final String f()
  {
    return this.f;
  }

  public final int g()
  {
    return this.g;
  }

  public final Bundle h()
  {
    return this.h;
  }

  public final int hashCode()
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = a();
    arrayOfObject[1] = b();
    arrayOfObject[2] = Long.valueOf(d());
    arrayOfObject[3] = Integer.valueOf(e());
    arrayOfObject[4] = f();
    arrayOfObject[5] = Integer.valueOf(g());
    arrayOfObject[6] = h();
    arrayOfObject[7] = k();
    arrayOfObject[8] = Integer.valueOf(i());
    return Arrays.hashCode(arrayOfObject);
  }

  public final int i()
  {
    return this.j;
  }

  public final int j()
  {
    return this.a;
  }

  public final ArrayList k()
  {
    return new ArrayList(this.i);
  }

  public final String toString()
  {
    return f.a(this).a("RoomId", a()).a("CreatorId", b()).a("CreationTimestamp", Long.valueOf(d())).a("RoomStatus", Integer.valueOf(e())).a("Description", f()).a("Variant", Integer.valueOf(g())).a("AutoMatchCriteria", h()).a("Participants", k()).a("AutoMatchWaitEstimateSeconds", Integer.valueOf(i())).toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RoomEntity
 * JD-Core Version:    0.6.0
 */