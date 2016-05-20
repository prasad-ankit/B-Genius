package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.b.kg;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.i;
import com.google.android.gms.common.internal.A;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public final class n
  implements G
{
  private final H a;
  private final Lock b;
  private final Context c;
  private final i d;
  private ConnectionResult e;
  private int f;
  private int g = 0;
  private int h;
  private final Bundle i = new Bundle();
  private final Set j = new HashSet();
  private kg k;
  private int l;
  private boolean m;
  private boolean n;
  private A o;
  private boolean p;
  private boolean q;
  private final com.google.android.gms.common.internal.f r;
  private final Map s;
  private final d t;
  private ArrayList u = new ArrayList();

  public n(H paramH, com.google.android.gms.common.internal.f paramf, Map paramMap, i parami, d paramd, Lock paramLock, Context paramContext)
  {
    this.a = paramH;
    this.r = paramf;
    this.s = paramMap;
    this.d = parami;
    this.t = paramd;
    this.b = paramLock;
    this.c = paramContext;
  }

  private void a(boolean paramBoolean)
  {
    if (this.k != null)
    {
      if ((this.k.e()) && (paramBoolean))
        this.k.c();
      this.k.d();
      this.o = null;
    }
  }

  private boolean a(ConnectionResult paramConnectionResult)
  {
    return (this.l == 2) || ((this.l == 1) && (!paramConnectionResult.a()));
  }

  private void b(ConnectionResult paramConnectionResult)
  {
    h();
    if (!paramConnectionResult.a());
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      this.a.a(paramConnectionResult);
      this.a.e.a(paramConnectionResult);
      return;
    }
  }

  private void b(ConnectionResult paramConnectionResult, a parama, int paramInt)
  {
    int i1 = 1;
    int i2;
    int i3;
    if (paramInt != 2)
    {
      i2 = parama.a().a();
      if (paramInt == i1)
      {
        if (!paramConnectionResult.a())
          break label90;
        i3 = i1;
        if (i3 == 0)
          break label117;
      }
      if ((this.e != null) && (i2 >= this.f))
        break label117;
    }
    while (true)
    {
      if (i1 != 0)
      {
        this.e = paramConnectionResult;
        this.f = i2;
      }
      this.a.b.put(parama.b(), paramConnectionResult);
      return;
      label90: if (this.d.b(paramConnectionResult.c()) != null)
      {
        i3 = i1;
        break;
      }
      i3 = 0;
      break;
      label117: i1 = 0;
    }
  }

  private boolean b(int paramInt)
  {
    if (this.g != paramInt)
    {
      Log.i("GoogleApiClientConnecting", this.a.d.h());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + c(this.g) + " but received callback for step " + c(paramInt), new Exception());
      b(new ConnectionResult(8, null));
      return false;
    }
    return true;
  }

  private static String c(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "UNKNOWN";
    case 0:
      return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
    case 1:
    }
    return "STEP_GETTING_REMOTE_SERVICE";
  }

  private boolean d()
  {
    this.h = (-1 + this.h);
    if (this.h > 0)
      return false;
    if (this.h < 0)
    {
      Log.i("GoogleApiClientConnecting", this.a.d.h());
      Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
      b(new ConnectionResult(8, null));
      return false;
    }
    if (this.e != null)
    {
      this.a.c = this.f;
      b(this.e);
      return false;
    }
    return true;
  }

  private void e()
  {
    if (this.h != 0);
    ArrayList localArrayList;
    do
    {
      do
        return;
      while ((this.m) && (!this.n));
      localArrayList = new ArrayList();
      this.g = 1;
      this.h = this.a.a.size();
      Iterator localIterator = this.a.a.keySet().iterator();
      while (localIterator.hasNext())
      {
        com.google.android.gms.common.api.f localf = (com.google.android.gms.common.api.f)localIterator.next();
        if (this.a.b.containsKey(localf))
        {
          if (!d())
            continue;
          f();
          continue;
        }
        localArrayList.add(this.a.a.get(localf));
      }
    }
    while (localArrayList.isEmpty());
    this.u.add(K.a().submit(new s(this, localArrayList)));
  }

  private void f()
  {
    this.a.e();
    K.a().execute(new o(this));
    if (this.k != null)
    {
      if (this.p)
        this.k.a(this.o, this.q);
      a(false);
    }
    Iterator localIterator = this.a.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      com.google.android.gms.common.api.f localf = (com.google.android.gms.common.api.f)localIterator.next();
      ((e)this.a.a.get(localf)).d();
    }
    if (this.i.isEmpty());
    for (Bundle localBundle = null; ; localBundle = this.i)
    {
      this.a.e.a(localBundle);
      return;
    }
  }

  private void g()
  {
    this.m = false;
    this.a.d.b = Collections.emptySet();
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      com.google.android.gms.common.api.f localf = (com.google.android.gms.common.api.f)localIterator.next();
      if (this.a.b.containsKey(localf))
        continue;
      this.a.b.put(localf, new ConnectionResult(17, null));
    }
  }

  private void h()
  {
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
      ((Future)localIterator.next()).cancel(true);
    this.u.clear();
  }

  public final b a(b paramb)
  {
    this.a.d.a.add(paramb);
    return paramb;
  }

  public final void a()
  {
    this.a.b.clear();
    this.m = false;
    this.e = null;
    this.g = 0;
    this.l = 2;
    this.n = false;
    this.p = false;
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.s.keySet().iterator();
    int i1 = 0;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      e locale = (e)this.a.a.get(locala.b());
      int i2 = ((Integer)this.s.get(locala)).intValue();
      if (locala.a().a() == 1);
      for (int i3 = 1; ; i3 = 0)
      {
        int i4 = i3 | i1;
        if (locale.f())
        {
          this.m = true;
          if (i2 < this.l)
            this.l = i2;
          if (i2 != 0)
            this.j.add(locala.b());
        }
        localHashMap.put(locale, new p(this, locala, i2));
        i1 = i4;
        break;
      }
    }
    if (i1 != 0)
      this.m = false;
    if (this.m)
    {
      this.r.a(Integer.valueOf(System.identityHashCode(this.a.d)));
      v localv = new v(this, 0);
      this.k = ((kg)this.t.a(this.c, this.a.d.a(), this.r, this.r.j(), localv, localv));
    }
    this.h = this.a.a.size();
    this.u.add(K.a().submit(new q(this, localHashMap)));
  }

  public final void a(int paramInt)
  {
    b(new ConnectionResult(8, null));
  }

  public final void a(Bundle paramBundle)
  {
    if (!b(1));
    do
    {
      return;
      if (paramBundle == null)
        continue;
      this.i.putAll(paramBundle);
    }
    while (!d());
    f();
  }

  public final void a(ConnectionResult paramConnectionResult, a parama, int paramInt)
  {
    if (!b(1));
    do
    {
      return;
      b(paramConnectionResult, parama, paramInt);
    }
    while (!d());
    f();
  }

  public final b b(b paramb)
  {
    throw new IllegalStateException("GoogleApiClient is not connected yet.");
  }

  public final boolean b()
  {
    h();
    a(true);
    this.a.a(null);
    return true;
  }

  public final void c()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.n
 * JD-Core Version:    0.6.0
 */