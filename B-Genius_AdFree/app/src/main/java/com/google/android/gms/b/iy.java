package com.google.android.gms.b;

import java.util.Map;
import java.util.Set;

final class iy
  implements bU
{
  private iy(it paramit)
  {
  }

  public final void a(is paramis, Map paramMap)
  {
    if (paramMap.keySet().contains("start"))
      it.a(this.a);
    do
    {
      return;
      if (!paramMap.keySet().contains("stop"))
        continue;
      it.b(this.a);
      return;
    }
    while (!paramMap.keySet().contains("cancel"));
    it.c(this.a);
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.iy
 * JD-Core Version:    0.6.0
 */