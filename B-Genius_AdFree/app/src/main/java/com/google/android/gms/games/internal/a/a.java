package com.google.android.gms.games.internal.a;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.m;
import com.google.android.gms.games.c.f;
import com.google.android.gms.games.internal.j;
import com.google.android.gms.games.internal.q;

public final class a
  implements f
{
  public final Intent a(g paramg, String paramString)
  {
    return com.google.android.gms.games.c.a(paramg).a(paramString, -1, -1);
  }

  public final m a(g paramg, String paramString, int paramInt1, int paramInt2)
  {
    return paramg.a(new b(this, paramg, paramString, 2, 0));
  }

  public final void a(g paramg, String paramString, long paramLong)
  {
    com.google.android.gms.games.internal.c localc = com.google.android.gms.games.c.a(paramg, false);
    if (localc != null);
    try
    {
      ((q)localc.o()).a(null, paramString, paramLong, null);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      j.a("LeaderboardsImpl", "service died");
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.a.a
 * JD-Core Version:    0.6.0
 */