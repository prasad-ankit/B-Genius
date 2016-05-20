package com.google.android.gms.b;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import android.support.v4.app.j;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.purchase.k;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.q;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

public class hn
{
  private final Object a = new Object();
  private final String b;
  private final gW c;
  private R d;
  private BigInteger e = BigInteger.ONE;
  private final HashSet f = new HashSet();
  private final HashMap g = new HashMap();
  private boolean h = false;
  private boolean i = true;
  private int j = 0;
  private boolean k = false;
  private Context l;
  private VersionInfoParcel m;
  private aG n = null;
  private boolean o = true;
  private af p = null;
  private ag q = null;
  private ae r = null;
  private String s;
  private Boolean t;
  private String u;
  private boolean v;
  private boolean w;

  public hn(hu paramhu)
  {
    new LinkedList();
    this.t = null;
    this.v = false;
    this.w = false;
    this.b = hu.b();
    this.c = new gW(this.b);
  }

  public Bundle a(Context paramContext, gX paramgX, String paramString)
  {
    Bundle localBundle1;
    Bundle localBundle2;
    synchronized (this.a)
    {
      localBundle1 = new Bundle();
      localBundle1.putBundle("app", this.c.a(paramContext, paramString));
      localBundle2 = new Bundle();
      Iterator localIterator1 = this.g.keySet().iterator();
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        localBundle2.putBundle(str, ((gY)this.g.get(str)).a());
      }
    }
    localBundle1.putBundle("slots", localBundle2);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = this.f.iterator();
    while (localIterator2.hasNext())
      localArrayList.add(((gU)localIterator2.next()).d());
    localBundle1.putParcelableArrayList("ads", localArrayList);
    paramgX.a(this.f);
    this.f.clear();
    monitorexit;
    return localBundle1;
  }

  public ag a(Context paramContext)
  {
    au localau = aD.x;
    if ((!((Boolean)P.n().a(localau)).booleanValue()) || (!j.c()) || (b()))
      return null;
    synchronized (this.a)
    {
      if (this.p == null)
      {
        if (!(paramContext instanceof Activity))
          return null;
        this.p = new af((Application)paramContext.getApplicationContext(), (Activity)paramContext);
      }
      if (this.r == null)
        this.r = new ae();
      if (this.q == null)
        this.q = new ag(this.p, this.r, new gn(this.l, this.m, null, null));
      this.q.a();
      ag localag = this.q;
      return localag;
    }
  }

  public String a()
  {
    return this.b;
  }

  public String a(int paramInt, String paramString)
  {
    if (this.m.e);
    for (Resources localResources = this.l.getResources(); localResources == null; localResources = q.c(this.l))
      return paramString;
    return localResources.getString(paramInt);
  }

  public Future a(Context paramContext, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      if (paramBoolean != this.i)
      {
        this.i = paramBoolean;
        Future localFuture = new he(paramContext, paramBoolean).g();
        return localFuture;
      }
      return null;
    }
  }

  public Future a(String paramString)
  {
    Object localObject1 = this.a;
    monitorenter;
    if (paramString != null);
    try
    {
      if (!paramString.equals(this.s))
      {
        this.s = paramString;
        Future localFuture = new hk(this.l, paramString).g();
        return localFuture;
      }
      return null;
    }
    finally
    {
      monitorexit;
    }
    throw localObject2;
  }

  public void a(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (this.a)
    {
      if (!this.k)
      {
        this.l = paramContext.getApplicationContext();
        this.m = paramVersionInfoParcel;
        new hf(paramContext, this).g();
        new hh(paramContext, this).g();
        new hj(paramContext, this).g();
        new hl(paramContext, this).g();
        a(Thread.currentThread());
        this.u = P.e().a(paramContext, paramVersionInfoParcel.b);
        if ((j.j()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()))
          this.w = true;
        Context localContext1 = paramContext.getApplicationContext();
        VersionInfoParcel localVersionInfoParcel1 = this.m;
        Context localContext2 = paramContext.getApplicationContext();
        VersionInfoParcel localVersionInfoParcel2 = this.m;
        au localau = aD.a;
        this.d = new R(localContext1, localVersionInfoParcel1, new du(localContext2, localVersionInfoParcel2, (String)P.n().a(localau)));
        n();
        P.o().a(this.l);
        this.k = true;
      }
      return;
    }
  }

  public void a(Bundle paramBundle)
  {
    synchronized (this.a)
    {
      if (paramBundle.containsKey("use_https"));
      for (boolean bool = paramBundle.getBoolean("use_https"); ; bool = this.i)
      {
        this.i = bool;
        if (!paramBundle.containsKey("webview_cache_version"))
          break;
        i1 = paramBundle.getInt("webview_cache_version");
        this.j = i1;
        if (paramBundle.containsKey("content_url_opted_out"))
          a(paramBundle.getBoolean("content_url_opted_out"));
        if (paramBundle.containsKey("content_url_hashes"))
          this.s = paramBundle.getString("content_url_hashes");
        return;
      }
      int i1 = this.j;
    }
  }

  public void a(gU paramgU)
  {
    synchronized (this.a)
    {
      this.f.add(paramgU);
      return;
    }
  }

  public void a(Boolean paramBoolean)
  {
    synchronized (this.a)
    {
      this.t = paramBoolean;
      return;
    }
  }

  public void a(String paramString, gY paramgY)
  {
    synchronized (this.a)
    {
      this.g.put(paramString, paramgY);
      return;
    }
  }

  public void a(Thread paramThread)
  {
    gn.a(this.l, paramThread, this.m);
  }

  public void a(Throwable paramThrowable, boolean paramBoolean)
  {
    new gn(this.l, this.m, null, null).a(paramThrowable, paramBoolean);
  }

  public void a(HashSet paramHashSet)
  {
    synchronized (this.a)
    {
      this.f.addAll(paramHashSet);
      return;
    }
  }

  public void a(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      if (this.o != paramBoolean)
        new hi(this.l, paramBoolean).g();
      this.o = paramBoolean;
      ag localag = a(this.l);
      if ((localag != null) && (!localag.isAlive()))
      {
        hc.c("start fetching content...");
        localag.a();
      }
      return;
    }
  }

  public void b(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      this.v = paramBoolean;
      return;
    }
  }

  public boolean b()
  {
    synchronized (this.a)
    {
      boolean bool = this.o;
      return bool;
    }
  }

  public String c()
  {
    synchronized (this.a)
    {
      String str = this.e.toString();
      this.e = this.e.add(BigInteger.ONE);
      return str;
    }
  }

  public gW d()
  {
    synchronized (this.a)
    {
      gW localgW = this.c;
      return localgW;
    }
  }

  public aG e()
  {
    synchronized (this.a)
    {
      aG localaG = this.n;
      return localaG;
    }
  }

  public boolean f()
  {
    synchronized (this.a)
    {
      boolean bool = this.h;
      this.h = true;
      return bool;
    }
  }

  public boolean g()
  {
    while (true)
    {
      synchronized (this.a)
      {
        if (!this.i)
        {
          if (!this.w)
            break label38;
          break label33;
          return i1;
        }
      }
      label33: int i1 = 1;
      continue;
      label38: i1 = 0;
    }
  }

  public String h()
  {
    synchronized (this.a)
    {
      String str = this.u;
      return str;
    }
  }

  public String i()
  {
    synchronized (this.a)
    {
      String str = this.s;
      return str;
    }
  }

  public Boolean j()
  {
    synchronized (this.a)
    {
      Boolean localBoolean = this.t;
      return localBoolean;
    }
  }

  public R k()
  {
    return this.d;
  }

  public boolean l()
  {
    synchronized (this.a)
    {
      int i1 = this.j;
      au localau1 = aD.K;
      if (i1 < ((Integer)P.n().a(localau1)).intValue())
      {
        au localau2 = aD.K;
        this.j = ((Integer)P.n().a(localau2)).intValue();
        new hg(this.l, this.j).g();
        return true;
      }
      return false;
    }
  }

  public boolean m()
  {
    synchronized (this.a)
    {
      boolean bool = this.v;
      return bool;
    }
  }

  void n()
  {
    aF localaF = new aF(this.l, this.m.b);
    while (true)
    {
      try
      {
        P.j();
        if (localaF.a())
          continue;
        hc.e("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
        localaG = null;
        this.n = localaG;
        return;
        if (localaF.c() == null)
          throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        hc.c("Cannot initialize CSI reporter.", localIllegalArgumentException);
        return;
      }
      if (TextUtils.isEmpty(localaF.d()))
        throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
      aG localaG = new aG(localaF.c(), localaF.d(), localaF.b(), localaF.e());
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.hn
 * JD-Core Version:    0.6.0
 */