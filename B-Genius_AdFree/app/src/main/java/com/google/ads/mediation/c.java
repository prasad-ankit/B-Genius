package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.b.e;
import com.google.android.gms.ads.b.f;
import com.google.android.gms.ads.mediation.k;

final class c extends k
{
  private final f a;

  public c(f paramf)
  {
    this.a = paramf;
    a(paramf.b().toString());
    a(paramf.c());
    b(paramf.d().toString());
    a(paramf.e());
    c(paramf.f().toString());
    a(paramf.g().doubleValue());
    d(paramf.h().toString());
    e(paramf.i().toString());
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
 * Qualified Name:     com.google.ads.mediation.c
 * JD-Core Version:    0.6.0
 */