package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public final class q
{
  private long a;
  private Bundle b;
  private int c;
  private List d;
  private boolean e;
  private int f;
  private boolean g;
  private String h;
  private SearchAdRequestParcel i;
  private Location j;
  private String k;
  private Bundle l;
  private Bundle m;
  private List n;
  private String o;
  private String p;
  private boolean q;

  public q()
  {
    this.a = -1L;
    this.b = new Bundle();
    this.c = -1;
    this.d = new ArrayList();
    this.e = false;
    this.f = -1;
    this.g = false;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
    this.l = new Bundle();
    this.m = new Bundle();
    this.n = new ArrayList();
    this.o = null;
    this.p = null;
    this.q = false;
  }

  public q(AdRequestParcel paramAdRequestParcel)
  {
    this.a = paramAdRequestParcel.b;
    this.b = paramAdRequestParcel.c;
    this.c = paramAdRequestParcel.d;
    this.d = paramAdRequestParcel.e;
    this.e = paramAdRequestParcel.f;
    this.f = paramAdRequestParcel.g;
    this.g = paramAdRequestParcel.h;
    this.h = paramAdRequestParcel.i;
    this.i = paramAdRequestParcel.j;
    this.j = paramAdRequestParcel.k;
    this.k = paramAdRequestParcel.l;
    this.l = paramAdRequestParcel.m;
    this.m = paramAdRequestParcel.n;
    this.n = paramAdRequestParcel.o;
    this.o = paramAdRequestParcel.p;
    this.p = paramAdRequestParcel.q;
  }

  public final AdRequestParcel a()
  {
    return new AdRequestParcel(7, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, false);
  }

  public final q a(Location paramLocation)
  {
    this.j = null;
    return this;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.client.q
 * JD-Core Version:    0.6.0
 */