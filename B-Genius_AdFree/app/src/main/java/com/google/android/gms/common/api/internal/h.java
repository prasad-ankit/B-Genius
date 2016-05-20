package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class h
  implements N
{
  h(g paramg)
  {
  }

  public final void a(int paramInt, boolean paramBoolean)
  {
    g.a(this.a).lock();
    try
    {
      if ((g.c(this.a)) || (g.d(this.a) == null) || (!g.d(this.a).b()))
      {
        g.a(this.a, false);
        g.a(this.a, paramInt, paramBoolean);
        return;
      }
      g.a(this.a, true);
      g.e(this.a).a(paramInt);
      return;
    }
    finally
    {
      g.a(this.a).unlock();
    }
    throw localObject;
  }

  public final void a(Bundle paramBundle)
  {
    g.a(this.a).lock();
    try
    {
      g.a(this.a, paramBundle);
      g.a(this.a, ConnectionResult.a);
      g.b(this.a);
      return;
    }
    finally
    {
      g.a(this.a).unlock();
    }
    throw localObject;
  }

  public final void a(ConnectionResult paramConnectionResult)
  {
    g.a(this.a).lock();
    try
    {
      g.a(this.a, paramConnectionResult);
      g.b(this.a);
      return;
    }
    finally
    {
      g.a(this.a).unlock();
    }
    throw localObject;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.h
 * JD-Core Version:    0.6.0
 */