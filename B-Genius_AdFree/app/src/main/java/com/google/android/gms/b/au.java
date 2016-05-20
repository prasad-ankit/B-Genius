package com.google.android.gms.b;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.P;

public abstract class au
{
  private final String a;
  private final Object b;

  private au(int paramInt, String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
    P.m().a(this);
  }

  public static au a(int paramInt, String paramString)
  {
    au localau = a(paramInt, paramString, null);
    P.m().b(localau);
    return localau;
  }

  public static au a(int paramInt1, String paramString, int paramInt2)
  {
    return new aw(paramInt1, paramString, Integer.valueOf(paramInt2));
  }

  public static au a(int paramInt, String paramString, long paramLong)
  {
    return new ax(0, paramString, Long.valueOf(paramLong));
  }

  public static au a(int paramInt, String paramString, Boolean paramBoolean)
  {
    return new av(paramInt, paramString, paramBoolean);
  }

  public static au a(int paramInt, String paramString1, String paramString2)
  {
    return new ay(paramInt, paramString1, paramString2);
  }

  public static au b(int paramInt, String paramString)
  {
    au localau = a(0, paramString, null);
    P.m().c(localau);
    return localau;
  }

  protected abstract Object a(SharedPreferences paramSharedPreferences);

  public final String a()
  {
    return this.a;
  }

  public final Object b()
  {
    return this.b;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.au
 * JD-Core Version:    0.6.0
 */