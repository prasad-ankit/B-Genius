package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.support.v4.app.w;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.B;
import com.google.android.gms.ads.internal.client.O;
import com.google.android.gms.ads.internal.client.T;
import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.ads.internal.client.W;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.client.y;
import com.google.android.gms.ads.internal.overlay.C;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.a.g;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.aG;
import com.google.android.gms.b.aN;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.aW;
import com.google.android.gms.b.au;
import com.google.android.gms.b.bG;
import com.google.android.gms.b.fF;
import com.google.android.gms.b.fU;
import com.google.android.gms.b.ft;
import com.google.android.gms.b.gO;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.gU;
import com.google.android.gms.b.gX;
import com.google.android.gms.b.gY;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hx;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import java.util.HashSet;

public abstract class b extends O
  implements com.google.android.gms.ads.internal.client.a, C, com.google.android.gms.ads.internal.request.d, bG, fU, gX
{
  protected aR a;
  protected boolean b = false;
  protected final M c;
  protected final Q d;
  protected transient AdRequestParcel e;
  protected final com.google.android.gms.b.R f;
  protected final k g;
  private aN h;
  private aN i;

  b(Q paramQ, M paramM, k paramk)
  {
    this.d = paramQ;
    if (paramM != null);
    while (true)
    {
      this.c = paramM;
      this.g = paramk;
      P.e().b(this.d.c);
      P.h().a(this.d.c, this.d.e);
      this.f = P.h().k();
      return;
      paramM = new M(this);
    }
  }

  private static long b(String paramString)
  {
    int j = paramString.indexOf("ufe");
    int k = paramString.indexOf(',', j);
    if (k == -1)
      k = paramString.length();
    int m = j + 4;
    try
    {
      long l = Long.parseLong(paramString.substring(m, k));
      return l;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      hc.d("Invalid index for Url fetch time in CSI latency info.");
      return -1L;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        hc.d("Cannot find valid format of Url fetch time in CSI latency info.");
    }
  }

  public final com.google.android.gms.a.a a()
  {
    w.b("getAdFrame must be called on the main UI thread.");
    return com.google.android.gms.a.d.a(this.d.f);
  }

  protected final void a(int paramInt)
  {
    hc.d("Failed to load ad: " + paramInt);
    this.b = false;
    if (this.d.n != null);
    try
    {
      this.d.n.a(paramInt);
      if (this.d.y == null);
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        this.d.y.a(paramInt);
        return;
        localRemoteException2 = localRemoteException2;
        hc.c("Could not call AdListener.onAdFailedToLoad().", localRemoteException2);
      }
      catch (RemoteException localRemoteException1)
      {
        hc.c("Could not call RewardedVideoAdListener.onRewardedVideoAdFailedToLoad().", localRemoteException1);
      }
    }
  }

  protected final void a(View paramView)
  {
    this.d.f.addView(paramView, P.g().d());
  }

  public final void a(AdSizeParcel paramAdSizeParcel)
  {
    w.b("setAdSize must be called on the main UI thread.");
    this.d.i = paramAdSizeParcel;
    if ((this.d.j != null) && (this.d.j.b != null) && (this.d.D == 0))
      this.d.j.b.a(paramAdSizeParcel);
    if (this.d.f == null)
      return;
    if (this.d.f.getChildCount() > 1)
      this.d.f.removeView(this.d.f.getNextView());
    this.d.f.setMinimumWidth(paramAdSizeParcel.g);
    this.d.f.setMinimumHeight(paramAdSizeParcel.d);
    this.d.f.requestLayout();
  }

  public final void a(B paramB)
  {
    w.b("setAdListener must be called on the main UI thread.");
    this.d.n = paramB;
  }

  public final void a(T paramT)
  {
    w.b("setAppEventListener must be called on the main UI thread.");
    this.d.o = paramT;
  }

  public final void a(W paramW)
  {
    w.b("setCorrelationIdProvider must be called on the main UI thread");
    this.d.p = paramW;
  }

  public final void a(y paramy)
  {
    w.b("setAdListener must be called on the main UI thread.");
    this.d.m = paramy;
  }

  public final void a(g paramg)
  {
    w.b("setRewardedVideoAdListener can only be called from the UI thread.");
    this.d.y = paramg;
  }

  protected final void a(RewardItemParcel paramRewardItemParcel)
  {
    if (this.d.y == null)
      return;
    String str = "";
    int j = 0;
    if (paramRewardItemParcel != null);
    try
    {
      str = paramRewardItemParcel.b;
      j = paramRewardItemParcel.c;
      this.d.y.a(new gO(str, j));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call RewardedVideoAdListener.onRewarded().", localRemoteException);
    }
  }

  public void a(aW paramaW)
  {
    throw new IllegalStateException("setOnCustomRenderedAdLoadedListener is not supported for current ad type");
  }

  public void a(fF paramfF, String paramString)
  {
    throw new IllegalStateException("setPlayStorePurchaseParams is not supported for current ad type");
  }

  public void a(ft paramft)
  {
    throw new IllegalStateException("setInAppPurchaseListener is not supported for current ad type");
  }

  public final void a(gT paramgT)
  {
    if ((paramgT.b.n != -1L) && (!TextUtils.isEmpty(paramgT.b.z)))
    {
      long l = b(paramgT.b.z);
      if (l != -1L)
      {
        aN localaN = this.a.a(l + paramgT.b.n);
        this.a.a(localaN, new String[] { "stc" });
      }
    }
    this.a.a(paramgT.b.z);
    this.a.a(this.h, new String[] { "arf" });
    this.i = this.a.a();
    this.a.a("gqi", paramgT.b.A);
    this.d.g = null;
    this.d.k = paramgT;
    a(paramgT, this.a);
  }

  protected abstract void a(gT paramgT, aR paramaR);

  public final void a(String paramString)
  {
    w.b("setUserId must be called on the main UI thread.");
  }

  public final void a(String paramString1, String paramString2)
  {
    if (this.d.o != null);
    try
    {
      this.d.o.a(paramString1, paramString2);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call the AppEventListener.", localRemoteException);
    }
  }

  public final void a(HashSet paramHashSet)
  {
    this.d.a(paramHashSet);
  }

  public void a(boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
  }

  public boolean a(AdRequestParcel paramAdRequestParcel)
  {
    w.b("loadAd must be called on the main UI thread.");
    if ((com.google.android.gms.common.q.g(this.d.c)) && (paramAdRequestParcel.k != null))
      paramAdRequestParcel = new com.google.android.gms.ads.internal.client.q(paramAdRequestParcel).a(null).a();
    if ((this.d.g != null) || (this.d.h != null))
    {
      if (this.e != null)
        hc.d("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
      while (true)
      {
        this.e = paramAdRequestParcel;
        return false;
        hc.d("Loading already in progress, saving this object for future refreshes.");
      }
    }
    hc.c("Starting ad request.");
    au localau = aD.u;
    this.a = new aR(((Boolean)P.n().a(localau)).booleanValue(), "load_ad", this.d.i.b);
    this.h = new aN(-1L, null, null);
    this.i = new aN(-1L, null, null);
    this.h = this.a.a();
    if (!paramAdRequestParcel.f)
      hc.c("Use AdRequest.Builder.addTestDevice(\"" + x.a().a(this.d.c) + "\") to get test ads on this device.");
    this.b = a(paramAdRequestParcel, this.a);
    return this.b;
  }

  protected abstract boolean a(AdRequestParcel paramAdRequestParcel, aR paramaR);

  boolean a(gS paramgS)
  {
    return false;
  }

  protected abstract boolean a(gS paramgS1, gS paramgS2);

  public final void b()
  {
    w.b("destroy must be called on the main UI thread.");
    this.c.a();
    this.f.c(this.d.j);
    Q localQ = this.d;
    if (localQ.f != null)
      localQ.f.b();
    localQ.n = null;
    localQ.o = null;
    localQ.r = null;
    localQ.q = null;
    localQ.x = null;
    localQ.p = null;
    localQ.a(false);
    if (localQ.f != null)
      localQ.f.removeAllViews();
    localQ.b();
    localQ.c();
    localQ.j = null;
  }

  public void b(gS paramgS)
  {
    this.a.a(this.i, new String[] { "awr" });
    this.d.h = null;
    if ((paramgS.d != -2) && (paramgS.d != 3))
      P.h().a(this.d.a());
    if (paramgS.d == -1)
      this.b = false;
    do
    {
      return;
      if (a(paramgS))
        hc.a("Ad refresh scheduled.");
      if (paramgS.d != -2)
      {
        a(paramgS.d);
        return;
      }
      if (this.d.B == null)
        this.d.B = new gY(this.d.b);
      this.f.b(this.d.j);
    }
    while (!a(this.d.j, paramgS));
    this.d.j = paramgS;
    Q localQ = this.d;
    localQ.l.a(localQ.j.w);
    localQ.l.b(localQ.j.x);
    localQ.l.a(localQ.i.e);
    localQ.l.b(localQ.j.m);
    aR localaR1 = this.a;
    String str1;
    label259: String str2;
    label293: aR localaR3;
    if (this.d.j.a())
    {
      str1 = "1";
      localaR1.a("is_mraid", str1);
      aR localaR2 = this.a;
      if (!this.d.j.m)
        break label444;
      str2 = "1";
      localaR2.a("is_mediation", str2);
      if ((this.d.j.b != null) && (this.d.j.b.l() != null))
      {
        localaR3 = this.a;
        if (!this.d.j.b.l().c())
          break label452;
      }
    }
    label444: label452: for (String str3 = "1"; ; str3 = "0")
    {
      localaR3.a("is_video", str3);
      this.a.a(this.h, new String[] { "ttc" });
      if (P.h().e() != null)
        P.h().e().a(this.a);
      if (!this.d.d())
        break;
      o();
      return;
      str1 = "0";
      break label259;
      str2 = "0";
      break label293;
    }
  }

  protected boolean b(AdRequestParcel paramAdRequestParcel)
  {
    ViewParent localViewParent = this.d.f.getParent();
    return ((localViewParent instanceof View)) && (((View)localViewParent).isShown()) && (P.e().a());
  }

  public final void c(AdRequestParcel paramAdRequestParcel)
  {
    if (b(paramAdRequestParcel))
    {
      a(paramAdRequestParcel);
      return;
    }
    hc.c("Ad is not visible. Not refreshing ad.");
    this.c.a(paramAdRequestParcel);
  }

  protected final void c(gS paramgS)
  {
    if (paramgS == null)
      hc.d("Ad state was null when trying to ping impression URLs.");
    do
    {
      return;
      hc.a("Pinging Impression URLs.");
      this.d.l.a();
    }
    while ((paramgS.e == null) || (paramgS.A));
    P.e();
    hu.a(this.d.c, this.d.e.b, paramgS.e);
    paramgS.A = true;
  }

  public final boolean c()
  {
    w.b("isLoaded must be called on the main UI thread.");
    return (this.d.g == null) && (this.d.h == null) && (this.d.j != null);
  }

  public void c_()
  {
    w.b("resume must be called on the main UI thread.");
  }

  public void d()
  {
    w.b("pause must be called on the main UI thread.");
  }

  public void e()
  {
    if (this.d.j == null)
      hc.d("Ad state was null when trying to ping click URLs.");
    do
    {
      return;
      hc.a("Pinging click URLs.");
      this.d.l.b();
      if (this.d.j.c == null)
        continue;
      P.e();
      hu.a(this.d.c, this.d.e.b, this.d.j.c);
    }
    while (this.d.m == null);
    try
    {
      this.d.m.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not notify onAdClicked event.", localRemoteException);
    }
  }

  public final void g()
  {
    w.b("stopLoading must be called on the main UI thread.");
    this.b = false;
    this.d.a(true);
  }

  public final void h()
  {
    w.b("recordManualImpression must be called on the main UI thread.");
    if (this.d.j == null)
      hc.d("Ad state was null when trying to ping manual tracking URLs.");
    do
    {
      return;
      hc.a("Pinging manual tracking URLs.");
    }
    while ((this.d.j.f == null) || (this.d.j.B));
    P.e();
    hu.a(this.d.c, this.d.e.b, this.d.j.f);
    this.d.j.B = true;
  }

  public final AdSizeParcel i()
  {
    w.b("getAdSize must be called on the main UI thread.");
    if (this.d.i == null)
      return null;
    return new ThinAdSizeParcel(this.d.i);
  }

  public final boolean k()
  {
    return this.b;
  }

  public final void l()
  {
    hc.c("Ad leaving application.");
    if (this.d.n != null);
    try
    {
      this.d.n.b();
      if (this.d.y == null);
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        this.d.y.e();
        return;
        localRemoteException2 = localRemoteException2;
        hc.c("Could not call AdListener.onAdLeftApplication().", localRemoteException2);
      }
      catch (RemoteException localRemoteException1)
      {
        hc.c("Could not call  RewardedVideoAdListener.onRewardedVideoAdLeftApplication().", localRemoteException1);
      }
    }
  }

  protected void m()
  {
    hc.c("Ad closing.");
    if (this.d.n != null);
    try
    {
      this.d.n.a();
      if (this.d.y == null);
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        this.d.y.d();
        return;
        localRemoteException2 = localRemoteException2;
        hc.c("Could not call AdListener.onAdClosed().", localRemoteException2);
      }
      catch (RemoteException localRemoteException1)
      {
        hc.c("Could not call RewardedVideoAdListener.onRewardedVideoAdClosed().", localRemoteException1);
      }
    }
  }

  protected final void n()
  {
    hc.c("Ad opening.");
    if (this.d.n != null);
    try
    {
      this.d.n.d();
      if (this.d.y == null);
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        this.d.y.b();
        return;
        localRemoteException2 = localRemoteException2;
        hc.c("Could not call AdListener.onAdOpened().", localRemoteException2);
      }
      catch (RemoteException localRemoteException1)
      {
        hc.c("Could not call RewardedVideoAdListener.onRewardedVideoAdOpened().", localRemoteException1);
      }
    }
  }

  protected void o()
  {
    hc.c("Ad finished loading.");
    this.b = false;
    if (this.d.n != null);
    try
    {
      this.d.n.c();
      if (this.d.y == null);
    }
    catch (RemoteException localRemoteException2)
    {
      try
      {
        this.d.y.a();
        return;
        localRemoteException2 = localRemoteException2;
        hc.c("Could not call AdListener.onAdLoaded().", localRemoteException2);
      }
      catch (RemoteException localRemoteException1)
      {
        hc.c("Could not call RewardedVideoAdListener.onRewardedVideoAdLoaded().", localRemoteException1);
      }
    }
  }

  protected final void p()
  {
    if (this.d.y == null)
      return;
    try
    {
      this.d.y.c();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Could not call RewardedVideoAdListener.onVideoStarted().", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.b
 * JD-Core Version:    0.6.0
 */