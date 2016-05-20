package com.google.android.gms.b;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class eh
  implements Runnable
{
  eh(ef paramef, ih paramih)
  {
  }

  public final void run()
  {
    Iterator localIterator = ef.e(this.b).keySet().iterator();
    while (localIterator.hasNext())
    {
      ih localih = (ih)localIterator.next();
      if (localih == this.a)
        continue;
      ((dZ)ef.e(this.b).get(localih)).a();
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.eh
 * JD-Core Version:    0.6.0
 */