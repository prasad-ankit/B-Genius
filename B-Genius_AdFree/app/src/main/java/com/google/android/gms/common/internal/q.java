package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.l;

public final class q extends j
{
  public q(i parami, int paramInt)
  {
    super(parami, paramInt, null);
  }

  protected final void a(ConnectionResult paramConnectionResult)
  {
    i.b(this.a).a(paramConnectionResult);
    this.a.a(paramConnectionResult);
  }

  protected final boolean a()
  {
    i.b(this.a).a(ConnectionResult.a);
    return true;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.q
 * JD-Core Version:    0.6.0
 */