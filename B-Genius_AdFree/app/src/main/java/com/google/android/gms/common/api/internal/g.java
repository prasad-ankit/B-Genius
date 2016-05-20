package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.w;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

public final class g
  implements M
{
  private final Context a;
  private final y b;
  private final H c;
  private final H d;
  private final Map e = new android.support.v4.b.a();
  private final Set f = Collections.newSetFromMap(new WeakHashMap());
  private final e g;
  private Bundle h;
  private ConnectionResult i = null;
  private ConnectionResult j = null;
  private boolean k = false;
  private final Lock l;
  private int m = 0;

  public g(Context paramContext, y paramy, Lock paramLock, Looper paramLooper, com.google.android.gms.common.i parami, Map paramMap1, com.google.android.gms.common.internal.f paramf, Map paramMap2, d paramd, ArrayList paramArrayList)
  {
    this.a = paramContext;
    this.b = paramy;
    this.l = paramLock;
    android.support.v4.b.a locala1 = new android.support.v4.b.a();
    android.support.v4.b.a locala2 = new android.support.v4.b.a();
    Iterator localIterator1 = paramMap1.keySet().iterator();
    while (localIterator1.hasNext())
    {
      com.google.android.gms.common.api.f localf4 = (com.google.android.gms.common.api.f)localIterator1.next();
      e locale = (e)paramMap1.get(localf4);
      if (locale.f())
      {
        locala1.put(localf4, locale);
        continue;
      }
      locala2.put(localf4, locale);
    }
    this.g = null;
    if (locala1.isEmpty())
      throw new IllegalStateException("CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
    android.support.v4.b.a locala3 = new android.support.v4.b.a();
    android.support.v4.b.a locala4 = new android.support.v4.b.a();
    Iterator localIterator2 = paramMap2.keySet().iterator();
    while (localIterator2.hasNext())
    {
      com.google.android.gms.common.api.a locala = (com.google.android.gms.common.api.a)localIterator2.next();
      com.google.android.gms.common.api.f localf3 = locala.b();
      if (locala1.containsKey(localf3))
      {
        locala3.put(locala, paramMap2.get(locala));
        continue;
      }
      if (locala2.containsKey(localf3))
      {
        locala4.put(locala, paramMap2.get(locala));
        continue;
      }
      throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator3 = paramArrayList.iterator();
    while (localIterator3.hasNext())
    {
      f localf = (f)localIterator3.next();
      if (locala3.containsKey(localf.a))
      {
        localArrayList1.add(localf);
        continue;
      }
      if (locala4.containsKey(localf.a))
      {
        localArrayList2.add(localf);
        continue;
      }
      throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
    }
    h localh = new h(this);
    this.c = new H(paramContext, this.b, paramLock, paramLooper, parami, locala2, null, locala4, null, localArrayList2, localh);
    i locali = new i(this);
    this.d = new H(paramContext, this.b, paramLock, paramLooper, parami, locala1, paramf, locala3, paramd, localArrayList1, locali);
    Iterator localIterator4 = locala2.keySet().iterator();
    while (localIterator4.hasNext())
    {
      com.google.android.gms.common.api.f localf2 = (com.google.android.gms.common.api.f)localIterator4.next();
      this.e.put(localf2, this.c);
    }
    Iterator localIterator5 = locala1.keySet().iterator();
    while (localIterator5.hasNext())
    {
      com.google.android.gms.common.api.f localf1 = (com.google.android.gms.common.api.f)localIterator5.next();
      this.e.put(localf1, this.d);
    }
  }

  private void a(ConnectionResult paramConnectionResult)
  {
    switch (this.m)
    {
    default:
      Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
    case 2:
    case 1:
    }
    while (true)
    {
      this.m = 0;
      return;
      this.b.a(paramConnectionResult);
      d();
    }
  }

  private static boolean b(ConnectionResult paramConnectionResult)
  {
    return (paramConnectionResult != null) && (paramConnectionResult.b());
  }

  private boolean c(b paramb)
  {
    com.google.android.gms.common.api.f localf = paramb.b();
    w.b(this.e.containsKey(localf), "GoogleApiClient is not configured to use the API required for this call.");
    return ((H)this.e.get(localf)).equals(this.d);
  }

  private void d()
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
      localIterator.next();
    this.f.clear();
  }

  private boolean e()
  {
    return (this.j != null) && (this.j.c() == 4);
  }

  private PendingIntent f()
  {
    if (this.g == null)
      return null;
    return PendingIntent.getActivity(this.a, System.identityHashCode(this.b), this.g.g(), 134217728);
  }

  public final b a(b paramb)
  {
    if (c(paramb))
    {
      if (e())
      {
        paramb.a(new Status(4, null, f()));
        return paramb;
      }
      return this.d.a(paramb);
    }
    return this.c.a(paramb);
  }

  public final void a()
  {
    this.m = 2;
    this.k = false;
    this.j = null;
    this.i = null;
    this.c.a();
    this.d.a();
  }

  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("authClient").println(":");
    this.d.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.append(paramString).append("anonClient").println(":");
    this.c.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public final b b(b paramb)
  {
    if (c(paramb))
    {
      if (e())
      {
        paramb.a(new Status(4, null, f()));
        return paramb;
      }
      return this.d.b(paramb);
    }
    return this.c.b(paramb);
  }

  public final boolean b()
  {
    this.j = null;
    this.i = null;
    this.m = 0;
    boolean bool1 = this.c.b();
    boolean bool2 = this.d.b();
    d();
    int n = 0;
    if (bool1)
    {
      n = 0;
      if (bool2)
        n = 1;
    }
    return n;
  }

  public final boolean c()
  {
    int n = 1;
    this.l.lock();
    try
    {
      if (this.c.c())
        if ((!this.d.c()) && (!e()))
        {
          int i1 = this.m;
          if (i1 != n);
        }
        else
        {
          return n;
        }
      n = 0;
    }
    finally
    {
      this.l.unlock();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.g
 * JD-Core Version:    0.6.0
 */