package com.google.android.gms.ads.internal.request;

import java.lang.ref.WeakReference;

public final class s extends z
{
  private final WeakReference a;

  public s(j paramj)
  {
    this.a = new WeakReference(paramj);
  }

  public final void a(AdResponseParcel paramAdResponseParcel)
  {
    j localj = (j)this.a.get();
    if (localj != null)
      localj.a(paramAdResponseParcel);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.request.s
 * JD-Core Version:    0.6.0
 */