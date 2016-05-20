package com.google.android.gms.ads.internal.request;

final class f
  implements Runnable
{
  f(e parame)
  {
  }

  public final void run()
  {
    synchronized (e.a(this.a))
    {
      if (this.a.a == null)
        return;
      this.a.b();
      e.a(this.a, 2, "Timed out waiting for ad response.");
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.f
 * JD-Core Version:    0.6.0
 */