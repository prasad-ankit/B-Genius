package com.google.android.gms.b;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Set;

final class fp extends WebViewClient
{
  fp(fo paramfo, WebView paramWebView)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    hc.a("Loading assets have finished");
    this.b.a.a.remove(this.a);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    hc.d("Loading assets have failed.");
    this.b.a.a.remove(this.a);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fp
 * JD-Core Version:    0.6.0
 */