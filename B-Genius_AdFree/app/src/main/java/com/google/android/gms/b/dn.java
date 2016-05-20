package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.x;
import com.google.android.gms.ads.internal.l;
import com.google.android.gms.ads.internal.overlay.C;
import com.google.android.gms.ads.internal.overlay.t;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

public final class dn
  implements dh
{
  private final is a;

  public dn(Context paramContext, VersionInfoParcel paramVersionInfoParcel, y paramy)
  {
    this.a = P.f().a(paramContext, new AdSizeParcel(), false, false, paramy, paramVersionInfoParcel);
    this.a.a().setWillNotDraw(true);
  }

  private static void a(Runnable paramRunnable)
  {
    x.a();
    if (com.google.android.gms.ads.internal.util.client.a.b())
    {
      paramRunnable.run();
      return;
    }
    hu.a.post(paramRunnable);
  }

  public final void a()
  {
    this.a.destroy();
  }

  public final void a(com.google.android.gms.ads.internal.client.a parama, t paramt, bG parambG, C paramC, boolean paramBoolean, cc paramcc, ce paramce, fa paramfa)
  {
    this.a.l().a(parama, paramt, parambG, paramC, false, null, null, new l(false), null);
  }

  public final void a(di paramdi)
  {
    this.a.l().a(new dt(this, paramdi));
  }

  public final void a(String paramString)
  {
    a(new dq(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] { paramString })));
  }

  public final void a(String paramString, bU parambU)
  {
    this.a.l().a(paramString, parambU);
  }

  public final void a(String paramString1, String paramString2)
  {
    a(new dp(this, paramString1, paramString2));
  }

  public final void a(String paramString, JSONObject paramJSONObject)
  {
    a(new do(this, paramString, paramJSONObject));
  }

  public final dS b()
  {
    return new dS(this);
  }

  public final void b(String paramString)
  {
    a(new ds(this, paramString));
  }

  public final void b(String paramString, bU parambU)
  {
    this.a.l().b(paramString, parambU);
  }

  public final void b(String paramString, JSONObject paramJSONObject)
  {
    this.a.b(paramString, paramJSONObject);
  }

  public final void c(String paramString)
  {
    a(new dr(this, paramString));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dn
 * JD-Core Version:    0.6.0
 */