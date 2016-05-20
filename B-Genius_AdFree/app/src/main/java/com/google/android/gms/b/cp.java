package com.google.android.gms.b;

import com.google.android.gms.ads.internal.P;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class cp
  implements Iterable
{
  private final List a = new LinkedList();

  private static cn c(is paramis)
  {
    Iterator localIterator = P.t().iterator();
    while (localIterator.hasNext())
    {
      cn localcn = (cn)localIterator.next();
      if (localcn.a == paramis)
        return localcn;
    }
    return null;
  }

  public final void a(cn paramcn)
  {
    this.a.add(paramcn);
  }

  public final boolean a(is paramis)
  {
    cn localcn = c(paramis);
    if (localcn != null)
    {
      localcn.b.b();
      return true;
    }
    return false;
  }

  public final void b(cn paramcn)
  {
    this.a.remove(paramcn);
  }

  public final boolean b(is paramis)
  {
    return c(paramis) != null;
  }

  public final Iterator iterator()
  {
    return this.a.iterator();
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.cp
 * JD-Core Version:    0.6.0
 */