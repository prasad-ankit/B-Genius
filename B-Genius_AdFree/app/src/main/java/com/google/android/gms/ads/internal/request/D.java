package com.google.android.gms.ads.internal.request;

import com.google.android.gms.b.dI;
import com.google.android.gms.b.gT;

final class D
  implements Runnable
{
  D(C paramC, gT paramgT)
  {
  }

  public final void run()
  {
    C.a(this.b).a(this.a);
    if (C.b(this.b) != null)
    {
      C.b(this.b).a();
      C.a(this.b, null);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.D
 * JD-Core Version:    0.6.0
 */