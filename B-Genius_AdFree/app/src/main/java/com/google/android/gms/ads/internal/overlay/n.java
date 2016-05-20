package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.b.hH;

final class n extends RelativeLayout
{
  private hH a;

  public n(Context paramContext, String paramString)
  {
    super(paramContext);
    this.a = new hH(paramContext, paramString);
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent);
    return false;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.n
 * JD-Core Version:    0.6.0
 */