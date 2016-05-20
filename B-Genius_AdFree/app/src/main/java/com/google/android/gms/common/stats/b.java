package com.google.android.gms.common.stats;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.j;
import android.util.Log;
import com.google.android.gms.b.jl;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private static final Object a = new Object();
  private static b b;
  private static Integer h;
  private final List c;
  private final List d;
  private final List e;
  private final List f;
  private f g;

  private b()
  {
    if (b() == 0)
    {
      this.c = Collections.EMPTY_LIST;
      this.d = Collections.EMPTY_LIST;
      this.e = Collections.EMPTY_LIST;
      this.f = Collections.EMPTY_LIST;
      return;
    }
    String str1 = (String)d.b.c();
    List localList1;
    String str2;
    List localList2;
    label81: String str3;
    List localList3;
    label108: String str4;
    if (str1 == null)
    {
      localList1 = Collections.EMPTY_LIST;
      this.c = localList1;
      str2 = (String)d.c.c();
      if (str2 != null)
        break label204;
      localList2 = Collections.EMPTY_LIST;
      this.d = localList2;
      str3 = (String)d.d.c();
      if (str3 != null)
        break label218;
      localList3 = Collections.EMPTY_LIST;
      this.e = localList3;
      str4 = (String)d.e.c();
      if (str4 != null)
        break label233;
    }
    label204: label218: label233: for (List localList4 = Collections.EMPTY_LIST; ; localList4 = Arrays.asList(str4.split(",")))
    {
      this.f = localList4;
      this.g = new f(1024, ((Long)d.f.c()).longValue());
      new f(1024, ((Long)d.f.c()).longValue());
      return;
      localList1 = Arrays.asList(str1.split(","));
      break;
      localList2 = Arrays.asList(str2.split(","));
      break label81;
      localList3 = Arrays.asList(str3.split(","));
      break label108;
    }
  }

  public static b a()
  {
    synchronized (a)
    {
      if (b == null)
        b = new b();
      return b;
    }
  }

  private static String a(ServiceConnection paramServiceConnection)
  {
    return String.valueOf(Process.myPid() << 32 | System.identityHashCode(paramServiceConnection));
  }

  private void a(Context paramContext, String paramString1, String paramString2, Intent paramIntent, int paramInt)
  {
    int i;
    if (!com.google.android.gms.common.internal.e.a)
    {
      i = 0;
      if ((i != 0) && (this.g != null))
        break label40;
    }
    label40: 
    do
    {
      return;
      if (b() == 0)
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      if ((paramInt != 4) && (paramInt != 1))
        break label199;
    }
    while (!this.g.b(paramString1));
    String str1 = null;
    String str2 = null;
    Object localObject = null;
    long l1 = System.currentTimeMillis();
    int j = b() & e.c;
    String str3 = null;
    if (j != 0)
    {
      str3 = null;
      if (paramInt != 13)
        str3 = j.a(3, 5);
    }
    long l2 = 0L;
    if ((b() & e.e) != 0)
      l2 = Debug.getNativeHeapAllocatedSize();
    if ((paramInt == 1) || (paramInt == 4) || (paramInt == 14));
    for (ConnectionEvent localConnectionEvent = new ConnectionEvent(l1, paramInt, null, null, null, null, str3, paramString1, SystemClock.elapsedRealtime(), l2); ; localConnectionEvent = new ConnectionEvent(l1, paramInt, localObject, paramString2, str1, str2, str3, paramString1, SystemClock.elapsedRealtime(), l2))
    {
      paramContext.startService(new Intent().setComponent(e.a).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", localConnectionEvent));
      return;
      label199: List localList1 = paramContext.getPackageManager().queryIntentServices(paramIntent, 128);
      ServiceInfo localServiceInfo;
      if ((localList1 == null) || (localList1.size() == 0))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = paramIntent.toUri(0);
        arrayOfObject1[1] = j.a(3, 20);
        Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", arrayOfObject1));
        localServiceInfo = null;
      }
      while (localServiceInfo == null)
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramString2;
        arrayOfObject2[1] = paramIntent.toUri(0);
        Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", arrayOfObject2));
        return;
        if (localList1.size() > 1)
        {
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = paramIntent.toUri(0);
          arrayOfObject3[1] = j.a(3, 20);
          Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", arrayOfObject3));
          Iterator localIterator2 = localList1.iterator();
          if (localIterator2.hasNext())
          {
            Log.w("ConnectionTracker", ((ResolveInfo)localIterator2.next()).serviceInfo.name);
            localServiceInfo = null;
            continue;
          }
        }
        localServiceInfo = ((ResolveInfo)localList1.get(0)).serviceInfo;
      }
      str1 = localServiceInfo.processName;
      str2 = localServiceInfo.name;
      int k = Binder.getCallingPid();
      List localList2 = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      String str4;
      if (localList2 != null)
      {
        Iterator localIterator1 = localList2.iterator();
        while (localIterator1.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator1.next();
          if (localRunningAppProcessInfo.pid != k)
            continue;
          str4 = localRunningAppProcessInfo.processName;
          label512: int m = b();
          if ((!this.c.contains(str4)) && (!this.d.contains(paramString2)) && (!this.e.contains(str1)) && (!this.f.contains(str2)) && ((!str1.equals(str4)) || ((m & e.d) == 0)))
            break label621;
        }
      }
      label621: for (int n = 0; ; n = 1)
      {
        if (n == 0)
          break label625;
        this.g.a(paramString1);
        localObject = str4;
        break;
        str4 = null;
        break label512;
      }
      label625: break;
    }
  }

  private static int b()
  {
    if (h == null);
    try
    {
      int i;
      if ((com.google.android.gms.common.internal.e.a) && (jl.b()) && (jl.a() == Process.myUid()))
      {
        i = 1;
        if (i == 0)
          break label65;
      }
      label65: for (int j = ((Integer)d.a.c()).intValue(); ; j = 0)
      {
        h = Integer.valueOf(j);
        return h.intValue();
        i = 0;
        break;
      }
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        h = Integer.valueOf(0);
    }
  }

  public final void a(Context paramContext, ServiceConnection paramServiceConnection)
  {
    paramContext.unbindService(paramServiceConnection);
    a(paramContext, a(paramServiceConnection), null, null, 1);
  }

  public final void a(Context paramContext, ServiceConnection paramServiceConnection, String paramString, Intent paramIntent)
  {
    a(paramContext, a(paramServiceConnection), paramString, paramIntent, 3);
  }

  public final boolean a(Context paramContext, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return a(paramContext, paramContext.getClass().getName(), paramIntent, paramServiceConnection, 1);
  }

  public final boolean a(Context paramContext, String paramString, Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    ComponentName localComponentName = paramIntent.getComponent();
    if ((localComponentName == null) || ((com.google.android.gms.common.internal.e.a) && ("com.google.android.gms".equals(localComponentName.getPackageName()))));
    for (boolean bool1 = false; bool1; bool1 = j.a(paramContext, localComponentName.getPackageName()))
    {
      Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
      return false;
    }
    boolean bool2 = paramContext.bindService(paramIntent, paramServiceConnection, paramInt);
    if (bool2)
      a(paramContext, a(paramServiceConnection), paramString, paramIntent, 2);
    return bool2;
  }

  public final void b(Context paramContext, ServiceConnection paramServiceConnection)
  {
    a(paramContext, a(paramServiceConnection), null, null, 4);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.stats.b
 * JD-Core Version:    0.6.0
 */