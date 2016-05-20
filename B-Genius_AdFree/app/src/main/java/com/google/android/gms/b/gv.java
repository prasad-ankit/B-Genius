package com.google.android.gms.b;

import android.content.Context;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

final class gv
  implements Runnable
{
  gv(Context paramContext, AdRequestInfoParcel paramAdRequestInfoParcel, gB paramgB, aR paramaR, aN paramaN, String paramString, as paramas)
  {
  }

  public final void run()
  {
    is localis = P.f().a(this.a, new AdSizeParcel(), false, false, null, this.b.k);
    if (P.h().l())
      localis.clearCache(true);
    localis.a().setWillNotDraw(true);
    this.c.a = localis;
    this.d.a(this.e, new String[] { "rwc" });
    aN localaN = this.d.a();
    iv localiv = gq.a(this.f, this.d, localaN);
    it localit = localis.l();
    localit.a("/invalidRequest", this.c.c);
    localit.a("/loadAdURL", this.c.d);
    localit.a("/log", bI.h);
    localit.a(localiv);
    hc.a("Loading the JS library.");
    localis.loadUrl(this.g.a());
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gv
 * JD-Core Version:    0.6.0
 */