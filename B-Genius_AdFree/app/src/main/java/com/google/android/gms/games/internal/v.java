package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;

public final class v
{
  public IBinder a;
  public int b = -1;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  private int g;

  private v(int paramInt, IBinder paramIBinder)
  {
    this.g = paramInt;
    this.a = paramIBinder;
  }

  public final Bundle a()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("popupLocationInfo.gravity", this.g);
    localBundle.putInt("popupLocationInfo.displayId", this.b);
    localBundle.putInt("popupLocationInfo.left", this.c);
    localBundle.putInt("popupLocationInfo.top", this.d);
    localBundle.putInt("popupLocationInfo.right", this.e);
    localBundle.putInt("popupLocationInfo.bottom", this.f);
    return localBundle;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.v
 * JD-Core Version:    0.6.0
 */