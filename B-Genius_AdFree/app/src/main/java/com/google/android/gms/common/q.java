package com.google.android.gms.common;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.app.j;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.b.jw;
import com.google.android.gms.common.internal.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class q
{
  public static final int a = 8487000;
  private static boolean b = false;
  private static boolean c = false;
  private static int d = -1;
  private static final Object e = new Object();
  private static String f = null;
  private static Integer g = null;
  private static AtomicBoolean h = new AtomicBoolean();
  private static final AtomicBoolean i = new AtomicBoolean();

  public static int a(Context paramContext)
  {
    if (e.a)
      return 0;
    PackageManager localPackageManager = paramContext.getPackageManager();
    Integer localInteger;
    do
      try
      {
        paramContext.getResources().getString(2130968593);
        if (("com.google.android.gms".equals(paramContext.getPackageName())) || (i.get()))
          break label285;
      }
      catch (Throwable localThrowable)
      {
        synchronized (e)
        {
          while (true)
            if (f == null)
            {
              f = paramContext.getPackageName();
              try
              {
                Bundle localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
                if (localBundle != null)
                  g = Integer.valueOf(localBundle.getInt("com.google.android.gms.version"));
                while (true)
                {
                  localInteger = g;
                  if (localInteger != null)
                    break label223;
                  throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                  localThrowable = localThrowable;
                  Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
                  break;
                  g = null;
                }
              }
              catch (PackageManager.NameNotFoundException localNameNotFoundException4)
              {
                while (true)
                  Log.wtf("GooglePlayServicesUtil", "This should never happen.", localNameNotFoundException4);
              }
            }
        }
      }
    while (f.equals(paramContext.getPackageName()));
    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + f + "' and this call used package '" + paramContext.getPackageName() + "'.");
    label223: if (localInteger.intValue() != a)
      throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + a + " but found " + localInteger + ".  You must have the following declaration within the <application> element: " + "    <meta-data android:name=\"com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
    label285: PackageInfo localPackageInfo;
    try
    {
      localPackageInfo = localPackageManager.getPackageInfo("com.google.android.gms", 64);
      r.a();
      if (j.a(paramContext))
      {
        if (r.a(localPackageInfo, n.a) != null)
          break label414;
        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
      return 1;
    }
    k localk;
    try
    {
      localk = r.a(localPackageManager.getPackageInfo("com.android.vending", 8256), n.a);
      if (localk == null)
      {
        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
        return 9;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException2)
    {
      Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
      return 9;
    }
    if (r.a(localPackageInfo, new k[] { localk }) == null)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
      return 9;
    }
    label414: int j = jw.a(a);
    if (jw.a(localPackageInfo.versionCode) < j)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + a + " but found " + localPackageInfo.versionCode);
      return 2;
    }
    Object localObject1 = localPackageInfo.applicationInfo;
    if (localObject1 == null);
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo("com.google.android.gms", 0);
      localObject1 = localApplicationInfo;
      if (!((ApplicationInfo)localObject1).enabled)
        return 3;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException3)
    {
      Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", localNameNotFoundException3);
      return 1;
    }
    return 0;
  }

  public static String a(int paramInt)
  {
    return ConnectionResult.a(paramInt);
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    boolean bool1 = a(paramContext, paramInt, "com.google.android.gms");
    boolean bool2 = false;
    if (!bool1);
    PackageInfo localPackageInfo;
    r localr;
    label115: label121: 
    do
    {
      return bool2;
      PackageManager localPackageManager1 = paramContext.getPackageManager();
      while (true)
      {
        boolean bool3;
        try
        {
          localPackageInfo = localPackageManager1.getPackageInfo("com.google.android.gms", 64);
          localr = r.a();
          PackageManager localPackageManager2 = paramContext.getPackageManager();
          bool2 = false;
          if (localPackageInfo == null)
            break;
          if ((!a(localPackageManager2)) && ("user".equals(Build.TYPE)))
            break label115;
          j = 1;
          if (j == 0)
            break label121;
          return localr.a(localPackageInfo, true);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          bool3 = Log.isLoggable("GooglePlayServicesUtil", 3);
          bool2 = false;
        }
        if (!bool3)
          break;
        Log.d("GooglePlayServicesUtil", "Package manager can't find google play services package, defaulting to false");
        return false;
        int j = 0;
      }
      bool2 = localr.a(localPackageInfo, false);
    }
    while ((bool2) || (!localr.a(localPackageInfo, true)));
    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
    return bool2;
  }

  private static boolean a(Context paramContext, int paramInt, String paramString)
  {
    AppOpsManager localAppOpsManager;
    if (j.g())
      localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
    try
    {
      localAppOpsManager.checkPackage(paramInt, paramString);
      int j = 1;
      String[] arrayOfString;
      do
      {
        return j;
        arrayOfString = paramContext.getPackageManager().getPackagesForUid(paramInt);
        j = 0;
      }
      while (arrayOfString == null);
      for (int k = 0; ; k++)
      {
        int m = arrayOfString.length;
        j = 0;
        if (k >= m)
          break;
        if (paramString.equals(arrayOfString[k]))
          return true;
      }
    }
    catch (SecurityException localSecurityException)
    {
    }
    return false;
  }

  static boolean a(Context paramContext, String paramString)
  {
    int j = 1;
    if (j.i())
    {
      Iterator localIterator = paramContext.getPackageManager().getPackageInstaller().getAllSessions().iterator();
      while (localIterator.hasNext())
        if (paramString.equals(((PackageInstaller.SessionInfo)localIterator.next()).getAppPackageName()))
          return j;
    }
    if (j.f())
    {
      Bundle localBundle = ((UserManager)paramContext.getSystemService("user")).getApplicationRestrictions(paramContext.getPackageName());
      if ((localBundle == null) || (!"true".equals(localBundle.getString("restricted_profile"))));
    }
    while (j != 0)
    {
      return false;
      j = 0;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      boolean bool = localPackageManager.getApplicationInfo(paramString, 8192).enabled;
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static boolean a(PackageManager paramPackageManager)
  {
    for (int j = 1; ; j = 0)
      synchronized (e)
      {
        int k = d;
        if (k == -1);
        try
        {
          PackageInfo localPackageInfo = paramPackageManager.getPackageInfo("com.google.android.gms", 64);
          r.a();
          k[] arrayOfk = new k[1];
          arrayOfk[0] = n.a[1];
          if (r.a(localPackageInfo, arrayOfk) != null)
            d = 1;
          while (d != 0)
          {
            return j;
            d = 0;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          while (true)
            d = 0;
        }
      }
  }

  public static void b(Context paramContext)
  {
    if (h.getAndSet(true))
      return;
    try
    {
      ((NotificationManager)paramContext.getSystemService("notification")).cancel(10436);
      return;
    }
    catch (SecurityException localSecurityException)
    {
    }
  }

  public static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    default:
      return false;
    case 1:
    case 2:
    case 3:
    case 9:
    }
    return true;
  }

  public static boolean b(Context paramContext, int paramInt)
  {
    if (paramInt == 18)
      return true;
    if (paramInt == 1)
      return a(paramContext, "com.google.android.gms");
    return false;
  }

  public static Resources c(Context paramContext)
  {
    try
    {
      Resources localResources = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
      return localResources;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static Context d(Context paramContext)
  {
    try
    {
      Context localContext = paramContext.createPackageContext("com.google.android.gms", 3);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static String e(Context paramContext)
  {
    String str = paramContext.getApplicationInfo().name;
    PackageManager localPackageManager;
    if (TextUtils.isEmpty(str))
    {
      str = paramContext.getPackageName();
      localPackageManager = paramContext.getApplicationContext().getPackageManager();
    }
    try
    {
      ApplicationInfo localApplicationInfo2 = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localApplicationInfo1 = localApplicationInfo2;
      if (localApplicationInfo1 != null)
        str = localPackageManager.getApplicationLabel(localApplicationInfo1).toString();
      return str;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        ApplicationInfo localApplicationInfo1 = null;
    }
  }

  public static int f(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo("com.google.android.gms", 0);
      return localPackageInfo.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
    }
    return 0;
  }

  public static boolean g(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    return (j.i()) && (localPackageManager.hasSystemFeature("cn.google"));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.q
 * JD-Core Version:    0.6.0
 */