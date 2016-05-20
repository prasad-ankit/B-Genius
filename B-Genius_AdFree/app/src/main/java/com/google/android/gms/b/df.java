package com.google.android.gms.b;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.a.a;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.B;
import com.google.android.gms.ads.internal.client.O;
import com.google.android.gms.ads.internal.client.T;
import com.google.android.gms.ads.internal.client.W;
import com.google.android.gms.ads.internal.client.y;
import com.google.android.gms.ads.internal.k;
import com.google.android.gms.ads.internal.reward.a.g;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.v;
import java.util.Set;

public final class df extends O
{
  private String a;
  private cx b;
  private v c;
  private cX d;
  private fF e;
  private String f;

  public df(Context paramContext, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    this(paramString, new cx(paramContext.getApplicationContext(), paramel, paramVersionInfoParcel, paramk));
  }

  private df(String paramString, cx paramcx)
  {
    this.a = paramString;
    this.b = paramcx;
    this.d = new cX();
    P.p().a(paramcx);
  }

  private void l()
  {
    if (this.c != null)
      return;
    this.c = this.b.a(this.a);
    this.d.a(this.c);
    m();
  }

  private void m()
  {
    if ((this.c != null) && (this.e != null))
      this.c.a(this.e, this.f);
  }

  public final a a()
  {
    if (this.c != null)
      return this.c.a();
    return null;
  }

  public final void a(AdSizeParcel paramAdSizeParcel)
  {
    if (this.c != null)
      this.c.a(paramAdSizeParcel);
  }

  public final void a(B paramB)
  {
    this.d.a = paramB;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(T paramT)
  {
    this.d.b = paramT;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(W paramW)
  {
    l();
    if (this.c != null)
      this.c.a(paramW);
  }

  public final void a(y paramy)
  {
    this.d.e = paramy;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(g paramg)
  {
    this.d.f = paramg;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(aW paramaW)
  {
    this.d.d = paramaW;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(fF paramfF, String paramString)
  {
    this.e = paramfF;
    this.f = paramString;
    m();
  }

  public final void a(ft paramft)
  {
    this.d.c = paramft;
    if (this.c != null)
      this.d.a(this.c);
  }

  public final void a(String paramString)
  {
  }

  public final void a(boolean paramBoolean)
  {
    l();
    if (this.c != null)
      this.c.a(paramBoolean);
  }

  public final boolean a(AdRequestParcel paramAdRequestParcel)
  {
    Bundle localBundle1 = paramAdRequestParcel.m;
    boolean bool = false;
    if (localBundle1 == null);
    while (true)
    {
      if (bool)
        l();
      if (paramAdRequestParcel.j != null)
        l();
      if (this.c == null)
        break;
      return this.c.a(paramAdRequestParcel);
      Bundle localBundle2 = localBundle1.getBundle(AdMobAdapter.class.getCanonicalName());
      bool = false;
      if (localBundle2 == null)
        continue;
      bool = localBundle2.keySet().contains("gw");
    }
    de localde = P.p().a(paramAdRequestParcel, this.a);
    if (localde != null)
    {
      if (!localde.e)
        localde.a(paramAdRequestParcel);
      this.c = localde.a;
      Context localContext = this.b.b().getBaseContext();
      localde.b.setBaseContext(localContext);
      localde.c.a(this.d);
      this.d.a(this.c);
      m();
      return localde.f;
    }
    this.c = this.b.a(this.a);
    this.d.a(this.c);
    m();
    return this.c.a(paramAdRequestParcel);
  }

  public final void b()
  {
    if (this.c != null)
      this.c.b();
  }

  public final boolean c()
  {
    return (this.c != null) && (this.c.c());
  }

  public final void c_()
  {
    if (this.c != null)
      this.c.c_();
  }

  public final void d()
  {
    if (this.c != null)
      this.c.d();
  }

  public final void f()
  {
    if (this.c != null)
    {
      this.c.f();
      return;
    }
    hc.d("Interstitial ad must be loaded before showInterstitial().");
  }

  public final void g()
  {
    if (this.c != null)
      this.c.g();
  }

  public final void h()
  {
    if (this.c != null)
    {
      this.c.h();
      return;
    }
    hc.d("Interstitial ad must be loaded before pingManualTrackingUrl().");
  }

  public final AdSizeParcel i()
  {
    if (this.c != null)
      return this.c.i();
    return null;
  }

  public final String j()
  {
    if (this.c != null)
      return this.c.j();
    return null;
  }

  public final boolean k()
  {
    return (this.c != null) && (this.c.k());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.df
 * JD-Core Version:    0.6.0
 */