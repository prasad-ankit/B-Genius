package com.google.android.gms.games.multiplayer;

import android.os.Parcelable;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;

public abstract interface Invitation extends Parcelable, e, h
{
  public abstract Game d();

  public abstract String e();

  public abstract Participant f();

  public abstract long g();

  public abstract int h();

  public abstract int i();

  public abstract int j();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.Invitation
 * JD-Core Version:    0.6.0
 */