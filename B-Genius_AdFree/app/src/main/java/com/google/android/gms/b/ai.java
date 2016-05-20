package com.google.android.gms.b;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

final class ai
  implements Runnable
{
  private ValueCallback e = new aj(this);

  ai(ag paramag, ad paramad, WebView paramWebView, boolean paramBoolean)
  {
  }

  public final void run()
  {
    if (this.b.getSettings().getJavaScriptEnabled());
    try
    {
      this.b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.e);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.e.onReceiveValue("");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ai
 * JD-Core Version:    0.6.0
 */