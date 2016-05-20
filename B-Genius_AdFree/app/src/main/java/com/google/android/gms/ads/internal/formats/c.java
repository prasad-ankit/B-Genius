package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.a.d;
import com.google.android.gms.b.aZ;
import com.google.android.gms.b.bg;
import java.util.List;

public final class c extends bg
  implements h
{
  private String a;
  private List b;
  private String c;
  private aZ d;
  private String e;
  private double f;
  private String g;
  private String h;
  private Bundle i;
  private Object j = new Object();
  private g k;

  public c(String paramString1, List paramList, String paramString2, aZ paramaZ, String paramString3, double paramDouble, String paramString4, String paramString5, a parama, Bundle paramBundle)
  {
    this.a = paramString1;
    this.b = paramList;
    this.c = paramString2;
    this.d = paramaZ;
    this.e = paramString3;
    this.f = paramDouble;
    this.g = paramString4;
    this.h = paramString5;
    this.i = paramBundle;
  }

  public final String a()
  {
    return this.a;
  }

  public final void a(g paramg)
  {
    synchronized (this.j)
    {
      this.k = paramg;
      return;
    }
  }

  public final List b()
  {
    return this.b;
  }

  public final String c()
  {
    return this.c;
  }

  public final aZ d()
  {
    return this.d;
  }

  public final String e()
  {
    return this.e;
  }

  public final double f()
  {
    return this.f;
  }

  public final String g()
  {
    return this.g;
  }

  public final String h()
  {
    return this.h;
  }

  public final com.google.android.gms.a.a i()
  {
    return d.a(this.k);
  }

  public final String j()
  {
    return "2";
  }

  public final String k()
  {
    return "";
  }

  public final Bundle l()
  {
    return this.i;
  }

  public final void m()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = 0.0D;
    this.g = null;
    this.h = null;
    this.i = null;
    this.j = null;
    this.k = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.c
 * JD-Core Version:    0.6.0
 */