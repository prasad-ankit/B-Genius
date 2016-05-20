package com.google.android.gms.games.multiplayer;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Player;

public abstract interface Participant extends Parcelable, e
{
  public abstract int a();

  public abstract String b();

  public abstract int d();

  public abstract boolean e();

  public abstract String f();

  public abstract Uri g();

  public abstract String getHiResImageUrl();

  public abstract String getIconImageUrl();

  public abstract Uri h();

  public abstract String i();

  public abstract Player j();

  public abstract ParticipantResult k();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Participant
 * JD-Core Version:    0.6.0
 */