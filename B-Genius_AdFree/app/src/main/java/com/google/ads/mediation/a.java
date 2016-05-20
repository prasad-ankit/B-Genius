package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.mediation.h;
import com.google.android.gms.ads.mediation.m;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.iU;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public abstract class a
  implements com.google.android.gms.ads.d.a.a, com.google.android.gms.ads.mediation.d, h, iU
{
  private com.google.android.gms.ads.g a;
  private com.google.android.gms.ads.i b;
  private com.google.android.gms.ads.b c;
  private Context d;
  private com.google.android.gms.ads.i e;
  private com.google.android.gms.ads.d.a.b f;
  private String g;
  private com.google.android.gms.ads.d.b h = new b(this);

  private com.google.android.gms.ads.d a(Context paramContext, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    com.google.android.gms.ads.e locale = new com.google.android.gms.ads.e();
    Date localDate = parama.a();
    if (localDate != null)
      locale.a(localDate);
    int i = parama.b();
    if (i != 0)
      locale.a(i);
    Set localSet = parama.c();
    if (localSet != null)
    {
      Iterator localIterator = localSet.iterator();
      while (localIterator.hasNext())
        locale.a((String)localIterator.next());
    }
    Location localLocation = parama.d();
    if (localLocation != null)
      locale.a(localLocation);
    if (parama.f())
      locale.b(x.a().a(paramContext));
    if (parama.e() != -1)
      if (parama.e() != 1)
        break label209;
    label209: for (boolean bool = true; ; bool = false)
    {
      locale.a(bool);
      locale.b(parama.g());
      locale.a(AdMobAdapter.class, a(paramBundle1, paramBundle2));
      return locale.a();
    }
  }

  protected abstract Bundle a(Bundle paramBundle1, Bundle paramBundle2);

  public String a(Bundle paramBundle)
  {
    return paramBundle.getString("pubid");
  }

  public final void a()
  {
    if (this.a != null)
    {
      this.a.d();
      this.a = null;
    }
    if (this.b != null)
      this.b = null;
    if (this.c != null)
      this.c = null;
    if (this.e != null)
      this.e = null;
  }

  public final void a(Context paramContext, com.google.android.gms.ads.mediation.e parame, Bundle paramBundle1, com.google.android.gms.ads.f paramf, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle2)
  {
    this.a = new com.google.android.gms.ads.g(paramContext);
    this.a.a(new com.google.android.gms.ads.f(paramf.b(), paramf.a()));
    this.a.a(a(paramBundle1));
    this.a.a(new e(this, parame));
    this.a.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }

  public final void a(Context paramContext, com.google.android.gms.ads.mediation.g paramg, Bundle paramBundle1, com.google.android.gms.ads.mediation.a parama, Bundle paramBundle2)
  {
    this.b = new com.google.android.gms.ads.i(paramContext);
    this.b.a(a(paramBundle1));
    this.b.a(new f(this, paramg));
    this.b.a(a(paramContext, parama, paramBundle2, paramBundle1));
  }

  public final void a(Context paramContext, com.google.android.gms.ads.mediation.i parami, Bundle paramBundle1, m paramm, Bundle paramBundle2)
  {
    g localg = new g(this, parami);
    com.google.android.gms.ads.c localc = new com.google.android.gms.ads.c(paramContext, paramBundle1.getString("pubid")).a(localg);
    com.google.android.gms.ads.b.c localc1 = paramm.h();
    if (localc1 != null)
      localc.a(localc1);
    if (paramm.i())
      localc.a(localg);
    if (paramm.j())
      localc.a(localg);
    this.c = localc.a();
    this.c.a(a(paramContext, paramm, paramBundle2, paramBundle1));
  }

  public final void a(Context paramContext, String paramString, com.google.android.gms.ads.d.a.b paramb)
  {
    this.d = paramContext.getApplicationContext();
    this.g = paramString;
    this.f = paramb;
    this.f.a(this);
  }

  public final void a(com.google.android.gms.ads.mediation.a parama, Bundle paramBundle1, Bundle paramBundle2)
  {
    if ((this.d == null) || (this.f == null))
    {
      hc.b("AdMobAdapter.loadAd called before initialize.");
      return;
    }
    this.e = new com.google.android.gms.ads.i(this.d);
    this.e.a(true);
    this.e.a(a(paramBundle1));
    this.e.a(this.h);
    this.e.b(this.g);
    this.e.a(a(this.d, parama, paramBundle2, paramBundle1));
  }

  public final void b()
  {
    if (this.a != null)
      this.a.b();
  }

  public final void c()
  {
    if (this.a != null)
      this.a.a();
  }

  public final View d()
  {
    return this.a;
  }

  public final void e()
  {
    this.b.b();
  }

  public final Bundle f()
  {
    return new com.google.android.gms.ads.mediation.c().a(1).a();
  }

  public final void g()
  {
    this.e.b();
  }

  public final boolean h()
  {
    return this.f != null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.a
 * JD-Core Version:    0.6.0
 */