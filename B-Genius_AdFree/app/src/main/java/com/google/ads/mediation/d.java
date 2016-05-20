package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.ads.b.h;
import com.google.android.gms.ads.mediation.l;

final class d extends l
{
  private final h a;

  public d(h paramh)
  {
    this.a = paramh;
    a(paramh.b().toString());
    a(paramh.c());
    b(paramh.d().toString());
    a(paramh.e());
    c(paramh.f().toString());
    d(paramh.g().toString());
    a(true);
    b(true);
  }

  public final void a(View paramView)
  {
    if ((paramView instanceof e))
      ((e)paramView).a(this.a);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.ads.mediation.d
 * JD-Core Version:    0.6.0
 */