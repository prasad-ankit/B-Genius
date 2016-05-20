package com.google.android.gms.ads.internal;

import com.google.android.gms.b.aB;
import com.google.android.gms.b.aD;
import com.google.android.gms.b.au;
import com.google.android.gms.b.hc;

public final class l
{
  private m a;
  private boolean b;
  private boolean c;

  public l()
  {
    au localau = aD.e;
    this.c = ((Boolean)P.n().a(localau)).booleanValue();
  }

  public l(boolean paramBoolean)
  {
    this.c = false;
  }

  public final void a()
  {
    this.b = true;
  }

  public final void a(m paramm)
  {
    this.a = paramm;
  }

  public final void a(String paramString)
  {
    hc.a("Action was blocked because no click was detected.");
    if (this.a != null)
      this.a.a(paramString);
  }

  public final boolean b()
  {
    return (!this.c) || (this.b);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.l
 * JD-Core Version:    0.6.0
 */