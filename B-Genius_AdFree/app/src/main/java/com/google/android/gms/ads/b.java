package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.a.a;
import com.google.android.gms.ads.internal.client.E;
import com.google.android.gms.ads.internal.client.s;

public class b
{
  private final s a;
  private final Context b;
  private final E c;

  b(Context paramContext, E paramE)
  {
    this(paramContext, paramE, s.a());
  }

  private b(Context paramContext, E paramE, s params)
  {
    this.b = paramContext;
    this.c = paramE;
    this.a = params;
  }

  public final void a(d paramd)
  {
    com.google.android.gms.ads.internal.client.b localb = paramd.a();
    try
    {
      this.c.a(s.a(this.b, localb));
      return;
    }
    catch (RemoteException localRemoteException)
    {
      a.b("Failed to load ad.", localRemoteException);
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.b
 * JD-Core Version:    0.6.0
 */