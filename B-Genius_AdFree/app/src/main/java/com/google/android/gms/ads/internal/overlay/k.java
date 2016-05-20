package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.fe;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hx;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import com.google.android.gms.b.iz;
import java.util.Collections;

public final class k extends fe
  implements D
{
  private static int b = Color.argb(0, 0, 0, 0);
  AdOverlayInfoParcel a;
  private final Activity c;
  private is d;
  private o e;
  private B f;
  private boolean g = false;
  private FrameLayout h;
  private WebChromeClient.CustomViewCallback i;
  private boolean j = false;
  private boolean k = false;
  private RelativeLayout l;
  private boolean m = false;
  private int n = 0;
  private y o;
  private boolean p;
  private boolean q = false;
  private boolean r = true;

  public k(Activity paramActivity)
  {
    this.c = paramActivity;
    this.o = new y();
  }

  private void a(boolean paramBoolean)
  {
    int i1;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i1 = 50;
      this.f = new B(this.c, i1, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean)
        break label90;
    }
    label90: for (int i2 = 11; ; i2 = 9)
    {
      localLayoutParams.addRule(i2);
      this.f.a(paramBoolean, this.a.h);
      this.l.addView(this.f, localLayoutParams);
      return;
      i1 = 32;
      break;
    }
  }

  private void b(boolean paramBoolean)
  {
    if (!this.p)
      this.c.requestWindowFeature(1);
    Window localWindow = this.c.getWindow();
    if (localWindow == null)
      throw new m("Invalid activity, no window available.");
    if ((!this.k) || ((this.a.q != null) && (this.a.q.c)))
      localWindow.setFlags(1024, 1024);
    boolean bool1 = this.a.e.l().b();
    this.m = false;
    boolean bool3;
    label145: label209: label378: com.google.android.gms.ads.internal.k localk;
    if (bool1)
    {
      if (this.a.k != P.g().a())
        break label571;
      if (this.c.getResources().getConfiguration().orientation == 1)
      {
        bool3 = true;
        this.m = bool3;
      }
    }
    else
    {
      hc.a("Delay onShow to next orientation change: " + this.m);
      a(this.a.k);
      if (P.g().a(localWindow))
        hc.a("Hardware acceleration on the AdActivity window enabled.");
      if (this.k)
        break label622;
      this.l.setBackgroundColor(-16777216);
      this.c.setContentView(this.l);
      this.p = true;
      if (!paramBoolean)
        break label689;
      P.f();
      this.d = iz.a(this.c, this.a.e.k(), true, bool1, null, this.a.n, null, this.a.e.h());
      this.d.l().a(null, null, this.a.f, this.a.j, true, this.a.o, null, this.a.e.l().a(), null);
      this.d.l().a(new l(this));
      if (this.a.m == null)
        break label635;
      this.d.loadUrl(this.a.m);
      if (this.a.e != null)
        this.a.e.b(this);
      label401: this.d.a(this);
      ViewParent localViewParent = this.d.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(this.d.b());
      if (this.k)
        this.d.setBackgroundColor(b);
      this.l.addView(this.d.b(), -1, -1);
      if ((!paramBoolean) && (!this.m))
        p();
      a(bool1);
      if (this.d.m())
        a(bool1, true);
      localk = this.d.h();
      if (localk == null)
        break label716;
    }
    label571: label716: for (z localz = localk.c; ; localz = null)
    {
      if (localz == null)
        break label722;
      this.o = localz.a();
      return;
      bool3 = false;
      break;
      if (this.a.k != P.g().b())
        break label145;
      if (this.c.getResources().getConfiguration().orientation == 2);
      for (boolean bool2 = true; ; bool2 = false)
      {
        this.m = bool2;
        break;
      }
      label622: this.l.setBackgroundColor(b);
      break label209;
      label635: if (this.a.i != null)
      {
        this.d.loadDataWithBaseURL(this.a.g, this.a.i, "text/html", "UTF-8", null);
        break label378;
      }
      throw new m("No URL or HTML to display in ad overlay.");
      this.d = this.a.e;
      this.d.a(this.c);
      break label401;
    }
    label689: label722: hc.d("Appstreaming controller is null.");
  }

  private void o()
  {
    if ((!this.c.isFinishing()) || (this.q))
      return;
    this.q = true;
    if (this.d != null)
    {
      int i1 = this.n;
      this.d.a(i1);
      this.l.removeView(this.d.b());
      if (this.e == null)
        break label167;
      this.d.a(this.e.d);
      this.d.a(false);
      this.e.c.addView(this.d.b(), this.e.a, this.e.b);
      this.e = null;
    }
    while (true)
    {
      this.d = null;
      if ((this.a == null) || (this.a.d == null))
        break;
      this.a.d.d_();
      return;
      label167: if (this.c.getApplicationContext() == null)
        continue;
      this.d.a(this.c.getApplicationContext());
    }
  }

  private void p()
  {
    this.d.d();
  }

  public final void a()
  {
    this.n = 2;
    this.c.finish();
  }

  public final void a(int paramInt)
  {
    this.c.setRequestedOrientation(paramInt);
  }

  public final void a(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null)
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    this.j = bool;
    do
    {
      try
      {
        this.a = AdOverlayInfoParcel.a(this.c.getIntent());
        if (this.a == null)
          throw new m("Could not get info for ad overlay.");
      }
      catch (m localm)
      {
        hc.d(localm.getMessage());
        this.n = 3;
        this.c.finish();
        return;
      }
      if (this.a.n.d > 7500000)
        this.n = 3;
      if (this.c.getIntent() != null)
        this.r = this.c.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
      if (this.a.q != null);
      for (this.k = this.a.q.b; ; this.k = false)
      {
        au localau = aD.ac;
        if ((((Boolean)P.n().a(localau)).booleanValue()) && (this.k) && (this.a.q.d != null))
          new p(this, 0).g();
        if (paramBundle == null)
        {
          if ((this.a.d != null) && (this.r))
            this.a.d.e_();
          if ((this.a.l != 1) && (this.a.c != null))
            this.a.c.e();
        }
        this.l = new n(this.c, this.a.p);
        this.l.setId(1000);
        switch (this.a.l)
        {
        default:
          throw new m("Could not determine ad overlay type.");
        case 1:
        case 2:
        case 3:
        case 4:
        }
      }
      b(false);
      return;
      this.e = new o(this.a.e);
      b(false);
      return;
      b(true);
      return;
      if (!this.j)
        continue;
      this.n = 3;
      this.c.finish();
      return;
    }
    while (P.b().a(this.c, this.a.b, this.a.j));
    this.n = 3;
    this.c.finish();
  }

  public final void a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.h = new FrameLayout(this.c);
    this.h.setBackgroundColor(-16777216);
    this.h.addView(paramView, -1, -1);
    this.c.setContentView(this.h);
    this.p = true;
    this.i = paramCustomViewCallback;
    this.g = true;
  }

  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f != null)
      this.f.a(paramBoolean1, paramBoolean2);
  }

  public final void b()
  {
    if ((this.a != null) && (this.g))
      a(this.a.k);
    if (this.h != null)
    {
      this.c.setContentView(this.l);
      this.p = true;
      this.h.removeAllViews();
      this.h = null;
    }
    if (this.i != null)
    {
      this.i.onCustomViewHidden();
      this.i = null;
    }
    this.g = false;
  }

  public final void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.j);
  }

  public final void c()
  {
    this.n = 1;
    this.c.finish();
  }

  public final void d()
  {
    this.n = 0;
  }

  public final boolean e()
  {
    int i1 = 1;
    this.n = 0;
    if (this.d == null);
    while (true)
    {
      return i1;
      if (this.d.t());
      while (i1 == 0)
      {
        this.d.a("onbackblocked", Collections.emptyMap());
        return i1;
        i1 = 0;
      }
    }
  }

  public final void f()
  {
  }

  public final void g()
  {
  }

  public final void h()
  {
    if ((this.a != null) && (this.a.l == 4))
    {
      if (!this.j)
        break label91;
      this.n = 3;
      this.c.finish();
    }
    while (true)
    {
      if (this.a.d != null)
        this.a.d.g_();
      if ((this.d == null) || (this.d.r()))
        break;
      P.g();
      hx.b(this.d);
      return;
      label91: this.j = true;
    }
    hc.d("The webview does not exit. Ignoring action.");
  }

  public final void i()
  {
    b();
    if (this.a.d != null)
      this.a.d.f_();
    if ((this.d != null) && ((!this.c.isFinishing()) || (this.e == null)))
    {
      P.g();
      hx.a(this.d);
    }
    o();
  }

  public final void j()
  {
    o();
  }

  public final void k()
  {
    if (this.d != null)
      this.l.removeView(this.d.b());
    o();
  }

  public final void l()
  {
    this.p = true;
  }

  public final void m()
  {
    this.l.removeView(this.f);
    a(true);
  }

  public final void n()
  {
    if (this.m)
    {
      this.m = false;
      p();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.k
 * JD-Core Version:    0.6.0
 */