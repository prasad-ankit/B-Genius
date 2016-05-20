package com.google.android.gms.b;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.P;
import java.lang.ref.WeakReference;

final class io extends iq
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private final WeakReference a;

  public io(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    super(paramView);
    this.a = new WeakReference(paramOnGlobalLayoutListener);
  }

  protected final void a(ViewTreeObserver paramViewTreeObserver)
  {
    paramViewTreeObserver.addOnGlobalLayoutListener(this);
  }

  protected final void b(ViewTreeObserver paramViewTreeObserver)
  {
    P.g().a(paramViewTreeObserver, this);
  }

  public final void onGlobalLayout()
  {
    ViewTreeObserver.OnGlobalLayoutListener localOnGlobalLayoutListener = (ViewTreeObserver.OnGlobalLayoutListener)this.a.get();
    if (localOnGlobalLayoutListener != null)
    {
      localOnGlobalLayoutListener.onGlobalLayout();
      return;
    }
    b();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.io
 * JD-Core Version:    0.6.0
 */