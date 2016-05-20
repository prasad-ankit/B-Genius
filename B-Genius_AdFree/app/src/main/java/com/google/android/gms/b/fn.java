package com.google.android.gms.b;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class fn
  implements fk
{
  final Set a = Collections.synchronizedSet(new HashSet());
  private final Context b;

  public fn(Context paramContext)
  {
    this.b = paramContext;
  }

  public final WebView a()
  {
    WebView localWebView = new WebView(this.b);
    localWebView.getSettings().setJavaScriptEnabled(true);
    return localWebView;
  }

  public final void a(String paramString1, String paramString2)
  {
    hc.a("Fetching assets for the given html");
    hu.a.post(new fo(this, paramString1, paramString2));
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fn
 * JD-Core Version:    0.6.0
 */