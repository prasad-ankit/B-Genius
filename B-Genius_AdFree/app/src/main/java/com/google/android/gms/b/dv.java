package com.google.android.gms.b;

import android.os.Handler;

final class dv
  implements Runnable
{
  dv(du paramdu, dM paramdM)
  {
  }

  public final void run()
  {
    dn localdn = new dn(du.a(this.b), du.b(this.b), null);
    localdn.a(new dw(this, localdn));
    localdn.a("/jsLoaded", new dz(this, localdn));
    ia localia = new ia();
    dA localdA = new dA(this, localdn, localia);
    localia.a(localdA);
    localdn.a("/requestReload", localdA);
    if (du.f(this.b).endsWith(".js"))
      localdn.a(du.f(this.b));
    while (true)
    {
      hu.a.postDelayed(new dB(this, localdn), dF.a);
      return;
      if (du.f(this.b).startsWith("<html>"))
      {
        localdn.c(du.f(this.b));
        continue;
      }
      localdn.b(du.f(this.b));
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.dv
 * JD-Core Version:    0.6.0
 */