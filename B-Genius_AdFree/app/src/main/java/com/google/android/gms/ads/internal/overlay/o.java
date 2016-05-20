package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.b.is;

public final class o
{
  public final int a;
  public final ViewGroup.LayoutParams b;
  public final ViewGroup c;
  public final Context d;

  public o(is paramis)
  {
    this.b = paramis.getLayoutParams();
    ViewParent localViewParent = paramis.getParent();
    this.d = paramis.g();
    if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
    {
      this.c = ((ViewGroup)localViewParent);
      this.a = this.c.indexOfChild(paramis.b());
      this.c.removeView(paramis.b());
      paramis.a(true);
      return;
    }
    throw new m("Could not get the parent of the WebView for an overlay.");
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.o
 * JD-Core Version:    0.6.0
 */