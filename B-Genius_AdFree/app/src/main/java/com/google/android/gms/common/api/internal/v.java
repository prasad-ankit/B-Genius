package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.b.kg;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.api.k;
import java.util.concurrent.locks.Lock;

final class v
  implements j, k
{
  private v(n paramn)
  {
  }

  public final void a(int paramInt)
  {
  }

  public final void a(Bundle paramBundle)
  {
    n.f(this.a).a(new t(this.a));
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    n.c(this.a).lock();
    try
    {
      if (n.b(this.a, paramConnectionResult))
      {
        n.i(this.a);
        n.j(this.a);
      }
      while (true)
      {
        return;
        n.a(this.a, paramConnectionResult);
      }
    }
    finally
    {
      n.c(this.a).unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.v
 * JD-Core Version:    0.6.0
 */