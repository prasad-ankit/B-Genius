package com.google.android.gms.ads.internal;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.RemoteException;
import android.support.v4.app.w;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import com.google.android.gms.b.G;
import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.dV;
import com.google.android.gms.b.eB;
import com.google.android.gms.b.el;
import com.google.android.gms.b.eo;
import com.google.android.gms.b.ey;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.gT;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.is;
import com.google.android.gms.b.it;
import java.util.List;

public final class n extends e
  implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener
{
  private boolean i;

  public n(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, el paramel, VersionInfoParcel paramVersionInfoParcel, k paramk)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramel, paramVersionInfoParcel, paramk);
  }

  private boolean b(gS paramgS1, gS paramgS2)
  {
    View localView2;
    if (paramgS2.m)
    {
      localView2 = f.a(paramgS2);
      if (localView2 == null)
      {
        hc.d("Could not get mediation view");
        return false;
      }
      View localView3 = this.d.f.getNextView();
      if (localView3 != null)
      {
        if ((localView3 instanceof is))
          ((is)localView3).destroy();
        this.d.f.removeView(localView3);
      }
      if (f.b(paramgS2));
    }
    while (true)
    {
      View localView1;
      try
      {
        a(localView2);
        if (this.d.f.getChildCount() <= 1)
          continue;
        this.d.f.showNext();
        if (paramgS1 == null)
          continue;
        localView1 = this.d.f.getNextView();
        if (!(localView1 instanceof is))
          break label276;
        ((is)localView1).a(this.d.c, this.d.i, this.a);
        this.d.c();
        this.d.f.setVisibility(0);
        return true;
      }
      catch (Throwable localThrowable)
      {
        hc.c("Could not add mediation view to view hierarchy.", localThrowable);
        return false;
      }
      if ((paramgS2.s == null) || (paramgS2.b == null))
        continue;
      paramgS2.b.a(paramgS2.s);
      this.d.f.removeAllViews();
      this.d.f.setMinimumWidth(paramgS2.s.g);
      this.d.f.setMinimumHeight(paramgS2.s.d);
      a(paramgS2.b.b());
      continue;
      label276: if (localView1 == null)
        continue;
      this.d.f.removeView(localView1);
    }
  }

  private void d(gS paramgS)
  {
    if (paramgS == null);
    do
      return;
    while ((paramgS.l) || (this.d.f == null));
    hu localhu = P.e();
    R localR = this.d.f;
    Context localContext1 = this.d.c;
    Context localContext2 = localContext1.getApplicationContext();
    if (localContext2 != null);
    for (PowerManager localPowerManager = (PowerManager)localContext2.getSystemService("power"); ; localPowerManager = null)
    {
      Object localObject = localContext1.getSystemService("keyguard");
      if ((localObject != null) && ((localObject instanceof KeyguardManager)));
      for (KeyguardManager localKeyguardManager = (KeyguardManager)localObject; (localhu.a(localR, localPowerManager, localKeyguardManager)) && (this.d.f.getGlobalVisibleRect(new Rect(), null)); localKeyguardManager = null)
      {
        a(paramgS, false);
        paramgS.l = true;
        return;
      }
      break;
    }
  }

  protected final is a(gT paramgT, l paraml)
  {
    AdSizeParcel localAdSizeParcel;
    if (this.d.i.j)
    {
      Q localQ = this.d;
      if (paramgT.b.B)
      {
        localAdSizeParcel = this.d.i;
        localQ.i = localAdSizeParcel;
      }
    }
    else
    {
      return super.a(paramgT, paraml);
    }
    String str = paramgT.b.m;
    String[] arrayOfString;
    if (str != null)
    {
      arrayOfString = str.split("[xX]");
      arrayOfString[0] = arrayOfString[0].trim();
      arrayOfString[1] = arrayOfString[1].trim();
    }
    for (com.google.android.gms.ads.f localf = new com.google.android.gms.ads.f(Integer.parseInt(arrayOfString[0]), Integer.parseInt(arrayOfString[1])); ; localf = this.d.i.c())
    {
      localAdSizeParcel = new AdSizeParcel(this.d.c, localf);
      break;
    }
  }

  protected final void a(gS paramgS, boolean paramBoolean)
  {
    super.a(paramgS, paramBoolean);
    p localp;
    is localis;
    View localView;
    if (f.b(paramgS))
    {
      localp = new p(this);
      if (f.b(paramgS))
      {
        localis = paramgS.b;
        localView = localis.b();
        if (localView != null)
          break label55;
        hc.d("AdWebView is null");
      }
    }
    return;
    label55: List localList;
    try
    {
      localList = paramgS.n.l;
      if ((localList == null) || (localList.isEmpty()))
      {
        hc.d("No template ids present in mediation response");
        return;
      }
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Error occurred while recording impression and registering for clicks", localRemoteException);
      return;
    }
    ey localey = paramgS.o.h();
    eB localeB = paramgS.o.i();
    if ((localList.contains("2")) && (localey != null))
    {
      localey.b(com.google.android.gms.a.d.a(localView));
      if (!localey.j())
        localey.i();
      localis.l().a("/nativeExpressViewClicked", f.a(localey, null, localp));
      return;
    }
    if ((localList.contains("1")) && (localeB != null))
    {
      localeB.b(com.google.android.gms.a.d.a(localView));
      if (!localeB.h())
        localeB.g();
      localis.l().a("/nativeExpressViewClicked", f.a(null, localeB, localp));
      return;
    }
    hc.d("No matching template id and mapper");
  }

  public final void a(boolean paramBoolean)
  {
    w.b("setManualImpressionsEnabled must be called from the main thread.");
    this.i = paramBoolean;
  }

  public final boolean a(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.h == this.i)
      return super.a(paramAdRequestParcel);
    int j = paramAdRequestParcel.a;
    long l = paramAdRequestParcel.b;
    Bundle localBundle = paramAdRequestParcel.c;
    int k = paramAdRequestParcel.d;
    List localList = paramAdRequestParcel.e;
    boolean bool1 = paramAdRequestParcel.f;
    int m = paramAdRequestParcel.g;
    if ((paramAdRequestParcel.h) || (this.i));
    for (boolean bool2 = true; ; bool2 = false)
    {
      paramAdRequestParcel = new AdRequestParcel(j, l, localBundle, k, localList, bool1, m, bool2, paramAdRequestParcel.i, paramAdRequestParcel.j, paramAdRequestParcel.k, paramAdRequestParcel.l, paramAdRequestParcel.m, paramAdRequestParcel.n, paramAdRequestParcel.o, paramAdRequestParcel.p, paramAdRequestParcel.q, paramAdRequestParcel.r);
      break;
    }
  }

  public final boolean a(gS paramgS1, gS paramgS2)
  {
    if (!super.a(paramgS1, paramgS2))
      return false;
    if ((this.d.d()) && (!b(paramgS1, paramgS2)))
    {
      a(0);
      return false;
    }
    if (paramgS2.k)
    {
      d(paramgS2);
      com.google.android.gms.b.d.a(this.d.f, this);
      com.google.android.gms.b.d.a(this.d.f, this);
      if (!this.d.d())
        break label207;
      if (paramgS2.b != null)
      {
        if (paramgS2.j != null)
          this.f.a(this.d.i, paramgS2);
        if (!paramgS2.a())
          break label183;
        this.f.a(this.d.i, paramgS2).a(paramgS2.b);
      }
    }
    while (true)
    {
      return true;
      if (this.d.e())
      {
        au localau = aD.ad;
        if (!((Boolean)P.n().a(localau)).booleanValue())
          break;
      }
      a(paramgS2, false);
      break;
      label183: paramgS2.b.l().a(new o(this, paramgS2));
      continue;
      label207: if ((this.d.C == null) || (paramgS2.j == null))
        continue;
      this.f.a(this.d.i, paramgS2, this.d.C);
    }
  }

  public final void f()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }

  public final void onGlobalLayout()
  {
    d(this.d.j);
  }

  public final void onScrollChanged()
  {
    d(this.d.j);
  }

  protected final boolean q()
  {
    int j = 1;
    P.e();
    if (!hu.a(this.d.c.getPackageManager(), this.d.c.getPackageName(), "android.permission.INTERNET"))
    {
      x.a().a(this.d.f, this.d.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      j = 0;
    }
    P.e();
    if (!hu.a(this.d.c))
    {
      x.a().a(this.d.f, this.d.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      j = 0;
    }
    if ((j == 0) && (this.d.f != null))
      this.d.f.setVisibility(0);
    return j;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.n
 * JD-Core Version:    0.6.0
 */