package com.google.android.gms.b;

import android.content.Context;
import android.support.v4.app.j;
import android.support.v4.app.w;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.x;

public final class ir
{
  private final is a;
  private final Context b;
  private final ViewGroup c;
  private x d;

  public ir(Context paramContext, ViewGroup paramViewGroup, is paramis)
  {
    this(paramContext, paramViewGroup, paramis, null);
  }

  private ir(Context paramContext, ViewGroup paramViewGroup, is paramis, x paramx)
  {
    this.b = paramContext;
    this.c = paramViewGroup;
    this.a = paramis;
    this.d = null;
  }

  public final x a()
  {
    w.b("getAdVideoUnderlay must be called from the UI thread.");
    return this.d;
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    w.b("The underlay may only be modified from the UI thread.");
    if (this.d != null)
      this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.d != null)
      return;
    j.a(this.a.x().a(), this.a.w(), new String[] { "vpr" });
    aN localaN = j.a(this.a.x().a());
    this.d = new x(this.b, this.a, paramInt5, this.a.x().a(), localaN);
    this.c.addView(this.d, 0, new ViewGroup.LayoutParams(-1, -1));
    this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.l().a(false);
  }

  public final void b()
  {
    w.b("onPause must be called from the UI thread.");
    if (this.d != null)
      this.d.g();
  }

  public final void c()
  {
    w.b("onDestroy must be called from the UI thread.");
    if (this.d != null)
      this.d.l();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ir
 * JD-Core Version:    0.6.0
 */