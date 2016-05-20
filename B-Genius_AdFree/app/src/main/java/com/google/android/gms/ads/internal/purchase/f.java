package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.fq;
import com.google.android.gms.b.fx;
import com.google.android.gms.b.hc;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hx;

public final class f extends fx
  implements ServiceConnection
{
  private final Activity a;
  private i b;
  private fq c;
  private b d;
  private g e;
  private m f;
  private n g;
  private String h = null;

  public f(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = i.a(this.a.getApplicationContext());
  }

  private void a(String paramString, boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    if (this.f != null)
      this.f.a(paramString, paramBoolean, paramInt, paramIntent, this.e);
  }

  public final void a()
  {
    GInAppPurchaseManagerInfoParcel localGInAppPurchaseManagerInfoParcel = GInAppPurchaseManagerInfoParcel.a(this.a.getIntent());
    this.f = localGInAppPurchaseManagerInfoParcel.e;
    this.g = localGInAppPurchaseManagerInfoParcel.b;
    this.c = localGInAppPurchaseManagerInfoParcel.c;
    this.d = new b(this.a.getApplicationContext());
    if (this.a.getResources().getConfiguration().orientation == 2)
      this.a.setRequestedOrientation(P.g().a());
    while (true)
    {
      Intent localIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
      localIntent.setPackage("com.android.vending");
      this.a.bindService(localIntent, this, 1);
      return;
      this.a.setRequestedOrientation(P.g().b());
    }
  }

  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001);
    try
    {
      P.o();
      int i = k.a(paramIntent);
      if (paramInt2 == -1)
      {
        P.o();
        if (i == 0)
        {
          boolean bool1 = this.g.a(this.h, paramIntent);
          bool2 = false;
          if (!bool1);
        }
      }
      for (boolean bool2 = true; ; bool2 = false)
      {
        this.c.b(i);
        this.a.finish();
        a(this.c.a(), bool2, paramInt2, paramIntent);
        return;
        this.b.a(this.e);
      }
    }
    catch (RemoteException localRemoteException)
    {
      hc.d("Fail to process purchase result.");
      this.a.finish();
      return;
    }
    finally
    {
      this.h = null;
    }
    throw localObject;
  }

  public final void b()
  {
    this.a.unbindService(this);
    this.d.a = null;
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.d.a(paramIBinder);
    try
    {
      P.e();
      this.h = hu.b();
      Bundle localBundle = this.d.a(this.a.getPackageName(), this.c.a(), this.h);
      PendingIntent localPendingIntent = (PendingIntent)localBundle.getParcelable("BUY_INTENT");
      if (localPendingIntent == null)
      {
        P.o();
        int i = k.a(localBundle);
        this.c.b(i);
        a(this.c.a(), false, i, null);
        this.a.finish();
        return;
      }
      this.e = new g(this.c.a(), this.h);
      this.b.b(this.e);
      this.a.startIntentSenderForResult(localPendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
      return;
    }
    catch (RemoteException localRemoteException)
    {
      hc.c("Error when connecting in-app billing service", localRemoteException);
      this.a.finish();
      return;
    }
    catch (IntentSender.SendIntentException localSendIntentException)
    {
      label192: break label192;
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    hc.c("In-app billing service disconnected.");
    this.d.a = null;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.purchase.f
 * JD-Core Version:    0.6.0
 */