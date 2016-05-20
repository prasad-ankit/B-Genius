package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.j;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import java.util.Arrays;

public final class PlayerEntity extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator CREATOR = new n();
  private final int a;
  private String b;
  private String c;
  private final Uri d;
  private final Uri e;
  private final long f;
  private final int g;
  private final long h;
  private final String i;
  private final String j;
  private final String k;
  private final MostRecentGameInfoEntity l;
  private final PlayerLevelInfo m;
  private final boolean n;
  private final boolean o;
  private final String p;
  private final String q;
  private final Uri r;
  private final String s;
  private final Uri t;
  private final String u;

  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString6, String paramString7, Uri paramUri3, String paramString8, Uri paramUri4, String paramString9)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramUri1;
    this.i = paramString3;
    this.e = paramUri2;
    this.j = paramString4;
    this.f = paramLong1;
    this.g = paramInt2;
    this.h = paramLong2;
    this.k = paramString5;
    this.n = paramBoolean1;
    this.l = paramMostRecentGameInfoEntity;
    this.m = paramPlayerLevelInfo;
    this.o = paramBoolean2;
    this.p = paramString6;
    this.q = paramString7;
    this.r = paramUri3;
    this.s = paramString8;
    this.t = paramUri4;
    this.u = paramString9;
  }

  public PlayerEntity(Player paramPlayer)
  {
    this(paramPlayer, true);
  }

  private PlayerEntity(Player paramPlayer, boolean paramBoolean)
  {
    this.a = 13;
    this.b = paramPlayer.a();
    this.c = paramPlayer.b();
    this.d = paramPlayer.g();
    this.i = paramPlayer.getIconImageUrl();
    this.e = paramPlayer.h();
    this.j = paramPlayer.getHiResImageUrl();
    this.f = paramPlayer.i();
    this.g = paramPlayer.k();
    this.h = paramPlayer.j();
    this.k = paramPlayer.m();
    this.n = paramPlayer.l();
    MostRecentGameInfo localMostRecentGameInfo = paramPlayer.o();
    MostRecentGameInfoEntity localMostRecentGameInfoEntity;
    if (localMostRecentGameInfo == null)
    {
      localMostRecentGameInfoEntity = null;
      this.l = localMostRecentGameInfoEntity;
      this.m = paramPlayer.n();
      this.o = paramPlayer.f();
      this.p = paramPlayer.d();
      this.q = paramPlayer.e();
      this.r = paramPlayer.p();
      this.s = paramPlayer.getBannerImageLandscapeUrl();
      this.t = paramPlayer.q();
      this.u = paramPlayer.getBannerImagePortraitUrl();
      j.a(this.b);
      j.a(this.c);
      if (this.f <= 0L)
        break label265;
    }
    label265: for (boolean bool = true; ; bool = false)
    {
      j.a(bool);
      return;
      localMostRecentGameInfoEntity = new MostRecentGameInfoEntity(localMostRecentGameInfo);
      break;
    }
  }

  static int a(Player paramPlayer)
  {
    Object[] arrayOfObject = new Object[12];
    arrayOfObject[0] = paramPlayer.a();
    arrayOfObject[1] = paramPlayer.b();
    arrayOfObject[2] = Boolean.valueOf(paramPlayer.f());
    arrayOfObject[3] = paramPlayer.g();
    arrayOfObject[4] = paramPlayer.h();
    arrayOfObject[5] = Long.valueOf(paramPlayer.i());
    arrayOfObject[6] = paramPlayer.m();
    arrayOfObject[7] = paramPlayer.n();
    arrayOfObject[8] = paramPlayer.d();
    arrayOfObject[9] = paramPlayer.e();
    arrayOfObject[10] = paramPlayer.p();
    arrayOfObject[11] = paramPlayer.q();
    return Arrays.hashCode(arrayOfObject);
  }

  static boolean a(Player paramPlayer, Object paramObject)
  {
    if (!(paramObject instanceof Player));
    Player localPlayer;
    do
    {
      return false;
      if (paramPlayer == paramObject)
        return true;
      localPlayer = (Player)paramObject;
    }
    while ((!f.a(localPlayer.a(), paramPlayer.a())) || (!f.a(localPlayer.b(), paramPlayer.b())) || (!f.a(Boolean.valueOf(localPlayer.f()), Boolean.valueOf(paramPlayer.f()))) || (!f.a(localPlayer.g(), paramPlayer.g())) || (!f.a(localPlayer.h(), paramPlayer.h())) || (!f.a(Long.valueOf(localPlayer.i()), Long.valueOf(paramPlayer.i()))) || (!f.a(localPlayer.m(), paramPlayer.m())) || (!f.a(localPlayer.n(), paramPlayer.n())) || (!f.a(localPlayer.d(), paramPlayer.d())) || (!f.a(localPlayer.e(), paramPlayer.e())) || (!f.a(localPlayer.p(), paramPlayer.p())) || (!f.a(localPlayer.q(), paramPlayer.q())));
    return true;
  }

  static String b(Player paramPlayer)
  {
    return f.a(paramPlayer).a("PlayerId", paramPlayer.a()).a("DisplayName", paramPlayer.b()).a("HasDebugAccess", Boolean.valueOf(paramPlayer.f())).a("IconImageUri", paramPlayer.g()).a("IconImageUrl", paramPlayer.getIconImageUrl()).a("HiResImageUri", paramPlayer.h()).a("HiResImageUrl", paramPlayer.getHiResImageUrl()).a("RetrievedTimestamp", Long.valueOf(paramPlayer.i())).a("Title", paramPlayer.m()).a("LevelInfo", paramPlayer.n()).a("GamerTag", paramPlayer.d()).a("Name", paramPlayer.e()).a("BannerImageLandscapeUri", paramPlayer.p()).a("BannerImageLandscapeUrl", paramPlayer.getBannerImageLandscapeUrl()).a("BannerImagePortraitUri", paramPlayer.q()).a("BannerImagePortraitUrl", paramPlayer.getBannerImagePortraitUrl()).toString();
  }

  public final String a()
  {
    return this.b;
  }

  public final String b()
  {
    return this.c;
  }

  public final String d()
  {
    return this.p;
  }

  public final int describeContents()
  {
    return 0;
  }

  public final String e()
  {
    return this.q;
  }

  public final boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public final boolean f()
  {
    return this.o;
  }

  public final Uri g()
  {
    return this.d;
  }

  public final String getBannerImageLandscapeUrl()
  {
    return this.s;
  }

  public final String getBannerImagePortraitUrl()
  {
    return this.u;
  }

  public final String getHiResImageUrl()
  {
    return this.j;
  }

  public final String getIconImageUrl()
  {
    return this.i;
  }

  public final Uri h()
  {
    return this.e;
  }

  public final int hashCode()
  {
    return a(this);
  }

  public final long i()
  {
    return this.f;
  }

  public final long j()
  {
    return this.h;
  }

  public final int k()
  {
    return this.g;
  }

  public final boolean l()
  {
    return this.n;
  }

  public final String m()
  {
    return this.k;
  }

  public final PlayerLevelInfo n()
  {
    return this.m;
  }

  public final MostRecentGameInfo o()
  {
    return this.l;
  }

  public final Uri p()
  {
    return this.r;
  }

  public final Uri q()
  {
    return this.t;
  }

  public final int r()
  {
    return this.a;
  }

  public final String toString()
  {
    return b(this);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    o.a(this, paramParcel, paramInt);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.PlayerEntity
 * JD-Core Version:    0.6.0
 */