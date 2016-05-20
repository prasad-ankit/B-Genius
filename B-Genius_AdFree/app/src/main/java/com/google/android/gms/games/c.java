package com.google.android.gms.games;

import android.support.v4.app.w;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.g;

public final class c
{
  static final com.google.android.gms.common.api.f a = new com.google.android.gms.common.api.f();
  public static final Scope b;
  public static final com.google.android.gms.common.api.a c;
  public static final Scope d;
  public static final com.google.android.gms.games.c.f e;
  public static final com.google.android.gms.games.request.b f;
  private static final com.google.android.gms.common.api.d g = new d();
  private static final com.google.android.gms.common.api.d h = new e();

  static
  {
    b = new Scope("https://www.googleapis.com/auth/games");
    c = new com.google.android.gms.common.api.a("Games.API", g, a);
    d = new Scope("https://www.googleapis.com/auth/games.firstparty");
    new com.google.android.gms.common.api.a("Games.API_1P", h, a);
    new l();
    new com.google.android.gms.games.achievement.b();
    new com.google.android.gms.games.a.a();
    new com.google.android.gms.games.b.a();
    e = new com.google.android.gms.games.internal.a.a();
    new com.google.android.gms.games.multiplayer.c();
    new com.google.android.gms.games.multiplayer.a.a();
    new com.google.android.gms.games.multiplayer.realtime.b();
    new com.google.android.gms.games.multiplayer.d();
    new r();
    new m();
    new com.google.android.gms.games.internal.a.e();
    f = new com.google.android.gms.games.request.b();
    new com.google.android.gms.games.snapshot.c();
    new com.google.android.gms.games.d.a();
    new com.google.android.gms.games.video.c();
    new com.google.android.gms.games.internal.c.a();
  }

  public static com.google.android.gms.games.internal.c a(g paramg)
  {
    return a(paramg, true);
  }

  public static com.google.android.gms.games.internal.c a(g paramg, boolean paramBoolean)
  {
    if (paramg != null);
    boolean bool2;
    for (boolean bool1 = true; ; bool1 = false)
    {
      w.b(bool1, "GoogleApiClient parameter is required.");
      w.a(paramg.d(), "GoogleApiClient must be connected.");
      w.a(paramg.a(c), "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
      bool2 = paramg.b(c);
      if ((!paramBoolean) || (bool2))
        break;
      throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
    }
    if (bool2)
      return (com.google.android.gms.games.internal.c)paramg.a(a);
    return null;
  }

  public static com.google.android.gms.common.api.m b(g paramg)
  {
    return paramg.b(new f(paramg));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.c
 * JD-Core Version:    0.6.0
 */