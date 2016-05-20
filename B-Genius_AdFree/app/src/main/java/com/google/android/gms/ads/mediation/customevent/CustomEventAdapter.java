package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.mediation.a;
import com.google.android.gms.ads.mediation.e;
import com.google.android.gms.ads.mediation.g;
import com.google.android.gms.ads.mediation.h;
import com.google.android.gms.ads.mediation.i;
import com.google.android.gms.ads.mediation.m;
import com.google.android.gms.b.hc;

public final class CustomEventAdapter
  implements com.google.android.gms.ads.mediation.d, com.google.android.gms.ads.mediation.f, h
{
  private c a;
  private c b;
  private c c;

  private static Object a(String paramString)
  {
    try
    {
      Object localObject = Class.forName(paramString).newInstance();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      hc.d("Could not instantiate custom event adapter: " + paramString + ". " + localThrowable.getMessage());
    }
    return null;
  }

  public final void a()
  {
  }

  public final void a(Context paramContext, e parame, Bundle paramBundle1, com.google.android.gms.ads.f paramf, a parama, Bundle paramBundle2)
  {
    this.a = ((c)a(paramBundle1.getString("class_name")));
    if (this.a == null)
    {
      parame.a(0);
      return;
    }
    if (paramBundle2 != null)
      paramBundle2.getBundle(paramBundle1.getString("class_name"));
    new d(this, parame);
    paramBundle1.getString("parameter");
  }

  public final void a(Context paramContext, g paramg, Bundle paramBundle1, a parama, Bundle paramBundle2)
  {
    this.b = ((c)a(paramBundle1.getString("class_name")));
    if (this.b == null)
    {
      paramg.b(0);
      return;
    }
    if (paramBundle2 != null)
      paramBundle2.getBundle(paramBundle1.getString("class_name"));
    new b(this, this, paramg);
    paramBundle1.getString("parameter");
  }

  public final void a(Context paramContext, i parami, Bundle paramBundle1, m paramm, Bundle paramBundle2)
  {
    this.c = ((c)a(paramBundle1.getString("class_name")));
    if (this.c == null)
    {
      parami.c(0);
      return;
    }
    if (paramBundle2 != null)
      paramBundle2.getBundle(paramBundle1.getString("class_name"));
    new f(this, parami);
    paramBundle1.getString("parameter");
  }

  public final void b()
  {
  }

  public final void c()
  {
  }

  public final View d()
  {
    return null;
  }

  public final void e()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.mediation.customevent.CustomEventAdapter
 * JD-Core Version:    0.6.0
 */