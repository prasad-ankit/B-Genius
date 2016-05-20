package com.google.android.gms.games.request;

import android.os.Parcelable;
import com.google.android.gms.common.data.e;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import java.util.List;

public abstract interface GameRequest extends Parcelable, e
{
  public abstract int a(String paramString);

  public abstract String d();

  public abstract Game e();

  public abstract Player f();

  public abstract byte[] g();

  public abstract int h();

  public abstract long i();

  public abstract long j();

  public abstract List k();
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequest
 * JD-Core Version:    0.6.0
 */