package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.P;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.hx;

final class p extends ha
{
  private p(k paramk)
  {
  }

  public final void a()
  {
    P.e();
    Bitmap localBitmap = hu.b(k.a(this.a), this.a.a.q.d);
    if (localBitmap != null)
    {
      Drawable localDrawable = P.g().a(k.a(this.a), localBitmap, this.a.a.q.e, this.a.a.q.f);
      hu.a.post(new q(this, localDrawable));
    }
  }

  public final void b()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.p
 * JD-Core Version:    0.6.0
 */