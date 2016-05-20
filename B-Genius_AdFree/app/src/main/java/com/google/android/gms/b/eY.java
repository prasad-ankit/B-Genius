package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import java.util.Map;

public final class eY extends eZ
  implements bU
{
  private final is a;
  private final Context b;
  private final WindowManager c;
  private final ar d;
  private DisplayMetrics e;
  private float f;
  private int g = -1;
  private int h = -1;
  private int i;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;

  public eY(is paramis, Context paramContext, ar paramar)
  {
    super(paramis);
    this.a = paramis;
    this.b = paramContext;
    this.d = paramar;
    this.c = ((WindowManager)paramContext.getSystemService("window"));
  }

  public final void a(int paramInt1, int paramInt2)
  {
    if ((this.b instanceof Activity));
    for (int n = P.e().c((Activity)this.b)[0]; ; n = 0)
    {
      b(paramInt1, paramInt2 - n, this.l, this.m);
      this.a.l().a(paramInt1, paramInt2);
      return;
    }
  }

  public final void a(is paramis, Map paramMap)
  {
    this.e = new DisplayMetrics();
    Display localDisplay = this.c.getDefaultDisplay();
    localDisplay.getMetrics(this.e);
    this.f = this.e.density;
    this.i = localDisplay.getRotation();
    x.a();
    this.g = a.b(this.e, this.e.widthPixels);
    x.a();
    this.h = a.b(this.e, this.e.heightPixels);
    Activity localActivity = this.a.f();
    if ((localActivity == null) || (localActivity.getWindow() == null))
    {
      this.j = this.g;
      this.k = this.h;
      if (!this.a.k().e)
        break label396;
      this.l = this.g;
    }
    for (this.m = this.h; ; this.m = x.a().b(this.b, this.a.getMeasuredHeight()))
    {
      a(this.g, this.h, this.j, this.k, this.f, this.i);
      eW localeW = new eW(new eX().b(this.d.a()).a(this.d.b()).c(this.d.d()).d(this.d.c()).e(true), 0);
      this.a.b("onDeviceFeaturesReceived", localeW.a());
      int[] arrayOfInt1 = new int[2];
      this.a.getLocationOnScreen(arrayOfInt1);
      a(x.a().b(this.b, arrayOfInt1[0]), x.a().b(this.b, arrayOfInt1[1]));
      if (hc.a(2))
        hc.c("Dispatching Ready Event.");
      b(this.a.o().b);
      return;
      int[] arrayOfInt2 = P.e().a(localActivity);
      x.a();
      this.j = a.b(this.e, arrayOfInt2[0]);
      x.a();
      this.k = a.b(this.e, arrayOfInt2[1]);
      break;
      label396: this.a.measure(0, 0);
      this.l = x.a().b(this.b, this.a.getMeasuredWidth());
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eY
 * JD-Core Version:    0.6.0
 */