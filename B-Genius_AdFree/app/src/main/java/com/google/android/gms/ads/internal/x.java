package com.google.android.gms.ads.internal;

import android.graphics.Bitmap;
import android.os.Handler;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.b.gS;
import com.google.android.gms.b.ha;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.is;

final class x extends ha
{
  private final Bitmap b;
  private final String c;

  public x(v paramv, Bitmap paramBitmap, String paramString)
  {
    this.b = paramBitmap;
    this.c = paramString;
  }

  public final void a()
  {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if (this.a.d.F)
    {
      P.e();
      bool1 = hu.a(this.a.d.c, this.b, this.c);
      bool2 = this.a.d.F;
      bool3 = this.a.B();
      if (!bool1)
        break label220;
    }
    label220: for (String str = this.c; ; str = null)
    {
      InterstitialAdParameterParcel localInterstitialAdParameterParcel = new InterstitialAdParameterParcel(bool2, bool3, str, v.a(this.a), v.b(this.a));
      int i = this.a.d.j.b.q();
      if (i == -1)
        i = this.a.d.j.g;
      AdOverlayInfoParcel localAdOverlayInfoParcel = new AdOverlayInfoParcel(this.a, this.a, this.a, this.a.d.j.b, i, this.a.d.e, this.a.d.j.y, localInterstitialAdParameterParcel);
      hu.a.post(new y(this, localAdOverlayInfoParcel));
      return;
      bool1 = false;
      break;
    }
  }

  public final void b()
  {
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.x
 * JD-Core Version:    0.6.0
 */