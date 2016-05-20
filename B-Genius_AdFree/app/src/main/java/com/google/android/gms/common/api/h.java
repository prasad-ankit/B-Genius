package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.w;
import com.google.android.gms.b.kc;
import com.google.android.gms.b.kh;
import com.google.android.gms.common.api.internal.O;
import com.google.android.gms.common.api.internal.y;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public final class h
{
  private final Set a = new HashSet();
  private final Set b = new HashSet();
  private String c;
  private String d;
  private final Map e = new android.support.v4.b.a();
  private final Context f;
  private final Map g = new android.support.v4.b.a();
  private int h = -1;
  private Looper i;
  private com.google.android.gms.common.i j = com.google.android.gms.common.i.b();
  private d k = kc.a;
  private final ArrayList l = new ArrayList();
  private final ArrayList m = new ArrayList();

  public h(Context paramContext)
  {
    this.f = paramContext;
    this.i = paramContext.getMainLooper();
    this.c = paramContext.getPackageName();
    this.d = paramContext.getClass().getName();
  }

  public h(Context paramContext, j paramj, k paramk)
  {
    this(paramContext);
    w.a(paramj, "Must provide a connected listener");
    this.l.add(paramj);
    w.a(paramk, "Must provide a connection failed listener");
    this.m.add(paramk);
  }

  private void a(O paramO, g paramg)
  {
    paramO.a(this.h, paramg, null);
  }

  public final h a(Scope paramScope)
  {
    w.a(paramScope, "Scope must not be null");
    this.a.add(paramScope);
    return this;
  }

  public final h a(a parama)
  {
    w.a(parama, "Api must not be null");
    this.g.put(parama, null);
    List localList = parama.a().a(null);
    this.b.addAll(localList);
    this.a.addAll(localList);
    return this;
  }

  public final h a(a parama, c paramc)
  {
    w.a(parama, "Api must not be null");
    w.a(paramc, "Null options are not permitted for this Api");
    this.g.put(parama, paramc);
    List localList = parama.a().a(paramc);
    this.b.addAll(localList);
    this.a.addAll(localList);
    return this;
  }

  public final com.google.android.gms.common.internal.f a()
  {
    kh localkh = kh.a;
    if (this.g.containsKey(kc.b))
      localkh = (kh)this.g.get(kc.b);
    return new com.google.android.gms.common.internal.f(null, this.a, this.e, 0, null, this.c, this.d, localkh);
  }

  public final g b()
  {
    boolean bool;
    com.google.android.gms.common.internal.f localf;
    android.support.v4.b.a locala1;
    android.support.v4.b.a locala2;
    ArrayList localArrayList;
    label73: a locala;
    Object localObject2;
    if (!this.g.isEmpty())
    {
      bool = true;
      w.b(bool, "must call addApi() to add at least one API");
      localf = a();
      Map localMap = localf.f();
      locala1 = new android.support.v4.b.a();
      locala2 = new android.support.v4.b.a();
      localArrayList = new ArrayList();
      Iterator localIterator = this.g.keySet().iterator();
      if (!localIterator.hasNext())
        break label236;
      locala = (a)localIterator.next();
      localObject2 = this.g.get(locala);
      Object localObject3 = localMap.get(locala);
      i1 = 0;
      if (localObject3 != null)
        if (!((com.google.android.gms.drive.e)localMap.get(locala)).b)
          break label230;
    }
    label230: for (int i1 = 1; ; i1 = 2)
    {
      locala1.put(locala, Integer.valueOf(i1));
      com.google.android.gms.common.api.internal.f localf1 = new com.google.android.gms.common.api.internal.f(locala, i1);
      localArrayList.add(localf1);
      e locale = locala.a().a(this.f, this.i, localf, localObject2, localf1, localf1);
      locala2.put(locala.b(), locale);
      break label73;
      bool = false;
      break;
    }
    label236: int n = y.a(locala2.values(), true);
    y localy = new y(this.f, new ReentrantLock(), this.i, localf, this.j, this.k, locala1, this.l, this.m, locala2, this.h, n, localArrayList);
    O localO;
    synchronized (g.e())
    {
      g.e().add(localy);
      if (this.h >= 0)
      {
        localO = O.a(null);
        if (localO == null)
          new Handler(this.f.getMainLooper()).post(new i(this, localy));
      }
      else
      {
        return localy;
      }
    }
    a(localO, localy);
    return localy;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.h
 * JD-Core Version:    0.6.0
 */