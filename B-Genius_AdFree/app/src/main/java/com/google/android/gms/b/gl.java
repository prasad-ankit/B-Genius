package com.google.android.gms.b;

import android.support.v4.b.k;
import java.util.concurrent.Future;

public final class gl
  implements gh
{
  private final boolean a;

  public gl(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  private static k a(k paramk)
  {
    k localk = new k();
    for (int i = 0; i < paramk.size(); i++)
      localk.put(paramk.b(i), ((Future)paramk.c(i)).get());
    return localk;
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.gl
 * JD-Core Version:    0.6.0
 */