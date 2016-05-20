package com.google.android.gms.ads.b;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public abstract class e extends FrameLayout
{
  private final FrameLayout a;

  public final void a(a parama)
  {
    try
    {
      parama.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      android.support.v4.a.a.b("Unable to call setNativeAd on delegate", localRemoteException);
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    super.bringChildToFront(this.a);
  }

  public void bringChildToFront(View paramView)
  {
    super.bringChildToFront(paramView);
    if (this.a != paramView)
      super.bringChildToFront(this.a);
  }

  public void removeAllViews()
  {
    super.removeAllViews();
    super.addView(this.a);
  }

  public void removeView(View paramView)
  {
    if (this.a == paramView)
      return;
    super.removeView(paramView);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.b.e
 * JD-Core Version:    0.6.0
 */