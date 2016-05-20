package com.google.android.gms.b;

import android.webkit.WebView;
import java.util.Set;

final class fo
  implements Runnable
{
  fo(fn paramfn, String paramString1, String paramString2)
  {
  }

  public final void run()
  {
    WebView localWebView = this.a.a();
    localWebView.setWebViewClient(new fp(this, localWebView));
    this.a.a.add(localWebView);
    localWebView.loadDataWithBaseURL(this.b, this.c, "text/html", "UTF-8", null);
    hc.a("Fetching assets finished.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fo
 * JD-Core Version:    0.6.0
 */