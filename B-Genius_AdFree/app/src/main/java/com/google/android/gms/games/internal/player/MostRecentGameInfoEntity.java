package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final a CREATOR = new a();
  private final int a;
  private final String b;
  private final String c;
  private final long d;
  private final Uri e;
  private final Uri f;
  private final Uri g;

  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramLong;
    this.e = paramUri1;
    this.f = paramUri2;
    this.g = paramUri3;
  }

  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.a = 2;
    this.b = paramMostRecentGameInfo.a();
    this.c = paramMostRecentGameInfo.b();
    this.d = paramMostRecentGameInfo.d();
    this.e = paramMostRecentGameInfo.e();
    this.f = paramMostRecentGameInfo.f();
    this.g = paramMostRecentGameInfo.g();
  }

  static int a(MostRecentGameInfo paramMostRecentGameInfo)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramMostRecentGameInfo.a();
    arrayOfObject[1] = paramMostRecentGameInfo.b();
    arrayOfObject[2] = Long.valueOf(paramMostRecentGameInfo.d());
    arrayOfObject[3] = paramMostRecentGameInfo.e();
    arrayOfObject[4] = paramMostRecentGameInfo.f();
    arrayOfObject[5] = paramMostRecentGameInfo.g();
    return Arrays.hashCode(arrayOfObject);
  }

  static boolean a(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    if (!(paramObject instanceof MostRecentGameInfo));
    MostRecentGameInfo localMostRecentGameInfo;
    do
    {
      return false;
      if (paramMostRecentGameInfo == paramObject)
        return true;
      localMostRecentGameInfo = (MostRecentGameInfo)paramObject;
    }
    while ((!f.a(localMostRecentGameInfo.a(), paramMostRecentGameInfo.a())) || (!f.a(localMostRecentGameInfo.b(), paramMostRecentGameInfo.b())) || (!f.a(Long.valueOf(localMostRecentGameInfo.d()), Long.valueOf(paramMostRecentGameInfo.d()))) || (!f.a(localMostRecentGameInfo.e(), paramMostRecentGameInfo.e())) || (!f.a(localMostRecentGameInfo.f(), paramMostRecentGameInfo.f())) || (!f.a(localMostRecentGameInfo.g(), paramMostRecentGameInfo.g())));
    return true;
  }

  static String b(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return f.a(paramMostRecentGameInfo).a("GameId", paramMostRecentGameInfo.a()).a("GameName", paramMostRecentGameInfo.b()).a("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.d())).a("GameIconUri", paramMostRecentGameInfo.e()).a("GameHiResUri", paramMostRecentGameInfo.f()).a("GameFeaturedUri", paramMostRecentGameInfo.g()).toString();
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

  public final Uri e()
  {
    return this.e;
  }

  public final boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public final Uri f()
  {
    return this.f;
  }

  public final Uri g()
  {
    return this.g;
  }

  public final int h()
  {
    return this.a;
  }

  public final int hashCode()
  {
    return a(this);
  }

  public final String toString()
  {
    return b(this);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.MostRecentGameInfoEntity
 * JD-Core Version:    0.6.0
 */