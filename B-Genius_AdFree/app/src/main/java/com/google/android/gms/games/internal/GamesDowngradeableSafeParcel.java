package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel
{
  protected static boolean b(Integer paramInteger)
  {
    if (paramInteger == null);
    do
      return false;
    while (paramInteger.intValue() < 3200000);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.GamesDowngradeableSafeParcel
 * JD-Core Version:    0.6.0
 */