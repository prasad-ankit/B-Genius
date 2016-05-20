package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.y;

public class i
{
  public static final int a = q.a;
  private static final i b = new i();

  public static boolean a(Context paramContext, String paramString)
  {
    return q.a(paramContext, paramString);
  }

  public static i b()
  {
    return b;
  }

  private static String b(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("gcore_");
    localStringBuilder.append(a);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString))
      localStringBuilder.append(paramString);
    localStringBuilder.append("-");
    if (paramContext != null)
      localStringBuilder.append(paramContext.getPackageName());
    localStringBuilder.append("-");
    if (paramContext != null);
    try
    {
      localStringBuilder.append(paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode);
      label94: return localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label94;
    }
  }

  public static void c(Context paramContext)
  {
    q.b(paramContext);
  }

  public int a(Context paramContext)
  {
    int i = q.a(paramContext);
    if (q.b(paramContext, i))
      i = 18;
    return i;
  }

  public Intent a(Context paramContext, int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 1:
    case 2:
      return y.a("com.google.android.gms", b(paramContext, paramString));
    case 42:
      return y.a();
    case 3:
    }
    return y.a("com.google.android.gms");
  }

  public boolean a(int paramInt)
  {
    return q.b(paramInt);
  }

  public boolean a(Context paramContext, int paramInt)
  {
    return q.b(paramContext, paramInt);
  }

  public int b(Context paramContext)
  {
    return q.f(paramContext);
  }

  public Intent b(int paramInt)
  {
    return a(null, paramInt, null);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.i
 * JD-Core Version:    0.6.0
 */