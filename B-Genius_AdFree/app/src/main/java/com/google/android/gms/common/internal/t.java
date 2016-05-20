package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class t
{
  private static final Object a = new Object();
  private static t b;

  public static t a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
        b = new u(paramContext.getApplicationContext());
      return b;
    }
  }

  public abstract boolean a(String paramString1, ServiceConnection paramServiceConnection, String paramString2);

  public abstract void b(String paramString1, ServiceConnection paramServiceConnection, String paramString2);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.t
 * JD-Core Version:    0.6.0
 */