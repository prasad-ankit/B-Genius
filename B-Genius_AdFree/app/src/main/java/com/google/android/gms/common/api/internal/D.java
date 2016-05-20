package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class D extends L
{
  private WeakReference a;

  D(y paramy)
  {
    this.a = new WeakReference(paramy);
  }

  public final void a()
  {
    y localy = (y)this.a.get();
    if (localy == null)
      return;
    y.b(localy);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.D
 * JD-Core Version:    0.6.0
 */