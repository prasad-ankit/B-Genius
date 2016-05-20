package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import java.lang.ref.WeakReference;

final class w extends u
  implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
{
  private WeakReference c;
  private boolean d = false;

  protected w(c paramc, int paramInt)
  {
    super(paramc, paramInt, 0);
  }

  private void b(View paramView)
  {
    int i = -1;
    if (android.support.v4.app.j.e())
    {
      Display localDisplay = paramView.getDisplay();
      if (localDisplay != null)
        i = localDisplay.getDisplayId();
    }
    IBinder localIBinder = paramView.getWindowToken();
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int j = paramView.getWidth();
    int k = paramView.getHeight();
    this.b.b = i;
    this.b.a = localIBinder;
    this.b.c = arrayOfInt[0];
    this.b.d = arrayOfInt[1];
    this.b.e = (j + arrayOfInt[0]);
    this.b.f = (k + arrayOfInt[1]);
    if (this.d)
    {
      a();
      this.d = false;
    }
  }

  public final void a()
  {
    if (this.b.a != null)
    {
      super.a();
      return;
    }
    if (this.c != null);
    for (boolean bool = true; ; bool = false)
    {
      this.d = bool;
      return;
    }
  }

  protected final void a(int paramInt)
  {
    this.b = new v(paramInt, null, 0);
  }

  public final void a(View paramView)
  {
    this.a.c();
    ViewTreeObserver localViewTreeObserver;
    if (this.c != null)
    {
      View localView2 = (View)this.c.get();
      Context localContext2 = this.a.k();
      if ((localView2 == null) && ((localContext2 instanceof Activity)))
        localView2 = ((Activity)localContext2).getWindow().getDecorView();
      if (localView2 != null)
      {
        localView2.removeOnAttachStateChangeListener(this);
        localViewTreeObserver = localView2.getViewTreeObserver();
        if (!android.support.v4.app.j.d())
          break label184;
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
      }
    }
    while (true)
    {
      this.c = null;
      Context localContext1 = this.a.k();
      if ((paramView == null) && ((localContext1 instanceof Activity)))
      {
        View localView1 = ((Activity)localContext1).findViewById(16908290);
        if (localView1 == null)
          localView1 = ((Activity)localContext1).getWindow().getDecorView();
        j.a("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view. Note that this may not work as expected in multi-screen environments");
        paramView = localView1;
      }
      if (paramView == null)
        break;
      b(paramView);
      this.c = new WeakReference(paramView);
      paramView.addOnAttachStateChangeListener(this);
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
      return;
      label184: localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
    j.b("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
  }

  public final void onGlobalLayout()
  {
    if (this.c == null);
    View localView;
    do
    {
      return;
      localView = (View)this.c.get();
    }
    while (localView == null);
    b(localView);
  }

  public final void onViewAttachedToWindow(View paramView)
  {
    b(paramView);
  }

  public final void onViewDetachedFromWindow(View paramView)
  {
    this.a.c();
    paramView.removeOnAttachStateChangeListener(this);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.w
 * JD-Core Version:    0.6.0
 */