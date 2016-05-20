package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class b
{
  public static final String a;
  private final Date b;
  private final String c;
  private final int d;
  private final Set e;
  private final Location f;
  private final boolean g;
  private final Bundle h;
  private final Map i;
  private final String j;
  private final String k;
  private final com.google.android.gms.ads.e.a l;
  private final int m;
  private final Set n;
  private final Bundle o;
  private final Set p;
  private final boolean q;

  static
  {
    x.a();
    a = com.google.android.gms.ads.internal.util.client.a.a("emulator");
  }

  public b(c paramc)
  {
    this(paramc, null);
  }

  private b(c paramc, com.google.android.gms.ads.e.a parama)
  {
    this.b = c.a(paramc);
    this.c = null;
    this.d = c.b(paramc);
    this.e = Collections.unmodifiableSet(c.c(paramc));
    this.f = c.d(paramc);
    this.g = false;
    this.h = c.e(paramc);
    this.i = Collections.unmodifiableMap(c.f(paramc));
    this.j = null;
    this.k = null;
    this.l = null;
    this.m = c.g(paramc);
    this.n = Collections.unmodifiableSet(c.h(paramc));
    this.o = c.i(paramc);
    this.p = Collections.unmodifiableSet(c.j(paramc));
    this.q = c.k(paramc);
  }

  public final Bundle a(Class paramClass)
  {
    return this.h.getBundle(paramClass.getName());
  }

  public final Date a()
  {
    return this.b;
  }

  public final boolean a(Context paramContext)
  {
    return this.n.contains(x.a().a(paramContext));
  }

  public final String b()
  {
    return this.c;
  }

  public final int c()
  {
    return this.d;
  }

  public final Set d()
  {
    return this.e;
  }

  public final Location e()
  {
    return this.f;
  }

  public final boolean f()
  {
    return this.g;
  }

  public final String g()
  {
    return this.j;
  }

  public final String h()
  {
    return this.k;
  }

  public final com.google.android.gms.ads.e.a i()
  {
    return this.l;
  }

  public final Map j()
  {
    return this.i;
  }

  public final Bundle k()
  {
    return this.h;
  }

  public final int l()
  {
    return this.m;
  }

  public final Bundle m()
  {
    return this.o;
  }

  public final Set n()
  {
    return this.p;
  }

  public final boolean o()
  {
    return this.q;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.b
 * JD-Core Version:    0.6.0
 */