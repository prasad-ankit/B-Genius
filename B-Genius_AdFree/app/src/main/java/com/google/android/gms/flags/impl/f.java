package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.w;

public final class f
{
  private static SharedPreferences a = null;

  public static SharedPreferences a(Context paramContext)
  {
    monitorenter;
    try
    {
      if (a == null)
        a = (SharedPreferences)w.a(new g(paramContext));
      SharedPreferences localSharedPreferences = a;
      return localSharedPreferences;
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.flags.impl.f
 * JD-Core Version:    0.6.0
 */