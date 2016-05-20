package android.support.v4.app;

import android.support.v4.b.a;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;

final class g
  implements ViewTreeObserver.OnPreDrawListener
{
  g(f paramf, View paramView, Object paramObject, ArrayList paramArrayList, j paramj, boolean paramBoolean, Fragment paramFragment1, Fragment paramFragment2)
  {
  }

  public final boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    if (this.b != null)
    {
      d.a(this.b, this.c);
      this.c.clear();
      a locala = f.a(this.h, this.d, this.e, this.f);
      d.a(this.b, this.d.d, locala, this.c);
      f.a(this.h, locala, this.d);
      f.a(this.h, this.d, this.f, this.g, this.e, locala);
    }
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     android.support.v4.app.g
 * JD-Core Version:    0.6.0
 */