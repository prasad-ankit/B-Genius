package com.google.android.gms.games.c;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class e extends h
  implements a
{
  private final PlayerRef c;

  e(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.c = new PlayerRef(paramDataHolder, paramInt);
  }

  public final long a()
  {
    return b("rank");
  }

  public final String b()
  {
    return e("display_rank");
  }

  public final String d()
  {
    return e("display_score");
  }

  public final long e()
  {
    return b("raw_score");
  }

  public final boolean equals(Object paramObject)
  {
    return d.a(this, paramObject);
  }

  public final long f()
  {
    return b("achieved_timestamp");
  }

  public final String g()
  {
    if (g("external_player_id"))
      return e("default_display_name");
    return this.c.b();
  }

  public final String getScoreHolderHiResImageUrl()
  {
    if (g("external_player_id"))
      return null;
    return this.c.getHiResImageUrl();
  }

  public final String getScoreHolderIconImageUrl()
  {
    if (g("external_player_id"))
      return e("default_display_image_url");
    return this.c.getIconImageUrl();
  }

  public final Uri h()
  {
    if (g("external_player_id"))
      return f("default_display_image_uri");
    return this.c.g();
  }

  public final int hashCode()
  {
    return d.a(this);
  }

  public final Uri i()
  {
    if (g("external_player_id"))
      return null;
    return this.c.h();
  }

  public final Player j()
  {
    if (g("external_player_id"))
      return null;
    return this.c;
  }

  public final String k()
  {
    return e("score_tag");
  }

  public final String toString()
  {
    return d.b(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.c.e
 * JD-Core Version:    0.6.0
 */