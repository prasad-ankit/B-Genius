package com.google.android.gms.b;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

public final class fW extends fV
{
  private Object d = new Object();
  private PopupWindow e;
  private boolean f = false;

  fW(Context paramContext, gT paramgT, is paramis, fU paramfU)
  {
    super(paramContext, paramgT, paramis, paramfU);
  }

  private void f()
  {
    synchronized (this.d)
    {
      this.f = true;
      if (((this.a instanceof Activity)) && (((Activity)this.a).isDestroyed()))
        this.e = null;
      if (this.e != null)
      {
        if (this.e.isShowing())
          this.e.dismiss();
        this.e = null;
      }
      return;
    }
  }

  protected final void a(int paramInt)
  {
    f();
    super.a(paramInt);
  }

  protected final void c()
  {
    if ((this.a instanceof Activity));
    for (Window localWindow = ((Activity)this.a).getWindow(); ; localWindow = null)
    {
      if ((localWindow == null) || (localWindow.getDecorView() == null));
      do
        return;
      while (((Activity)this.a).isDestroyed());
      FrameLayout localFrameLayout = new FrameLayout(this.a);
      localFrameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localFrameLayout.addView(this.b.b(), -1, -1);
      synchronized (this.d)
      {
        if (this.f)
          return;
      }
      this.e = new PopupWindow(localFrameLayout, 1, 1, false);
      this.e.setOutsideTouchable(true);
      this.e.setClippingEnabled(false);
      hc.a("Displaying the 1x1 popup off the screen.");
      try
      {
        this.e.showAtLocation(localWindow.getDecorView(), 0, -1, -1);
        monitorexit;
        return;
      }
      catch (Exception localException)
      {
        while (true)
          this.e = null;
      }
    }
  }

  public final void d()
  {
    f();
    super.d();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.fW
 * JD-Core Version:    0.6.0
 */