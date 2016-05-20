package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.b.aZ;
import com.google.android.gms.b.bk;
import java.util.List;

public final class d extends bk
  implements h
{
  private String a;
  private List b;
  private String c;
  private aZ d;
  private String e;
  private String f;
  private Bundle g;
  private Object h = new Object();
  private g i;

  public d(String paramString1, List paramList, String paramString2, aZ paramaZ, String paramString3, String paramString4, a parama, Bundle paramBundle)
  {
    this.a = paramString1;
    this.b = paramList;
    this.c = paramString2;
    this.d = paramaZ;
    this.e = paramString3;
    this.f = paramString4;
    this.g = paramBundle;
  }

  public final String a()
  {
    return this.a;
  }

  public final void a(g paramg)
  {
    synchronized (this.h)
    {
      this.i = paramg;
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

  public final String f()
  {
    return this.f;
  }

  public final com.google.android.gms.a.a g()
  {
    return com.google.android.gms.a.d.a(this.i);
  }

  public final Bundle h()
  {
    return this.g;
  }

  public final void i()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
    this.g = null;
    this.h = null;
    this.i = null;
  }

  public final String j()
  {
    return "1";
  }

  public final String k()
  {
    return "";
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.formats.d
 * JD-Core Version:    0.6.0
 */