package com.google.android.gms.ads.internal.request;

import android.os.Handler;
import com.google.android.gms.b.hu;
import com.google.android.gms.b.ij;

final class g
  implements Runnable
{
  g(e parame, ij paramij)
  {
  }

  public final void run()
  {
    synchronized (e.a(this.b))
    {
      this.b.a = this.b.a(e.b(this.b).j, this.a);
      if (this.b.a == null)
      {
        e.a(this.b, 0, "Could not start the ad request service.");
        hu.a.removeCallbacks(e.c(this.b));
      }
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.g
 * JD-Core Version:    0.6.0
 */