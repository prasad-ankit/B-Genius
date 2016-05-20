package com.google.android.gms.b;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.P;

public final class ib
{
  private Activity a;
  private boolean b;
  private boolean c;
  private boolean d;
  private ViewTreeObserver.OnGlobalLayoutListener e;
  private ViewTreeObserver.OnScrollChangedListener f;

  public ib(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.a = paramActivity;
    this.e = paramOnGlobalLayoutListener;
    this.f = paramOnScrollChangedListener;
  }

  private void e()
  {
    if (this.a == null);
    do
      return;
    while (this.b);
    if (this.e != null)
    {
      P.e();
      hu.a(this.a, this.e);
    }
    if (this.f != null)
    {
      P.e();
      hu.a(this.a, this.f);
    }
    this.b = true;
  }

  private void f()
  {
    if (this.a == null);
    do
      return;
    while (!this.b);
    if (this.e != null)
      P.g().a(this.a, this.e);
    if (this.f != null)
    {
      P.e();
      hu.b(this.a, this.f);
    }
    this.b = false;
  }

  public final void a()
  {
    this.d = true;
    if (this.c)
      e();
  }

  public final void a(Activity paramActivity)
  {
    this.a = paramActivity;
  }

  public final void b()
  {
    this.d = false;
    f();
  }

  public final void c()
  {
    this.c = true;
    if (this.d)
      e();
  }

  public final void d()
  {
    this.c = false;
    f();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ib
 * JD-Core Version:    0.6.0
 */