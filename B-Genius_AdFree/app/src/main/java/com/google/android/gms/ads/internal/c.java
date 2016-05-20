package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.app.w;
import android.util.DisplayMetrics;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.W;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.g;
import com.google.android.gms.ads.internal.purchase.h;
import com.google.android.gms.ads.internal.purchase.m;
import com.google.android.gms.ads.internal.purchase.n;
import com.google.android.gms.ads.internal.request.C;
import com.google.android.gms.ads.internal.request.CapabilityParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.ad;
import com.google.android.gms.b.ag;
import com.google.android.gms.b.cc;
import com.google.android.gms.b.dV;
import com.google.android.gms.b.dW;
import com.google.android.gms.b.dX;
import com.google.android.gms.b.dY;
import com.google.android.gms.b.ee;
import com.google.android.gms.b.el;
import com.google.android.gms.b.eo;
import com.google.android.gms.b.fF;
import com.google.android.gms.b.fm;
import com.google.android.gms.b.ft;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.gU;
import com.google.android.gms.b.gY;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hn;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hx;
import com.google.android.gms.b.y;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class c extends b
  implements t, m, cc, dX
{
  protected final el h;
  private final Messenger i;
  private transient boolean j;

  public c(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    this(new Q(paramContext, paramAdSizeParcel, paramString, paramVersionInfoParcel), paramel, null, paramk);
  }

  private c(Q paramQ, el paramel, M paramM, k paramk)
  {
    super(paramQ, null, paramk);
    this.h = paramel;
    this.i = new Messenger(new fm(this.d.c));
    this.j = false;
  }

  private com.google.android.gms.ads.internal.request.a a(AdRequestParcel paramAdRequestParcel, Bundle paramBundle)
  {
    ApplicationInfo localApplicationInfo = this.d.c.getApplicationInfo();
    PackageInfo localPackageInfo1;
    DisplayMetrics localDisplayMetrics;
    Bundle localBundle1;
    String str1;
    String str2;
    long l1;
    String str3;
    Bundle localBundle2;
    ArrayList localArrayList;
    try
    {
      PackageInfo localPackageInfo2 = this.d.c.getPackageManager().getPackageInfo(localApplicationInfo.packageName, 0);
      localPackageInfo1 = localPackageInfo2;
      localDisplayMetrics = this.d.c.getResources().getDisplayMetrics();
      R localR = this.d.f;
      localBundle1 = null;
      if (localR != null)
      {
        ViewParent localViewParent = this.d.f.getParent();
        localBundle1 = null;
        if (localViewParent != null)
        {
          int[] arrayOfInt = new int[2];
          this.d.f.getLocationOnScreen(arrayOfInt);
          int i2 = arrayOfInt[0];
          int i3 = arrayOfInt[1];
          int i4 = this.d.f.getWidth();
          int i5 = this.d.f.getHeight();
          boolean bool4 = this.d.f.isShown();
          int i6 = 0;
          if (bool4)
          {
            int i7 = i2 + i4;
            i6 = 0;
            if (i7 > 0)
            {
              int i8 = i3 + i5;
              i6 = 0;
              if (i8 > 0)
              {
                int i9 = localDisplayMetrics.widthPixels;
                i6 = 0;
                if (i2 <= i9)
                {
                  int i10 = localDisplayMetrics.heightPixels;
                  i6 = 0;
                  if (i3 <= i10)
                    i6 = 1;
                }
              }
            }
          }
          localBundle1 = new Bundle(5);
          localBundle1.putInt("x", i2);
          localBundle1.putInt("y", i3);
          localBundle1.putInt("width", i4);
          localBundle1.putInt("height", i5);
          localBundle1.putInt("visible", i6);
        }
      }
      str1 = P.h().c();
      this.d.l = new gU(str1, this.d.b);
      this.d.l.a(paramAdRequestParcel);
      str2 = P.e().a(this.d.c, this.d.f, this.d.i);
      l1 = 0L;
      if (this.d.p == null);
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      try
      {
        long l2 = this.d.p.a();
        l1 = l2;
        str3 = UUID.randomUUID().toString();
        localBundle2 = P.h().a(this.d.c, this, str1);
        localArrayList = new ArrayList();
        int k = 0;
        while (k < this.d.v.size())
        {
          localArrayList.add(this.d.v.b(k));
          k++;
          continue;
          localNameNotFoundException = localNameNotFoundException;
          localPackageInfo1 = null;
        }
      }
      catch (RemoteException localRemoteException)
      {
        while (true)
          hc.d("Cannot get correlation id, default to 0.");
      }
    }
    boolean bool1;
    if (this.d.q != null)
    {
      bool1 = true;
      if ((this.d.r == null) || (!P.h().m()))
        break label747;
    }
    label747: for (boolean bool2 = true; ; bool2 = false)
    {
      AdSizeParcel localAdSizeParcel = this.d.i;
      String str4 = this.d.b;
      String str5 = P.h().a();
      VersionInfoParcel localVersionInfoParcel = this.d.e;
      List localList1 = this.d.z;
      boolean bool3 = P.h().g();
      Messenger localMessenger = this.i;
      int m = localDisplayMetrics.widthPixels;
      int n = localDisplayMetrics.heightPixels;
      float f1 = localDisplayMetrics.density;
      List localList2 = aD.a();
      String str6 = this.d.a;
      NativeAdOptionsParcel localNativeAdOptionsParcel = this.d.w;
      CapabilityParcel localCapabilityParcel = new CapabilityParcel(bool1, bool2, false);
      String str7 = this.d.f();
      P.e();
      float f2 = hu.d();
      P.e();
      int i1 = hu.i(this.d.c);
      P.e();
      return new com.google.android.gms.ads.internal.request.a(localBundle1, paramAdRequestParcel, localAdSizeParcel, str4, localApplicationInfo, localPackageInfo1, str1, str5, localVersionInfoParcel, localBundle2, localList1, localArrayList, paramBundle, bool3, localMessenger, m, n, f1, str2, l1, str3, localList2, str6, localNativeAdOptionsParcel, localCapabilityParcel, str7, f2, i1, hu.b(this.d.f));
      bool1 = false;
      break;
    }
  }

  public final void a(fF paramfF, String paramString)
  {
    w.b("setPlayStorePurchaseParams must be called on the main UI thread.");
    this.d.A = new n(paramString);
    this.d.r = paramfF;
    if ((!P.h().f()) && (paramfF != null))
      new com.google.android.gms.ads.internal.purchase.c(this.d.c, this.d.r, this.d.A).g();
  }

  public void a(ft paramft)
  {
    w.b("setInAppPurchaseListener must be called on the main UI thread.");
    this.d.q = paramft;
  }

  protected void a(gS paramgS, boolean paramBoolean)
  {
    if (paramgS == null)
      hc.d("Ad state was null when trying to ping impression URLs.");
    do
    {
      return;
      super.c(paramgS);
      if ((paramgS.q == null) || (paramgS.q.d == null))
        continue;
      P.r();
      ee.a(this.d.c, this.d.e.b, paramgS, this.d.b, paramBoolean, paramgS.q.d);
    }
    while ((paramgS.n == null) || (paramgS.n.g == null));
    P.r();
    ee.a(this.d.c, this.d.e.b, paramgS, this.d.b, paramBoolean, paramgS.n.g);
  }

  public final void a(String paramString, ArrayList paramArrayList)
  {
    com.google.android.gms.ads.internal.purchase.e locale = new com.google.android.gms.ads.internal.purchase.e(paramString, paramArrayList, this.d.c, this.d.e.b);
    if (this.d.q == null)
    {
      hc.d("InAppPurchaseListener is not set. Try to launch default purchase flow.");
      x.a();
      if (!com.google.android.gms.ads.internal.util.client.a.b(this.d.c))
      {
        hc.d("Google Play Service unavailable, cannot launch default purchase flow.");
        return;
      }
      if (this.d.r == null)
      {
        hc.d("PlayStorePurchaseListener is not set.");
        return;
      }
      if (this.d.A == null)
      {
        hc.d("PlayStorePurchaseVerifier is not initialized.");
        return;
      }
      if (this.d.E)
      {
        hc.d("An in-app purchase request is already in progress, abort");
        return;
      }
      this.d.E = true;
      try
      {
        if (!this.d.r.a(paramString))
        {
          this.d.E = false;
          return;
        }
      }
      catch (RemoteException localRemoteException2)
      {
        hc.d("Could not start In-App purchase.");
        this.d.E = false;
        return;
      }
      P.o();
      Context localContext = this.d.c;
      boolean bool = this.d.e.e;
      GInAppPurchaseManagerInfoParcel localGInAppPurchaseManagerInfoParcel = new GInAppPurchaseManagerInfoParcel(this.d.c, this.d.A, locale, this);
      Intent localIntent = new Intent();
      localIntent.setClassName(localContext, "com.google.android.gms.ads.purchase.InAppPurchaseActivity");
      localIntent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", bool);
      GInAppPurchaseManagerInfoParcel.a(localIntent, localGInAppPurchaseManagerInfoParcel);
      P.e();
      hu.a(localContext, localIntent);
      return;
    }
    try
    {
      this.d.q.a(locale);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      hc.d("Could not start In-App purchase.");
    }
  }

  public final void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, g paramg)
  {
    try
    {
      if (this.d.r != null)
        this.d.r.a(new h(this.d.c, paramString, paramBoolean, paramInt, paramIntent, paramg));
      hu.a.postDelayed(new d(this, paramIntent), 500L);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hc.d("Fail to invoke PlayStorePurchaseListener.");
    }
  }

  public boolean a(AdRequestParcel paramAdRequestParcel, aR paramaR)
  {
    if (!q())
      return false;
    ag localag = P.h().a(this.d.c);
    Bundle localBundle = null;
    String str1;
    String str2;
    if (localag != null)
    {
      if (localag.d())
        localag.c();
      ad localad = localag.b();
      if (localad == null)
        break label312;
      str1 = localad.b();
      str2 = localad.c();
      hc.a("In AdManager: loadAd, " + localad.toString());
      if (str1 != null)
        P.h().a(str1);
      localBundle = null;
      if (str1 != null)
      {
        localBundle = new Bundle(1);
        localBundle.putString("fingerprint", str1);
        if (!str1.equals(str2))
          localBundle.putString("v_fp", str2);
      }
    }
    this.c.a();
    this.d.D = 0;
    com.google.android.gms.ads.internal.request.a locala = a(paramAdRequestParcel, localBundle);
    paramaR.a("seq_num", locala.g);
    paramaR.a("request_id", locala.v);
    paramaR.a("session_id", locala.h);
    if (locala.f != null)
      paramaR.a("app_version", String.valueOf(locala.f.versionCode));
    Q localQ = this.d;
    P.a();
    Context localContext = this.d.c;
    y localy = this.d.d;
    if (locala.b.c.getBundle("sdk_less_server_data") != null);
    for (Object localObject = new C(localContext, locala, this); ; localObject = new com.google.android.gms.ads.internal.request.e(localContext, locala, localy, this))
    {
      ((ha)localObject).g();
      localQ.g = ((ha)localObject);
      return true;
      label312: str1 = P.h().i();
      str2 = null;
      break;
    }
  }

  protected boolean a(AdRequestParcel paramAdRequestParcel, gS paramgS, boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.d.d()))
    {
      if (paramgS.h <= 0L)
        break label43;
      this.c.a(paramAdRequestParcel, paramgS.h);
    }
    while (true)
    {
      return this.c.d();
      label43: if ((paramgS.q != null) && (paramgS.q.g > 0L))
      {
        this.c.a(paramAdRequestParcel, paramgS.q.g);
        continue;
      }
      if ((paramgS.m) || (paramgS.d != 2))
        continue;
      this.c.a(paramAdRequestParcel);
    }
  }

  final boolean a(gS paramgS)
  {
    boolean bool = false;
    AdRequestParcel localAdRequestParcel;
    if (this.e != null)
    {
      localAdRequestParcel = this.e;
      this.e = null;
    }
    while (true)
    {
      return a(localAdRequestParcel, paramgS, bool);
      localAdRequestParcel = paramgS.a;
      Bundle localBundle = localAdRequestParcel.c;
      bool = false;
      if (localBundle == null)
        continue;
      bool = localAdRequestParcel.c.getBoolean("_noRefresh", false);
    }
  }

  protected boolean a(gS paramgS1, gS paramgS2)
  {
    if ((paramgS1 != null) && (paramgS1.r != null))
      paramgS1.r.a(null);
    if (paramgS2.r != null)
      paramgS2.r.a(this);
    int m;
    int k;
    if (paramgS2.q != null)
    {
      m = paramgS2.q.j;
      k = paramgS2.q.k;
    }
    while (true)
    {
      this.d.B.a(m, k);
      return true;
      k = 0;
      m = 0;
    }
  }

  public final void b(gS paramgS)
  {
    super.b(paramgS);
    if ((paramgS.d == 3) && (paramgS.q != null) && (paramgS.q.e != null))
    {
      hc.a("Pinging no fill URLs.");
      P.r();
      ee.a(this.d.c, this.d.e.b, paramgS, this.d.b, false, paramgS.q.e);
    }
  }

  protected final boolean b(AdRequestParcel paramAdRequestParcel)
  {
    return (super.b(paramAdRequestParcel)) && (!this.j);
  }

  public void c_()
  {
    w.b("resume must be called on the main UI thread.");
    if ((this.d.j != null) && (this.d.j.b != null) && (this.d.d()))
    {
      P.g();
      hx.b(this.d.j.b);
    }
    if ((this.d.j != null) && (this.d.j.o != null));
    try
    {
      this.d.j.o.e();
      this.c.c();
      this.f.e(this.d.j);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hc.d("Could not resume mediation adapter.");
    }
  }

  public void d()
  {
    w.b("pause must be called on the main UI thread.");
    if ((this.d.j != null) && (this.d.j.b != null) && (this.d.d()))
    {
      P.g();
      hx.a(this.d.j.b);
    }
    if ((this.d.j != null) && (this.d.j.o != null));
    try
    {
      this.d.j.o.d();
      this.f.d(this.d.j);
      this.c.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        hc.d("Could not pause mediation adapter.");
    }
  }

  public final void d_()
  {
    this.f.b(this.d.j);
    this.j = false;
    m();
    this.d.l.c();
  }

  public final void e()
  {
    if (this.d.j == null)
    {
      hc.d("Ad state was null when trying to ping click URLs.");
      return;
    }
    if ((this.d.j.q != null) && (this.d.j.q.c != null))
    {
      P.r();
      ee.a(this.d.c, this.d.e.b, this.d.j, this.d.b, false, this.d.j.q.c);
    }
    if ((this.d.j.n != null) && (this.d.j.n.f != null))
    {
      P.r();
      ee.a(this.d.c, this.d.e.b, this.d.j, this.d.b, false, this.d.j.n.f);
    }
    super.e();
  }

  public void e_()
  {
    this.j = true;
    n();
  }

  public void f()
  {
    throw new IllegalStateException("showInterstitial is not supported for current ad type");
  }

  public final void f_()
  {
    this.f.d(this.d.j);
  }

  public final void g_()
  {
    this.f.e(this.d.j);
  }

  public final String j()
  {
    if (this.d.j == null)
      return null;
    return this.d.j.p;
  }

  protected boolean q()
  {
    int k = 1;
    P.e();
    if (hu.a(this.d.c.getPackageManager(), this.d.c.getPackageName(), "android.permission.INTERNET"))
    {
      P.e();
      if (hu.a(this.d.c));
    }
    else
    {
      k = 0;
    }
    return k;
  }

  public final void r()
  {
    e();
  }

  public final void s()
  {
    d_();
  }

  public final void t()
  {
    l();
  }

  public final void u()
  {
    e_();
  }

  public final void v()
  {
    if (this.d.j != null)
      hc.d("Mediation adapter " + this.d.j.p + " refreshed, but mediation adapters should never refresh.");
    a(this.d.j, true);
    o();
  }

  public final void w()
  {
    a(this.d.j, false);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.c
 * JD-Core Version:    0.6.0
 */