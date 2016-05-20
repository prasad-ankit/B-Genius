package com.google.android.gms.games.c;

import android.net.Uri;
import android.support.v4.app.w;
import com.google.android.gms.common.internal.Q;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.Arrays;

public final class d
  implements a
{
  private final long a;
  private final String b;
  private final String c;
  private final long d;
  private final long e;
  private final String f;
  private final Uri g;
  private final Uri h;
  private final PlayerEntity i;
  private final String j;
  private final String k;
  private final String l;

  public d(a parama)
  {
    this.a = parama.a();
    this.b = ((String)w.a(parama.b()));
    this.c = ((String)w.a(parama.d()));
    this.d = parama.e();
    this.e = parama.f();
    this.f = parama.g();
    this.g = parama.h();
    this.h = parama.i();
    Player localPlayer = parama.j();
    if (localPlayer == null);
    for (PlayerEntity localPlayerEntity = null; ; localPlayerEntity = (PlayerEntity)localPlayer.c())
    {
      this.i = localPlayerEntity;
      this.j = parama.k();
      this.k = parama.getScoreHolderIconImageUrl();
      this.l = parama.getScoreHolderHiResImageUrl();
      return;
    }
  }

  static int a(a parama)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = Long.valueOf(parama.a());
    arrayOfObject[1] = parama.b();
    arrayOfObject[2] = Long.valueOf(parama.e());
    arrayOfObject[3] = parama.d();
    arrayOfObject[4] = Long.valueOf(parama.f());
    arrayOfObject[5] = parama.g();
    arrayOfObject[6] = parama.h();
    arrayOfObject[7] = parama.i();
    arrayOfObject[8] = parama.j();
    return Arrays.hashCode(arrayOfObject);
  }

  static boolean a(a parama, Object paramObject)
  {
    if (!(paramObject instanceof a));
    a locala;
    do
    {
      return false;
      if (parama == paramObject)
        return true;
      locala = (a)paramObject;
    }
    while ((!f.a(Long.valueOf(locala.a()), Long.valueOf(parama.a()))) || (!f.a(locala.b(), parama.b())) || (!f.a(Long.valueOf(locala.e()), Long.valueOf(parama.e()))) || (!f.a(locala.d(), parama.d())) || (!f.a(Long.valueOf(locala.f()), Long.valueOf(parama.f()))) || (!f.a(locala.g(), parama.g())) || (!f.a(locala.h(), parama.h())) || (!f.a(locala.i(), parama.i())) || (!f.a(locala.j(), parama.j())) || (!f.a(locala.k(), parama.k())));
    return true;
  }

  static String b(a parama)
  {
    Q localQ = f.a(parama).a("Rank", Long.valueOf(parama.a())).a("DisplayRank", parama.b()).a("Score", Long.valueOf(parama.e())).a("DisplayScore", parama.d()).a("Timestamp", Long.valueOf(parama.f())).a("DisplayName", parama.g()).a("IconImageUri", parama.h()).a("IconImageUrl", parama.getScoreHolderIconImageUrl()).a("HiResImageUri", parama.i()).a("HiResImageUrl", parama.getScoreHolderHiResImageUrl());
    if (parama.j() == null);
    for (Object localObject = null; ; localObject = parama.j())
      return localQ.a("Player", localObject).a("ScoreTag", parama.k()).toString();
  }

  public final long a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.b;
  }

  public final String d()
  {
    return this.c;
  }

  public final long e()
  {
    return this.d;
  }

  public final boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }

  public final long f()
  {
    return this.e;
  }

  public final String g()
  {
    if (this.i == null)
      return this.f;
    return this.i.b();
  }

  public final String getScoreHolderHiResImageUrl()
  {
    if (this.i == null)
      return this.l;
    return this.i.getHiResImageUrl();
  }

  public final String getScoreHolderIconImageUrl()
  {
    if (this.i == null)
      return this.k;
    return this.i.getIconImageUrl();
  }

  public final Uri h()
  {
    if (this.i == null)
      return this.g;
    return this.i.g();
  }

  public final int hashCode()
  {
    return a(this);
  }

  public final Uri i()
  {
    if (this.i == null)
      return this.h;
    return this.i.h();
  }

  public final Player j()
  {
    return this.i;
  }

  public final String k()
  {
    return this.j;
  }

  public final String toString()
  {
    return b(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.c.d
 * JD-Core Version:    0.6.0
 */