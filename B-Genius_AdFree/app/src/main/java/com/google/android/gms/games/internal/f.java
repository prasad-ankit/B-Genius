package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.c.a;
import com.google.android.gms.games.c.b;
import com.google.android.gms.games.c.d;
import com.google.android.gms.games.c.g;

final class f extends e
  implements g
{
  private final d a;

  f(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    b localb = new b(paramDataHolder);
    try
    {
      if (localb.b() > 0);
      for (this.a = ((d)localb.b(0).c()); ; this.a = null)
        return;
    }
    finally
    {
      localb.a();
    }
    throw localObject;
  }

  public final a c()
  {
    return this.a;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.f
 * JD-Core Version:    0.6.0
 */