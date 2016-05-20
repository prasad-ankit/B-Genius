package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.Arrays;

public final class GameEntity extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator CREATOR = new a();
  private final int a;
  private final String b;
  private final String c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private final Uri h;
  private final Uri i;
  private final Uri j;
  private final boolean k;
  private final boolean l;
  private final String m;
  private final int n;
  private final int o;
  private final int p;
  private final boolean q;
  private final boolean r;
  private final String s;
  private final String t;
  private final String u;
  private final boolean v;
  private final boolean w;
  private final boolean x;
  private final String y;
  private final boolean z;

  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11, boolean paramBoolean8)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.h = paramUri1;
    this.s = paramString8;
    this.i = paramUri2;
    this.t = paramString9;
    this.j = paramUri3;
    this.u = paramString10;
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.m = paramString7;
    this.n = paramInt2;
    this.o = paramInt3;
    this.p = paramInt4;
    this.q = paramBoolean3;
    this.r = paramBoolean4;
    this.v = paramBoolean5;
    this.w = paramBoolean6;
    this.x = paramBoolean7;
    this.y = paramString11;
    this.z = paramBoolean8;
  }

  static int a(Game paramGame)
  {
    Object[] arrayOfObject = new Object[22];
    arrayOfObject[0] = paramGame.a();
    arrayOfObject[1] = paramGame.b();
    arrayOfObject[2] = paramGame.d();
    arrayOfObject[3] = paramGame.e();
    arrayOfObject[4] = paramGame.f();
    arrayOfObject[5] = paramGame.g();
    arrayOfObject[6] = paramGame.h();
    arrayOfObject[7] = paramGame.i();
    arrayOfObject[8] = paramGame.j();
    arrayOfObject[9] = Boolean.valueOf(paramGame.k());
    arrayOfObject[10] = Boolean.valueOf(paramGame.n());
    arrayOfObject[11] = paramGame.o();
    arrayOfObject[12] = Integer.valueOf(paramGame.p());
    arrayOfObject[13] = Integer.valueOf(paramGame.q());
    arrayOfObject[14] = Integer.valueOf(paramGame.r());
    arrayOfObject[15] = Boolean.valueOf(paramGame.s());
    arrayOfObject[16] = Boolean.valueOf(paramGame.t());
    arrayOfObject[17] = Boolean.valueOf(paramGame.l());
    arrayOfObject[18] = Boolean.valueOf(paramGame.m());
    arrayOfObject[19] = Boolean.valueOf(paramGame.u());
    arrayOfObject[20] = paramGame.v();
    arrayOfObject[21] = Boolean.valueOf(paramGame.w());
    return Arrays.hashCode(arrayOfObject);
  }

  static boolean a(Game paramGame, Object paramObject)
  {
    if (!(paramObject instanceof Game));
    while (true)
    {
      return false;
      if (paramGame == paramObject)
        return true;
      Game localGame = (Game)paramObject;
      if ((!f.a(localGame.a(), paramGame.a())) || (!f.a(localGame.b(), paramGame.b())) || (!f.a(localGame.d(), paramGame.d())) || (!f.a(localGame.e(), paramGame.e())) || (!f.a(localGame.f(), paramGame.f())) || (!f.a(localGame.g(), paramGame.g())) || (!f.a(localGame.h(), paramGame.h())) || (!f.a(localGame.i(), paramGame.i())) || (!f.a(localGame.j(), paramGame.j())) || (!f.a(Boolean.valueOf(localGame.k()), Boolean.valueOf(paramGame.k()))) || (!f.a(Boolean.valueOf(localGame.n()), Boolean.valueOf(paramGame.n()))) || (!f.a(localGame.o(), paramGame.o())) || (!f.a(Integer.valueOf(localGame.p()), Integer.valueOf(paramGame.p()))) || (!f.a(Integer.valueOf(localGame.q()), Integer.valueOf(paramGame.q()))) || (!f.a(Integer.valueOf(localGame.r()), Integer.valueOf(paramGame.r()))) || (!f.a(Boolean.valueOf(localGame.s()), Boolean.valueOf(paramGame.s()))))
        continue;
      Boolean localBoolean = Boolean.valueOf(localGame.t());
      if ((paramGame.t()) && (f.a(Boolean.valueOf(localGame.l()), Boolean.valueOf(paramGame.l()))) && (f.a(Boolean.valueOf(localGame.m()), Boolean.valueOf(paramGame.m()))));
      for (boolean bool = true; (f.a(localBoolean, Boolean.valueOf(bool))) && (f.a(Boolean.valueOf(localGame.u()), Boolean.valueOf(paramGame.u()))) && (f.a(localGame.v(), paramGame.v())) && (f.a(Boolean.valueOf(localGame.w()), Boolean.valueOf(paramGame.w()))); bool = false)
        return true;
    }
  }

  static String b(Game paramGame)
  {
    return f.a(paramGame).a("ApplicationId", paramGame.a()).a("DisplayName", paramGame.b()).a("PrimaryCategory", paramGame.d()).a("SecondaryCategory", paramGame.e()).a("Description", paramGame.f()).a("DeveloperName", paramGame.g()).a("IconImageUri", paramGame.h()).a("IconImageUrl", paramGame.getIconImageUrl()).a("HiResImageUri", paramGame.i()).a("HiResImageUrl", paramGame.getHiResImageUrl()).a("FeaturedImageUri", paramGame.j()).a("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(paramGame.k())).a("InstanceInstalled", Boolean.valueOf(paramGame.n())).a("InstancePackageName", paramGame.o()).a("AchievementTotalCount", Integer.valueOf(paramGame.q())).a("LeaderboardCount", Integer.valueOf(paramGame.r())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.s())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.t())).a("AreSnapshotsEnabled", Boolean.valueOf(paramGame.u())).a("ThemeColor", paramGame.v()).a("HasGamepadSupport", Boolean.valueOf(paramGame.w())).toString();
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
    return a(this, paramObject);
  }

  public final String f()
  {
    return this.f;
  }

  public final String g()
  {
    return this.g;
  }

  public final String getFeaturedImageUrl()
  {
    return this.u;
  }

  public final String getHiResImageUrl()
  {
    return this.t;
  }

  public final String getIconImageUrl()
  {
    return this.s;
  }

  public final Uri h()
  {
    return this.h;
  }

  public final int hashCode()
  {
    return a(this);
  }

  public final Uri i()
  {
    return this.i;
  }

  public final Uri j()
  {
    return this.j;
  }

  public final boolean k()
  {
    return this.k;
  }

  public final boolean l()
  {
    return this.v;
  }

  public final boolean m()
  {
    return this.w;
  }

  public final boolean n()
  {
    return this.l;
  }

  public final String o()
  {
    return this.m;
  }

  public final int p()
  {
    return this.n;
  }

  public final int q()
  {
    return this.o;
  }

  public final int r()
  {
    return this.p;
  }

  public final boolean s()
  {
    return this.q;
  }

  public final boolean t()
  {
    return this.r;
  }

  public final String toString()
  {
    return b(this);
  }

  public final boolean u()
  {
    return this.x;
  }

  public final String v()
  {
    return this.y;
  }

  public final boolean w()
  {
    return this.z;
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }

  public final int x()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.GameEntity
 * JD-Core Version:    0.6.0
 */