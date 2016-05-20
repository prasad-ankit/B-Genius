package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.k;
import com.google.android.gms.common.api.l;

public final class o
  implements l
{
  public o(i parami)
  {
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.b())
      this.a.a(null, i.e(this.a));
    do
      return;
    while (i.f(this.a) == null);
    i.f(this.a).a(paramConnectionResult);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.o
 * JD-Core Version:    0.6.0
 */