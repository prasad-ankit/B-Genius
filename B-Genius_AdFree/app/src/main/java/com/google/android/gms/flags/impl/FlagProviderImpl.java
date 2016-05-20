package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.w;
import com.google.android.gms.a.a;
import com.google.android.gms.b.jY;

public class FlagProviderImpl extends jY
{
  private boolean a = false;
  private SharedPreferences b;

  public boolean getBooleanFlagValue(String paramString, boolean paramBoolean, int paramInt)
  {
    return ((Boolean)w.a(new b(this.b, paramString, Boolean.valueOf(paramBoolean)))).booleanValue();
  }

  public int getIntFlagValue(String paramString, int paramInt1, int paramInt2)
  {
    return ((Integer)w.a(new c(this.b, paramString, Integer.valueOf(paramInt1)))).intValue();
  }

  public long getLongFlagValue(String paramString, long paramLong, int paramInt)
  {
    return ((Long)w.a(new d(this.b, paramString, Long.valueOf(paramLong)))).longValue();
  }

  public String getStringFlagValue(String paramString1, String paramString2, int paramInt)
  {
    return (String)w.a(new e(this.b, paramString1, paramString2));
  }

  public void init(a parama)
  {
    Context localContext = (Context)com.google.android.gms.a.d.a(parama);
    if (this.a)
      return;
    try
    {
      this.b = f.a(localContext.createPackageContext("com.google.android.gms", 0));
      this.a = true;
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.flags.impl.FlagProviderImpl
 * JD-Core Version:    0.6.0
 */