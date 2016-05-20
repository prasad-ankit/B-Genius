package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.w;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.aW;
import com.google.android.gms.b.dR;
import com.google.android.gms.b.el;
import com.google.android.gms.b.fT;
import com.google.android.gms.b.fa;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hH;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import com.google.android.gms.b.iz;

public abstract class e extends c
  implements q, fa
{
  public e(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramel, paramVersionInfoParcel, paramk);
  }

  public final void A()
  {
    m();
  }

  protected is a(gT paramgT, l paraml)
  {
    View localView = this.d.f.getNextView();
    is localis;
    if ((localView instanceof is))
    {
      hc.a("Reusing webview...");
      localis = (is)localView;
      localis.a(this.d.c, this.d.i, this.a);
    }
    while (true)
    {
      localis.l().a(this, this, this, this, false, this, null, paraml, this);
      a(localis);
      localis.b(paramgT.a.w);
      return localis;
      if (localView != null)
        this.d.f.removeView(localView);
      P.f();
      localis = iz.a(this.d.c, this.d.i, false, false, this.d.d, this.d.e, this.a, this.g);
      if (this.d.i.h != null)
        continue;
      a(localis.b());
    }
  }

  public final void a(aW paramaW)
  {
    w.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    this.d.x = paramaW;
  }

  protected final void a(dR paramdR)
  {
    paramdR.a("/trackActiveViewUnit", new f(this));
  }

  protected final void a(gT paramgT, aR paramaR)
  {
    if (paramgT.e != -2)
    {
      hu.a.post(new g(this, paramgT));
      return;
    }
    if (paramgT.d != null)
      this.d.i = paramgT.d;
    if ((paramgT.b.h) && (!paramgT.b.C))
    {
      this.d.D = 0;
      Q localQ = this.d;
      P.d();
      localQ.h = fT.a(this.d.c, this, paramgT, this.d.d, null, this.h, this, paramaR);
      return;
    }
    hu.a.post(new h(this, paramgT, paramaR));
  }

  protected boolean a(gS paramgS1, gS paramgS2)
  {
    if ((this.d.d()) && (this.d.f != null))
      this.d.f.a().a(paramgS2.y);
    return super.a(paramgS1, paramgS2);
  }

  public final void b(View paramView)
  {
    this.d.C = paramView;
    b(new gS(this.d.k, null, null, null, null, null, null));
  }

  public final void x()
  {
    e();
  }

  public final void y()
  {
    w();
    h();
  }

  public final void z()
  {
    n();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.e
 * JD-Core Version:    0.6.0
 */