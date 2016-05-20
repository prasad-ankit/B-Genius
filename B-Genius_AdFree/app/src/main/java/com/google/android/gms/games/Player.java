package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;

public abstract interface Player extends Parcelable, e
{
  public abstract String a();

  public abstract String b();

  public abstract String d();

  public abstract String e();

  public abstract boolean f();

  public abstract Uri g();

  public abstract String getBannerImageLandscapeUrl();

  public abstract String getBannerImagePortraitUrl();

  public abstract String getHiResImageUrl();

  public abstract String getIconImageUrl();

  public abstract Uri h();

  public abstract long i();

  public abstract long j();

  public abstract int k();

  public abstract boolean l();

  public abstract String m();

  public abstract PlayerLevelInfo n();

  public abstract MostRecentGameInfo o();

  public abstract Uri p();

  public abstract Uri q();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.Player
 * JD-Core Version:    0.6.0
 */