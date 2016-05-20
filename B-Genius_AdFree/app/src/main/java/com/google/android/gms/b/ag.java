package com.google.android.gms.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.v4.app.j;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.P;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag extends Thread
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = false;
  private final Object d;
  private final af e;
  private final ae f;
  private final gn g;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final int l;

  public ag(af paramaf, ae paramae, gn paramgn)
  {
    this.e = paramaf;
    this.f = paramae;
    this.g = paramgn;
    this.d = new Object();
    au localau1 = aD.y;
    this.i = ((Integer)P.n().a(localau1)).intValue();
    au localau2 = aD.z;
    this.j = ((Integer)P.n().a(localau2)).intValue();
    au localau3 = aD.A;
    this.k = ((Integer)P.n().a(localau3)).intValue();
    au localau4 = aD.B;
    this.l = ((Integer)P.n().a(localau4)).intValue();
    au localau5 = aD.C;
    this.h = ((Integer)P.n().a(localau5)).intValue();
    setName("ContentFetchTask");
  }

  private ak a(View paramView, ad paramad)
  {
    int m = 0;
    if (paramView == null)
      return new ak(this, 0, 0);
    boolean bool = paramView.getGlobalVisibleRect(new Rect());
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        paramad.b(localCharSequence.toString(), bool);
        return new ak(this, 1, 0);
      }
      return new ak(this, 0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof is)))
    {
      paramad.f();
      WebView localWebView = (WebView)paramView;
      if (!j.g());
      for (int i2 = 0; i2 != 0; i2 = 1)
      {
        return new ak(this, 0, 1);
        paramad.f();
        localWebView.post(new ai(this, paramad, localWebView, bool));
      }
      return new ak(this, 0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int n = 0;
      for (int i1 = 0; i1 < localViewGroup.getChildCount(); i1++)
      {
        ak localak = a(localViewGroup.getChildAt(i1), paramad);
        n += localak.a;
        m += localak.b;
      }
      return new ak(this, n, m);
    }
    return new ak(this, 0, 0);
  }

  private boolean e()
  {
    while (true)
    {
      int m;
      int n;
      try
      {
        Context localContext = this.e.b();
        if (localContext == null)
          return false;
        ActivityManager localActivityManager = (ActivityManager)localContext.getSystemService("activity");
        KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
        if ((localActivityManager != null) && (localKeyguardManager != null))
        {
          List localList = localActivityManager.getRunningAppProcesses();
          if (localList == null)
            return false;
          Iterator localIterator = localList.iterator();
          if (!localIterator.hasNext())
            continue;
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (Process.myPid() != localRunningAppProcessInfo.pid)
            continue;
          if (localRunningAppProcessInfo.importance != 100)
            break label178;
          m = 1;
          if ((m == 0) || (localKeyguardManager.inKeyguardRestrictedInputMode()))
            continue;
          PowerManager localPowerManager = (PowerManager)localContext.getSystemService("power");
          if (localPowerManager != null)
            continue;
          n = 0;
          break label171;
          boolean bool = localPowerManager.isScreenOn();
          n = bool;
          break label171;
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
      return false;
      label171: if (n != 0)
      {
        return true;
        label178: m = 0;
      }
    }
  }

  public final void a()
  {
    synchronized (this.d)
    {
      if (this.a)
      {
        hc.a("Content hash thread already started, quiting...");
        return;
      }
      this.a = true;
      start();
      return;
    }
  }

  final void a(View paramView)
  {
    try
    {
      ad localad = new ad(this.i, this.j, this.k, this.l);
      ak localak = a(paramView, localad);
      localad.g();
      if ((localak.a == 0) && (localak.b == 0))
        return;
      if (((localak.b != 0) || (localad.i() != 0)) && ((localak.b != 0) || (!this.f.a(localad))))
      {
        this.f.c(localad);
        return;
      }
    }
    catch (Exception localException)
    {
      hc.b("Exception in fetchContentOnUIThread", localException);
      this.g.a(localException, true);
    }
  }

  final void a(ad paramad, WebView paramWebView, String paramString, boolean paramBoolean)
  {
    paramad.e();
    try
    {
      String str;
      if (!TextUtils.isEmpty(paramString))
      {
        str = new JSONObject(paramString).optString("text");
        if (TextUtils.isEmpty(paramWebView.getTitle()))
          break label88;
        paramad.a(paramWebView.getTitle() + "\n" + str, paramBoolean);
      }
      while (paramad.a())
      {
        this.f.b(paramad);
        return;
        label88: paramad.a(str, paramBoolean);
      }
    }
    catch (JSONException localJSONException)
    {
      hc.a("Json string may be malformed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      hc.a("Failed to get webview content.", localThrowable);
      this.g.a(localThrowable, true);
    }
  }

  public final ad b()
  {
    return this.f.a();
  }

  public final void c()
  {
    synchronized (this.d)
    {
      this.b = false;
      this.d.notifyAll();
      hc.a("ContentFetchThread: wakeup");
      return;
    }
  }

  public final boolean d()
  {
    return this.b;
  }

  public final void run()
  {
    Activity localActivity;
    try
    {
      while (true)
      {
        if (!e())
          break label177;
        localActivity = this.e.a();
        if (localActivity != null)
          break;
        hc.a("ContentFetchThread: no activity");
      }
    }
    catch (Throwable localThrowable)
    {
      hc.b("Error in ContentFetchTask", localThrowable);
      this.g.a(localThrowable, true);
    }
    while (true)
    {
      View localView1;
      synchronized (this.d)
      {
        boolean bool = this.b;
        if (!bool)
          continue;
        try
        {
          hc.a("ContentFetchTask: waiting");
          this.d.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
        }
        continue;
        if (localActivity == null)
          continue;
        Window localWindow = localActivity.getWindow();
        localView1 = null;
        if (localWindow != null)
        {
          View localView2 = localActivity.getWindow().getDecorView();
          localView1 = null;
          if (localView2 != null)
          {
            localView1 = localActivity.getWindow().getDecorView().findViewById(16908290);
            break label244;
            Thread.sleep(1000 * this.h);
            continue;
            localView1.post(new ah(this, localView1));
            continue;
            label177: hc.a("ContentFetchTask: sleeping");
            synchronized (this.d)
            {
              this.b = true;
              hc.a("ContentFetchThread: paused, mPause = " + this.b);
            }
          }
        }
      }
      label244: if (localView1 == null)
        continue;
      if (localView1 != null)
        continue;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ag
 * JD-Core Version:    0.6.0
 */