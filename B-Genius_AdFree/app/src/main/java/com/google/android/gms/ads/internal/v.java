package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.r;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.R;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.au;
import com.google.android.gms.b.ce;
import com.google.android.gms.b.ck;
import com.google.android.gms.b.cl;
import com.google.android.gms.b.el;
import com.google.android.gms.b.eo;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hx;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import com.google.android.gms.b.iz;

public final class v extends e
  implements ce, cl
{
  private transient boolean i = false;
  private boolean j;
  private float k;
  private String l = "background" + hashCode() + ".png";

  public v(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramel, paramVersionInfoParcel, paramk);
  }

  private void a(Bundle paramBundle)
  {
    P.e().b(this.d.c, this.d.e.b, "gmob-apps", paramBundle, false);
  }

  protected final boolean B()
  {
    if (!(this.d.c instanceof Activity))
      return false;
    Window localWindow = ((Activity)this.d.c).getWindow();
    if ((localWindow == null) || (localWindow.getDecorView() == null))
      return false;
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    return (localRect1.bottom != 0) && (localRect2.bottom != 0) && (localRect1.top == localRect2.top);
  }

  public final void C()
  {
    new w(this, this.l).g();
    if (this.d.d())
    {
      this.d.b();
      this.d.j = null;
      this.d.F = false;
      this.i = false;
    }
  }

  public final void D()
  {
    if ((this.d.j != null) && (this.d.j.u != null))
    {
      P.e();
      hu.a(this.d.c, this.d.e.b, this.d.j.u);
    }
    p();
  }

  protected final is a(gT paramgT, l paraml)
  {
    P.f();
    is localis = iz.a(this.d.c, this.d.i, false, false, this.d.d, this.d.e, this.a, this.g);
    it localit = localis.l();
    au localau = aD.H;
    localit.a(this, null, this, this, ((Boolean)P.n().a(localau)).booleanValue(), this, this, paraml, null);
    a(localis);
    localis.b(paramgT.a.w);
    localis.l().a("/reward", new ck(this));
    return localis;
  }

  public final void a(boolean paramBoolean, float paramFloat)
  {
    this.j = paramBoolean;
    this.k = paramFloat;
  }

  public final boolean a(AdRequestParcel paramAdRequestParcel, aR paramaR)
  {
    if (this.d.j != null)
    {
      hc.d("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.a(paramAdRequestParcel, paramaR);
  }

  protected final boolean a(AdRequestParcel paramAdRequestParcel, gS paramgS, boolean paramBoolean)
  {
    if ((this.d.d()) && (paramgS.b != null))
    {
      P.g();
      hx.a(paramgS.b);
    }
    return this.c.d();
  }

  public final boolean a(gS paramgS1, gS paramgS2)
  {
    if (!super.a(paramgS1, paramgS2))
      return false;
    if ((!this.d.d()) && (this.d.C != null) && (paramgS2.j != null))
      this.f.a(this.d.i, paramgS2, this.d.C);
    return true;
  }

  public final void b(RewardItemParcel paramRewardItemParcel)
  {
    if (this.d.j != null)
    {
      if (this.d.j.v != null)
      {
        P.e();
        hu.a(this.d.c, this.d.e.b, this.d.j.v);
      }
      if (this.d.j.t != null)
        paramRewardItemParcel = this.d.j.t;
    }
    a(paramRewardItemParcel);
  }

  public final void b(boolean paramBoolean)
  {
    this.d.F = paramBoolean;
  }

  public final void e_()
  {
    w();
    super.e_();
  }

  public final void f()
  {
    android.support.v4.app.w.b("showInterstitial must be called on the main UI thread.");
    if (this.d.j == null)
    {
      hc.d("The interstitial has not loaded.");
      return;
    }
    au localau1 = aD.U;
    if (((Boolean)P.n().a(localau1)).booleanValue())
      if (this.d.c.getApplicationContext() == null)
        break label232;
    label232: for (String str = this.d.c.getApplicationContext().getPackageName(); ; str = this.d.c.getPackageName())
    {
      if (!this.i)
      {
        hc.d("It is not recommended to show an interstitial before onAdLoaded completes.");
        Bundle localBundle2 = new Bundle();
        localBundle2.putString("appid", str);
        localBundle2.putString("action", "show_interstitial_before_load_finish");
        a(localBundle2);
      }
      if (!P.e().f(this.d.c))
      {
        hc.d("It is not recommended to show an interstitial when app is not in foreground.");
        Bundle localBundle1 = new Bundle();
        localBundle1.putString("appid", str);
        localBundle1.putString("action", "show_interstitial_app_not_in_foreground");
        a(localBundle1);
      }
      if (this.d.e())
        break;
      if (!this.d.j.m)
        break label247;
      try
      {
        this.d.j.o.b();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        hc.c("Could not show interstitial.", localRemoteException);
        C();
        return;
      }
    }
    label247: if (this.d.j.b == null)
    {
      hc.d("The interstitial failed to load.");
      return;
    }
    if (this.d.j.b.p())
    {
      hc.d("The interstitial is already showing.");
      return;
    }
    this.d.j.b.a(true);
    if (this.d.j.j != null)
      this.f.a(this.d.i, this.d.j);
    if (this.d.F)
      P.e();
    for (Bitmap localBitmap = hu.g(this.d.c); ; localBitmap = null)
    {
      au localau2 = aD.ac;
      if ((!((Boolean)P.n().a(localau2)).booleanValue()) || (localBitmap == null))
        break;
      new x(this, localBitmap, this.l).g();
      return;
    }
    InterstitialAdParameterParcel localInterstitialAdParameterParcel = new InterstitialAdParameterParcel(this.d.F, B(), null, false, 0.0F);
    int m = this.d.j.b.q();
    if (m == -1)
      m = this.d.j.g;
    AdOverlayInfoParcel localAdOverlayInfoParcel = new AdOverlayInfoParcel(this, this, this, this.d.j.b, m, this.d.e, this.d.j.y, localInterstitialAdParameterParcel);
    P.c();
    r.a(this.d.c, localAdOverlayInfoParcel, true);
  }

  protected final void m()
  {
    C();
    super.m();
  }

  protected final void o()
  {
    super.o();
    this.i = true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.v
 * JD-Core Version:    0.6.0
 */