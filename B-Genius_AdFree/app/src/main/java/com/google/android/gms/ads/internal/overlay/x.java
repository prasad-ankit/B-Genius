package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.j;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.ads.internal.k;
import com.google.android.gms.b.aN;
import com.google.android.gms.b.aR;
import com.google.android.gms.b.is;
import java.util.HashMap;

public final class x extends FrameLayout
  implements u
{
  private final is a;
  private final FrameLayout b;
  private final F c;
  private v d;
  private boolean e;
  private boolean f;
  private TextView g;
  private long h;
  private long i;
  private String j;
  private String k;

  public x(Context paramContext, is paramis, int paramInt, aR paramaR, aN paramaN)
  {
    super(paramContext);
    this.a = paramis;
    this.b = new FrameLayout(paramContext);
    addView(this.b, new FrameLayout.LayoutParams(-1, -1));
    j.a(paramis.h());
    this.d = paramis.h().b.a(paramContext, paramis, paramaR, paramaN);
    if (this.d != null)
      this.b.addView(this.d, new FrameLayout.LayoutParams(-1, -1, 17));
    this.g = new TextView(paramContext);
    this.g.setBackgroundColor(-16777216);
    n();
    this.c = new F(this);
    this.c.b();
    if (this.d != null)
      this.d.a(this);
    if (this.d == null)
      a("AdVideoUnderlay Error", "Allocating player failed.");
  }

  public static void a(is paramis)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", "no_video_view");
    paramis.a("onVideoEvent", localHashMap);
  }

  private void a(String paramString, String[] paramArrayOfString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event", paramString);
    int m = paramArrayOfString.length;
    int n = 0;
    Object localObject = null;
    if (n < m)
    {
      String str = paramArrayOfString[n];
      if (localObject == null);
      while (true)
      {
        n++;
        localObject = str;
        break;
        localHashMap.put(localObject, str);
        str = null;
      }
    }
    this.a.a("onVideoEvent", localHashMap);
  }

  private void n()
  {
    if (!o())
    {
      this.b.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      this.b.bringChildToFront(this.g);
    }
  }

  private boolean o()
  {
    return this.g.getParent() != null;
  }

  private void p()
  {
    if (this.a.f() == null);
    do
      return;
    while ((!this.e) || (this.f));
    this.a.f().getWindow().clearFlags(128);
    this.e = false;
  }

  public final void a()
  {
    if (this.d == null);
    do
      return;
    while (this.i != 0L);
    float f1 = this.d.e() / 1000.0F;
    int m = this.d.i();
    int n = this.d.j();
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "duration";
    arrayOfString[1] = String.valueOf(f1);
    arrayOfString[2] = "videoWidth";
    arrayOfString[3] = String.valueOf(m);
    arrayOfString[4] = "videoHeight";
    arrayOfString[5] = String.valueOf(n);
    a("canplaythrough", arrayOfString);
  }

  public final void a(float paramFloat)
  {
    if (this.d == null)
      return;
    this.d.a(paramFloat);
  }

  public final void a(int paramInt)
  {
    if (this.d == null)
      return;
    this.d.a(paramInt);
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0))
      return;
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(paramInt3 + 2, paramInt4 + 2);
    localLayoutParams.setMargins(paramInt1 - 1, paramInt2 - 1, 0, 0);
    this.b.setLayoutParams(localLayoutParams);
    requestLayout();
  }

  public final void a(MotionEvent paramMotionEvent)
  {
    if (this.d == null)
      return;
    this.d.dispatchTouchEvent(paramMotionEvent);
  }

  public final void a(String paramString)
  {
    this.j = paramString;
  }

  public final void a(String paramString1, String paramString2)
  {
    a("error", new String[] { "what", paramString1, "extra", paramString2 });
  }

  public final void b()
  {
    if ((this.a.f() != null) && (!this.e))
      if ((0x80 & this.a.f().getWindow().getAttributes().flags) == 0)
        break label82;
    label82: for (boolean bool = true; ; bool = false)
    {
      this.f = bool;
      if (!this.f)
      {
        this.a.f().getWindow().addFlags(128);
        this.e = true;
      }
      return;
    }
  }

  public final void b(String paramString)
  {
    this.k = paramString;
  }

  public final void c()
  {
    a("pause", new String[0]);
    p();
  }

  public final void d()
  {
    a("ended", new String[0]);
    p();
  }

  public final void e()
  {
    n();
    this.i = this.h;
  }

  public final void f()
  {
    if (this.d == null)
      return;
    if (!TextUtils.isEmpty(this.k))
    {
      this.d.a(this.k);
      return;
    }
    a("no_src", new String[0]);
  }

  public final void g()
  {
    if (this.d == null)
      return;
    this.d.d();
  }

  public final void h()
  {
    if (this.d == null)
      return;
    this.d.c();
  }

  public final void i()
  {
    if (this.d == null)
      return;
    this.d.g();
  }

  public final void j()
  {
    if (this.d == null)
      return;
    this.d.h();
  }

  public final void k()
  {
    if (this.d == null)
      return;
    TextView localTextView = new TextView(this.d.getContext());
    localTextView.setText("AdMob - " + this.d.a());
    localTextView.setTextColor(-65536);
    localTextView.setBackgroundColor(-256);
    this.b.addView(localTextView, new FrameLayout.LayoutParams(-2, -2, 17));
    this.b.bringChildToFront(localTextView);
  }

  public final void l()
  {
    this.c.a();
    if (this.d != null)
      this.d.b();
    p();
  }

  final void m()
  {
    if (this.d == null);
    long l;
    do
    {
      return;
      l = this.d.f();
    }
    while ((this.h == l) || (l <= 0L));
    if (o())
      this.b.removeView(this.g);
    float f1 = (float)l / 1000.0F;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "time";
    arrayOfString[1] = String.valueOf(f1);
    a("timeupdate", arrayOfString);
    this.h = l;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.x
 * JD-Core Version:    0.6.0
 */