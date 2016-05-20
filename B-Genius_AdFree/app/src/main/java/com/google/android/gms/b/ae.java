package com.google.android.gms.b;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae
{
  private final Object a = new Object();
  private int b;
  private List c = new LinkedList();

  public final ad a()
  {
    Object localObject4;
    for (Object localObject1 = null; ; localObject1 = localObject4)
    {
      synchronized (this.a)
      {
        if (this.c.size() == 0)
        {
          hc.a("Queue empty");
          return null;
        }
        if (this.c.size() >= 2)
        {
          i = -2147483648;
          Iterator localIterator = this.c.iterator();
          if (localIterator.hasNext())
          {
            ad localad1 = (ad)localIterator.next();
            int j = localad1.h();
            if (j <= i)
              break label150;
            localObject4 = localad1;
            k = j;
            break label160;
          }
          this.c.remove(localObject1);
          return localObject1;
        }
      }
      ad localad2 = (ad)this.c.get(0);
      localad2.d();
      monitorexit;
      return localad2;
      label150: int k = i;
      localObject4 = localObject1;
      label160: int i = k;
    }
  }

  public final boolean a(ad paramad)
  {
    synchronized (this.a)
    {
      return this.c.contains(paramad);
    }
  }

  public final boolean b(ad paramad)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        ad localad = (ad)localIterator.next();
        if ((paramad == localad) || (!localad.b().equals(paramad.b())))
          continue;
        localIterator.remove();
        return true;
      }
      return false;
    }
  }

  public final void c(ad paramad)
  {
    synchronized (this.a)
    {
      if (this.c.size() >= 10)
      {
        hc.a("Queue is full, current size = " + this.c.size());
        this.c.remove(0);
      }
      int i = this.b;
      this.b = (i + 1);
      paramad.a(i);
      this.c.add(paramad);
      return;
    }
  }
}

/* Location:           C:\Users\KSHITIZ GUPTA\Downloads\apktool-install-windws\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.b.ae
 * JD-Core Version:    0.6.0
 */