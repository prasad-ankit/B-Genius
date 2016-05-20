package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class h
  implements ViewTreeObserver.OnPreDrawListener
{
  h(f paramf, View paramView, j paramj, int paramInt, Object paramObject)
  {
  }

  public final boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    f.a(this.e, this.b, this.c, this.d);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.h
 * JD-Core Version:    0.6.0
 */