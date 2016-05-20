package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.SharedPreferences;

public final class a
{
  public static final a a;
  private static int b = -1;

  static
  {
    a = new a();
  }

  public static int a(Context paramContext)
  {
    if (b < 0)
      b = paramContext.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
    return b;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.clearcut.a
 * JD-Core Version:    0.6.0
 */