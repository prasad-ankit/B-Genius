package com.google.android.gms.b;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class iq
{
  private final WeakReference a;

  public iq(View paramView)
  {
    this.a = new WeakReference(paramView);
  }

  private ViewTreeObserver c()
  {
    View localView = (View)this.a.get();
    ViewTreeObserver localViewTreeObserver;
    if (localView == null)
      localViewTreeObserver = null;
    do
    {
      return localViewTreeObserver;
      localViewTreeObserver = localView.getViewTreeObserver();
    }
    while ((localViewTreeObserver != null) && (localViewTreeObserver.isAlive()));
    return null;
  }

  public final void a()
  {
    ViewTreeObserver localViewTreeObserver = c();
    if (localViewTreeObserver != null)
      a(localViewTreeObserver);
  }

  protected abstract void a(ViewTreeObserver paramViewTreeObserver);

  public final void b()
  {
    ViewTreeObserver localViewTreeObserver = c();
    if (localViewTreeObserver != null)
      b(localViewTreeObserver);
  }

  protected abstract void b(ViewTreeObserver paramViewTreeObserver);
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.iq
 * JD-Core Version:    0.6.0
 */