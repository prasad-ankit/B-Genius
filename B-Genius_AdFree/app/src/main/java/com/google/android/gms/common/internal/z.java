package com.google.android.gms.common.internal;

import android.support.v4.app.w;
import android.util.Log;

public final class z
{
  private static final String a = null;
  private final String b;
  private final String c;

  public z(String paramString)
  {
    this(paramString, null);
  }

  private z(String paramString1, String paramString2)
  {
    w.a(paramString1, "log tag cannot be null");
    if (paramString1.length() <= 23);
    for (int i = 1; ; i = 0)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramString1;
      arrayOfObject[1] = Integer.valueOf(23);
      if (i != 0)
        break;
      throw new IllegalArgumentException(String.format("tag \"%s\" is longer than the %d character maximum", arrayOfObject));
    }
    this.b = paramString1;
    if ((paramString2 == null) || (paramString2.length() <= 0))
    {
      this.c = null;
      return;
    }
    this.c = paramString2;
  }

  private String a(String paramString)
  {
    if (this.c == null)
      return paramString;
    return this.c.concat(paramString);
  }

  private boolean a(int paramInt)
  {
    return Log.isLoggable(this.b, paramInt);
  }

  public final void a(String paramString1, String paramString2)
  {
    if (a(5))
      Log.w(paramString1, a(paramString2));
  }

  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a(5))
      Log.w(paramString1, a(paramString2), paramThrowable);
  }

  public final void b(String paramString1, String paramString2)
  {
    if (a(6))
      Log.e(paramString1, a(paramString2));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.z
 * JD-Core Version:    0.6.0
 */