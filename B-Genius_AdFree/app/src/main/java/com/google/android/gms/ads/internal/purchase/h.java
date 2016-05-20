package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.fD;
import com.google.android.gms.b.hc;

public final class h extends fD
  implements ServiceConnection
{
  private boolean a = false;
  private Context b;
  private int c;
  private Intent d;
  private g e;
  private String f;
  private b g;

  public h(Context paramContext, String paramString, boolean paramBoolean, int paramInt, Intent paramIntent, g paramg)
  {
    this.f = paramString;
    this.c = paramInt;
    this.d = paramIntent;
    this.a = paramBoolean;
    this.b = paramContext;
    this.e = paramg;
  }

  public final boolean a()
  {
    return this.a;
  }

  public final String b()
  {
    return this.f;
  }

  public final Intent c()
  {
    return this.d;
  }

  public final int d()
  {
    return this.c;
  }

  public final void e()
  {
    P.o();
    int i = k.a(this.d);
    if ((this.c != -1) || (i != 0))
      return;
    this.g = new b(this.b);
    Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
    localIntent.setPackage("com.android.vending");
    com.google.android.gms.common.stats.b.a().a(this.b, localIntent, this, 1);
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    hc.c("In-app billing service connected.");
    this.g.a(paramIBinder);
    P.o();
    String str1 = k.b(this.d);
    P.o();
    String str2 = k.b(str1);
    if (str2 == null)
      return;
    if (this.g.a(this.b.getPackageName(), str2) == 0)
      i.a(this.b).a(this.e);
    com.google.android.gms.common.stats.b.a().a(this.b, this);
    this.g.a = null;
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    hc.c("In-app billing service disconnected.");
    this.g.a = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.h
 * JD-Core Version:    0.6.0
 */